package Qatar.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories(basePackages="Qatar.com")
@SpringBootApplication
public class Coupe2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Coupe2022Application.class, args);
	}

}
