-- Insertar platos
INSERT INTO `platos` (`nombre`, `descripcion`,`etiqueta`, `imagen`, `cantidad_maxima`, `stock`, `cantidad_veces_pedido`, `tipo_plato_id`) VALUES
('Milanesa','Milanesa de carne con pan rallado','Carne', 'http://example.com/milanesa.jpg', 1, 50, 30, 1),  -- Plato: Milanesa, Tipo: Plato
('Papas Fritas','Papas fritas crocantes','Papas', 'http://example.com/papas.jpg', 1, 80, 45, 2),       -- Plato: Papas Fritas, Tipo: Complemento
('Coca Cola','Bebida gaseosa','Gaseosa', 'http://example.com/coca.jpg', 1, 100, 60, 3),                 -- Plato: Coca Cola, Tipo: Bebida
('Pollo Asado', 'Pollo asado con especias','Carne', 'http://example.com/pollo.jpg', 1, 40, 20, 1),       -- Plato: Pollo Asado, Tipo: Plato
('Ensalada', 'Ensalada fresca con vegetales','Ensalada', 'http://example.com/ensalada.jpg', 1, 60, 25, 2),  -- Plato: Ensalada, Tipo: Complemento
('Agua', 'Agua mineral','Agua','http://example.com/agua.jpg', 1, 120, 70, 3),                        -- Plato: Agua, Tipo: Bebida
('Empanadas', 'Empanadas variadas','Empanada','http://example.com/empanadas.jpg', 2, 70, 50, 1);         -- Plato: Empanadas, Tipo: Plato

