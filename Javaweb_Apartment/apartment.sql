/*
Navicat MySQL Data Transfer

Source Server         : EL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : apartment

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-30 12:19:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `atime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `asubject` varchar(255) DEFAULT NULL,
  `aintr` varchar(255) DEFAULT NULL,
  `aaddress` varchar(255) DEFAULT NULL,
  `aprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `aid` int(11) NOT NULL,
  `roid` int(11) NOT NULL,
  `auth_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`,`roid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cnum` varchar(255) DEFAULT NULL,
  `chid` int(11) DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  `ctime` date DEFAULT NULL,
  `cstartTime` date DEFAULT NULL,
  `cendTime` date DEFAULT NULL,
  `ctotalMoney` double(255,0) DEFAULT NULL,
  `cpayType` int(11) DEFAULT NULL,
  `cstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`cid`),
  KEY `fk_chid_hid` (`chid`),
  KEY `fk_clid_lid` (`clid`),
  CONSTRAINT `fk_chid_hid` FOREIGN KEY (`chid`) REFERENCES `house` (`hid`),
  CONSTRAINT `fk_clid_lid` FOREIGN KEY (`clid`) REFERENCES `lessee` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `haddress` varchar(255) CHARACTER SET utf8 NOT NULL,
  `hfloor` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `hroomNum` int(11) NOT NULL,
  `harea` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hdir` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hdeco` int(11) NOT NULL,
  `hair` int(11) NOT NULL,
  `hprice` double(10,2) NOT NULL,
  `hrentStatus` int(11) NOT NULL,
  `himage` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `haddTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `hupdateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `hstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for lessee
-- ----------------------------
DROP TABLE IF EXISTS `lessee`;
CREATE TABLE `lessee` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `ltel` varchar(255) DEFAULT NULL,
  `lsex` int(11) DEFAULT NULL,
  `lnp` varchar(255) DEFAULT NULL,
  `lidCard` varchar(255) NOT NULL,
  `laddTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `lstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logi
-- ----------------------------
DROP TABLE IF EXISTS `logi`;
CREATE TABLE `logi` (
  `loid` int(11) NOT NULL AUTO_INCREMENT,
  `loname` varchar(255) DEFAULT NULL,
  `loidCard` varchar(255) DEFAULT NULL,
  `lotel` varchar(255) DEFAULT NULL,
  `losex` int(11) DEFAULT NULL,
  `loaddTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `losalary` double(10,2) DEFAULT NULL,
  `lstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`loid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mhid` int(11) DEFAULT NULL,
  `mloid` int(11) DEFAULT NULL,
  `mtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `mresult` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `fk_mhid_hid` (`mhid`),
  KEY `fk_mloid_loid` (`mloid`),
  CONSTRAINT `fk_mhid_hid` FOREIGN KEY (`mhid`) REFERENCES `house` (`hid`),
  CONSTRAINT `fk_mloid_loid` FOREIGN KEY (`mloid`) REFERENCES `logi` (`loid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rhid` int(11) DEFAULT NULL,
  `rlid` int(11) DEFAULT NULL,
  `rprice` double(10,2) DEFAULT NULL,
  `rpayTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `rstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`rid`),
  KEY `fk_rhid_hid` (`rhid`),
  KEY `fk_rlid_lid` (`rlid`),
  CONSTRAINT `fk_rhid_hid` FOREIGN KEY (`rhid`) REFERENCES `house` (`hid`),
  CONSTRAINT `fk_rlid_lid` FOREIGN KEY (`rlid`) REFERENCES `lessee` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roid` int(11) NOT NULL AUTO_INCREMENT,
  `roname` varchar(255) DEFAULT NULL,
  `rodesc` varchar(255) DEFAULT NULL,
  `roaddTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`roid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_auth
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `roid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`roid`,`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) NOT NULL,
  `upassword` varchar(255) NOT NULL,
  `urealname` varchar(255) DEFAULT NULL,
  `uroid` int(11) DEFAULT NULL,
  `uaddTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ustatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `roid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`roid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
