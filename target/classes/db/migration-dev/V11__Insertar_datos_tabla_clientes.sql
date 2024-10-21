-- Insertar clientes
INSERT INTO `clientes` (`nombre`, `apellido`, `documento`, `correo`, `contrasenia`, `fecha_alta`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`, `rol`) VALUES
('Juan', 'Pérez', 12345678, 'juan.perez@example.com', '$2a$12$lMzUW4UWcaKfqa92LM54.eJhl9y1v6MQKCQ7QIb19mNjRP0s.aMyO', '2023-11-14', 1, 1, 1, 0, 1, 'CLIENTE'),  -- Cliente: Juan Pérez, Disponible: Lunes, Martes, Miércoles, Viernes
('Ana', 'Gómez', 87654321, 'ana.gomez@example.com', '$2a$12$lMzUW4UWcaKfqa92LM54.eJhl9y1v6MQKCQ7QIb19mNjRP0s.aMyO', '2023-09-21', 1, 0, 1, 1, 0, 'CLIENTE');  -- Cliente: Ana Gómez, Disponible: Lunes, Miércoles, Jueves

-- La contraseña está encriptada pero es password123 en todos estos usuarios

-- Insertar un usuario local
INSERT INTO `clientes` (`nombre`, `apellido`, `documento`, `correo`, `contrasenia`, `fecha_alta`, `rol`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('Duenio', 'AutomovilClub', 38921108, 'duenio@automovilclub.com', '$2a$12$lMzUW4UWcaKfqa92LM54.eJhl9y1v6MQKCQ7QIb19mNjRP0s.aMyO', '2023-11-14', 'LOCAL', 0, 0, 0, 0, 0);

-- Insertar al admin
INSERT INTO `clientes` (`nombre`, `apellido`, `documento`, `correo`, `contrasenia`, `fecha_alta`, `rol`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('Admin', 'Admin', 00000000, 'admin@admin.com', '$2a$12$lMzUW4UWcaKfqa92LM54.eJhl9y1v6MQKCQ7QIb19mNjRP0s.aMyO', '2023-11-14', 'ADMINISTRADOR', 0, 0, 0, 0, 0);

