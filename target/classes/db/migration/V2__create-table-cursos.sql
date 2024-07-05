CREATE TABLE cursos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  categoria varchar(255) NOT NULL,
  nombre varchar(255) NOT NULL UNIQUE,

  PRIMARY KEY(id)
);