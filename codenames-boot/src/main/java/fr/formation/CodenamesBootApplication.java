package fr.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("codenames.model")
public class CodenamesBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodenamesBootApplication.class, args);
	}

}

