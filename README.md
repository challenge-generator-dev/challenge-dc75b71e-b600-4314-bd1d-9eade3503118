# Desarrollo de una API REST para gestión de productos

Debes crear una API REST que gestione productos en una base de datos H2. Cada producto tiene un nombre, precio, stock y categoría. La API debe prohibir precios negativos y nombres duplicados. Además, deberá estar documentada con Swagger para facilitar su uso.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Creación de API REST con persistencia en H2 y documentación con Swagger |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición y persistencia de productos

**Objetivo:** Crear una API que permita registrar productos con validación de reglas de negocio.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Diseña la estructura de datos para representar un producto.
- Implementa la persistencia de productos en la base de datos H2.
- Aplica validaciones para evitar precios negativos y nombres duplicados.

**Entregable:** API REST que permite registrar productos con las validaciones especificadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo representar y validar los atributos de un producto.
- Piensa en cómo manejar los errores de validación en la API.

</details>

### Fase 2: Documentación con Swagger

**Objetivo:** Documentar la API REST utilizando Swagger para facilitar su uso y comprensión.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Integra Swagger en tu proyecto para documentar la API.
- Asegúrate de que la documentación incluya todas las operaciones disponibles y sus parámetros.
- Verifica que la documentación sea clara y completa.

**Entregable:** API REST documentada con Swagger, incluyendo todas las operaciones y parámetros.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa las mejores prácticas para documentar APIs con Swagger.
- Considera cómo hacer que la documentación sea accesible y útil para los usuarios.

</details>

### Fase 3: Pruebas y optimización

**Objetivo:** Realizar pruebas unitarias y de integración para asegurar la calidad del código y optimizar el rendimiento de la API.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribe pruebas unitarias para las validaciones de negocio.
- Realiza pruebas de integración para asegurar que la API funcione correctamente con la base de datos.
- Identifica y soluciona posibles puntos de mejora en el rendimiento de la API.

**Entregable:** API REST con pruebas unitarias y de integración, y rendimiento optimizado.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa las mejores prácticas para escribir pruebas unitarias y de integración.
- Considera cómo medir y mejorar el rendimiento de la API.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un producto en el contexto de esta API y cómo se representa?
- **paraQueSirve**: ¿Para qué sirve la validación de nombres duplicados en la API?
- **comoSeUsa**: ¿Cómo se usa Swagger para documentar una API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir al registrar un producto y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la optimización del rendimiento de la API?

## Criterios de Evaluacion

- API REST que permite registrar productos con validaciones de negocio.
- Documentación completa y clara de la API utilizando Swagger.
- Pruebas unitarias y de integración que aseguran la calidad del código.
- Rendimiento optimizado de la API.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
