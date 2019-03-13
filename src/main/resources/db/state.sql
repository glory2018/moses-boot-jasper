/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-03-08 19:35:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `country` varchar(40) DEFAULT NULL COMMENT '国家',
  `city` varchar(40) DEFAULT NULL COMMENT '城市'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('CHINA', 'Beijing');
INSERT INTO `state` VALUES ('CHINA', 'Beijing');
INSERT INTO `state` VALUES ('CHINA', 'Beijing');
INSERT INTO `state` VALUES ('CHINA', 'Shanghai');
INSERT INTO `state` VALUES ('USA', 'Chicago');
INSERT INTO `state` VALUES ('USA', 'Chicago');
INSERT INTO `state` VALUES ('USA', 'Alaska');
INSERT INTO `state` VALUES ('USA', 'Alaska');
INSERT INTO `state` VALUES ('USA', 'Alaska');
