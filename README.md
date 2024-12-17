# 🚀 **Product Service**
> _Microservicio encargado de gestionar precios en función de producto, marca y fecha._

## 📦 **Descripción del Proyecto**

El proyecto `Product Main` es una aplicación multi modulo construida con **Spring Boot** y **Java 17**.

Permite recuperar información de precios aplicables a productos en función de la fecha, identificador del producto y de la marca.

La arquitectura implementada sigue el enfoque **Hexagonal (Ports & Adapters)**.


## 🛠 **¿Qué es la Arquitectura Hexagonal (Ports & Adapters)?**

La **Arquitectura Hexagonal** busca desacoplar la lógica de negocio de las implementaciones externas, como bases de datos, APIs externas o interfaces de usuario.

### 🧩 **Principales Componentes:**

1. **Puertos (Ports):**  
   Interfaces que definen los contratos para interactuar con el core.
    - **Puertos de Entrada (Input Ports):** Interfaces que exponen las operaciones de la lógica de negocio al exterior.
    - **Puertos de Salida (Output Ports):** Interfaces a través de las cuales el core interactúa con componentes externos, como repositorios de datos o servicios externos.

2. **Adaptadores (Adapters):**  
   Implementaciones concretas de los puertos que interactúan con las tecnologías específicas (BD, APIs, UI, etc.).

---

## 🗂 **Estructura del Proyecto**

El proyecto está dividido en **modulos** siguiendo el patrón **Hexagonal**. Cada capa tiene una responsabilidad específica:

### 🌐 **1. Capa de Infraestructura (Adaptadores de Salida)**

Esta capa interactúa con la infraestructura externa, como la base de datos. Aquí se implementan los **puertos de salida** definidos en la aplicación.

📁 **Paquete:** `org.redsf.product.database.repository`

**Responsabilidades:**
- **Persistencia de Datos** con JPA y H2.
- Implementación de los puertos de salida (`RepositoryPort`).
- Mappeo entre entidades de base de datos (`PriceEntity`) y modelos de negocio (`PriceMO`) utilizando **MapStruct**.

**Clases Importantes:**
- `PriceEntity`: Entidad JPA que representa la tabla `PRICE`.
- `PriceJpaRepository`: Repositorio con consultas SQL personalizadas.
- `JpaEntityMapper`: Mapper entre la entidad `PriceEntity` y el modelo de aplicación `PriceMO`.
- `RepositoryPortImpl`: Implementación del puerto `RepositoryPort` que interactúa con la base de datos.

---

### ⚙️ **2. Capa de Aplicación (Core)**

La capa central del proyecto contiene la lógica de negocio (API interna + casos de uso) y define los **puertos (interfaces)** necesarios para la comunicación entre el core y las tecnologías externas.

📁 **Paquetes:** `org.redsf.product.use.cases` + `org.redsf.product.apirest`

**Responsabilidades:**
- **Definir los puertos** (interfaces) que serán implementados por la capa de infraestructura o consumidos por la capa de exposición.
- **Implementar los servicios** que contienen la lógica de negocio.
- **Mapear los modelos** entre diferentes capas.

**Clases Importantes:**
- **Puertos:**
    - `RepositoryPort`: Puerto de salida que define la interfaz para recuperar precios desde una fuente de datos.
    - `PriceService`: Puerto de entrada que define la operación para obtener precios.
- **Servicios:**
    - `PriceServiceImpl`: Implementación del servicio de negocio.
- **Modelos:**
    - `PriceMO`: Modelo de negocio usado en la aplicación.
- **Mappers:**
    - `PriceMapper`: Mapper entre `PriceMO` y `PriceDTO`.

---

#### 📤 **2.1. Capa de Exposición (Adaptadores de Entrada)**

La capa de exposición es la responsable de:
- Recibir peticiones externas (HTTP).
- Convertir las solicitudes en operaciones que puedan ser ejecutadas por la lógica de negocio.
- Devolver las respuestas adecuadas.

📁 **Paquete:** `org.redsf.product.apirest.controller`

**Responsabilidades:**
- Exponer un endpoint REST que interactúa con la lógica de negocio.
- Manejar validaciones y excepciones.

**Clases Importantes:**
- `PricesController`: Controlador REST que expone el endpoint para recuperar precios.

**Endpoint:**
```http
GET /api/prices?publishDate={publishDate}&productId={productId}&brandId={brandId}
```
___
## 🛠 **Tabla de Herramientas**

| **Tecnología**             | **Descripción**                                 |
|----------------------------|-------------------------------------------------|
| **Java 17**                | Lenguaje de programación principal.             |
| **Spring Boot**            | Framework para desarrollo de microservicios.    |
| **Spring Data JPA**        | Abstracción para acceso a la base de datos.     |
| **H2 Database**            | Base de datos en memoria para desarrollo/test.  |
| **MapStruct**              | Mapeo automático de objetos.                    |
| **JUnit 5**                | Framework para pruebas unitarias.               |
| **Mockito**                | Framework para mockear dependencias en pruebas. |
| **Maven**                  | Herramienta de gestión de dependencias.         |
| **JaCoCo**                 | Generación de cobertura de código.              |

---

## 📊 **Cobertura de Código**  

Para generar un reporte de cobertura con **JaCoCo**, ejecuta el siguiente comando:  
```bash
mvn clean verify -Pcoverage
```

Esto generará un reporte en cada modulo:

target/site/jacoco/index.html



