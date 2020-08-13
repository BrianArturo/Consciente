-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-08-2020 a las 16:20:04
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
(2, '001', 'Producto2'),
(3, '005', 'Rojo'),
(4, '004', 'Verde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoclientes`
--

CREATE TABLE `tipoclientes` (
  `id` int(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `otro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipoclientes`
--

INSERT INTO `tipoclientes` (`id`, `nombre`, `otro`) VALUES
(1, 'Empresarial', ''),
(2, 'Personal', '');

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `identificacion` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `clave` varchar(250) NOT NULL,
  `rol` enum('SuperAdmin','Admin','Poliza','') NOT NULL,
  `fechaCreado` date NOT NULL DEFAULT current_timestamp(),
  `fechaModificado` date NOT NULL DEFAULT current_timestamp(),
  `estado` enum('Activo','Inactivo','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `nombre`, `identificacion`, `user`, `clave`, `rol`, `fechaCreado`, `fechaModificado`, `estado`) VALUES
(1, 'Super Admin', '111111', 'Jhon', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'SuperAdmin', '2020-08-13', '2020-08-13', 'Activo'),
(2, 'Admin', '222222', 'Doe', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Admin', '2020-08-13', '2020-08-13', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
