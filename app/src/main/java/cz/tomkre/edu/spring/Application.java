package cz.tomkre.edu.spring;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		var greeting = new Greeting("e", "Good morning");
		var validator = Validation.buildDefaultValidatorFactory().getValidator();
		var violations = validator.validate(greeting).stream()
			.map(ConstraintViolation::getMessage)
			.toList();
		log.info("Violations={}", violations);
	}


}
