-- Insertar disponibilidad semanal de platos
INSERT INTO `disponibilidades` (`semana_inicio`, `plato_id`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('2024-11-11', 1, 1, 1, 1, 0, 1),  -- Milanesa disponible en lunes, martes, miércoles y viernes
('2024-11-11', 2, 1, 1, 1, 0, 1),  -- Papas Fritas disponible en lunes, martes, miércoles y viernes
('2024-11-11', 3, 1, 1, 1, 1, 1),  -- Coca Cola disponible todos los días
('2024-11-11', 4, 0, 1, 1, 0, 0),  -- Pollo Asado disponible en martes y miércoles
('2024-11-11', 5, 1, 0, 1, 1, 1),  -- Ensalada disponible en lunes, miércoles, jueves y viernes
('2024-11-11', 6, 1, 1, 1, 1, 1),  -- Agua disponible todos los días
('2024-11-11', 7, 1, 1, 0, 1, 1);  -- Empanadas disponible en lunes, martes, jueves y viernes
-- Insertar disponibilidad semanal de los nuevos platos
INSERT INTO `disponibilidades` (`semana_inicio`, `plato_id`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`) VALUES
('2024-11-11', 8, 1, 1, 0, 0, 0),  -- Tacos disponible en lunes y martes
('2024-11-11', 9, 1, 0, 1, 1, 0),  -- Hamburguesa disponible en lunes, miércoles y jueves
('2024-11-11', 10, 0, 1, 1, 0, 1), -- Sopa de Pollo disponible en martes, miércoles y viernes
('2024-11-11', 11, 1, 1, 1, 1, 0), -- Pizza disponible de lunes a jueves
('2024-11-11', 12, 1, 0, 0, 1, 1), -- Fajitas disponible en lunes, jueves y viernes
('2024-11-11', 13, 0, 0, 1, 1, 1), -- Tortilla de Patatas disponible en miércoles, jueves y viernes
('2024-11-11', 14, 1, 1, 0, 1, 0), -- Sandwich Vegetariano disponible en lunes, martes y jueves
('2024-11-11', 15, 1, 1, 1, 0, 0), -- Ceviche disponible en lunes, martes y miércoles
('2024-11-11', 16, 0, 1, 1, 1, 0), -- Ravioles disponible en martes, miércoles y jueves
('2024-11-11', 17, 1, 0, 1, 0, 1), -- Spaghetti disponible en lunes, miércoles y viernes
('2024-11-11', 18, 1, 1, 1, 1, 1), -- Paella disponible todos los días
('2024-11-11', 19, 1, 1, 1, 0, 1), -- Lasagna disponible en lunes, martes, miércoles y viernes
('2024-11-11', 20, 1, 0, 1, 1, 0), -- Salmon Grillado disponible en lunes, miércoles y jueves
('2024-11-11', 21, 1, 1, 0, 1, 0), -- Sushi disponible en lunes, martes y jueves
('2024-11-11', 22, 1, 0, 1, 0, 1), -- Camarones disponible en lunes, miércoles y viernes
('2024-11-11', 23, 0, 1, 1, 1, 0), -- Carne Asada disponible en martes, miércoles y jueves
('2024-11-11', 24, 1, 1, 0, 1, 0), -- Pollo al Curry disponible en lunes, martes y jueves
('2024-11-11', 25, 0, 1, 0, 1, 1), -- Falafel disponible en martes, jueves y viernes
('2024-11-11', 26, 1, 1, 1, 1, 0), -- Shawarma disponible de lunes a jueves
('2024-11-11', 27, 1, 1, 1, 0, 0), -- Ratatouille disponible en lunes, martes y miércoles
('2024-11-11', 28, 1, 1, 0, 0, 1), -- Brochetas de Pollo disponible en lunes, martes y viernes
('2024-11-11', 29, 0, 1, 1, 0, 1), -- Quesadilla disponible en martes, miércoles y viernes
('2024-11-11', 30, 1, 0, 1, 1, 0), -- Churrasco disponible en lunes, miércoles y jueves
('2024-11-11', 31, 0, 0, 1, 1, 1), -- Tarta de Verduras disponible en miércoles, jueves y viernes
('2024-11-11', 32, 1, 1, 0, 1, 0), -- Pasta Alfredo disponible en lunes, martes y jueves
('2024-11-11', 33, 1, 0, 0, 1, 1), -- Papas Bravas disponible en lunes, jueves y viernes
('2024-11-11', 34, 0, 1, 1, 1, 0), -- Nachos disponible en martes, miércoles y jueves
('2024-11-11', 35, 1, 0, 1, 0, 1), -- Arepas disponible en lunes, miércoles y viernes
('2024-11-11', 36, 1, 1, 0, 1, 0), -- Tequeños disponible en lunes, martes y jueves
('2024-11-11', 37, 0, 1, 1, 1, 0), -- Croquetas disponible en martes, miércoles y jueves
('2024-11-11', 38, 1, 1, 0, 0, 1), -- Empanadas Arabes disponible en lunes, martes y viernes
('2024-11-11', 39, 0, 1, 1, 0, 1), -- Empanadas de Pollo disponible en martes, miércoles y viernes
('2024-11-11', 40, 1, 0, 0, 1, 1), -- Empanadas de Queso disponible en lunes, jueves y viernes
('2024-11-11', 41, 1, 1, 0, 1, 0), -- Empanadas de Carne disponible en lunes, martes y jueves
('2024-11-11', 42, 0, 1, 1, 1, 0), -- Empanadas de Jamón y Queso disponible en martes, miércoles y jueves
('2024-11-11', 43, 1, 1, 0, 0, 1), -- Empanadas de Espinaca disponible en lunes, martes y viernes
('2024-11-11', 44, 1, 1, 0, 1, 1), -- Empanadas Criollas disponible en lunes, martes, jueves y viernes
('2024-11-11', 45, 0, 1, 1, 0, 1), -- Empanadas de Calabaza disponible en martes, miércoles y viernes
('2024-11-11', 46, 1, 1, 0, 0, 1), -- Empanadas Caprese disponible en lunes, martes y viernes
('2024-11-11', 47, 1, 0, 1, 0, 1), -- Coca Zero disponible en lunes, miércoles y viernes
('2024-11-11', 48, 0, 1, 1, 1, 0), -- Fanta disponible en martes, miércoles y jueves
('2024-11-11', 49, 1, 1, 0, 0, 1), -- Sprite disponible en lunes, martes y viernes
('2024-11-11', 50, 1, 0, 1, 1, 0), -- Jugo de Naranja disponible en lunes, miércoles y jueves
('2024-11-11', 51, 1, 0, 1, 1, 1), -- Limonada disponible en lunes, miércoles, jueves y viernes
('2024-11-11', 52, 0, 1, 1, 0, 0), -- Té Helado disponible en martes y miércoles
('2024-11-11', 53, 1, 1, 0, 1, 1), -- Café disponible en lunes, martes, jueves y viernes
('2024-11-11', 54, 0, 1, 1, 1, 0), -- Chocolate Caliente disponible en martes, miércoles y jueves
('2024-11-11', 55, 1, 0, 0, 1, 1); -- Batido de Fresa disponible en lunes, jueves y viernes
