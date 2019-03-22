/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : smms_upload

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 22/03/2019 13:33:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for smms_image
-- ----------------------------
DROP TABLE IF EXISTS `smms_image`;
CREATE TABLE `smms_image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传文件时所用的文件名',
  `storename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传后的文件名',
  `size` int(11) NULL DEFAULT NULL COMMENT '文件大小',
  `width` int(11) NULL DEFAULT NULL COMMENT '图片的宽度',
  `height` int(11) NULL DEFAULT NULL COMMENT '图片的高度',
  `hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '随机字符串，用于删除文件',
  `delete_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除上传的图片文件专有链接',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片服务器地址',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片的相对地址',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误信息，上传失败时出现',
  `status` int(2) NULL DEFAULT NULL COMMENT '图片状态 0上传成功 1上传失败 2已删除',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `user_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户ip',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_image
-- ----------------------------
INSERT INTO `smms_image` VALUES (1, '4c500055296761735769c72804fa7489.jpg', '5c8f51a0c1adb.jpg', 880547, 1920, 1080, 'F1NZesUQlwSYdpm', 'https://sm.ms/delete/F1NZesUQlwSYdpm', 'https://i.loli.net/2019/03/18/5c8f51a0c1adb.jpg', '/2019/03/18/5c8f51a0c1adb.jpg', NULL, 2, NULL, '116.228.21.165', '1970-01-19 07:21:36', NULL);
INSERT INTO `smms_image` VALUES (2, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f51a2011c6.jpg', 1819854, 1920, 1080, 'SU9mqJraKhxgY51', 'https://sm.ms/delete/SU9mqJraKhxgY51', 'https://i.loli.net/2019/03/18/5c8f51a2011c6.jpg', '/2019/03/18/5c8f51a2011c6.jpg', NULL, 2, NULL, '116.228.21.165', '1970-01-19 07:21:36', NULL);
INSERT INTO `smms_image` VALUES (3, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f51a2af6f1.jpg', 1802666, 1920, 1080, '4DAwR6N53yjoTcL', 'https://sm.ms/delete/4DAwR6N53yjoTcL', 'https://i.loli.net/2019/03/18/5c8f51a2af6f1.jpg', '/2019/03/18/5c8f51a2af6f1.jpg', NULL, 2, NULL, '116.228.21.165', '1970-01-19 07:21:36', NULL);
INSERT INTO `smms_image` VALUES (4, '4c500055296761735769c72804fa7489.jpg', '5c8f5271c59e9.jpg', 880547, 1920, 1080, '1C5dqNLSZzJMHr8', 'https://sm.ms/delete/1C5dqNLSZzJMHr8', 'https://i.loli.net/2019/03/18/5c8f5271c59e9.jpg', '/2019/03/18/5c8f5271c59e9.jpg', NULL, 2, NULL, '116.228.21.165', '2019-03-18 16:10:27', NULL);
INSERT INTO `smms_image` VALUES (5, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f527318183.jpg', 1819854, 1920, 1080, 'K7ASCmMh1egicR6', 'https://sm.ms/delete/K7ASCmMh1egicR6', 'https://i.loli.net/2019/03/18/5c8f527318183.jpg', '/2019/03/18/5c8f527318183.jpg', NULL, 2, NULL, '116.228.21.165', '2019-03-18 16:10:28', NULL);
INSERT INTO `smms_image` VALUES (6, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f5273d1ee2.jpg', 1802666, 1920, 1080, 'j1yKd5nEsT7DVF9', 'https://sm.ms/delete/j1yKd5nEsT7DVF9', 'https://i.loli.net/2019/03/18/5c8f5273d1ee2.jpg', '/2019/03/18/5c8f5273d1ee2.jpg', NULL, 2, NULL, '116.228.21.165', '2019-03-18 16:10:29', NULL);
INSERT INTO `smms_image` VALUES (7, '4c500055296761735769c72804fa7489.jpg', '5c8f57363a263.jpg', 880547, 1920, 1080, 'QMmZ5f8Wo4kVx71', 'https://sm.ms/delete/QMmZ5f8Wo4kVx71', 'https://i.loli.net/2019/03/18/5c8f57363a263.jpg', '/2019/03/18/5c8f57363a263.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:30:46', '2019-03-18 16:35:23');
INSERT INTO `smms_image` VALUES (8, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f57376cc36.jpg', 1819854, 1920, 1080, 'Br25HX9CnoSWwOy', 'https://sm.ms/delete/Br25HX9CnoSWwOy', 'https://i.loli.net/2019/03/18/5c8f57376cc36.jpg', '/2019/03/18/5c8f57376cc36.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:30:47', '2019-03-18 16:35:23');
INSERT INTO `smms_image` VALUES (9, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f583e0f813.jpg', 1819854, 1920, 1080, 'FrI85bajSUC4QEf', 'https://sm.ms/delete/FrI85bajSUC4QEf', 'https://i.loli.net/2019/03/18/5c8f583e0f813.jpg', '/2019/03/18/5c8f583e0f813.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:35:10', '2019-03-18 16:35:23');
INSERT INTO `smms_image` VALUES (10, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f583f4bdbd.jpg', 1802666, 1920, 1080, 'uzHcULZtp38bTR2', 'https://sm.ms/delete/uzHcULZtp38bTR2', 'https://i.loli.net/2019/03/18/5c8f583f4bdbd.jpg', '/2019/03/18/5c8f583f4bdbd.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:35:11', '2019-03-18 16:35:23');
INSERT INTO `smms_image` VALUES (11, '4c500055296761735769c72804fa7489.jpg', '5c8f58bfce9f8.jpg', 880547, 1920, 1080, 'pSI2Ehlv48ifuaG', 'https://sm.ms/delete/pSI2Ehlv48ifuaG', 'https://i.loli.net/2019/03/18/5c8f58bfce9f8.jpg', '/2019/03/18/5c8f58bfce9f8.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:37:19', '2019-03-18 16:37:42');
INSERT INTO `smms_image` VALUES (12, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f58c109366.jpg', 1819854, 1920, 1080, 'fEIhOFbWTxjpCQ1', 'https://sm.ms/delete/fEIhOFbWTxjpCQ1', 'https://i.loli.net/2019/03/18/5c8f58c109366.jpg', '/2019/03/18/5c8f58c109366.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:37:21', '2019-03-18 16:37:42');
INSERT INTO `smms_image` VALUES (13, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f58c1bc600.jpg', 1802666, 1920, 1080, '7YKD9OLFzX16Ckt', 'https://sm.ms/delete/7YKD9OLFzX16Ckt', 'https://i.loli.net/2019/03/18/5c8f58c1bc600.jpg', '/2019/03/18/5c8f58c1bc600.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:37:21', '2019-03-18 16:37:42');
INSERT INTO `smms_image` VALUES (14, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f58fc8ba54.jpg', 1802666, 1920, 1080, 's8vBEqdlfcCbnJH', 'https://sm.ms/delete/s8vBEqdlfcCbnJH', 'https://i.loli.net/2019/03/18/5c8f58fc8ba54.jpg', '/2019/03/18/5c8f58fc8ba54.jpg', NULL, 2, 2013302791, '116.228.21.165', '2019-03-18 16:38:20', '2019-03-18 16:39:16');
INSERT INTO `smms_image` VALUES (15, 'ea088c90jw1f6dhutqtktj21hc0u0dyb.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'File is too large.', 1, 2013302791, NULL, '2019-03-18 16:38:24', NULL);
INSERT INTO `smms_image` VALUES (16, '4c500055296761735769c72804fa7489.jpg', '5c8f653f81ec7.jpg', 880547, 1920, 1080, 'DQhxWaKiIpkGF3w', 'https://sm.ms/delete/DQhxWaKiIpkGF3w', 'https://i.loli.net/2019/03/18/5c8f653f81ec7.jpg', '/2019/03/18/5c8f653f81ec7.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:30:39', '2019-03-18 17:31:17');
INSERT INTO `smms_image` VALUES (17, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f65406db0a.jpg', 1819854, 1920, 1080, 'cztdAsmB5iUn6oG', 'https://sm.ms/delete/cztdAsmB5iUn6oG', 'https://i.loli.net/2019/03/18/5c8f65406db0a.jpg', '/2019/03/18/5c8f65406db0a.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:30:40', '2019-03-18 17:31:17');
INSERT INTO `smms_image` VALUES (18, 'dfa2ba4e5d9fc0991dab62879ea6d4b5.jpg', '5c8f65413463b.jpg', 1802666, 1920, 1080, 'adjnOHPCpMeb7kA', 'https://sm.ms/delete/adjnOHPCpMeb7kA', 'https://i.loli.net/2019/03/18/5c8f65413463b.jpg', '/2019/03/18/5c8f65413463b.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:30:41', '2019-03-18 17:31:17');
INSERT INTO `smms_image` VALUES (19, 'ea088c90jw1f6dhutqtktj21hc0u0dyb.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'File is too large.', 1, 1, NULL, '2019-03-18 17:30:44', NULL);
INSERT INTO `smms_image` VALUES (20, '4c500055296761735769c72804fa7489.jpg', '5c8f65813bc17.jpg', 880547, 1920, 1080, 'rmNpctMz3U5ITWK', 'https://sm.ms/delete/rmNpctMz3U5ITWK', 'https://i.loli.net/2019/03/18/5c8f65813bc17.jpg', '/2019/03/18/5c8f65813bc17.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:31:45', '2019-03-18 17:33:38');
INSERT INTO `smms_image` VALUES (21, '9fe68e1569e1c8a5f98ec582f291b2d5cbd828790985c161ef8d2c5293af82f5.jpg', '5c8f6581f0da6.jpg', 1819854, 1920, 1080, 'HmEOxzpj51gVIXZ', 'https://sm.ms/delete/HmEOxzpj51gVIXZ', 'https://i.loli.net/2019/03/18/5c8f6581f0da6.jpg', '/2019/03/18/5c8f6581f0da6.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:31:45', '2019-03-18 17:33:38');
INSERT INTO `smms_image` VALUES (22, '$62%2_RX)YT`D_~K8TBO37T.jpg', '5c8f668347ded.jpg', 4770, 198, 198, 'SWVY2oIgyNEpQaM', 'https://sm.ms/delete/SWVY2oIgyNEpQaM', 'https://i.loli.net/2019/03/18/5c8f668347ded.jpg', '/2019/03/18/5c8f668347ded.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:36:03', '2019-03-18 17:37:09');
INSERT INTO `smms_image` VALUES (23, '%(G$B~5OWX%1_9HYGV2]ZUM.jpg', '5c8f6683cd408.jpg', 20613, 400, 400, '2HOB63nqAYkSKVy', 'https://sm.ms/delete/2HOB63nqAYkSKVy', 'https://i.loli.net/2019/03/18/5c8f6683cd408.jpg', '/2019/03/18/5c8f6683cd408.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:36:03', '2019-03-18 17:37:09');
INSERT INTO `smms_image` VALUES (24, '%HNPF(~C240W)5(8Y`D(Y%G.jpg', '5c8f66841899a.jpg', 22493, 192, 198, '59oSTzqpd12yIJm', 'https://sm.ms/delete/59oSTzqpd12yIJm', 'https://i.loli.net/2019/03/18/5c8f66841899a.jpg', '/2019/03/18/5c8f66841899a.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:36:04', '2019-03-18 17:37:09');
INSERT INTO `smms_image` VALUES (25, '%UE_US_[6UG0U45%WDG)@W6.jpg', '5c8f66844bcff.jpg', 10968, 200, 200, '7F1x2dRbt6hEjzv', 'https://sm.ms/delete/7F1x2dRbt6hEjzv', 'https://i.loli.net/2019/03/18/5c8f66844bcff.jpg', '/2019/03/18/5c8f66844bcff.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:36:04', '2019-03-18 17:37:09');
INSERT INTO `smms_image` VALUES (26, '005H5cUily1g0z7slgh1sj30aw0awn1e.jpg', '5c8f6af6b686f.jpg', 20356, 392, 392, 'YDkuetPCR95Zcs8', 'https://sm.ms/delete/YDkuetPCR95Zcs8', 'https://i.loli.net/2019/03/18/5c8f6af6b686f.jpg', '/2019/03/18/5c8f6af6b686f.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:55:02', '2019-03-18 17:56:04');
INSERT INTO `smms_image` VALUES (27, '[8IZ1SYEYR{@7YTK$AGF5QV.jpg', '5c8f6b1ca459b.jpg', 41057, 640, 640, 'kxvCYU4gATV6O5s', 'https://sm.ms/delete/kxvCYU4gATV6O5s', 'https://i.loli.net/2019/03/18/5c8f6b1ca459b.jpg', '/2019/03/18/5c8f6b1ca459b.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:55:40', '2019-03-18 17:56:04');
INSERT INTO `smms_image` VALUES (28, ')UB$F]@YRKEEQVUEV]734YY.jpg', '5c8f6bf6ace0c.jpg', 13713, 240, 240, 'f4s97zqRIt2L6PC', 'https://sm.ms/delete/f4s97zqRIt2L6PC', 'https://i.loli.net/2019/03/18/5c8f6bf6ace0c.jpg', '/2019/03/18/5c8f6bf6ace0c.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 17:59:18', '2019-03-18 17:59:27');
INSERT INTO `smms_image` VALUES (29, '%UE_US_[6UG0U45%WDG)@W6.jpg', '5c8f6cd624334.jpg', 10968, 200, 200, 'VLlwyrb5sEJ2Ipk', 'https://sm.ms/delete/VLlwyrb5sEJ2Ipk', 'https://i.loli.net/2019/03/18/5c8f6cd624334.jpg', '/2019/03/18/5c8f6cd624334.jpg', NULL, 2, 1, '116.228.21.165', '2019-03-18 18:03:02', '2019-03-18 18:03:16');
INSERT INTO `smms_image` VALUES (30, '%(G$B~5OWX%1_9HYGV2]ZUM.jpg', '5c94706736a3c.jpg', 20613, 400, 400, 'ISgiQCt1LdXoqy6', 'https://sm.ms/delete/ISgiQCt1LdXoqy6', 'https://i.loli.net/2019/03/22/5c94706736a3c.jpg', '/2019/03/22/5c94706736a3c.jpg', NULL, 0, NULL, '116.228.21.165', '2019-03-22 13:19:35', NULL);

