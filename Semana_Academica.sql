CREATE DATABASE  IF NOT EXISTS `semana_academica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `semana_academica`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: semana_academica
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `idAluno` int(5) NOT NULL AUTO_INCREMENT,
  `nomeAluno` varchar(100) NOT NULL,
  `nomeCurso` varchar(50) NOT NULL,
  `faseCurso` int(2) NOT NULL,
  PRIMARY KEY (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES 
(1,'Dhyego Luiz Damasco Pedroso','ADS',3),
(2,'Felipe Dania','ADS',3),
(3,'João Martins','PG',1),
(4,'Maria Fonseca','RH',1),
(5,'Ana Bella','RH',2),
(6,'Jessica Correa','PG',4),
(7,'Adriano Martins','PG',4),
(8,'Alan Bixona','ADS',3),
(9,'Adriano Gago','ADS',1),
(10,'Botelho','PG',2),
(11,'Vaginalda','PG',4),
(12,'Afonsa Seca','RH',3);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palestra`
--

DROP TABLE IF EXISTS `palestra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `palestra` (
  `idPalestra` int(5) NOT NULL AUTO_INCREMENT,
  `tituloPalestra` varchar(100) NOT NULL,
  `descricaoPalestra` varchar(300) DEFAULT NULL,
  `diaPalestra` int(2) NOT NULL,
  PRIMARY KEY (`idPalestra`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palestra`
--

LOCK TABLES `palestra` WRITE;
/*!40000 ALTER TABLE `palestra` DISABLE KEYS */;
INSERT INTO `palestra` VALUES 
(1,'Como conseguir o seu melhor emprego',NULL,22),
(2,'Canvas',NULL,23),
(3,'Design Thinking',NULL,23),
(4,'Scrum',NULL,23),
(5,'BI',NULL,23),
(6,'Scamper',NULL,23),
(7,'Inovação como processo diário',NULL,23),
(8,'Validar',NULL,24),
(9,' a definir',NULL,24),
(10,' a definir',NULL,25),
(11,'Testgbvg','gvgv',25);
/*!40000 ALTER TABLE `palestra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palestrante`
--

DROP TABLE IF EXISTS `palestrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `palestrante` (
  `idPalestrante` int(5) NOT NULL AUTO_INCREMENT,
  `nomePalestrante` varchar(100) NOT NULL,
  `idPalestra` int(5) NOT NULL,
  PRIMARY KEY (`idPalestrante`),
  KEY `idPalestra` (`idPalestra`),
  CONSTRAINT `palestrante_ibfk_1` FOREIGN KEY (`idPalestra`) REFERENCES `palestra` (`idPalestra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palestrante`
--

LOCK TABLES `palestrante` WRITE;
/*!40000 ALTER TABLE `palestrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `palestrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relatorio`
--

DROP TABLE IF EXISTS `relatorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relatorio` (
  `idRelatorio` int(5) NOT NULL AUTO_INCREMENT,
  `idAluno` int(5) NOT NULL,
  `idPalestra` int(5) NOT NULL,
  `dia` datetime NOT NULL,
  PRIMARY KEY (`idRelatorio`),
  KEY `idAluno` (`idAluno`),
  KEY `idPalestra` (`idPalestra`),
  CONSTRAINT `relatorio_ibfk_1` FOREIGN KEY (`idAluno`) REFERENCES `aluno` (`idAluno`),
  CONSTRAINT `relatorio_ibfk_2` FOREIGN KEY (`idPalestra`) REFERENCES `palestra` (`idPalestra`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relatorio`
--

LOCK TABLES `relatorio` WRITE;
/*!40000 ALTER TABLE `relatorio` DISABLE KEYS */;
INSERT INTO `relatorio` VALUES 
(1,1,2,'2018-05-11 23:40:03'),
(2,1,1,'2018-05-11 23:42:08'),
(3,1,7,'2018-05-11 23:42:16'),
(4,7,1,'2018-05-11 23:42:21'),
(5,10,1,'2018-05-11 23:42:23'),
(6,6,3,'2018-05-11 23:42:25'),
(7,3,11,'2018-05-12 00:00:54'),
(8,5,3,'2018-05-12 00:26:37'),
(9,1,1,'2018-05-12 00:26:51'),
(10,1,1,'2018-05-12 00:26:52'),
(11,4,1,'2018-05-12 00:26:53'),
(12,5,1,'2018-05-12 00:26:54'),
(13,5,1,'2018-05-12 00:26:58'),
(14,12,8,'2018-05-12 00:38:34'),
(15,11,8,'2018-05-12 00:38:37'),
(16,10,8,'2018-05-12 00:38:39'),
(17,10,3,'2018-05-12 00:47:42');
/*!40000 ALTER TABLE `relatorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'semana_academica'
--

--
-- Dumping routines for database 'semana_academica'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12  0:51:17
