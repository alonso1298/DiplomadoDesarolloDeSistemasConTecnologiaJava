insert into usuario(nombre,correo,edad) values("Usuario 1","demo1@demo.dgtic",23);
insert into usuario(nombre,correo,edad) values("Usuario 2","demo1@demo.dgtic",24);
insert into usuario(nombre,correo,edad) values("Usuario 3","demo1@demo.dgtic",25);
insert into usuario(nombre,correo,edad) values("Usuario 4","demo1@demo.dgtic",26);
insert into usuario(nombre,correo,edad) values("Usuario 5","demo1@demo.dgtic",27);
insert into usuario(nombre,correo,edad) values("Usuario 6","demo1@demo.dgtic",28);
insert into categoria(nombre) values('conveniencia');
insert into producto(nombre,categoria_id) values('pan',1);
insert into producto(nombre,categoria_id) values('agua',1);
insert into producto(nombre,categoria_id) values('tortillas',1);
insert into producto(nombre,categoria_id) values('refresco',1);
insert into categoria(nombre) values('comparacion');
insert into producto(nombre,categoria_id) values('muebles',2);
insert into producto(nombre,categoria_id) values('ropa',2);
insert into producto(nombre,categoria_id) values('carro',2);
insert into producto(nombre,categoria_id) values('motocicleta',2);

insert into pais(nombre) values('México');
insert into ciudad(nombre,id_pais) values('Ciudad de México',1);
insert into ciudad(nombre,id_pais) values('Monterrey',1);
insert into ciudad(nombre,id_pais) values('Guadalajara',1);
insert into ciudad(nombre,id_pais) values('Puebla de México',1);

insert into pais(nombre) values('Brasil');
insert into ciudad(nombre,id_pais) values('Brasilia',2);
insert into ciudad(nombre,id_pais) values('Río de Janeiro',2);
insert into ciudad(nombre,id_pais) values('São Paulo',2);
insert into ciudad(nombre,id_pais) values('Salvador',2);

insert into pais(nombre) values('Argentina');
insert into ciudad(nombre,id_pais) values('Buenos Aires',3);
insert into ciudad(nombre,id_pais) values('Córdoba',3);
insert into ciudad(nombre,id_pais) values('Rosario',3);
insert into ciudad(nombre,id_pais) values('Mendoza',3);