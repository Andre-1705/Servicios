-- 1. Servicios de programación

SELECT nombre, descripcion
FROM servicios
WHERE tipo = 'Programación';

-- 2. Productos con stock mayor a cantidad determinada

SELECT nombre, stock
FROM productos
WHERE stock < 20;

-- 3. Empleado con salario superior a cierto monto 

SELECT nombre, salario
FROM empleados
WHERE activo = true AND salario > 60000.0;

-- 4. Clientes activos con edad de entre 50 y 120 años

SELECT nombre, edad
FROM clientes
WHERE activo = true AND edad BETWEEN 50 AND 120;

-- 5. Productos en stock

SELECT COUNT(*) FROM productos WHERE stock > 0;

-- 6. Servicios de Programación

SELECT * FROM servicios WHERE tipo = 'Programación';

-- 7. Servicios activos de cada cliente

SELECT c.nombre, c.apellido, s.nombre AS servicio_nombre
FROM clientes c
INNER JOIN servicios s ON c.id = s.cliente_id
WHERE s.activo = true;

-- 8. Clientes con servicios

SELECT s.nombre AS nombre_servicio, c.nombre AS nombre_cliente
FROM servicios s
INNER JOIN clientes c ON s.cliente_id = c.id;

-- 9. Salario Promedio

SELECT AVG(e.salario) AS salario_promedio
FROM empleados e
JOIN servicios s ON e.id = s.cliente_id
WHERE s.tipo = 'Comunicación';

-- 10 clientes

SELECT * FROM clientes;
