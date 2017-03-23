-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 23 Mars 2017 à 00:21
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
-- Structure de la table `language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `LanguageId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LanguageId`),
  UNIQUE KEY `LanguageId_UNIQUE` (`LanguageId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=86 ;

--
-- Vider la table avant d'insérer `language`
--

TRUNCATE TABLE `language`;
--
-- Contenu de la table `language`
--

INSERT INTO `language` (`LanguageId`, `Language`) VALUES
(1, 'Afrikaans'),
(2, 'Albanian'),
(3, 'American Sign Language'),
(4, 'Arabic'),
(5, 'Aramaic'),
(6, 'Assyrian Neo-Aramaic'),
(7, 'Bengali'),
(8, 'British Sign Language'),
(9, 'Bulgarian'),
(10, 'Cantonese'),
(11, 'Catalan'),
(12, 'Chechen'),
(13, 'Czech'),
(14, 'Danish'),
(15, 'Dutch'),
(16, 'English'),
(17, 'Esperanto'),
(18, 'Filipino'),
(19, 'Finnish'),
(20, 'French'),
(21, 'Gaelic'),
(22, 'Georgian'),
(23, 'German'),
(24, 'German Sign Language'),
(25, 'Greek'),
(26, 'Hebrew'),
(27, 'Hindi'),
(28, 'Hopi'),
(29, 'Hungarian'),
(30, 'Icelandic'),
(31, 'Inuktitut'),
(32, 'Irish Gaelic'),
(33, 'Italian'),
(34, 'Japanese'),
(35, 'Kandarian'),
(36, 'Karaja'),
(37, 'Khmer'),
(38, 'Klingon'),
(39, 'Korean'),
(40, 'Lao'),
(41, 'Latin'),
(42, 'Latvian'),
(43, 'Macedonian'),
(44, 'Malay'),
(45, 'Malayalam'),
(46, 'Maltese'),
(47, 'Mandarin'),
(48, 'Maori'),
(49, 'Mende'),
(50, 'More'),
(51, 'Nepali'),
(52, 'None'),
(53, 'Norwegian'),
(54, 'Pawnee'),
(55, 'Persian'),
(56, 'Polish'),
(57, 'Polynesian'),
(58, 'Portuguese'),
(59, 'Punjabi'),
(60, 'Romanian'),
(61, 'Romany'),
(62, 'Russian'),
(63, 'Serbo-Croatian'),
(64, 'Shanghainese'),
(65, 'Sindarin'),
(66, 'Sinhala'),
(67, 'Sioux'),
(68, 'Slovak'),
(69, 'Spanish'),
(70, 'Swahili'),
(71, 'Swedish'),
(72, 'Tagalog'),
(73, 'Tamil'),
(74, 'Thai'),
(75, 'Tibetan'),
(76, 'Turkish'),
(77, 'Ungwatsi'),
(78, 'Urdu'),
(79, 'Vietnamese'),
(80, 'Washoe'),
(81, 'Welsh'),
(82, 'Wolof'),
(83, 'Xhosa'),
(84, 'Yiddish'),
(85, 'Zulu');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
