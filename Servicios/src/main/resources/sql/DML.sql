use servicios;

INSERT INTO clientes(apellido, nombre, edad, email, telefono, activo) VALUES 
('García', 'María', 30, 'maria.garcia@example.com', '555-123-4567', true),
('Rodríguez', 'Juan', 25, 'juan.rodriguez@example.com', '555-987-6543', true),
('López', 'Ana', 22, 'ana.lopez@example.com', '555-555-5555', true),
('Martínez', 'Carlos', 40, 'carlos.martinez@example.com', '555-111-2222', true),
('Pérez', 'Laura', 28, 'laura.perez@example.com', '555-444-3333', true),
('Fernández', 'Pedro', 33, 'pedro.fernandez@example.com', '555-333-2222', true),
('Gómez', 'Sofía', 29, 'sofia.gomez@example.com', '555-666-9999', true),
('Torres', 'Luis', 45, 'luis.torres@example.com', '555-888-7777', true),
('Rojas', 'Valentina', 24, 'valentina.rojas@example.com', '555-222-1111', true),
('Díaz', 'Andrés', 31, 'andres.diaz@example.com', '555-444-5555', true),
('Hernández', 'Isabella', 27, 'isabella.hernandez@example.com', '555-777-4444', true),
('Sánchez', 'Diego', 35, 'diego.sanchez@example.com', '555-777-8888', true),    
('González', 'Lucía', 26, 'lucia.gonzalez@example.com', '555-123-4567', true),
('Silva', 'Matías', 34, 'matias.silva@example.com', '555-987-6543', true),
('Vargas', 'Camila', 23, 'camila.vargas@example.com', '555-555-5555', true),
('Fuentes', 'Joaquín', 29, 'joaquin.fuentes@example.com', '555-111-2222', true),
('Castro', 'Valeria', 27, 'valeria.castro@example.com', '555-444-3333', true),
('Ortega', 'Felipe', 32, 'felipe.ortega@example.com', '555-777-8888', true),
('Molina', 'Isabel', 28, 'isabel.molina@example.com', '555-666-9999', true),
('Rivas', 'Emilio', 36, 'emilio.rivas@example.com', '555-888-7777', true);


INSERT INTO servicios(nombre, descripcion, tipo, cliente_id, activo) VALUES 
('Desarrollo de Sitios Web', 'Desarrollo de sitios web personalizados', 'Programación', 1,true),
('Desarrollo de Aplicaciones Móviles', 'Desarrollo de aplicaciones para iOS y Android', 'Programación', 2, true),
('Seminaria software personalizado', 'Soluciones específicas para negocios', 'Programación', 3, true),
('Desarrollo de Videojuegos', 'Diversificación de desarrollo en videojuegos', 'Programación', 4, true),
('Desarrollo de Chatbots', 'Automatización de atención al cliente', 'Programación', 5, true),
('Desarrollo de Extensiones de Navegador', 'Mejoras en las funcionalidades de navegadores', 'Programación', 6, true),
('Desarrollo de Aplicaciones de Escritorios','Programas para Windows, MacOS, Linux', 'Programación', 7, true),
('Curso sobre Desarrollo de Plugins', 'Desarrollo de funcionalidades en plataformas como WordPress', 'Programación', 8, true),
('Desarrollo de Inteligenia Artificial', 'Modelos de aprendizaje automático', 'Programación', 9, true),
('Desarrollo de Integraciones y Apis', 'Conección entre diferentes aplicaciones', 'Programación', 10,true),
('Creación de Contenido Creativo', 'Desarrollo de contenido original y atractivo para redes sociales y sitio web', 'Comunicación', 11, true),
('Gestión de Redes Sociales', 'Manejo profesional de tus perfiles en plataformas como Facebook, Instagram, Twitter y Linkedin', 'Comunicación', 12,true),
('Curso integral Estrategia de Branding', 'Definición de la identidad de tu marca, valores y voz para una comunicación coherente', 'Comunicación', 13, true), 
('Diseño Gráfico para Redes Sociales', 'Creación de imágenes, banners y gráficos visuales para tus publicaciones3', 'Comunicación', 14, true),
('Campañas de Publicidad en Redes Sociales', 'Planificación, ejecución de anuncios pagados, aumento de visibilidad de marca', 'Comunicación', 15, true),
('Generación de Contenido Audiovisual', 'Videos, animaciones y presentaciones para compartir en tus canales digitales', 'Comunicación', 16, true),
('Seminario teorico-práctico Email Marketing', 'Estrategias para enviar correos electrónicos relevantes y atractivos a tu audiencia', 'Comunicación', 17, true),
('Optimización SEO', 'Mejora de la visibilidad de tu contenido en motores de búsqueda', 'Comunicación', 18, true),
('Monitoreo y Análisis de Datos', 'Seguimiento de métricas y ajustes según el rendimiento de tus publicaciones', 'Comunicación', 19, true),
('Colaboraciones con Influencers', 'Establecimiento de alianzas con personas influyentes para promocionar tu marca', 'Comunicación', 20, true);



INSERT INTO empleados (apellido, nombre, salario, fecha_contrato, activo) VALUES
('García', 'Ana', 50000.0, '2023-05-01', true),
('Martínez', 'Luis', 60000.0, '2022-11-15', true),
('Fernández', 'Laura', 55000.0, '2023-02-20', true),
('Pérez', 'Diego', 62000.0, '2023-03-10', true),
('Rodríguez', 'Sofía', 58000.0, '2023-04-05', true),
('López', 'Carlos', 54000.0, '2023-01-10', true),
('González', 'María', 59000.0, '2023-06-20', true);

INSERT INTO productos (nombre, precio, stock, activo) VALUES
('Producto A', 100, 50, true),
('Producto B', 200, 30, true),
('Producto C', 150, 20, true),
('Producto D', 80, 40, true),
('Producto E', 120, 60, true),
('Producto F', 90, 25, true),
('Producto G', 180, 35, true),
('Producto H', 70, 50, true),
('Producto I', 130, 15, true),
('Producto J', 110, 55, true);