/*
Navicat MySQL Data Transfer

Source Server         : gw
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : zl

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-10-14 09:46:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('1', '中国银行股份有限公司任丘支行', '中国银行股份有限公司任丘支行');
INSERT INTO `bank` VALUES ('2', '中国建设银行股份有限公司华北石油分行', '中国建设银行股份有限公司华北石油分行');
INSERT INTO `bank` VALUES ('3', '交通银行股份有限公司沧州分行', '交通银行股份有限公司沧州分行');
INSERT INTO `bank` VALUES ('4', '中国农业银行股份有限公司任丘支行', '中国农业银行股份有限公司任丘支行');
INSERT INTO `bank` VALUES ('5', '中国工商银行股份有限公司任丘支行', '中国工商银行股份有限公司任丘支行');
INSERT INTO `bank` VALUES ('6', '中国邮政储蓄银行股份有限公司任丘市支行', '中国邮政储蓄银行股份有限公司任丘市支行');
INSERT INTO `bank` VALUES ('16', '中国银行', '中国银行');
INSERT INTO `bank` VALUES ('17', '中国银行2', '');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `d_id` int(30) DEFAULT NULL COMMENT '档案id',
  `borrow_code` varchar(255) DEFAULT NULL COMMENT '借款人code',
  `borrow_name` varchar(255) DEFAULT NULL COMMENT '借款人姓名',
  `borrow_phone` varchar(255) DEFAULT NULL COMMENT '借款人手机号码',
  `borrow_spouse_code` varchar(255) DEFAULT NULL COMMENT '借款人配偶code',
  `borrow_spouse_name` varchar(255) DEFAULT NULL COMMENT '借款人配偶姓名',
  `borrow_spouse_phone` varchar(255) DEFAULT NULL COMMENT '借款人配偶手机号码',
  `married` int(11) DEFAULT NULL,
  `act` int(20) DEFAULT NULL COMMENT '是否由他人代办  1：是  2：不是',
  `act_name` varchar(255) DEFAULT NULL COMMENT '代办人姓名',
  `act_code` varchar(255) DEFAULT NULL COMMENT '代办人身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('18', '12', '130928456789541254', '张无忌', '13100010001', '130928456789545896', '赵敏', '13100010002', '1', '0', '', '');
INSERT INTO `borrow` VALUES ('23', '12', '111', '111', '111', '', '', '', '0', '0', '', '');
INSERT INTO `borrow` VALUES ('24', '14', '132456789546461254', '马云', '13100010008', '152025487965214786', '李璐', '13100010009', '1', '0', '', '');
INSERT INTO `borrow` VALUES ('25', '15', '123', '123', '123', '', '', '', '0', '0', '', '');
INSERT INTO `borrow` VALUES ('26', '16', '123', '333', '123', '', '', '', '0', '0', '', '');
INSERT INTO `borrow` VALUES ('27', '17', '456', '444', '456', '', '', '', '0', '0', '', '');
INSERT INTO `borrow` VALUES ('28', '18', '456', '555', '456', '', '', '', '0', '0', '', '');

-- ----------------------------
-- Table structure for documents
-- ----------------------------
DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `num` varchar(50) DEFAULT NULL COMMENT '档案编号',
  `dc_id` int(30) DEFAULT NULL COMMENT '档案种类',
  `bank_id` int(30) DEFAULT NULL COMMENT '银行Id',
  `loan_amount` decimal(10,0) DEFAULT NULL COMMENT '借款金额  可以是小数，单位是万元',
  `duration` int(11) DEFAULT NULL COMMENT '贷款年限',
  `house_status` int(11) DEFAULT NULL COMMENT '借款类型  1：现房抵押  2：预抵押',
  `address` varchar(255) DEFAULT NULL COMMENT '抵押物坐落位置',
  `property_certificate` varchar(255) DEFAULT NULL COMMENT '产权证号',
  `house_cost` decimal(10,0) DEFAULT NULL COMMENT '购房总款',
  `area` decimal(10,0) DEFAULT NULL COMMENT '面积（平米）',
  `village_id` int(11) DEFAULT NULL COMMENT '小区id',
  `building` varchar(255) DEFAULT NULL COMMENT '楼号',
  `unit` varchar(255) DEFAULT NULL COMMENT '单元号',
  `house` varchar(255) DEFAULT NULL COMMENT '门牌号',
  `date` datetime DEFAULT NULL COMMENT '担保日期',
  `state` int(30) DEFAULT NULL COMMENT '档案状态  1 正常  2 作废',
  `sc_date` datetime DEFAULT NULL COMMENT '删除日期',
  `zf_date` datetime DEFAULT NULL COMMENT '作废日期',
  `certificates_status` int(20) DEFAULT NULL COMMENT '房产证状态',
  `different` int(20) DEFAULT NULL COMMENT '是否借款人和担保人不同',
  `bank_num` varchar(255) DEFAULT NULL COMMENT '银行合同编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of documents
-- ----------------------------
INSERT INTO `documents` VALUES ('12', 'S201909001', '1', '16', '85', '6', '1', '英才小区13号楼5单元603室', '78451564745', '1200000', '100', '12', '13', '5', '603', '2019-09-04 15:04:02', '1', null, null, '1', '1', '45648797413261');
INSERT INTO `documents` VALUES ('14', 'D201909001', '3', '3', '60', '10', '1', '精彩小区25号楼2单元410室', '4545787896321', '800000', '100', '13', '5', '2', '410', '2019-09-04 16:13:36', '1', null, null, '1', '0', '');
INSERT INTO `documents` VALUES ('15', 'S201909002', '1', '1', '12', '123', '1', '英才小区123号楼123单元123室', '123', '123000', '123', '12', '123', '123', '123', '2019-09-04 16:16:07', '1', null, null, '1', '0', '123');
INSERT INTO `documents` VALUES ('16', 'U201909001', '2', '1', '123', '12', '1', '英才小区12号楼2单元131室', '321', '321231', '123', '12', '12', '2', '131', '2019-09-04 16:16:57', '1', null, null, '1', '0', '123');
INSERT INTO `documents` VALUES ('17', 'D201909002', '1', '1', '456', '45', '1', '英才小区45号楼4单元464室', '456', '456456', '45', '12', '45', '4', '464', '2019-09-04 16:18:45', '1', null, null, '1', '0', '456');
INSERT INTO `documents` VALUES ('18', 'S201909003', '3', '1', '456', '45', '1', '英才小区45号楼4单元464室', '456', '456456', '45', '12', '45', '4', '464', '2019-09-04 16:18:45', '1', null, null, '1', '0', '456');

-- ----------------------------
-- Table structure for documents_classification
-- ----------------------------
DROP TABLE IF EXISTS `documents_classification`;
CREATE TABLE `documents_classification` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `sqb_num` int(30) DEFAULT NULL COMMENT '申请表打印份数',
  `ht_num` int(30) DEFAULT NULL COMMENT '抵押合同打印份数',
  `xy_num` int(30) DEFAULT NULL COMMENT '担保协议打印份数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of documents_classification
-- ----------------------------
INSERT INTO `documents_classification` VALUES ('1', '地方公积金', '1', '3', '0');
INSERT INTO `documents_classification` VALUES ('2', '油田公积金', '1', '5', '0');
INSERT INTO `documents_classification` VALUES ('3', '商业贷款', '1', '0', '2');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `passwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `role_id` int(30) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1');
INSERT INTO `employee` VALUES ('17', 'liyu', '李玉', '25d55ad283aa400af464c76d713c07ad', '22');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `d_id` int(30) DEFAULT NULL COMMENT '档案id',
  `url` varchar(255) DEFAULT NULL COMMENT '路径',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `state` int(30) DEFAULT NULL COMMENT '状态  1 新增  2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('78', '12', 'http://192.168.10.61:8766/uploads/2019-10-14/1571015482626.png', 'flex.png', '2');
INSERT INTO `file` VALUES ('79', '12', 'http://192.168.10.61:8766/uploads/2019-10-14/1571015640607.jpg', 'workplace-banner.jpg', '2');
INSERT INTO `file` VALUES ('80', '12', 'http://192.168.10.22:8766/uploads/2019-10-14/1571015676083.png', 'flex.png', '1');
INSERT INTO `file` VALUES ('81', '12', 'http://192.168.10.22:8766/uploads/2019-10-14/1571017531159.png', 'flex.png', '1');

-- ----------------------------
-- Table structure for mortgage
-- ----------------------------
DROP TABLE IF EXISTS `mortgage`;
CREATE TABLE `mortgage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `d_id` int(30) DEFAULT NULL COMMENT '档案id',
  `mortgage_name` varchar(255) DEFAULT NULL COMMENT '抵押人姓名',
  `mortgage_phone` varchar(255) DEFAULT NULL COMMENT '抵押人手机号码',
  `mortgage_spouse_name` varchar(255) DEFAULT NULL COMMENT '抵押人配偶姓名',
  `mortgage_spouse_phone` varchar(255) DEFAULT NULL COMMENT '抵押人配偶手机号码',
  `married` int(11) DEFAULT NULL,
  `act` int(20) DEFAULT NULL COMMENT '是否由他人代办  1：是  2：不是',
  `act_name` varchar(255) DEFAULT NULL COMMENT '代办人姓名',
  `act_code` varchar(255) DEFAULT NULL COMMENT '代办人身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mortgage
-- ----------------------------
INSERT INTO `mortgage` VALUES ('24', '12', '张无忌', '13100010001', '', '', '0', '0', '', '');
INSERT INTO `mortgage` VALUES ('25', '12', '赵敏', '13100010002', '', '', '0', null, null, null);
INSERT INTO `mortgage` VALUES ('27', '14', '马云', '13100010008', '李璐', '13100010009', '1', '0', '', '');
INSERT INTO `mortgage` VALUES ('28', '15', '123', '123', '', '', '0', '0', '', '');
INSERT INTO `mortgage` VALUES ('29', '16', '123', '123', '', '', '0', '0', '', '');
INSERT INTO `mortgage` VALUES ('30', '17', '444', '456', '', '', '0', '0', '', '');
INSERT INTO `mortgage` VALUES ('31', '18', '444', '456', '', '', '0', '0', '', '');

-- ----------------------------
-- Table structure for operate
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `u_id` int(30) DEFAULT NULL COMMENT '操作人id',
  `d_id` int(30) DEFAULT NULL COMMENT '操作的档案的id',
  `date` datetime DEFAULT NULL COMMENT '操作日期',
  `type` int(255) DEFAULT NULL COMMENT '操作的类型  1：新增档案\n2：修改档案内容\n3：增加附件\n4：删除附件\n5：删除档案   6.注销/还原  7.期转现',
  `change` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '修改的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate
-- ----------------------------
INSERT INTO `operate` VALUES ('187', '17', '12', '2019-09-04 15:12:55', '1', '新增档案');
INSERT INTO `operate` VALUES ('200', '17', '12', '2019-09-04 16:04:08', '2', '借款金额(万元) 从 80 改为 85；借款期限 从 5 改为 6；抵押物坐落位置 从 英才小区13号楼5单元602室 改为 英才小区13号楼5单元603室；门号 从 602 改为 603');
INSERT INTO `operate` VALUES ('201', '17', '12', '2019-09-04 16:04:41', '2', '新增借款人：111');
INSERT INTO `operate` VALUES ('202', '17', '14', '2019-09-04 16:15:28', '1', '新增档案');
INSERT INTO `operate` VALUES ('203', '17', '15', '2019-09-04 16:16:43', '1', '新增档案');
INSERT INTO `operate` VALUES ('204', '17', '16', '2019-09-04 16:17:32', '1', '新增档案');
INSERT INTO `operate` VALUES ('205', '17', '17', '2019-09-04 16:19:14', '1', '新增档案');
INSERT INTO `operate` VALUES ('206', '17', '18', '2019-09-04 16:19:23', '1', '新增档案');
INSERT INTO `operate` VALUES ('207', '13', '12', '2019-10-14 09:11:23', '3', '添加文件：flex.png');
INSERT INTO `operate` VALUES ('208', '13', '12', '2019-10-14 09:14:01', '3', '添加文件：workplace-banner.jpg');
INSERT INTO `operate` VALUES ('209', '13', '12', '2019-10-14 09:14:37', '3', '添加文件：flex.png');
INSERT INTO `operate` VALUES ('210', '13', '12', '2019-10-14 09:15:05', '4', '删除文件：workplace-banner.jpg');
INSERT INTO `operate` VALUES ('211', '13', '12', '2019-10-14 09:15:10', '4', '删除文件：flex.png');
INSERT INTO `operate` VALUES ('212', '1', '12', '2019-10-14 09:27:13', '2', '借款人与抵押人不同 从 否 改为 是');
INSERT INTO `operate` VALUES ('213', '1', '12', '2019-10-14 09:27:51', '2', '借款人与抵押人不同 从 是 改为 否');
INSERT INTO `operate` VALUES ('214', '1', '12', '2019-10-14 09:32:09', '2', '借款人与抵押人不同 从 否 改为 是');
INSERT INTO `operate` VALUES ('215', '1', '12', '2019-10-14 09:32:28', '2', '借款人与抵押人不同 从 是 改为 否');
INSERT INTO `operate` VALUES ('216', '1', '12', '2019-10-14 09:36:53', '2', '借款人与抵押人不同 从 否 改为 是');
INSERT INTO `operate` VALUES ('217', '1', '12', '2019-10-14 09:45:31', '3', '添加文件：flex.png');

-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `perm`;
CREATE TABLE `perm` (
  `id` int(11) NOT NULL COMMENT '权限',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '所属分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perm
-- ----------------------------
INSERT INTO `perm` VALUES ('1', '增加档案', '档案管理');
INSERT INTO `perm` VALUES ('2', '修改档案', '档案管理');
INSERT INTO `perm` VALUES ('3', '删除档案', '档案管理');
INSERT INTO `perm` VALUES ('4', '增加附件', '档案管理');
INSERT INTO `perm` VALUES ('5', '删除附件', '档案管理');
INSERT INTO `perm` VALUES ('6', '注销档案', '档案管理');
INSERT INTO `perm` VALUES ('7', '打印合同', '档案管理');
INSERT INTO `perm` VALUES ('8', '修改分类', '档案分类');
INSERT INTO `perm` VALUES ('9', '增加员工', '员工管理');
INSERT INTO `perm` VALUES ('10', '修改员工', '员工管理');
INSERT INTO `perm` VALUES ('11', '删除员工', '员工管理');
INSERT INTO `perm` VALUES ('12', '重置密码', '员工管理');
INSERT INTO `perm` VALUES ('13', '增加角色', '角色管理');
INSERT INTO `perm` VALUES ('14', '修改角色', '角色管理');
INSERT INTO `perm` VALUES ('15', '删除角色', '角色管理');
INSERT INTO `perm` VALUES ('16', '增加小区', '小区管理');
INSERT INTO `perm` VALUES ('17', '修改小区', '小区管理');
INSERT INTO `perm` VALUES ('18', '删除小区', '小区管理');
INSERT INTO `perm` VALUES ('19', '增加银行', '银行管理');
INSERT INTO `perm` VALUES ('20', '修改银行', '银行管理');
INSERT INTO `perm` VALUES ('21', '删除银行', '银行管理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `perm` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '1,2,4,5,7,8,10,3,6,9,11,12,14,13,15,16,18,17,19,20,21');
INSERT INTO `role` VALUES ('22', '前台人员', '1,2,4,5,7,8,16,18,17,19,20,21');
INSERT INTO `role` VALUES ('23', '角色', '8');
INSERT INTO `role` VALUES ('24', '11', '9');

-- ----------------------------
-- Table structure for village
-- ----------------------------
DROP TABLE IF EXISTS `village`;
CREATE TABLE `village` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of village
-- ----------------------------
INSERT INTO `village` VALUES ('12', '英才小区', '');
INSERT INTO `village` VALUES ('13', '精彩小区2', '');
