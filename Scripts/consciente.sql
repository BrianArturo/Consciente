-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-08-2020 a las 16:24:40
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consciente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `id` int(100) NOT NULL,
  `nit` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `contacto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `nit`, `nombre`, `direccion`, `telefono`, `contacto`) VALUES
(1, '999999999', 'Nombre', 'Direccion', '3333333', '34444444'),
(2, '88888888', 'Nombre', 'Direccion', '34455667', '31111111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(100) NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `nombre`) VALUES
(1, '001', 'Producto1'),
(2, '001', 'Producto2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopolizas`
--

CREATE TABLE `tipopolizas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `creada` date NOT NULL DEFAULT current_timestamp(),
  `modificada` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipopolizas`
--

INSERT INTO `tipopolizas` (`id`, `nombre`, `creada`, `modificada`) VALUES
(1, 'Nueva', '0000-00-00', '0000-00-00'),
(2, 'Renovaciòn', '0000-00-00', '0000-00-00'),
(3, 'Inclusiòn', '0000-00-00', '0000-00-00'),
(4, 'Modificaciòn', '0000-00-00', '0000-00-00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
