-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2015 a las 11:50:53
-- Versión del servidor: 5.5.36
-- Versión de PHP: 5.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `videoclub`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE IF NOT EXISTS `peliculas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `duracion` int(11) NOT NULL,
  `director` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`titulo`, `genero`, `duracion`, `director`) VALUES
('Tomorrowland: El mundo del mañana', 'Ciencia Ficción', 135, 'Brad Bird'),
('It Follows', 'Terror', 100, 'David Robert Mitchell'),
('¡Upss! ¿donde esta Noe...?', 'Animación, Aventuras, Comedia', 85, 'Toby Genkel, Sean McCormack'),
('52 Martes', 'Drama, Familiar', 109, 'Sophie Hyde'),
('Caza al asesino', 'Acción, Crimen, Drama, Misterio, Thriller', 105, 'Pierre Morel'),
('El amanecer', 'acción', 134, 'yo');

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idPelicula` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `socio` varchar(45) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reservas_1_idx` (`idPelicula`),
  CONSTRAINT `fk_reservas_1` FOREIGN KEY (`idPelicula`) REFERENCES `peliculas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,10,'2020-05-01','Pepe'),(2,10,'2020-05-10','Juan'),(3,11,'2020-05-01','Rosa'),(4,12,'2020-05-02','Inma'),(5,13,'2020-05-03','Pepe');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
