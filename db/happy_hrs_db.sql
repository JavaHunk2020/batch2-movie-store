/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : happy_hrs_db

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-05 18:06:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `users_tbl`;
CREATE TABLE `users_tbl` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  `salutation` varchar(4) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users_tbl
-- ----------------------------
INSERT INTO `users_tbl` VALUES ('1', 'yadna01', 'test', 'Nagendra Kumar', 'nagen@gmail.com', '923489438', 'Mr.', 'https://www.goodmorningimagesdownload.com/wp-content/uploads/2019/10/Nice-Whatsapp-Dp-Profile-Images-101-300x300.jpg', '2020-05-05 17:09:19');
INSERT INTO `users_tbl` VALUES ('2', 'javatech1000@gmail.com', 'tetetete', 'JavaHunk Technologies', 'javatech1000@gmail.com', '8700134973', 'Mr.', 'https://www.goodmorningimagesdownload.com/wp-content/uploads/2019/10/Nice-Whatsapp-Dp-Profile-Images-101-300x300.jpg', '2020-05-05 17:27:25');
INSERT INTO `users_tbl` VALUES ('3', 'synergisticit2020@gmail.com', 'cool', 'Amita', 'synergisticit2020@gmail.com', '3242424234', 'Miss', 'https://www.goodmorningimagesdownload.com/wp-content/uploads/2019/10/Nice-Whatsapp-Dp-Profile-Images-101-300x300.jpg', '2020-05-05 17:57:07');
