/*
 Navicat Premium Data Transfer

 Source Server         : Nay
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : book_manage

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 09/10/2020 23:09:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banhao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bianzhu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chubanshe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chubanDate` date NULL DEFAULT NULL,
  `danjia` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kucun` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (3, '1002', 'php攻略', '5520', '小红', '美山出版社', '2020-10-02', '50', 10);
INSERT INTO `t_book` VALUES (4, '1001', 'java攻略', '5510', '小明', '美工出版社', '2020-10-01', '50', 10);
INSERT INTO `t_book` VALUES (6, '1003', '三国演义', '5530', '小明', '中国！@@@@', '2020-10-09', '50', 20);

-- ----------------------------
-- Table structure for t_config
-- ----------------------------
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_site` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headStr` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `layuiStr` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_config
-- ----------------------------
INSERT INTO `t_config` VALUES (1, '图书管理系统', 'https://github.com/1046762075', '<!-- 强制  高速模式 渲染网页    -->\n<meta NAME=”renderer” content=”webkit”>\n<!-- 强制  高速模式 渲染网页    -->\n\n<link href=\"/static/favicon.ico\" rel=\"shortcut icon\" />\n\n<!--添加  jq  支持加载-->\n<script	src=\"/static/easy-ui/jquery.min.js\"></script>\n<!--添加  jq  支持加载-->', '<!--添加 layui  支持加载-->\n<link rel=\"stylesheet\"	href=\"/static/layui-v2.2.5/layui/css/layui.css\">\n<script	src=\"/static/layui-v2.2.5/layui/layui.js\"></script>\n<!--添加 layui  支持加载-->');

-- ----------------------------
-- Table structure for t_cui_hai
-- ----------------------------
DROP TABLE IF EXISTS `t_cui_hai`;
CREATE TABLE `t_cui_hai`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userSubId` int(11) NULL DEFAULT NULL,
  `jieyuerenId` int(11) NULL DEFAULT NULL,
  `bookId` int(11) NULL DEFAULT NULL,
  `createDateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cui_hai
-- ----------------------------
INSERT INTO `t_cui_hai` VALUES (1, 18, 12, 6, '2020-10-04 21:45:17');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDateTime` datetime(0) NULL DEFAULT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tree
-- ----------------------------
DROP TABLE IF EXISTS `t_tree`;
CREATE TABLE `t_tree`  (
  `id` int(11) NULL DEFAULT NULL,
  `text` varchar(46) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `father` int(11) NULL DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(46) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconCls` varchar(46) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permissions` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dd_id` varchar(46) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tree
-- ----------------------------
INSERT INTO `t_tree` VALUES (99, '借阅', -1, NULL, 'close', NULL, NULL, NULL);
INSERT INTO `t_tree` VALUES (6, '信息管理', -1, NULL, 'close', NULL, NULL, NULL);
INSERT INTO `t_tree` VALUES (61010, '图书管理', 6, '/houtai/book/manage', 'opend', '&#xe63c;', NULL, 'book');
INSERT INTO `t_tree` VALUES (17, '借阅', -1, NULL, 'close', NULL, NULL, NULL);
INSERT INTO `t_tree` VALUES (171005, '我的借阅记录', 17, '/houtai/user/sub/my', 'opend', '&#xe612;', NULL, 'submy');
INSERT INTO `t_tree` VALUES (171000, '我要借阅', 17, '/houtai/book/sub/manage', 'opend', '&#xe612;', NULL, 'clienttype');
INSERT INTO `t_tree` VALUES (171009, '我的催还记录', 17, '/houtai/cuihai/my', 'opend', '&#xe612;', NULL, 'mysub');
INSERT INTO `t_tree` VALUES (61013, '借阅记录', 6, '/houtai/user/sub/manage', 'opend', '&#xe612;', NULL, 'sub');
INSERT INTO `t_tree` VALUES (61015, '读者信息管理和维护', 6, '/houtai/user/manage', 'opend', '&#xe612;', NULL, 'user');
INSERT INTO `t_tree` VALUES (61014, '催还记录', 6, '/houtai/cuihai/manage', 'opend', '&#xe612;', NULL, 'cui');
INSERT INTO `t_tree` VALUES (171010, '留言板', 17, '/houtai/message/my', 'opend', '&#xe612;', NULL, 'myliuyan');
INSERT INTO `t_tree` VALUES (61017, '留言板管理', 6, '/houtai/message/manage', 'opend', '&#xe612;', NULL, 'liuyan');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trueName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex_` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuIds` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDateTime` datetime(0) NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `weiyi`(`num_`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (9, 'firenay', '超级管理员', '18337537555', '男', '6,61010,61015,61013,61014,61017', '2020-04-29 15:50:59', '0680d00353f3555fe7c01f11ed89bf8b', '超级管理员', 1);
INSERT INTO `t_user` VALUES (12, '100', '陈豪', '12345678900', '男', '17,171000,171005,171009,171011,171010', '2019-12-26 23:58:07', '0680d00353f3555fe7c01f11ed89bf8b', '新用户', 2);
INSERT INTO `t_user` VALUES (13, '200', '小红', '12345678900', '女', '17,171000,171005,171009,171011,171010', '2020-06-24 23:59:49', '0680d00353f3555fe7c01f11ed89bf8b', '小红', 2);
INSERT INTO `t_user` VALUES (14, 'admin', '管理员', '18471484845', '男', '6,61010,61015,61013,61014,61017', '2020-06-30 12:13:51', 'FD58E1D93432F4DA5B6FF1C2821B2327', '管理员', 1);
INSERT INTO `t_user` VALUES (15, 'fire', 'jxl', '15456878945', '男', '17,171000,171005,171009,171011,171010', '2020-06-30 13:21:51', '0680d00353f3555fe7c01f11ed89bf8b', '新用户', 2);

-- ----------------------------
-- Table structure for t_user_sub
-- ----------------------------
DROP TABLE IF EXISTS `t_user_sub`;
CREATE TABLE `t_user_sub`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `bookId` int(11) NULL DEFAULT NULL,
  `subDateTime` datetime(0) NULL DEFAULT NULL,
  `returnDateTime` datetime(0) NULL DEFAULT NULL,
  `type` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_sub
-- ----------------------------
INSERT INTO `t_user_sub` VALUES (14, 12, 6, '2020-10-01 23:58:39', '2020-10-02 00:02:34', 2);
INSERT INTO `t_user_sub` VALUES (15, 12, 3, '2020-10-01 23:59:30', '2020-10-18 00:02:32', 2);
INSERT INTO `t_user_sub` VALUES (16, 13, 4, '2020-10-02 00:00:41', '2020-10-25 00:02:32', 2);
INSERT INTO `t_user_sub` VALUES (17, 13, 3, '2020-10-02 00:00:43', '2020-10-28 00:02:32', 2);
INSERT INTO `t_user_sub` VALUES (18, 12, 6, '2020-10-04 21:44:56', '2020-10-05 00:02:32', 1);
INSERT INTO `t_user_sub` VALUES (19, 12, 3, '2020-10-04 21:44:57', '2020-10-09 00:02:32', 1);

SET FOREIGN_KEY_CHECKS = 1;
