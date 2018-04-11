-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Servidor: sql11.freemysqlhosting.net
-- Tiempo de generación: 27-01-2017 a las 13:02:10
-- Versión del servidor: 5.5.53-0ubuntu0.14.04.1
-- Versión de PHP: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sql11155835`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Farmacias`
--
-- Creación: 27-01-2017 a las 12:28:28
--

CREATE TABLE IF NOT EXISTS `Farmacias` (
  `CIF` varchar(9) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Horario` varchar(200) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `NumeroCuenta` varchar(24) NOT NULL,
  `NombreDueno` varchar(100) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `email` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Medicos`
--
-- Creación: 27-01-2017 a las 12:33:59
--

CREATE TABLE IF NOT EXISTS `Medicos` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `NumeroSS` varchar(12) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `email` varchar(20) NOT NULL,
  `CentroMedico` varchar(100) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pacientes`
--
-- Creación: 27-01-2017 a las 12:24:58
--

CREATE TABLE IF NOT EXISTS `Pacientes` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `NumeroSS` varchar(12) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Productos`
--
-- Creación: 27-01-2017 a las 12:39:02
--

CREATE TABLE IF NOT EXISTS `Productos` (
  `CIF_Farmacia` varchar(9) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Precio` decimal(10,0) NOT NULL,
  `Cuantia` int(11) NOT NULL,
  PRIMARY KEY (`CIF_Farmacia`,`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Recetas`
--
-- Creación: 27-01-2017 a las 13:00:23
--

CREATE TABLE IF NOT EXISTS `Recetas` (
  `DNI_Paciente` varchar(9) NOT NULL,
  `DNI_Medico` varchar(9) NOT NULL,
  `NombreMedicamento` varchar(100) NOT NULL,
  `Cronica` tinyint(1) NOT NULL,
  `Fecha` date NOT NULL,
  `UnidadesToma` double NOT NULL,
  `Frecuencia` int(11) NOT NULL,
  `Duracion` varchar(50) NOT NULL,
  `Instrucciones` varchar(200) NOT NULL,
  `NumEnvases` int(11) NOT NULL,
  PRIMARY KEY (`DNI_Paciente`,`DNI_Medico`,`NombreMedicamento`,`Fecha`),
  KEY `DNI_Medico` (`DNI_Medico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Productos`
--
ALTER TABLE `Productos`
  ADD CONSTRAINT `Productos_ibfk_1` FOREIGN KEY (`CIF_Farmacia`) REFERENCES `Farmacias` (`CIF`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Recetas`
--
ALTER TABLE `Recetas`
  ADD CONSTRAINT `Recetas_ibfk_2` FOREIGN KEY (`DNI_Medico`) REFERENCES `Medicos` (`DNI`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Recetas_ibfk_1` FOREIGN KEY (`DNI_Paciente`) REFERENCES `Pacientes` (`DNI`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
