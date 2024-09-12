CREATE TABLE `pedidos` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`fecha_pedido` DATE NOT NULL,
    `semana_entrega` DATE NOT NULL,  -- Primer día de la semana de entrega
	`estado` ENUM('Pendiente','Confirmado','Entregado') NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`cliente_id` BIGINT(19) NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `cliente_id` (`cliente_id`) USING BTREE,
	CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT `chk_fecha_entrega` CHECK (`semana_entrega` > `fecha_pedido`)

)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
