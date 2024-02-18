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
-- Table structure for table `Movie_Writers`
--

DROP TABLE IF EXISTS `Movie_Writers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie_Writers` (
  `movie_id` int NOT NULL,
  `writer_id` int NOT NULL,
  KEY `movie_id` (`movie_id`),
  KEY `writer_id` (`writer_id`),
  CONSTRAINT `movie_writers_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `Movies` (`movie_id`),
  CONSTRAINT `movie_writers_ibfk_2` FOREIGN KEY (`writer_id`) REFERENCES `Writers` (`writer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie_Writers`
--

LOCK TABLES `Movie_Writers` WRITE;
/*!40000 ALTER TABLE `Movie_Writers` DISABLE KEYS */;
INSERT INTO `Movie_Writers` VALUES (1,1),(1,2),(2,3),(2,4),(2,5),(3,6),(3,7),(4,8),(4,9),(4,10),(5,11),(6,12),(6,13),(6,14),(7,15),(7,16),(8,17),(8,18),(8,19),(9,20),(9,21),(9,22),(10,23),(10,24),(11,25),(11,26),(11,27),(12,9),(12,28),(12,29),(13,30),(13,31),(13,32),(14,33),(14,34),(14,35),(15,36),(16,36),(17,37),(17,38),(18,39),(19,39),(20,39),(20,40),(20,41),(21,40),(21,39),(22,39),(23,42),(23,43),(23,44),(23,22),(24,20),(24,21),(24,22),(25,8),(25,9),(25,45),(25,46),(26,8),(26,33),(26,46),(27,46),(27,47),(1,1),(1,2),(2,3),(2,4),(2,5),(3,6),(3,7),(4,8),(4,9),(4,10),(5,11),(6,12),(6,13),(6,14),(7,15),(7,16),(8,17),(8,18),(8,19),(9,20),(9,21),(9,22),(10,23),(10,24),(11,25),(11,26),(11,27),(12,9),(12,28),(12,29),(13,30),(13,31),(13,32),(14,33),(14,34),(14,35),(15,36),(16,36),(17,37),(17,38),(18,39),(19,39),(20,39),(20,40),(20,41),(21,40),(21,39),(22,39),(23,42),(23,43),(23,44),(23,22),(24,20),(24,21),(24,22),(25,8),(25,9),(25,45),(25,46),(26,8),(26,33),(26,46),(27,46),(27,47),(1,1),(1,2),(2,3),(2,4),(2,5),(3,6),(3,7),(4,8),(4,9),(4,10),(5,11),(6,12),(6,13),(6,14),(7,15),(7,16),(8,17),(8,18),(8,19),(9,20),(9,21),(9,22),(10,23),(10,24),(11,25),(11,26),(11,27),(12,9),(12,28),(12,29),(13,30),(13,31),(13,32),(14,33),(14,34),(14,35),(15,36),(16,36),(17,37),(17,38),(18,39),(19,39),(20,39),(20,40),(20,41),(21,40),(21,39),(22,39),(23,42),(23,43),(23,44),(23,22),(24,20),(24,21),(24,22),(25,8),(25,9),(25,45),(25,46),(26,8),(26,33),(26,46),(27,46),(27,47);
/*!40000 ALTER TABLE `Movie_Writers` ENABLE KEYS */;
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
