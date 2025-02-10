package cz.tomkre.edu.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ConfigurationPropertiesScan
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner run(DeveloperRepository repository) {
		return args -> {
			log.info("app - start");
			repository.save(Developer.of("tom", "java", 9));
			repository.increment("tom");
			log.info("Found developer: '{}'", repository.findById("tom").get());
			log.info("app - end");
		};
	}


}