-- Insertar 50 platos adicionales
INSERT INTO `platos` (`nombre`, `descripcion`, `etiqueta`, `imagen`, `cantidad_maxima`, `stock`, `cantidad_veces_pedido`, `tipo_plato_id`) VALUES
('Tacos', 'Tacos mexicanos con carne y guacamole', 'Carne', 'http://example.com/tacos.jpg', 1, 60, 35, 1),
('Hamburguesa', 'Hamburguesa con queso y bacon', 'Carne', 'http://example.com/hamburguesa.jpg', 1, 50, 30, 1),
('Sopa de Pollo', 'Sopa casera de pollo y fideos', 'Sopa', 'http://example.com/sopa.jpg', 1, 40, 20, 1),
('Pizza', 'Pizza de queso y tomate', 'Pizza', 'http://example.com/pizza.jpg', 1, 70, 50, 1),
('Fajitas', 'Fajitas de pollo con vegetales', 'Carne', 'http://example.com/fajitas.jpg', 1, 50, 25, 1),
('Tortilla de Patatas', 'Tortilla española con patatas y cebolla', 'Tortilla', 'http://example.com/tortilla.jpg', 1, 60, 30, 1),
('Sandwich Vegetariano', 'Sandwich con aguacate, lechuga y tomate', 'Vegetariano', 'http://example.com/sandwich.jpg', 1, 40, 20, 1),
('Ceviche', 'Ceviche de pescado fresco', 'Pescado', 'http://example.com/ceviche.jpg', 1, 30, 15, 1),
('Ravioles', 'Ravioles de carne con salsa de tomate', 'Pasta', 'http://example.com/ravioles.jpg', 1, 80, 45, 1),
('Spaghetti', 'Spaghetti con salsa boloñesa', 'Pasta', 'http://example.com/spaghetti.jpg', 1, 90, 50, 1),
('Paella', 'Paella de mariscos y arroz', 'Arroz', 'http://example.com/paella.jpg', 1, 45, 25, 1),
('Lasagna', 'Lasagna de carne y queso', 'Pasta', 'http://example.com/lasagna.jpg', 1, 50, 30, 1),
('Salmon Grillado', 'Salmon grillado con espárragos', 'Pescado', 'http://example.com/salmon.jpg', 1, 35, 15, 1),
('Sushi', 'Rollos de sushi con salmón y aguacate', 'Pescado', 'http://example.com/sushi.jpg', 1, 70, 40, 1),
('Camarones', 'Camarones al ajillo con arroz', 'Pescado', 'http://example.com/camarones.jpg', 1, 60, 35, 1),
('Carne Asada', 'Carne asada con chimichurri', 'Carne', 'http://example.com/carne_asada.jpg', 1, 50, 30, 1),
('Pollo al Curry', 'Pollo al curry con arroz', 'Carne', 'http://example.com/pollo_curry.jpg', 1, 40, 20, 1),
('Falafel', 'Falafel con hummus y ensalada', 'Vegetariano', 'http://example.com/falafel.jpg', 1, 30, 15, 1),
('Shawarma', 'Shawarma de cordero con ensalada', 'Carne', 'http://example.com/shawarma.jpg', 1, 50, 25, 1),
('Ratatouille', 'Ratatouille de vegetales', 'Vegetariano', 'http://example.com/ratatouille.jpg', 1, 40, 20, 1),
('Brochetas de Pollo', 'Brochetas de pollo con pimientos', 'Carne', 'http://example.com/brochetas.jpg', 1, 60, 35, 1),
('Quesadilla', 'Quesadilla de queso y pollo', 'Carne', 'http://example.com/quesadilla.jpg', 1, 50, 30, 1),
('Churrasco', 'Churrasco con chimichurri', 'Carne', 'http://example.com/churrasco.jpg', 1, 70, 40, 1),
('Tarta de Verduras', 'Tarta de espinaca y queso', 'Vegetariano', 'http://example.com/tarta.jpg', 1, 30, 15, 1),
('Pasta Alfredo', 'Pasta con salsa Alfredo', 'Pasta', 'http://example.com/alfredo.jpg', 1, 50, 30, 1),
('Papas Bravas', 'Papas fritas con salsa picante', 'Papas', 'http://example.com/papas_bravas.jpg', 1, 60, 35, 2),
('Nachos', 'Nachos con queso y guacamole', 'Snacks', 'http://example.com/nachos.jpg', 1, 50, 25, 2),
('Arepas', 'Arepas venezolanas rellenas de queso', 'Snacks', 'http://example.com/arepas.jpg', 1, 40, 20, 2),
('Tequeños', 'Tequeños rellenos de queso', 'Snacks', 'http://example.com/tequenos.jpg', 1, 30, 15, 2),
('Croquetas', 'Croquetas de jamón y queso', 'Snacks', 'http://example.com/croquetas.jpg', 1, 70, 45, 2),
('Empanadas Arabes', 'Empanadas de carne estilo árabe', 'Empanada', 'http://example.com/empanadas_arabes.jpg', 2, 80, 55, 1),
('Empanadas de Pollo', 'Empanadas de pollo y especias', 'Empanada', 'http://example.com/empanadas_pollo.jpg', 2, 75, 50, 1),
('Empanadas de Queso', 'Empanadas de queso y cebolla', 'Empanada', 'http://example.com/empanadas_queso.jpg', 2, 90, 65, 1),
('Empanadas de Carne', 'Empanadas de carne picante', 'Empanada', 'http://example.com/empanadas_carne.jpg', 2, 100, 70, 1),
('Empanadas de Jamón y Queso', 'Empanadas de jamón y queso', 'Empanada', 'http://example.com/empanadas_jamon_queso.jpg', 2, 85, 60, 1),
('Empanadas de Espinaca', 'Empanadas de espinaca y ricota', 'Empanada', 'http://example.com/empanadas_espinaca.jpg', 2, 90, 50, 1),
('Empanadas Criollas', 'Empanadas criollas de carne y huevo', 'Empanada', 'http://example.com/empanadas_criollas.jpg', 2, 95, 55, 1),
('Empanadas de Calabaza', 'Empanadas de calabaza y queso', 'Empanada', 'http://example.com/empanadas_calabaza.jpg', 2, 80, 45, 1),
('Empanadas Caprese', 'Empanadas de tomate, mozzarella y albahaca', 'Empanada', 'http://example.com/empanadas_caprese.jpg', 2, 85, 60, 1),
('Coca Zero', 'Bebida gaseosa sin azúcar', 'Gaseosa', 'http://example.com/coca_zero.jpg', 1, 100, 60, 3),
('Fanta', 'Bebida gaseosa de naranja', 'Gaseosa', 'http://example.com/fanta.jpg', 1, 90, 50, 3),
('Sprite', 'Bebida gaseosa de limón', 'Gaseosa', 'http://example.com/sprite.jpg', 1, 80, 45, 3),
('Jugo de Naranja', 'Jugo de naranja natural', 'Jugo', 'http://example.com/jugo_naranja.jpg', 1, 70, 40, 3),
('Limonada', 'Limonada fresca', 'Jugo', 'http://example.com/limonada.jpg', 1, 60, 35, 3),
('Té Helado', 'Té helado con limón', 'Bebida', 'http://example.com/te_helado.jpg', 1, 50, 30, 3),
('Café', 'Café negro americano', 'Bebida', 'http://example.com/cafe.jpg', 1, 40, 25, 3),
('Chocolate Caliente', 'Chocolate caliente con crema', 'Bebida', 'http://example.com/chocolate.jpg', 1, 30, 20, 3),
('Batido de Fresa', 'Batido de fresa con leche', 'Batido', 'http://example.com/batido_fresa.jpg', 1, 50, 35, 3);