-- ----------------------------
-- Table structure for smms_ip
-- ----------------------------
DROP TABLE IF EXISTS `smms_ip`;
CREATE TABLE `smms_ip`  (
  `user_id` int(11) NOT NULL,
  `user_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_ip
-- ----------------------------
INSERT INTO `smms_ip` VALUES (1, '116.228.21.165');

-- ----------------------------
-- Table structure for smms_permission
-- ----------------------------
DROP TABLE IF EXISTS `smms_permission`;
CREATE TABLE `smms_permission`  (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名 唯一标识',
  `permission_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `permission_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission_parent_id` int(11) NULL DEFAULT NULL COMMENT '父权限id',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_permission
-- ----------------------------
INSERT INTO `smms_permission` VALUES (1, 'img:delete', '删除图片', '/img/clear', NULL);
INSERT INTO `smms_permission` VALUES (2, 'img:select', '查询图片', '/img/history', NULL);

-- ----------------------------
-- Table structure for smms_role
-- ----------------------------
DROP TABLE IF EXISTS `smms_role`;
CREATE TABLE `smms_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_role
-- ----------------------------
INSERT INTO `smms_role` VALUES (1, 'admin', '管理员');
INSERT INTO `smms_role` VALUES (2, 'normal', '普通用户');

-- ----------------------------
-- Table structure for smms_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `smms_role_permission`;
CREATE TABLE `smms_role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_role_permission
-- ----------------------------
INSERT INTO `smms_role_permission` VALUES (1, 1);
INSERT INTO `smms_role_permission` VALUES (2, 2);

-- ----------------------------
-- Table structure for smms_user
-- ----------------------------
DROP TABLE IF EXISTS `smms_user`;
CREATE TABLE `smms_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_user
-- ----------------------------
INSERT INTO `smms_user` VALUES (1, 'HEARTdd', '0138e32b7a80038f8fc24460cf525ac1', 'heart');
INSERT INTO `smms_user` VALUES (2, 'Heart', '956f56299a3fbcfd5ebfdf383b33a031', 'Heart1234566');
INSERT INTO `smms_user` VALUES (3, 'heart33', '98a5f1c04e9ee07326de449af55921aa', 'heart331234566');

-- ----------------------------
-- Table structure for smms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `smms_user_role`;
CREATE TABLE `smms_user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smms_user_role
-- ----------------------------
INSERT INTO `smms_user_role` VALUES (1, 1);
INSERT INTO `smms_user_role` VALUES (3, 2);

SET FOREIGN_KEY_CHECKS = 1;
