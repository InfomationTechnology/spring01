/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-28 17:01:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '张三', '0');
INSERT INTO `t_account` VALUES ('2', '李四', '100');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'Jerry', '20');
INSERT INTO `t_user` VALUES ('3', '花花', '25');
INSERT INTO `t_user` VALUES ('4', '张三', '25');
INSERT INTO `t_user` VALUES ('5', '张三90', '25');
INSERT INTO `t_user` VALUES ('6', '老王95', '25');
INSERT INTO `t_user` VALUES ('7', '老王83', '25');
INSERT INTO `t_user` VALUES ('8', '老王59', '25');
INSERT INTO `t_user` VALUES ('9', '老王83', '25');
INSERT INTO `t_user` VALUES ('10', '老王88', '25');
INSERT INTO `t_user` VALUES ('11', '老王49', '25');
INSERT INTO `t_user` VALUES ('12', '老王80', '25');
INSERT INTO `t_user` VALUES ('13', '老王80', '25');
INSERT INTO `t_user` VALUES ('14', '老王33', '25');
INSERT INTO `t_user` VALUES ('15', '老王49', '25');
