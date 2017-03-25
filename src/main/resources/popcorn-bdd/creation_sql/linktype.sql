-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 23 Mars 2017 à 00:23
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
-- Structure de la table `linktype`
--

DROP TABLE IF EXISTS `linktype`;
CREATE TABLE IF NOT EXISTS `linktype` (
  `LinkTypeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LinkType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LinkTypeId`),
  UNIQUE KEY `LinkTypeId_UNIQUE` (`LinkTypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Vider la table avant d'insérer `linktype`
--

TRUNCATE TABLE `linktype`;
--
-- Contenu de la table `linktype`
--

INSERT INTO `linktype` (`LinkTypeId`, `LinkType`) VALUES
(1, 'alternate language version of'),
(2, 'edited from'),
(3, 'edited into'),
(4, 'featured in'),
(5, 'features'),
(6, 'followed by'),
(7, 'follows'),
(8, 'referenced in'),
(9, 'references'),
(10, 'remade as'),
(11, 'remake of'),
(12, 'spin off'),
(13, 'spoofed in'),
(14, 'spoofs'),
(15, 'version of');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
