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

CREATE TABLE curso(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    id_instructor INT,
    FOREIGN KEY (id_instructor) REFERENCES instructor(id)
);

CREATE TABLE inscripcion(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_estudiante INT,
    id_curso INT,
    calificacion DECIMAL(4,2) CHECK (calificacion >= 0 AND calificacion <= 10)
);

ALTER TABLE incripcion
	ADD FOREIGN KEY (id_estudiante) REFERENCES estudiante (id);
ALTER TABLE incripcion
	ADD FOREIGN KEY (id_curso) REFERENCES curso (id);

ALTER TABLE inscripcion
	ADD FOREIGN KEY (id_estudiante) REFERENCES estudiante (id);
ALTER TABLE inscripcion
	ADD FOREIGN KEY (id_curso) REFERENCES curso (id);


INSERT INTO estudiante (nombre, apellido_paterno, correo_electronico, numero_cuenta)
	VALUES ('Mario', 'Hernández', 'mariohm@unam.mx', '00012');
INSERT INTO estudiante (nombre, apellido_paterno, correo_electronico, numero_cuenta)
	VALUES ('Juan', 'Pérez', 'jperez@unam.mx', '00112');
INSERT INTO estudiante (nombre, apellido_paterno, correo_electronico, numero_cuenta)
	VALUES ('Ana', 'López', 'ana@unam.mx', '00212');


INSERT INTO instructor (nombre, apellido_paterno, correo_electronico, especialidad)
	VALUES ('Jorge', 'Hernández', 'jorge@unam.mx', 'Matemáticas');
INSERT INTO instructor (nombre, apellido_paterno, correo_electronico, especialidad)
	VALUES ('Sofía', 'Valle', 'svalle@unam.mx', 'Diseño');

INSERT INTO curso (nombre, descripcion, id_instructor)
	VALUES ('Álgebra', '', 1);
INSERT INTO curso (nombre, descripcion, id_instructor)
	VALUES ('Cálculo', '', 1);

INSERT INTO inscripcion (id_estudiante, id_curso, calificacion)
	VALUES (1, 1, 7.5);
INSERT INTO inscripcion (id_estudiante, id_curso, calificacion)
	VALUES (2, 1, 9.75);
INSERT INTO inscripcion (id_estudiante, id_curso, calificacion)
	VALUES (2, 2, 9.50);


CREATE TABLE especialidad (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50)
);

INSERT INTO especialidad (nombre) VALUES ('Matemáticas');
INSERT INTO especialidad (nombre) VALUES ('Diseño');

ALTER TABLE instructor ADD COLUMN id_especialidad INT REFERENCES especialidad(id);
ALTER TABLE instructor DROP COLUMN especialidad;


SELECT numero_cuenta, nombre, apellido_paterno, correo_electronico
	FROM estudiante ORDER BY apellido_paterno;

SELECT nombre FROM curso ORDER BY nombre;

SELECT * FROM inscripcion;

SELECT e.numero_cuenta, e.nombre, e.apellido_paterno, c.nombre
FROM inscripcion i
	JOIN estudiante e ON i.id_estudiante = e.id
	JOIN curso c ON i.id_curso = c.id
ORDER BY e.numero_cuenta;