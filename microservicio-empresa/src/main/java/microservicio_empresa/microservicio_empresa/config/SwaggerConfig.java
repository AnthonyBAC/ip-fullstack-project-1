package microservicio_empresa.microservicio_empresa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentación Gestión de Flota / API Empresa")
                        .version("1.0")
                        .description(
                                "Documentación del sistema de gestión de flota, específicamente enfocada en la API Empresa, la cual se encarga de gestionar la información de las empresas que nos contactan."));
    }
}
