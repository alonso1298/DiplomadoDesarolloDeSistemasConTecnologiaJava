-- CONSULTAS --
-- a) Listar todas las figuras junto con sus fabricantes
SELECT f.id AS id_figura, f.nombre AS figura, fab.nombre AS fabricante 
FROM figura f
JOIN fabricante fab ON f.id_fabricante = fab.id;

-- b) Listar las figuras de un fabricante en particular con precio mayor a $200.00
SELECT f.nombre AS figura, f.precio, fab.nombre AS fabricante 
FROM figura f
JOIN fabricante fab ON f.id_fabricante = fab.id
WHERE fab.nombre = 'Mattel' AND f.precio > 200;

-- c) Promedio de precios por fabricante
SELECT f.nombre AS fabricante,
	ROUND(AVG(f.precio), 2) AS promecio_precio
FROM figura f
JOIN fabricante fab ON f.id_fabricante = fab.id
GROUP BY fab.nombre;

-- d) Obtener el coleccionista con más transacciones, mostrando el total de transacciones y el monto total de esas ventas.
SELECT 
    c.nombre AS coleccionista,
    COUNT(t.id) AS total_transacciones,
    SUM(t.precio_transaccion) AS monto_total
FROM transaccion t
JOIN coleccionista c ON t.id_coleccionista = c.id
GROUP BY c.id
ORDER BY total_transacciones DESC
LIMIT 1;

-- c) Obtener la cantidad vendida por mes del primer trimestre de 2024.
SELECT 
    MONTH(fecha) AS mes,
    COUNT(*) AS cantidad_transacciones,
    SUM(precio_transaccion) AS monto_total
FROM transaccion
WHERE YEAR(fecha) = 2024
  AND MONTH(fecha) BETWEEN 1 AND 3
GROUP BY MONTH(fecha)
ORDER BY mes;
