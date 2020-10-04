# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: mutabaahku
# ------------------------------------------------------
# Server version 5.5.5-10.4.14-MariaDB

#
# Source for table bm_kegiatantahsintahfidz
#

DROP TABLE IF EXISTS `bm_kegiatantahsintahfidz`;
CREATE TABLE `bm_kegiatantahsintahfidz` (
  `id_bmktt` int(11) NOT NULL AUTO_INCREMENT,
  `id_bukumutabaah` int(11) NOT NULL DEFAULT 0,
  `tanggal` datetime DEFAULT NULL,
  `surat` int(11) NOT NULL DEFAULT 0,
  `ayat` int(11) NOT NULL DEFAULT 0,
  `nilai` int(11) DEFAULT NULL,
  `catatan` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id_bmktt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table bm_kegiatantahsintahfidz
#

LOCK TABLES `bm_kegiatantahsintahfidz` WRITE;
/*!40000 ALTER TABLE `bm_kegiatantahsintahfidz` DISABLE KEYS */;
/*!40000 ALTER TABLE `bm_kegiatantahsintahfidz` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table bm_kegiatantilawah
#

DROP TABLE IF EXISTS `bm_kegiatantilawah`;
CREATE TABLE `bm_kegiatantilawah` (
  `id_bmkt` int(11) NOT NULL AUTO_INCREMENT,
  `id_bukumutabaah` int(11) NOT NULL DEFAULT 0,
  `tanggal` datetime DEFAULT NULL,
  `surat` int(11) NOT NULL DEFAULT 0,
  `ayat` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_bmkt`),
  KEY `id_bukumutabaah` (`id_bukumutabaah`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table bm_kegiatantilawah
#

LOCK TABLES `bm_kegiatantilawah` WRITE;
/*!40000 ALTER TABLE `bm_kegiatantilawah` DISABLE KEYS */;
INSERT INTO `bm_kegiatantilawah` VALUES (3,13,'2020-09-27',1,7);
INSERT INTO `bm_kegiatantilawah` VALUES (4,13,'2020-09-28',2,7);
INSERT INTO `bm_kegiatantilawah` VALUES (6,14,'2020-09-27',1,7);
INSERT INTO `bm_kegiatantilawah` VALUES (7,14,'2020-09-28',2,7);
INSERT INTO `bm_kegiatantilawah` VALUES (8,14,'1970-01-19 19:56:30',1000,5000);
INSERT INTO `bm_kegiatantilawah` VALUES (9,14,'1970-01-19 19:56:30',10,5);
/*!40000 ALTER TABLE `bm_kegiatantilawah` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table bukumutabaah
#

DROP TABLE IF EXISTS `bukumutabaah`;
CREATE TABLE `bukumutabaah` (
  `id_bukumutabaah` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_bukumutabaah`),
  KEY `bukumutabaah_ibfk_1` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table bukumutabaah
#

LOCK TABLES `bukumutabaah` WRITE;
/*!40000 ALTER TABLE `bukumutabaah` DISABLE KEYS */;
INSERT INTO `bukumutabaah` VALUES (13,1);
INSERT INTO `bukumutabaah` VALUES (14,2);
/*!40000 ALTER TABLE `bukumutabaah` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table halaqoh
#

DROP TABLE IF EXISTS `halaqoh`;
CREATE TABLE `halaqoh` (
  `id_halaqoh` int(11) NOT NULL AUTO_INCREMENT,
  `nama_halaqoh` varchar(255) DEFAULT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_halaqoh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table halaqoh
#

LOCK TABLES `halaqoh` WRITE;
/*!40000 ALTER TABLE `halaqoh` DISABLE KEYS */;
/*!40000 ALTER TABLE `halaqoh` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table murabbi
#

DROP TABLE IF EXISTS `murabbi`;
CREATE TABLE `murabbi` (
  `id_murabbi` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_murabbi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table murabbi
#

LOCK TABLES `murabbi` WRITE;
/*!40000 ALTER TABLE `murabbi` DISABLE KEYS */;
/*!40000 ALTER TABLE `murabbi` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table pengurus
#

DROP TABLE IF EXISTS `pengurus`;
CREATE TABLE `pengurus` (
  `id_murabbi` int(11) NOT NULL DEFAULT 0,
  `id_halaqoh` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_murabbi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table pengurus
#

LOCK TABLES `pengurus` WRITE;
/*!40000 ALTER TABLE `pengurus` DISABLE KEYS */;
/*!40000 ALTER TABLE `pengurus` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table santri
#

DROP TABLE IF EXISTS `santri`;
CREATE TABLE `santri` (
  `id_santri` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_santri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table santri
#

LOCK TABLES `santri` WRITE;
/*!40000 ALTER TABLE `santri` DISABLE KEYS */;
/*!40000 ALTER TABLE `santri` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nama_user` varchar(255) DEFAULT NULL,
  `username` varchar(80) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

#
# Dumping data for table user
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Agung Sulistyanto','agung.sulistyanto','sulistyan');
INSERT INTO `user` VALUES (2,'tito','tito.hendrawan','tito');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table bm_kegiatantilawah
#

ALTER TABLE `bm_kegiatantilawah`
ADD CONSTRAINT `bm_kegiatantilawah_ibfk_1` FOREIGN KEY (`id_bukumutabaah`) REFERENCES `bukumutabaah` (`id_bukumutabaah`);

#
#  Foreign keys for table bukumutabaah
#

ALTER TABLE `bukumutabaah`
ADD CONSTRAINT `bukumutabaah_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
