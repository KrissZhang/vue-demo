/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : vue

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-20 17:26:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `key` varchar(255) DEFAULT NULL COMMENT '测试键',
  `value` varchar(255) DEFAULT NULL COMMENT '测试值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_key` (`key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1', 'key1', 'value1');
INSERT INTO `t_test` VALUES ('2', 'key2', 'value2');
INSERT INTO `t_test` VALUES ('3', 'key3', 'value3');
INSERT INTO `t_test` VALUES ('4', 'key4', 'value4');
INSERT INTO `t_test` VALUES ('5', 'key5', 'value5');
