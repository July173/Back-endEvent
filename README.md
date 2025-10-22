# Gestión Events Backend

Backend Spring Boot para la gestión de eventos, artistas, localidades, ventas y seguridad básica.

## Requisitos

- Java 17+
- Maven 3.8+
- MySQL 8.x (o el motor que definas en `application.properties`)

## Dependencias principales

Revisar `pom.xml` para la versión exacta. Usualmente:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mysql-connector-j (o driver JDBC que uses)
- spring-boot-starter-validation (opcional)

## Configuración

Editar `src/main/resources/application.properties`:

```properties
# Puerto del servidor
server.port=8081

# Datasource (ejemplo MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/control_event?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Crear la base de datos vacía antes de ejecutar:

```sql
CREATE DATABASE IF NOT EXISTS control_event CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Opcional: poblar datos base ejecutando `sql.sql` en la raíz del proyecto.

## Ejecución

- Desarrollo:
```bash
mvn spring-boot:run
```
- Producción (JAR):
```bash
mvn clean package -DskipTests
java -jar target/gestionEventsBackend-*.jar
```

## Endpoints principales

Base URL: `http://localhost:8081/api/v1`

- Eventos (`/event/`)
  - `POST /event/create` crea evento con tickets y artistas (body: `EventCreateDTO`).
  - `GET /event/` filtros opcionales: `filter`, `municipioId`, `departmentId`, `startDate`, `endDate`.
  - `GET /event/{id}` obtiene evento por id.
  - `GET /event/{id}/detail` detalle con `tickets` y `artists`.
  - `PUT /event/{id}` actualiza usando `EventCreateDTO`.
  - `PATCH /event/{id}/status?status=0|1` cambia estado.

- Artistas (`/artist/`)
  - `POST /artist/` crea.
  - `GET /artist/` lista.
  - `GET /artist/{id}` por id.
  - `PUT /artist/{id}` actualiza.
  - `PATCH /artist/{id}/status?status=0|1` borrado lógico / reactivación.

- Localidades de evento (`/locatedevent/`)
  - `POST /locatedevent/` crea.
  - `GET /locatedevent/` lista.
  - `GET /locatedevent/{id}` por id.
  - `PUT /locatedevent/{id}` actualiza.
  - `DELETE /locatedevent/{id}` borrado permanente.

- Usuario (`/user/`)
  - `POST /user/` crea usuario (incluye vínculo a `person`).
  - `GET /user/` lista usuarios.
  - `GET /user/{id}` trae usuario con `person` y `role`.
  - `PUT /user/{id}` actualiza `user` y `person` juntos.
  - `PATCH /user/{id}` actualización parcial de `user` y `person`.

- Autenticación (`/auth/`)
  - `POST /auth/login` login (ver payload en `info.txt`).

- Métodos de pago (`/payment-method/`)
  - `POST /payment-method/` crea.
  - `GET /payment-method/` lista.

- Menú por rol (`/rolform/`)
  - `GET /rolform/menu?roleId={id}` devuelve estructura de módulos y forms disponibles.

## Filtros de eventos

- Búsqueda textual (prioritaria): `GET /event/?filter=feria`
- Por municipio: `GET /event/?municipioId=1`
- Por departamento: `GET /event/?departmentId=2`
- Rango de fechas (ISO yyyy-MM-dd): `GET /event/?startDate=2025-11-01&endDate=2025-11-30`
- Sin filtros: retorna todos los eventos.

## Datos de ejemplo

Revisa `info.txt` y `sql.sql` en la raíz para ejemplos de payloads e inserts iniciales.

## Troubleshooting

- Error 500 en `/rolform/menu`: asegúrate de tener datos en `rol_form` y `form_module` y que las tablas coincidan con las entidades (`rolForm`, `formModule`).
- Conexión a DB: valida `spring.datasource.*` y que la DB `control_event` exista.
- Puerto ocupado: cambia `server.port` en `application.properties`.
