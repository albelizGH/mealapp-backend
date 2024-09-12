CREATE TABLE `detalles_pedidos` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`comentario` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`cantidad` TINYINT(3) NOT NULL,
	`pedido_dia_id` BIGINT(19) NULL DEFAULT NULL,
	`plato_id` BIGINT(19) NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fk_pedido_dia` (`pedido_dia_id`) USING BTREE,
	INDEX `fk_plato` (`plato_id`) USING BTREE,
	CONSTRAINT `FK_detalles_pedidos_pedidos_dia` FOREIGN KEY (`pedido_dia_id`) REFERENCES `pedidos_dia` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT `fk_plato` FOREIGN KEY (`plato_id`) REFERENCES `platos` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
