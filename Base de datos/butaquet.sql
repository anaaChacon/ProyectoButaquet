-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: butaquet
-- ------------------------------------------------------
-- Server version	5.6.34-log

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
-- Table structure for table `cines`
--

DROP TABLE IF EXISTS `cines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cines` (
  `id_cine` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `cif` varchar(9) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_cine`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cines`
--

LOCK TABLES `cines` WRITE;
/*!40000 ALTER TABLE `cines` DISABLE KEYS */;
INSERT INTO `cines` VALUES (1,'Aragó Cinema','A85261457',961361505,'Avinguda del Port 1'),(2,'Cine Lys','A36587123',963511766,'Passeig de Russafa 3'),(3,'Kinepolis València','A85630145',961587423,'Av. Francesc Tomñas i Valiente s/n (CC Heron City)'),(4,'ABC El Saler','A32478965',961478623,'Av. Profesor Lopez Piñero 16 (CC El Saler)'),(5,'Ocine Aqua','A12874698',961358745,'Carrer de Menorca 19 (CC Aqua)');
/*!40000 ALTER TABLE `cines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id_empleado` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `direccion_empleado` varchar(60) DEFAULT NULL,
  `acceso_usuario` int(6) NOT NULL,
  `acceso_contrasenya` int(8) NOT NULL,
  `tipo_empleado` tinyint(4) DEFAULT NULL,
  `cine_id` int(3) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `cine_id` (`cine_id`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`cine_id`) REFERENCES `cines` (`id_cine`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Maria','López Gómez',658745324,'23547856V','Carrer de Burjassot 5',526874,11111111,0,1),(2,'Antonio','Pérez Galdos',963478596,'19754485M','Carrer de Marí Blas de Lezo 53',574326,11111111,0,1),(3,'Carmen','Machi Terol',961458765,'26478596Z','Travesia de les Flors',574236,11111111,0,3),(4,'Alejandro','Venta Pública',963478596,'45871698Z','Passeig Rajolar 1',587456,11111111,0,2),(5,'Daniel','Marí Fortea',961584655,'56842362T','Carrer de Pintor Ferrandis 45',581235,11111111,0,2),(6,'Miguel Ángel','Gálvez Alfaro',963874236,'36521478L','Carrer Dr. Lluch 56',594562,11111111,0,4),(7,'Antonia','Oliver Mendizabal',963458745,'26358415X','Carrer de Castella 23',587632,11111111,0,4),(8,'Anabel','Chacon Fernández',654782364,'56874236','Carrer Gran de Benimamet 35',574321,11111111,0,5),(9,'José Benito','Romero Martinez',961954933,'47235123P','Av. del Llevant UE',514365,11111111,0,5);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peliculas` (
  `id_pelicula` int(4) NOT NULL AUTO_INCREMENT,
  `nombre_pelicula` varchar(60) DEFAULT NULL,
  `categoria` varchar(30) DEFAULT NULL,
  `director` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (1,'Frozen','Fantasía/Comedia','Charles Vidor'),(2,'Underworld 5','Acción-Ciencia Ficción','Len Wiselman'),(3,'Infierno azul','Ciencia Ficción','Jaume Collet-Serra'),(4,'La llegada','Drama','Denis Villeneuve'),(5,'Contratiempo','Thriller','Oriol Paulo'),(6,'Ballerina','Animacion','Eric Warin'),(7,'Batman: Lego Película','Animacion','Chris McKay'),(8,'Cincuenta sombras más oscuras','Drama','James Foley'),(9,'Figuras Ocultas','Drama','Theodore Melfi'),(10,'La La Land','Romance','Damien Chazelle'),(11,'Lion','Drama','Garth Davis'),(12,'Manchester Frente al mar','Drama','Kenneth Lonergan'),(13,'Multiple','Thriller','Night Shyamalan'),(14,'Resident Evil: Cap. Final','Acción','Paul W.S. Anderson'),(15,'Rings','Terror','F. Javier Gutiérrez'),(16,'¡Canta!','Animacion','Garth Jennings'),(17,'Las Furias','Autor','Antonio Garcia'),(18,'Expediente Warren','Terror','Jonathan Trump'),(19,'Hachiko, siempre a tu lado','Drama','Lasse Hallström'),(20,'Casablanca','Drama','Michael Curtiz');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyeccion`
--

DROP TABLE IF EXISTS `proyeccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyeccion` (
  `id_proyeccion` int(6) NOT NULL AUTO_INCREMENT,
  `sala_id` int(3) NOT NULL,
  `pelicula_id` int(4) NOT NULL,
  `hora` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_proyeccion`),
  KEY `sala_id` (`sala_id`),
  KEY `pelicula_id` (`pelicula_id`),
  CONSTRAINT `proyeccion_ibfk_1` FOREIGN KEY (`sala_id`) REFERENCES `salas` (`id_sala`),
  CONSTRAINT `proyeccion_ibfk_2` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id_pelicula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyeccion`
--

LOCK TABLES `proyeccion` WRITE;
/*!40000 ALTER TABLE `proyeccion` DISABLE KEYS */;
INSERT INTO `proyeccion` VALUES (10,1,17,'18:00:00','2017-02-15'),(11,1,17,'20:30:00','2017-02-15'),(12,1,17,'18:00:00','2017-02-16'),(13,1,17,'20:30:00','2017-02-16'),(14,1,17,'18:00:00','2017-02-17'),(15,1,17,'20:30:00','2017-02-17'),(16,3,11,'16:45:00','2017-02-15'),(17,4,20,'17:00:00','2017-02-15'),(18,6,7,'18:00:00','2017-02-15'),(19,6,7,'20:00:00','2017-02-15'),(20,6,7,'22:00:00','2017-02-15'),(21,7,8,'18:00:00','2017-02-15'),(22,7,8,'20:00:00','2017-02-15'),(23,7,8,'22:00:00','2017-02-15'),(24,8,9,'18:00:00','2017-02-15'),(25,8,9,'20:00:00','2017-02-15'),(26,8,9,'22:00:00','2017-02-15'),(27,9,10,'18:00:00','2017-02-15'),(28,9,10,'20:00:00','2017-02-15'),(29,9,10,'22:00:00','2017-02-15'),(30,10,11,'18:00:00','2017-02-15'),(31,10,11,'20:00:00','2017-02-15'),(32,10,11,'22:00:00','2017-02-15'),(33,15,14,'18:00:00','2017-02-15'),(34,14,14,'18:00:00','2017-02-15'),(35,13,11,'22:00:00','2017-02-15'),(36,6,7,'18:00:00','2017-02-16'),(37,6,7,'20:00:00','2017-02-16'),(38,6,7,'22:00:00','2017-02-16'),(39,7,8,'18:00:00','2017-02-16'),(40,7,8,'20:00:00','2017-02-16'),(41,7,8,'22:00:00','2017-02-16'),(42,8,9,'18:00:00','2017-02-16'),(43,8,9,'20:00:00','2017-02-16'),(44,8,9,'22:00:00','2017-02-16'),(45,9,10,'18:00:00','2017-02-16'),(46,9,10,'20:00:00','2017-02-16'),(47,9,10,'22:00:00','2017-02-16'),(48,10,11,'18:00:00','2017-02-16'),(49,10,11,'20:00:00','2017-02-16'),(50,10,11,'22:00:00','2017-02-16'),(51,15,14,'18:00:00','2017-02-16'),(52,14,14,'18:00:00','2017-02-16'),(53,13,11,'22:00:00','2017-02-16'),(54,16,7,'18:00:00','2017-02-15'),(55,16,7,'20:00:00','2017-02-15'),(56,16,7,'22:00:00','2017-02-15'),(57,17,8,'18:00:00','2017-02-15'),(58,17,8,'20:00:00','2017-02-15'),(59,17,8,'22:00:00','2017-02-15'),(60,18,2,'18:00:00','2017-02-15'),(61,18,9,'20:00:00','2017-02-15'),(62,18,9,'22:00:00','2017-02-15'),(63,19,13,'18:00:00','2017-02-15'),(64,19,13,'20:00:00','2017-02-15'),(65,19,13,'22:00:00','2017-02-15'),(66,20,6,'18:00:00','2017-02-15'),(67,20,6,'20:00:00','2017-02-15'),(68,20,6,'22:00:00','2017-02-15'),(69,25,14,'18:00:00','2017-02-15'),(70,24,12,'18:00:00','2017-02-15'),(71,23,3,'22:00:00','2017-02-15'),(72,16,7,'18:00:00','2017-02-16'),(73,16,7,'20:00:00','2017-02-16'),(74,16,7,'22:00:00','2017-02-16'),(75,17,8,'18:00:00','2017-02-16'),(76,17,8,'20:00:00','2017-02-16'),(77,17,8,'22:00:00','2017-02-16'),(78,18,2,'18:00:00','2017-02-16'),(79,18,9,'20:00:00','2017-02-16'),(80,18,9,'22:00:00','2017-02-16'),(81,19,13,'18:00:00','2017-02-16'),(82,19,13,'20:00:00','2017-02-16'),(83,19,13,'22:00:00','2017-02-16'),(84,20,6,'18:00:00','2017-02-16'),(85,20,6,'20:00:00','2017-02-16'),(86,20,6,'22:00:00','2017-02-16'),(87,25,14,'18:00:00','2017-02-16'),(88,24,12,'18:00:00','2017-02-16'),(89,23,3,'22:00:00','2017-02-16'),(90,26,7,'18:00:00','2017-02-15'),(91,26,7,'20:00:00','2017-02-15'),(92,26,7,'22:00:00','2017-02-15'),(93,27,8,'18:00:00','2017-02-15'),(94,27,8,'20:00:00','2017-02-15'),(95,27,8,'22:00:00','2017-02-15'),(96,28,9,'18:00:00','2017-02-15'),(97,28,9,'20:00:00','2017-02-15'),(98,28,9,'22:00:00','2017-02-15'),(99,29,10,'18:00:00','2017-02-15'),(100,29,10,'20:00:00','2017-02-15'),(101,29,10,'22:00:00','2017-02-15'),(102,30,11,'18:00:00','2017-02-15'),(103,30,11,'20:00:00','2017-02-15'),(104,30,11,'22:00:00','2017-02-15'),(105,35,14,'18:00:00','2017-02-15'),(106,34,14,'18:00:00','2017-02-15'),(107,33,11,'22:00:00','2017-02-15'),(108,26,7,'18:00:00','2017-02-16'),(109,26,7,'20:00:00','2017-02-16'),(110,26,7,'22:00:00','2017-02-16'),(111,27,8,'18:00:00','2017-02-16'),(112,27,8,'20:00:00','2017-02-16'),(113,27,8,'22:00:00','2017-02-16'),(114,28,9,'18:00:00','2017-02-16'),(115,28,9,'20:00:00','2017-02-16'),(116,28,9,'22:00:00','2017-02-16'),(117,29,10,'18:00:00','2017-02-16'),(118,29,10,'20:00:00','2017-02-16'),(119,29,10,'22:00:00','2017-02-16'),(120,30,11,'18:00:00','2017-02-16'),(121,30,11,'20:00:00','2017-02-16'),(122,30,11,'22:00:00','2017-02-16'),(123,35,14,'18:00:00','2017-02-16'),(124,34,14,'18:00:00','2017-02-16'),(125,33,11,'22:00:00','2017-02-16'),(126,36,7,'18:00:00','2017-02-15'),(127,36,7,'20:00:00','2017-02-15'),(128,37,8,'18:00:00','2017-02-15'),(129,37,8,'20:00:00','2017-02-15'),(130,37,8,'22:00:00','2017-02-15'),(131,38,9,'18:00:00','2017-02-15'),(132,38,9,'20:00:00','2017-02-15'),(133,38,9,'22:00:00','2017-02-15'),(134,39,10,'18:00:00','2017-02-15'),(135,39,10,'20:00:00','2017-02-15'),(136,39,10,'22:00:00','2017-02-15'),(137,40,11,'18:00:00','2017-02-15'),(138,40,11,'20:00:00','2017-02-15'),(139,40,11,'22:00:00','2017-02-15'),(140,45,14,'18:00:00','2017-02-15'),(141,44,16,'18:00:00','2017-02-15'),(142,43,16,'22:00:00','2017-02-15'),(143,36,7,'18:00:00','2017-02-16'),(144,36,7,'20:00:00','2017-02-16'),(145,37,8,'18:00:00','2017-02-16'),(146,37,8,'20:00:00','2017-02-16'),(147,37,8,'22:00:00','2017-02-16'),(148,38,9,'18:00:00','2017-02-16'),(149,38,9,'20:00:00','2017-02-16'),(150,38,9,'22:00:00','2017-02-16'),(151,39,10,'18:00:00','2017-02-16'),(152,39,10,'20:00:00','2017-02-16'),(153,39,10,'22:00:00','2017-02-16'),(154,40,11,'18:00:00','2017-02-16'),(155,40,11,'20:00:00','2017-02-16'),(156,40,11,'22:00:00','2017-02-16'),(157,45,14,'18:00:00','2017-02-16'),(158,44,16,'18:00:00','2017-02-16'),(159,43,16,'22:00:00','2017-02-16');
/*!40000 ALTER TABLE `proyeccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salas` (
  `id_sala` int(3) NOT NULL AUTO_INCREMENT,
  `num_sala` int(3) DEFAULT NULL,
  `filas` int(3) DEFAULT NULL,
  `columnas` int(2) NOT NULL,
  `cine_id` int(3) NOT NULL,
  PRIMARY KEY (`id_sala`),
  KEY `cine_id` (`cine_id`),
  CONSTRAINT `salas_ibfk_1` FOREIGN KEY (`cine_id`) REFERENCES `cines` (`id_cine`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (1,1,7,10,1),(2,2,7,7,1),(3,3,7,5,1),(4,4,7,5,1),(5,6,7,5,1),(6,1,9,10,2),(7,2,9,10,2),(8,3,9,10,2),(9,4,9,10,2),(10,5,9,10,2),(11,6,9,10,2),(12,7,9,10,2),(13,8,9,10,2),(14,9,5,9,2),(15,10,10,12,2),(16,1,10,10,3),(17,2,10,10,3),(18,3,10,10,3),(19,4,10,10,3),(20,5,10,10,3),(21,6,10,10,3),(22,7,10,10,3),(23,8,10,10,3),(24,9,10,10,3),(25,10,10,12,3),(26,1,9,10,4),(27,2,9,10,4),(28,3,9,10,4),(29,4,9,10,4),(30,5,9,10,4),(31,6,9,10,4),(32,7,9,10,4),(33,8,9,10,4),(34,9,5,9,4),(35,10,10,12,4),(36,1,9,10,5),(37,2,9,10,5),(38,3,9,10,5),(39,4,9,10,5),(40,5,9,10,5),(41,6,9,10,5),(42,7,9,10,5),(43,8,9,10,5),(44,9,5,9,5),(45,10,10,12,5);
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-14 21:57:08
