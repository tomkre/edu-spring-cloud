package cz.tomkre.edu.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:postgresql:17.1-alpine://test")
class ApplicationTests {

	@Autowired
	private DeveloperRepository repository;

	@Test
	void shouldHandle() {
		repository.save(Developer.of("tom", "java", 9));
		assertThat(repository.findById("tom").isPresent()).isTrue();
	}

}
