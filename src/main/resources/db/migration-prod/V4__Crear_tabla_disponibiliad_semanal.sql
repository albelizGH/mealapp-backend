CREATE TABLE `disponibilidad_semanal` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`semana_inicio` DATE NULL ,-- Primer día de la semana
	`plato_id` BIGINT(19) NOT NULL DEFAULT '0',
	`lunes` TINYINT(3) NOT NULL DEFAULT '0',
	`martes` TINYINT(3) NOT NULL DEFAULT '0',
	`miercoles` TINYINT(3) NOT NULL DEFAULT '0',
	`jueves` TINYINT(3) NOT NULL DEFAULT '0',
	`viernes` TINYINT(3) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `plato_id_disponibilidad` (`plato_id`) USING BTREE,
	CONSTRAINT `plato_id_disponibilidad` FOREIGN KEY (`plato_id`) REFERENCES `platos` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;