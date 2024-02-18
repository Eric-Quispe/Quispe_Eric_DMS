-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: db_movies
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `Writers`
--

DROP TABLE IF EXISTS `Writers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Writers` (
  `writer_id` int NOT NULL AUTO_INCREMENT,
  `writer_name` varchar(100) NOT NULL,
  PRIMARY KEY (`writer_id`),
  UNIQUE KEY `unique_writer_name` (`writer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Writers`
--

LOCK TABLES `Writers` WRITE;
/*!40000 ALTER TABLE `Writers` DISABLE KEYS */;
INSERT INTO `Writers` VALUES (16,'Andrew Knight'),(46,'Andrew Stanton'),(10,'Ash Brannon'),(24,'Benjamin Renner'),(27,'Bob Kane'),(28,'Bob Peterson'),(36,'Brad Bird'),(19,'Brenda Hsueh'),(30,'Byron Howard'),(13,'Cary Joji Fukunaga'),(12,'Chase Palmer'),(41,'Chris Collins'),(20,'Chris McKenna'),(4,'Christopher Miller'),(5,'Dave Callaham'),(39,'Derek Kolstad'),(21,'Erik Sommers'),(14,'Gary Dauberman'),(1,'Greta Gerwig'),(32,'Jared Bush'),(34,'Jason Katz'),(44,'John Francis Daley'),(17,'John Hoberg'),(8,'John Lasseter'),(42,'Jon Watts'),(43,'Jonathan Goldstein'),(7,'Jordan Belfort'),(45,'Joss Whedon'),(18,'Kat Likkel'),(11,'Kurt Wimmer'),(33,'Lee Unkrich'),(37,'Luc Besson'),(35,'Matthew Aldrich'),(23,'Mike White'),(2,'Noah BaumBach'),(9,'Pete Docter'),(3,'Phil Lord'),(31,'Rich Moore'),(38,'Robert Mark Kamen'),(15,'Robert Schenkkan'),(26,'Scott Silver'),(40,'Shay Hatten'),(22,'Stan Lee'),(47,'Stephany Folsom'),(6,'Terence Winter'),(25,'Todd Phillips'),(29,'Tom McCarthy');
/*!40000 ALTER TABLE `Writers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-18  3:53:49
