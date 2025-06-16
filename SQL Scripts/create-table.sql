CREATE DATABASE  IF NOT EXISTS `Entertainment`;
USE `Entertainment`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `Anime`;

CREATE TABLE `Anime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anime_name`varchar(45) DEFAULT NULL,
  `main_character` varchar(45) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

