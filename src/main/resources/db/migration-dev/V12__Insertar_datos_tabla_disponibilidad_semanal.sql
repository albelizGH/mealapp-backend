-- Insertar disponibilidad semanal de platos
INSERT INTO `disponibilidad_semanal` (`semana_inicio`, `plato_id`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('2024-10-07', 1, 1, 1, 1, 0, 1),  -- Milanesa disponible en lunes, martes, miércoles y viernes
('2024-10-07', 2, 1, 1, 1, 0, 1),  -- Papas Fritas disponible en lunes, martes, miércoles y viernes
('2024-10-07', 3, 1, 1, 1, 1, 1),  -- Coca Cola disponible todos los días
('2024-10-07', 4, 0, 1, 1, 0, 0),  -- Pollo Asado disponible en martes y miércoles
('2024-10-07', 5, 1, 0, 1, 1, 1),  -- Ensalada disponible en lunes, miércoles, jueves y viernes
('2024-10-07', 6, 1, 1, 1, 1, 1),  -- Agua disponible todos los días
('2024-10-07', 7, 1, 1, 0, 1, 1);  -- Empanadas disponible en lunes, martes, jueves y viernes
