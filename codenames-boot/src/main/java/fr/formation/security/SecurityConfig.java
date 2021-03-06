package fr.formation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/api/**").authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest().permitAll() //.hasAnyRole("ADMIN", "USER")
				.and().httpBasic()
				.and().csrf().disable();
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/accueil").permitAll()
				.antMatchers("/inscription").permitAll()
				.antMatchers("/**").hasAnyRole("ADMIN", "USER")
				.and().formLogin().loginPage("/connexion").loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/accueil", true).failureUrl("/connexion?error=true").permitAll().and().logout()
				.logoutUrl("/deconnexion").logoutSuccessUrl("/accueil").permitAll()

				.and().csrf().ignoringAntMatchers("/jeu/**");
	}

	@Autowired
	private AuthService authService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.authService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}