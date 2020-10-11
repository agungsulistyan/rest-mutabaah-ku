-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.40-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mutabaahku
DROP DATABASE IF EXISTS `mutabaahku`;
CREATE DATABASE IF NOT EXISTS `mutabaahku` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mutabaahku`;

-- Dumping structure for table mutabaahku.alquran_surat
DROP TABLE IF EXISTS `alquran_surat`;
CREATE TABLE IF NOT EXISTS `alquran_surat` (
  `surat_id` int(11) NOT NULL,
  `nama_surat` varchar(120) DEFAULT NULL,
  `jumlah_ayat` int(11) DEFAULT NULL,
  PRIMARY KEY (`surat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mutabaahku.alquran_surat: ~0 rows (approximately)
/*!40000 ALTER TABLE `alquran_surat` DISABLE KEYS */;
INSERT INTO `alquran_surat` (`surat_id`, `nama_surat`, `jumlah_ayat`) VALUES
	(1, 'Al-Fatihah', 7),
	(2, 'Al-Baqarah', 286),
	(3, 'Ali-Imran', 200),
	(4, 'An-Nisa’', 176),
	(5, 'Al-Ma’idah', 120),
	(6, 'Al-An’am', 165),
	(7, 'Al-A’raf', 206),
	(8, 'Al-Anfal', 75),
	(9, 'At-Taubah', 129),
	(10, 'Yunus', 109),
	(11, 'Hud', 123),
	(12, 'Yusuf', 111),
	(13, 'Ar-Ra’d', 43),
	(14, 'Ibrahim', 52),
	(15, 'Al-Hijr', 99),
	(16, 'An-Nahl', 128),
	(17, 'Al-Isra’', 111),
	(18, 'Al-Kahfi', 110),
	(19, 'Maryam', 98),
	(20, 'Ta Ha', 135),
	(21, 'Al-Anbiya’', 112),
	(22, 'Al-Hajj', 78),
	(23, 'Al-Mu’minun', 118),
	(24, 'An-Nur', 64),
	(25, 'Al-Furqan', 77),
	(26, 'Asy-Syu’ara’', 227),
	(27, 'An-Naml', 93),
	(28, 'Al-Qasas', 88),
	(29, 'Al-Ankabut', 69),
	(30, 'Ar-Ruu', 60),
	(31, 'Luqman', 34),
	(32, 'As-Sajdah', 30),
	(33, 'Al-Ahzab', 73),
	(34, 'Saba’', 54),
	(35, 'Fatir', 45),
	(36, 'Ya sin', 83),
	(37, 'Ash-Shaaffat', 182),
	(38, 'Shad', 88),
	(39, 'Az-Zumar', 75),
	(40, 'Al-Mu’min', 85),
	(41, 'Fushshilat', 54),
	(42, 'Asy-Syura', 53),
	(43, 'Az-Zukhruf', 89),
	(44, 'Ad-Dukhan', 59),
	(45, 'Al-Jaatsiyah', 37),
	(46, 'Al-Ahqaf', 35),
	(47, 'Muhammad', 38),
	(48, 'Al-Fath', 29),
	(49, 'Al-Hujurat', 18),
	(50, 'Qaaf', 45),
	(51, 'Adz-dzariyat', 60),
	(52, 'Ath-Thuur', 49),
	(53, 'An-Najm', 62),
	(54, 'Al-Qamar', 55),
	(55, 'Ar-Rahman', 78),
	(56, 'Al-Waqi’ah', 96),
	(57, 'Al-Hadid', 29),
	(58, 'Al-Mujadilah', 22),
	(59, 'Al-Hasyr', 24),
	(60, 'Al-Mumtahanah', 13),
	(61, 'Ash-shaf', 14),
	(62, 'Al-Jumu’ah', 11),
	(63, 'Al-Munafiqun', 11),
	(64, 'At-taghabun', 18),
	(65, 'Ath-Thalaq', 12),
	(66, 'At-Tahrim', 12),
	(67, 'Al-Mulk', 30),
	(68, 'Al-Qalam', 52),
	(69, 'Al-Haqqah', 52),
	(70, 'Al-Ma’arij', 44),
	(71, 'Nuh', 28),
	(72, 'Al-Jin', 28),
	(73, 'Al-Muzammil', 20),
	(74, 'Al-Muddatstsir', 56),
	(75, 'Al-Qiyamah', 40),
	(76, 'Al-Insan', 31),
	(77, 'Al-Mursalat', 50),
	(78, 'An-Naba’', 40),
	(79, 'An-Nazi’at', 46),
	(80, '‘Abasa', 42),
	(81, 'At-Takwir', 29),
	(82, 'Al-Infithar', 19),
	(83, 'Al-Muthaffifin', 36),
	(84, 'Al-Insyiqaq', 25),
	(85, 'Al-Buruj', 22),
	(86, 'Ath-Thariq', 17),
	(87, 'Al-A’laa', 19),
	(88, 'Al-Ghasyiyah', 26),
	(89, 'Al-Fajr', 30),
	(90, 'Al-Balad', 20),
	(91, 'Asy-Syams', 15),
	(92, 'Al-Lail', 21),
	(93, 'Adh-Dhuha', 11),
	(94, 'Al-Insyirah', 8),
	(95, 'At-Tin', 8),
	(96, 'Al-‘Alaq', 19),
	(97, 'Al-Qadr', 5),
	(98, 'Al-Bayyinah', 8),
	(99, 'Al-Zalzalah', 8),
	(100, 'Al-‘Adiyat', 11),
	(101, 'Al-Qari’ah', 11),
	(102, 'At-Takatsur', 8),
	(103, 'Al-‘Ashr', 3),
	(104, 'Al-Humazah', 9),
	(105, 'Al-Fil', 5),
	(106, 'Quraysh', 4),
	(107, 'Al-Ma’un', 7),
	(108, 'Al-Kautsar', 3),
	(109, 'Al-Kafirun', 6),
	(110, 'An-Nashr', 3),
	(111, 'Al-Lahab', 5),
	(112, 'Al-Ikhlas', 4),
	(113, 'Al-Falaq', 5),
	(114, 'An-Nas', 6);
