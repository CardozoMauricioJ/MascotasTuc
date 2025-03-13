# Tienda de mascotas API REST

## Descripción

Este proyecto es una API REST desarrollada con Spring Boot para gestionar una tienda de mascotas. Permite crear, editar, eliminar y consultar mascotas y adoptantes.

## Tecnologías Utilizadas

* Java 8
* MySQL Community Server
* Spring Boot
* Spring Data JPA
* Swagger
* Maven

## Instrucciones de Ejecución

Instrucciones paso a paso para ejecutar el proyecto en un entorno local.

1.  Clonar el repositorio: `git clone https://github.com/CardozoMauricioJ/MascotasTuc.git`
2.  Navegar al directorio del proyecto: `cd MascotasTuc`
3.  Ejecutar la aplicación con Maven: `mvn spring-boot:run`
4.  Acceder a la documentación de Swagger UI: `http://localhost:8080/swagger-ui.html`

## Endpoints de la API

Lista de los endpoints principales de la API con ejemplos de solicitudes y respuestas.

Ejemplo mascotas:
* **GET tienda/mascotas:** Obtiene la lista de todas las mascotas.
* **GET tienda/mascotas/{idMascota}:** Obtiene una mascota por ID.
* **POST tienda/mascotas:** Para dar de alta una nueva mascota.
* **PUT tienda/mascotas:** Para modificar una mascota existente. (Modificar idMascota por un ID valido. Solo se podrá modificar nombre y edad).
* **DELETE tienda/mascotas/{idMascota}:** Elimina una mascota por ID.

Ejemplo adoptantes:
* **GET tienda/adoptantes:** Obtiene la lista de todos los adoptantes.
* **GET tienda/adoptantes/{idAdoptante}:** Obtiene un adoptante por ID.
* **GET tienda/adopciones:** Obtiene la lista de todos los adopciones.
* **POST tienda/adoptantes:** Para dar de alta un nuevo adoptante.
* **POST tienda/adoptar/{idAdoptante}/{idMascota}:** Para agregar una mascota a un adoptante por ID que corresponda a cada uno.
* **PUT tienda/adoptantes:** Para modificar un adoptante existente. (Modificar idAdoptante por un ID valido. Solo se podrá modificar nombre y dirección).
* **DELETE tienda/adoptantes/{idAdoptante}:** Elimina un adoptante por ID.

## Autor

Desarrollado por [Mauricio Javier Cardozo] - [mau.webapp@gmail.com] - [LinkedIn (https://www.linkedin.com/in/MauricioCardozo1)]