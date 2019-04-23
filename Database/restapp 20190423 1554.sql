-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.48


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema restapp
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ restapp;
USE restapp;

--
-- Table structure for table `restapp`.`city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(45) NOT NULL,
  `stateId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cityId`),
  UNIQUE KEY `UK_m2369jxf8n1cvy0fujk6nt6li` (`cityName`),
  KEY `FK10l334hxh0vd9a5ainlulk64r` (`stateId`),
  CONSTRAINT `FK10l334hxh0vd9a5ainlulk64r` FOREIGN KEY (`stateId`) REFERENCES `state` (`stateId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restapp`.`city`
--

/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`cityId`,`cityName`,`stateId`) VALUES 
 (1,'Pachora',1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


--
-- Table structure for table `restapp`.`company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `registrationNumber` varchar(255) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`companyId`),
  KEY `FK3wcxl6p3iuwivwo7jjxfw6u7w` (`cityId`),
  CONSTRAINT `FK3wcxl6p3iuwivwo7jjxfw6u7w` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restapp`.`company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


--
-- Table structure for table `restapp`.`country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `countryCode` varchar(10) NOT NULL,
  `countryName` varchar(45) NOT NULL,
  `currency` varchar(45) NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restapp`.`country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`countryId`,`countryCode`,`countryName`,`currency`) VALUES 
 (1,'IN','India','INR');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Table structure for table `restapp`.`state`
--

DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `stateId` int(11) NOT NULL AUTO_INCREMENT,
  `stateCode` varchar(10) NOT NULL,
  `stateName` varchar(45) NOT NULL,
  `countryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`stateId`),
  KEY `FKhy4xwugy993mc24vg7mrcg49n` (`countryId`),
  CONSTRAINT `FKhy4xwugy993mc24vg7mrcg49n` FOREIGN KEY (`countryId`) REFERENCES `country` (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restapp`.`state`
--

/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`stateId`,`stateCode`,`stateName`,`countryId`) VALUES 
 (1,'MH','Maharashtra',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;


--
-- Table structure for table `restapp`.`user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  `cityId` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobileNumber` varchar(255) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK3rdxytlsn8ggt7ey01w3lptci` (`cityId`),
  KEY `FK3baec9qsc6qxp55q8fiv9c18t` (`companyId`),
  CONSTRAINT `FK3baec9qsc6qxp55q8fiv9c18t` FOREIGN KEY (`companyId`) REFERENCES `company` (`companyId`),
  CONSTRAINT `FK3rdxytlsn8ggt7ey01w3lptci` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restapp`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`,`email`,`fullName`,`password`,`role`,`cityId`,`address`,`mobileNumber`,`companyId`) VALUES 
 (1,'prvnpatil11@gmail.com','Pravin P Patil','pravin',1,1,'Jalgaon','7276622442',NULL),
 (2,'ppp@gmail.com','Pravin ','pravin',0,1,'Jalgaon','7276622442',NULL),
 (3,'bala@gmail.com','Balasaheb Patil','bala',1,1,'Jalgaon','7276622442',NULL),
 (4,'rrr@gmail.com','Rehan','123',1,1,'Jalgaon','7276622442',NULL),
 (5,'rizwan@gmail.com','Rizwan Khan','rizwan',1,1,'Jalgaon','7276622442',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
