-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para virtualfarma
CREATE DATABASE IF NOT EXISTS `virtualfarma` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `virtualfarma`;

-- Volcando estructura para tabla virtualfarma.farmacias
CREATE TABLE IF NOT EXISTS `farmacias` (
  `CIF` varchar(255) NOT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `Horario` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `NombreDueno` varchar(255) DEFAULT NULL,
  `NumeroCuenta` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla virtualfarma.farmacias: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `farmacias` DISABLE KEYS */;
/*!40000 ALTER TABLE `farmacias` ENABLE KEYS */;

-- Volcando estructura para tabla virtualfarma.medicos
CREATE TABLE IF NOT EXISTS `medicos` (
  `DNI` varchar(255) NOT NULL,
  `CentroMedico` varchar(255) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `NumeroSS` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla virtualfarma.medicos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;

-- Volcando estructura para tabla virtualfarma.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `DNI` varchar(255) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `NumeroSS` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla virtualfarma.pacientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;

-- Volcando estructura para tabla virtualfarma.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `Cuantia` int(11) DEFAULT NULL,
  `Precio` bigint(20) DEFAULT NULL,
  `CIF_Farmacia` varchar(255) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`CIF_Farmacia`,`Nombre`),
  CONSTRAINT `FK_productos_CIF_Farmacia` FOREIGN KEY (`CIF_Farmacia`) REFERENCES `farmacias` (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla virtualfarma.productos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Volcando estructura para tabla virtualfarma.recetas
CREATE TABLE IF NOT EXISTS `recetas` (
  `Cronica` tinyint(1) DEFAULT '0',
  `Duracion` varchar(255) DEFAULT NULL,
  `Frecuencia` int(11) DEFAULT NULL,
  `Instrucciones` varchar(255) DEFAULT NULL,
  `NumEnvases` int(11) DEFAULT NULL,
  `UnidadesToma` double DEFAULT NULL,
  `Fecha` date NOT NULL,
  `DNI_Medico` varchar(255) NOT NULL,
  `NombreMedicamento` varchar(255) NOT NULL,
  `DNI_Paciente` varchar(255) NOT NULL,
  PRIMARY KEY (`Fecha`,`DNI_Medico`,`NombreMedicamento`,`DNI_Paciente`),
  KEY `FK_recetas_DNI_Medico` (`DNI_Medico`),
  KEY `FK_recetas_DNI_Paciente` (`DNI_Paciente`),
  CONSTRAINT `FK_recetas_DNI_Medico` FOREIGN KEY (`DNI_Medico`) REFERENCES `medicos` (`DNI`),
  CONSTRAINT `FK_recetas_DNI_Paciente` FOREIGN KEY (`DNI_Paciente`) REFERENCES `pacientes` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla virtualfarma.recetas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `recetas` DISABLE KEYS */;
/*!40000 ALTER TABLE `recetas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
