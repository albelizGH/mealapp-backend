CREATE TABLE `favoritos` (
	`cliente_id` BIGINT(19) NULL DEFAULT NULL,
	`plato_id` BIGINT(19) NULL DEFAULT NULL,
	INDEX `fk_cliente_favoritos` (`cliente_id`) USING BTREE,
	INDEX `fk_plato_favoritos` (`plato_id`) USING BTREE,
	CONSTRAINT `fk_cliente_favoritos` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT `fk_plato_favoritos` FOREIGN KEY (`plato_id`) REFERENCES `platos` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
