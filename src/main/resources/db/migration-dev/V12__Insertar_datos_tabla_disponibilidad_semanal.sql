-- Insertar disponibilidad semanal de platos
INSERT INTO `disponibilidad_semanal` (`semana_inicio`, `plato_id`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('2024-10-07', 1, 1, 1, 1, 0, 1),  -- Milanesa disponible en lunes, martes, miércoles y viernes
('2024-10-07', 2, 1, 1, 1, 0, 1),  -- Papas Fritas disponible en lunes, martes, miércoles y viernes
('2024-10-07', 3, 1, 1, 1, 1, 1),  -- Coca Cola disponible todos los días
('2024-10-07', 4, 0, 1, 1, 0, 0),  -- Pollo Asado disponible en martes y miércoles
('2024-10-07', 5, 1, 0, 1, 1, 1),  -- Ensalada disponible en lunes, miércoles, jueves y viernes
('2024-10-07', 6, 1, 1, 1, 1, 1),  -- Agua disponible todos los días
('2024-10-07', 7, 1, 1, 0, 1, 1);  -- Empanadas disponible en lunes, martes, jueves y viernes
-- Insertar disponibilidad semanal de los nuevos platos
INSERT INTO `disponibilidad_semanal` (`semana_inicio`, `plato_id`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('2024-10-07', 8, 1, 1, 0, 0, 0),  -- Tacos disponible en lunes y martes
('2024-10-07', 9, 1, 0, 1, 1, 0),  -- Hamburguesa disponible en lunes, miércoles y jueves
('2024-10-07', 10, 0, 1, 1, 0, 1), -- Sopa de Pollo disponible en martes, miércoles y viernes
('2024-10-07', 11, 1, 1, 1, 1, 0), -- Pizza disponible de lunes a jueves
('2024-10-07', 12, 1, 0, 0, 1, 1), -- Fajitas disponible en lunes, jueves y viernes
('2024-10-07', 13, 0, 0, 1, 1, 1), -- Tortilla de Patatas disponible en miércoles, jueves y viernes
('2024-10-07', 14, 1, 1, 0, 1, 0), -- Sandwich Vegetariano disponible en lunes, martes y jueves
('2024-10-07', 15, 1, 1, 1, 0, 0), -- Ceviche disponible en lunes, martes y miércoles
('2024-10-07', 16, 0, 1, 1, 1, 0), -- Ravioles disponible en martes, miércoles y jueves
('2024-10-07', 17, 1, 0, 1, 0, 1), -- Spaghetti disponible en lunes, miércoles y viernes
('2024-10-07', 18, 1, 1, 1, 1, 1), -- Paella disponible todos los días
('2024-10-07', 19, 1, 1, 1, 0, 1), -- Lasagna disponible en lunes, martes, miércoles y viernes
('2024-10-07', 20, 1, 0, 1, 1, 0), -- Salmon Grillado disponible en lunes, miércoles y jueves
('2024-10-07', 21, 1, 1, 0, 1, 0), -- Sushi disponible en lunes, martes y jueves
('2024-10-07', 22, 1, 0, 1, 0, 1), -- Camarones disponible en lunes, miércoles y viernes
('2024-10-07', 23, 0, 1, 1, 1, 0), -- Carne Asada disponible en martes, miércoles y jueves
('2024-10-07', 24, 1, 1, 0, 1, 0), -- Pollo al Curry disponible en lunes, martes y jueves
('2024-10-07', 25, 0, 1, 0, 1, 1), -- Falafel disponible en martes, jueves y viernes
('2024-10-07', 26, 1, 1, 1, 1, 0), -- Shawarma disponible de lunes a jueves
('2024-10-07', 27, 1, 1, 1, 0, 0), -- Ratatouille disponible en lunes, martes y miércoles
('2024-10-07', 28, 1, 1, 0, 0, 1), -- Brochetas de Pollo disponible en lunes, martes y viernes
('2024-10-07', 29, 0, 1, 1, 0, 1), -- Quesadilla disponible en martes, miércoles y viernes
('2024-10-07', 30, 1, 0, 1, 1, 0), -- Churrasco disponible en lunes, miércoles y jueves
('2024-10-07', 31, 0, 0, 1, 1, 1), -- Tarta de Verduras disponible en miércoles, jueves y viernes
('2024-10-07', 32, 1, 1, 0, 1, 0), -- Pasta Alfredo disponible en lunes, martes y jueves
('2024-10-07', 33, 1, 0, 0, 1, 1), -- Papas Bravas disponible en lunes, jueves y viernes
('2024-10-07', 34, 0, 1, 1, 1, 0), -- Nachos disponible en martes, miércoles y jueves
('2024-10-07', 35, 1, 0, 1, 0, 1), -- Arepas disponible en lunes, miércoles y viernes
('2024-10-07', 36, 1, 1, 0, 1, 0), -- Tequeños disponible en lunes, martes y jueves
('2024-10-07', 37, 0, 1, 1, 1, 0), -- Croquetas disponible en martes, miércoles y jueves
('2024-10-07', 38, 1, 1, 0, 0, 1), -- Empanadas Arabes disponible en lunes, martes y viernes
('2024-10-07', 39, 0, 1, 1, 0, 1), -- Empanadas de Pollo disponible en martes, miércoles y viernes
('2024-10-07', 40, 1, 0, 0, 1, 1), -- Empanadas de Queso disponible en lunes, jueves y viernes
('2024-10-07', 41, 1, 1, 0, 1, 0), -- Empanadas de Carne disponible en lunes, martes y jueves
('2024-10-07', 42, 0, 1, 1, 1, 0), -- Empanadas de Jamón y Queso disponible en martes, miércoles y jueves
('2024-10-07', 43, 1, 1, 0, 0, 1), -- Empanadas de Espinaca disponible en lunes, martes y viernes
('2024-10-07', 44, 1, 1, 0, 1, 1), -- Empanadas Criollas disponible en lunes, martes, jueves y viernes
('2024-10-07', 45, 0, 1, 1, 0, 1), -- Empanadas de Calabaza disponible en martes, miércoles y viernes
('2024-10-07', 46, 1, 1, 0, 0, 1), -- Empanadas Caprese disponible en lunes, martes y viernes
('2024-10-07', 47, 1, 0, 1, 0, 1), -- Coca Zero disponible en lunes, miércoles y viernes
('2024-10-07', 48, 0, 1, 1, 1, 0), -- Fanta disponible en martes, miércoles y jueves
('2024-10-07', 49, 1, 1, 0, 0, 1), -- Sprite disponible en lunes, martes y viernes
('2024-10-07', 50, 1, 0, 1, 1, 0), -- Jugo de Naranja disponible en lunes, miércoles y jueves
('2024-10-07', 51, 1, 0, 1, 1, 1), -- Limonada disponible en lunes, miércoles, jueves y viernes
('2024-10-07', 52, 0, 1, 1, 0, 0), -- Té Helado disponible en martes y miércoles
('2024-10-07', 53, 1, 1, 0, 1, 1), -- Café disponible en lunes, martes, jueves y viernes
('2024-10-07', 54, 0, 1, 1, 1, 0), -- Chocolate Caliente disponible en martes, miércoles y jueves
('2024-10-07', 55, 1, 0, 0, 1, 1); -- Batido de Fresa disponible en lunes, jueves y viernes
