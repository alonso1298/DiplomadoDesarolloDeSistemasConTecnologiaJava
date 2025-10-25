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

insert into usuario values('JUAN RODRÍGUEZ', 'juan@unam.mx');
insert into usuario (correo_electronico, nombre) values('JUAN RODRÍGUEZ', 'juan@unam.mx');

UPDATE usuario u SET nombre = "Juan Antonio Perez"
	WHERE u.correo_electronico = "juan@aunam.mx";

DELETE FROM usuario WHERE correo_electronico = "juan@aunam.mx";

SELECT * FROM usuario;