# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/example/productapi/controller/ProductControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/example/productapi/ProductApiApplication.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.OpenAPIDefinition pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/model/dto/ProductRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/model/dto/ProductResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/controller/ProductController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/example/productapi/controller/ProductControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/controller/ProductControllerTest.java` — `ProductService.getProductById`: Se invoca `getProductById` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductService.getProductById`: Se invoca `getProductById` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.deleteAll`: Se invoca `deleteAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: Creación de API REST con persistencia en H2 y documentación con Swagger
- Seniority: junior-l2
- Tipo: practical
- Título: Desarrollo de una API REST para gestión de productos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición y persistencia de productos — objetivo: Crear una API que permita registrar productos con validación de reglas de negocio. — entregable (NO resolver): API REST que permite registrar productos con las validaciones especificadas.
- Fase 2: Documentación con Swagger — objetivo: Documentar la API REST utilizando Swagger para facilitar su uso y comprensión. — entregable (NO resolver): API REST documentada con Swagger, incluyendo todas las operaciones y parámetros.
- Fase 3: Pruebas y optimización — objetivo: Realizar pruebas unitarias y de integración para asegurar la calidad del código y optimizar el rendimiento de la API. — entregable (NO resolver): API REST con pruebas unitarias y de integración, y rendimiento optimizado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>product-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>product-api</name>
    <description>API REST para gestión de productos con H2 y Swagger</description>

    <properties>
        <java.version>21</java.version>
        <springdoc-openapi-ui.version>2.6.0</springdoc-openapi-ui.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Base de datos H2 -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Documentación Swagger -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi-ui.version}</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/example/productapi/ProductApiApplication.java ===
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

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración de Spring Boot
spring.application.name=product-api

# Configuración de H2 Database
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

# Configuración de JPA/Hibernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

# Configuración de Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.operationsSorter=alpha
springdoc.swagger-ui.doc-expansion=none

# Configuración de validación
spring.mvc.pathmatch.matching-strategy=ant_path_matcher

# Configuración de logs
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=INFO
logging.level.com.example.productapi=DEBUG

// === ARCHIVO: src/main/java/com/example/productapi/repository/ProductRepository.java ===
package com.example.productapi.repository;

import com.example.productapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para operaciones CRUD sobre la entidad Product.
 * Proporciona métodos para validar nombres duplicados y operaciones básicas de persistencia.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Verifica si existe un producto con el nombre especificado.
     * @param name Nombre del producto a verificar.
     * @return true si existe un producto con ese nombre, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Busca un producto por su nombre.
     * @param name Nombre del producto a buscar.
     * @return Optional que contiene el producto si existe, o vacío si no existe.
     */
    Optional<Product> findByName(String name);
}

// === ARCHIVO: src/main/java/com/example/productapi/model/entity/Product.java ===
package com.example.productapi.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products",
       uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private String category;
}

