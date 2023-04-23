/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : db_admin

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 23/04/2023 17:37:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录IP',
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录地点',
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'User Agent',
  `status` tinyint NULL DEFAULT NULL COMMENT '登录状态  0：失败   1：成功',
  `operation` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '操作信息   0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------
INSERT INTO `sys_log_login` VALUES (1, 'admin', '127.0.0.1', '内网IP', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36', 1, 0, '2023-04-23 15:48:33');
INSERT INTO `sys_log_login` VALUES (2, 'admin', '127.0.0.1', '内网IP', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36', 0, 2, '2023-04-23 16:03:02');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` bigint NULL DEFAULT NULL COMMENT '上级ID，一级菜单为0',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `authority` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权标识(多个用逗号分隔，如：sys:menu:list,sys:menu:save)',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型   0：菜单   1：按钮   2：接口',
  `open_style` tinyint NULL DEFAULT NULL COMMENT '打开方式   0：内部   1：外部',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '权限管理', '', '', 0, 0, 'Lock', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (2, 1, '菜单管理', '/sys/menu/index', NULL, 0, 0, 'Memo', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (3, 2, '查看', '', 'sys:menu:list', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (4, 2, '新增', '', 'sys:menu:save', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (5, 2, '修改', '', 'sys:menu:update,sys:menu:info', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (6, 2, '删除', '', 'sys:menu:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (8, 1, '角色管理', '/sys/role/index', '', 0, 0, 'Edit', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (9, 8, '查询', '', 'sys:role:page', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (10, 8, '新增', '', 'sys:role:save,sys:role:menu', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (11, 8, '修改', '', 'sys:role:update,sys:role:info,sys:role:menu,sys:user:page', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (12, 8, '删除', '', 'sys:role:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (13, 0, '用户管理', '/sys/user/index', '', 0, 0, 'User', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (14, 13, '查询', '', 'sys:user:page', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (15, 13, '新增', '', 'sys:user:save,sys:role:list', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (16, 13, '修改', '', 'sys:user:update,sys:user:info,sys:role:list', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (17, 13, '删除', '', 'sys:user:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (18, 13, '导入', '', 'sys:user:import', 1, 0, '', 4, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (19, 13, '导出', '', 'sys:user:export', 1, 0, '', 5, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (20, 0, '接口文档', '/docs/index', NULL, 0, 0, 'Document', 6, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (21, 0, '商品管理', '/goods/index', NULL, 0, 0, 'Goods', 3, 0, 10000, '2023-04-18 20:12:43', 10000, '2023-04-18 20:12:49');
INSERT INTO `sys_menu` VALUES (22, 0, '订单管理', '/order/index', NULL, 0, 0, 'ShoppingCart', 4, 0, 10000, '2023-04-18 20:13:26', 10000, '2023-04-18 20:13:31');
INSERT INTO `sys_menu` VALUES (24, 0, '仪表盘', '/', NULL, 0, 0, 'DataBoard', 0, 0, 10000, '2023-04-20 16:33:10', 10000, '2023-04-20 16:33:15');
INSERT INTO `sys_menu` VALUES (25, 0, '通知管理', '/notice/index', NULL, 0, 0, 'Bell', 5, 0, 10000, '2023-04-20 16:27:32', 10000, '2023-04-20 16:27:36');
INSERT INTO `sys_menu` VALUES (26, 25, '查看', NULL, 'sys:notice:page', 1, 0, NULL, 0, 0, 10000, '2023-04-20 22:45:28', 10000, '2023-04-20 22:45:30');
INSERT INTO `sys_menu` VALUES (27, 25, '新增', NULL, 'sys:notice:save', 1, 0, NULL, 1, 0, 10000, '2023-04-20 22:42:38', 10000, '2023-04-20 22:42:45');
INSERT INTO `sys_menu` VALUES (28, 25, '修改', NULL, 'sys:notice:update,sys:notice:info', 1, 0, NULL, 2, 0, 10000, '2023-04-20 22:43:31', 10000, '2023-04-20 22:43:36');
INSERT INTO `sys_menu` VALUES (29, 25, '删除', NULL, 'sys:notice:delete', 1, 0, NULL, 3, 0, 10000, '2023-04-20 22:44:24', 10000, '2023-04-20 22:44:26');
INSERT INTO `sys_menu` VALUES (30, 25, '导入', NULL, 'sys:notice:import', 1, 0, NULL, 4, 0, 10000, '2023-04-21 00:22:42', 10000, '2023-04-21 00:22:51');
INSERT INTO `sys_menu` VALUES (31, 26, '导出', NULL, 'sys:notice:export', 1, 0, NULL, 5, 0, 10000, '2023-04-21 00:23:22', 10000, '2023-04-21 00:23:32');
INSERT INTO `sys_menu` VALUES (32, 0, '登录日志', '/sys/log/index', 'sys:log:page', 0, 0, 'Bell', 6, 0, 10000, '2023-04-23 14:47:20', 10000, '2023-04-23 14:47:22');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '超级管理员', 0, NULL, '2023-04-09 18:02:31', NULL, '2023-04-09 18:02:31');
INSERT INTO `sys_role` VALUES (2, '销售管理员', '销售管理员', 0, 10000, '2023-04-18 19:30:54', 10000, '2023-04-18 19:30:59');
INSERT INTO `sys_role` VALUES (3, '仓储管理员', '仓储管理员', 0, 10000, '2023-04-18 19:39:30', 10000, '2023-04-18 19:39:35');
INSERT INTO `sys_role` VALUES (4, '普通员工', '普通员工', 0, 10000, '2023-04-18 20:15:31', 10000, '2023-04-18 20:15:35');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint NULL DEFAULT NULL COMMENT '菜单ID',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_menu_id`(`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (2, 1, 2, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (3, 1, 3, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (4, 1, 4, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (5, 1, 5, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (6, 1, 6, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (7, 1, 7, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (8, 1, 8, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (9, 1, 9, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (10, 1, 10, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (11, 1, 11, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (12, 1, 12, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (13, 1, 13, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (14, 1, 14, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (15, 1, 15, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (16, 1, 16, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (17, 1, 17, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (18, 1, 18, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (19, 1, 19, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (20, 1, 20, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (21, 1, 21, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (22, 1, 22, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (23, 2, 21, 0, 10000, '2023-04-18 20:17:57', 10000, '2023-04-18 20:18:01');
INSERT INTO `sys_role_menu` VALUES (24, 3, 22, 0, 10000, '2023-04-18 20:18:22', 10000, '2023-04-18 20:18:24');
INSERT INTO `sys_role_menu` VALUES (25, 1, 23, 0, 10000, '2023-04-20 16:44:49', 10000, '2023-04-20 16:44:54');
INSERT INTO `sys_role_menu` VALUES (26, 1, 24, 0, 10000, '2023-04-20 16:45:05', 10000, '2023-04-20 16:45:10');
INSERT INTO `sys_role_menu` VALUES (27, 2, 24, 0, 10000, '2023-04-20 16:45:40', 10000, '2023-04-20 16:45:45');
INSERT INTO `sys_role_menu` VALUES (28, 3, 24, 0, 10000, '2023-04-20 16:45:56', 10000, '2023-04-20 16:46:02');
INSERT INTO `sys_role_menu` VALUES (29, 1, 25, 0, 10000, '2023-04-20 22:46:44', 10000, '2023-04-20 22:46:47');
INSERT INTO `sys_role_menu` VALUES (30, 1, 26, 0, 10000, '2023-04-20 22:46:59', 10000, '2023-04-20 22:47:01');
INSERT INTO `sys_role_menu` VALUES (31, 1, 27, 0, 10000, '2023-04-20 22:47:12', 10000, '2023-04-20 22:47:15');
INSERT INTO `sys_role_menu` VALUES (32, 1, 28, 0, 10000, '2023-04-20 22:47:24', 10000, '2023-04-20 22:47:27');
INSERT INTO `sys_role_menu` VALUES (33, 1, 29, 0, 10000, '2023-04-20 22:47:37', 10000, '2023-04-20 22:47:41');
INSERT INTO `sys_role_menu` VALUES (34, 2, 25, 0, 10000, '2023-04-20 22:50:50', 10000, '2023-04-20 22:50:55');
INSERT INTO `sys_role_menu` VALUES (35, 2, 26, 0, 10000, '2023-04-20 22:51:08', 10000, '2023-04-20 22:51:14');
INSERT INTO `sys_role_menu` VALUES (36, 3, 25, 0, 10000, '2023-04-20 22:52:22', 10000, '2023-04-20 22:52:26');
INSERT INTO `sys_role_menu` VALUES (37, 3, 26, 0, 10000, '2023-04-20 22:52:41', 10000, '2023-04-20 22:52:45');
INSERT INTO `sys_role_menu` VALUES (38, 1, 30, 0, 10000, '2023-04-21 00:24:07', 10000, '2023-04-21 00:24:11');
INSERT INTO `sys_role_menu` VALUES (39, 1, 31, 0, 10000, '2023-04-21 00:24:24', 10000, '2023-04-21 00:24:31');
INSERT INTO `sys_role_menu` VALUES (40, 1, 32, 0, 10000, '2023-04-23 14:47:55', 10000, '2023-04-23 14:47:58');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` tinyint NULL DEFAULT NULL COMMENT '性别   0：男   1：女   2：未知',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `super_admin` tinyint NULL DEFAULT NULL COMMENT '超级管理员   0：否   1：是',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (10000, 'admin', '{bcrypt}$2a$10$XaYSLfG0Oi6CAw7npTmsi.8lidqZpHRC0bbPWhZGNd5iA/7TCnPUu', 'flobby', 'https://flobby529.oss-cn-nanjing.aliyuncs.com/avatar/7a2b94fe-90ac-4186-960a-e1a6fa063ee0.jpg', 1, '16422802@qq.com', '13951905171', 1, 1, 0, NULL, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_user` VALUES (10001, 'admin1', '{bcrypt}$2a$10$XaYSLfG0Oi6CAw7npTmsi.8lidqZpHRC0bbPWhZGNd5iA/7TCnPUu', 'admin1', 'https://i2.100024.xyz/2023/01/26/3exzjl.webp', 2, 'admin1@qq.com', '13911112222', 0, 1, 0, 10000, '2023-04-09 18:03:51', 10000, '2023-04-09 18:03:51');
INSERT INTO `sys_user` VALUES (10002, 'admin2', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'admin2', 'https://i2.100024.xyz/2023/01/26/3ey3yb.webp', 0, 'admin2@qq.com', '13900001111', 0, 1, 0, 10000, '2023-04-18 19:27:17', 10000, '2023-04-18 19:27:22');
INSERT INTO `sys_user` VALUES (10003, 'bbb', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'bbb', 'https://i2.100024.xyz/2023/01/26/3eyd0m.webp', 1, 'bbb@qq.com', '13911112222', 0, 1, 0, 10000, '2023-04-18 19:28:14', 10000, '2023-04-18 19:28:20');
INSERT INTO `sys_user` VALUES (10004, 'ccc', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'ccc', 'https://i2.100024.xyz/2023/01/26/3eyjfo.webp', 0, 'ccc@qq.com', '13933334444', 0, 1, 0, 10000, '2023-04-18 19:35:04', 10000, '2023-04-18 19:35:10');
INSERT INTO `sys_user` VALUES (10005, 'ddd', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'ddd', 'https://i2.100024.xyz/2023/01/26/3eyiq7.webp', 1, 'ddd@qq.com', '13955556666', 0, 1, 0, 10000, '2023-04-18 19:35:56', 10000, '2023-04-18 19:36:02');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 10000, 0, 10000, '2023-04-09 18:03:51', 10000, '2023-04-09 18:03:51');
INSERT INTO `sys_user_role` VALUES (2, 2, 10001, 0, 10000, '2023-04-18 19:40:33', 10000, '2023-04-18 19:40:38');
INSERT INTO `sys_user_role` VALUES (3, 3, 10002, 0, 10000, '2023-04-18 19:40:59', 10000, '2023-04-18 19:41:04');
INSERT INTO `sys_user_role` VALUES (4, 4, 10003, 0, 10000, '2023-04-18 19:42:13', 10000, '2023-04-18 19:42:18');
INSERT INTO `sys_user_role` VALUES (5, 4, 10004, 0, 10000, '2023-04-18 19:42:49', 10000, '2023-04-18 19:42:53');
INSERT INTO `sys_user_role` VALUES (6, 4, 10005, 0, 10000, '2023-04-18 19:43:13', 10000, '2023-04-18 19:43:19');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告内容',
  `creator` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int NULL DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '学习 Vue3 Composition API', '学习 Vue3 Composition API', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 12:44:07', 0);
INSERT INTO `t_notice` VALUES (2, '学习 HTML', '学习 HTML', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (3, '学习 CSS', '学习 CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (4, '学习 JavaScript', '学习 JavaScript', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (5, '学习 Vue3 + Vite 工程化开发', '学习 Vue3 + Vite 工程化开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (6, '学习 Pinia', '学习 Pinia', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (7, '学习 Vue3 代码规范', '学习 Vue3 代码规范', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (8, '学习 Element Plus', '学习 Element Plus', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (9, '学习 Tailwind CSS', '学习 Tailwind CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (10, '学习 Nginx', '学习 Nginx', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (11, '学习 SASS', '学习 SASS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (12, '学习前后端分离项目开发', '学习前后端分离项目开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (13, '项目初始化', '项目初始化', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (14, '引入 Element Plus 和基本使用', '引入 Element Plus 和基本使用', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (15, '引入windicss工具库和配置', '引入windicss工具库和配置', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (16, '使用@apply简化代码', '使用@apply简化代码', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (17, '引入路由,配置路由和404页面捕获', '引入路由,配置路由和404页面捕获', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (18, '登录页响应式处理', '登录页响应式处理', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (19, 'setup语法糖和组合式api', 'setup语法糖和组合式api', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (20, '引入axios请求库和登录接口交互', '引入axios请求库和登录接口交互', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (21, '引入cookie存储用户token', '引入cookie存储用户token', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (22, '请求拦截器和响应拦截器', '请求拦截器和响应拦截器', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (23, '常用工具库封装', '常用工具库封装', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (24, '引入pinia状态管理用户信息', '引入pinia状态管理用户信息', 10000, '2023-04-20 18:20:08', 10000, '2023-04-20 18:20:09', 0);
INSERT INTO `t_notice` VALUES (25, '全局loading进度条实现', '全局loading进度条实现', 10000, '2023-04-20 19:54:43', 10000, '2023-04-20 19:54:51', 0);
INSERT INTO `t_notice` VALUES (33, '学习 Vue3 组合式 API', '学习 Vue3 组合式 API', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (34, '学习 HTML', '学习 HTML', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (35, '学习 CSS', '学习 CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (36, '学习 JavaScript', '学习 JavaScript', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (37, '学习 Vue3 + Vite 工程化开发', '学习 Vue3 + Vite 工程化开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (38, '学习 Pinia', '学习 Pinia', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (39, '学习 Vue3 代码规范', '学习 Vue3 代码规范', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (40, '学习 Element Plus', '学习 Element Plus', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (41, '学习 Tailwind CSS', '学习 Tailwind CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (42, '学习 Nginx', '学习 Nginx', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (43, '学习 SASS', '学习 SASS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (44, '学习前后端分离项目开发', '学习前后端分离项目开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (45, '项目初始化', '项目初始化', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (46, '引入 Element Plus 和基本使用', '引入 Element Plus 和基本使用', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (47, '引入windicss工具库和配置', '引入windicss工具库和配置', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (48, '使用@apply简化代码', '使用@apply简化代码', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (49, '引入路由,配置路由和404页面捕获', '引入路由,配置路由和404页面捕获', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (50, '登录页响应式处理', '登录页响应式处理', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (51, 'setup语法糖和组合式api', 'setup语法糖和组合式api', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (52, '引入axios请求库和登录接口交互', '引入axios请求库和登录接口交互', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (53, '引入cookie存储用户token', '引入cookie存储用户token', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (54, '请求拦截器和响应拦截器', '请求拦截器和响应拦截器', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (55, '常用工具库封装', '常用工具库封装', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (56, '引入pinia状态管理用户信息', '引入pinia状态管理用户信息', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (57, '全局loading进度条实现', '全局loading进度条实现', 10000, '2023-04-20 19:54:43', 10000, '2023-04-21 00:57:49', 0);
INSERT INTO `t_notice` VALUES (58, 'test', 'test', 10000, '2023-04-21 09:02:25', 10000, '2023-04-21 09:02:32', 1);
INSERT INTO `t_notice` VALUES (59, '学习 Vue3 Composition API', '学习 Vue3 Composition API', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (60, '学习 HTML', '学习 HTML', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (61, '学习 CSS', '学习 CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (62, '学习 JavaScript', '学习 JavaScript', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (63, '学习 Vue3 + Vite 工程化开发', '学习 Vue3 + Vite 工程化开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (64, '学习 Pinia', '学习 Pinia', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (65, '学习 Vue3 代码规范', '学习 Vue3 代码规范', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (66, '学习 Element Plus', '学习 Element Plus', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (67, '学习 Tailwind CSS', '学习 Tailwind CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (68, '学习 Nginx', '学习 Nginx', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (69, '学习 SASS', '学习 SASS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (70, '学习前后端分离项目开发', '学习前后端分离项目开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (71, '项目初始化', '项目初始化', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (72, '引入 Element Plus 和基本使用', '引入 Element Plus 和基本使用', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (73, '引入windicss工具库和配置', '引入windicss工具库和配置', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (74, '使用@apply简化代码', '使用@apply简化代码', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (75, '引入路由,配置路由和404页面捕获', '引入路由,配置路由和404页面捕获', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (76, '登录页响应式处理', '登录页响应式处理', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (77, 'setup语法糖和组合式api', 'setup语法糖和组合式api', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (78, '引入axios请求库和登录接口交互', '引入axios请求库和登录接口交互', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (79, '引入cookie存储用户token', '引入cookie存储用户token', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (80, '请求拦截器和响应拦截器', '请求拦截器和响应拦截器', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (81, '常用工具库封装', '常用工具库封装', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (82, '引入pinia状态管理用户信息', '引入pinia状态管理用户信息', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (83, '全局loading进度条实现', '全局loading进度条实现', 10000, '2023-04-20 19:54:43', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (84, '学习 Vue3 组合式 API', '学习 Vue3 组合式 API', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (85, '学习 HTML', '学习 HTML', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (86, '学习 CSS', '学习 CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (87, '学习 JavaScript', '学习 JavaScript', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (88, '学习 Vue3 + Vite 工程化开发', '学习 Vue3 + Vite 工程化开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (89, '学习 Pinia', '学习 Pinia', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (90, '学习 Vue3 代码规范', '学习 Vue3 代码规范', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (91, '学习 Element Plus', '学习 Element Plus', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (92, '学习 Tailwind CSS', '学习 Tailwind CSS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (93, '学习 Nginx', '学习 Nginx', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (94, '学习 SASS', '学习 SASS', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (95, '学习前后端分离项目开发', '学习前后端分离项目开发', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (96, '项目初始化', '项目初始化', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (97, '引入 Element Plus 和基本使用', '引入 Element Plus 和基本使用', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (98, '引入windicss工具库和配置', '引入windicss工具库和配置', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (99, '使用@apply简化代码', '使用@apply简化代码', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (100, '引入路由,配置路由和404页面捕获', '引入路由,配置路由和404页面捕获', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (101, '登录页响应式处理', '登录页响应式处理', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (102, 'setup语法糖和组合式api', 'setup语法糖和组合式api', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (103, '引入axios请求库和登录接口交互', '引入axios请求库和登录接口交互', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (104, '引入cookie存储用户token', '引入cookie存储用户token', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (105, '请求拦截器和响应拦截器', '请求拦截器和响应拦截器', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (106, '常用工具库封装', '常用工具库封装', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (107, '引入pinia状态管理用户信息', '引入pinia状态管理用户信息', 10000, '2023-04-20 18:20:08', 10000, '2023-04-21 09:04:30', 0);
INSERT INTO `t_notice` VALUES (108, '全局loading进度条实现', '全局loading进度条实现', 10000, '2023-04-20 19:54:43', 10000, '2023-04-21 12:50:17', 1);
INSERT INTO `t_notice` VALUES (109, '???', '???', 10000, '2023-04-21 10:32:02', 10000, '2023-04-21 10:33:39', 1);
INSERT INTO `t_notice` VALUES (110, 'test1', 'test1', 10000, '2023-04-21 10:32:21', 10000, '2023-04-21 10:34:14', 1);
INSERT INTO `t_notice` VALUES (111, 'test2', 'test2', 10000, '2023-04-21 10:32:41', 10000, '2023-04-21 10:34:14', 1);
INSERT INTO `t_notice` VALUES (112, 'test2', 'test2', 10000, '2023-04-21 10:32:42', 10000, '2023-04-21 10:34:14', 1);
INSERT INTO `t_notice` VALUES (113, '111', '111', 10000, '2023-04-21 12:50:40', 10000, '2023-04-21 12:54:38', 1);
INSERT INTO `t_notice` VALUES (114, '新增通知', '修改通知内容', 10000, '2023-04-21 12:54:33', 10000, '2023-04-21 12:54:51', 1);

SET FOREIGN_KEY_CHECKS = 1;
