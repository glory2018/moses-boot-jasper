/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-03-08 19:34:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1001', 'Iron Iron', '5');
INSERT INTO `product` VALUES ('1001', 'Chair Shoe', '25');
INSERT INTO `product` VALUES ('1001', 'Telephone Clock', '25');
INSERT INTO `product` VALUES ('1001', 'Chair Chair', '25');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Shoe', '13');
INSERT INTO `product` VALUES ('1001', 'Clock Clock', '24');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Chair', '10');
INSERT INTO `product` VALUES ('1001', 'Telephone Shoe', '8');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Clock', '23');
INSERT INTO `product` VALUES ('1001', 'Clock Telephone', '17');
INSERT INTO `product` VALUES ('1001', 'Telephone Ice Tea', '20');
INSERT INTO `product` VALUES ('1001', 'Telephone Iron', '9');
INSERT INTO `product` VALUES ('1001', 'Clock Ice Tea', '17');
INSERT INTO `product` VALUES ('1001', 'Telephone Clock', '18');
INSERT INTO `product` VALUES ('1001', 'Telephone Iron', '12');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Chair', '9');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Shoe', '19');
INSERT INTO `product` VALUES ('1001', 'Clock Ice Tea', '22');
INSERT INTO `product` VALUES ('1001', 'Chair Clock', '17');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Ice Tea', '11');
INSERT INTO `product` VALUES ('1001', 'Ice Tea Telephone', '20');
INSERT INTO `product` VALUES ('1001', 'Chair Chair', '11');
INSERT INTO `product` VALUES ('1001', 'Iron Iron', '7');
INSERT INTO `product` VALUES ('1001', 'Shoe Chair', '8');
INSERT INTO `product` VALUES ('1001', 'Chair Shoe', '7');
INSERT INTO `product` VALUES ('1002', 'Shoe Shoe', '16');
INSERT INTO `product` VALUES ('1002', 'Shoe Shoe', '25');
INSERT INTO `product` VALUES ('1002', 'Telephone Iron', '23');
INSERT INTO `product` VALUES ('1002', 'Clock Iron', '3');
INSERT INTO `product` VALUES ('1002', 'Chair Telephone', '11');
INSERT INTO `product` VALUES ('1002', 'Shoe Iron', '23');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Telephone', '5');
INSERT INTO `product` VALUES ('1002', 'Clock Iron', '19');
INSERT INTO `product` VALUES ('1002', 'Iron Chair', '18');
INSERT INTO `product` VALUES ('1002', 'Chair Iron', '26');
INSERT INTO `product` VALUES ('1002', 'Telephone Shoe', '8');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Iron', '3');
INSERT INTO `product` VALUES ('1002', 'Clock Shoe', '9');
INSERT INTO `product` VALUES ('1002', 'Clock Ice Tea', '22');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Shoe', '15');
INSERT INTO `product` VALUES ('1002', 'Shoe Clock', '3');
INSERT INTO `product` VALUES ('1002', 'Clock Ice Tea', '21');
INSERT INTO `product` VALUES ('1002', 'Iron Chair', '20');
INSERT INTO `product` VALUES ('1002', 'Telephone Clock', '9');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Ice Tea', '10');
INSERT INTO `product` VALUES ('1002', 'Iron Ice Tea', '18');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Clock', '6');
INSERT INTO `product` VALUES ('1002', 'Ice Tea Iron', '18');
INSERT INTO `product` VALUES ('1002', 'Clock Clock', '21');
INSERT INTO `product` VALUES ('1002', 'Iron Iron', '2');
