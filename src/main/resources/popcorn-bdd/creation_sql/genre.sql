-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 23 Mars 2017 à 00:13
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `popcorn`
--

-- --------------------------------------------------------

--
-- Vider la table avant d'insérer `genre`
--

TRUNCATE TABLE `genre`;
--
-- Contenu de la table `genre`
--

INSERT INTO `genre` (`GenreId`, `Genre`) VALUES
(1, 'Action'),
(2, 'Adult'),
(3, 'Adventure'),
(4, 'Animation'),
(5, 'Biography'),
(6, 'Comedy'),
(7, 'Crime'),
(8, 'Documentary'),
(9, 'Drama'),
(10, 'Family'),
(11, 'Fantasy'),
(12, 'Film-Noir'),
(13, 'History'),
(14, 'Horror'),
(15, 'Music'),
(16, 'Musical'),
(17, 'Mystery'),
(18, 'Reality-TV'),
(19, 'Romance'),
(20, 'Sci-Fi'),
(21, 'Short'),
(22, 'Sport'),
(23, 'Thriller'),
(24, 'War'),
(25, 'Western');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
