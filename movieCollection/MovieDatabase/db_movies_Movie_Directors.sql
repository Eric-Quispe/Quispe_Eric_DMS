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
-- Table structure for table `Movie_Directors`
--

DROP TABLE IF EXISTS `Movie_Directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie_Directors` (
  `movie_id` int NOT NULL,
  `director_id` int NOT NULL,
  KEY `movie_id` (`movie_id`),
  KEY `director_id` (`director_id`),
  CONSTRAINT `movie_directors_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `Movies` (`movie_id`),
  CONSTRAINT `movie_directors_ibfk_2` FOREIGN KEY (`director_id`) REFERENCES `Directors` (`director_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie_Directors`
--

LOCK TABLES `Movie_Directors` WRITE;
/*!40000 ALTER TABLE `Movie_Directors` DISABLE KEYS */;
INSERT INTO `Movie_Directors` VALUES (1,1),(2,2),(2,3),(2,4),(3,5),(4,6),(4,7),(4,8),(5,9),(6,10),(7,11),(8,12),(9,13),(10,14),(10,15),(11,16),(12,17),(12,18),(13,19),(13,20),(13,21),(14,8),(14,22),(15,23),(16,23),(17,24),(18,25),(18,26),(19,25),(20,25),(21,25),(22,27),(23,13),(24,13),(25,6),(26,8),(27,28),(1,1),(2,2),(2,3),(2,4),(3,5),(4,6),(4,7),(4,8),(5,9),(6,10),(7,11),(8,12),(9,13),(10,14),(10,15),(11,16),(12,17),(12,18),(13,19),(13,20),(13,21),(14,8),(14,22),(15,23),(16,23),(17,24),(18,25),(18,26),(19,25),(20,25),(21,25),(22,27),(23,13),(24,13),(25,6),(26,8),(27,28),(1,1),(2,2),(2,3),(2,4),(3,5),(4,6),(4,7),(4,8),(5,9),(6,10),(7,11),(8,12),(9,13),(10,14),(10,15),(11,16),(12,17),(12,18),(13,19),(13,20),(13,21),(14,8),(14,22),(15,23),(16,23),(17,24),(18,25),(18,26),(19,25),(20,25),(21,25),(22,27),(23,13),(24,13),(25,6),(26,8),(27,28);
/*!40000 ALTER TABLE `Movie_Directors` ENABLE KEYS */;
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
