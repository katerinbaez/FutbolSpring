## 📄 SISTEMA GESTOR DE FUTBOL JPA/JSP
Este proyecto es un sistema de gestión de fútbol desarrollado en Java utilizando Spring Boot, JPA (Java Persistence API) y JSP (Java Server Pages). 
El sistema está diseñado para gestionar entidades como clubes, jugadores, entrenadores, asociaciones y competiciones.

---

## 🛠️ Tecnologías utilizadas:
- Spring Boot: Framework principal para el desarrollo del backend.

- JPA (Java Persistence API): Persistencia de datos con bases de datos relacionales (MySQL, PostgreSQL, etc.).

- JSP (Java Server Pages): Motor de plantillas utilizado para generar las vistas de la aplicación.

- Spring Data JPA: Simplificación del acceso a datos.

- Bootstrap: Framework CSS para una interfaz web responsiva.
---

## ⚽ Funcionalidades:
- CRUD (Crear, Leer, Actualizar, Eliminar) para jugadores, clubes, entrenadores, asociaciones y competiciones.

- Relacionamiento entre entidades (Ej. jugadores asignados a clubes).

- Interfaz web amigable utilizando JSP.

- Persistencia de datos con JPA y relaciones entre entidades (@Entity, @OneToMany, @ManyToOne, etc.).

- Navegación sencilla a través de formularios y vistas dinámicas.

## 🏗️ Estructura del Proyecto:
```
sistema-gestor-futbol/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── futbol/
│   │   │           ├── controller/         # Controladores MVC para vistas JSP
│   │   │           │   ├── ClubController.java
│   │   │           │   ├── JugadorController.java
│   │   │           │   └── ...
│   │   │           ├── model/              # Entidades JPA
│   │   │           │   ├── Club.java
│   │   │           │   ├── Jugador.java
│   │   │           │   ├── Entrenador.java
│   │   │           │   ├── Competicion.java
│   │   │           │   └── Asociacion.java
│   │   │           ├── repository/         # Interfaces de repositorios JPA
│   │   │           │   ├── ClubRepository.java
│   │   │           │   └── ...
│   │   │           ├── config/             # Configuración de Spring Boot, JPA y JSP
│   │   │           │   └── JpaConfig.java
│   │   │           └── SistemaFutbolApplication.java  # Clase principal de Spring Boot
│   │   └── resources/
│   │       ├── application.properties      # Configuración de Spring Boot y base de datos
│   │       ├── static/                     # Archivos estáticos (CSS, JS, imágenes)
│   │       └── templates/                  # Archivos JSP
│   │           ├── index.jsp
│   │           ├── jugadores.jsp
│   │           └── ...
│   └── test/                               # Tests unitarios y de integración
│       └── ...
├── pom.xml / build.gradle                  # Dependencias del proyecto
└── README.md                               # Documentación del proyecto
```
---
## ⚙️ Configuración de la Base de Datos
El sistema utiliza H2 por defecto. Puedes acceder a la consola web para visualizar las tablas y datos en ejecución.
```
spring.datasource.url=jdbc:h2:mem:futbol
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
---

## 🚀 ¿Cómo ejecutar el proyecto?
Pasos claros para ejecutar el proyecto localmente:

1. Clonar el repositorio.

2. Abrirlo en SpringBoot.

3. Configura la base de datos con los datos correctos.

4. Ejecutar los micorservicios.

5. Accede a la aplicacion: http://localhost:8013

   
