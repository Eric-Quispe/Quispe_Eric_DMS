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
-- Table structure for table `Movies`
--

DROP TABLE IF EXISTS `Movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movies` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `rating` double NOT NULL,
  `description` text,
  PRIMARY KEY (`movie_id`),
  UNIQUE KEY `unique_movie_name` (`title`),
  UNIQUE KEY `unique_imagePath` (`image_path`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movies`
--

LOCK TABLES `Movies` WRITE;
/*!40000 ALTER TABLE `Movies` DISABLE KEYS */;
INSERT INTO `Movies` VALUES (1,'Barbie','resources/movieImages/Barbie.png',6.9,'Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.'),(2,'Spider-Man:Across the Spider-Verse','resources/movieImages/Spider-Man Across The Spider-Verse.png',8.6,'Miles Morales catapults across the multiverse, where he encounters a team of Spider-People charged with protecting its very existence. When the heroes clash on how to handle a new threat, Miles must redefine what it means to be a hero.'),(3,'The Wolf of Wall Street','resources/movieImages/The Wolf Of Wall Street.png',8.2,'Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.'),(4,'Toy Story 2','resources/movieImages/ToyStory2.png',7.9,'When Woody is stolen by a toy collector, Buzz and his friends vow to rescue him, but Woody finds the idea of immortality in a museum tempting.'),(5,'The BeeKeeper','resources/movieImages/The BeeKeeper.png',6.5,'One man\'s brutal campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as \"Beekeepers\".'),(6,'IT','resources/movieImages/IT.png',7.3,'In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.'),(7,'HackSaw Ridge','resources/movieImages/Hacksaw Ridge.png',8.1,'World War II American Army Medic Desmond T. Doss, serving during the Battle of Okinawa, refuses to kill people and becomes the first man in American history to receive the Medal of Honor without firing a shot.'),(8,'Elemental','resources/movieImages/Elemental.png',7.1,'Follows Ember and Wade, in a city where fire-, water-, earth- and air-residents live together.'),(9,'Spider-Man: Far From Home','resources/movieImages/SpiderManFarFromHome.png',8.5,'Peter Parker goes on a school trip to Europe, but his vacation is quickly scrapped when he begrudgingly agrees to help Nick Fury uncover the mystery of several elemental creature attacks.'),(10,'Migration','resources/movieImages/Migration.png',6.7,'A family of ducks try to convince their overprotective father to go on the vacation of a lifetime.'),(11,'Joker','resources/movieImages/Joker.png',8.4,'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.'),(12,'Up','resources/movieImages/Up.png',8.3,'Seventy-eight-year-old Carl Fredricksen travels to Paradise Falls in his house equipped with balloons, inadvertently taking a young stowaway.'),(13,'Zootopia','resources/movieImages/Zootopia.png',8,'In a city of anthropomorphic animals, a rookie bunny cop and a cynical con artist fox must work together to uncover a conspiracy.'),(14,'Coco','resources/movieImages/Coco.png',8.4,'Aspiring musician Miguel, confronted with his family\'s ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.'),(15,'The Incredibles','resources/movieImages/The Incredibles.png',8,'A family of undercover superheroes, while trying to live the quiet suburban life, are forced into action to save the world.'),(16,'Incredibles 2','resources/movieImages/Incredibles2.png',7.7,'The Parr family struggles to maintain normal lives while Helen, as Elastigirl, takes on a new mission to save the world.'),(17,'Taken','resources/movieImages/Taken.png',7.8,'A retired CIA agent travels across Europe and relies on his old skills to save his estranged daughter, who has been kidnapped while on a trip to Paris.'),(18,'John Wick','resources/movieImages/JohnWick.png',7.4,'An ex-hit-man comes out of retirement to track down the gangsters that killed his dog and took everything from him.'),(19,'John Wick: Chapter 2','resources/movieImages/JohnWick2.png',7.5,'John Wick is forced back out of retirement by a former associate plotting to seize control of a shadowy international assassins\' guild.'),(20,'John Wick: Chapter 3 Parabellum','resources/movieImages/JohnWick3.png',7.5,'John Wick is on the run after killing a member of the international assassin\'s guild, and with a $14 million price tag on his head, he is the target of hit men and women everywhere.'),(21,'John Wick: Chapter 4','resources/movieImages/JohnWick4.png',8,'With the high table seeking retribution, John Wick uncovers a path to defeating the organization, but it comes with challenging alliances and a fight against the world\'s most lethal killers.'),(22,'Nobody','resources/movieImages/Nobody.png',8,'A bystander who intervenes to help a woman being harassed by a group of men becomes the target of a vengeful drug lord.'),(23,'Spider-Man: Homecoming','resources/movieImages/SpiderManHomecoming.png',8.1,'Peter Parker balances his life as an ordinary high school student in Queens with his superhero alter-ego Spider-Man, and finds himself on the trail of a new menace prowling the skies of New York City.'),(24,'Spider-Man: No Way Home','resources/movieImages/SpiderManNoWayHome.png',9.7,'Peter Parker\'s secret identity is revealed to the world. Desperate for help, he turns to Doctor Strange to restore his secret, leading to a dangerous alternative that alters their world forever.'),(25,'Toy Story','resources/movieImages/ToyStory.png',8.3,'A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy\'s room.'),(26,'Toy Story 3','resources/movieImages/ToyStory3.png',8.3,'The toys are mistakenly delivered to a day-care center instead of the attic right before Andy leaves for college, and it\'s up to Woody to convince the other toys that they weren\'t abandoned and to return home.'),(27,'Toy Story 4','resources/movieImages/ToyStory4.png',7.8,'When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.');
/*!40000 ALTER TABLE `Movies` ENABLE KEYS */;
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
