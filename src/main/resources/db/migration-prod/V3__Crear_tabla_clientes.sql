CREATE TABLE `clientes` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`apellido` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`documento` VARCHAR(20) NOT NULL,
	`correo` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`contrasenia` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`activo` TINYINT DEFAULT '1',
	`lunes` TINYINT(3) NOT NULL DEFAULT '0',
	`martes` TINYINT(3) NOT NULL DEFAULT '0',
	`miercoles` TINYINT(3) NOT NULL DEFAULT '0',
	`jueves` TINYINT(3) NOT NULL DEFAULT '0',
	`viernes` TINYINT(3) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `correo` (`correo`) USING BTREE,
	UNIQUE INDEX `documento` (`documento`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;