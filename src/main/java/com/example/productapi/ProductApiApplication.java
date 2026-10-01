package com.example.productapi;


import com.example.productapi.model.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Product API",
        version = "1.0",
        description = "API para gestión de productos con validación de negocio y documentación Swagger"
    ),
    servers = @Server(url = "/", description = "Default Server URL")
)
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }

    @Bean
    public String applicationInfo() {
        System.out.println("Product API iniciada con éxito");
        System.out.println("Base de datos H2 en memoria disponible en: http://localhost:8080/h2-console");
        System.out.println("Documentación Swagger disponible en: http://localhost:8080/swagger-ui.html");
        return "Product API configurada correctamente";
    }
}