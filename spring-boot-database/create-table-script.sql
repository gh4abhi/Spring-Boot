CREATE DATABASE IF NOT EXISTS `student_tracker`;

USE `student_tracker`;

DROP TABLE IF EXISTS `Employee`;

CREATE TABLE `employee`(
	`id` int NOT NULL AUTO_INCREMENT,
    `fname` varchar(45) DEFAULT NULL,
    `lname` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

