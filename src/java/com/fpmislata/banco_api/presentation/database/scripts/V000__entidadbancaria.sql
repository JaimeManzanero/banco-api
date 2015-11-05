CREATE TABLE IF NOT EXISTS `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`codigoEntidad` INT(11) NULL DEFAULT NULL,
	`fechaCreacion` DATETIME NULL DEFAULT NULL,
	`direccion` VARCHAR(50) NULL DEFAULT NULL,
	`CIF` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidad`, `fechaCreacion`, `direccion`, `CIF`) VALUES
	(null, 'Soy un pro', 666, '2015-10-28 00:00:00', 'Mi calle (de pros)', 'pro+1'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'juan', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'EXITOOOOOOO', 28, '2015-10-28 00:00:00', 'calle falsa', 'asd'),
	(null, 'pro', 3, '2015-10-29 00:00:00', 'Mi calle', 'pro');
