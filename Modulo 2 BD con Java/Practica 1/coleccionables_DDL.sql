-- Crea la Base de Datos
CREATE DATABASE tienda_coleccionables;

-- Se hace el uso de l Base de Datos
USE tienda_coleccionables;

-- Crea la tabla pais
CREATE TABLE pais (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo CHAR(2) NOT NULL UNIQUE
    );

-- Crea la tabla fabricante
CREATE TABLE fabricante (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_pais INT NOT NULL,
    FOREIGN KEY (id_pais) REFERENCES pais(id)
    );
    
-- Crea la tabla edicion
CREATE TABLE edicion (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	descripcion VARCHAR(250)
	);
    
-- Crea la tabla figura
CREATE TABLE figura (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250),
    fecha_lanzamiento DATE,
    precio DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
    id_fabricante INT NOT NULL,
    FOREIGN KEY (id_fabricante) REFERENCES fabricante(id),
    id_edicion INT NOT NULL,
    FOREIGN KEY (id_edicion) REFERENCES edicion(id)
    );
    
-- Crea la tabla coleccion
CREATE TABLE coleccionista (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(10) NOT NULL
    );
    
-- Crea la tabla transaccion
CREATE TABLE transaccion (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
	id_figura INT NOT NULL,
	FOREIGN KEY (id_figura) REFERENCES figura(id),
    id_coleccionista INT NOT NULL,
    FOREIGN KEY (id_coleccionista) REFERENCES coleccionista(id),
    fecha DATE NOT NULL DEFAULT (CURRENT_DATE),
    precio_transaccion DECIMAL(10,2) NOT NULL CHECK (precio_transaccion >= 0)
    );
    
-- DATOS DE PRUEBA -- 

-- Tabla: pais
INSERT INTO pais (nombre, codigo) VALUES
('México', 'MX'),
('Japón', 'JP'),
('Estados Unidos', 'US');

-- Tabla: fabricante
INSERT INTO fabricante (nombre, id_pais) VALUES
('Bandai', 2),
('Hasbro', 3),
('Funko', 3),
('Mattel', 1);

-- Tabla: edicion
INSERT INTO edicion (nombre, descripcion) VALUES
('Edición Limitada', 'Figuras lanzadas en cantidad limitada'),
('Clásica', 'Reedición de modelos antiguos'),
('Coleccionista', 'Edición especial para coleccionistas');

-- Tabla: figura
INSERT INTO figura (nombre, descripcion, fecha_lanzamiento, precio, id_fabricante, id_edicion) VALUES
('Goku Super Saiyajin', 'Figura articulada de Goku en SSJ', '2023-06-01', 350.00, 1, 1),
('Iron Man Mark 50', 'Figura metálica de Iron Man', '2022-05-15', 450.00, 2, 3),
('Batman Edición Oscura', 'Figura con capa y base de colección', '2023-09-10', 280.00, 4, 2),
('Darth Vader', 'Figura de 15 cm con sable rojo', '2024-01-20', 500.00, 3, 1);

-- Tabla: coleccionista
INSERT INTO coleccionista (nombre, email, telefono) VALUES
('Alonso Sagrero', 'alonso@example.com', '5512345678'),
('Carlos Pérez', 'carlos.perez@example.com', '5587654321'),
('María López', 'maria.lopez@example.com', '5522334455');

-- Tabla: transaccion
INSERT INTO transaccion (nombre, id_figura, id_coleccionista, fecha, precio_transaccion) VALUES
('Compra Goku', 1, 1, '2024-01-15', 350.00),
('Compra Iron Man', 2, 2, '2024-02-05', 460.00),
('Compra Batman', 3, 1, '2024-03-10', 280.00),
('Compra Darth Vader', 4, 3, '2024-03-25', 500.00),
('Compra Goku 2', 1, 2, '2024-03-30', 355.00);