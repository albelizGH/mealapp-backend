-- Insertar detalles de pedidos para el cliente con ID 1
INSERT INTO `detalles_pedidos` (`comentario`, `cantidad`, `pedido_dia_id`, `plato_id`) VALUES
('Sin comentarios', 2, 1, 1), -- 2 Milanesa en el pedido del lunes (pedido_dia_id = 1)
('Extra crujiente', 1, 1, 2), -- 1 Papas Fritas en el pedido del lunes (pedido_dia_id = 1)
('Acompañar con salsa', 3, 2, 5); -- 3 Ensalada en el pedido del miércoles (pedido_dia_id = 2)

-- Insertar detalles de pedidos para el cliente con ID 2
INSERT INTO `detalles_pedidos` (`comentario`, `cantidad`, `pedido_dia_id`, `plato_id`) VALUES
('Sin hielo', 2, 3, 3), -- 2 Coca Cola en el pedido del martes (pedido_dia_id = 3)
('Con limón', 1, 3, 4), -- 1 Pollo Asado en el pedido del martes (pedido_dia_id = 3)
('Acompañar con salsa', 1, 4, 5); -- 1 Ensalada en el pedido del viernes (pedido_dia_id = 4)
