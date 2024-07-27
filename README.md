# Registro de Adopción de Mascotas API REST

## Descripción

Este proyecto es una API REST para la gestión de adopciones de mascotas en protectoras de animales.  
Proporciona funcionalidades para crear, leer, actualizar y eliminar información sobre mascotas, así como realizar búsquedas y paginaciones.

## Tecnologías Utilizadas

- **Spring Boot:** Framework para el desarrollo de aplicaciones Java basadas en Spring.
- **Spring Data JPA:** Para la persistencia de datos.
- **H2 Database:** Base de datos en memoria para desarrollo y pruebas.
- **Swagger:** Para la documentación y pruebas de la API.
- **Lombok:** Para la generación automática de métodos como getters y setters.
- **Maven:** Para la gestión de dependencias y construcción del proyecto.

## Instalación y Ejecución

1. **Clonar el repositorio:**

   ```bash
    git clone https://github.com/espemb/apirest_adopcion_mascotas.git

2. **Acceder a la API:**  
URL base: http://localhost:8080/api  
Swagger UI: http://localhost:8080/swagger-ui.html

## Configuración
La aplicación utiliza una base de datos en memoria H2 para el almacenamiento de datos.  
Para visualizar la base de datos, se puede acceder a la consola H2 en http://localhost:8080/h2-console con las siguientes credenciales:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: sa

## Uso
Endpoints principales
- GET /api/mascota/{id}: Obtener una mascota por ID.
- POST /api/mascota: Crear una nueva mascota.
- PUT /api/mascota: Actualizar una mascota existente.
- GET /api/mascota: Obtener todas las mascotas.
- GET /api/mascota/recents/{pag}/{qtty}: Obtener mascotas recientes con paginación.
- GET /api/mascota/pag/{pag}: Obtener mascotas por página con paginación.
- DELETE /api/mascota/{id}: Eliminar una mascota por ID.
- GET /api/mascota/nombre/{nombre}: Buscar una mascota por nombre.
