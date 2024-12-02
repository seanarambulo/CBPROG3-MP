-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: shuttlesystem
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arrowsexpressline`
--

DROP TABLE IF EXISTS `arrowsexpressline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arrowsexpressline` (
  `LineID` int NOT NULL AUTO_INCREMENT,
  `LineName` varchar(45) NOT NULL,
  PRIMARY KEY (`LineID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrowsexpressline`
--

LOCK TABLES `arrowsexpressline` WRITE;
/*!40000 ALTER TABLE `arrowsexpressline` DISABLE KEYS */;
INSERT INTO `arrowsexpressline` VALUES (1,'MANILA<-->LAGUNA'),(2,'PASEO<-->LAGUNA'),(3,'CARMONA<-->LAGUNA'),(4,'PAVILION<-->LAGUNA'),(5,'WALTER<-->LAGUNA');
/*!40000 ALTER TABLE `arrowsexpressline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `ShuttleBookingID` int NOT NULL AUTO_INCREMENT,
  `Attendance` tinyint(1) NOT NULL,
  `Origin` varchar(45) NOT NULL,
  `Destination` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  `LineID` int NOT NULL,
  `UserID` bigint NOT NULL,
  `TimeID` int NOT NULL,
  PRIMARY KEY (`ShuttleBookingID`),
  KEY `TimeID` (`TimeID`),
  KEY `LineID` (`LineID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`TimeID`) REFERENCES `time` (`TimeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`LineID`) REFERENCES `arrowsexpressline` (`LineID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,0,'DLSU-MNL','DLSU-LC','2024-11-25',1,12344818,1),(2,0,'DLSU-LC','PASEO','2024-11-25',2,12344818,2),(5,0,'DLSU-MNL','DLSU-LC','2024-11-26',1,12345678,1),(6,0,'PASEO','DLSU-LC','2024-11-26',2,12345678,2),(7,1,'PASEO','LAGUNA','2024-12-03',2,12340006,2),(16,0,'LAGUNA','PASEO','2024-12-17',2,12340006,3),(18,0,'paseo','laguna','2024-11-25',2,12340006,2),(19,0,'LAGUNA','PASEO','2024-12-23',2,12340006,2),(20,0,'LAGUNA','PASEO','2024-12-16',2,12340006,2),(21,0,'paseo','laguna','2024-12-23',2,12340006,1),(22,0,'LAGUNA','PASEO','2024-12-17',2,12340006,1),(23,0,'LAGUNA','PASEO','2024-12-03',2,12340006,1),(24,0,'LAGUNA','PASEO','2024-12-03',2,12340006,2),(25,0,'PASEO','LAGUNA','2024-12-09',2,12340006,3),(26,0,'PASEO','LAGUNA','2024-12-16',2,12340006,3),(27,0,'PASEO','LAGUNA','2024-12-03',2,12340006,3);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classdays`
--

DROP TABLE IF EXISTS `classdays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classdays` (
  `DaysID` int NOT NULL,
  `StudentID` bigint NOT NULL,
  PRIMARY KEY (`DaysID`,`StudentID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `classdays_ibfk_1` FOREIGN KEY (`DaysID`) REFERENCES `days` (`DaysID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `classdays_ibfk_2` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classdays`
--

LOCK TABLES `classdays` WRITE;
/*!40000 ALTER TABLE `classdays` DISABLE KEYS */;
INSERT INTO `classdays` VALUES (1,12340006),(2,12340006),(1,12344818),(2,12344818),(1,12345678),(3,12345678);
/*!40000 ALTER TABLE `classdays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `days`
--

DROP TABLE IF EXISTS `days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `days` (
  `DaysID` int NOT NULL AUTO_INCREMENT,
  `DayName` varchar(45) NOT NULL,
  PRIMARY KEY (`DaysID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `days`
--

LOCK TABLES `days` WRITE;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` VALUES (1,'Monday'),(2,'Tuesday'),(3,'Wednesday'),(4,'Thursday'),(5,'Friday'),(6,'Saturday');
/*!40000 ALTER TABLE `days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `designation`
--

DROP TABLE IF EXISTS `designation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `designation` (
  `DesignationID` int NOT NULL AUTO_INCREMENT,
  `DesignationType` varchar(45) NOT NULL,
  PRIMARY KEY (`DesignationID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designation`
--

LOCK TABLES `designation` WRITE;
/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
INSERT INTO `designation` VALUES (1,'Admin'),(2,'Dispatcher'),(3,'Employee'),(4,'Student');
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irregshuttlebooking`
--

DROP TABLE IF EXISTS `irregshuttlebooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `irregshuttlebooking` (
  `IrregShuttleBookingID` int NOT NULL,
  `Reason` varchar(255) NOT NULL,
  `isApproved` tinyint(1) NOT NULL,
  PRIMARY KEY (`IrregShuttleBookingID`),
  CONSTRAINT `irregshuttlebooking_ibfk_1` FOREIGN KEY (`IrregShuttleBookingID`) REFERENCES `booking` (`ShuttleBookingID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irregshuttlebooking`
--

LOCK TABLES `irregshuttlebooking` WRITE;
/*!40000 ALTER TABLE `irregshuttlebooking` DISABLE KEYS */;
INSERT INTO `irregshuttlebooking` VALUES (1,'Medical Emergency',1),(2,'Traffic Jam',1),(18,'traffic lods',0),(21,'pasado cutie',0),(25,'pota',0),(27,'ftkig',0);
/*!40000 ALTER TABLE `irregshuttlebooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linetime`
--

DROP TABLE IF EXISTS `linetime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linetime` (
  `LineID` int NOT NULL,
  `TimeID` int NOT NULL,
  PRIMARY KEY (`LineID`,`TimeID`),
  KEY `TimeID` (`TimeID`),
  CONSTRAINT `linetime_ibfk_1` FOREIGN KEY (`LineID`) REFERENCES `arrowsexpressline` (`LineID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `linetime_ibfk_2` FOREIGN KEY (`TimeID`) REFERENCES `time` (`TimeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linetime`
--

LOCK TABLES `linetime` WRITE;
/*!40000 ALTER TABLE `linetime` DISABLE KEYS */;
INSERT INTO `linetime` VALUES (1,1),(2,1),(1,2),(2,2),(2,3);
/*!40000 ALTER TABLE `linetime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shuttlebookingpreset`
--

DROP TABLE IF EXISTS `shuttlebookingpreset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shuttlebookingpreset` (
  `PresetID` int NOT NULL AUTO_INCREMENT,
  `ShuttleBookingID` int NOT NULL,
  PRIMARY KEY (`PresetID`),
  KEY `ShuttleBookingID` (`ShuttleBookingID`),
  CONSTRAINT `shuttlebookingpreset_ibfk_1` FOREIGN KEY (`ShuttleBookingID`) REFERENCES `booking` (`ShuttleBookingID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shuttlebookingpreset`
--

LOCK TABLES `shuttlebookingpreset` WRITE;
/*!40000 ALTER TABLE `shuttlebookingpreset` DISABLE KEYS */;
INSERT INTO `shuttlebookingpreset` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `shuttlebookingpreset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StudentID` bigint NOT NULL,
  `TrimesterID` int NOT NULL,
  `EAF` varchar(255) NOT NULL,
  `isVerified` tinyint(1) NOT NULL,
  `enrolledAs` varchar(90) NOT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `TrimesterID` (`TrimesterID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`TrimesterID`) REFERENCES `trimester` (`TrimesterID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (12340006,1,'http://example.com/eaf3',1,'College - Laguna Enrolled with class/es in Manila'),(12344818,1,'http://example.com/eaf1',0,'College - Laguna Enrolled without class/es in Manila'),(12345678,1,'http://example.com/eaf2',0,'College - Laguna Enrolled without class/es in Manila');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `TimeID` int NOT NULL AUTO_INCREMENT,
  `Time` time NOT NULL,
  PRIMARY KEY (`TimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'08:00:00'),(2,'10:00:00'),(3,'13:00:00'),(4,'15:00:00');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trimester`
--

DROP TABLE IF EXISTS `trimester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trimester` (
  `TrimesterID` int NOT NULL AUTO_INCREMENT,
  `YearNum` int NOT NULL,
  `TermNum` int NOT NULL,
  PRIMARY KEY (`TrimesterID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trimester`
--

LOCK TABLES `trimester` WRITE;
/*!40000 ALTER TABLE `trimester` DISABLE KEYS */;
INSERT INTO `trimester` VALUES (1,2024,1),(2,2024,2),(3,2024,3),(4,2025,1);
/*!40000 ALTER TABLE `trimester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trimesterschedule`
--

DROP TABLE IF EXISTS `trimesterschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trimesterschedule` (
  `TrimesterScheduleID` int NOT NULL AUTO_INCREMENT,
  `TrimesterID` int NOT NULL,
  `TimeID` int NOT NULL,
  PRIMARY KEY (`TrimesterScheduleID`),
  KEY `TimeID` (`TimeID`),
  KEY `TrimesterID` (`TrimesterID`),
  CONSTRAINT `trimesterschedule_ibfk_1` FOREIGN KEY (`TimeID`) REFERENCES `time` (`TimeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trimesterschedule_ibfk_2` FOREIGN KEY (`TrimesterID`) REFERENCES `trimester` (`TrimesterID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trimesterschedule`
--

LOCK TABLES `trimesterschedule` WRITE;
/*!40000 ALTER TABLE `trimesterschedule` DISABLE KEYS */;
INSERT INTO `trimesterschedule` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4);
/*!40000 ALTER TABLE `trimesterschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` bigint NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DesignationID` int NOT NULL,
  PRIMARY KEY (`UserID`),
  KEY `DesignationID` (`DesignationID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`DesignationID`) REFERENCES `designation` (`DesignationID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10000001,'Admin1','password1','admin1@example.com',1),(12340006,'Student2','password3','student3@example.com',4),(12344818,'Student1','password4','student1@example.com',4),(12345670,'rovick','12345678','rovick@dlsu.edu.ph',4),(12345678,'Student2','password2','student2@example.com',4),(20000002,'Dispatcher1','password2','dispatcher1@example.com',2),(30000003,'Employee1','password3','employee1@example.com',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-02 15:59:16
