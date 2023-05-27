# Introducción

Este proyecto es una API REST de backend de la aplicación AwakeSeller. El objetivo principal de este proyecto es proporcionar a los vendedores una aplicación que les ayude a mejorar sus ventas en Etsy. 

## Requisitos

- Java >= 17
- Docker

## Cómo empezar

Todos los comandos deben ejecutarse en una terminal situada en la raíz del proyecto.

### Docker

Necesitaremos arrancar otros servicios de los que depende nuestra aplicación (definidos en el fichero `docker-compose.yml`), 
docker descargará las imágenes correspondientes y levantará los contenedores necesarios:

```shell
docker-compose up -d
```

### Aplicación

Principalmente, durante el desarrollo, arrancaremos la aplicación mediante nuestro IDE favorito, pero habrá ocasiones en las que
necesitemos arrancarla sin el IDE. Para ello podemos usar el wrapper de Maven:

- En Windows

```shell
mvnw spring-boot:run
```

- En Linux/Mac
	
```shell
./mvnw spring-boot:run
```

### Swagger

Url de la definición de nuestra API con Swagger:

[https://localhost:8080/swagger-ui/index.html](https://localhost:8080/swagger-ui/index.html)

### Consideraciones

- Se permite una configuración muy poco segura de CORS y CSRF que habría que mejorar para un proyecto real
- Se ha generado un certificado autofirmado para poder conectar con la API de Etsy ya que sólo permite urls de callback de autenticación que sean https
- Al tener un certificado autofirmado, puede darse que algunos navegadores no permitan la conexión desde el frontend, por lo cual habría que indicarle al navegador que lo permita (entrando en https://localhost:8080 y diciendole al navegador que permita la conexión)
- El modelo de datos se genera automáticamente con JPA

## Anexo

### Documentación de referencia

Algunos enlaces de documentación sobre las tecnologías usadas en este proyecto:

* [Docker](https://docs.docker.com/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [Springdoc](https://springdoc.org/)

### Guías

Algunas guías y tutoriales de implementación:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
