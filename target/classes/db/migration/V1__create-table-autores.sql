CREATE TABLE autores (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  contraseña varchar(255) NOT NULL,
  correo_electronico varchar(255) NOT NULL UNIQUE,
  nombre varchar(255) NOT NULL,

  PRIMARY KEY(id)
);