#Primer ejemplo de BD
create database prueba character set utf8mb4 collate utf8mb4_unicode_ci;

use prueba;

create table usuario(
	nombre varchar(100)
);

#create user curso@localhost IDENTIFIED by "cursos";

alter table usuario add column correo_electronico varchar(100);

drop table usuario;

drop database prueba;
INSERT INTO usuario VALUES ("Juan rodriguez", "juan@unam.mx");

INSERT INTO usuario (correo_electronico, nombre)
	VALUES ("manuel@unam.mx", "Manuel Rodriguez");

UPDATE usuario u SET nombre = "Juan Antonio Perez"
	WHERE u.correo_electronico = "juan@aunam.mx";

DELETE FROM usuario WHERE correo_electronico = "juan@unam.mx";

ALTER TABLE usuario ADD COLUMN carrera VARCHAR(100);

UPDATE usuario SET carrera = "Matematicas";

SELECT * FROM usuario;

SELECT * FROM usuario ORDER BY nombre DESC;

INSERT INTO usuario VALUES ("Alonso Sagrero", "alonso@unam.mx", "Fisica");

SELECT carrera, COUNT(*) as numero_usuario FROM usuario GROUP BY carrera ORDER BY carrera DESC;

GRANT ALL PRIVILEGES ON prueba.* TO cursos@localhost;

FLUSH PRIVILEGES;