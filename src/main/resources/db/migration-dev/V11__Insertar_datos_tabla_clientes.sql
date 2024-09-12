-- Insertar clientes
INSERT INTO `clientes` (`nombre`, `apellido`, `documento`, `correo`, `contrasenia`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('Juan', 'Pérez', 12345678, 'juan.perez@example.com', 'password123', 1, 1, 1, 0, 1),  -- Cliente: Juan Pérez, Disponible: Lunes, Martes, Miércoles, Viernes
('Ana', 'Gómez', 87654321, 'ana.gomez@example.com', 'password456', 1, 0, 1, 1, 0);  -- Cliente: Ana Gómez, Disponible: Lunes, Miércoles, Jueves
