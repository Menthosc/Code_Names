package configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan({ "configuration" })
@PropertySource("classpath:data-source.properties")
public class AppConfig {

}