/*
SQLyog v10.2 
MySQL - 5.1.73-community : Database - chout
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`chout` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `chout`;

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `userID` int(11) DEFAULT NULL,
  `newsID` int(11) DEFAULT NULL,
  KEY `userID` (`userID`),
  KEY `newsID` (`newsID`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`newsID`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `collect` */

insert  into `collect`(`userID`,`newsID`) values (3,1),(3,2);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fatherID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `newsID` int(11) DEFAULT NULL,
  `tier` int(11) DEFAULT NULL,
  `text` varchar(200) CHARACTER SET gb2312 DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`),
  KEY `newsID` (`newsID`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`newsID`) REFERENCES `news` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`fatherID`,`userID`,`newsID`,`tier`,`text`,`date`) values (3,-1,3,1,0,'好新闻','2019-05-15 20:00:22'),(4,3,3,1,1,'+1','2019-05-15 20:01:39'),(5,3,3,1,1,'这是什么鬼','2019-05-20 01:43:20'),(6,3,3,1,1,'垃圾新闻','2019-05-20 20:50:39');

/*Table structure for table `goodnews` */

DROP TABLE IF EXISTS `goodnews`;

CREATE TABLE `goodnews` (
  `newsID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  KEY `newsID` (`newsID`),
  KEY `userID` (`userID`),
  CONSTRAINT `goodnews_ibfk_1` FOREIGN KEY (`newsID`) REFERENCES `news` (`id`),
  CONSTRAINT `goodnews_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `goodnews` */

insert  into `goodnews`(`newsID`,`userID`) values (1,4),(1,5),(1,3),(2,3),(3,3);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `text` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gb2312;

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`pic`,`text`,`url`,`userID`,`type`,`date`) values (1,'标题',NULL,'好新闻','www.baidu.com',3,'图片区','2019-05-04 14:37:12'),(2,'必应',NULL,'打算看鹿鼎记昆仑决撒旦大神','www.bing.com',3,NULL,NULL),(3,'哔哩哔哩',NULL,'旦木大木大木大木大木大木大木大木','www.bilibili.com',3,'42区',NULL),(9,NULL,'\\img\\newsImg/5939d6dd/19d1/44ac/a339/6ee59b42a59a/win.jpg','呜呜呜呜',NULL,3,'图片',NULL),(11,'546','564','456',NULL,3,NULL,NULL),(12,'4854',NULL,NULL,NULL,3,NULL,NULL),(13,'4545',NULL,NULL,NULL,3,NULL,NULL),(14,'',NULL,'aaaaa','',3,'42区','2019-05-09 16:59:41'),(15,NULL,'/img/newsImg/a9d7246f/4a07/4fd7/a8be/4b2c6b71f9aa/icon.jpg','9999999',NULL,3,'图片','2019-05-09 17:00:23'),(16,NULL,'/img/newsImg/5fd8b48f/0272/484c/8b86/a80da2f1a31f/win.jpg','哈哈哈哈',NULL,3,'图片','2019-05-11 17:57:21'),(17,NULL,'/img/newsImg/ea30352e/ebc9/48e0/a89c/523dc73482d1/c7c59147.jpg','发布一条图片新闻',NULL,3,'42区','2019-05-20 21:06:08');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patname` varchar(20) DEFAULT NULL,
  `usename` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `headimgurl` varchar(200) DEFAULT '#',
  `explains` varchar(200) DEFAULT NULL,
  `sex` varchar(1) DEFAULT '男',
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`patname`,`usename`,`password`,`headimgurl`,`explains`,`sex`,`birthday`) values (3,'张三','12345678911','123','/images/user.png','good boy','男',NULL),(4,'张三','12345678922','123','/images/user.png','good boy','男',NULL),(5,'张三','12345678933','123','/images/user.png','good boy','男',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
