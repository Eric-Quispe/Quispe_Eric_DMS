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
-- Table structure for table `Actors`
--

DROP TABLE IF EXISTS `Actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Actors` (
  `actor_id` int NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(100) NOT NULL,
  PRIMARY KEY (`actor_id`),
  UNIQUE KEY `unique_actor_name` (`actor_name`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actors`
--

LOCK TABLES `Actors` WRITE;
/*!40000 ALTER TABLE `Actors` DISABLE KEYS */;
INSERT INTO `Actors` VALUES (55,'Aleksey Serebryakov'),(49,'Alfie Allen'),(17,'Andrew Garfield'),(63,'Annie Potts'),(38,'Anthony Gonzalez'),(60,'Benedict Cumberbatch'),(40,'Benjamin Bratt'),(14,'Bill Skarsgard'),(54,'Bob Odenkirk'),(6,'Brain Tyree Henry'),(56,'Connie Nielsen'),(41,'Craig T. Nelson'),(62,'Don Rickles'),(53,'Donnie Yen'),(32,'Edward Asner'),(28,'Elizabeth Banks'),(13,'Emmy Raver-Lampman'),(46,'Famke Janssen'),(16,'Finn Wolfhard'),(39,'Gael García Bernal'),(35,'Ginnifer Goodwin'),(5,'Hailee Steinfeld'),(52,'Halle Berry'),(42,'Holly Hunter'),(51,'Ian McShane'),(37,'Idris Elba'),(3,'Issa Rae'),(15,'Jaeden Martell'),(25,'Jake Gyllenhaal'),(36,'Jason Bateman'),(12,'Jason Statham'),(11,'Joan Cusack'),(29,'Joaquin Phoenix'),(34,'John Ratzenberger'),(8,'Jonah Hill'),(33,'Jordan Nagai'),(47,'Keanu Reeves'),(26,'Kumail Nanjiani'),(20,'Leah Lewis'),(7,'Leonardo DiCaprio'),(44,'Liam Neeson'),(19,'Luke Bracey'),(45,'Maggie Grace'),(21,'Mamoudou Athie'),(1,'Marrgot Robbie'),(57,'Michael Keaton'),(48,'Michael Nyqvist'),(50,'Riccardo Scamarcio'),(30,'Robert De Niro'),(58,'Robert Downey Jr.'),(22,'Ronnie Del Carmen'),(2,'Ryan Gosling'),(18,'Sam Worthington'),(24,'Samuel L. Jackson'),(43,'Sarah Vowell'),(4,'Shameik Moore'),(10,'Tim Allen'),(61,'Tobey Maguire'),(9,'Tom Hanks'),(23,'Tom Holland'),(27,'Tresi Gazal'),(31,'Zazie Beetz'),(59,'Zendaya');
/*!40000 ALTER TABLE `Actors` ENABLE KEYS */;
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
