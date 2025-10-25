CREATE DATABASE cursos;

USE cursos;

CREATE TABLE estudiante (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(50) NOT NULL,
    numero_cuenta VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE instructor(
	id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50),
    PRIMARY KEY (id)
);