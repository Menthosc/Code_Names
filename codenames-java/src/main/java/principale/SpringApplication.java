package principale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.AppConfig;


public class SpringApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBeanFactory().createBean(MainCodeNames.class).run(args);
		myContext.close();

		
	}

}
