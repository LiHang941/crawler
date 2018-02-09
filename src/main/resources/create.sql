/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : linuxidc

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-09 15:13:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(2048) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
