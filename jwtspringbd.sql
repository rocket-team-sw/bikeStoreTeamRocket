-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2018 a las 14:29:14
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jwtspringbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3),
(3),
(3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `status_changes`
--

CREATE TABLE `status_changes` (
  `id` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `date_change_status` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ticket` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `user` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE `tickets` (
  `id` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `assigned_user` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `user` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `profile` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `profile`) VALUES
('1', 'cris@gmail.es', '$2a$10$0X6duP.zprKaFj6a3qhOcOGrBfP94LWVh7T4qeuGUrqZAJHMoI2cS', 0),
('2', 'Cristian.1701212362@ucaldas.edu.co', '$2a$10$uN5WvZBqXu9glrWzUQ6wneGPHtk8tBQXj0.G39hMHT5ZzMpi..qM.', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `status_changes`
--
ALTER TABLE `status_changes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbn029g7bt5ab9k69iktemvk51` (`ticket`),
  ADD KEY `FK80kwohti6t1ek5agumflisihs` (`user`);

--
-- Indices de la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe317qkhods9n7o80dc8vr0gwi` (`assigned_user`),
  ADD KEY `FKlydnex8t5yd51viecfllce0cu` (`user`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
