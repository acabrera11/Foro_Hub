# Challenge ONE Alura| Back End | Foro Hub
Desafío a nivel backend donde se crea una API REST usando Spring para que los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. En este desafio vamos a replicar este proceso a nivel de back end y, para eso, crearemos una API REST usando Spring.

## Requerimientos
Nuestra API se centrará específicamente en los tópicos, y debe permitir a los usuarios:
- ✅ Crear un nuevo tópico;
- ✅ Mostrar todos los tópicos creados;
- ✅ Mostrar un tópico específico;
- ✅ Actualizar un tópico;
- ✅ Eliminar un tópico.

Además de estos requermientos se han agregado otras funcionalidades adicionales:

- ✅ Crear un nuevo usuario(autor);
- ✅ Mostrar todos los usuarios creados;
- ✅ Mostrar un usuario específico por id;
- ✅ Actualizar un usuario;
- ✅ Eliminar un usuario de forma lógica.
- ✅ Crear un nuevo curso

En resumen, nuestro objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:

- ✅ API con rutas implementadas siguiendo las mejores prácticas del modelo REST;
- ✅ Validaciones realizadas según las reglas de negocio;
- ✅ Implementación de una base de datos relacional para la persistencia de la información;
- ✅ Servicio de autenticación/autorización para restringir el acceso a la información.
  
- ## Tecnologías utilizadas:

  - [IntelliJ IDEA 2024](https://www.jetbrains.com/idea/)
  - [Insomnia](https://insomnia.rest/)
  - [MySql](https://www.mysql.com/)
  - [Java 17](https://www.java.com/en/)
  - [Spring Boot 3.3.1](https://start.spring.io/)
  - [Token JWT](https://jwt.io/)
  - [Maven](http://maven.apache.org/POM/4.0.0)
  - [flywaydb](https://flywaydb.org/)
  - [lombok](https://projectlombok.org/)
  - Spring Boot Security
 
 - ## EndPoints
   - Registro de usuario (Autor)
     ```bash
[POST] http://localhost:8080/autores
```

```json
{
  "nombre":"Saul Cabrera",
  "correo":"saul@gmail",
  "contraseña":"123456"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Registro exitoso
```

</details>
 



