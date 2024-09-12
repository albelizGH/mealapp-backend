CREATE TABLE `platos` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`descripcion` TEXT NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`imagen` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`cantidad_maxima` TINYINT(3) NOT NULL,
	`stock` INT(10) NULL DEFAULT '0',
	`cantidad_veces_pedido` INT(10) NOT NULL,
	`tipo_plato_id` BIGINT(19) NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fk_tipo_plato` (`tipo_plato_id`) USING BTREE,
	CONSTRAINT `fk_tipo_plato` FOREIGN KEY (`tipo_plato_id`) REFERENCES `tipos_plato` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
