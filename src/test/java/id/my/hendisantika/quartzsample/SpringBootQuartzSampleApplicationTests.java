package id.my.hendisantika.quartzsample;

import id.my.hendisantika.quartzsample.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:mysql:9.1.0:///postsDB",
                "spring.datasource.jdbc-url=jdbc:tc:mysql:9.1.0:///postsDB",
                "spring.datasource.driverClassName=org.testcontainers.jdbc.ContainerDatabaseDriver"
        },
        webEnvironment = RANDOM_PORT
)
class SpringBootQuartzSampleApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void contextLoads() {
        assertThat(authorRepository).isNotNull();
        assertThat(authorRepository.count()).isNotNegative();
    }

}