/*!40000 ALTER TABLE `alquran_surat` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.bm_kegiatantahsintahfidz
DROP TABLE IF EXISTS `bm_kegiatantahsintahfidz`;
CREATE TABLE IF NOT EXISTS `bm_kegiatantahsintahfidz` (
  `id_bmktt` int(11) NOT NULL AUTO_INCREMENT,
  `id_bukumutabaah` int(11) NOT NULL DEFAULT '0',
  `tanggal` datetime DEFAULT NULL,
  `surat` int(11) NOT NULL DEFAULT '0',
  `ayat` int(11) NOT NULL DEFAULT '0',
  `nilai` int(11) DEFAULT NULL,
  `catatan` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id_bmktt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.bm_kegiatantahsintahfidz: ~0 rows (approximately)
/*!40000 ALTER TABLE `bm_kegiatantahsintahfidz` DISABLE KEYS */;
/*!40000 ALTER TABLE `bm_kegiatantahsintahfidz` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.bm_kegiatantilawah
DROP TABLE IF EXISTS `bm_kegiatantilawah`;
CREATE TABLE IF NOT EXISTS `bm_kegiatantilawah` (
  `id_bmkt` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  `tanggal` datetime DEFAULT NULL,
  `surat` int(11) NOT NULL DEFAULT '0',
  `ayat` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_bmkt`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `bm_kegiatantilawah_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.bm_kegiatantilawah: ~10 rows (approximately)
/*!40000 ALTER TABLE `bm_kegiatantilawah` DISABLE KEYS */;
INSERT INTO `bm_kegiatantilawah` (`id_bmkt`, `id_user`, `tanggal`, `surat`, `ayat`) VALUES
	(10, 1, '2020-10-11 08:24:08', 3, 20),
	(11, 1, '2020-10-11 08:24:39', 3, 1),
	(12, 1, '2020-10-11 08:24:51', 2, 1),
	(13, 1, '2020-10-11 10:06:38', 7, 7),
	(14, 1, '2020-10-11 10:06:43', 7, 7),
	(15, 1, '2020-10-11 10:06:45', 7, 7),
	(16, 1, '2020-10-11 10:06:46', 7, 7),
	(17, 1, '2020-10-11 10:06:48', 7, 7),
	(18, 1, '2020-10-11 10:06:49', 7, 7),
	(19, 1, '2020-10-11 10:06:51', 7, 7),
	(21, 1, '2020-10-11 00:00:00', 10, 1);
/*!40000 ALTER TABLE `bm_kegiatantilawah` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.halaqoh
DROP TABLE IF EXISTS `halaqoh`;
CREATE TABLE IF NOT EXISTS `halaqoh` (
  `id_halaqoh` int(11) NOT NULL AUTO_INCREMENT,
  `nama_halaqoh` varchar(255) DEFAULT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_halaqoh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.halaqoh: ~0 rows (approximately)
/*!40000 ALTER TABLE `halaqoh` DISABLE KEYS */;
/*!40000 ALTER TABLE `halaqoh` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.murabbi
DROP TABLE IF EXISTS `murabbi`;
CREATE TABLE IF NOT EXISTS `murabbi` (
  `id_murabbi` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_murabbi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.murabbi: ~0 rows (approximately)
/*!40000 ALTER TABLE `murabbi` DISABLE KEYS */;
/*!40000 ALTER TABLE `murabbi` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.pengurus
DROP TABLE IF EXISTS `pengurus`;
CREATE TABLE IF NOT EXISTS `pengurus` (
  `id_murabbi` int(11) NOT NULL DEFAULT '0',
  `id_halaqoh` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_murabbi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.pengurus: ~0 rows (approximately)
/*!40000 ALTER TABLE `pengurus` DISABLE KEYS */;
/*!40000 ALTER TABLE `pengurus` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.santri
DROP TABLE IF EXISTS `santri`;
CREATE TABLE IF NOT EXISTS `santri` (
  `id_santri` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_santri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.santri: ~0 rows (approximately)
/*!40000 ALTER TABLE `santri` DISABLE KEYS */;
/*!40000 ALTER TABLE `santri` ENABLE KEYS */;

-- Dumping structure for table mutabaahku.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nama_user` varchar(255) DEFAULT NULL,
  `username` varchar(80) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mutabaahku.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `nama_user`, `username`, `password`) VALUES
	(1, 'Agung Sulistyanto', 'agung.sulistyanto', 'sulistyan'),
	(2, 'tito', 'tito.hendrawan', 'tito'),
	(3, 'aaaa', 'aaaa', 'bbbbb'),
	(4, 'alif', 'alifiandra', 'alifalif');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
