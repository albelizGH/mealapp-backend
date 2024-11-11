-- Insertar días de pedidos con fecha_entrega
INSERT INTO `pedidos_diarios` (`pedido_id`, `dia`, `fecha_entrega`) VALUES
(1, 'Lunes', '2024-11-18'),       -- Pedido 1, entrega el lunes siguiente
(1, 'Miércoles', '2024-11-20'),   -- Pedido 1, entrega el miércoles siguiente
(2, 'Martes', '2024-11-19'),      -- Pedido 2, entrega el martes siguiente
(2, 'Viernes', '2024-11-22');     -- Pedido 2, entrega el viernes siguiente
