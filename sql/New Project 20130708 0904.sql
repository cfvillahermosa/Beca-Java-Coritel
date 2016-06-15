-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.61-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema festivaldb
--

CREATE DATABASE IF NOT EXISTS festivaldb;
USE festivaldb;

--
-- Definition of table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `places` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `event_type` varchar(45) NOT NULL,
  `seats_available` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` (`id`,`name`,`description`,`places`,`duration`,`event_type`,`seats_available`) VALUES 
 (1,'Evento 1','Descripcion Evento 1','Place 1','0900-1100','Type 1',10),
 (2,'Evento 2','Descripcion Evento 2','Place 2','1100-1200','Type 2',2);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;


--
-- Definition of table `events_signup`
--

DROP TABLE IF EXISTS `events_signup`;
CREATE TABLE `events_signup` (
  `id` int(10) unsigned NOT NULL ,
  `event_id` int(10) unsigned NOT NULL,
  `visitor_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_event_signup_1` (`event_id`),
  KEY `FK_event_signup_2` (`visitor_id`),
  CONSTRAINT `FK_event_signup_1` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FK_event_signup_2` FOREIGN KEY (`visitor_id`) REFERENCES `visitors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events_signup`
--

/*!40000 ALTER TABLE `events_signup` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_signup` ENABLE KEYS */;


--
-- Definition of table `visitors`
--

DROP TABLE IF EXISTS `visitors`;
CREATE TABLE `visitors` (
  `id` int(10) unsigned NOT NULL ,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(15) NOT NULL,
  `isadmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visitors`
--

/*!40000 ALTER TABLE `visitors` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitors` ENABLE KEYS */;


--
-- Definition of table `sequencer`
--
DROP TABLE IF EXISTS `festivaldb`.`sequencer`;
CREATE TABLE  `festivaldb`.`sequencer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `value` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequencer`
--

/*!40000 ALTER TABLE `sequencer` DISABLE KEYS */;
INSERT INTO `sseats_availableseats_availableseats_availableequencer` (`id`,`name`,`value`) VALUES 
 (1,'event',0),
 (2,'visitor',0),
 (3,'event_signup',0);
/*!40000 ALTER TABLE `sequencer` ENABLE KEYS */;





/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
