/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2015-12-24 16:58:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `stockanalysis`
-- ----------------------------
DROP TABLE IF EXISTS `stockanalysis`;
CREATE TABLE `stockanalysis` (
`Id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`Code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`SupportPrice`  double NULL DEFAULT NULL ,
`PressurePrice`  double NULL DEFAULT NULL ,
`PlanBuyPrice`  double NULL DEFAULT NULL ,
`PlanSellPrice`  double NULL DEFAULT NULL ,
`BuyPrice`  double NULL DEFAULT NULL ,
PRIMARY KEY (`Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=9 */

;

-- ----------------------------
-- Table structure for `stockinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stockinfo`;
CREATE TABLE `stockinfo` (
`Id`  int(11) NOT NULL AUTO_INCREMENT ,
`Code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`Name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`NewPrice`  double NULL DEFAULT NULL ,
`Volume`  bigint(20) NULL DEFAULT NULL ,
`IfGetHistory`  int(11) NULL DEFAULT NULL ,
`IfSetVolumeRate`  int(11) NULL DEFAULT NULL ,
`Symbol`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`IfHeart`  int(11) NOT NULL ,
PRIMARY KEY (`Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=2629 */

;

-- ----------------------------
-- Table structure for `stocktransactiondetail`
-- ----------------------------
DROP TABLE IF EXISTS `stocktransactiondetail`;
CREATE TABLE `stocktransactiondetail` (
`Id`  int(11) NOT NULL AUTO_INCREMENT ,
`Code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`TransactionDate`  date NULL DEFAULT NULL ,
`BeginPrice`  double NULL DEFAULT NULL ,
`EndPrice`  double NULL DEFAULT NULL ,
`HighestPrice`  double NULL DEFAULT NULL ,
`LowestPrice`  double NULL DEFAULT NULL ,
`Volume`  bigint(20) NULL DEFAULT NULL ,
`TransactionMoney`  bigint(20) NULL DEFAULT NULL ,
`VolumeRate`  double NULL DEFAULT NULL ,
`IfGetIntradayData`  int(11) NULL DEFAULT 0 ,
`IfAnalyIntradayData`  int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
PRIMARY KEY (`Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=986201 */

;

-- ----------------------------
-- Table structure for `ticai`
-- ----------------------------
DROP TABLE IF EXISTS `ticai`;
CREATE TABLE `ticai` (
`Id`  int(11) NOT NULL AUTO_INCREMENT ,
`Name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`Status`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=4 */

;

-- ----------------------------
-- Table structure for `ticaistockrelation`
-- ----------------------------
DROP TABLE IF EXISTS `ticaistockrelation`;
CREATE TABLE `ticaistockrelation` (
`Id`  int(11) NOT NULL AUTO_INCREMENT ,
`TicaiId`  int(11) NULL DEFAULT NULL ,
`StockCode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`Status`  int(11) NULL DEFAULT NULL ,
`Level`  int(11) NULL DEFAULT 0 ,
PRIMARY KEY (`Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=9 */

;

-- ----------------------------
-- Auto increment value for `stockanalysis`
-- ----------------------------
ALTER TABLE `stockanalysis` AUTO_INCREMENT=9;

-- ----------------------------
-- Auto increment value for `stockinfo`
-- ----------------------------
ALTER TABLE `stockinfo` AUTO_INCREMENT=2629;

-- ----------------------------
-- Auto increment value for `stocktransactiondetail`
-- ----------------------------
ALTER TABLE `stocktransactiondetail` AUTO_INCREMENT=986201;

-- ----------------------------
-- Auto increment value for `ticai`
-- ----------------------------
ALTER TABLE `ticai` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `ticaistockrelation`
-- ----------------------------
ALTER TABLE `ticaistockrelation` AUTO_INCREMENT=9;
