package fiap.com.br.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "BoOK Planner", version = "v1", description = "API do sistema de controle de leitura de livros"))
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
