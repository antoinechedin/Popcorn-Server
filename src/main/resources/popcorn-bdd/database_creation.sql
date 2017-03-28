-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 25 Mars 2017 à 19:46
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `popcorn`
--
CREATE DATABASE IF NOT EXISTS `popcorn` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `popcorn`;

-- --------------------------------------------------------

--
-- Structure de la table `actor`
--

DROP TABLE IF EXISTS `actor`;
CREATE TABLE IF NOT EXISTS `actor` (
  `ActorId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `MovieQuantity` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ActorId`),
  UNIQUE KEY `ActorId_UNIQUE` (`ActorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=94928 ;

-- --------------------------------------------------------

--
-- Structure de la table `age`
--

DROP TABLE IF EXISTS `age`;
CREATE TABLE IF NOT EXISTS `age` (
  `AgeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MinAge` int(10) unsigned DEFAULT NULL,
  `MaxAge` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`AgeId`),
  UNIQUE KEY `AgeId_UNIQUE` (`AgeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=57 ;

-- --------------------------------------------------------

--
-- Structure de la table `color`
--

DROP TABLE IF EXISTS `color`;
CREATE TABLE IF NOT EXISTS `color` (
  `ColorId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ColorId`),
  UNIQUE KEY `ColorId_UNIQUE` (`ColorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `CountryId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Country` varchar(45) DEFAULT NULL,
  `LongName` varchar(100) DEFAULT NULL,
  `DomainCode` varchar(45) DEFAULT NULL,
  `Continent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CountryId`),
  UNIQUE KEY `CountryId_UNIQUE` (`CountryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=257 ;

-- --------------------------------------------------------

--
-- Structure de la table `countrycode`
--

DROP TABLE IF EXISTS `countrycode`;
CREATE TABLE IF NOT EXISTS `countrycode` (
  `CountryCode` varchar(45) NOT NULL,
  `CountryId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`CountryCode`),
  UNIQUE KEY `CountryCodeId_UNIQUE` (`CountryCode`),
  KEY `fk_country_idx` (`CountryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `director`
--

DROP TABLE IF EXISTS `director`;
CREATE TABLE IF NOT EXISTS `director` (
  `DirectorId`    INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `MovieQuantity` int(10) unsigned          DEFAULT NULL,
  `LastName`      varchar(45)               DEFAULT NULL,
  `FirstName`     varchar(45)               DEFAULT NULL,
  PRIMARY KEY (`DirectorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `distributor`
--

DROP TABLE IF EXISTS `distributor`;
CREATE TABLE IF NOT EXISTS `distributor` (
  `DistributorId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DistributionCompany` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DistributorId`),
  UNIQUE KEY `DistributorId_UNIQUE` (`DistributorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2392 ;

-- --------------------------------------------------------

--
-- Structure de la table `gender`
--

DROP TABLE IF EXISTS `gender`;
CREATE TABLE IF NOT EXISTS `gender` (
  `GenderId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`GenderId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `GenreId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Genre`   varchar(45)               DEFAULT NULL,
  PRIMARY KEY (`GenreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `keyword`
--

DROP TABLE IF EXISTS `keyword`;
CREATE TABLE IF NOT EXISTS `keyword` (
  `KeywordId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Keyword` varchar(45) DEFAULT NULL,
  `MovieQuantity` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`KeywordId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14975 ;

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

-- --------------------------------------------------------

--
-- Structure de la table `movieactor`
--

DROP TABLE IF EXISTS `movieactor`;
CREATE TABLE IF NOT EXISTS `movieactor` (
  `MovieActorLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `ActorId` int(10) unsigned NOT NULL,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MovieActorLinkId`),
  UNIQUE KEY `MovieActorLinkId_UNIQUE` (`MovieActorLinkId`),
  KEY `fk_movieActor_idx` (`ActorId`),
  KEY `fk_movieActor_idx1` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=158972 ;

-- --------------------------------------------------------

--
-- Structure de la table `moviecolor`
--

DROP TABLE IF EXISTS `moviecolor`;
CREATE TABLE IF NOT EXISTS `moviecolor` (
  `MovieId` int(10) unsigned NOT NULL,
  `ColorId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieId`),
  KEY `fk_color_idx` (`ColorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `moviecountry`
--

DROP TABLE IF EXISTS `moviecountry`;
CREATE TABLE IF NOT EXISTS `moviecountry` (
  `MovieCountryLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `CountryId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieCountryLinkId`),
  UNIQUE KEY `MovieCountryLinkId_UNIQUE` (`MovieCountryLinkId`),
  KEY `fk_movieCountry_idx` (`MovieId`),
  KEY `CountryId` (`CountryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4994 ;

-- --------------------------------------------------------

--
-- Structure de la table `moviedirector`
--

DROP TABLE IF EXISTS `moviedirector`;
CREATE TABLE IF NOT EXISTS `moviedirector` (
  `MovieDirectorLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `DirectorId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieDirectorLinkId`),
  UNIQUE KEY `MovieDirectorLinkId_UNIQUE` (`MovieDirectorLinkId`),
  KEY `fk_director_idx` (`DirectorId`),
  KEY `fk_MovieDirector_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4142 ;

-- --------------------------------------------------------

--
-- Structure de la table `moviedistributor`
--

DROP TABLE IF EXISTS `moviedistributor`;
CREATE TABLE IF NOT EXISTS `moviedistributor` (
  `MovieDistributorLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `DistributionCompanyId` int(10) unsigned NOT NULL,
  `CountryCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MovieDistributorLinkId`),
  UNIQUE KEY `MovieDistributorLinkId_UNIQUE` (`MovieDistributorLinkId`),
  KEY `fk_distributor_idx` (`DistributionCompanyId`),
  KEY `fk_distributorCountry_idx` (`CountryCode`),
  KEY `fk_movieDistributor_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23061 ;

-- --------------------------------------------------------

--
-- Structure de la table `moviegenre`
--

DROP TABLE IF EXISTS `moviegenre`;
CREATE TABLE IF NOT EXISTS `moviegenre` (
  `MovieGenreLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `GenreId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieGenreLinkId`),
  UNIQUE KEY `MovieGenreLinkId_UNIQUE` (`MovieGenreLinkId`),
  KEY `fk_genre_idx` (`GenreId`),
  KEY `fk_moviesGenres_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9289 ;

-- --------------------------------------------------------

--
-- Structure de la table `moviekeyword`
--

DROP TABLE IF EXISTS `moviekeyword`;
CREATE TABLE IF NOT EXISTS `moviekeyword` (
  `MovieKeywordLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `KeywordId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieKeywordLinkId`),
  UNIQUE KEY `MovieKeywordLinkId_UNIQUE` (`MovieKeywordLinkId`),
  KEY `fk_keyword_idx` (`KeywordId`),
  KEY `fk_movieKeyword_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=105129 ;

-- --------------------------------------------------------

--
-- Structure de la table `movielanguage`
--

DROP TABLE IF EXISTS `movielanguage`;
CREATE TABLE IF NOT EXISTS `movielanguage` (
  `MovieLanguageLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `LanguageId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieLanguageLinkId`),
  UNIQUE KEY `MovieLanguagesLinkId_UNIQUE` (`MovieLanguageLinkId`),
  KEY `fk_language_idx` (`LanguageId`),
  KEY `fk_movieLanguage_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4797 ;

-- --------------------------------------------------------

--
-- Structure de la table `movielink`
--

DROP TABLE IF EXISTS `movielink`;
CREATE TABLE IF NOT EXISTS `movielink` (
  `MovieLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `LinkedMovieId` int(10) unsigned NOT NULL,
  `LinkTypeId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieLinkId`),
  UNIQUE KEY `MovieLinkId_UNIQUE` (`MovieLinkId`),
  KEY `fk_linktype_idx` (`LinkTypeId`),
  KEY `fk_movieLink_idx` (`MovieId`),
  KEY `fk_movieLinked_idx` (`LinkedMovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18161 ;

-- --------------------------------------------------------

--
-- Structure de la table `movieproducer`
--

DROP TABLE IF EXISTS `movieproducer`;
CREATE TABLE IF NOT EXISTS `movieproducer` (
  `MovieProducerLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `ProducerId` int(10) unsigned NOT NULL,
  `ProducerInfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MovieProducerLinkId`),
  UNIQUE KEY `MovieProducerLinkId_UNIQUE` (`MovieProducerLinkId`),
  KEY `fk_producer_idx` (`ProducerId`),
  KEY `fk_movieProducer_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16750 ;

-- --------------------------------------------------------

--
-- Structure de la table `movieproductioncompany`
--

DROP TABLE IF EXISTS `movieproductioncompany`;
CREATE TABLE IF NOT EXISTS `movieproductioncompany` (
  `MovieProductionCompanyLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `CountryCode` varchar(45) DEFAULT NULL,
  `ProductionCompanyId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieProductionCompanyLinkId`),
  UNIQUE KEY `MovieProductionCompnyLinkId_UNIQUE` (`MovieProductionCompanyLinkId`),
  KEY `fk_productionCompaniesCountryCode_idx` (`CountryCode`),
  KEY `fk_movieProductionCompany_idx` (`MovieId`),
  KEY `fk_productionCompanyName_idx` (`ProductionCompanyId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9518 ;

-- --------------------------------------------------------

--
-- Structure de la table `movierating`
--

DROP TABLE IF EXISTS `movierating`;
CREATE TABLE IF NOT EXISTS `movierating` (
  `MovieId` int(10) unsigned NOT NULL,
  `Distribution` varchar(10) DEFAULT NULL,
  `Votes` int(10) unsigned DEFAULT NULL,
  `Rating` float unsigned DEFAULT NULL,
  PRIMARY KEY (`MovieId`),
  UNIQUE KEY `MovieId_UNIQUE` (`MovieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `MovieId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TitleMovieLens` varchar(100) DEFAULT NULL,
  `TitleIMDB` varchar(100) DEFAULT NULL,
  `Date` int(4) DEFAULT NULL,
  `totalScore` int default 0,
  `numberOfRantings` int default 0,
  PRIMARY KEY (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3953 ;

-- --------------------------------------------------------

--
-- Structure de la table `movietype`
--

DROP TABLE IF EXISTS `movietype`;
CREATE TABLE IF NOT EXISTS `movietype` (
  `MovieId` int(10) unsigned NOT NULL,
  `TypeId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieId`),
  KEY `fk_type_idx` (`TypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `moviewritter`
--

DROP TABLE IF EXISTS `moviewritter`;
CREATE TABLE IF NOT EXISTS `moviewritter` (
  `MovieWritterLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieId` int(10) unsigned NOT NULL,
  `WritterId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieWritterLinkId`),
  UNIQUE KEY `MovieWritterLinkId_UNIQUE` (`MovieWritterLinkId`),
  KEY `fk_writter_idx` (`WritterId`),
  KEY `fk_movieWritter_idx` (`MovieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8767 ;

-- --------------------------------------------------------

--
-- Structure de la table `producer`
--

DROP TABLE IF EXISTS `producer`;
CREATE TABLE IF NOT EXISTS `producer` (
  `ProducerId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `MovieQuantity` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ProducerId`),
  UNIQUE KEY `ProducerId_UNIQUE` (`ProducerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8143 ;

-- --------------------------------------------------------

--
-- Structure de la table `productor`
--

DROP TABLE IF EXISTS `productor`;
CREATE TABLE IF NOT EXISTS `productor` (
  `ProductorsId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ProductorCompany` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProductorsId`),
  UNIQUE KEY `ProductorsId_UNIQUE` (`ProductorsId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12022 ;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `TypeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) DEFAULT NULL,
  `TypeDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TypeId`),
  UNIQUE KEY `TypeId_UNIQUE` (`TypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Login` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Birthdate` date DEFAULT NULL,
  `GenderId` int(10) unsigned NOT NULL,
  `AgeId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`UserId`),
  KEY `fk_gender_idx` (`GenderId`),
  KEY `fk_ages_idx` (`AgeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6041 ;

--
-- Déclencheurs `user`
--
DROP TRIGGER IF EXISTS `trigger_password`;
DELIMITER //
CREATE TRIGGER `trigger_password` BEFORE INSERT ON `user`
 FOR EACH ROW BEGIN
SET new.Password = SHA1(new.Password);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `userrating`
--

DROP TABLE IF EXISTS `userrating`;
CREATE TABLE IF NOT EXISTS `userrating` (
  `UserRatingLinkId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserId` int(10) unsigned NOT NULL,
  `MovieId` int(10) unsigned NOT NULL,
  `Rating` int(10) unsigned DEFAULT NULL,
  `TimeStamp` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`UserRatingLinkId`),
  UNIQUE KEY `UserRatingLinkId_UNIQUE` (`UserRatingLinkId`),
  KEY `fk_movieUserRating_idx` (`MovieId`),
  KEY `fk_UserRating_idx` (`UserId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1000195 ;

-- --------------------------------------------------------

--
-- Structure de la table `writter`
--

DROP TABLE IF EXISTS `writter`;
CREATE TABLE IF NOT EXISTS `writter` (
  `WritterId` int(10) unsigned NOT NULL,
  `MovieQuantity` int(10) unsigned DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`WritterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `countrycode`
--
ALTER TABLE `countrycode`
  ADD CONSTRAINT `countrycode_ibfk_1` FOREIGN KEY (`CountryId`) REFERENCES `country` (`CountryId`);

--
-- Contraintes pour la table `movieactor`
--
ALTER TABLE `movieactor`
  ADD CONSTRAINT `movieactor_ibfk_2` FOREIGN KEY (`ActorId`) REFERENCES `actor` (`ActorId`),
  ADD CONSTRAINT `movieactor_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `moviecolor`
--
ALTER TABLE `moviecolor`
  ADD CONSTRAINT `moviecolor_ibfk_2` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`),
  ADD CONSTRAINT `moviecolor_ibfk_1` FOREIGN KEY (`ColorId`) REFERENCES `color` (`ColorId`);

--
-- Contraintes pour la table `moviecountry`
--
ALTER TABLE `moviecountry`
  ADD CONSTRAINT `moviecountry_ibfk_2` FOREIGN KEY (`CountryId`) REFERENCES `country` (`CountryId`),
  ADD CONSTRAINT `moviecountry_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `moviedirector`
--
ALTER TABLE `moviedirector`
  ADD CONSTRAINT `moviedirector_ibfk_2` FOREIGN KEY (`DirectorId`) REFERENCES `director` (`DirectorId`),
  ADD CONSTRAINT `moviedirector_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `moviedistributor`
--
ALTER TABLE `moviedistributor`
  ADD CONSTRAINT `moviedistributor_ibfk_3` FOREIGN KEY (`CountryCode`) REFERENCES `countrycode` (`CountryCode`),
  ADD CONSTRAINT `moviedistributor_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`),
  ADD CONSTRAINT `moviedistributor_ibfk_2` FOREIGN KEY (`DistributionCompanyId`) REFERENCES `distributor` (`DistributorId`);

--
-- Contraintes pour la table `moviegenre`
--
ALTER TABLE `moviegenre`
  ADD CONSTRAINT `moviegenre_ibfk_2` FOREIGN KEY (`GenreId`) REFERENCES `genre` (`GenreId`),
  ADD CONSTRAINT `moviegenre_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `moviekeyword`
--
ALTER TABLE `moviekeyword`
  ADD CONSTRAINT `moviekeyword_ibfk_2` FOREIGN KEY (`KeywordId`) REFERENCES `keyword` (`KeywordId`),
  ADD CONSTRAINT `moviekeyword_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `movielanguage`
--
ALTER TABLE `movielanguage`
  ADD CONSTRAINT `movielanguage_ibfk_2` FOREIGN KEY (`LanguageId`) REFERENCES `language` (`LanguageId`),
  ADD CONSTRAINT `movielanguage_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `movielink`
--
ALTER TABLE `movielink`
  ADD CONSTRAINT `movielink_ibfk_3` FOREIGN KEY (`LinkTypeId`) REFERENCES `linktype` (`LinkTypeId`),
  ADD CONSTRAINT `movielink_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`),
  ADD CONSTRAINT `movielink_ibfk_2` FOREIGN KEY (`LinkedMovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `movieproducer`
--
ALTER TABLE `movieproducer`
  ADD CONSTRAINT `movieproducer_ibfk_2` FOREIGN KEY (`ProducerId`) REFERENCES `producer` (`ProducerId`),
  ADD CONSTRAINT `movieproducer_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `movieproductioncompany`
--
ALTER TABLE `movieproductioncompany`
  ADD CONSTRAINT `movieproductioncompany_ibfk_3` FOREIGN KEY (`ProductionCompanyId`) REFERENCES `productor` (`ProductorsId`),
  ADD CONSTRAINT `movieproductioncompany_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`),
  ADD CONSTRAINT `movieproductioncompany_ibfk_2` FOREIGN KEY (`CountryCode`) REFERENCES `countrycode` (`CountryCode`);

--
-- Contraintes pour la table `movierating`
--
ALTER TABLE `movierating`
  ADD CONSTRAINT `movierating_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `movietype`
--
ALTER TABLE `movietype`
  ADD CONSTRAINT `movietype_ibfk_2` FOREIGN KEY (`TypeId`) REFERENCES `type` (`TypeId`),
  ADD CONSTRAINT `movietype_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `moviewritter`
--
ALTER TABLE `moviewritter`
  ADD CONSTRAINT `moviewritter_ibfk_2` FOREIGN KEY (`WritterId`) REFERENCES `writter` (`WritterId`),
  ADD CONSTRAINT `moviewritter_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`AgeId`) REFERENCES `age` (`AgeId`),
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`GenderId`) REFERENCES `gender` (`GenderId`);

--
-- Contraintes pour la table `userrating`
--
ALTER TABLE `userrating`
  ADD CONSTRAINT `userrating_ibfk_2` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`MovieId`),
  ADD CONSTRAINT `userrating_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`);

--
-- Déclencheurs `user`
--
DROP TRIGGER IF EXISTS `trigger_password`;
DELIMITER //
CREATE TRIGGER `trigger_password` BEFORE INSERT ON `user`
FOR EACH ROW BEGIN
  SET new.Password = SHA1(new.Password);
END
//
DELIMITER ;

--
-- Déclencheurs `userrating`
--
DROP TRIGGER IF EXISTS `trigger_rating_insert`;
DROP TRIGGER IF EXISTS `trigger_rating_delete`;
DROP TRIGGER IF EXISTS `trigger_rating_update`;
DELIMITER //
CREATE TRIGGER `trigger_rating_insert` AFTER INSERT ON `userrating` FOR EACH ROW
  BEGIN
    UPDATE  `movies` SET `movies`.numberOfRantings = `movies`.numberOfRantings + 1 WHERE `movies`.MovieId = NEW.MovieId;
    UPDATE  `movies` SET `movies`.totalScore = `movies`.totalScore + NEW.Rating WHERE `movies`.MovieId = NEW.MovieId;
  END //

CREATE TRIGGER `trigger_rating_delete` AFTER DELETE ON `userrating` FOR EACH ROW
  BEGIN
    UPDATE  `movies` SET `movies`.numberOfRantings = `movies`.numberOfRantings - 1 WHERE `movies`.MovieId = OLD.MovieId;
    UPDATE  `movies` SET `movies`.totalScore = `movies`.totalScore - OLD.Rating WHERE `movies`.MovieId = OLD.MovieId;
  END //

CREATE TRIGGER `trigger_rating_update` AFTER UPDATE ON `userrating` FOR EACH ROW
  BEGIN
    IF OLD.MovieId = NEW.MovieId THEN
      UPDATE  `movies` SET `movies`.totalScore = `movies`.totalScore - OLD.Rating + NEW.Rating WHERE `movies`.MovieId = NEW.MovieId;
    ELSE
      UPDATE  `movies` SET `movies`.totalScore = `movies`.totalScore - OLD.Rating WHERE `movies`.MovieId = OLD.MovieId;
      UPDATE  `movies` SET `movies`.numberOfRantings = `movies`.numberOfRantings - 1 WHERE `movies`.MovieId = OLD.MovieId;

      UPDATE  `movies` SET `movies`.totalScore = `movies`.totalScore + NEW.Rating WHERE `movies`.MovieId = NEW.MovieId;
      UPDATE  `movies` SET `movies`.numberOfRantings = `movies`.numberOfRantings + 1 WHERE `movies`.MovieId = NEW.MovieId;
    END IF;
  END //
DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
