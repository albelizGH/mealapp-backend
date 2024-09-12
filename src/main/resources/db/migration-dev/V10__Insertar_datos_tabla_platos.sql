-- Insertar platos
INSERT INTO `platos` (`nombre`, `descripcion`, `imagen`, `cantidad_maxima`, `stock`, `cantidad_veces_pedido`, `tipo_plato_id`) VALUES
('Milanesa', 'Milanesa de carne con pan rallado', 'http://example.com/milanesa.jpg', 1, 50, 30, 1),  -- Plato: Milanesa, Tipo: Plato
('Papas Fritas', 'Papas fritas crocantes', 'http://example.com/papas.jpg', 1, 80, 45, 2),       -- Plato: Papas Fritas, Tipo: Complemento
('Coca Cola', 'Bebida gaseosa', 'http://example.com/coca.jpg', 1, 100, 60, 3),                 -- Plato: Coca Cola, Tipo: Bebida
('Pollo Asado', 'Pollo asado con especias', 'http://example.com/pollo.jpg', 1, 40, 20, 1),       -- Plato: Pollo Asado, Tipo: Plato
('Ensalada', 'Ensalada fresca con vegetales', 'http://example.com/ensalada.jpg', 1, 60, 25, 2),  -- Plato: Ensalada, Tipo: Complemento
('Agua', 'Agua mineral', 'http://example.com/agua.jpg', 1, 120, 70, 3),                        -- Plato: Agua, Tipo: Bebida
('Empanadas', 'Empanadas variadas', 'http://example.com/empanadas.jpg', 2, 70, 50, 1);         -- Plato: Empanadas, Tipo: Plato