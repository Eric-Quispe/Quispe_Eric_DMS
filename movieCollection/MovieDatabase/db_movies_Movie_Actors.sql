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
-- Table structure for table `Movie_Actors`
--

DROP TABLE IF EXISTS `Movie_Actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie_Actors` (
  `movie_id` int NOT NULL,
  `actor_id` int NOT NULL,
  KEY `movie_id` (`movie_id`),
  KEY `actor_id` (`actor_id`),
  CONSTRAINT `movie_actors_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `Movies` (`movie_id`),
  CONSTRAINT `movie_actors_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `Actors` (`actor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie_Actors`
--

LOCK TABLES `Movie_Actors` WRITE;
/*!40000 ALTER TABLE `Movie_Actors` DISABLE KEYS */;
INSERT INTO `Movie_Actors` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,1),(4,9),(4,10),(4,11),(5,12),(5,13),(6,14),(6,15),(6,16),(7,17),(7,18),(7,19),(8,20),(8,21),(8,22),(9,23),(9,24),(9,25),(10,26),(10,27),(10,28),(11,29),(11,30),(11,31),(12,32),(12,33),(12,34),(13,35),(13,36),(13,37),(14,38),(14,39),(14,40),(15,41),(15,42),(15,24),(16,41),(16,42),(16,43),(17,44),(17,45),(17,46),(18,47),(18,48),(18,49),(19,47),(19,50),(19,51),(20,47),(20,52),(20,51),(21,47),(21,53),(21,14),(22,54),(22,55),(22,56),(23,23),(23,57),(23,58),(24,23),(24,59),(24,60),(24,17),(24,61),(25,9),(25,10),(25,62),(26,9),(26,10),(26,11),(27,9),(27,10),(27,63),(1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,1),(4,9),(4,10),(4,11),(5,12),(5,13),(6,14),(6,15),(6,16),(7,17),(7,18),(7,19),(8,20),(8,21),(8,22),(9,23),(9,24),(9,25),(10,26),(10,27),(10,28),(11,29),(11,30),(11,31),(12,32),(12,33),(12,34),(13,35),(13,36),(13,37),(14,38),(14,39),(14,40),(15,41),(15,42),(15,24),(16,41),(16,42),(16,43),(17,44),(17,45),(17,46),(18,47),(18,48),(18,49),(19,47),(19,50),(19,51),(20,47),(20,52),(20,51),(21,47),(21,53),(21,14),(22,54),(22,55),(22,56),(23,23),(23,57),(23,58),(24,23),(24,59),(24,60),(24,17),(24,61),(25,9),(25,10),(25,62),(26,9),(26,10),(26,11),(27,9),(27,10),(27,63),(1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,1),(4,9),(4,10),(4,11),(5,12),(5,13),(6,14),(6,15),(6,16),(7,17),(7,18),(7,19),(8,20),(8,21),(8,22),(9,23),(9,24),(9,25),(10,26),(10,27),(10,28),(11,29),(11,30),(11,31),(12,32),(12,33),(12,34),(13,35),(13,36),(13,37),(14,38),(14,39),(14,40),(15,41),(15,42),(15,24),(16,41),(16,42),(16,43),(17,44),(17,45),(17,46),(18,47),(18,48),(18,49),(19,47),(19,50),(19,51),(20,47),(20,52),(20,51),(21,47),(21,53),(21,14),(22,54),(22,55),(22,56),(23,23),(23,57),(23,58),(24,23),(24,59),(24,60),(24,17),(24,61),(25,9),(25,10),(25,62),(26,9),(26,10),(26,11),(27,9),(27,10),(27,63);
/*!40000 ALTER TABLE `Movie_Actors` ENABLE KEYS */;
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
