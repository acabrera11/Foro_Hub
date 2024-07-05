CREATE TABLE topicos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  fecha_creacion datetime(6) NOT NULL,
  mensaje varchar(255) NOT NULL,
  status bit(1) NOT NULL,
  titulo varchar(255) NOT NULL,
  autor_id bigint(20) NOT NULL,
  curso_id bigint(20) NOT NULL,

  PRIMARY KEY(id),
  CONSTRAINT fk_topicos_autor_id FOREIGN KEY (autor_id) REFERENCES autores (id),
  CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos (id)
);