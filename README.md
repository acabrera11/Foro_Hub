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
- ✅ Login de usuario;
- ✅ Crear un nuevo usuario(autor);
- ✅ Mostrar todos los usuarios creados;
- ✅ Actualizar un usuario;
- ✅ Eliminar un usuario de forma lógica.
- ✅ Crear un nuevo curso

En resumen, el objetivo es implementar una API REST con las siguientes funcionalidades:

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
A excepcion del login de usuario, todos los endpoints requieren autenticaaión con un Bearer Token

## Crear un nuevo tópico
```bash
[POST] http://localhost:8080/topicos
```

```json
{
"titulo":"Duda 255",
"mensaje":"Error 5000",
"fechaCreacion":"2024-07-05T10:30",
"status":"true",
"idAutor":"3",
"idCurso":"1"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
{
	"id": 5,
	"titulo": "Duda 255",
	"mensaje": "Error 5000",
	"fechaCreacion": "2024-07-05T10:30:00",
	"status": true,
	"idAutor": 3,
	"idCurso": 1
}
```
</details>

## Mostrar todos los tópicos creados
```bash
[GET] http://localhost:8080/topicos
```
<details><summary><b>Output</b></summary>
<br/>
```javascript
{
	"totalPages": 1,
	"totalElements": 2,
	"size": 10,
	"content": [
		{
			"id": 4,
			"titulo": "Duda 25",
			"mensaje": "Error 500",
			"fechaCreacion": "2024-07-05T10:30:00",
			"status": true,
			"idAutor": 2,
			"idCurso": 1
		},
		{
			"id": 1,
			"titulo": "Duda MODIFICADA",
			"mensaje": "Error MODIFICADO",
			"fechaCreacion": "2024-07-03T10:30:00",
			"status": true,
			"idAutor": 1,
			"idCurso": 1
		}
	],
	"number": 0,
	"sort": {
		"empty": false,
		"sorted": true,
		"unsorted": false
	},
	"numberOfElements": 2,
	"pageable": {
		"pageNumber": 0,
		"pageSize": 10,
		"sort": {
			"empty": false,
			"sorted": true,
			"unsorted": false
		},
		"offset": 0,
		"paged": true,
		"unpaged": false
	},
	"first": true,
	"last": true,
	"empty": false
}
```
</details>

## Mostrar un tópico específico
```bash
[GET] http://localhost:8080/topicos/2
```
<details><summary><b>Output</b></summary>
<br/>

```javascript
{
	"id": 2,
	"titulo": "Duda 2",
	"mensaje": "Error 500",
	"fechaCreacion": "2024-07-04T10:30:00",
	"status": false,
	"idAutor": 2,
	"idCurso": 1
}
```
</details>

## Actualizar un tópico;
```bash
[PUT] http://localhost:8080/topicos
```

```json
{
	"id":"1",
	"titulo": "Duda MODIFICADA2",
	"mensaje": "Error MODIFICADO2"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Registro Actualizado
```
</details>

## Eliminar un tópico.
```bash
[DELETE] http://localhost:8080/topicos/1
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Registro eliminado
```
</details>

## Login de usuario;
```bash
[POST] http://localhost:8080/login
```

```json
{
	"correo":"otrocambio@gmail",
	"contraseña":"123456"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
{
	"jwTtoken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvdHJvY2FtYmlvQGdtYWlsIiwiaXNzIjoiZm9ybyBhbHVyYSIsImlkIjoxLCJleHAiOjE3MjAxNjY2MzR9.ae40ygQuMS4Ld43c31Bf0zVXg7WFg0N3O9nnTqbP-Rc"
}
```
</details>

## Crear un nuevo usuario(Autor)
```bash
[POST] http://localhost:8080/autores
```

```json
{
  "nombre":"Saul Cabrera",
  "correo":"saul@gmail.com",
  "contraseña":"123456"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Registro exitoso
```
</details>

## Mostrar todos los usuarios creados
```bash
[POST] http://localhost:8080/autores
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
{
	"totalPages": 1,
	"totalElements": 4,
	"size": 10,
	"content": [
		{
			"id": 1,
			"nombre": "Enriquez Cabrera",
			"correo": "otrocambio@gmail.com"
		},
		{
			"id": 3,
			"nombre": "Luis Cabrera",
			"correo": "lucho1@gmail.com"
		},
		{
			"id": 4,
			"nombre": "Mario Cabrera",
			"correo": "mario@gmail.com"
		},
		{
			"id": 7,
			"nombre": "Saul Cabrera",
			"correo": "saul@gmail.com"
		}
	],
	"number": 0,
	"sort": {
		"empty": true,
		"sorted": false,
		"unsorted": true
	},
	"first": true,
	"last": true,
	"numberOfElements": 4,
	"pageable": {
		"pageNumber": 0,
		"pageSize": 10,
		"sort": {
			"empty": true,
			"sorted": false,
			"unsorted": true
		},
		"offset": 0,
		"paged": true,
		"unpaged": false
	},
	"empty": false
}
```
</details>

## Actualizar un usuario;
```bash
[PUT] http://localhost:8080/autores
```

```json
{
			"id": 2,
			"correo": "otrocambi2@gmail.com"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Actualización exitosa
```
</details>

## Eliminar un usuario de forma lógica.
```bash
[DELETE] http://localhost:8080/autores/2
```
<details><summary><b>Output</b></summary>
<br/>

```javascript
Usuario eliminado
}
```
</details>

## Crear un nuevo curso
```bash
[POST] http://localhost:8080/cursos
```

```json
{
	"nombre":"Curso de SpringBoot",
  	"categoria":"Programacion Web Avanzada"
}
```

<details><summary><b>Output</b></summary>
<br/>

```javascript
Curso creado
```
</details>
 



