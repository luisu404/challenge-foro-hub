
# ForoHub - Challenge Alura

ForoHub es una **API REST** desarrollada con **Spring Boot** que permite gestionar un foro de discusión.  
Los usuarios pueden crear, consultar, actualizar y eliminar tópicos, siguiendo las buenas prácticas del modelo **REST** y aplicando validaciones, autenticación y persistencia de datos.

Este proyecto fue desarrollado como parte del **Challenge ForoHub del programa Oracle Next Education (ONE) en colaboración con Alura Latam**.

---

# 🌟 Características

- 📝 Crear un nuevo tópico
- 📖 Listar todos los tópicos
- 🔍 Consultar un tópico específico
- ✏️ Actualizar un tópico
- 🗑️ Eliminar un tópico
- ✔️ Validaciones de reglas de negocio
- 🔒 Autenticación y autorización de usuarios
- Crear, Editar, Listar y Eliminar (logico) usuario
- - Crear, Editar, Listar y Eliminar cursos
---

# 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **Spring Security**
- **Hibernate**
- **Lombok**
- **MySQL**
- **Maven**

---

# 📋 Requisitos

Antes de ejecutar el proyecto debes tener instalado:

- **Java 21**
- **Maven 3.x**
- **MySQL**

---

# 🚀 Instalación

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/luisu404/challenge-foro-hub.git
```
Navegar a la carpeta
```bash
cd Challenge-foro-alura

src/main/resources/application.properties
```xml
### Coloca tus informaciones en el application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

```

📡 Uso de la API

Una vez iniciada la aplicación puedes consumir la API utilizando herramientas como:
- Postman
- Insomnia
- cURL

Los endpoints permiten realizar operaciones CRUD sobre los tópicos del foro.

🧪 Desarrollo

- Durante el desarrollo puedes utilizar Spring Boot DevTools, que permite:
- Recarga automática de la aplicación
- Reinicio rápido del servidor
- Mejora en la experiencia de desarrollo
