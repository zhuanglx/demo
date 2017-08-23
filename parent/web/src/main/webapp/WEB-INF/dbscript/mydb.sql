/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-08-23 18:12:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_dba`
-- ----------------------------
DROP TABLE IF EXISTS `t_dba`;
CREATE TABLE `t_dba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xxx` varchar(255) DEFAULT NULL,
  `yyy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dba
-- ----------------------------
INSERT INTO `t_dba` VALUES ('1', '11', '111');
INSERT INTO `t_dba` VALUES ('2', '1', '1');
INSERT INTO `t_dba` VALUES ('3', '1', '1');
INSERT INTO `t_dba` VALUES ('4', '1', null);
INSERT INTO `t_dba` VALUES ('5', '1', null);
INSERT INTO `t_dba` VALUES ('6', '1', null);
INSERT INTO `t_dba` VALUES ('7', '1', null);
INSERT INTO `t_dba` VALUES ('8', '1', null);
INSERT INTO `t_dba` VALUES ('9', '1', null);
INSERT INTO `t_dba` VALUES ('10', '1', null);
INSERT INTO `t_dba` VALUES ('11', '1', null);
INSERT INTO `t_dba` VALUES ('12', '1', null);
INSERT INTO `t_dba` VALUES ('13', '1', null);
INSERT INTO `t_dba` VALUES ('14', '1', null);
INSERT INTO `t_dba` VALUES ('15', '1', null);
INSERT INTO `t_dba` VALUES ('16', '1', null);
INSERT INTO `t_dba` VALUES ('17', '1', null);
INSERT INTO `t_dba` VALUES ('18', '1', null);
INSERT INTO `t_dba` VALUES ('19', '1', null);
INSERT INTO `t_dba` VALUES ('20', '1', null);
INSERT INTO `t_dba` VALUES ('21', '1', null);
INSERT INTO `t_dba` VALUES ('22', '1', null);
INSERT INTO `t_dba` VALUES ('23', '1', null);
INSERT INTO `t_dba` VALUES ('24', '1', null);
INSERT INTO `t_dba` VALUES ('25', '1', null);
INSERT INTO `t_dba` VALUES ('26', '1', null);
INSERT INTO `t_dba` VALUES ('27', '1', null);
INSERT INTO `t_dba` VALUES ('28', '1', null);
INSERT INTO `t_dba` VALUES ('29', '1', null);
INSERT INTO `t_dba` VALUES ('30', '1', null);
INSERT INTO `t_dba` VALUES ('31', '1', null);
INSERT INTO `t_dba` VALUES ('32', '1', null);
INSERT INTO `t_dba` VALUES ('33', '1', null);
INSERT INTO `t_dba` VALUES ('34', '1', null);
INSERT INTO `t_dba` VALUES ('35', '1', null);
INSERT INTO `t_dba` VALUES ('36', '1', null);
INSERT INTO `t_dba` VALUES ('37', '1', null);
INSERT INTO `t_dba` VALUES ('38', '1', null);
INSERT INTO `t_dba` VALUES ('39', '1', null);
INSERT INTO `t_dba` VALUES ('40', '1', null);
INSERT INTO `t_dba` VALUES ('41', '1', null);
INSERT INTO `t_dba` VALUES ('42', '1', null);
INSERT INTO `t_dba` VALUES ('43', '1', null);
INSERT INTO `t_dba` VALUES ('44', '1', null);
INSERT INTO `t_dba` VALUES ('45', '1', null);
INSERT INTO `t_dba` VALUES ('46', '1', null);
INSERT INTO `t_dba` VALUES ('47', '1', null);
INSERT INTO `t_dba` VALUES ('48', '1', null);
INSERT INTO `t_dba` VALUES ('49', '1', null);
INSERT INTO `t_dba` VALUES ('50', '1', null);
INSERT INTO `t_dba` VALUES ('51', '1', null);
INSERT INTO `t_dba` VALUES ('52', '1', null);
INSERT INTO `t_dba` VALUES ('53', '1', null);
INSERT INTO `t_dba` VALUES ('54', '1', null);
INSERT INTO `t_dba` VALUES ('55', '1', null);
INSERT INTO `t_dba` VALUES ('56', '1', null);
INSERT INTO `t_dba` VALUES ('57', '1', null);
INSERT INTO `t_dba` VALUES ('58', '1', null);
INSERT INTO `t_dba` VALUES ('59', '1', null);
INSERT INTO `t_dba` VALUES ('60', '1', null);
INSERT INTO `t_dba` VALUES ('61', '1', null);
INSERT INTO `t_dba` VALUES ('62', '1', null);
INSERT INTO `t_dba` VALUES ('63', '1', null);
INSERT INTO `t_dba` VALUES ('64', '1', null);
INSERT INTO `t_dba` VALUES ('65', '11', null);
INSERT INTO `t_dba` VALUES ('66', '1', null);
INSERT INTO `t_dba` VALUES ('67', '1', null);
INSERT INTO `t_dba` VALUES ('68', '1', null);
INSERT INTO `t_dba` VALUES ('69', '1', null);
INSERT INTO `t_dba` VALUES ('70', '1', null);
INSERT INTO `t_dba` VALUES ('71', '1', null);
INSERT INTO `t_dba` VALUES ('72', '1', null);
INSERT INTO `t_dba` VALUES ('73', '1', null);
INSERT INTO `t_dba` VALUES ('74', '1', null);

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
