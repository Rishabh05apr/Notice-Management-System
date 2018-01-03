-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.22-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema nms
--

CREATE DATABASE IF NOT EXISTS nms;
USE nms;

--
-- Definition of table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `id` varchar(450) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `emailid` varchar(60) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 PACK_KEYS=1;

--
-- Dumping data for table `faculty`
--

/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`id`,`name`,`emailid`,`password`) VALUES 
 ('1001','pankaj','pankaj45353@gmail.com','pankajpankaj'),
 ('1002','mehul','mehul3223@gmail.com','mehul123'),
 ('1003','mukesh','mukesh_123@gmail.com','mukeshgupta123'),
 ('1004','priyanka','priyanka9apr@gmail.com','pri123'),
 ('1005','neha','neha123@gmail.com','neha123');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Rollno` varchar(15) NOT NULL,
  `Course` varchar(15) DEFAULT NULL,
  `Branch` varchar(15) DEFAULT NULL,
  `Year` varchar(5) DEFAULT NULL,
  `Shift` varchar(5) DEFAULT NULL,
  `Section` varchar(5) DEFAULT NULL,
  `Grp` varchar(5) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Mobileno` varchar(15) DEFAULT NULL,
  `Emailid` varchar(100) DEFAULT NULL,
  `BatchCounsellor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Rollno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`Rollno`,`Course`,`Branch`,`Year`,`Shift`,`Section`,`Grp`,`Name`,`Mobileno`,`Emailid`,`BatchCounsellor`) VALUES 
 ('10eskcs101','b.tech','cs','1','1','a','1','ajay','7776126382','skitstudent1@gmail.com','mukesh'),
 ('10eskcs102','b.tech','cs','1','1','a','1','nitin','8723123672','skitstudent2@gmail.com','mukesh'),
 ('10eskcs103','b.tech','ec','2','2','b','2','vijay','9827323562','skitstudent3@gmail.com','girish'),
 ('10eskcs104','b.tech','civil','1','2','b','1','dhawan','8732132362','skitstudent4@gmail.com','manoj'),
 ('10eskcs105','b.tech','mech','1','1','a','1','virat','9236173273','skitstudent05@gmail.com','neha'),
 ('10eskcs106','b.tech','cs','2','2','b','2','rajat','7721532178','skitstudent6@gmail.com','pankaj'),
 ('10eskcs107','b.tech','cs','3','1','b','1','nikita','9823712736','skitstudent7@gmail.com','saurabh'),
 ('10eskcs108','b.tech','ec','2','1','b','2','jatin','9384387643','skitstudent8@gmail.com','priyanka'),
 ('10eskcs109','b.tech','ec','1','2','a','2','syed','9343274237','skitstudent9@gmail.com','anil'),
 ('10eskcs110','b.tech','mech','1','1','a','1','akansha','9473434637','skitstudent10@gmail.com','mehul');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
