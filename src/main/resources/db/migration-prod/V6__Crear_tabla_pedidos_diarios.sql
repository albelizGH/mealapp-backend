CREATE TABLE `pedidos_diarios` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`pedido_id` BIGINT(19) NULL DEFAULT NULL,
	`dia` ENUM('Lunes','Martes','Miercoles','Jueves','Viernes') NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `fecha_entrega` DATE NOT NULL,
	`estado` ENUM('Pendiente','Listo','Entregado') DEFAULT 'Pendiente' COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fk_pedido` (`pedido_id`) USING BTREE,
	CONSTRAINT `fk_pedido` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos_semanales` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