// === ARCHIVO: src/main/java/com/example/productapi/model/dto/ProductRequest.java ===
package com.example.productapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "DTO para la creación y actualización de productos")
public record ProductRequest(

    @Schema(description = "Nombre del producto", example = "Laptop Gamer", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    String name,

    @Schema(description = "Precio del producto", example = "999.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    BigDecimal price,

    @Schema(description = "Cantidad disponible en stock", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    Integer stock,

    @Schema(description = "Categoría del producto", example = "Electrónicos", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    String category
) {
}

// === ARCHIVO: src/main/java/com/example/productapi/model/dto/ProductResponse.java ===
package com.example.productapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "Respuesta de un producto en la API")
public record ProductResponse(
    @Schema(description = "Identificador único del producto", example = "1")
    Long id,
    
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    String name,
    
    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,
    
    @Schema(description = "Cantidad en stock", example = "25")
    Integer stock,
    
    @Schema(description = "Categoría del producto", example = "Electrónica")
    String category
) {}

// === ARCHIVO: src/main/java/com/example/productapi/controller/ProductController.java ===
package com.example.productapi.controller;

import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Gestión de Productos", description = "API para gestionar productos en el sistema")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en el sistema con validación de reglas de negocio")
    public ResponseEntity<ProductResponse> createProduct(
            @Parameter(description = "Datos del producto a crear")
            @Valid @RequestBody ProductRequest request) {
        ProductResponse created = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", description = "Retorna los datos de un producto específico")
    public ResponseEntity<ProductResponse> getProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {
        ProductResponse product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    @Operation(summary = "Listar todos los productos", description = "Retorna una lista con todos los productos registrados")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Actualiza los datos de un producto existente")
    public ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del producto")
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto del sistema")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock")
    @Operation(summary = "Actualizar stock de un producto", description = "Modifica la cantidad de stock de un producto existente")
    public ResponseEntity<ProductResponse> updateStock(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nueva cantidad en stock", example = "50")
            @RequestParam Integer quantity) {
        ProductResponse updated = productService.updateProductStock(id, quantity);
        return ResponseEntity.ok(updated);
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/service/ProductService.java ===
package com.example.productapi.service;

import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.model.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        validatePriceNotNegative(request.price());
        validateNameNotDuplicated(request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(request.category());

        Product saved = productRepository.save(product);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
        return toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        validatePriceNotNegative(request.price());
        if (!existing.getName().equals(request.name())) {
            validateNameNotDuplicated(request.name());
        }

        existing.setName(request.name());
        existing.setPrice(request.price());
        existing.setStock(request.stock());
        existing.setCategory(request.category());

        Product updated = productRepository.save(existing);
        return toResponse(updated);
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponse updateProductStock(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        if (quantity < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        product.setStock(quantity);
        Product updated = productRepository.save(product);
        return toResponse(updated);
    }

    private void validatePriceNotNegative(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("El precio es obligatorio");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    private void validateNameNotDuplicated(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("Ya existe un producto con el nombre: " + name);
        }
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/exception/ProductAlreadyExistsException.java ===
package com.example.productapi.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    private final String productName;
    private final String category;

    public ProductAlreadyExistsException(String productName) {
        super(String.format("Ya existe un producto con el nombre '%s' en el sistema", productName));
        this.productName = productName;
        this.category = null;
    }

    public ProductAlreadyExistsException(String productName, String category) {
        super(String.format("Ya existe un producto con el nombre '%s' en la categoría '%s'", productName, category));
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getDetailedMessage() {
        if (category != null) {
            return String.format("Producto duplicado: '%s' en categoría '%s'", productName, category);
        }
        return String.format("Producto duplicado: '%s'", productName);
    }

    @Override
    public String toString() {
        return "ProductAlreadyExistsException{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/exception/GlobalExceptionHandler.java ===
package com.example.productapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("error", "Conflicto de datos");
        response.put("message", ex.getMessage());
        response.put("productName", ex.getProductName());
        if (ex.getCategory() != null) {
            response.put("category", ex.getCategory());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(ProductNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Recurso no encontrado");
        response.put("message", ex.getMessage());
        response.put("productId", ex.getProductId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Error de validación");
        response.put("message", "Los datos proporcionados no son válidos");
        response.put("validationErrors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Solicitud inválida");
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> response = new HashMap<>();
        String message = String.format("El parámetro '%s' tiene un valor inválido: '%s'", 
                ex.getName(), ex.getValue());
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Tipo de parámetro incorrecto");
        response.put("message", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Error interno del servidor");
        response.put("message", "Ha ocurrido un error inesperado. Por favor, contacte al administrador.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/exception/ProductNotFoundException.java ===
package com.example.productapi.exception;

public class ProductNotFoundException extends RuntimeException {
    private final Long productId;
    private final String searchCriteria;

    public ProductNotFoundException(Long productId) {
        super(String.format("No se encontró el producto con ID: %d", productId));
        this.productId = productId;
        this.searchCriteria = "id:" + productId;
    }

    public ProductNotFoundException(String productName, boolean byName) {
        super(String.format("No se encontró el producto con nombre: '%s'", productName));
        this.productId = null;
        this.searchCriteria = "name:" + productName;
    }

    public Long getProductId() {
        return productId;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getDetailedMessage() {
        if (productId != null) {
            return String.format("Producto no encontrado - ID: %d", productId);
        }
        return String.format("Producto no encontrado - criterio: %s", searchCriteria);
    }

    @Override
    public String toString() {
        return "ProductNotFoundException{" +
                "productId=" + productId +
                ", searchCriteria='" + searchCriteria + '\'' +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/config/OpenApiConfig.java ===
package com.example.productapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Productos")
                        .version("1.0.0")
                        .description("""
                                API REST para la gestión de productos en el sistema.
                                
                                Esta API permite crear, leer, actualizar y eliminar productos,
                                con validación de reglas de negocio como precios positivos
                                y nombres únicos por categoría.
                                
                                ## Características principales
                                - CRUD completo de productos
                                - Validación de precios no negativos
                                - Prevención de nombres duplicados
                                - Documentación interactiva con Swagger
                                - Persistencia en base de datos H2
                                
                                ## Códigos de respuesta
                                - 200: Operación exitosa
                                - 201: Recurso creado correctamente
                                - 400: Error de validación o solicitud inválida
                                - 404: Recurso no encontrado
                                - 409: Conflicto (producto duplicado)
                                - 500: Error interno del servidor
                                """)
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@empresa.com")
                                .url("https://empresa.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token de autenticación JWT")));
    }
}

// === ARCHIVO: src/test/java/com/example/productapi/controller/ProductControllerTest.java ===
package com.example.productapi.controller;



import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.entity.Product;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    void shouldReturnAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of());

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void shouldReturnProductById() throws Exception {
        ProductResponse response = new ProductResponse(1L, "Test", new BigDecimal("10.00"), 5, "Electronics");
        when(productService.getProductById(1L)).thenReturn(java.util.Optional.of(response));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test"));
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest request = new ProductRequest("New Product", new BigDecimal("25.00"), 10, "Electronics");
        ProductResponse response = new ProductResponse(1L, "New Product", new BigDecimal("25.00"), 10, "Electronics");
        when(productService.createProduct(any(ProductRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("New Product"));
    }

    @Test
    void shouldReturnBadRequestWhenCreatingProductWithNegativePrice() throws Exception {
        ProductRequest request = new ProductRequest("Bad Product", new BigDecimal("-10.00"), 5, "Electronics");

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnConflictWhenCreatingDuplicateProduct() throws Exception {
        ProductRequest request = new ProductRequest("Duplicate", new BigDecimal("15.00"), 3, "Books");
        when(productService.createProduct(any(ProductRequest.class)))
                .thenThrow(new com.example.productapi.exception.ProductAlreadyExistsException("Duplicate"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict());
    }
}

// === ARCHIVO: src/test/java/com/example/productapi/service/ProductServiceTest.java ===
package com.example.productapi.service;

import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.dto.ProductRequest;
import com.example.productapi.model.dto.ProductResponse;
import com.example.productapi.model.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;
    private ProductRequest sampleRequest;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product();
        sampleProduct.setId(1L);
        sampleProduct.setName("Test Product");
        sampleProduct.setPrice(new BigDecimal("29.99"));
        sampleProduct.setStock(10);
        sampleProduct.setCategory("Electronics");

        sampleRequest = new ProductRequest("Test Product", new BigDecimal("29.99"), 10, "Electronics");
    }

    @Test
    void shouldReturnAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(sampleProduct));

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Product", result.get(0).name());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        Optional<ProductResponse> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Product", result.get().name());
    }

    @Test
    void shouldReturnEmptyWhenProductNotFound() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.getProductById(999L);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCreateProductSuccessfully() {
        when(productRepository.existsByName("Test Product")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);

        ProductResponse result = productService.createProduct(sampleRequest);

        assertNotNull(result);
        assertEquals("Test Product", result.name());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionWhenCreatingDuplicateProduct() {
        when(productRepository.existsByName("Test Product")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.createProduct(sampleRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProductWithNegativePrice() {
        ProductRequest invalidRequest = new ProductRequest("Invalid", new BigDecimal("-5.00"), 5, "Books");

        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProduct(invalidRequest);
        });
    }

    @Test
    void shouldUpdateProductStock() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);

        ProductResponse result = productService.updateProductStock(1L, 20);

        assertNotNull(result);
        assertEquals(20, result.stock());
    }

    @Test
    void shouldDeleteProduct() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentProduct() {
        when(productRepository.existsById(999L)).thenReturn(false);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.deleteProduct(999L);
        });
    }
}

// === ARCHIVO: src/test/java/com/example/productapi/repository/ProductRepositoryTest.java ===
package com.example.productapi.repository;

import com.example.productapi.model.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private org.springframework.test.context.TestTransaction testTransaction;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

        sampleProduct = new Product();
        sampleProduct.setName("Test Product");
        sampleProduct.setPrice(new BigDecimal("49.99"));
        sampleProduct.setStock(15);
        sampleProduct.setCategory("Electronics");
        sampleProduct = productRepository.save(sampleProduct);
    }

    @Test
    void shouldSaveProduct() {
        Product newProduct = new Product();
        newProduct.setName("New Product");
        newProduct.setPrice(new BigDecimal("19.99"));
        newProduct.setStock(5);
        newProduct.setCategory("Books");

        Product saved = productRepository.save(newProduct);

        assertNotNull(saved.getId());
        assertEquals("New Product", saved.getName());
        assertEquals(new BigDecimal("19.99"), saved.getPrice());
    }

    @Test
    void shouldFindProductById() {
        Optional<Product> found = productRepository.findById(sampleProduct.getId());

        assertTrue(found.isPresent());
        assertEquals("Test Product", found.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenFindingNonExistentId() {
        Optional<Product> found = productRepository.findById(99999L);

        assertTrue(found.isEmpty());
    }

    @Test
    void shouldFindAllProducts() {
        Product anotherProduct = new Product();
        anotherProduct.setName("Another Product");
        anotherProduct.setPrice(new BigDecimal("9.99"));
        anotherProduct.setStock(20);
        anotherProduct.setCategory("Clothing");
        productRepository.save(anotherProduct);

        var allProducts = productRepository.findAll();

        assertEquals(2, allProducts.size());
    }

    @Test
    void shouldCheckIfProductExistsByName() {
        boolean exists = productRepository.existsByName("Test Product");
        assertTrue(exists);

        boolean notExists = productRepository.existsByName("Non Existent");
        assertFalse(notExists);
    }

    @Test
    void shouldFindProductByName() {
        Optional<Product> found = productRepository.findByName("Test Product");

        assertTrue(found.isPresent());
        assertEquals("Electronics", found.get().getCategory());
    }

    @Test
    void shouldReturnEmptyWhenFindingByNonExistentName() {
        Optional<Product> found = productRepository.findByName("Non Existent Product");

        assertTrue(found.isEmpty());
    }

    @Test
    void shouldDeleteProduct() {
        Long productId = sampleProduct.getId();
        productRepository.deleteById(productId);

        Optional<Product> found = productRepository.findById(productId);
        assertTrue(found.isEmpty());
    }

    @Test
    void shouldUpdateProduct() {
        sampleProduct.setPrice(new BigDecimal("59.99"));
        sampleProduct.setStock(25);
        Product updated = productRepository.save(sampleProduct);

        assertEquals(new BigDecimal("59.99"), updated.getPrice());
        assertEquals(25, updated.getStock());
    }
}

// === ARCHIVO: README.md ===
# Product API - REST API for Product Management

A RESTful API built with Spring Boot 3.4 and Java 21 for managing products with H2 in-memory database and Swagger documentation.

## Overview

This project provides a complete REST API for product management with the following features:
- Create, read, update and delete products
- Validation of business rules (no negative prices, no duplicate names)
- H2 in-memory database for persistence
- Swagger UI for API documentation
- Comprehensive error handling

## Prerequisites

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.8 or higher
- Any modern web browser (for Swagger UI)

## Project Structure

```
product-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/productapi/
│   │   │   ├── ProductApiApplication.java
│   │   │   ├── config/
│   │   │   │   └── OpenApiConfig.java
│   │   │   ├── controller/
│   │   │   │   └── ProductController.java
│   │   │   ├── service/
│   │   │   │   └── ProductService.java
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java
│   │   │   ├── model/
│   │   │   │   ├── entity/
│   │   │   │   │   └── Product.java
│   │   │   │   └── dto/
│   │   │   │       ├── ProductRequest.java
│   │   │   │       └── ProductResponse.java
│   │   │   └── exception/
│   │   │       ├── ProductAlreadyExistsException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/productapi/
│           ├── controller/
│           ├── service/
│           └── repository/
└── pom.xml
```

## Build and Run

### Compile the project

```bash
mvn clean compile
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start on port 8080 by default. You should see output similar to:

```
Started ProductApiApplication in X.XXX seconds
```

### Package as JAR

```bash
mvn clean package
java -jar target/product-api-0.0.1-SNAPSHOT.jar
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/products | Get all products |
| GET | /api/products/{id} | Get product by ID |
| POST | /api/products | Create a new product |
| PUT | /api/products/{id} | Update an existing product |
| DELETE | /api/products/{id} | Delete a product |

### Request Body Examples

#### Create Product (POST /api/products)
```json
{
  "name": "Laptop",
  "price": 1299.99,
  "stock": 50,
  "category": "Electronics"
}
```

#### Update Product (PUT /api/products/{id})
```json
{
  "name": "Gaming Laptop",
  "price": 1499.99,
  "stock": 30,
  "category": "Electronics"
}
```

## Swagger UI

Once the application is running, access the interactive API documentation at:

**URL:** http://localhost:8080/swagger-ui.html

Alternative endpoints:
- OpenAPI JSON: http://localhost:8080/v3/api-docs
- Swagger UI (new): http://localhost:8080/swagger-ui/index.html

Through Swagger UI you can:
- View all available endpoints
- See request and response schemas
- Try out each operation directly from the browser
- View model documentation and constraints

## Validation Rules

The API enforces the following business rules:

- **Product name**: Required, must be unique (no duplicates allowed)
- **Price**: Required, must be positive (greater than 0)
- **Stock**: Required, must be non-negative (0 or greater)
- **Category**: Required

## Error Responses

The API returns appropriate HTTP status codes:

- **200 OK**: Successful GET/PUT operations
- **201 Created**: Successful POST operations
- **204 No Content**: Successful DELETE operations
- **400 Bad Request**: Validation errors (negative price, duplicate name)
- **404 Not Found**: Product not found by ID
- **500 Internal Server Error**: Unexpected server errors

Example error response:
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Product price must be positive"
}
```

## Database Configuration

The application uses H2 in-memory database, which is automatically created on startup. The database is configured in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
```

Data is lost when the application stops. For persistence across restarts, you can switch to file-based H2 or another database.

## Testing

Run unit tests:

```bash
mvn test
```

Run specific test classes:

```bash
mvn test -Dtest=ProductControllerTest
mvn test -Dtest=ProductServiceTest
mvn test -Dtest=ProductRepositoryTest
```

## Technology Stack

- **Framework**: Spring Boot 3.4.0
- **Language**: Java 21
- **Build Tool**: Apache Maven
- **Database**: H2 (in-memory)
- **ORM**: Spring Data JPA with Hibernate
- **Documentation**: SpringDoc OpenAPI 2.6.0
- **Validation**: Jakarta Bean Validation
- **Lombok**: 1.18.34

## Additional Information

- The API follows RESTful conventions
- All endpoints are prefixed with `/api`
- CORS is enabled for all origins
- The application runs on port 8080 by default
- Swagger documentation is available at `/swagger-ui.html`
- OpenAPI 3.0 specification is available at `/v3/api-docs`
```
