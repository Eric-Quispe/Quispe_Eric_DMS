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
-- Table structure for table `Movie_Genres`
--

DROP TABLE IF EXISTS `Movie_Genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie_Genres` (
  `movie_id` int NOT NULL,
  `genre_id` int NOT NULL,
  KEY `movie_id` (`movie_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `movie_genres_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `Movies` (`movie_id`),
  CONSTRAINT `movie_genres_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `Genres` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie_Genres`
--

LOCK TABLES `Movie_Genres` WRITE;
/*!40000 ALTER TABLE `Movie_Genres` DISABLE KEYS */;
INSERT INTO `Movie_Genres` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,3),(3,6),(3,1),(3,7),(4,4),(4,3),(4,1),(5,5),(5,8),(6,9),(7,6),(7,10),(7,11),(8,4),(8,3),(8,1),(9,5),(9,3),(9,12),(10,4),(10,5),(10,3),(11,7),(11,10),(11,8),(12,4),(12,3),(12,1),(13,4),(13,3),(13,1),(14,4),(14,3),(14,10),(15,4),(15,5),(15,3),(16,4),(16,5),(16,3),(17,5),(17,7),(17,8),(18,5),(18,7),(18,8),(19,5),(19,7),(19,8),(20,5),(20,7),(20,8),(21,5),(21,7),(21,8),(22,5),(22,7),(22,8),(23,5),(23,3),(23,12),(24,5),(24,3),(24,12),(25,4),(25,3),(25,1),(26,4),(26,3),(26,1),(27,4),(27,3),(27,1),(1,1),(1,2),(1,3),(2,4),(2,5),(2,3),(3,6),(3,1),(3,7),(4,4),(4,3),(4,1),(5,5),(5,8),(6,9),(7,6),(7,10),(7,11),(8,4),(8,3),(8,1),(9,5),(9,3),(9,12),(10,4),(10,5),(10,3),(11,7),(11,10),(11,8),(12,4),(12,3),(12,1),(13,4),(13,3),(13,1),(14,4),(14,3),(14,10),(15,4),(15,5),(15,3),(16,4),(16,5),(16,3),(17,5),(17,7),(17,8),(18,5),(18,7),(18,8),(19,5),(19,7),(19,8),(20,5),(20,7),(20,8),(21,5),(21,7),(21,8),(22,5),(22,7),(22,8),(23,5),(23,3),(23,12),(24,5),(24,3),(24,12),(25,4),(25,3),(25,1),(26,4),(26,3),(26,1),(27,4),(27,3),(27,1),(1,1),(1,2),(1,3),(2,4),(2,5),(2,3),(3,6),(3,1),(3,7),(4,4),(4,3),(4,1),(5,5),(5,8),(6,9),(7,6),(7,10),(7,11),(8,4),(8,3),(8,1),(9,5),(9,3),(9,12),(10,4),(10,5),(10,3),(11,7),(11,10),(11,8),(12,4),(12,3),(12,1),(13,4),(13,3),(13,1),(14,4),(14,3),(14,10),(15,4),(15,5),(15,3),(16,4),(16,5),(16,3),(17,5),(17,7),(17,8),(18,5),(18,7),(18,8),(19,5),(19,7),(19,8),(20,5),(20,7),(20,8),(21,5),(21,7),(21,8),(22,5),(22,7),(22,8),(23,5),(23,3),(23,12),(24,5),(24,3),(24,12),(25,4),(25,3),(25,1),(26,4),(26,3),(26,1),(27,4),(27,3),(27,1);
/*!40000 ALTER TABLE `Movie_Genres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-18  3:53:48
