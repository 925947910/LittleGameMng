/*
Navicat MySQL Data Transfer

Source Server         : 正式服
Source Server Version : 50732
Source Host           : 127.0.0.1:3306
Source Database       : db_game

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-03-08 17:41:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `agentId` int(11) NOT NULL,
  `nick` varchar(255) NOT NULL DEFAULT '',
  `remain` int(11) NOT NULL DEFAULT '0',
  `cost` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  `tagId` int(11) NOT NULL DEFAULT '0',
  `accountOut` varchar(255) NOT NULL DEFAULT '',
  `accountIn` varchar(255) NOT NULL DEFAULT '',
  `reason` varchar(255) NOT NULL DEFAULT '',
  `time` bigint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`) USING BTREE,
  KEY `type` (`type`) USING BTREE,
  KEY `tagId` (`tagId`) USING BTREE,
  KEY `agentId` (`agentId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7867 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('6842', '2', '8', 'Tina', '9990', '-10', '21', '2', '', '', 'BenzBmw下注', '1615116999');
INSERT INTO `bills` VALUES ('6843', '2', '8', 'Tina', '9980', '-10', '21', '2', '', '', 'BenzBmw下注', '1615117000');
INSERT INTO `bills` VALUES ('6844', '2', '8', 'Tina', '9970', '-10', '21', '2', '', '', 'BenzBmw下注', '1615117001');
INSERT INTO `bills` VALUES ('6845', '2', '8', 'Tina', '9920', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117041');
INSERT INTO `bills` VALUES ('6846', '2', '8', 'Tina', '9870', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117042');
INSERT INTO `bills` VALUES ('6847', '2', '8', 'Tina', '9820', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117082');
INSERT INTO `bills` VALUES ('6848', '2', '8', 'Tina', '9770', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117084');
INSERT INTO `bills` VALUES ('6849', '2', '8', 'Tina', '9720', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117085');
INSERT INTO `bills` VALUES ('6850', '2', '8', 'Tina', '9670', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117086');
INSERT INTO `bills` VALUES ('6851', '2', '8', 'Tina', '9620', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117116');
INSERT INTO `bills` VALUES ('6852', '2', '8', 'Tina', '9570', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117117');
INSERT INTO `bills` VALUES ('6853', '2', '8', 'Tina', '9520', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117117');
INSERT INTO `bills` VALUES ('6854', '2', '8', 'Tina', '9470', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117118');
INSERT INTO `bills` VALUES ('6855', '2', '8', 'Tina', '9420', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117119');
INSERT INTO `bills` VALUES ('6856', '2', '8', 'Tina', '9370', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117119');
INSERT INTO `bills` VALUES ('6857', '2', '8', 'Tina', '9320', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117119');
INSERT INTO `bills` VALUES ('6858', '2', '8', 'Tina', '9270', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117119');
INSERT INTO `bills` VALUES ('6859', '2', '8', 'Tina', '9220', '-50', '21', '2', '', '', 'BenzBmw下注', '1615117119');
INSERT INTO `bills` VALUES ('6860', '2', '8', 'Tina', '9120', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117198');
INSERT INTO `bills` VALUES ('6861', '2', '8', 'Tina', '9020', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117199');
INSERT INTO `bills` VALUES ('6862', '2', '8', 'Tina', '8920', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117199');
INSERT INTO `bills` VALUES ('6863', '2', '8', 'Tina', '8820', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117200');
INSERT INTO `bills` VALUES ('6864', '2', '8', 'Tina', '8720', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117200');
INSERT INTO `bills` VALUES ('6865', '2', '8', 'Tina', '8620', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117200');
INSERT INTO `bills` VALUES ('6866', '2', '8', 'Tina', '8520', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117200');
INSERT INTO `bills` VALUES ('6867', '2', '8', 'Tina', '8420', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117201');
INSERT INTO `bills` VALUES ('6868', '2', '8', 'Tina', '8320', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117201');
INSERT INTO `bills` VALUES ('6869', '2', '8', 'Tina', '8220', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117233');
INSERT INTO `bills` VALUES ('6870', '2', '8', 'Tina', '8120', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117235');
INSERT INTO `bills` VALUES ('6871', '2', '8', 'Tina', '8020', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117235');
INSERT INTO `bills` VALUES ('6872', '2', '8', 'Tina', '7920', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117235');
INSERT INTO `bills` VALUES ('6873', '2', '8', 'Tina', '7820', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117236');
INSERT INTO `bills` VALUES ('6874', '2', '8', 'Tina', '7720', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117237');
INSERT INTO `bills` VALUES ('6875', '2', '8', 'Tina', '7620', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117237');
INSERT INTO `bills` VALUES ('6876', '2', '8', 'Tina', '7520', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117237');
INSERT INTO `bills` VALUES ('6877', '2', '8', 'Tina', '7420', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117237');
INSERT INTO `bills` VALUES ('6878', '2', '8', 'Tina', '7320', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117237');
INSERT INTO `bills` VALUES ('6879', '2', '8', 'Tina', '7220', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6880', '2', '8', 'Tina', '7120', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6881', '2', '8', 'Tina', '7020', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6882', '2', '8', 'Tina', '6920', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6883', '2', '8', 'Tina', '6820', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6884', '2', '8', 'Tina', '6720', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117238');
INSERT INTO `bills` VALUES ('6885', '2', '8', 'Tina', '6620', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117239');
INSERT INTO `bills` VALUES ('6886', '2', '8', 'Tina', '6520', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117239');
INSERT INTO `bills` VALUES ('6887', '2', '8', 'Tina', '6420', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117278');
INSERT INTO `bills` VALUES ('6888', '2', '8', 'Tina', '6320', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117279');
INSERT INTO `bills` VALUES ('6889', '2', '8', 'Tina', '6220', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117279');
INSERT INTO `bills` VALUES ('6890', '2', '8', 'Tina', '6120', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117279');
INSERT INTO `bills` VALUES ('6891', '2', '8', 'Tina', '6020', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117279');
INSERT INTO `bills` VALUES ('6892', '2', '8', 'Tina', '5920', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117280');
INSERT INTO `bills` VALUES ('6893', '2', '8', 'Tina', '5820', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117280');
INSERT INTO `bills` VALUES ('6894', '2', '8', 'Tina', '5720', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117280');
INSERT INTO `bills` VALUES ('6895', '2', '8', 'Tina', '5620', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117280');
INSERT INTO `bills` VALUES ('6896', '2', '8', 'Tina', '5520', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6897', '2', '8', 'Tina', '5420', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6898', '2', '8', 'Tina', '5320', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6899', '2', '8', 'Tina', '5220', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6900', '2', '8', 'Tina', '5120', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6901', '2', '8', 'Tina', '5020', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117281');
INSERT INTO `bills` VALUES ('6902', '2', '8', 'Tina', '4920', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117282');
INSERT INTO `bills` VALUES ('6903', '2', '8', 'Tina', '4820', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117282');
INSERT INTO `bills` VALUES ('6904', '2', '8', 'Tina', '4720', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117282');
INSERT INTO `bills` VALUES ('6905', '2', '8', 'Tina', '4620', '-100', '21', '2', '', '', 'BenzBmw下注', '1615117282');
INSERT INTO `bills` VALUES ('6906', '2', '8', 'Tina', '4120', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117361');
INSERT INTO `bills` VALUES ('6907', '2', '8', 'Tina', '3620', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117361');
INSERT INTO `bills` VALUES ('6908', '2', '8', 'Tina', '3120', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117361');
INSERT INTO `bills` VALUES ('6909', '2', '8', 'Tina', '2620', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117362');
INSERT INTO `bills` VALUES ('6910', '2', '8', 'Tina', '2120', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117362');
INSERT INTO `bills` VALUES ('6911', '2', '8', 'Tina', '1620', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117362');
INSERT INTO `bills` VALUES ('6912', '2', '8', 'Tina', '1120', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117362');
INSERT INTO `bills` VALUES ('6913', '2', '8', 'Tina', '620', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117363');
INSERT INTO `bills` VALUES ('6914', '2', '8', 'Tina', '120', '-500', '21', '2', '', '', 'BenzBmw下注', '1615117363');
INSERT INTO `bills` VALUES ('6915', '8', '171', '555', '110000', '100000', '12', '8', '', '', '业务号', '1615120782');
INSERT INTO `bills` VALUES ('6916', '8', '171', '555', '109990', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125049');
INSERT INTO `bills` VALUES ('6917', '8', '171', '555', '109980', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125050');
INSERT INTO `bills` VALUES ('6918', '8', '171', '555', '109970', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125050');
INSERT INTO `bills` VALUES ('6919', '8', '171', '555', '109960', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125050');
INSERT INTO `bills` VALUES ('6920', '8', '171', '555', '109950', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125051');
INSERT INTO `bills` VALUES ('6921', '8', '171', '555', '109940', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125051');
INSERT INTO `bills` VALUES ('6922', '8', '171', '555', '109930', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125051');
INSERT INTO `bills` VALUES ('6923', '8', '171', '555', '109920', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125052');
INSERT INTO `bills` VALUES ('6924', '8', '171', '555', '109910', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125052');
INSERT INTO `bills` VALUES ('6925', '8', '171', '555', '109960', '50', '24', '0', '', '', 'Benz BMW Issue69644', '1615125066');
INSERT INTO `bills` VALUES ('6926', '8', '171', '555', '109950', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125171');
INSERT INTO `bills` VALUES ('6927', '8', '171', '555', '109940', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125172');
INSERT INTO `bills` VALUES ('6928', '8', '171', '555', '109930', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125174');
INSERT INTO `bills` VALUES ('6929', '8', '171', '555', '109920', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125290');
INSERT INTO `bills` VALUES ('6930', '8', '171', '555', '109910', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125291');
INSERT INTO `bills` VALUES ('6931', '8', '171', '555', '109900', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125291');
INSERT INTO `bills` VALUES ('6932', '8', '171', '555', '109890', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125292');
INSERT INTO `bills` VALUES ('6933', '8', '171', '555', '109880', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125292');
INSERT INTO `bills` VALUES ('6934', '8', '171', '555', '109870', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125292');
INSERT INTO `bills` VALUES ('6935', '8', '171', '555', '109860', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125293');
INSERT INTO `bills` VALUES ('6936', '8', '171', '555', '109850', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125293');
INSERT INTO `bills` VALUES ('6937', '8', '171', '555', '109840', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125294');
INSERT INTO `bills` VALUES ('6938', '8', '171', '555', '109830', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125294');
INSERT INTO `bills` VALUES ('6939', '8', '171', '555', '109820', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125294');
INSERT INTO `bills` VALUES ('6940', '8', '171', '555', '109810', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125294');
INSERT INTO `bills` VALUES ('6941', '8', '171', '555', '109800', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125295');
INSERT INTO `bills` VALUES ('6942', '8', '171', '555', '109790', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125295');
INSERT INTO `bills` VALUES ('6943', '8', '171', '555', '109780', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125298');
INSERT INTO `bills` VALUES ('6944', '8', '171', '555', '109770', '-10', '21', '8', '', '', 'BenzBmw下注', '1615125299');
INSERT INTO `bills` VALUES ('6945', '8', '171', '555', '109760', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126099');
INSERT INTO `bills` VALUES ('6946', '8', '171', '555', '109750', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126099');
INSERT INTO `bills` VALUES ('6947', '8', '171', '555', '109740', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126689');
INSERT INTO `bills` VALUES ('6948', '8', '171', '555', '109730', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126690');
INSERT INTO `bills` VALUES ('6949', '8', '171', '555', '109720', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126690');
INSERT INTO `bills` VALUES ('6950', '8', '171', '555', '109710', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126690');
INSERT INTO `bills` VALUES ('6951', '8', '171', '555', '109700', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126691');
INSERT INTO `bills` VALUES ('6952', '8', '171', '555', '109690', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126691');
INSERT INTO `bills` VALUES ('6953', '8', '171', '555', '109680', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126691');
INSERT INTO `bills` VALUES ('6954', '8', '171', '555', '109670', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126692');
INSERT INTO `bills` VALUES ('6955', '8', '171', '555', '109660', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126692');
INSERT INTO `bills` VALUES ('6956', '8', '171', '555', '109650', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126692');
INSERT INTO `bills` VALUES ('6957', '8', '171', '555', '109640', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126693');
INSERT INTO `bills` VALUES ('6958', '8', '171', '555', '109630', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126693');
INSERT INTO `bills` VALUES ('6959', '8', '171', '555', '109620', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126694');
INSERT INTO `bills` VALUES ('6960', '8', '171', '555', '109610', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126694');
INSERT INTO `bills` VALUES ('6961', '8', '171', '555', '109600', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126694');
INSERT INTO `bills` VALUES ('6962', '8', '171', '555', '109590', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126694');
INSERT INTO `bills` VALUES ('6963', '8', '171', '555', '109580', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126695');
INSERT INTO `bills` VALUES ('6964', '8', '171', '555', '109570', '-10', '21', '8', '', '', 'BenzBmw下注', '1615126695');
INSERT INTO `bills` VALUES ('6965', '8', '171', '555', '109670', '100', '24', '0', '', '', 'Benz BMW Issue71284', '1615126706');
INSERT INTO `bills` VALUES ('6966', '8', '171', '555', '109660', '-10', '20', '8', '', '', '红绿球下注', '1615126735');
INSERT INTO `bills` VALUES ('6967', '8', '171', '555', '109650', '-10', '20', '8', '', '', '红绿球下注', '1615126736');
INSERT INTO `bills` VALUES ('6968', '10', '171', 'daxiong', '1010000', '1000000', '12', '8', '', '', '业务号', '1615127717');
INSERT INTO `bills` VALUES ('6969', '10', '171', 'daxiong', '1009900', '-100', '22', '10', '', '', '一元购下注', '1615127768');
INSERT INTO `bills` VALUES ('6970', '10', '171', 'daxiong', '1009800', '-100', '22', '10', '', '', '一元购下注', '1615127777');
INSERT INTO `bills` VALUES ('6971', '10', '171', 'daxiong', '1009700', '-100', '22', '10', '', '', '一元购下注', '1615127782');
INSERT INTO `bills` VALUES ('6972', '10', '171', 'daxiong', '1009600', '-100', '22', '10', '', '', '一元购下注', '1615127784');
INSERT INTO `bills` VALUES ('6973', '10', '171', 'daxiong', '1009500', '-100', '22', '10', '', '', '一元购下注', '1615127784');
INSERT INTO `bills` VALUES ('6974', '10', '171', 'daxiong', '1009400', '-100', '22', '10', '', '', '一元购下注', '1615127785');
INSERT INTO `bills` VALUES ('6975', '10', '171', 'daxiong', '1009300', '-100', '22', '10', '', '', '一元购下注', '1615127785');
INSERT INTO `bills` VALUES ('6976', '10', '171', 'daxiong', '1009200', '-100', '22', '10', '', '', '一元购下注', '1615127785');
INSERT INTO `bills` VALUES ('6977', '10', '171', 'daxiong', '1009100', '-100', '22', '10', '', '', '一元购下注', '1615127785');
INSERT INTO `bills` VALUES ('6978', '10', '171', 'daxiong', '1009000', '-100', '22', '10', '', '', '一元购下注', '1615127785');
INSERT INTO `bills` VALUES ('6979', '10', '171', 'daxiong', '1008900', '-100', '22', '10', '', '', '一元购下注', '1615127786');
INSERT INTO `bills` VALUES ('6980', '10', '171', 'daxiong', '1008800', '-100', '22', '10', '', '', '一元购下注', '1615127786');
INSERT INTO `bills` VALUES ('6981', '10', '171', 'daxiong', '1008700', '-100', '22', '10', '', '', '一元购下注', '1615127786');
INSERT INTO `bills` VALUES ('6982', '10', '171', 'daxiong', '1008600', '-100', '22', '10', '', '', '一元购下注', '1615127786');
INSERT INTO `bills` VALUES ('6983', '10', '171', 'daxiong', '1008500', '-100', '22', '10', '', '', '一元购下注', '1615127786');
INSERT INTO `bills` VALUES ('6984', '10', '171', 'daxiong', '1008300', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127850');
INSERT INTO `bills` VALUES ('6985', '10', '171', 'daxiong', '1008100', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127851');
INSERT INTO `bills` VALUES ('6986', '10', '171', 'daxiong', '1007900', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127851');
INSERT INTO `bills` VALUES ('6987', '10', '171', 'daxiong', '1007700', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127852');
INSERT INTO `bills` VALUES ('6988', '10', '171', 'daxiong', '1007500', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127852');
INSERT INTO `bills` VALUES ('6989', '10', '171', 'daxiong', '1007300', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127853');
INSERT INTO `bills` VALUES ('6990', '10', '171', 'daxiong', '1007100', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127853');
INSERT INTO `bills` VALUES ('6991', '10', '171', 'daxiong', '1006900', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127854');
INSERT INTO `bills` VALUES ('6992', '10', '171', 'daxiong', '1006700', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127858');
INSERT INTO `bills` VALUES ('6993', '10', '171', 'daxiong', '1006500', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127858');
INSERT INTO `bills` VALUES ('6994', '10', '171', 'daxiong', '1006300', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127858');
INSERT INTO `bills` VALUES ('6995', '10', '171', 'daxiong', '1006100', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127858');
INSERT INTO `bills` VALUES ('6996', '10', '171', 'daxiong', '1005900', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127858');
INSERT INTO `bills` VALUES ('6997', '10', '171', 'daxiong', '1005700', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127859');
INSERT INTO `bills` VALUES ('6998', '10', '171', 'daxiong', '1005500', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127859');
INSERT INTO `bills` VALUES ('6999', '10', '171', 'daxiong', '1005300', '-200', '21', '10', '', '', 'BenzBmw下注', '1615127860');
INSERT INTO `bills` VALUES ('7000', '10', '171', 'daxiong', '1007300', '2000', '24', '0', '', '', 'Benz BMW Issue72444', '1615127866');
INSERT INTO `bills` VALUES ('7001', '10', '171', 'daxiong', '1007200', '-100', '20', '10', '', '', '红绿球下注', '1615127902');
INSERT INTO `bills` VALUES ('7002', '10', '171', 'daxiong', '1007190', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128251');
INSERT INTO `bills` VALUES ('7003', '10', '171', 'daxiong', '1007180', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128251');
INSERT INTO `bills` VALUES ('7004', '10', '171', 'daxiong', '1007170', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128252');
INSERT INTO `bills` VALUES ('7005', '10', '171', 'daxiong', '1007160', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128252');
INSERT INTO `bills` VALUES ('7006', '10', '171', 'daxiong', '1007150', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128253');
INSERT INTO `bills` VALUES ('7007', '10', '171', 'daxiong', '1007140', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128253');
INSERT INTO `bills` VALUES ('7008', '10', '171', 'daxiong', '1007130', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128254');
INSERT INTO `bills` VALUES ('7009', '10', '171', 'daxiong', '1007120', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128254');
INSERT INTO `bills` VALUES ('7010', '10', '171', 'daxiong', '1007110', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128255');
INSERT INTO `bills` VALUES ('7011', '10', '171', 'daxiong', '1007100', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128255');
INSERT INTO `bills` VALUES ('7012', '10', '171', 'daxiong', '1007090', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128256');
INSERT INTO `bills` VALUES ('7013', '10', '171', 'daxiong', '1007080', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128257');
INSERT INTO `bills` VALUES ('7014', '10', '171', 'daxiong', '1007070', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128257');
INSERT INTO `bills` VALUES ('7015', '10', '171', 'daxiong', '1007060', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128257');
INSERT INTO `bills` VALUES ('7016', '10', '171', 'daxiong', '1007050', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128257');
INSERT INTO `bills` VALUES ('7017', '10', '171', 'daxiong', '1007040', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128258');
INSERT INTO `bills` VALUES ('7018', '10', '171', 'daxiong', '1007030', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128258');
INSERT INTO `bills` VALUES ('7019', '10', '171', 'daxiong', '1007020', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128258');
INSERT INTO `bills` VALUES ('7020', '10', '171', 'daxiong', '1007010', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128259');
INSERT INTO `bills` VALUES ('7021', '10', '171', 'daxiong', '1007000', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128259');
INSERT INTO `bills` VALUES ('7022', '10', '171', 'daxiong', '1007100', '100', '24', '0', '', '', 'Benz BMW Issue72844', '1615128266');
INSERT INTO `bills` VALUES ('7023', '10', '171', 'daxiong', '1007000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128334');
INSERT INTO `bills` VALUES ('7024', '10', '171', 'daxiong', '1006900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128334');
INSERT INTO `bills` VALUES ('7025', '10', '171', 'daxiong', '1006800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128334');
INSERT INTO `bills` VALUES ('7026', '10', '171', 'daxiong', '1006700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128335');
INSERT INTO `bills` VALUES ('7027', '10', '171', 'daxiong', '1006600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128335');
INSERT INTO `bills` VALUES ('7028', '10', '171', 'daxiong', '1006500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128335');
INSERT INTO `bills` VALUES ('7029', '10', '171', 'daxiong', '1006400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128335');
INSERT INTO `bills` VALUES ('7030', '10', '171', 'daxiong', '1006300', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128336');
INSERT INTO `bills` VALUES ('7031', '10', '171', 'daxiong', '1006200', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128337');
INSERT INTO `bills` VALUES ('7032', '10', '171', 'daxiong', '1006100', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128337');
INSERT INTO `bills` VALUES ('7033', '10', '171', 'daxiong', '1006000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128338');
INSERT INTO `bills` VALUES ('7034', '10', '171', 'daxiong', '1005900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128338');
INSERT INTO `bills` VALUES ('7035', '10', '171', 'daxiong', '1005800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128338');
INSERT INTO `bills` VALUES ('7036', '10', '171', 'daxiong', '1005700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128338');
INSERT INTO `bills` VALUES ('7037', '10', '171', 'daxiong', '1005600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128339');
INSERT INTO `bills` VALUES ('7038', '10', '171', 'daxiong', '1005500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128339');
INSERT INTO `bills` VALUES ('7039', '10', '171', 'daxiong', '1005400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128339');
INSERT INTO `bills` VALUES ('7040', '10', '171', 'daxiong', '1005300', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128339');
INSERT INTO `bills` VALUES ('7041', '10', '171', 'daxiong', '1005200', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128340');
INSERT INTO `bills` VALUES ('7042', '10', '171', 'daxiong', '1005100', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128340');
INSERT INTO `bills` VALUES ('7043', '10', '171', 'daxiong', '1005000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128341');
INSERT INTO `bills` VALUES ('7044', '10', '171', 'daxiong', '1004900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128341');
INSERT INTO `bills` VALUES ('7045', '10', '171', 'daxiong', '1004800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128342');
INSERT INTO `bills` VALUES ('7046', '10', '171', 'daxiong', '1004700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128342');
INSERT INTO `bills` VALUES ('7047', '10', '171', 'daxiong', '1004600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128342');
INSERT INTO `bills` VALUES ('7048', '10', '171', 'daxiong', '1004500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128342');
INSERT INTO `bills` VALUES ('7049', '10', '171', 'daxiong', '1004400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128343');
INSERT INTO `bills` VALUES ('7050', '10', '171', 'daxiong', '1004300', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128343');
INSERT INTO `bills` VALUES ('7051', '10', '171', 'daxiong', '1004200', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128343');
INSERT INTO `bills` VALUES ('7052', '10', '171', 'daxiong', '1004100', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128343');
INSERT INTO `bills` VALUES ('7053', '10', '171', 'daxiong', '1004000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128343');
INSERT INTO `bills` VALUES ('7054', '10', '171', 'daxiong', '1003900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128372');
INSERT INTO `bills` VALUES ('7055', '10', '171', 'daxiong', '1003800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128372');
INSERT INTO `bills` VALUES ('7056', '10', '171', 'daxiong', '1003700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128372');
INSERT INTO `bills` VALUES ('7057', '10', '171', 'daxiong', '1003600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128372');
INSERT INTO `bills` VALUES ('7058', '10', '171', 'daxiong', '1003500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128373');
INSERT INTO `bills` VALUES ('7059', '10', '171', 'daxiong', '1003400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128373');
INSERT INTO `bills` VALUES ('7060', '10', '171', 'daxiong', '1003300', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128373');
INSERT INTO `bills` VALUES ('7061', '10', '171', 'daxiong', '1003200', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128373');
INSERT INTO `bills` VALUES ('7062', '10', '171', 'daxiong', '1003100', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128373');
INSERT INTO `bills` VALUES ('7063', '10', '171', 'daxiong', '1003000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128374');
INSERT INTO `bills` VALUES ('7064', '10', '171', 'daxiong', '1002900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128374');
INSERT INTO `bills` VALUES ('7065', '10', '171', 'daxiong', '1002800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128374');
INSERT INTO `bills` VALUES ('7066', '10', '171', 'daxiong', '1002700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128374');
INSERT INTO `bills` VALUES ('7067', '10', '171', 'daxiong', '1002600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128375');
INSERT INTO `bills` VALUES ('7068', '10', '171', 'daxiong', '1002500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128375');
INSERT INTO `bills` VALUES ('7069', '10', '171', 'daxiong', '1002400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128375');
INSERT INTO `bills` VALUES ('7070', '10', '171', 'daxiong', '1002300', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128375');
INSERT INTO `bills` VALUES ('7071', '10', '171', 'daxiong', '1002200', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128375');
INSERT INTO `bills` VALUES ('7072', '10', '171', 'daxiong', '1002100', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128376');
INSERT INTO `bills` VALUES ('7073', '10', '171', 'daxiong', '1002000', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128376');
INSERT INTO `bills` VALUES ('7074', '10', '171', 'daxiong', '1001900', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128376');
INSERT INTO `bills` VALUES ('7075', '10', '171', 'daxiong', '1001800', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128382');
INSERT INTO `bills` VALUES ('7076', '10', '171', 'daxiong', '1001700', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128382');
INSERT INTO `bills` VALUES ('7077', '10', '171', 'daxiong', '1001600', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128449');
INSERT INTO `bills` VALUES ('7078', '10', '171', 'daxiong', '1001500', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128449');
INSERT INTO `bills` VALUES ('7079', '10', '171', 'daxiong', '1001400', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128449');
INSERT INTO `bills` VALUES ('7080', '10', '171', 'daxiong', '1001390', '-10', '21', '10', '', '', 'BenzBmw下注', '1615128449');
INSERT INTO `bills` VALUES ('7081', '10', '171', 'daxiong', '1001290', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128450');
INSERT INTO `bills` VALUES ('7082', '10', '171', 'daxiong', '1001190', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128455');
INSERT INTO `bills` VALUES ('7083', '10', '171', 'daxiong', '1001090', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128455');
INSERT INTO `bills` VALUES ('7084', '10', '171', 'daxiong', '1000990', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128456');
INSERT INTO `bills` VALUES ('7085', '10', '171', 'daxiong', '1000890', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128456');
INSERT INTO `bills` VALUES ('7086', '10', '171', 'daxiong', '1000790', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128456');
INSERT INTO `bills` VALUES ('7087', '10', '171', 'daxiong', '1000690', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128457');
INSERT INTO `bills` VALUES ('7088', '10', '171', 'daxiong', '1000590', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128457');
INSERT INTO `bills` VALUES ('7089', '10', '171', 'daxiong', '1000490', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128457');
INSERT INTO `bills` VALUES ('7090', '10', '171', 'daxiong', '1000390', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128457');
INSERT INTO `bills` VALUES ('7091', '10', '171', 'daxiong', '1000290', '-100', '21', '10', '', '', 'BenzBmw下注', '1615128458');
INSERT INTO `bills` VALUES ('7092', '10', '171', 'daxiong', '1000240', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128500');
INSERT INTO `bills` VALUES ('7093', '10', '171', 'daxiong', '1000190', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128500');
INSERT INTO `bills` VALUES ('7094', '10', '171', 'daxiong', '1000140', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128500');
INSERT INTO `bills` VALUES ('7095', '10', '171', 'daxiong', '1000090', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128501');
INSERT INTO `bills` VALUES ('7096', '10', '171', 'daxiong', '1000040', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128501');
INSERT INTO `bills` VALUES ('7097', '10', '171', 'daxiong', '999990', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128501');
INSERT INTO `bills` VALUES ('7098', '10', '171', 'daxiong', '999940', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7099', '10', '171', 'daxiong', '999890', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7100', '10', '171', 'daxiong', '999840', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7101', '10', '171', 'daxiong', '999790', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7102', '10', '171', 'daxiong', '999740', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7103', '10', '171', 'daxiong', '999690', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7104', '10', '171', 'daxiong', '999640', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128502');
INSERT INTO `bills` VALUES ('7105', '10', '171', 'daxiong', '999590', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128540');
INSERT INTO `bills` VALUES ('7106', '10', '171', 'daxiong', '999540', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7107', '10', '171', 'daxiong', '999490', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7108', '10', '171', 'daxiong', '999440', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7109', '10', '171', 'daxiong', '999390', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7110', '10', '171', 'daxiong', '999340', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7111', '10', '171', 'daxiong', '999290', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128541');
INSERT INTO `bills` VALUES ('7112', '10', '171', 'daxiong', '999240', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128542');
INSERT INTO `bills` VALUES ('7113', '10', '171', 'daxiong', '999190', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128542');
INSERT INTO `bills` VALUES ('7114', '10', '171', 'daxiong', '999140', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128542');
INSERT INTO `bills` VALUES ('7115', '10', '171', 'daxiong', '999090', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128542');
INSERT INTO `bills` VALUES ('7116', '10', '171', 'daxiong', '999040', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128542');
INSERT INTO `bills` VALUES ('7117', '10', '171', 'daxiong', '998990', '-50', '21', '10', '', '', 'BenzBmw下注', '1615128543');
INSERT INTO `bills` VALUES ('7118', '11', '8', 'Mozi2019', '9000', '-1000', '21', '11', '', '', 'BenzBmw下注', '1615128651');
INSERT INTO `bills` VALUES ('7119', '11', '8', 'Mozi2019', '8000', '-1000', '21', '11', '', '', 'BenzBmw下注', '1615128652');
INSERT INTO `bills` VALUES ('7120', '11', '8', 'Mozi2019', '7000', '-1000', '21', '11', '', '', 'BenzBmw下注', '1615128653');
INSERT INTO `bills` VALUES ('7121', '11', '8', 'Mozi2019', '6000', '-1000', '21', '11', '', '', 'BenzBmw下注', '1615128654');
INSERT INTO `bills` VALUES ('7122', '11', '8', 'Mozi2019', '5990', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128691');
INSERT INTO `bills` VALUES ('7123', '11', '8', 'Mozi2019', '5980', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128692');
INSERT INTO `bills` VALUES ('7124', '11', '8', 'Mozi2019', '5970', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128693');
INSERT INTO `bills` VALUES ('7125', '11', '8', 'Mozi2019', '5960', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128694');
INSERT INTO `bills` VALUES ('7126', '11', '8', 'Mozi2019', '5950', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128695');
INSERT INTO `bills` VALUES ('7127', '11', '8', 'Mozi2019', '5940', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128695');
INSERT INTO `bills` VALUES ('7128', '11', '8', 'Mozi2019', '5930', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128696');
INSERT INTO `bills` VALUES ('7129', '11', '8', 'Mozi2019', '5920', '-10', '21', '11', '', '', 'BenzBmw下注', '1615128697');
INSERT INTO `bills` VALUES ('7130', '11', '8', 'Mozi2019', '5970', '50', '24', '0', '', '', 'Benz BMW Issue73284', '1615128706');
INSERT INTO `bills` VALUES ('7131', '11', '8', 'Mozi2019', '5960', '-10', '20', '11', '', '', '红绿球下注', '1615128730');
INSERT INTO `bills` VALUES ('7132', '10', '171', 'daxiong', '998490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128732');
INSERT INTO `bills` VALUES ('7133', '10', '171', 'daxiong', '997990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128732');
INSERT INTO `bills` VALUES ('7134', '10', '171', 'daxiong', '997490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128732');
INSERT INTO `bills` VALUES ('7135', '10', '171', 'daxiong', '996990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128732');
INSERT INTO `bills` VALUES ('7136', '10', '171', 'daxiong', '996490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128733');
INSERT INTO `bills` VALUES ('7137', '10', '171', 'daxiong', '995990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128733');
INSERT INTO `bills` VALUES ('7138', '10', '171', 'daxiong', '995490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128733');
INSERT INTO `bills` VALUES ('7139', '10', '171', 'daxiong', '994990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128733');
INSERT INTO `bills` VALUES ('7140', '10', '171', 'daxiong', '994490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128734');
INSERT INTO `bills` VALUES ('7141', '10', '171', 'daxiong', '993990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128734');
INSERT INTO `bills` VALUES ('7142', '10', '171', 'daxiong', '993490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128734');
INSERT INTO `bills` VALUES ('7143', '10', '171', 'daxiong', '992990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128734');
INSERT INTO `bills` VALUES ('7144', '10', '171', 'daxiong', '992490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128734');
INSERT INTO `bills` VALUES ('7145', '10', '171', 'daxiong', '991990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128735');
INSERT INTO `bills` VALUES ('7146', '10', '171', 'daxiong', '991490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128735');
INSERT INTO `bills` VALUES ('7147', '10', '171', 'daxiong', '990990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128735');
INSERT INTO `bills` VALUES ('7148', '10', '171', 'daxiong', '990490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7149', '10', '171', 'daxiong', '989990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7150', '10', '171', 'daxiong', '989490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7151', '10', '171', 'daxiong', '988990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7152', '10', '171', 'daxiong', '988490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7153', '10', '171', 'daxiong', '987990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128736');
INSERT INTO `bills` VALUES ('7154', '10', '171', 'daxiong', '987490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7155', '10', '171', 'daxiong', '986990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7156', '10', '171', 'daxiong', '986490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7157', '10', '171', 'daxiong', '985990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7158', '10', '171', 'daxiong', '985490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7159', '10', '171', 'daxiong', '984990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7160', '10', '171', 'daxiong', '984490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128737');
INSERT INTO `bills` VALUES ('7161', '10', '171', 'daxiong', '983990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7162', '10', '171', 'daxiong', '983490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7163', '10', '171', 'daxiong', '982990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7164', '10', '171', 'daxiong', '982490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7165', '10', '171', 'daxiong', '981990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7166', '10', '171', 'daxiong', '981490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7167', '10', '171', 'daxiong', '980990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7168', '10', '171', 'daxiong', '980490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128738');
INSERT INTO `bills` VALUES ('7169', '10', '171', 'daxiong', '979990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7170', '10', '171', 'daxiong', '979490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7171', '10', '171', 'daxiong', '978990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7172', '10', '171', 'daxiong', '978490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7173', '10', '171', 'daxiong', '977990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7174', '10', '171', 'daxiong', '977490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7175', '10', '171', 'daxiong', '976990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128739');
INSERT INTO `bills` VALUES ('7176', '10', '171', 'daxiong', '976490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7177', '10', '171', 'daxiong', '975990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7178', '10', '171', 'daxiong', '975490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7179', '10', '171', 'daxiong', '974990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7180', '10', '171', 'daxiong', '974490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7181', '10', '171', 'daxiong', '973990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7182', '10', '171', 'daxiong', '973490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128740');
INSERT INTO `bills` VALUES ('7183', '10', '171', 'daxiong', '972990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128741');
INSERT INTO `bills` VALUES ('7184', '10', '171', 'daxiong', '972490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128741');
INSERT INTO `bills` VALUES ('7185', '10', '171', 'daxiong', '971990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128741');
INSERT INTO `bills` VALUES ('7186', '10', '171', 'daxiong', '971490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128741');
INSERT INTO `bills` VALUES ('7187', '10', '171', 'daxiong', '970990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128741');
INSERT INTO `bills` VALUES ('7188', '10', '171', 'daxiong', '970490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7189', '10', '171', 'daxiong', '969990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7190', '10', '171', 'daxiong', '969490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7191', '10', '171', 'daxiong', '968990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7192', '10', '171', 'daxiong', '968490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7193', '10', '171', 'daxiong', '967990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7194', '10', '171', 'daxiong', '967490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7195', '10', '171', 'daxiong', '966990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7196', '10', '171', 'daxiong', '966490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7197', '10', '171', 'daxiong', '965990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7198', '10', '171', 'daxiong', '965490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7199', '10', '171', 'daxiong', '964990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128742');
INSERT INTO `bills` VALUES ('7200', '10', '171', 'daxiong', '964490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128743');
INSERT INTO `bills` VALUES ('7201', '10', '171', 'daxiong', '963990', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128743');
INSERT INTO `bills` VALUES ('7202', '10', '171', 'daxiong', '963490', '-500', '21', '10', '', '', 'BenzBmw下注', '1615128743');
INSERT INTO `bills` VALUES ('7203', '11', '8', 'Mozi2019', '5950', '-10', '20', '11', '', '', '红绿球下注', '1615128794');
INSERT INTO `bills` VALUES ('7204', '11', '8', 'Mozi2019', '5850', '-100', '20', '11', '', '', '红绿球下注', '1615128861');
INSERT INTO `bills` VALUES ('7205', '8', '171', '555', '109640', '-10', '21', '8', '', '', 'BenzBmw下注', '1615128973');
INSERT INTO `bills` VALUES ('7206', '12', '8', 'ssjj', '9000', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615129292');
INSERT INTO `bills` VALUES ('7207', '12', '8', 'ssjj', '8000', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615129293');
INSERT INTO `bills` VALUES ('7208', '12', '8', 'ssjj', '7000', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615129297');
INSERT INTO `bills` VALUES ('7209', '12', '8', 'ssjj', '6900', '-100', '20', '12', '', '', '红绿球下注', '1615129388');
INSERT INTO `bills` VALUES ('7210', '11', '8', 'Mozi2019', '5840', '-10', '20', '11', '', '', '红绿球下注', '1615129417');
INSERT INTO `bills` VALUES ('7211', '11', '8', 'Mozi2019', '5830', '-10', '20', '11', '', '', '红绿球下注', '1615129437');
INSERT INTO `bills` VALUES ('7212', '8', '171', '555', '109630', '-10', '20', '8', '', '', '红绿球下注', '1615129744');
INSERT INTO `bills` VALUES ('7213', '8', '171', '555', '109620', '-10', '20', '8', '', '', '红绿球下注', '1615129778');
INSERT INTO `bills` VALUES ('7214', '10', '171', 'daxiong', '963480', '-10', '20', '10', '', '', '红绿球下注', '1615129882');
INSERT INTO `bills` VALUES ('7215', '10', '171', 'daxiong', '953480', '-10000', '20', '10', '', '', '红绿球下注', '1615129925');
INSERT INTO `bills` VALUES ('7216', '8', '171', '555', '109610', '-10', '21', '8', '', '', 'BenzBmw下注', '1615130336');
INSERT INTO `bills` VALUES ('7217', '8', '171', '555', '109600', '-10', '21', '8', '', '', 'BenzBmw下注', '1615130337');
INSERT INTO `bills` VALUES ('7218', '8', '171', '555', '109550', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130770');
INSERT INTO `bills` VALUES ('7219', '8', '171', '555', '109500', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130770');
INSERT INTO `bills` VALUES ('7220', '8', '171', '555', '109450', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130770');
INSERT INTO `bills` VALUES ('7221', '8', '171', '555', '109400', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130771');
INSERT INTO `bills` VALUES ('7222', '8', '171', '555', '109350', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130771');
INSERT INTO `bills` VALUES ('7223', '8', '171', '555', '109300', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130772');
INSERT INTO `bills` VALUES ('7224', '8', '171', '555', '109250', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130772');
INSERT INTO `bills` VALUES ('7225', '8', '171', '555', '109200', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130774');
INSERT INTO `bills` VALUES ('7226', '8', '171', '555', '109150', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130774');
INSERT INTO `bills` VALUES ('7227', '8', '171', '555', '109100', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130774');
INSERT INTO `bills` VALUES ('7228', '8', '171', '555', '109050', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130775');
INSERT INTO `bills` VALUES ('7229', '8', '171', '555', '109000', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130775');
INSERT INTO `bills` VALUES ('7230', '8', '171', '555', '108950', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130776');
INSERT INTO `bills` VALUES ('7231', '8', '171', '555', '108900', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130776');
INSERT INTO `bills` VALUES ('7232', '8', '171', '555', '108850', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130777');
INSERT INTO `bills` VALUES ('7233', '8', '171', '555', '108800', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130777');
INSERT INTO `bills` VALUES ('7234', '8', '171', '555', '108750', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130777');
INSERT INTO `bills` VALUES ('7235', '8', '171', '555', '108700', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130778');
INSERT INTO `bills` VALUES ('7236', '8', '171', '555', '108650', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130778');
INSERT INTO `bills` VALUES ('7237', '8', '171', '555', '108600', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130779');
INSERT INTO `bills` VALUES ('7238', '8', '171', '555', '108550', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130779');
INSERT INTO `bills` VALUES ('7239', '8', '171', '555', '108500', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130779');
INSERT INTO `bills` VALUES ('7240', '8', '171', '555', '108450', '-50', '21', '8', '', '', 'BenzBmw下注', '1615130780');
INSERT INTO `bills` VALUES ('7241', '8', '171', '555', '108950', '500', '24', '0', '', '', 'Benz BMW Issue75364', '1615130786');
INSERT INTO `bills` VALUES ('7242', '12', '8', 'ssjj', '6800', '-100', '20', '12', '', '', '红绿球下注', '1615131108');
INSERT INTO `bills` VALUES ('7243', '12', '8', 'ssjj', '6700', '-100', '20', '12', '', '', '红绿球下注', '1615131274');
INSERT INTO `bills` VALUES ('7244', '12', '8', 'ssjj', '5700', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615131658');
INSERT INTO `bills` VALUES ('7245', '12', '8', 'ssjj', '4700', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615131658');
INSERT INTO `bills` VALUES ('7246', '12', '8', 'ssjj', '4598', '-102', '22', '12', '', '', '一元购下注', '1615131747');
INSERT INTO `bills` VALUES ('7247', '12', '8', 'ssjj', '4475', '-123', '22', '12', '', '', '一元购下注', '1615131768');
INSERT INTO `bills` VALUES ('7248', '8', '171', '555', '108949', '-1', '22', '8', '', '', '一元购下注', '1615131881');
INSERT INTO `bills` VALUES ('7249', '12', '8', 'ssjj', '3975', '-500', '21', '12', '', '', 'BenzBmw下注', '1615132019');
INSERT INTO `bills` VALUES ('7250', '12', '8', 'ssjj', '3475', '-500', '21', '12', '', '', 'BenzBmw下注', '1615132021');
INSERT INTO `bills` VALUES ('7251', '12', '8', 'ssjj', '3460', '-15', '22', '12', '', '', '一元购下注', '1615132153');
INSERT INTO `bills` VALUES ('7252', '12', '8', 'ssjj', '3439', '-21', '22', '12', '', '', '一元购下注', '1615132223');
INSERT INTO `bills` VALUES ('7253', '12', '8', 'ssjj', '3418', '-21', '22', '12', '', '', '一元购下注', '1615132225');
INSERT INTO `bills` VALUES ('7254', '12', '8', 'ssjj', '3383', '-35', '22', '12', '', '', '一元购下注', '1615132233');
INSERT INTO `bills` VALUES ('7255', '11', '8', 'Mozi2019', '5630', '-200', '22', '11', '', '', '一元购下注', '1615132262');
INSERT INTO `bills` VALUES ('7256', '12', '8', 'ssjj', '2383', '-1000', '22', '12', '', '', '一元购下注', '1615132267');
INSERT INTO `bills` VALUES ('7257', '12', '8', 'ssjj', '2283', '-100', '20', '12', '', '', '红绿球下注', '1615132323');
INSERT INTO `bills` VALUES ('7258', '8', '171', '555', '108944', '-5', '22', '8', '', '', '一元购下注', '1615135642');
INSERT INTO `bills` VALUES ('7259', '8', '171', '555', '108939', '-5', '22', '8', '', '', '一元购下注', '1615135643');
INSERT INTO `bills` VALUES ('7260', '8', '171', '555', '108934', '-5', '22', '8', '', '', '一元购下注', '1615135644');
INSERT INTO `bills` VALUES ('7261', '8', '171', '555', '108929', '-5', '22', '8', '', '', '一元购下注', '1615135644');
INSERT INTO `bills` VALUES ('7262', '8', '171', '555', '108924', '-5', '22', '8', '', '', '一元购下注', '1615135645');
INSERT INTO `bills` VALUES ('7263', '8', '171', '555', '108919', '-5', '22', '8', '', '', '一元购下注', '1615135645');
INSERT INTO `bills` VALUES ('7264', '8', '171', '555', '108914', '-5', '22', '8', '', '', '一元购下注', '1615135646');
INSERT INTO `bills` VALUES ('7265', '8', '171', '555', '108909', '-5', '22', '8', '', '', '一元购下注', '1615135646');
INSERT INTO `bills` VALUES ('7266', '8', '171', '555', '108904', '-5', '22', '8', '', '', '一元购下注', '1615135646');
INSERT INTO `bills` VALUES ('7267', '8', '171', '555', '108899', '-5', '22', '8', '', '', '一元购下注', '1615135646');
INSERT INTO `bills` VALUES ('7268', '8', '171', '555', '108894', '-5', '22', '8', '', '', '一元购下注', '1615135647');
INSERT INTO `bills` VALUES ('7269', '8', '171', '555', '108889', '-5', '22', '8', '', '', '一元购下注', '1615135647');
INSERT INTO `bills` VALUES ('7270', '8', '171', '555', '108884', '-5', '22', '8', '', '', '一元购下注', '1615135648');
INSERT INTO `bills` VALUES ('7271', '8', '171', '555', '108879', '-5', '22', '8', '', '', '一元购下注', '1615135648');
INSERT INTO `bills` VALUES ('7272', '8', '171', '555', '108873', '-6', '22', '8', '', '', '一元购下注', '1615135649');
INSERT INTO `bills` VALUES ('7273', '8', '171', '555', '108867', '-6', '22', '8', '', '', '一元购下注', '1615135649');
INSERT INTO `bills` VALUES ('7274', '8', '171', '555', '108861', '-6', '22', '8', '', '', '一元购下注', '1615135649');
INSERT INTO `bills` VALUES ('7275', '10', '171', 'daxiong', '952480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135901');
INSERT INTO `bills` VALUES ('7276', '10', '171', 'daxiong', '951480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135901');
INSERT INTO `bills` VALUES ('7277', '10', '171', 'daxiong', '950480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135901');
INSERT INTO `bills` VALUES ('7278', '10', '171', 'daxiong', '949480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7279', '10', '171', 'daxiong', '948480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7280', '10', '171', 'daxiong', '947480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7281', '10', '171', 'daxiong', '946480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7282', '10', '171', 'daxiong', '945480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7283', '10', '171', 'daxiong', '944480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7284', '10', '171', 'daxiong', '943480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135902');
INSERT INTO `bills` VALUES ('7285', '10', '171', 'daxiong', '942480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135903');
INSERT INTO `bills` VALUES ('7286', '10', '171', 'daxiong', '941480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135903');
INSERT INTO `bills` VALUES ('7287', '10', '171', 'daxiong', '940480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135903');
INSERT INTO `bills` VALUES ('7288', '10', '171', 'daxiong', '939480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135903');
INSERT INTO `bills` VALUES ('7289', '10', '171', 'daxiong', '938480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135904');
INSERT INTO `bills` VALUES ('7290', '10', '171', 'daxiong', '937480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135904');
INSERT INTO `bills` VALUES ('7291', '10', '171', 'daxiong', '936480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135904');
INSERT INTO `bills` VALUES ('7292', '10', '171', 'daxiong', '935480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135904');
INSERT INTO `bills` VALUES ('7293', '10', '171', 'daxiong', '934480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135905');
INSERT INTO `bills` VALUES ('7294', '10', '171', 'daxiong', '933480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135905');
INSERT INTO `bills` VALUES ('7295', '10', '171', 'daxiong', '932480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135905');
INSERT INTO `bills` VALUES ('7296', '10', '171', 'daxiong', '931480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135905');
INSERT INTO `bills` VALUES ('7297', '10', '171', 'daxiong', '930480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135906');
INSERT INTO `bills` VALUES ('7298', '10', '171', 'daxiong', '929480', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615135906');
INSERT INTO `bills` VALUES ('7299', '8', '171', '555', '108851', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135936');
INSERT INTO `bills` VALUES ('7300', '8', '171', '555', '108841', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135936');
INSERT INTO `bills` VALUES ('7301', '8', '171', '555', '108831', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135936');
INSERT INTO `bills` VALUES ('7302', '8', '171', '555', '108821', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135937');
INSERT INTO `bills` VALUES ('7303', '8', '171', '555', '108811', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135937');
INSERT INTO `bills` VALUES ('7304', '8', '171', '555', '108801', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135937');
INSERT INTO `bills` VALUES ('7305', '8', '171', '555', '108791', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135938');
INSERT INTO `bills` VALUES ('7306', '8', '171', '555', '108781', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135938');
INSERT INTO `bills` VALUES ('7307', '8', '171', '555', '108771', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135938');
INSERT INTO `bills` VALUES ('7308', '8', '171', '555', '108761', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135939');
INSERT INTO `bills` VALUES ('7309', '10', '171', 'daxiong', '928980', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135939');
INSERT INTO `bills` VALUES ('7310', '8', '171', '555', '108751', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135939');
INSERT INTO `bills` VALUES ('7311', '8', '171', '555', '108741', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135939');
INSERT INTO `bills` VALUES ('7312', '8', '171', '555', '108731', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135939');
INSERT INTO `bills` VALUES ('7313', '10', '171', 'daxiong', '928480', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7314', '10', '171', 'daxiong', '927980', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7315', '8', '171', '555', '108721', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7316', '10', '171', 'daxiong', '927480', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7317', '10', '171', 'daxiong', '926980', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7318', '10', '171', 'daxiong', '926480', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7319', '8', '171', '555', '108711', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135940');
INSERT INTO `bills` VALUES ('7320', '8', '171', '555', '108701', '-10', '21', '8', '', '', 'BenzBmw下注', '1615135941');
INSERT INTO `bills` VALUES ('7321', '10', '171', 'daxiong', '925980', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135941');
INSERT INTO `bills` VALUES ('7322', '10', '171', 'daxiong', '925480', '-500', '21', '10', '', '', 'BenzBmw下注', '1615135941');
INSERT INTO `bills` VALUES ('7323', '8', '171', '555', '108751', '50', '24', '0', '', '', 'Benz BMW Issue80527', '1615135949');
INSERT INTO `bills` VALUES ('7324', '10', '171', 'daxiong', '927980', '2500', '24', '0', '', '', 'Benz BMW Issue80527', '1615135949');
INSERT INTO `bills` VALUES ('7325', '8', '171', '555', '107751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135975');
INSERT INTO `bills` VALUES ('7326', '8', '171', '555', '106751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135975');
INSERT INTO `bills` VALUES ('7327', '8', '171', '555', '105751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135975');
INSERT INTO `bills` VALUES ('7328', '8', '171', '555', '104751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135975');
INSERT INTO `bills` VALUES ('7329', '8', '171', '555', '103751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135975');
INSERT INTO `bills` VALUES ('7330', '8', '171', '555', '102751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135976');
INSERT INTO `bills` VALUES ('7331', '8', '171', '555', '101751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135976');
INSERT INTO `bills` VALUES ('7332', '8', '171', '555', '100751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135976');
INSERT INTO `bills` VALUES ('7333', '8', '171', '555', '99751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135976');
INSERT INTO `bills` VALUES ('7334', '8', '171', '555', '98751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135977');
INSERT INTO `bills` VALUES ('7335', '8', '171', '555', '97751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135977');
INSERT INTO `bills` VALUES ('7336', '8', '171', '555', '96751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135977');
INSERT INTO `bills` VALUES ('7337', '8', '171', '555', '95751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135978');
INSERT INTO `bills` VALUES ('7338', '8', '171', '555', '94751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135979');
INSERT INTO `bills` VALUES ('7339', '8', '171', '555', '93751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135979');
INSERT INTO `bills` VALUES ('7340', '8', '171', '555', '92751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135979');
INSERT INTO `bills` VALUES ('7341', '8', '171', '555', '91751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615135980');
INSERT INTO `bills` VALUES ('7342', '8', '171', '555', '101751', '10000', '24', '0', '', '', 'Benz BMW Issue80567', '1615135989');
INSERT INTO `bills` VALUES ('7343', '8', '171', '555', '100751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136022');
INSERT INTO `bills` VALUES ('7344', '8', '171', '555', '99751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136022');
INSERT INTO `bills` VALUES ('7345', '8', '171', '555', '98751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7346', '8', '171', '555', '97751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7347', '8', '171', '555', '96751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7348', '8', '171', '555', '95751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7349', '8', '171', '555', '94751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7350', '8', '171', '555', '93751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136023');
INSERT INTO `bills` VALUES ('7351', '8', '171', '555', '92751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136024');
INSERT INTO `bills` VALUES ('7352', '8', '171', '555', '91751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136024');
INSERT INTO `bills` VALUES ('7353', '8', '171', '555', '90751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136025');
INSERT INTO `bills` VALUES ('7354', '8', '171', '555', '89751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136025');
INSERT INTO `bills` VALUES ('7355', '8', '171', '555', '88751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136025');
INSERT INTO `bills` VALUES ('7356', '8', '171', '555', '87751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136025');
INSERT INTO `bills` VALUES ('7357', '8', '171', '555', '86751', '-1000', '21', '8', '', '', 'BenzBmw下注', '1615136025');
INSERT INTO `bills` VALUES ('7358', '8', '171', '555', '91751', '5000', '24', '0', '', '', 'Benz BMW Issue80607', '1615136029');
INSERT INTO `bills` VALUES ('7359', '10', '171', 'daxiong', '926980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136057');
INSERT INTO `bills` VALUES ('7360', '10', '171', 'daxiong', '925980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136058');
INSERT INTO `bills` VALUES ('7361', '10', '171', 'daxiong', '924980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136059');
INSERT INTO `bills` VALUES ('7362', '10', '171', 'daxiong', '923980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136060');
INSERT INTO `bills` VALUES ('7363', '10', '171', 'daxiong', '922980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136060');
INSERT INTO `bills` VALUES ('7364', '10', '171', 'daxiong', '921980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136061');
INSERT INTO `bills` VALUES ('7365', '10', '171', 'daxiong', '920980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136061');
INSERT INTO `bills` VALUES ('7366', '10', '171', 'daxiong', '919980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136061');
INSERT INTO `bills` VALUES ('7367', '10', '171', 'daxiong', '918980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136061');
INSERT INTO `bills` VALUES ('7368', '10', '171', 'daxiong', '917980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136062');
INSERT INTO `bills` VALUES ('7369', '8', '171', '555', '91741', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136062');
INSERT INTO `bills` VALUES ('7370', '10', '171', 'daxiong', '916980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7371', '8', '171', '555', '91731', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7372', '10', '171', 'daxiong', '915980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7373', '10', '171', 'daxiong', '914980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7374', '8', '171', '555', '91721', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7375', '8', '171', '555', '91711', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7376', '10', '171', 'daxiong', '913980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136063');
INSERT INTO `bills` VALUES ('7377', '8', '171', '555', '91701', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7378', '10', '171', 'daxiong', '912980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7379', '8', '171', '555', '91691', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7380', '8', '171', '555', '91681', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7381', '10', '171', 'daxiong', '911980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7382', '10', '171', 'daxiong', '910980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136064');
INSERT INTO `bills` VALUES ('7383', '10', '171', 'daxiong', '909980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136065');
INSERT INTO `bills` VALUES ('7384', '10', '171', 'daxiong', '908980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136065');
INSERT INTO `bills` VALUES ('7385', '10', '171', 'daxiong', '907980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136065');
INSERT INTO `bills` VALUES ('7386', '10', '171', 'daxiong', '906980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136066');
INSERT INTO `bills` VALUES ('7387', '10', '171', 'daxiong', '905980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136066');
INSERT INTO `bills` VALUES ('7388', '10', '171', 'daxiong', '904980', '-1000', '21', '10', '', '', 'BenzBmw下注', '1615136066');
INSERT INTO `bills` VALUES ('7389', '8', '171', '555', '91671', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136066');
INSERT INTO `bills` VALUES ('7390', '8', '171', '555', '91661', '-10', '21', '8', '', '', 'BenzBmw下注', '1615136066');
INSERT INTO `bills` VALUES ('7391', '8', '171', '555', '91811', '150', '24', '0', '', '', 'Benz BMW Issue80647', '1615136069');
INSERT INTO `bills` VALUES ('7392', '10', '171', 'daxiong', '914980', '10000', '24', '0', '', '', 'Benz BMW Issue80647', '1615136069');
INSERT INTO `bills` VALUES ('7393', '10', '171', 'daxiong', '914968', '-12', '22', '10', '', '', '一元购下注', '1615136119');
INSERT INTO `bills` VALUES ('7394', '14', '8', 'lzknw', '9000', '-1000', '21', '14', '', '', 'BenzBmw下注', '1615169374');
INSERT INTO `bills` VALUES ('7395', '14', '8', 'lzknw', '8000', '-1000', '21', '14', '', '', 'BenzBmw下注', '1615169381');
INSERT INTO `bills` VALUES ('7396', '14', '8', 'lzknw', '7000', '-1000', '21', '14', '', '', 'BenzBmw下注', '1615169413');
INSERT INTO `bills` VALUES ('7397', '14', '8', 'lzknw', '6800', '-200', '21', '14', '', '', 'BenzBmw下注', '1615169416');
INSERT INTO `bills` VALUES ('7398', '14', '8', 'lzknw', '6600', '-200', '21', '14', '', '', 'BenzBmw下注', '1615169418');
INSERT INTO `bills` VALUES ('7399', '14', '8', 'lzknw', '6500', '-100', '21', '14', '', '', 'BenzBmw下注', '1615169420');
INSERT INTO `bills` VALUES ('7400', '14', '8', 'lzknw', '6400', '-100', '21', '14', '', '', 'BenzBmw下注', '1615169422');
INSERT INTO `bills` VALUES ('7401', '14', '8', 'lzknw', '6300', '-100', '20', '14', '', '', '红绿球下注', '1615169584');
INSERT INTO `bills` VALUES ('7402', '14', '8', 'lzknw', '6200', '-100', '20', '14', '', '', '红绿球下注', '1615169633');
INSERT INTO `bills` VALUES ('7403', '14', '8', 'lzknw', '6100', '-100', '20', '14', '', '', '红绿球下注', '1615169636');
INSERT INTO `bills` VALUES ('7404', '14', '8', 'lzknw', '6000', '-100', '20', '14', '', '', '红绿球下注', '1615169916');
INSERT INTO `bills` VALUES ('7405', '14', '8', 'lzknw', '5900', '-100', '20', '14', '', '', '红绿球下注', '1615169920');
INSERT INTO `bills` VALUES ('7406', '14', '8', 'lzknw', '5800', '-100', '20', '14', '', '', '红绿球下注', '1615169943');
INSERT INTO `bills` VALUES ('7407', '14', '8', 'lzknw', '5790', '-10', '20', '14', '', '', '红绿球下注', '1615170457');
INSERT INTO `bills` VALUES ('7408', '14', '8', 'lzknw', '4790', '-1000', '20', '14', '', '', '红绿球下注', '1615170468');
INSERT INTO `bills` VALUES ('7409', '14', '8', 'lzknw', '4780', '-10', '20', '14', '', '', '红绿球下注', '1615170473');
INSERT INTO `bills` VALUES ('7410', '14', '8', 'lzknw', '4680', '-100', '20', '14', '', '', '红绿球下注', '1615172511');
INSERT INTO `bills` VALUES ('7411', '14', '8', 'lzknw', '4580', '-100', '20', '14', '', '', '红绿球下注', '1615172513');
INSERT INTO `bills` VALUES ('7412', '14', '8', 'lzknw', '4480', '-100', '20', '14', '', '', '红绿球下注', '1615172515');
INSERT INTO `bills` VALUES ('7413', '14', '8', 'lzknw', '4470', '-10', '21', '14', '', '', 'BenzBmw下注', '1615172576');
INSERT INTO `bills` VALUES ('7414', '14', '8', 'lzknw', '4420', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172578');
INSERT INTO `bills` VALUES ('7415', '14', '8', 'lzknw', '4320', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172580');
INSERT INTO `bills` VALUES ('7416', '14', '8', 'lzknw', '4120', '-200', '21', '14', '', '', 'BenzBmw下注', '1615172582');
INSERT INTO `bills` VALUES ('7417', '14', '8', 'lzknw', '3620', '-500', '21', '14', '', '', 'BenzBmw下注', '1615172584');
INSERT INTO `bills` VALUES ('7418', '14', '8', 'lzknw', '3120', '-500', '21', '14', '', '', 'BenzBmw下注', '1615172613');
INSERT INTO `bills` VALUES ('7419', '14', '8', 'lzknw', '3020', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172615');
INSERT INTO `bills` VALUES ('7420', '14', '8', 'lzknw', '2920', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172617');
INSERT INTO `bills` VALUES ('7421', '14', '8', 'lzknw', '2870', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172618');
INSERT INTO `bills` VALUES ('7422', '14', '8', 'lzknw', '2820', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172619');
INSERT INTO `bills` VALUES ('7423', '14', '8', 'lzknw', '2720', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172620');
INSERT INTO `bills` VALUES ('7424', '14', '8', 'lzknw', '2670', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172624');
INSERT INTO `bills` VALUES ('7425', '14', '8', 'lzknw', '2620', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172655');
INSERT INTO `bills` VALUES ('7426', '14', '8', 'lzknw', '2520', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172658');
INSERT INTO `bills` VALUES ('7427', '14', '8', 'lzknw', '2420', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172662');
INSERT INTO `bills` VALUES ('7428', '14', '8', 'lzknw', '2370', '-50', '21', '14', '', '', 'BenzBmw下注', '1615172663');
INSERT INTO `bills` VALUES ('7429', '14', '8', 'lzknw', '2270', '-100', '21', '14', '', '', 'BenzBmw下注', '1615172665');
INSERT INTO `bills` VALUES ('7430', '11', '8', 'Mozi2019', '5530', '-100', '20', '11', '', '', '红绿球下注', '1615173423');
INSERT INTO `bills` VALUES ('7431', '11', '8', 'Mozi2019', '5430', '-100', '20', '11', '', '', '红绿球下注', '1615173427');
INSERT INTO `bills` VALUES ('7432', '11', '8', 'Mozi2019', '5330', '-100', '20', '11', '', '', '红绿球下注', '1615175215');
INSERT INTO `bills` VALUES ('7433', '11', '8', 'Mozi2019', '5230', '-100', '20', '11', '', '', '红绿球下注', '1615175219');
INSERT INTO `bills` VALUES ('7434', '12', '8', 'ssjj', '1283', '-1000', '21', '12', '', '', 'BenzBmw下注', '1615177177');
INSERT INTO `bills` VALUES ('7435', '12', '8', 'ssjj', '1273', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177221');
INSERT INTO `bills` VALUES ('7436', '12', '8', 'ssjj', '1263', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177221');
INSERT INTO `bills` VALUES ('7437', '12', '8', 'ssjj', '1253', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177222');
INSERT INTO `bills` VALUES ('7438', '12', '8', 'ssjj', '1243', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177222');
INSERT INTO `bills` VALUES ('7439', '12', '8', 'ssjj', '1233', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177222');
INSERT INTO `bills` VALUES ('7440', '12', '8', 'ssjj', '1223', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177223');
INSERT INTO `bills` VALUES ('7441', '12', '8', 'ssjj', '1213', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177223');
INSERT INTO `bills` VALUES ('7442', '12', '8', 'ssjj', '1203', '-10', '21', '12', '', '', 'BenzBmw下注', '1615177223');
INSERT INTO `bills` VALUES ('7443', '12', '8', 'ssjj', '1253', '50', '24', '0', '', '', 'Benz BMW Issue35407', '1615177229');
INSERT INTO `bills` VALUES ('7444', '12', '8', 'ssjj', '1153', '-100', '20', '12', '', '', '红绿球下注', '1615177263');
INSERT INTO `bills` VALUES ('7445', '12', '8', 'ssjj', '1148', '-5', '22', '12', '', '', '一元购下注', '1615177290');
INSERT INTO `bills` VALUES ('7446', '12', '8', 'ssjj', '1143', '-5', '22', '12', '', '', '一元购下注', '1615177295');
INSERT INTO `bills` VALUES ('7447', '12', '8', 'ssjj', '1138', '-5', '22', '12', '', '', '一元购下注', '1615177308');
INSERT INTO `bills` VALUES ('7448', '12', '8', 'ssjj', '1038', '-100', '22', '12', '', '', '一元购下注', '1615177315');
INSERT INTO `bills` VALUES ('7449', '12', '8', 'ssjj', '938', '-100', '22', '12', '', '', '一元购下注', '1615177356');
INSERT INTO `bills` VALUES ('7450', '6', '8', 'Aaron', '9990', '-10', '20', '6', '', '', '红绿球下注', '1615180912');
INSERT INTO `bills` VALUES ('7451', '4', '8', 'NehaSingh', '9990', '-10', '20', '4', '', '', '红绿球下注', '1615181445');
INSERT INTO `bills` VALUES ('7452', '3', '8', 'gains', '9990', '-10', '21', '3', '', '', 'BenzBmw下注', '1615182980');
INSERT INTO `bills` VALUES ('7453', '3', '8', 'gains', '9980', '-10', '21', '3', '', '', 'BenzBmw下注', '1615182980');
INSERT INTO `bills` VALUES ('7454', '3', '8', 'gains', '9970', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183017');
INSERT INTO `bills` VALUES ('7455', '3', '8', 'gains', '9960', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183018');
INSERT INTO `bills` VALUES ('7456', '3', '8', 'gains', '9950', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183059');
INSERT INTO `bills` VALUES ('7457', '3', '8', 'gains', '9940', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183065');
INSERT INTO `bills` VALUES ('7458', '10', '171', 'daxiong', '914868', '-100', '20', '10', '', '', '红绿球下注', '1615183104');
INSERT INTO `bills` VALUES ('7459', '10', '171', 'daxiong', '914768', '-100', '20', '10', '', '', '红绿球下注', '1615183137');
INSERT INTO `bills` VALUES ('7460', '10', '171', 'daxiong', '914668', '-100', '20', '10', '', '', '红绿球下注', '1615183142');
INSERT INTO `bills` VALUES ('7461', '10', '171', 'daxiong', '914568', '-100', '20', '10', '', '', '红绿球下注', '1615183145');
INSERT INTO `bills` VALUES ('7462', '10', '171', 'daxiong', '914468', '-100', '20', '10', '', '', '红绿球下注', '1615183148');
INSERT INTO `bills` VALUES ('7463', '10', '171', 'daxiong', '914368', '-100', '20', '10', '', '', '红绿球下注', '1615183150');
INSERT INTO `bills` VALUES ('7464', '10', '171', 'daxiong', '914268', '-100', '20', '10', '', '', '红绿球下注', '1615183153');
INSERT INTO `bills` VALUES ('7465', '10', '171', 'daxiong', '914168', '-100', '20', '10', '', '', '红绿球下注', '1615183155');
INSERT INTO `bills` VALUES ('7466', '10', '171', 'daxiong', '914068', '-100', '20', '10', '', '', '红绿球下注', '1615183158');
INSERT INTO `bills` VALUES ('7467', '10', '171', 'daxiong', '913968', '-100', '20', '10', '', '', '红绿球下注', '1615183160');
INSERT INTO `bills` VALUES ('7468', '10', '171', 'daxiong', '913868', '-100', '20', '10', '', '', '红绿球下注', '1615183162');
INSERT INTO `bills` VALUES ('7469', '10', '171', 'daxiong', '913768', '-100', '22', '10', '', '', '一元购下注', '1615183345');
INSERT INTO `bills` VALUES ('7470', '11', '8', 'Mozi2019', '5130', '-100', '20', '11', '', '', '红绿球下注', '1615183474');
INSERT INTO `bills` VALUES ('7471', '11', '8', 'Mozi2019', '5030', '-100', '20', '11', '', '', '红绿球下注', '1615183477');
INSERT INTO `bills` VALUES ('7472', '3', '8', 'gains', '9930', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183614');
INSERT INTO `bills` VALUES ('7473', '22', '8', '欧阳', '9993', '-7', '22', '22', '', '', '一元购下注', '1615183615');
INSERT INTO `bills` VALUES ('7474', '22', '8', '欧阳', '9986', '-7', '22', '22', '', '', '一元购下注', '1615183615');
INSERT INTO `bills` VALUES ('7475', '22', '8', '欧阳', '9979', '-7', '22', '22', '', '', '一元购下注', '1615183617');
INSERT INTO `bills` VALUES ('7476', '3', '8', 'gains', '9920', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183617');
INSERT INTO `bills` VALUES ('7477', '22', '8', '欧阳', '9972', '-7', '22', '22', '', '', '一元购下注', '1615183617');
INSERT INTO `bills` VALUES ('7478', '22', '8', '欧阳', '9965', '-7', '22', '22', '', '', '一元购下注', '1615183618');
INSERT INTO `bills` VALUES ('7479', '22', '8', '欧阳', '9865', '-100', '20', '22', '', '', '红绿球下注', '1615183654');
INSERT INTO `bills` VALUES ('7480', '3', '8', 'gains', '9910', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183654');
INSERT INTO `bills` VALUES ('7481', '3', '8', 'gains', '9900', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183655');
INSERT INTO `bills` VALUES ('7482', '22', '8', '欧阳', '9765', '-100', '20', '22', '', '', '红绿球下注', '1615183661');
INSERT INTO `bills` VALUES ('7483', '22', '8', '欧阳', '9665', '-100', '20', '22', '', '', '红绿球下注', '1615183677');
INSERT INTO `bills` VALUES ('7484', '22', '8', '欧阳', '9565', '-100', '20', '22', '', '', '红绿球下注', '1615183679');
INSERT INTO `bills` VALUES ('7485', '22', '8', '欧阳', '9465', '-100', '20', '22', '', '', '红绿球下注', '1615183681');
INSERT INTO `bills` VALUES ('7486', '22', '8', '欧阳', '9365', '-100', '20', '22', '', '', '红绿球下注', '1615183683');
INSERT INTO `bills` VALUES ('7487', '22', '8', '欧阳', '9265', '-100', '20', '22', '', '', '红绿球下注', '1615183686');
INSERT INTO `bills` VALUES ('7488', '4', '8', 'NehaSingh', '3990', '-6000', '20', '4', '', '', '红绿球下注', '1615183687');
INSERT INTO `bills` VALUES ('7489', '3', '8', 'gains', '9890', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183693');
INSERT INTO `bills` VALUES ('7490', '3', '8', 'gains', '9880', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183695');
INSERT INTO `bills` VALUES ('7491', '3', '8', 'gains', '9870', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183698');
INSERT INTO `bills` VALUES ('7492', '3', '8', 'gains', '9860', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183698');
INSERT INTO `bills` VALUES ('7493', '3', '8', 'gains', '9850', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183733');
INSERT INTO `bills` VALUES ('7494', '3', '8', 'gains', '9840', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183734');
INSERT INTO `bills` VALUES ('7495', '3', '8', 'gains', '9830', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183734');
INSERT INTO `bills` VALUES ('7496', '3', '8', 'gains', '9820', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183734');
INSERT INTO `bills` VALUES ('7497', '3', '8', 'gains', '9810', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183773');
INSERT INTO `bills` VALUES ('7498', '3', '8', 'gains', '9800', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183774');
INSERT INTO `bills` VALUES ('7499', '3', '8', 'gains', '9790', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183774');
INSERT INTO `bills` VALUES ('7500', '3', '8', 'gains', '9780', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183774');
INSERT INTO `bills` VALUES ('7501', '4', '8', 'NehaSingh', '990', '-3000', '20', '4', '', '', '红绿球下注', '1615183779');
INSERT INTO `bills` VALUES ('7502', '3', '8', 'gains', '9770', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183816');
INSERT INTO `bills` VALUES ('7503', '3', '8', 'gains', '9760', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183816');
INSERT INTO `bills` VALUES ('7504', '3', '8', 'gains', '9750', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183817');
INSERT INTO `bills` VALUES ('7505', '3', '8', 'gains', '9740', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183817');
INSERT INTO `bills` VALUES ('7506', '3', '8', 'gains', '9730', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183853');
INSERT INTO `bills` VALUES ('7507', '3', '8', 'gains', '9720', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183853');
INSERT INTO `bills` VALUES ('7508', '3', '8', 'gains', '9710', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183853');
INSERT INTO `bills` VALUES ('7509', '3', '8', 'gains', '9700', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183854');
INSERT INTO `bills` VALUES ('7510', '3', '8', 'gains', '9690', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183854');
INSERT INTO `bills` VALUES ('7511', '3', '8', 'gains', '9680', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183854');
INSERT INTO `bills` VALUES ('7512', '3', '8', 'gains', '9670', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183854');
INSERT INTO `bills` VALUES ('7513', '3', '8', 'gains', '9660', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183854');
INSERT INTO `bills` VALUES ('7514', '3', '8', 'gains', '9710', '50', '24', '0', '', '', 'Benz BMW Issue42047', '1615183869');
INSERT INTO `bills` VALUES ('7515', '3', '8', 'gains', '9700', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183893');
INSERT INTO `bills` VALUES ('7516', '3', '8', 'gains', '9690', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183894');
INSERT INTO `bills` VALUES ('7517', '3', '8', 'gains', '9680', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183894');
INSERT INTO `bills` VALUES ('7518', '3', '8', 'gains', '9670', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183895');
INSERT INTO `bills` VALUES ('7519', '3', '8', 'gains', '9660', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183895');
INSERT INTO `bills` VALUES ('7520', '22', '8', '欧阳', '9255', '-10', '21', '22', '', '', 'BenzBmw下注', '1615183904');
INSERT INTO `bills` VALUES ('7521', '22', '8', '欧阳', '9245', '-10', '21', '22', '', '', 'BenzBmw下注', '1615183904');
INSERT INTO `bills` VALUES ('7522', '22', '8', '欧阳', '9235', '-10', '21', '22', '', '', 'BenzBmw下注', '1615183905');
INSERT INTO `bills` VALUES ('7523', '22', '8', '欧阳', '9225', '-10', '21', '22', '', '', 'BenzBmw下注', '1615183905');
INSERT INTO `bills` VALUES ('7524', '2', '8', 'Tina', '110', '-10', '20', '2', '', '', '红绿球下注', '1615183922');
INSERT INTO `bills` VALUES ('7525', '2', '8', 'Tina', '100', '-10', '20', '2', '', '', '红绿球下注', '1615183923');
INSERT INTO `bills` VALUES ('7526', '4', '8', 'NehaSingh', '990', '0', '20', '4', '', '', '红绿球下注', '1615183933');
INSERT INTO `bills` VALUES ('7527', '3', '8', 'gains', '9650', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183933');
INSERT INTO `bills` VALUES ('7528', '3', '8', 'gains', '9640', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183934');
INSERT INTO `bills` VALUES ('7529', '3', '8', 'gains', '9630', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183934');
INSERT INTO `bills` VALUES ('7530', '3', '8', 'gains', '9620', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183935');
INSERT INTO `bills` VALUES ('7531', '4', '8', 'NehaSingh', '890', '-100', '20', '4', '', '', '红绿球下注', '1615183943');
INSERT INTO `bills` VALUES ('7532', '3', '8', 'gains', '9610', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183976');
INSERT INTO `bills` VALUES ('7533', '3', '8', 'gains', '9600', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183976');
INSERT INTO `bills` VALUES ('7534', '3', '8', 'gains', '9590', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183977');
INSERT INTO `bills` VALUES ('7535', '3', '8', 'gains', '9580', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183977');
INSERT INTO `bills` VALUES ('7536', '3', '8', 'gains', '9570', '-10', '21', '3', '', '', 'BenzBmw下注', '1615183977');
INSERT INTO `bills` VALUES ('7537', '7', '8', 'crystal', '9900', '-100', '20', '7', '', '', '红绿球下注', '1615184030');
INSERT INTO `bills` VALUES ('7538', '3', '8', 'gains', '9560', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184053');
INSERT INTO `bills` VALUES ('7539', '3', '8', 'gains', '9550', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184053');
INSERT INTO `bills` VALUES ('7540', '3', '8', 'gains', '9540', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184053');
INSERT INTO `bills` VALUES ('7541', '3', '8', 'gains', '9530', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184053');
INSERT INTO `bills` VALUES ('7542', '3', '8', 'gains', '9520', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184054');
INSERT INTO `bills` VALUES ('7543', '23', '8', 'jj', '9000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184054');
INSERT INTO `bills` VALUES ('7544', '23', '8', 'jj', '8000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184055');
INSERT INTO `bills` VALUES ('7545', '23', '8', 'jj', '7000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184057');
INSERT INTO `bills` VALUES ('7546', '23', '8', 'jj', '6000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184059');
INSERT INTO `bills` VALUES ('7547', '23', '8', 'jj', '5000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184060');
INSERT INTO `bills` VALUES ('7548', '23', '8', 'jj', '4000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184063');
INSERT INTO `bills` VALUES ('7549', '23', '8', 'jj', '3000', '-1000', '21', '23', '', '', 'BenzBmw下注', '1615184063');
INSERT INTO `bills` VALUES ('7550', '3', '8', 'gains', '9510', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184092');
INSERT INTO `bills` VALUES ('7551', '3', '8', 'gains', '9500', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184092');
INSERT INTO `bills` VALUES ('7552', '3', '8', 'gains', '9490', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184092');
INSERT INTO `bills` VALUES ('7553', '3', '8', 'gains', '9480', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184092');
INSERT INTO `bills` VALUES ('7554', '3', '8', 'gains', '9470', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184093');
INSERT INTO `bills` VALUES ('7555', '3', '8', 'gains', '9460', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184144');
INSERT INTO `bills` VALUES ('7556', '3', '8', 'gains', '9450', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184145');
INSERT INTO `bills` VALUES ('7557', '3', '8', 'gains', '9440', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184145');
INSERT INTO `bills` VALUES ('7558', '3', '8', 'gains', '9430', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184146');
INSERT INTO `bills` VALUES ('7559', '3', '8', 'gains', '9420', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184146');
INSERT INTO `bills` VALUES ('7560', '5', '169', 'tuned', '9990', '-10', '20', '5', '', '', '红绿球下注', '1615184163');
INSERT INTO `bills` VALUES ('7561', '3', '8', 'gains', '9410', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184173');
INSERT INTO `bills` VALUES ('7562', '3', '8', 'gains', '9400', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184173');
INSERT INTO `bills` VALUES ('7563', '3', '8', 'gains', '9390', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184173');
INSERT INTO `bills` VALUES ('7564', '3', '8', 'gains', '9380', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184173');
INSERT INTO `bills` VALUES ('7565', '3', '8', 'gains', '9370', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184174');
INSERT INTO `bills` VALUES ('7566', '3', '8', 'gains', '9360', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184214');
INSERT INTO `bills` VALUES ('7567', '3', '8', 'gains', '9350', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184215');
INSERT INTO `bills` VALUES ('7568', '3', '8', 'gains', '9340', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184215');
INSERT INTO `bills` VALUES ('7569', '3', '8', 'gains', '9330', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184215');
INSERT INTO `bills` VALUES ('7570', '3', '8', 'gains', '9320', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184336');
INSERT INTO `bills` VALUES ('7571', '3', '8', 'gains', '9310', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184336');
INSERT INTO `bills` VALUES ('7572', '3', '8', 'gains', '9300', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184336');
INSERT INTO `bills` VALUES ('7573', '3', '8', 'gains', '9290', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184336');
INSERT INTO `bills` VALUES ('7574', '5', '169', 'tuned', '9890', '-100', '20', '5', '', '', '红绿球下注', '1615184356');
INSERT INTO `bills` VALUES ('7575', '3', '8', 'gains', '9280', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184378');
INSERT INTO `bills` VALUES ('7576', '3', '8', 'gains', '9270', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184379');
INSERT INTO `bills` VALUES ('7577', '3', '8', 'gains', '9260', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184379');
INSERT INTO `bills` VALUES ('7578', '3', '8', 'gains', '9250', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184379');
INSERT INTO `bills` VALUES ('7579', '3', '8', 'gains', '9240', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184459');
INSERT INTO `bills` VALUES ('7580', '3', '8', 'gains', '9230', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184460');
INSERT INTO `bills` VALUES ('7581', '3', '8', 'gains', '9220', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184460');
INSERT INTO `bills` VALUES ('7582', '3', '8', 'gains', '9210', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184460');
INSERT INTO `bills` VALUES ('7583', '3', '8', 'gains', '9200', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184461');
INSERT INTO `bills` VALUES ('7584', '3', '8', 'gains', '9190', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184461');
INSERT INTO `bills` VALUES ('7585', '3', '8', 'gains', '9180', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184461');
INSERT INTO `bills` VALUES ('7586', '23', '8', 'jj', '2990', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184504');
INSERT INTO `bills` VALUES ('7587', '23', '8', 'jj', '2980', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184505');
INSERT INTO `bills` VALUES ('7588', '23', '8', 'jj', '2970', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184505');
INSERT INTO `bills` VALUES ('7589', '23', '8', 'jj', '2960', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184505');
INSERT INTO `bills` VALUES ('7590', '23', '8', 'jj', '2950', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184505');
INSERT INTO `bills` VALUES ('7591', '23', '8', 'jj', '2940', '-10', '21', '23', '', '', 'BenzBmw下注', '1615184505');
INSERT INTO `bills` VALUES ('7592', '23', '8', 'jj', '2840', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184584');
INSERT INTO `bills` VALUES ('7593', '12', '8', 'ssjj', '928', '-10', '20', '12', '', '', '红绿球下注', '1615184593');
INSERT INTO `bills` VALUES ('7594', '12', '8', 'ssjj', '918', '-10', '20', '12', '', '', '红绿球下注', '1615184598');
INSERT INTO `bills` VALUES ('7595', '23', '8', 'jj', '2740', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184618');
INSERT INTO `bills` VALUES ('7596', '23', '8', 'jj', '2640', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184619');
INSERT INTO `bills` VALUES ('7597', '23', '8', 'jj', '2540', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184621');
INSERT INTO `bills` VALUES ('7598', '23', '8', 'jj', '2440', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184621');
INSERT INTO `bills` VALUES ('7599', '23', '8', 'jj', '2340', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184622');
INSERT INTO `bills` VALUES ('7600', '23', '8', 'jj', '2240', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184623');
INSERT INTO `bills` VALUES ('7601', '23', '8', 'jj', '2140', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184625');
INSERT INTO `bills` VALUES ('7602', '23', '8', 'jj', '2040', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184625');
INSERT INTO `bills` VALUES ('7603', '23', '8', 'jj', '1940', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184626');
INSERT INTO `bills` VALUES ('7604', '23', '8', 'jj', '1740', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184654');
INSERT INTO `bills` VALUES ('7605', '23', '8', 'jj', '1540', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184655');
INSERT INTO `bills` VALUES ('7606', '23', '8', 'jj', '1340', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184656');
INSERT INTO `bills` VALUES ('7607', '23', '8', 'jj', '1140', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184657');
INSERT INTO `bills` VALUES ('7608', '23', '8', 'jj', '940', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184662');
INSERT INTO `bills` VALUES ('7609', '23', '8', 'jj', '740', '-200', '21', '23', '', '', 'BenzBmw下注', '1615184663');
INSERT INTO `bills` VALUES ('7610', '23', '8', 'jj', '730', '-10', '20', '23', '', '', '红绿球下注', '1615184712');
INSERT INTO `bills` VALUES ('7611', '12', '8', 'ssjj', '908', '-10', '20', '12', '', '', '红绿球下注', '1615184720');
INSERT INTO `bills` VALUES ('7612', '12', '8', 'ssjj', '898', '-10', '20', '12', '', '', '红绿球下注', '1615184723');
INSERT INTO `bills` VALUES ('7613', '23', '8', 'jj', '720', '-10', '20', '23', '', '', '红绿球下注', '1615184737');
INSERT INTO `bills` VALUES ('7614', '23', '8', 'jj', '710', '-10', '20', '23', '', '', '红绿球下注', '1615184827');
INSERT INTO `bills` VALUES ('7615', '5', '169', 'tuned', '9690', '-200', '20', '5', '', '', '红绿球下注', '1615184869');
INSERT INTO `bills` VALUES ('7616', '5', '169', 'tuned', '9590', '-100', '20', '5', '', '', '红绿球下注', '1615184891');
INSERT INTO `bills` VALUES ('7617', '24', '169', 'anna', '9800', '-200', '21', '24', '', '', 'BenzBmw下注', '1615184894');
INSERT INTO `bills` VALUES ('7618', '2', '8', 'Tina', '0', '-100', '20', '2', '', '', '红绿球下注', '1615184902');
INSERT INTO `bills` VALUES ('7619', '24', '169', 'anna', '9700', '-100', '21', '24', '', '', 'BenzBmw下注', '1615184904');
INSERT INTO `bills` VALUES ('7620', '22', '8', '欧阳', '9175', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184933');
INSERT INTO `bills` VALUES ('7621', '22', '8', '欧阳', '9125', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184934');
INSERT INTO `bills` VALUES ('7622', '22', '8', '欧阳', '9075', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184934');
INSERT INTO `bills` VALUES ('7623', '22', '8', '欧阳', '9025', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184935');
INSERT INTO `bills` VALUES ('7624', '23', '8', 'jj', '610', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184935');
INSERT INTO `bills` VALUES ('7625', '22', '8', '欧阳', '8975', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184936');
INSERT INTO `bills` VALUES ('7626', '22', '8', '欧阳', '8925', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184936');
INSERT INTO `bills` VALUES ('7627', '23', '8', 'jj', '510', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184936');
INSERT INTO `bills` VALUES ('7628', '22', '8', '欧阳', '8875', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184937');
INSERT INTO `bills` VALUES ('7629', '22', '8', '欧阳', '8825', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184937');
INSERT INTO `bills` VALUES ('7630', '23', '8', 'jj', '410', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184937');
INSERT INTO `bills` VALUES ('7631', '23', '8', 'jj', '310', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184938');
INSERT INTO `bills` VALUES ('7632', '7', '8', 'crystal', '9850', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184941');
INSERT INTO `bills` VALUES ('7633', '23', '8', 'jj', '210', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184941');
INSERT INTO `bills` VALUES ('7634', '23', '8', 'jj', '110', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184942');
INSERT INTO `bills` VALUES ('7635', '7', '8', 'crystal', '9800', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184942');
INSERT INTO `bills` VALUES ('7636', '7', '8', 'crystal', '9750', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184943');
INSERT INTO `bills` VALUES ('7637', '23', '8', 'jj', '10', '-100', '21', '23', '', '', 'BenzBmw下注', '1615184943');
INSERT INTO `bills` VALUES ('7638', '7', '8', 'crystal', '9700', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184943');
INSERT INTO `bills` VALUES ('7639', '7', '8', 'crystal', '9650', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184944');
INSERT INTO `bills` VALUES ('7640', '7', '8', 'crystal', '9600', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184944');
INSERT INTO `bills` VALUES ('7641', '7', '8', 'crystal', '9550', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184945');
INSERT INTO `bills` VALUES ('7642', '22', '8', '欧阳', '8775', '-50', '21', '22', '', '', 'BenzBmw下注', '1615184945');
INSERT INTO `bills` VALUES ('7643', '22', '8', '欧阳', '9025', '250', '24', '0', '', '', 'Benz BMW Issue43127', '1615184949');
INSERT INTO `bills` VALUES ('7644', '7', '8', 'crystal', '9800', '250', '24', '0', '', '', 'Benz BMW Issue43127', '1615184949');
INSERT INTO `bills` VALUES ('7645', '3', '8', 'gains', '9170', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184979');
INSERT INTO `bills` VALUES ('7646', '3', '8', 'gains', '9160', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7647', '3', '8', 'gains', '9150', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7648', '3', '8', 'gains', '9140', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7649', '3', '8', 'gains', '9130', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7650', '3', '8', 'gains', '9120', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7651', '3', '8', 'gains', '9110', '-10', '21', '3', '', '', 'BenzBmw下注', '1615184980');
INSERT INTO `bills` VALUES ('7652', '7', '8', 'crystal', '9750', '-50', '21', '7', '', '', 'BenzBmw下注', '1615184985');
INSERT INTO `bills` VALUES ('7653', '22', '8', '欧阳', '8975', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185013');
INSERT INTO `bills` VALUES ('7654', '22', '8', '欧阳', '8925', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185014');
INSERT INTO `bills` VALUES ('7655', '22', '8', '欧阳', '8875', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185014');
INSERT INTO `bills` VALUES ('7656', '22', '8', '欧阳', '8825', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185015');
INSERT INTO `bills` VALUES ('7657', '24', '169', 'anna', '9500', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185020');
INSERT INTO `bills` VALUES ('7658', '24', '169', 'anna', '9300', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185022');
INSERT INTO `bills` VALUES ('7659', '22', '8', '欧阳', '8775', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185022');
INSERT INTO `bills` VALUES ('7660', '24', '169', 'anna', '9100', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185022');
INSERT INTO `bills` VALUES ('7661', '24', '169', 'anna', '8900', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185022');
INSERT INTO `bills` VALUES ('7662', '22', '8', '欧阳', '8725', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185022');
INSERT INTO `bills` VALUES ('7663', '24', '169', 'anna', '8700', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7664', '22', '8', '欧阳', '8675', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7665', '24', '169', 'anna', '8500', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7666', '22', '8', '欧阳', '8625', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7667', '24', '169', 'anna', '8300', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7668', '24', '169', 'anna', '8100', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185023');
INSERT INTO `bills` VALUES ('7669', '24', '169', 'anna', '7900', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185024');
INSERT INTO `bills` VALUES ('7670', '24', '169', 'anna', '7700', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185024');
INSERT INTO `bills` VALUES ('7671', '24', '169', 'anna', '7500', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185024');
INSERT INTO `bills` VALUES ('7672', '24', '169', 'anna', '7300', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185024');
INSERT INTO `bills` VALUES ('7673', '24', '169', 'anna', '7100', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185025');
INSERT INTO `bills` VALUES ('7674', '24', '169', 'anna', '6900', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185056');
INSERT INTO `bills` VALUES ('7675', '24', '169', 'anna', '6700', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185057');
INSERT INTO `bills` VALUES ('7676', '24', '169', 'anna', '6500', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185059');
INSERT INTO `bills` VALUES ('7677', '24', '169', 'anna', '6300', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185059');
INSERT INTO `bills` VALUES ('7678', '24', '169', 'anna', '6100', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185062');
INSERT INTO `bills` VALUES ('7679', '24', '169', 'anna', '5900', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185062');
INSERT INTO `bills` VALUES ('7680', '24', '169', 'anna', '5700', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185063');
INSERT INTO `bills` VALUES ('7681', '5', '169', 'tuned', '9490', '-100', '20', '5', '', '', '红绿球下注', '1615185063');
INSERT INTO `bills` VALUES ('7682', '24', '169', 'anna', '5500', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185063');
INSERT INTO `bills` VALUES ('7683', '22', '8', '欧阳', '8575', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185064');
INSERT INTO `bills` VALUES ('7684', '22', '8', '欧阳', '8525', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185064');
INSERT INTO `bills` VALUES ('7685', '22', '8', '欧阳', '8475', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185065');
INSERT INTO `bills` VALUES ('7686', '24', '169', 'anna', '5300', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185065');
INSERT INTO `bills` VALUES ('7687', '24', '169', 'anna', '5100', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185065');
INSERT INTO `bills` VALUES ('7688', '24', '169', 'anna', '4900', '-200', '21', '24', '', '', 'BenzBmw下注', '1615185065');
INSERT INTO `bills` VALUES ('7689', '5', '169', 'tuned', '9390', '-100', '20', '5', '', '', '红绿球下注', '1615185069');
INSERT INTO `bills` VALUES ('7690', '5', '169', 'tuned', '9290', '-100', '20', '5', '', '', '红绿球下注', '1615185072');
INSERT INTO `bills` VALUES ('7691', '5', '169', 'tuned', '9190', '-100', '20', '5', '', '', '红绿球下注', '1615185074');
INSERT INTO `bills` VALUES ('7692', '22', '8', '欧阳', '8425', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185094');
INSERT INTO `bills` VALUES ('7693', '22', '8', '欧阳', '8375', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185096');
INSERT INTO `bills` VALUES ('7694', '22', '8', '欧阳', '8325', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185097');
INSERT INTO `bills` VALUES ('7695', '22', '8', '欧阳', '8275', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185099');
INSERT INTO `bills` VALUES ('7696', '22', '8', '欧阳', '8225', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185100');
INSERT INTO `bills` VALUES ('7697', '22', '8', '欧阳', '8175', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185101');
INSERT INTO `bills` VALUES ('7698', '22', '8', '欧阳', '8125', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185103');
INSERT INTO `bills` VALUES ('7699', '22', '8', '欧阳', '8075', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185104');
INSERT INTO `bills` VALUES ('7700', '22', '8', '欧阳', '8025', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185106');
INSERT INTO `bills` VALUES ('7701', '22', '8', '欧阳', '7975', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185106');
INSERT INTO `bills` VALUES ('7702', '24', '169', 'anna', '4800', '-100', '20', '24', '', '', '红绿球下注', '1615185112');
INSERT INTO `bills` VALUES ('7703', '22', '8', '欧阳', '7925', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185132');
INSERT INTO `bills` VALUES ('7704', '22', '8', '欧阳', '7875', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185133');
INSERT INTO `bills` VALUES ('7705', '22', '8', '欧阳', '7825', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185134');
INSERT INTO `bills` VALUES ('7706', '22', '8', '欧阳', '7775', '-50', '21', '22', '', '', 'BenzBmw下注', '1615185135');
INSERT INTO `bills` VALUES ('7707', '11', '8', 'Mozi2019', '4930', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185135');
INSERT INTO `bills` VALUES ('7708', '11', '8', 'Mozi2019', '4830', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185136');
INSERT INTO `bills` VALUES ('7709', '11', '8', 'Mozi2019', '4730', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185136');
INSERT INTO `bills` VALUES ('7710', '11', '8', 'Mozi2019', '4630', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185136');
INSERT INTO `bills` VALUES ('7711', '22', '8', '欧阳', '6775', '-1000', '21', '22', '', '', 'BenzBmw下注', '1615185138');
INSERT INTO `bills` VALUES ('7712', '22', '8', '欧阳', '5775', '-1000', '21', '22', '', '', 'BenzBmw下注', '1615185138');
INSERT INTO `bills` VALUES ('7713', '22', '8', '欧阳', '4775', '-1000', '21', '22', '', '', 'BenzBmw下注', '1615185139');
INSERT INTO `bills` VALUES ('7714', '22', '8', '欧阳', '3775', '-1000', '21', '22', '', '', 'BenzBmw下注', '1615185140');
INSERT INTO `bills` VALUES ('7715', '12', '8', 'ssjj', '798', '-100', '21', '12', '', '', 'BenzBmw下注', '1615185140');
INSERT INTO `bills` VALUES ('7716', '12', '8', 'ssjj', '698', '-100', '21', '12', '', '', 'BenzBmw下注', '1615185143');
INSERT INTO `bills` VALUES ('7717', '12', '8', 'ssjj', '598', '-100', '21', '12', '', '', 'BenzBmw下注', '1615185144');
INSERT INTO `bills` VALUES ('7718', '12', '8', 'ssjj', '498', '-100', '21', '12', '', '', 'BenzBmw下注', '1615185144');
INSERT INTO `bills` VALUES ('7719', '12', '8', 'ssjj', '398', '-100', '21', '12', '', '', 'BenzBmw下注', '1615185144');
INSERT INTO `bills` VALUES ('7720', '12', '8', 'ssjj', '1398', '1000', '24', '0', '', '', 'Benz BMW Issue43327', '1615185149');
INSERT INTO `bills` VALUES ('7721', '22', '8', '欧阳', '3275', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185173');
INSERT INTO `bills` VALUES ('7722', '22', '8', '欧阳', '2775', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185174');
INSERT INTO `bills` VALUES ('7723', '22', '8', '欧阳', '2275', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185176');
INSERT INTO `bills` VALUES ('7724', '22', '8', '欧阳', '1775', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185176');
INSERT INTO `bills` VALUES ('7725', '22', '8', '欧阳', '1275', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185178');
INSERT INTO `bills` VALUES ('7726', '22', '8', '欧阳', '775', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185179');
INSERT INTO `bills` VALUES ('7727', '11', '8', 'Mozi2019', '4620', '-10', '21', '11', '', '', 'BenzBmw下注', '1615185180');
INSERT INTO `bills` VALUES ('7728', '22', '8', '欧阳', '275', '-500', '21', '22', '', '', 'BenzBmw下注', '1615185180');
INSERT INTO `bills` VALUES ('7729', '11', '8', 'Mozi2019', '4610', '-10', '21', '11', '', '', 'BenzBmw下注', '1615185181');
INSERT INTO `bills` VALUES ('7730', '11', '8', 'Mozi2019', '4600', '-10', '21', '11', '', '', 'BenzBmw下注', '1615185181');
INSERT INTO `bills` VALUES ('7731', '11', '8', 'Mozi2019', '4590', '-10', '21', '11', '', '', 'BenzBmw下注', '1615185182');
INSERT INTO `bills` VALUES ('7732', '11', '8', 'Mozi2019', '4490', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185217');
INSERT INTO `bills` VALUES ('7733', '11', '8', 'Mozi2019', '4390', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185217');
INSERT INTO `bills` VALUES ('7734', '11', '8', 'Mozi2019', '4290', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185218');
INSERT INTO `bills` VALUES ('7735', '11', '8', 'Mozi2019', '4190', '-100', '21', '11', '', '', 'BenzBmw下注', '1615185218');
INSERT INTO `bills` VALUES ('7736', '24', '169', 'anna', '4700', '-100', '20', '24', '', '', '红绿球下注', '1615185229');
INSERT INTO `bills` VALUES ('7737', '5', '169', 'tuned', '9090', '-100', '20', '5', '', '', '红绿球下注', '1615185239');
INSERT INTO `bills` VALUES ('7738', '5', '169', 'tuned', '9040', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185259');
INSERT INTO `bills` VALUES ('7739', '5', '169', 'tuned', '8990', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185260');
INSERT INTO `bills` VALUES ('7740', '5', '169', 'tuned', '8940', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185260');
INSERT INTO `bills` VALUES ('7741', '5', '169', 'tuned', '8890', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185260');
INSERT INTO `bills` VALUES ('7742', '5', '169', 'tuned', '8840', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185261');
INSERT INTO `bills` VALUES ('7743', '5', '169', 'tuned', '8790', '-50', '21', '5', '', '', 'BenzBmw下注', '1615185261');
INSERT INTO `bills` VALUES ('7744', '5', '169', 'tuned', '8590', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185298');
INSERT INTO `bills` VALUES ('7745', '5', '169', 'tuned', '8390', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185305');
INSERT INTO `bills` VALUES ('7746', '5', '169', 'tuned', '8190', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185335');
INSERT INTO `bills` VALUES ('7747', '5', '169', 'tuned', '7990', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185336');
INSERT INTO `bills` VALUES ('7748', '5', '169', 'tuned', '7790', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185336');
INSERT INTO `bills` VALUES ('7749', '5', '169', 'tuned', '7590', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185337');
INSERT INTO `bills` VALUES ('7750', '5', '169', 'tuned', '7390', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185346');
INSERT INTO `bills` VALUES ('7751', '5', '169', 'tuned', '7190', '-200', '21', '5', '', '', 'BenzBmw下注', '1615185346');
INSERT INTO `bills` VALUES ('7752', '24', '169', 'anna', '4600', '-100', '20', '24', '', '', '红绿球下注', '1615185611');
INSERT INTO `bills` VALUES ('7753', '24', '169', 'anna', '4500', '-100', '20', '24', '', '', '红绿球下注', '1615185611');
INSERT INTO `bills` VALUES ('7754', '24', '169', 'anna', '4400', '-100', '20', '24', '', '', '红绿球下注', '1615185612');
INSERT INTO `bills` VALUES ('7755', '24', '169', 'anna', '4300', '-100', '20', '24', '', '', '红绿球下注', '1615185612');
INSERT INTO `bills` VALUES ('7756', '24', '169', 'anna', '4200', '-100', '20', '24', '', '', '红绿球下注', '1615185617');
INSERT INTO `bills` VALUES ('7757', '24', '169', 'anna', '4100', '-100', '20', '24', '', '', '红绿球下注', '1615185618');
INSERT INTO `bills` VALUES ('7758', '24', '169', 'anna', '4000', '-100', '20', '24', '', '', '红绿球下注', '1615185825');
INSERT INTO `bills` VALUES ('7759', '24', '169', 'anna', '3900', '-100', '20', '24', '', '', '红绿球下注', '1615185826');
INSERT INTO `bills` VALUES ('7760', '5', '169', 'tuned', '7180', '-10', '20', '5', '', '', '红绿球下注', '1615185908');
INSERT INTO `bills` VALUES ('7761', '5', '169', 'tuned', '7170', '-10', '20', '5', '', '', '红绿球下注', '1615186119');
INSERT INTO `bills` VALUES ('7762', '6', '8', 'Aaron', '9980', '-10', '20', '6', '', '', '红绿球下注', '1615186403');
INSERT INTO `bills` VALUES ('7763', '5', '169', 'tuned', '6170', '-1000', '20', '5', '', '', '红绿球下注', '1615186501');
INSERT INTO `bills` VALUES ('7764', '5', '169', 'tuned', '5170', '-1000', '20', '5', '', '', '红绿球下注', '1615186505');
INSERT INTO `bills` VALUES ('7765', '6', '8', 'Aaron', '9970', '-10', '20', '6', '', '', '红绿球下注', '1615186569');
INSERT INTO `bills` VALUES ('7766', '6', '8', 'Aaron', '8970', '-1000', '20', '6', '', '', '红绿球下注', '1615186688');
INSERT INTO `bills` VALUES ('7767', '3', '8', 'gains', '9100', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187175');
INSERT INTO `bills` VALUES ('7768', '3', '8', 'gains', '9090', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187175');
INSERT INTO `bills` VALUES ('7769', '3', '8', 'gains', '9080', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187175');
INSERT INTO `bills` VALUES ('7770', '3', '8', 'gains', '9070', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187175');
INSERT INTO `bills` VALUES ('7771', '3', '8', 'gains', '9060', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187213');
INSERT INTO `bills` VALUES ('7772', '3', '8', 'gains', '9050', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187214');
INSERT INTO `bills` VALUES ('7773', '3', '8', 'gains', '9040', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187214');
INSERT INTO `bills` VALUES ('7774', '3', '8', 'gains', '9030', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187214');
INSERT INTO `bills` VALUES ('7775', '3', '8', 'gains', '9020', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187215');
INSERT INTO `bills` VALUES ('7776', '3', '8', 'gains', '9010', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187215');
INSERT INTO `bills` VALUES ('7777', '3', '8', 'gains', '9000', '-10', '21', '3', '', '', 'BenzBmw下注', '1615187215');
INSERT INTO `bills` VALUES ('7778', '3', '8', 'gains', '8950', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187253');
INSERT INTO `bills` VALUES ('7779', '3', '8', 'gains', '8900', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7780', '3', '8', 'gains', '8850', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7781', '3', '8', 'gains', '8800', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7782', '3', '8', 'gains', '8750', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7783', '3', '8', 'gains', '8700', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7784', '3', '8', 'gains', '8650', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187254');
INSERT INTO `bills` VALUES ('7785', '3', '8', 'gains', '8600', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187293');
INSERT INTO `bills` VALUES ('7786', '3', '8', 'gains', '8550', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187294');
INSERT INTO `bills` VALUES ('7787', '3', '8', 'gains', '8500', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187294');
INSERT INTO `bills` VALUES ('7788', '3', '8', 'gains', '8450', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187295');
INSERT INTO `bills` VALUES ('7789', '3', '8', 'gains', '8400', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187295');
INSERT INTO `bills` VALUES ('7790', '3', '8', 'gains', '8350', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187295');
INSERT INTO `bills` VALUES ('7791', '3', '8', 'gains', '8300', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187296');
INSERT INTO `bills` VALUES ('7792', '3', '8', 'gains', '8250', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187333');
INSERT INTO `bills` VALUES ('7793', '3', '8', 'gains', '8200', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187334');
INSERT INTO `bills` VALUES ('7794', '3', '8', 'gains', '8150', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187334');
INSERT INTO `bills` VALUES ('7795', '3', '8', 'gains', '8100', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187334');
INSERT INTO `bills` VALUES ('7796', '3', '8', 'gains', '8050', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187334');
INSERT INTO `bills` VALUES ('7797', '3', '8', 'gains', '8000', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187334');
INSERT INTO `bills` VALUES ('7798', '3', '8', 'gains', '7950', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187335');
INSERT INTO `bills` VALUES ('7799', '6', '8', 'Aaron', '8920', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187340');
INSERT INTO `bills` VALUES ('7800', '6', '8', 'Aaron', '8870', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187343');
INSERT INTO `bills` VALUES ('7801', '6', '8', 'Aaron', '8820', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187345');
INSERT INTO `bills` VALUES ('7802', '6', '8', 'Aaron', '8770', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187346');
INSERT INTO `bills` VALUES ('7803', '3', '8', 'gains', '7900', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187376');
INSERT INTO `bills` VALUES ('7804', '3', '8', 'gains', '7850', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187376');
INSERT INTO `bills` VALUES ('7805', '3', '8', 'gains', '7800', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187377');
INSERT INTO `bills` VALUES ('7806', '3', '8', 'gains', '7750', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187377');
INSERT INTO `bills` VALUES ('7807', '3', '8', 'gains', '7700', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187377');
INSERT INTO `bills` VALUES ('7808', '3', '8', 'gains', '7650', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187377');
INSERT INTO `bills` VALUES ('7809', '3', '8', 'gains', '7600', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187377');
INSERT INTO `bills` VALUES ('7810', '3', '8', 'gains', '7550', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187414');
INSERT INTO `bills` VALUES ('7811', '7', '8', 'crystal', '9550', '-200', '21', '7', '', '', 'BenzBmw下注', '1615187415');
INSERT INTO `bills` VALUES ('7812', '6', '8', 'Aaron', '8720', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187415');
INSERT INTO `bills` VALUES ('7813', '3', '8', 'gains', '7500', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187415');
INSERT INTO `bills` VALUES ('7814', '3', '8', 'gains', '7450', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187415');
INSERT INTO `bills` VALUES ('7815', '7', '8', 'crystal', '9350', '-200', '21', '7', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7816', '3', '8', 'gains', '7400', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7817', '3', '8', 'gains', '7350', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7818', '3', '8', 'gains', '7300', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7819', '3', '8', 'gains', '7250', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7820', '3', '8', 'gains', '7200', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7821', '3', '8', 'gains', '7150', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187416');
INSERT INTO `bills` VALUES ('7822', '5', '169', 'tuned', '4670', '-500', '21', '5', '', '', 'BenzBmw下注', '1615187421');
INSERT INTO `bills` VALUES ('7823', '5', '169', 'tuned', '4170', '-500', '21', '5', '', '', 'BenzBmw下注', '1615187421');
INSERT INTO `bills` VALUES ('7824', '5', '169', 'tuned', '3670', '-500', '21', '5', '', '', 'BenzBmw下注', '1615187422');
INSERT INTO `bills` VALUES ('7825', '5', '169', 'tuned', '3170', '-500', '21', '5', '', '', 'BenzBmw下注', '1615187422');
INSERT INTO `bills` VALUES ('7826', '5', '169', 'tuned', '2670', '-500', '21', '5', '', '', 'BenzBmw下注', '1615187423');
INSERT INTO `bills` VALUES ('7827', '6', '8', 'Aaron', '8670', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187424');
INSERT INTO `bills` VALUES ('7828', '3', '8', 'gains', '7400', '250', '24', '0', '', '', 'Benz BMW Issue45607', '1615187429');
INSERT INTO `bills` VALUES ('7829', '3', '8', 'gains', '7350', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187454');
INSERT INTO `bills` VALUES ('7830', '3', '8', 'gains', '7300', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187455');
INSERT INTO `bills` VALUES ('7831', '3', '8', 'gains', '7250', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187456');
INSERT INTO `bills` VALUES ('7832', '3', '8', 'gains', '7200', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187456');
INSERT INTO `bills` VALUES ('7833', '3', '8', 'gains', '7150', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187456');
INSERT INTO `bills` VALUES ('7834', '3', '8', 'gains', '7100', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187456');
INSERT INTO `bills` VALUES ('7835', '3', '8', 'gains', '7050', '-50', '21', '3', '', '', 'BenzBmw下注', '1615187456');
INSERT INTO `bills` VALUES ('7836', '6', '8', 'Aaron', '8620', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187461');
INSERT INTO `bills` VALUES ('7837', '6', '8', 'Aaron', '8570', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187463');
INSERT INTO `bills` VALUES ('7838', '3', '8', 'gains', '7300', '250', '24', '0', '', '', 'Benz BMW Issue45647', '1615187469');
INSERT INTO `bills` VALUES ('7839', '6', '8', 'Aaron', '8520', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187660');
INSERT INTO `bills` VALUES ('7840', '6', '8', 'Aaron', '8470', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187698');
INSERT INTO `bills` VALUES ('7841', '6', '8', 'Aaron', '8420', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187700');
INSERT INTO `bills` VALUES ('7842', '6', '8', 'Aaron', '8370', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187701');
INSERT INTO `bills` VALUES ('7843', '6', '8', 'Aaron', '8320', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187702');
INSERT INTO `bills` VALUES ('7844', '6', '8', 'Aaron', '8270', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187703');
INSERT INTO `bills` VALUES ('7845', '6', '8', 'Aaron', '8220', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187704');
INSERT INTO `bills` VALUES ('7846', '6', '8', 'Aaron', '8170', '-50', '21', '6', '', '', 'BenzBmw下注', '1615187704');
INSERT INTO `bills` VALUES ('7847', '6', '8', 'Aaron', '8070', '-100', '21', '6', '', '', 'BenzBmw下注', '1615187736');
INSERT INTO `bills` VALUES ('7848', '6', '8', 'Aaron', '7970', '-100', '21', '6', '', '', 'BenzBmw下注', '1615187738');
INSERT INTO `bills` VALUES ('7849', '5', '169', 'tuned', '2570', '-100', '20', '5', '', '', '红绿球下注', '1615187799');
INSERT INTO `bills` VALUES ('7850', '3', '8', 'gains', '7290', '-10', '20', '3', '', '', '红绿球下注', '1615188113');
INSERT INTO `bills` VALUES ('7851', '3', '8', 'gains', '7280', '-10', '20', '3', '', '', '红绿球下注', '1615188261');
INSERT INTO `bills` VALUES ('7852', '3', '8', 'gains', '7270', '-10', '20', '3', '', '', '红绿球下注', '1615188275');
INSERT INTO `bills` VALUES ('7853', '3', '8', 'gains', '7260', '-10', '20', '3', '', '', '红绿球下注', '1615188279');
INSERT INTO `bills` VALUES ('7854', '5', '169', 'tuned', '2470', '-100', '20', '5', '', '', '红绿球下注', '1615188499');
INSERT INTO `bills` VALUES ('7855', '5', '169', 'tuned', '1470', '-1000', '20', '5', '', '', '红绿球下注', '1615188557');
INSERT INTO `bills` VALUES ('7856', '5', '169', 'tuned', '470', '-1000', '20', '5', '', '', '红绿球下注', '1615188558');
INSERT INTO `bills` VALUES ('7857', '3', '8', 'gains', '7160', '-100', '20', '3', '', '', '红绿球下注', '1615192405');
INSERT INTO `bills` VALUES ('7858', '6', '8', 'Aaron', '6970', '-1000', '20', '6', '', '', '红绿球下注', '1615192408');
INSERT INTO `bills` VALUES ('7859', '3', '8', 'gains', '6160', '-1000', '20', '3', '', '', '红绿球下注', '1615192410');
INSERT INTO `bills` VALUES ('7860', '3', '8', 'gains', '5160', '-1000', '20', '3', '', '', '红绿球下注', '1615192424');
INSERT INTO `bills` VALUES ('7861', '3', '8', 'gains', '4160', '-1000', '20', '3', '', '', '红绿球下注', '1615192428');
INSERT INTO `bills` VALUES ('7862', '6', '8', 'Aaron', '5970', '-1000', '20', '6', '', '', '红绿球下注', '1615192441');
INSERT INTO `bills` VALUES ('7863', '6', '8', 'Aaron', '5960', '-10', '20', '6', '', '', '红绿球下注', '1615192705');
INSERT INTO `bills` VALUES ('7864', '6', '8', 'Aaron', '5860', '-100', '20', '6', '', '', '红绿球下注', '1615192922');
INSERT INTO `bills` VALUES ('7865', '6', '8', 'Aaron', '5760', '-100', '20', '6', '', '', '红绿球下注', '1615193046');
INSERT INTO `bills` VALUES ('7866', '6', '8', 'Aaron', '5660', '-100', '20', '6', '', '', '红绿球下注', '1615193051');

-- ----------------------------
-- Table structure for cc_announcement_info
-- ----------------------------
DROP TABLE IF EXISTS `cc_announcement_info`;
CREATE TABLE `cc_announcement_info` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT,
  `announcement_type` int(11) DEFAULT NULL COMMENT '公告类型',
  `announcement_title` varchar(50) DEFAULT NULL COMMENT '公告标题',
  `announcement_content` varchar(500) DEFAULT NULL COMMENT '公告内容',
  `announcement_author` varchar(50) DEFAULT NULL COMMENT '发布者',
  `announcement_time` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cc_announcement_info
-- ----------------------------

-- ----------------------------
-- Table structure for cc_announcement_info_user
-- ----------------------------
DROP TABLE IF EXISTS `cc_announcement_info_user`;
CREATE TABLE `cc_announcement_info_user` (
  `announcement_info_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `announcement_id` int(11) DEFAULT NULL COMMENT '公告Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `announcement_flag` int(11) DEFAULT NULL COMMENT '是否已读',
  PRIMARY KEY (`announcement_info_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cc_announcement_info_user
-- ----------------------------

-- ----------------------------
-- Table structure for cc_data_cleaning
-- ----------------------------
DROP TABLE IF EXISTS `cc_data_cleaning`;
CREATE TABLE `cc_data_cleaning` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `data_type` int(11) DEFAULT NULL COMMENT '数据类型',
  `data_time` varchar(50) DEFAULT NULL COMMENT '数据时间',
  `data_count` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`data_id`) USING BTREE,
  UNIQUE KEY `unique_data_type_time` (`data_type`,`data_time`) USING BTREE COMMENT '数据类型、日期唯一建索引'
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cc_data_cleaning
-- ----------------------------
INSERT INTO `cc_data_cleaning` VALUES ('1', '1', '2019-12-04', '1');
INSERT INTO `cc_data_cleaning` VALUES ('2', '1', '2019-12-05', '0');
INSERT INTO `cc_data_cleaning` VALUES ('3', '1', '2019-12-06', '0');
INSERT INTO `cc_data_cleaning` VALUES ('4', '1', '2019-12-07', '0');
INSERT INTO `cc_data_cleaning` VALUES ('5', '1', '2019-12-08', '0');
INSERT INTO `cc_data_cleaning` VALUES ('6', '1', '2019-12-09', '0');
INSERT INTO `cc_data_cleaning` VALUES ('7', '1', '2019-12-10', '2');
INSERT INTO `cc_data_cleaning` VALUES ('14', '1', '2019-12-11', '0');
INSERT INTO `cc_data_cleaning` VALUES ('15', '1', '2019-12-12', '1');
INSERT INTO `cc_data_cleaning` VALUES ('42', '1', '2019-12-15', '0');
INSERT INTO `cc_data_cleaning` VALUES ('43', '1', '2019-12-16', '0');
INSERT INTO `cc_data_cleaning` VALUES ('44', '1', '2019-12-17', '0');
INSERT INTO `cc_data_cleaning` VALUES ('45', '1', '2019-12-18', '0');
INSERT INTO `cc_data_cleaning` VALUES ('46', '1', '2019-12-19', '0');
INSERT INTO `cc_data_cleaning` VALUES ('47', '1', '2019-12-20', '0');
INSERT INTO `cc_data_cleaning` VALUES ('48', '1', '2019-12-21', '1');
INSERT INTO `cc_data_cleaning` VALUES ('60', '1', '2019-12-22', '0');
INSERT INTO `cc_data_cleaning` VALUES ('61', '1', '2019-12-23', '0');
INSERT INTO `cc_data_cleaning` VALUES ('62', '1', '2019-12-24', '1');
INSERT INTO `cc_data_cleaning` VALUES ('67', '1', '2019-12-25', '1');
INSERT INTO `cc_data_cleaning` VALUES ('74', '1', '2019-12-26', '2');
INSERT INTO `cc_data_cleaning` VALUES ('96', '1', '2019-12-27', '0');
INSERT INTO `cc_data_cleaning` VALUES ('97', '1', '2019-12-28', '0');
INSERT INTO `cc_data_cleaning` VALUES ('98', '1', '2019-12-29', '0');
INSERT INTO `cc_data_cleaning` VALUES ('99', '1', '2019-12-30', '1');
INSERT INTO `cc_data_cleaning` VALUES ('103', '1', '2019-12-31', '2');
INSERT INTO `cc_data_cleaning` VALUES ('110', '1', '2020-01-01', '2');
INSERT INTO `cc_data_cleaning` VALUES ('117', '1', '2020-01-02', '3');
INSERT INTO `cc_data_cleaning` VALUES ('124', '1', '2020-01-03', '2');
INSERT INTO `cc_data_cleaning` VALUES ('131', '1', '2020-01-04', '3');
INSERT INTO `cc_data_cleaning` VALUES ('138', '1', '2020-01-05', '1');
INSERT INTO `cc_data_cleaning` VALUES ('145', '1', '2020-01-06', '1');
INSERT INTO `cc_data_cleaning` VALUES ('152', '1', '2020-01-07', '1');
INSERT INTO `cc_data_cleaning` VALUES ('159', '1', '2020-01-08', '2');
INSERT INTO `cc_data_cleaning` VALUES ('166', '1', '2020-01-09', '3');
INSERT INTO `cc_data_cleaning` VALUES ('167', '1', '2021-02-22', '0');
INSERT INTO `cc_data_cleaning` VALUES ('168', '1', '2021-02-23', '0');
INSERT INTO `cc_data_cleaning` VALUES ('169', '1', '2021-02-24', '0');
INSERT INTO `cc_data_cleaning` VALUES ('170', '1', '2021-02-25', '1');
INSERT INTO `cc_data_cleaning` VALUES ('171', '1', '2021-02-26', '1');
INSERT INTO `cc_data_cleaning` VALUES ('172', '1', '2021-02-27', '1');
INSERT INTO `cc_data_cleaning` VALUES ('173', '1', '2021-02-28', '1');
INSERT INTO `cc_data_cleaning` VALUES ('174', '1', '2021-03-01', '1');
INSERT INTO `cc_data_cleaning` VALUES ('181', '1', '2021-03-02', '4');
INSERT INTO `cc_data_cleaning` VALUES ('188', '1', '2021-03-03', '7');
INSERT INTO `cc_data_cleaning` VALUES ('195', '1', '2021-03-04', '2');
INSERT INTO `cc_data_cleaning` VALUES ('202', '1', '2021-03-05', '6');
INSERT INTO `cc_data_cleaning` VALUES ('209', '1', '2021-03-06', '3');
INSERT INTO `cc_data_cleaning` VALUES ('210', '1', '2021-03-07', '6');

-- ----------------------------
-- Table structure for cc_resource
-- ----------------------------
DROP TABLE IF EXISTS `cc_resource`;
CREATE TABLE `cc_resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_parentId` int(11) DEFAULT NULL,
  `res_name` varchar(50) NOT NULL,
  `res_status` int(11) DEFAULT NULL,
  `res_model_code` varchar(30) DEFAULT NULL COMMENT '模块标识',
  `res_link_address` varchar(200) DEFAULT NULL,
  `res_image` varchar(100) DEFAULT NULL,
  `res_level` int(11) DEFAULT NULL,
  `res_type` int(11) DEFAULT NULL,
  `res_display_order` int(11) DEFAULT NULL,
  `res_remark` varchar(200) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`res_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='资源表';

-- ----------------------------
-- Records of cc_resource
-- ----------------------------
INSERT INTO `cc_resource` VALUES ('2', '5', '用户管理', '0', '7JMoS6yG', '/user/user_list.do', 'larry-10103', '3', '0', '11', '', 'admin', '2016-11-25 16:57:22', 'admin', '2017-08-15 11:27:40');
INSERT INTO `cc_resource` VALUES ('3', '5', '角色管理', '0', 'SPAn6H46', '/role/role_list.do', 'larry-jiaoseguanli1', '3', '0', '3', '配置系统角色信息', 'admin', '2016-11-25 16:57:25', null, null);
INSERT INTO `cc_resource` VALUES ('4', '5', '菜单管理', '0', '0rbT8g7m', '/res/res_list.do', 'larry-caidanguanli', '3', '0', '4', '', 'admin', '2016-11-25 16:57:31', 'admin', '2017-08-15 11:04:41');
INSERT INTO `cc_resource` VALUES ('5', '7', '系统设置', '0', '0rbT8g9m', null, 'larry-xitongshezhi1', '2', '0', '5', '配置系统菜单信息', 'admin', '2017-07-28 09:31:43', null, null);
INSERT INTO `cc_resource` VALUES ('7', null, '系统管理', '0', '0rbT8g8m', '', 'larry-xitongshezhi1', '1', '0', '1', '配置系统菜单信息', 'admin', '2017-07-28 13:24:57', 'admin', '2019-10-31 16:40:03');
INSERT INTO `cc_resource` VALUES ('9', '7', '消息中心', '0', '0rbT8g2m', '', 'larry-gerenxinxi5', '2', '0', '8', '配置系统菜单信息', 'admin', '2017-07-28 14:23:35', 'admin', '2017-08-28 19:50:48');
INSERT INTO `cc_resource` VALUES ('10', '9', '公告管理', '0', '0rbT8t2m', '/announcement/announcement_list.do', 'larry-gonggaoguanli', '3', '0', '9', '配置系统菜单信息', 'admin', '2017-07-28 17:07:55', 'admin', '2017-09-04 11:07:18');
INSERT INTO `cc_resource` VALUES ('12', '2', '用户新增', '0', '0rbT8t2P', '/user/user_add.do', 'larry-gerenxinxi1', '3', '1', '3', '', 'admin', '2017-08-14 16:47:12', 'admin', '2017-08-16 17:56:18');
INSERT INTO `cc_resource` VALUES ('15', '2', '用户导出', '0', '0jOfTHGx', '/user/excel_users_export.do', 'larry-10103', '3', '1', null, '', 'admin', '2017-08-16 23:29:50', null, null);
INSERT INTO `cc_resource` VALUES ('16', '2', '用户修改', '0', 'fSv1B2kZ', '/user/user_update.do', 'larry-bianji2', '3', '1', null, '', 'admin', '2017-08-16 23:30:21', 'admin', '2017-08-22 14:37:55');
INSERT INTO `cc_resource` VALUES ('17', '2', '用户失效', '0', 'uBg9TdEr', '/user/ajax_user_fail.do', 'larry-10103', '3', '1', null, '', 'admin', '2017-08-16 23:30:46', null, null);
INSERT INTO `cc_resource` VALUES ('18', '2', '批量失效', '0', 'lBE3hz5c', '/user/ajax_user_batch_fail.do', 'caidanguanli', '3', '1', null, '', 'admin', '2017-08-16 23:31:09', null, null);
INSERT INTO `cc_resource` VALUES ('19', '2', '分配角色', '0', 'mScICO9G', '/user/user_grant.do', 'jiaoseguanli1', '3', '1', null, '', 'admin', '2017-08-16 23:31:37', null, null);
INSERT INTO `cc_resource` VALUES ('20', '3', '角色导出', '0', 'oCNcsKmk', '/role/excel_role_export.do', 'jiaoseguanli1', '3', '1', null, '', 'admin', '2017-08-16 23:32:29', null, null);
INSERT INTO `cc_resource` VALUES ('21', '3', '角色新增', '0', 'nxRVZA5i', '/role/role_add.do', 'caidanguanli', '3', '1', null, '', 'admin', '2017-08-16 23:33:01', null, null);
INSERT INTO `cc_resource` VALUES ('22', '3', '角色修改', '0', 'moHbdnjz', '/role/role_update.do', 'liuyan', '3', '1', null, '', 'admin', '2017-08-16 23:33:26', null, null);
INSERT INTO `cc_resource` VALUES ('23', '3', '角色失效', '0', 'tkwJk34z', '/role/ajax_role_fail.do', 'caidanguanli', '3', '1', null, '', 'admin', '2017-08-16 23:33:46', null, null);
INSERT INTO `cc_resource` VALUES ('24', '3', '批量失效', '0', 'qsieHTy4', '/role/ajax_role_batch_fail.do', 'liuyan', '3', '1', null, '', 'admin', '2017-08-16 23:34:04', 'admin', '2017-08-22 17:31:48');
INSERT INTO `cc_resource` VALUES ('25', '3', '角色赋权', '0', 'bSG7LAmU', '/role/role_grant.do', 'caidanguanli', '3', '1', null, '', 'admin', '2017-08-16 23:34:28', null, null);
INSERT INTO `cc_resource` VALUES ('26', '4', '菜单新增', '0', 'Mhtly5er', '/res/res_edit.do', 'larry-11', '3', '1', null, '', 'admin', '2017-08-22 13:41:27', null, null);
INSERT INTO `cc_resource` VALUES ('27', '4', '菜单编辑', '0', 'KxCQVzRq', '/res/res_update.do', 'larry-bianji5', '3', '1', null, '', 'admin', '2017-08-22 13:42:30', null, null);
INSERT INTO `cc_resource` VALUES ('28', '4', '菜单失效', '0', 'DK3uPfe7', '/res/ajax_res_fail.do', 'larry-shanchu8', '3', '1', null, '', 'admin', '2017-08-22 13:45:01', null, null);
INSERT INTO `cc_resource` VALUES ('29', '4', '菜单导出', '0', 'wPUNDGgZ', '/res/excel_res_export.do', 'larry-wangzhanneirong', '3', '1', null, '', 'admin', '2017-08-22 13:46:43', null, null);
INSERT INTO `cc_resource` VALUES ('51', '7', '日志中心', '0', 'gYFTwbQb', '', 'larry-gongzuoneirong', '2', '0', null, '', 'admin', '2017-08-30 17:58:16', 'admin', '2017-08-30 18:01:42');
INSERT INTO `cc_resource` VALUES ('52', '51', '日志管理', '0', 'oL6OcNAt', '/syslog/sys_log_list.do', 'larry-pingjiaguanli1', '3', '0', null, '', 'admin', '2017-08-30 18:03:00', 'admin', '2017-09-08 10:55:16');
INSERT INTO `cc_resource` VALUES ('53', '9', '消息管理', '0', 'H70iVoxC', '/test.do', 'larry-liuyan', '3', '0', null, '', 'admin', '2017-08-31 12:34:52', null, null);
INSERT INTO `cc_resource` VALUES ('54', '10', '新增公告', '0', '4JQVLmOd', '/announcement/announcement_add.do', 'larry-iconfontadd', '3', '1', null, '', 'admin', '2017-09-04 17:08:03', null, null);
INSERT INTO `cc_resource` VALUES ('55', '10', '删除公告', '0', 'eTDnjGAM', '/announcement/ajax_del_announcement.do', 'larry-shanchu9', '3', '1', null, '', 'admin', '2017-09-04 17:08:27', null, null);
INSERT INTO `cc_resource` VALUES ('57', null, '游戏管理', '0', 'AnWHwDjw', '', 'larry-dengji', '1', '0', '2', '', 'admin', '2019-10-31 16:33:10', 'admin', '2019-10-31 17:08:33');
INSERT INTO `cc_resource` VALUES ('58', '70', '玩家列表', '0', 'DyYDzcJq', '/gameUser/user_list.do', 'larry-10103', '3', '0', '1', '', 'admin', '2019-10-31 17:03:32', 'admin', '2019-11-29 16:09:35');
INSERT INTO `cc_resource` VALUES ('59', '60', '流水管理', '0', 'n7XWweF0', '/gameCapital/bills_list.do', 'larry-duanxin1', '3', '0', '1', '', 'admin', '2019-10-31 17:08:01', 'admin', '2019-11-07 10:01:42');
INSERT INTO `cc_resource` VALUES ('60', '57', '资金管理', '0', 'MTVxoerT', '', 'larry-dengjipingdingguanli', '2', '0', '2', '', 'admin', '2019-10-31 17:11:12', null, null);
INSERT INTO `cc_resource` VALUES ('61', '60', '订单管理', '0', 'WWBcKAyo', '/gameCapital/order_list.do', 'larry-iconzfb', '3', '0', '2', '', 'admin', '2019-10-31 17:14:06', 'admin', '2019-11-08 09:28:08');
INSERT INTO `cc_resource` VALUES ('62', '60', '冻结资金', '1', 'wlnCyjCi', '/gameCapital/freeze_list.do', 'larry-iconfonthuishouzhan', '3', '0', '3', '', 'admin', '2019-10-31 17:16:40', 'admin', '2020-01-09 18:44:30');
INSERT INTO `cc_resource` VALUES ('63', '60', '战绩列表', '1', 'Tb65eU4r', '/gameCapital/gameRec_list.do', 'larry-tihuan', '3', '0', '3', '', 'admin', '2019-10-31 17:18:15', 'admin', '2021-02-26 16:18:35');
INSERT INTO `cc_resource` VALUES ('65', '62', '解冻资金', '0', 'QsTIzP4o', '/gameCapital/ajax_unfreeze.do', 'larry-shanchu9', '3', '1', null, '', 'admin', '2019-11-08 17:15:12', null, null);
INSERT INTO `cc_resource` VALUES ('66', '57', '矿石管理', '1', 'EGX4mvpz', '', 'larry-dengji', '2', '0', null, '', 'admin', '2019-11-14 09:41:49', 'admin', '2020-01-09 18:46:26');
INSERT INTO `cc_resource` VALUES ('67', '66', '矿卡明细', '1', 'kJeHwP81', '/gameMineral/mineralCode_list.do', 'larry-chongfuzhaopian', '3', '0', null, '', 'admin', '2019-11-14 09:58:53', 'admin', '2020-01-09 18:46:17');
INSERT INTO `cc_resource` VALUES ('68', '66', '矿石流水', '1', 'cNPhT2xR', '/gameMineral/mineralBills_list.do', 'larry-dengjipingdingguanli', '3', '0', null, '', 'admin', '2019-11-14 10:16:32', 'admin', '2020-01-09 18:46:08');
INSERT INTO `cc_resource` VALUES ('69', '67', '新增矿卡', '1', 'B69B6W6k', '/gameMineral/ajax_save_mineralCode.do', 'larry-tianjia6', '3', '1', null, '', 'admin', '2019-11-15 14:19:45', 'admin', '2020-01-09 18:45:58');
INSERT INTO `cc_resource` VALUES ('70', '57', '玩家管理', '0', '5xZt3Pjt', '', 'larry-10103', '2', '0', '1', '', 'admin', '2019-11-29 16:06:40', 'admin', '2019-11-29 17:10:53');
INSERT INTO `cc_resource` VALUES ('71', '58', '添加金币', '0', 'fZKo6sJb', '/gameUser/ajax_add_coin.do', 'larry-dengjipingdingguanli', '3', '1', null, '', 'admin', '2019-11-29 16:12:15', 'admin', '2019-12-03 14:40:47');
INSERT INTO `cc_resource` VALUES ('72', '58', '添加矿石', '1', 'uG9vazWK', '/gameMineral/ajax_add_mineral.do', 'larry-dengjipingdingguanli', '3', '1', null, '', 'admin', '2019-12-02 11:45:22', 'admin', '2020-01-09 15:14:06');
INSERT INTO `cc_resource` VALUES ('73', '67', '矿卡失效', '1', 'AELCG3Rd', '/gameMineral/ajax_mineralCode_fail.do', 'larry-zidingyicaidan', '3', '1', null, '', 'admin', '2019-12-03 15:09:49', 'admin', '2020-01-09 18:45:50');
INSERT INTO `cc_resource` VALUES ('74', '58', '新增玩家', '0', 'CWiObpIP', '/gameUser/gameUser_add.do', 'larry-tianjia3', '3', '1', null, '', 'admin', '2020-01-09 12:10:36', null, null);
INSERT INTO `cc_resource` VALUES ('75', '58', '修改玩家密码', '0', '42wUOYef', '/gameUser/user_update.do', 'larry-tianjia3', '3', '1', null, '', 'admin', '2020-01-09 16:30:19', null, null);
INSERT INTO `cc_resource` VALUES ('76', '61', '提现审核', '0', 'gA3ITNsk', '/gameCapital/ajax_order_review.do', 'larry-tags', '3', '1', null, '', 'admin', '2020-01-09 18:00:36', null, null);
INSERT INTO `cc_resource` VALUES ('77', '58', '解冻冻结', '0', 'ZDl78QVW', '/gameMineral/ajax_user_freeze.do', 'larry-guanbi1', '3', '1', null, '', 'admin', '2021-02-19 11:37:59', null, null);
INSERT INTO `cc_resource` VALUES ('78', '60', '代理信息', '0', 'WrEveVOt', '/user/agent_info.do', 'larry-jiaoseguanli1', '3', '0', null, '', 'admin', '2021-02-25 16:24:49', 'admin', '2021-02-25 16:44:01');
INSERT INTO `cc_resource` VALUES ('79', '57', '游戏控制', '0', 'YGjEo64Q', '', 'larry-tianjia5', '2', '0', null, '', 'admin', '2021-02-26 16:20:40', null, null);
INSERT INTO `cc_resource` VALUES ('80', '79', '红绿球设置', '0', 'Aqu6a4bB', '/gameActive/rbBall_list.do', 'larry-logoshuiyin', '3', '0', null, '', 'admin', '2021-02-26 16:22:04', 'admin', '2021-02-26 16:35:23');
INSERT INTO `cc_resource` VALUES ('81', '79', '奔驰宝马设置', '0', 'RMVhVXdz', '/gameActive/benzBmw_info.do', 'larry-circularxiangxi', '3', '0', null, '', 'admin', '2021-02-26 16:23:03', 'admin', '2021-02-26 20:59:12');
INSERT INTO `cc_resource` VALUES ('82', '80', '新增一期', '0', '63Ry9Rel', '/gameActive/ajax_add_rbBall.do', 'larry-tianjia3', '3', '1', null, '', 'admin', '2021-02-26 20:24:08', 'admin', '2021-02-26 20:25:14');

-- ----------------------------
-- Table structure for cc_role
-- ----------------------------
DROP TABLE IF EXISTS `cc_role`;
CREATE TABLE `cc_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_status` int(11) NOT NULL,
  `role_remark` varchar(255) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of cc_role
-- ----------------------------
INSERT INTO `cc_role` VALUES ('51', '超级管理员', '0', null, 'admin', '2017-08-16 16:05:48', 'admin', '2017-08-16 16:05:48');
INSERT INTO `cc_role` VALUES ('52', '系统管理员', '0', null, 'admin', '2017-08-16 16:05:48', 'admin', '2017-08-16 16:05:48');
INSERT INTO `cc_role` VALUES ('53', '普通用户', '0', '', 'admin', '2017-08-22 13:50:41', 'admin', '2019-10-31 16:25:54');
INSERT INTO `cc_role` VALUES ('54', '风控员', '0', '', 'admin', '2021-03-08 13:10:19', null, null);

-- ----------------------------
-- Table structure for cc_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `cc_role_resource`;
CREATE TABLE `cc_role_resource` (
  `role_res_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_res_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1609 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色与资源关系表';

-- ----------------------------
-- Records of cc_role_resource
-- ----------------------------
INSERT INTO `cc_role_resource` VALUES ('1479', '51', '7', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1480', '51', '5', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1481', '51', '2', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1482', '51', '12', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1483', '51', '15', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1484', '51', '16', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1485', '51', '17', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1486', '51', '18', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1487', '51', '19', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1488', '51', '3', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1489', '51', '20', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1490', '51', '21', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1491', '51', '22', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1492', '51', '23', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1493', '51', '24', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1494', '51', '25', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1495', '51', '4', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1496', '51', '26', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1497', '51', '27', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1498', '51', '28', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1499', '51', '29', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1500', '51', '9', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1501', '51', '10', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1502', '51', '54', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1503', '51', '55', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1504', '51', '53', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1505', '51', '51', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1506', '51', '52', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1507', '51', '57', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1508', '51', '60', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1509', '51', '59', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1510', '51', '61', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1511', '51', '76', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1512', '51', '78', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1513', '51', '70', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1514', '51', '58', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1515', '51', '71', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1516', '51', '74', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1517', '51', '75', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1518', '51', '77', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1519', '51', '79', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1520', '51', '80', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1521', '51', '82', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1522', '51', '81', 'admin', '2021-03-02 19:33:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1548', '52', '7', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1549', '52', '5', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1550', '52', '2', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1551', '52', '12', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1552', '52', '16', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1553', '52', '17', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1554', '52', '19', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1555', '52', '9', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1556', '52', '10', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1557', '52', '54', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1558', '52', '55', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1559', '52', '57', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1560', '52', '60', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1561', '52', '59', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1562', '52', '61', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1563', '52', '76', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1564', '52', '78', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1565', '52', '70', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1566', '52', '58', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1567', '52', '71', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1568', '52', '75', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1569', '52', '77', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1570', '52', '79', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1571', '52', '80', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1572', '52', '82', 'admin', '2021-03-02 19:34:16', null, null);
INSERT INTO `cc_role_resource` VALUES ('1573', '52', '81', 'admin', '2021-03-02 19:34:17', null, null);
INSERT INTO `cc_role_resource` VALUES ('1574', '53', '57', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1575', '53', '60', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1576', '53', '59', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1577', '53', '61', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1578', '53', '78', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1579', '53', '70', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1580', '53', '58', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1581', '53', '75', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1582', '53', '77', 'admin', '2021-03-02 19:34:46', null, null);
INSERT INTO `cc_role_resource` VALUES ('1600', '54', '57', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1601', '54', '70', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1602', '54', '58', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1603', '54', '77', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1604', '54', '79', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1605', '54', '80', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1606', '54', '82', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1607', '54', '81', 'admin', '2021-03-08 13:18:24', null, null);
INSERT INTO `cc_role_resource` VALUES ('1608', '54', '65', 'admin', '2021-03-08 13:18:24', null, null);

-- ----------------------------
-- Table structure for cc_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `cc_sys_log`;
CREATE TABLE `cc_sys_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_title` varchar(20) DEFAULT NULL COMMENT '日志标题',
  `log_type` varchar(10) DEFAULT NULL COMMENT '日志类型 info error',
  `log_url` varchar(50) DEFAULT NULL COMMENT '日志请求url',
  `log_method` varchar(10) DEFAULT NULL COMMENT '请求方式 get post',
  `log_params` varchar(300) DEFAULT NULL COMMENT '请求参数',
  `log_exception` varchar(200) DEFAULT NULL COMMENT '请求异常',
  `log_user_name` varchar(50) DEFAULT NULL COMMENT '请求用户Id',
  `log_ip` varchar(20) DEFAULT NULL COMMENT '请求IP',
  `log_ip_address` varchar(40) DEFAULT NULL COMMENT '请求ip所在地',
  `log_start_time` datetime DEFAULT NULL COMMENT '请求开始时间',
  `log_elapsed_time` bigint(20) DEFAULT NULL COMMENT '请求耗时',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cc_sys_log
-- ----------------------------
INSERT INTO `cc_sys_log` VALUES ('1', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52\",\"userId\":\"9\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:23:55', '11');
INSERT INTO `cc_sys_log` VALUES ('2', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53\",\"userId\":\"9\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:24:17', '10');
INSERT INTO `cc_sys_log` VALUES ('3', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53,52\",\"userId\":\"9\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:24:24', '11');
INSERT INTO `cc_sys_log` VALUES ('4', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52,53\",\"userId\":\"9\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:24:38', '12');
INSERT INTO `cc_sys_log` VALUES ('5', '保存角色信息', 'info', '/role/ajax_save_role.do', 'POST', '{\"roleRemark\":\"\",\"roleId\":\"53\",\"roleName\":\"普通用户\",\"roleStatus\":\"0\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:25:54', '11');
INSERT INTO `cc_sys_log` VALUES ('6', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:26:06', '58');
INSERT INTO `cc_sys_log` VALUES ('7', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 16:27:13', '73');
INSERT INTO `cc_sys_log` VALUES ('8', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jktqi\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:30:02', '5');
INSERT INTO `cc_sys_log` VALUES ('9', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"seycj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:30:09', '21');
INSERT INTO `cc_sys_log` VALUES ('10', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jktqj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:31:37', '3');
INSERT INTO `cc_sys_log` VALUES ('11', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"trudj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:44:42', '8');
INSERT INTO `cc_sys_log` VALUES ('12', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jktqj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:50:23', '4');
INSERT INTO `cc_sys_log` VALUES ('13', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"btifr\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:50:30', '7');
INSERT INTO `cc_sys_log` VALUES ('14', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jktqj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:55:21', '4');
INSERT INTO `cc_sys_log` VALUES ('15', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nswiq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:55:28', '2');
INSERT INTO `cc_sys_log` VALUES ('16', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1b7ho\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-10-31 17:55:35', '16');
INSERT INTO `cc_sys_log` VALUES ('17', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wbvm9\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 09:45:35', '40');
INSERT INTO `cc_sys_log` VALUES ('18', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wbvm9\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 09:57:31', '189');
INSERT INTO `cc_sys_log` VALUES ('19', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ihmnr\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 10:51:26', '8');
INSERT INTO `cc_sys_log` VALUES ('20', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hpauh\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 11:34:27', '7');
INSERT INTO `cc_sys_log` VALUES ('21', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bv9uq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 14:05:07', '34');
INSERT INTO `cc_sys_log` VALUES ('22', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"oar9r\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:26:00', '32');
INSERT INTO `cc_sys_log` VALUES ('23', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:28:43', '83');
INSERT INTO `cc_sys_log` VALUES ('24', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bv9uq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:31:00', '5');
INSERT INTO `cc_sys_log` VALUES ('25', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mfwme\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:31:05', '181');
INSERT INTO `cc_sys_log` VALUES ('26', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bv9uq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:32:38', '2');
INSERT INTO `cc_sys_log` VALUES ('27', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kt1lg\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:32:43', '7');
INSERT INTO `cc_sys_log` VALUES ('28', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bv\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:39:00', '7');
INSERT INTO `cc_sys_log` VALUES ('29', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fhdpq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:39:05', '178');
INSERT INTO `cc_sys_log` VALUES ('30', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"a\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:46:29', '4');
INSERT INTO `cc_sys_log` VALUES ('31', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"axpb9\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:46:33', '1');
INSERT INTO `cc_sys_log` VALUES ('32', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hcezf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 15:46:38', '19');
INSERT INTO `cc_sys_log` VALUES ('33', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bv9uq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 16:28:00', '4');
INSERT INTO `cc_sys_log` VALUES ('34', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"7y5j3\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-01 16:28:12', '17');
INSERT INTO `cc_sys_log` VALUES ('35', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"myvu7\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 09:36:20', '60');
INSERT INTO `cc_sys_log` VALUES ('36', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"y6r5k\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 14:38:53', '33');
INSERT INTO `cc_sys_log` VALUES ('37', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"p7bn7\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 14:43:26', '41');
INSERT INTO `cc_sys_log` VALUES ('38', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vkp21\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 15:06:24', '9');
INSERT INTO `cc_sys_log` VALUES ('39', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"izy5p\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 15:06:30', '209');
INSERT INTO `cc_sys_log` VALUES ('40', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vkp21\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 15:08:05', '5');
INSERT INTO `cc_sys_log` VALUES ('41', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"d74kp\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 15:08:10', '24');
INSERT INTO `cc_sys_log` VALUES ('42', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"FH244\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 15:16:48', '42');
INSERT INTO `cc_sys_log` VALUES ('43', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rvgd8\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 16:14:21', '210');
INSERT INTO `cc_sys_log` VALUES ('44', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rvgd8\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 16:51:18', '198');
INSERT INTO `cc_sys_log` VALUES ('45', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"r\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 17:22:05', '8');
INSERT INTO `cc_sys_log` VALUES ('46', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gfla9\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-07 17:22:14', '230');
INSERT INTO `cc_sys_log` VALUES ('47', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rtfeo\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 09:27:54', '33');
INSERT INTO `cc_sys_log` VALUES ('48', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rtpeo\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 09:40:57', '3');
INSERT INTO `cc_sys_log` VALUES ('49', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qlpcx\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 09:41:03', '17');
INSERT INTO `cc_sys_log` VALUES ('50', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1ankl\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 11:01:14', '22');
INSERT INTO `cc_sys_log` VALUES ('51', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd\",\"userName\":\"测试账户\",\"userId\":\"\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 11:51:33', '17');
INSERT INTO `cc_sys_log` VALUES ('52', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"9\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 11:51:44', '17');
INSERT INTO `cc_sys_log` VALUES ('53', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"157\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 11:51:53', '10');
INSERT INTO `cc_sys_log` VALUES ('54', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd\",\"userName\":\"测试账户\",\"userId\":\"157\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 11:52:57', '8');
INSERT INTO `cc_sys_log` VALUES ('55', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"aexjf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:05:18', '30');
INSERT INTO `cc_sys_log` VALUES ('56', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:08:56', '92');
INSERT INTO `cc_sys_log` VALUES ('57', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"aexjf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:16:45', '9');
INSERT INTO `cc_sys_log` VALUES ('58', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd1\",\"userName\":\"第二个测试账户\",\"userId\":\"\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:30:06', '19');
INSERT INTO `cc_sys_log` VALUES ('59', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:31:27', '17');
INSERT INTO `cc_sys_log` VALUES ('60', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"157\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:34:13', '10');
INSERT INTO `cc_sys_log` VALUES ('61', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd1\",\"userName\":\"第二个测试账户\",\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:41:52', '10');
INSERT INTO `cc_sys_log` VALUES ('62', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:42:20', '9');
INSERT INTO `cc_sys_log` VALUES ('63', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:42:22', '10');
INSERT INTO `cc_sys_log` VALUES ('64', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:42:29', '11');
INSERT INTO `cc_sys_log` VALUES ('65', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd1\",\"userName\":\"第二个测试账户\",\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:54:00', '10');
INSERT INTO `cc_sys_log` VALUES ('66', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 14:54:07', '12');
INSERT INTO `cc_sys_log` VALUES ('67', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2sdbr\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 16:57:39', '17');
INSERT INTO `cc_sys_log` VALUES ('68', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd1\",\"userName\":\"第二个测试账户\",\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 16:58:28', '16');
INSERT INTO `cc_sys_log` VALUES ('69', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"158\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 16:58:40', '13');
INSERT INTO `cc_sys_log` VALUES ('70', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-08 17:17:40', '121');
INSERT INTO `cc_sys_log` VALUES ('71', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"orz7g\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-13 17:17:27', '42');
INSERT INTO `cc_sys_log` VALUES ('72', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rj3ad\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 09:39:27', '41');
INSERT INTO `cc_sys_log` VALUES ('73', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"l8fap\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 11:54:43', '33');
INSERT INTO `cc_sys_log` VALUES ('74', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"68xeh\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 13:41:31', '7');
INSERT INTO `cc_sys_log` VALUES ('75', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ZBNDK\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 17:13:50', '34');
INSERT INTO `cc_sys_log` VALUES ('76', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ZBNDK\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 17:13:50', '6');
INSERT INTO `cc_sys_log` VALUES ('77', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-14 17:15:08', '95');
INSERT INTO `cc_sys_log` VALUES ('78', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dcubv\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 10:13:55', '35');
INSERT INTO `cc_sys_log` VALUES ('79', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"v7oj5\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 11:32:19', '195');
INSERT INTO `cc_sys_log` VALUES ('80', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xjtay\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 14:04:27', '20');
INSERT INTO `cc_sys_log` VALUES ('81', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd\",\"userName\":\"用户\",\"userId\":\"\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 14:04:57', '10');
INSERT INTO `cc_sys_log` VALUES ('82', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd\",\"userName\":\"用户\",\"userId\":\"\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 14:05:02', '7');
INSERT INTO `cc_sys_log` VALUES ('83', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vzm6f\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 14:24:38', '42');
INSERT INTO `cc_sys_log` VALUES ('84', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"icw4n\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 15:21:10', '35');
INSERT INTO `cc_sys_log` VALUES ('85', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 15:21:22', '100');
INSERT INTO `cc_sys_log` VALUES ('86', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"1\",\"num\":\"10\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 15:45:32', '63');
INSERT INTO `cc_sys_log` VALUES ('87', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"1\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 15:45:48', '6');
INSERT INTO `cc_sys_log` VALUES ('88', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"1\",\"num\":\"1\",\"mineral\":\"1\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 15:47:21', '7');
INSERT INTO `cc_sys_log` VALUES ('89', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"6msts\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 16:55:24', '47');
INSERT INTO `cc_sys_log` VALUES ('90', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 16:55:43', '58');
INSERT INTO `cc_sys_log` VALUES ('91', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 16:56:14', '25');
INSERT INTO `cc_sys_log` VALUES ('92', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:07:06', '93');
INSERT INTO `cc_sys_log` VALUES ('93', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:08:54', '497');
INSERT INTO `cc_sys_log` VALUES ('94', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"100\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:21:21', '45');
INSERT INTO `cc_sys_log` VALUES ('95', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"100\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:22:51', '28');
INSERT INTO `cc_sys_log` VALUES ('96', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"100\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:25:56', '149');
INSERT INTO `cc_sys_log` VALUES ('97', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:27:25', '35');
INSERT INTO `cc_sys_log` VALUES ('98', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"10\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:28:36', '137');
INSERT INTO `cc_sys_log` VALUES ('99', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"10\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:48:04', '46');
INSERT INTO `cc_sys_log` VALUES ('100', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:51:48', '39');
INSERT INTO `cc_sys_log` VALUES ('101', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:53:20', '42');
INSERT INTO `cc_sys_log` VALUES ('102', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:54:53', '529');
INSERT INTO `cc_sys_log` VALUES ('103', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"100\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-15 17:55:41', '2262');
INSERT INTO `cc_sys_log` VALUES ('104', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qav8q\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-18 10:27:24', '47');
INSERT INTO `cc_sys_log` VALUES ('105', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"10\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-18 10:28:06', '310');
INSERT INTO `cc_sys_log` VALUES ('106', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5ixn6\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-18 11:24:58', '9');
INSERT INTO `cc_sys_log` VALUES ('107', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"y2bg8\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 10:23:08', '34');
INSERT INTO `cc_sys_log` VALUES ('108', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 10:23:23', '736');
INSERT INTO `cc_sys_log` VALUES ('109', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hbrnf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 11:48:28', '34');
INSERT INTO `cc_sys_log` VALUES ('110', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 11:49:42', '128');
INSERT INTO `cc_sys_log` VALUES ('111', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"j9idv\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 14:03:28', '9');
INSERT INTO `cc_sys_log` VALUES ('112', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 14:30:58', '372');
INSERT INTO `cc_sys_log` VALUES ('113', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 14:39:23', '504');
INSERT INTO `cc_sys_log` VALUES ('114', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"20\",\"mineral\":\"300\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 14:52:46', '834');
INSERT INTO `cc_sys_log` VALUES ('115', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"6veok\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 15:49:36', '35');
INSERT INTO `cc_sys_log` VALUES ('116', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"cua38\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-21 17:21:11', '28');
INSERT INTO `cc_sys_log` VALUES ('117', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"as6to\",\"username\":\"admin\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:12:08', '66');
INSERT INTO `cc_sys_log` VALUES ('118', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"100\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:13:11', '3298');
INSERT INTO `cc_sys_log` VALUES ('119', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"100\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:13:40', '3059');
INSERT INTO `cc_sys_log` VALUES ('120', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"100\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:13:53', '3031');
INSERT INTO `cc_sys_log` VALUES ('121', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"700\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:15:40', '21696');
INSERT INTO `cc_sys_log` VALUES ('122', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"700\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-22 20:16:02', '21297');
INSERT INTO `cc_sys_log` VALUES ('123', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wkb6i\",\"username\":\"admin\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-23 17:14:53', '45');
INSERT INTO `cc_sys_log` VALUES ('124', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"挖哈哈腕力球\",\"num\":\"150\",\"mineral\":\"298\"}', null, 'admin', '192.168.1.103', 'XX 内网IP', '2019-11-23 17:15:24', '6068');
INSERT INTO `cc_sys_log` VALUES ('125', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"psrf3\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-25 15:54:37', '228');
INSERT INTO `cc_sys_log` VALUES ('126', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2j4rv\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-25 16:40:16', '209');
INSERT INTO `cc_sys_log` VALUES ('127', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"sfl1e\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-11-25 17:34:26', '39');
INSERT INTO `cc_sys_log` VALUES ('128', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"feqbt\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-11-26 11:08:09', '94');
INSERT INTO `cc_sys_log` VALUES ('129', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"botkh\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 17:26:31', '64');
INSERT INTO `cc_sys_log` VALUES ('130', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"botkh\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 17:26:52', '34');
INSERT INTO `cc_sys_log` VALUES ('131', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"botkh\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 17:27:45', '195');
INSERT INTO `cc_sys_log` VALUES ('132', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yqzbg\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:00:02', '76');
INSERT INTO `cc_sys_log` VALUES ('133', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qkpr1\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:01:38', '28');
INSERT INTO `cc_sys_log` VALUES ('134', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ruofj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:41:35', '59');
INSERT INTO `cc_sys_log` VALUES ('135', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"7j3yu\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:44:25', '10');
INSERT INTO `cc_sys_log` VALUES ('136', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"iuef1\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:45:06', '2');
INSERT INTO `cc_sys_log` VALUES ('137', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ejrx8\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:45:11', '10');
INSERT INTO `cc_sys_log` VALUES ('138', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ingma\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-28 18:51:31', '14');
INSERT INTO `cc_sys_log` VALUES ('139', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ng8vm\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 09:31:51', '81');
INSERT INTO `cc_sys_log` VALUES ('140', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ng8vm\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 09:32:43', '36');
INSERT INTO `cc_sys_log` VALUES ('141', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ng8vm\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 09:40:11', '71');
INSERT INTO `cc_sys_log` VALUES ('142', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ng8vm\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 09:45:16', '35');
INSERT INTO `cc_sys_log` VALUES ('143', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5boo4\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 11:01:04', '227');
INSERT INTO `cc_sys_log` VALUES ('144', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"w5ou5\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 11:05:32', '37');
INSERT INTO `cc_sys_log` VALUES ('145', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bxkug\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 15:39:32', '41');
INSERT INTO `cc_sys_log` VALUES ('146', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nqp5v\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 16:30:22', '71');
INSERT INTO `cc_sys_log` VALUES ('147', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gdcxn\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 16:33:22', '12');
INSERT INTO `cc_sys_log` VALUES ('148', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 16:33:41', '181');
INSERT INTO `cc_sys_log` VALUES ('149', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"trpp9\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-11-29 17:16:59', '208');
INSERT INTO `cc_sys_log` VALUES ('150', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1rhxb\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-12-02 09:22:03', '92');
INSERT INTO `cc_sys_log` VALUES ('151', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"keavm\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-12-02 11:05:32', '61');
INSERT INTO `cc_sys_log` VALUES ('152', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bu1sc\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 11:38:59', '40');
INSERT INTO `cc_sys_log` VALUES ('153', '失效矿卡', 'info', '/gameMineral/ajax_mineralCode_fail.do', 'POST', '{\"mineralCodeId\":\"1\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 11:39:14', '40');
INSERT INTO `cc_sys_log` VALUES ('154', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 11:45:51', '329');
INSERT INTO `cc_sys_log` VALUES ('155', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mwvbx\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 14:25:03', '69');
INSERT INTO `cc_sys_log` VALUES ('156', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mwvbx\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 14:32:49', '42');
INSERT INTO `cc_sys_log` VALUES ('157', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 14:38:06', '735');
INSERT INTO `cc_sys_log` VALUES ('158', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mwvbx\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 14:40:34', '210');
INSERT INTO `cc_sys_log` VALUES ('159', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"QGTHV\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 15:02:27', '25');
INSERT INTO `cc_sys_log` VALUES ('160', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jwstf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 16:43:25', '43');
INSERT INTO `cc_sys_log` VALUES ('161', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jwstf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 16:45:27', '209');
INSERT INTO `cc_sys_log` VALUES ('162', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jwstf\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 16:47:30', '41');
INSERT INTO `cc_sys_log` VALUES ('163', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jhj9n\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 18:29:53', '36');
INSERT INTO `cc_sys_log` VALUES ('164', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jhj9n\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 18:29:52', '225');
INSERT INTO `cc_sys_log` VALUES ('165', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fef4o\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-02 18:41:18', '231');
INSERT INTO `cc_sys_log` VALUES ('166', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"tfjuc\",\"username\":\"user_1\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 14:23:40', '58');
INSERT INTO `cc_sys_log` VALUES ('167', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yi1jk\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 14:30:22', '62');
INSERT INTO `cc_sys_log` VALUES ('168', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 14:33:23', '59');
INSERT INTO `cc_sys_log` VALUES ('169', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ogfxe\",\"username\":\"user_1\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 14:34:29', '39');
INSERT INTO `cc_sys_log` VALUES ('170', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ugmsv\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 14:36:14', '36');
INSERT INTO `cc_sys_log` VALUES ('171', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:12:28', '210');
INSERT INTO `cc_sys_log` VALUES ('172', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ix4om\",\"username\":\"user_1\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:12:55', '36');
INSERT INTO `cc_sys_log` VALUES ('173', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:13:16', '68');
INSERT INTO `cc_sys_log` VALUES ('174', '失效矿卡', 'info', '/gameMineral/ajax_mineralCode_fail.do', 'POST', '{\"mineralCodeId\":\"2\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:13:21', '14');
INSERT INTO `cc_sys_log` VALUES ('175', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"4eqan\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:14:46', '39');
INSERT INTO `cc_sys_log` VALUES ('176', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ysvfy\",\"username\":\"user_1\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:16:51', '38');
INSERT INTO `cc_sys_log` VALUES ('177', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nnhdj\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:17:35', '34');
INSERT INTO `cc_sys_log` VALUES ('178', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:24:44', '177');
INSERT INTO `cc_sys_log` VALUES ('179', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yjlcb\",\"username\":\"user_1\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:25:02', '8');
INSERT INTO `cc_sys_log` VALUES ('180', '保存矿卡', 'info', '/gameMineral/ajax_save_mineralCode.do', 'POST', '{\"mineralCodeDesc\":\"测试商品矿卡\",\"num\":\"1\",\"mineral\":\"300\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:25:43', '31');
INSERT INTO `cc_sys_log` VALUES ('181', '失效矿卡', 'info', '/gameMineral/ajax_mineralCode_fail.do', 'POST', '{\"mineralCodeId\":\"1351\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:26:06', '12');
INSERT INTO `cc_sys_log` VALUES ('182', '失效矿卡', 'info', '/gameMineral/ajax_mineralCode_fail.do', 'POST', '{\"mineralCodeId\":\"1352\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:26:11', '13');
INSERT INTO `cc_sys_log` VALUES ('183', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"a4osi\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:27:38', '37');
INSERT INTO `cc_sys_log` VALUES ('184', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:33:10', '217');
INSERT INTO `cc_sys_log` VALUES ('185', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"asdasd2\",\"userName\":\"测试账户二\",\"userId\":\"\"}', null, 'user_1', '192.168.1.102', 'XX 内网IP', '2019-12-03 15:34:18', '23');
INSERT INTO `cc_sys_log` VALUES ('186', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"j9idn\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-12-04 11:58:59', '54');
INSERT INTO `cc_sys_log` VALUES ('187', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ojibl\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', null, '2019-12-04 14:01:31', '34');
INSERT INTO `cc_sys_log` VALUES ('188', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"c1fuq\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-04 15:43:43', '206');
INSERT INTO `cc_sys_log` VALUES ('189', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qk6jo\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-04 16:55:03', '58');
INSERT INTO `cc_sys_log` VALUES ('190', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kzy11\",\"username\":\"admin\"}', null, 'admin', '192.168.1.102', 'XX 内网IP', '2019-12-10 14:14:39', '60');
INSERT INTO `cc_sys_log` VALUES ('191', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dyop3\",\"username\":\"admin\"}', null, 'admin', '175.0.119.146', '湖南 长沙', '2019-12-10 16:34:17', '98');
INSERT INTO `cc_sys_log` VALUES ('192', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"U7HUi\",\"username\":\"admin\"}', null, 'admin', '222.244.180.233', '湖南 长沙', '2019-12-12 16:52:13', '4');
INSERT INTO `cc_sys_log` VALUES ('193', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mb1jz\",\"username\":\"admin\"}', null, 'admin', '113.246.118.219', '湖南 长沙', '2019-12-21 13:58:50', '10');
INSERT INTO `cc_sys_log` VALUES ('194', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yihsy\",\"username\":\"admin\"}', null, 'admin', '113.246.117.123', '湖南 长沙', '2019-12-24 15:34:56', '7');
INSERT INTO `cc_sys_log` VALUES ('195', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1a7pD\",\"username\":\"admin\"}', null, 'admin', '59.51.85.10', '湖南 衡阳', '2019-12-25 13:35:01', '6');
INSERT INTO `cc_sys_log` VALUES ('196', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"labfh\",\"username\":\"admin\"}', null, 'admin', '47.56.83.178', '香港 XX', '2019-12-26 15:04:06', '7');
INSERT INTO `cc_sys_log` VALUES ('197', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"t64az\",\"username\":\"admin\"}', null, 'admin', '47.56.83.178', '香港 XX', '2019-12-26 16:27:38', '4');
INSERT INTO `cc_sys_log` VALUES ('198', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kwojr\",\"username\":\"admin\"}', null, 'admin', '113.246.118.85', '湖南 长沙', '2019-12-26 16:39:24', '3');
INSERT INTO `cc_sys_log` VALUES ('199', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wrwlc\",\"username\":\"admin\"}', null, 'admin', '110.53.228.37', '湖南 长沙', '2019-12-30 12:12:12', '8');
INSERT INTO `cc_sys_log` VALUES ('200', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3jadp\",\"username\":\"admin\"}', null, 'admin', '118.250.142.208', '湖南 长沙', '2019-12-31 11:15:34', '7');
INSERT INTO `cc_sys_log` VALUES ('201', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"na7q6\",\"username\":\"admin\"}', null, 'admin', '118.250.142.208', '湖南 长沙', '2019-12-31 11:28:09', '4');
INSERT INTO `cc_sys_log` VALUES ('202', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3tcej\",\"username\":\"admin\"}', null, 'admin', '220.202.215.189', '湖南 长沙', '2019-12-31 21:35:04', '7');
INSERT INTO `cc_sys_log` VALUES ('203', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"8y9qx\",\"username\":\"admin\"}', null, 'admin', '220.202.215.189', '湖南 长沙', '2019-12-31 22:10:43', '3');
INSERT INTO `cc_sys_log` VALUES ('204', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"s7jtt\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-01 14:18:05', '325');
INSERT INTO `cc_sys_log` VALUES ('205', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wc9oe\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-01 14:55:49', '164');
INSERT INTO `cc_sys_log` VALUES ('206', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"94kgg\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-01 15:09:09', '165');
INSERT INTO `cc_sys_log` VALUES ('207', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nstcd\",\"username\":\"admin\"}', null, 'admin', '220.202.215.189', '湖南 长沙', '2020-01-01 15:22:20', '34');
INSERT INTO `cc_sys_log` VALUES ('208', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ylana\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 10:58:45', '9');
INSERT INTO `cc_sys_log` VALUES ('209', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"CHacX\",\"username\":\"admin\"}', null, 'admin', '47.56.83.178', '香港 XX', '2020-01-02 11:44:17', '5');
INSERT INTO `cc_sys_log` VALUES ('210', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nn8ft\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 11:45:25', '5');
INSERT INTO `cc_sys_log` VALUES ('211', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"uccdh\",\"username\":\"admin\"}', null, 'admin', '222.240.107.134', '湖南 长沙', '2020-01-02 11:47:39', '5');
INSERT INTO `cc_sys_log` VALUES ('212', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"msk1f\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 12:33:25', '4');
INSERT INTO `cc_sys_log` VALUES ('213', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"m5257\",\"username\":\"admin\"}', null, 'admin', '222.240.107.134', '湖南 长沙', '2020-01-02 13:35:38', '4');
INSERT INTO `cc_sys_log` VALUES ('214', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wqm9e\",\"username\":\"admin\"}', null, 'admin', '222.240.107.134', '湖南 长沙', '2020-01-02 14:46:14', '4');
INSERT INTO `cc_sys_log` VALUES ('215', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3XF6G\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 16:13:06', '3');
INSERT INTO `cc_sys_log` VALUES ('216', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"sivdm\",\"username\":\"admin\"}', null, 'admin', '222.240.107.134', '湖南 长沙', '2020-01-02 16:45:49', '4');
INSERT INTO `cc_sys_log` VALUES ('217', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kwttb\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 17:37:40', '4');
INSERT INTO `cc_sys_log` VALUES ('218', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"FHYIG\",\"username\":\"admin\"}', null, 'admin', '222.240.107.134', '湖南 长沙', '2020-01-02 18:02:40', '3');
INSERT INTO `cc_sys_log` VALUES ('219', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ae8pq\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 21:07:27', '3');
INSERT INTO `cc_sys_log` VALUES ('220', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1szio\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 21:17:33', '3');
INSERT INTO `cc_sys_log` VALUES ('221', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ijhbe\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 21:20:50', '4');
INSERT INTO `cc_sys_log` VALUES ('222', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"69nbe\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 21:21:34', '3');
INSERT INTO `cc_sys_log` VALUES ('223', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"sw2of\",\"username\":\"admin\"}', null, 'admin', '222.244.183.183', '湖南 长沙', '2020-01-02 21:22:22', '3');
INSERT INTO `cc_sys_log` VALUES ('224', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3QdwF\",\"username\":\"admin\"}', null, 'admin', '220.202.233.11', '湖南 长沙', '2020-01-03 10:42:28', '8');
INSERT INTO `cc_sys_log` VALUES ('225', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"SUJXN\",\"username\":\"admin\"}', null, 'admin', '220.202.233.11', '湖南 长沙', '2020-01-03 11:11:23', '4');
INSERT INTO `cc_sys_log` VALUES ('226', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"tqcqr\",\"username\":\"admin\"}', null, 'admin', '220.202.233.11', '湖南 长沙', '2020-01-03 11:38:01', '3');
INSERT INTO `cc_sys_log` VALUES ('227', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"PKEYP\",\"username\":\"admin\"}', null, 'admin', '113.246.232.192', '湖南 长沙', '2020-01-03 17:33:09', '3');
INSERT INTO `cc_sys_log` VALUES ('228', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"chari\",\"username\":\"admin\"}', null, 'admin', '113.246.232.192', '湖南 长沙', '2020-01-03 17:57:12', '1');
INSERT INTO `cc_sys_log` VALUES ('229', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"sckm8\",\"username\":\"admin\"}', null, 'admin', '113.246.232.192', '湖南 长沙', '2020-01-03 17:57:19', '3');
INSERT INTO `cc_sys_log` VALUES ('230', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"QKHNX\",\"username\":\"admin\"}', null, 'admin', '113.246.232.192', '湖南 长沙', '2020-01-04 14:33:33', '7');
INSERT INTO `cc_sys_log` VALUES ('231', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3tqsz\",\"username\":\"admin\"}', null, 'admin', '113.246.233.55', '湖南 长沙', '2020-01-04 16:46:55', '3');
INSERT INTO `cc_sys_log` VALUES ('232', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3x4vw\",\"username\":\"admin\"}', null, 'admin', '222.240.41.19', '湖南 长沙', '2020-01-04 18:35:21', '3');
INSERT INTO `cc_sys_log` VALUES ('233', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"R3XU2\",\"username\":\"admin\"}', null, 'admin', '113.246.116.1', '湖南 长沙', '2020-01-05 13:43:27', '8');
INSERT INTO `cc_sys_log` VALUES ('234', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"r62rx\",\"username\":\"admin\"}', null, 'admin', '220.202.233.11', '湖南 长沙', '2020-01-06 13:26:56', '7');
INSERT INTO `cc_sys_log` VALUES ('235', '保存用户信息', 'info', '/gameManagerSystem/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"12312312312\",\"userName\":\"张三\",\"userId\":\"\"}', null, 'admin', '113.246.116.1', '湖南 长沙', '2020-01-06 15:26:48', '6');
INSERT INTO `cc_sys_log` VALUES ('236', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3acte\",\"username\":\"admin\"}', null, 'admin', '222.240.105.35', '湖南 长沙', '2020-01-07 11:22:55', '7');
INSERT INTO `cc_sys_log` VALUES ('237', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hj63n\",\"username\":\"admin\"}', null, 'admin', '222.240.105.35', '湖南 长沙', '2020-01-07 14:17:06', '3');
INSERT INTO `cc_sys_log` VALUES ('238', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ucq48\",\"username\":\"admin\"}', null, 'admin', '222.240.105.35', '湖南 长沙', '2020-01-07 17:07:22', '3');
INSERT INTO `cc_sys_log` VALUES ('239', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"V341L\",\"username\":\"admin\"}', null, 'admin', '220.202.233.11', '湖南 长沙', '2020-01-08 12:33:16', '3');
INSERT INTO `cc_sys_log` VALUES ('240', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"chk3z\",\"username\":\"admin\"}', null, 'admin', '220.202.199.4', '湖南 长沙', '2020-01-08 15:05:17', '3');
INSERT INTO `cc_sys_log` VALUES ('241', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"cpnsl\",\"username\":\"admin\"}', null, 'admin', '220.202.199.4', '湖南 长沙', '2020-01-09 12:09:10', '7');
INSERT INTO `cc_sys_log` VALUES ('242', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"oxvuk\",\"username\":\"admin\"}', null, 'admin', '222.240.104.238', '湖南 长沙', '2020-01-09 13:46:47', '3');
INSERT INTO `cc_sys_log` VALUES ('243', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2yku3\",\"username\":\"admin\"}', null, 'admin', '220.202.199.4', '湖南 长沙', '2020-01-09 14:13:12', '2');
INSERT INTO `cc_sys_log` VALUES ('244', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"oz1gq\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 14:17:33', '187');
INSERT INTO `cc_sys_log` VALUES ('245', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rdbkw\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 14:57:11', '282');
INSERT INTO `cc_sys_log` VALUES ('246', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xutge\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 16:01:52', '158');
INSERT INTO `cc_sys_log` VALUES ('247', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"lmnj2\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 17:08:29', '145');
INSERT INTO `cc_sys_log` VALUES ('248', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5vnxd\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 17:59:36', '164');
INSERT INTO `cc_sys_log` VALUES ('249', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bhq33\",\"username\":\"admin\"}', null, 'admin', '192.168.0.102', 'XX 内网IP', '2020-01-09 18:41:00', '158');
INSERT INTO `cc_sys_log` VALUES ('250', '用户登陆', 'info', '/gameManagerSystem/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"czchs\",\"username\":\"admin\"}', null, 'admin', '220.202.199.4', '湖南 长沙', '2020-01-09 19:01:20', '42');
INSERT INTO `cc_sys_log` VALUES ('251', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"EEX2F\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-01-26 18:12:19', '563');
INSERT INTO `cc_sys_log` VALUES ('252', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.2.203', null, '2021-01-26 18:31:07', '37');
INSERT INTO `cc_sys_log` VALUES ('253', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"52\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-01-26 18:32:50', '40');
INSERT INTO `cc_sys_log` VALUES ('254', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xmdoe\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-01-31 14:43:47', '27');
INSERT INTO `cc_sys_log` VALUES ('255', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"skfta\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 17:36:32', '687');
INSERT INTO `cc_sys_log` VALUES ('256', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5oopa\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 17:44:30', '73');
INSERT INTO `cc_sys_log` VALUES ('257', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5oopa\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 18:15:17', '9');
INSERT INTO `cc_sys_log` VALUES ('258', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5oopa\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 18:20:07', '9');
INSERT INTO `cc_sys_log` VALUES ('259', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5oopa\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 18:21:03', '12');
INSERT INTO `cc_sys_log` VALUES ('260', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"lia6z\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-02 18:24:40', '10');
INSERT INTO `cc_sys_log` VALUES ('261', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"l8owi\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 10:43:50', '640');
INSERT INTO `cc_sys_log` VALUES ('262', '失效用户信息', 'info', '/user/ajax_user_fail.do', 'POST', '{\"userId\":\"10\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 11:40:03', '20');
INSERT INTO `cc_sys_log` VALUES ('263', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nr6wq\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 13:20:10', '72');
INSERT INTO `cc_sys_log` VALUES ('264', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"c8kiu\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 13:54:11', '71');
INSERT INTO `cc_sys_log` VALUES ('265', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ko67b\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 14:05:46', '74');
INSERT INTO `cc_sys_log` VALUES ('266', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"eave3\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 14:09:59', '68');
INSERT INTO `cc_sys_log` VALUES ('267', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"czqnd\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 14:25:38', '71');
INSERT INTO `cc_sys_log` VALUES ('268', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gnnko\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 14:31:44', '71');
INSERT INTO `cc_sys_log` VALUES ('269', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rx3do\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 15:15:24', '36');
INSERT INTO `cc_sys_log` VALUES ('270', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"brevu\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 15:38:26', '73');
INSERT INTO `cc_sys_log` VALUES ('271', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"utl19\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 15:43:27', '61');
INSERT INTO `cc_sys_log` VALUES ('272', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"k894v\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 15:53:04', '71');
INSERT INTO `cc_sys_log` VALUES ('273', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rzxbd\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 15:59:42', '60');
INSERT INTO `cc_sys_log` VALUES ('274', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"mng001\",\"userName\":\"系统管理员\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:26:14', '18');
INSERT INTO `cc_sys_log` VALUES ('275', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"\",\"userId\":\"161\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:26:32', '11');
INSERT INTO `cc_sys_log` VALUES ('276', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"userLoginName\":\"user001\",\"userName\":\"yeah001\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:28:39', '10');
INSERT INTO `cc_sys_log` VALUES ('277', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"\",\"userId\":\"162\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:29:05', '6');
INSERT INTO `cc_sys_log` VALUES ('278', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53\",\"userId\":\"162\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:29:33', '11');
INSERT INTO `cc_sys_log` VALUES ('279', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52\",\"userId\":\"161\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:29:44', '8');
INSERT INTO `cc_sys_log` VALUES ('280', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52,51\",\"userId\":\"161\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:29:56', '12');
INSERT INTO `cc_sys_log` VALUES ('281', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"6ygof\",\"username\":\"mng001\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:31:13', '16');
INSERT INTO `cc_sys_log` VALUES ('282', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"51\",\"userId\":\"162\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:31:51', '10');
INSERT INTO `cc_sys_log` VALUES ('283', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52\",\"userId\":\"161\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:40:04', '21');
INSERT INTO `cc_sys_log` VALUES ('284', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53\",\"userId\":\"162\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:40:16', '9');
INSERT INTO `cc_sys_log` VALUES ('285', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bvdom\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:43:42', '8');
INSERT INTO `cc_sys_log` VALUES ('286', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"52\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:45:35', '64');
INSERT INTO `cc_sys_log` VALUES ('287', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rh6pd\",\"username\":\"mng001\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:46:22', '9');
INSERT INTO `cc_sys_log` VALUES ('288', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"uybn9\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:47:34', '8');
INSERT INTO `cc_sys_log` VALUES ('289', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"lbyjr\",\"username\":\"mng001\"}', null, 'mng001', '192.168.2.203', null, '2021-02-19 16:53:21', '8');
INSERT INTO `cc_sys_log` VALUES ('290', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"52\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-19 16:55:03', '48');
INSERT INTO `cc_sys_log` VALUES ('291', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ow9us\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 12:37:02', '600');
INSERT INTO `cc_sys_log` VALUES ('292', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ijkuw\",\"username\":\"user001\"}', null, 'user001', '192.168.2.203', null, '2021-02-25 13:12:13', '10');
INSERT INTO `cc_sys_log` VALUES ('293', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"n8dtu\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 13:18:12', '20');
INSERT INTO `cc_sys_log` VALUES ('294', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gmtcn\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 14:26:01', '74');
INSERT INTO `cc_sys_log` VALUES ('295', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53,52,51\",\"userId\":\"162\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 14:26:32', '25');
INSERT INTO `cc_sys_log` VALUES ('296', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"52,53,51\",\"userId\":\"162\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 14:26:47', '14');
INSERT INTO `cc_sys_log` VALUES ('297', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53\",\"userId\":\"162\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 14:26:55', '12');
INSERT INTO `cc_sys_log` VALUES ('298', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"b6ama\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:20:08', '18');
INSERT INTO `cc_sys_log` VALUES ('299', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jihsj\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:23:32', '33');
INSERT INTO `cc_sys_log` VALUES ('300', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jihsj\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:23:19', '12722');
INSERT INTO `cc_sys_log` VALUES ('301', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18692275790\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:23:53', '21012');
INSERT INTO `cc_sys_log` VALUES ('302', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"jjrbq\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:28:07', '71');
INSERT INTO `cc_sys_log` VALUES ('303', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18692275790\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:28:27', '112');
INSERT INTO `cc_sys_log` VALUES ('304', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18692275790\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:28:33', '19');
INSERT INTO `cc_sys_log` VALUES ('305', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xwjmb\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:32:05', '92');
INSERT INTO `cc_sys_log` VALUES ('306', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"atd8f\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:55:52', '20');
INSERT INTO `cc_sys_log` VALUES ('307', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"8790071999\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:56:23', '124');
INSERT INTO `cc_sys_log` VALUES ('308', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rlsis\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 15:58:58', '104');
INSERT INTO `cc_sys_log` VALUES ('309', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"8790071999\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:00:38', '37102');
INSERT INTO `cc_sys_log` VALUES ('310', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"brsgh\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:08:45', '83');
INSERT INTO `cc_sys_log` VALUES ('311', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"8790071999\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:08:57', '17');
INSERT INTO `cc_sys_log` VALUES ('312', '保存用户信息', 'info', '/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18692275790\",\"wechat\":\"18692275790\",\"userLoginName\":\"user002\",\"userName\":\"yeah002\",\"userId\":\"168\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:11:11', '16');
INSERT INTO `cc_sys_log` VALUES ('313', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"\",\"userId\":\"168\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:13:39', '14');
INSERT INTO `cc_sys_log` VALUES ('314', '用户分配角色', 'info', '/user/ajax_save_user_role.do', 'POST', '{\"roleIds\":\"53\",\"userId\":\"168\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 16:13:53', '12');
INSERT INTO `cc_sys_log` VALUES ('315', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"6k1jn\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 17:07:31', '67');
INSERT INTO `cc_sys_log` VALUES ('316', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5aghr\",\"username\":\"user002\"}', null, 'user002', '192.168.2.203', null, '2021-02-25 17:11:56', '84');
INSERT INTO `cc_sys_log` VALUES ('317', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"43dl2\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 17:12:24', '11');
INSERT INTO `cc_sys_log` VALUES ('318', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 17:13:39', '43');
INSERT INTO `cc_sys_log` VALUES ('319', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nynxa\",\"username\":\"user002\"}', null, 'user002', '192.168.2.203', null, '2021-02-25 17:13:55', '10');
INSERT INTO `cc_sys_log` VALUES ('320', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rp3kg\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 18:47:50', '25');
INSERT INTO `cc_sys_log` VALUES ('321', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rp3kg\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 18:47:49', '104');
INSERT INTO `cc_sys_log` VALUES ('322', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rp3kg\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 18:47:50', '32');
INSERT INTO `cc_sys_log` VALUES ('323', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"w5tku\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 18:51:02', '104');
INSERT INTO `cc_sys_log` VALUES ('324', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"afkdv\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 19:10:09', '81');
INSERT INTO `cc_sys_log` VALUES ('325', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fkjmz\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 19:44:31', '77');
INSERT INTO `cc_sys_log` VALUES ('326', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"oe88g\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:33:40', '60');
INSERT INTO `cc_sys_log` VALUES ('327', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dxovk\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:35:43', '73');
INSERT INTO `cc_sys_log` VALUES ('328', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vlbli\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:38:43', '87');
INSERT INTO `cc_sys_log` VALUES ('329', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"lhcmf\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:45:10', '100');
INSERT INTO `cc_sys_log` VALUES ('330', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kitew\",\"username\":\"user001\"}', null, 'user001', '192.168.2.203', null, '2021-02-25 20:46:54', '11');
INSERT INTO `cc_sys_log` VALUES ('331', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3ylkb\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:47:12', '11');
INSERT INTO `cc_sys_log` VALUES ('332', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:47:28', '45');
INSERT INTO `cc_sys_log` VALUES ('333', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nuohv\",\"username\":\"user001\"}', null, 'user001', '192.168.2.203', null, '2021-02-25 20:47:43', '10');
INSERT INTO `cc_sys_log` VALUES ('334', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"e4rgn\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 20:49:41', '10');
INSERT INTO `cc_sys_log` VALUES ('335', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"tesoh\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-25 21:14:10', '80');
INSERT INTO `cc_sys_log` VALUES ('336', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"u5igw\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 14:01:37', '73');
INSERT INTO `cc_sys_log` VALUES ('337', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hzmxn\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 14:30:39', '72');
INSERT INTO `cc_sys_log` VALUES ('338', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"cow78\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 14:51:10', '72');
INSERT INTO `cc_sys_log` VALUES ('339', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"b9vyq\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 14:53:15', '111');
INSERT INTO `cc_sys_log` VALUES ('340', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fbbwf\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 15:22:39', '69');
INSERT INTO `cc_sys_log` VALUES ('341', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ptnic\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 15:45:42', '70');
INSERT INTO `cc_sys_log` VALUES ('342', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mao1y\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:10:53', '69');
INSERT INTO `cc_sys_log` VALUES ('343', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:13:15', '113');
INSERT INTO `cc_sys_log` VALUES ('344', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"53\",\"resourceIds[]\":\"57\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:14:13', '24');
INSERT INTO `cc_sys_log` VALUES ('345', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:14:49', '84');
INSERT INTO `cc_sys_log` VALUES ('346', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"52\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:15:11', '44');
INSERT INTO `cc_sys_log` VALUES ('347', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:16:17', '75');
INSERT INTO `cc_sys_log` VALUES ('348', '角色赋权', 'info', '/role/ajax_save_role_res.do', 'POST', '{\"roleId\":\"51\",\"resourceIds[]\":\"7\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 16:17:33', '77');
INSERT INTO `cc_sys_log` VALUES ('349', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zkuf4\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 19:15:51', '38');
INSERT INTO `cc_sys_log` VALUES ('350', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"8ynyl\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 20:58:44', '38');
INSERT INTO `cc_sys_log` VALUES ('351', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"o2cat\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-26 21:03:32', '80');
INSERT INTO `cc_sys_log` VALUES ('352', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rju75\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', 'XX 内网IP', '2021-02-27 15:15:51', '819');
INSERT INTO `cc_sys_log` VALUES ('353', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qysjs\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 16:06:02', '40');
INSERT INTO `cc_sys_log` VALUES ('354', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qtwt9\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 16:08:23', '107');
INSERT INTO `cc_sys_log` VALUES ('355', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mx1t9\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 16:53:01', '79');
INSERT INTO `cc_sys_log` VALUES ('356', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"y1drc\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 17:00:15', '80');
INSERT INTO `cc_sys_log` VALUES ('357', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ra3ji\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', 'XX 内网IP', '2021-02-27 17:36:31', '68');
INSERT INTO `cc_sys_log` VALUES ('358', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"36eub\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 19:10:43', '62');
INSERT INTO `cc_sys_log` VALUES ('359', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mms4c\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 19:17:33', '63');
INSERT INTO `cc_sys_log` VALUES ('360', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"1mdms\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 19:29:53', '71');
INSERT INTO `cc_sys_log` VALUES ('361', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5s26s\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 20:45:19', '62');
INSERT INTO `cc_sys_log` VALUES ('362', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"lbbld\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 20:48:31', '82');
INSERT INTO `cc_sys_log` VALUES ('363', '用户登陆', 'info', '/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"D8mzp\",\"username\":\"admin\"}', null, 'admin', '192.168.2.203', null, '2021-02-27 21:55:26', '14');
INSERT INTO `cc_sys_log` VALUES ('364', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"orcgr\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 22:27:53', '93');
INSERT INTO `cc_sys_log` VALUES ('365', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hdtxs\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 22:47:10', '43');
INSERT INTO `cc_sys_log` VALUES ('366', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hdtxs\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 22:47:59', '7');
INSERT INTO `cc_sys_log` VALUES ('367', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zeokf\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 22:50:00', '7');
INSERT INTO `cc_sys_log` VALUES ('368', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"9ea95\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 23:08:07', '8');
INSERT INTO `cc_sys_log` VALUES ('369', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"tvwp8\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 23:10:17', '1');
INSERT INTO `cc_sys_log` VALUES ('370', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"n84wv\\\\\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 23:10:24', '2');
INSERT INTO `cc_sys_log` VALUES ('371', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rcrfg\",\"username\":\"admin\"}', null, 'admin', '113.246.116.111', null, '2021-02-28 23:10:33', '6');
INSERT INTO `cc_sys_log` VALUES ('372', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"t1iqt\",\"username\":\"admin\"}', null, 'admin', '106.18.73.233', null, '2021-03-01 12:27:13', '15');
INSERT INTO `cc_sys_log` VALUES ('373', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zjcy8\",\"username\":\"admin\"}', null, 'admin', '222.244.181.103', null, '2021-03-02 14:35:20', '12');
INSERT INTO `cc_sys_log` VALUES ('374', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"tejmj\",\"username\":\"admin\"}', null, 'admin', '222.244.181.103', null, '2021-03-02 14:36:45', '6');
INSERT INTO `cc_sys_log` VALUES ('375', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"y5r7y\",\"username\":\"admin\"}', null, 'admin', '18.163.110.25', null, '2021-03-02 14:38:56', '5');
INSERT INTO `cc_sys_log` VALUES ('376', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zsauh\",\"username\":\"admin\"}', null, 'admin', '18.163.110.25', null, '2021-03-02 15:57:33', '5');
INSERT INTO `cc_sys_log` VALUES ('377', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3xmzp\",\"username\":\"admin\"}', null, 'admin', '18.163.110.25', null, '2021-03-02 18:30:13', '5');
INSERT INTO `cc_sys_log` VALUES ('378', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yfkz3\",\"username\":\"admin\"}', null, 'admin', '104.248.152.28', null, '2021-03-02 18:47:53', '4');
INSERT INTO `cc_sys_log` VALUES ('379', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fuudv\",\"username\":\"mng001\"}', null, 'mng001', '18.163.110.25', null, '2021-03-02 18:52:23', '4');
INSERT INTO `cc_sys_log` VALUES ('380', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"qtibp\",\"username\":\"admin\"}', null, 'admin', '104.248.152.28', null, '2021-03-02 19:16:13', '46');
INSERT INTO `cc_sys_log` VALUES ('381', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3op86\",\"username\":\"admin\"}', null, 'admin', '104.248.152.28', null, '2021-03-02 19:16:26', '37');
INSERT INTO `cc_sys_log` VALUES ('382', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"yf7iz\",\"username\":\"admin\"}', null, 'admin', '104.248.152.28', null, '2021-03-02 19:28:25', '89');
INSERT INTO `cc_sys_log` VALUES ('383', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wyxuu\",\"username\":\"mng001\"}', null, 'mng001', '18.163.110.25', null, '2021-03-02 19:34:00', '5');
INSERT INTO `cc_sys_log` VALUES ('384', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vjcnw\",\"username\":\"user001\"}', null, 'user001', '18.163.110.25', null, '2021-03-02 19:35:14', '6');
INSERT INTO `cc_sys_log` VALUES ('385', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2m74c\",\"username\":\"mng001\"}', null, 'mng001', '18.163.110.25', null, '2021-03-02 19:36:08', '4');
INSERT INTO `cc_sys_log` VALUES ('386', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"pggai\",\"username\":\"mng001\"}', null, 'mng001', '18.163.110.25', null, '2021-03-02 19:37:11', '5');
INSERT INTO `cc_sys_log` VALUES ('387', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dbzlr\",\"username\":\"admin\"}', null, 'admin', '18.163.110.25', null, '2021-03-02 19:43:07', '5');
INSERT INTO `cc_sys_log` VALUES ('388', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ddwpe\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-02 22:43:12', '5');
INSERT INTO `cc_sys_log` VALUES ('389', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xjata\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 09:34:58', '5');
INSERT INTO `cc_sys_log` VALUES ('390', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"3asph\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 10:44:20', '4');
INSERT INTO `cc_sys_log` VALUES ('391', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"h9h3a\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:02:50', '5');
INSERT INTO `cc_sys_log` VALUES ('392', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"foc3k\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:34:48', '4');
INSERT INTO `cc_sys_log` VALUES ('393', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"15797711069\",\"wechat\":\"15797711069\",\"userLoginName\":\"15797711069\",\"userName\":\"南昌陈总\",\"userId\":\"\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:36:07', '9');
INSERT INTO `cc_sys_log` VALUES ('394', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dk2qn\",\"username\":\"15797711069\"}', null, '15797711069', '54.255.187.223', null, '2021-03-03 14:36:34', '5');
INSERT INTO `cc_sys_log` VALUES ('395', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"91y51\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:37:46', '4');
INSERT INTO `cc_sys_log` VALUES ('396', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"u2ikr\",\"username\":\"15797711069\"}', null, '15797711069', '182.96.242.202', null, '2021-03-03 14:38:59', '4');
INSERT INTO `cc_sys_log` VALUES ('397', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xc9kk\",\"username\":\"15797711069\"}', null, '15797711069', '54.255.187.223', null, '2021-03-03 14:40:00', '5');
INSERT INTO `cc_sys_log` VALUES ('398', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wgeuh\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:40:37', '5');
INSERT INTO `cc_sys_log` VALUES ('399', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18391832757\",\"wechat\":\"18391832757\",\"userLoginName\":\"18391832757\",\"userName\":\"四川林总\",\"userId\":\"\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:44:12', '9');
INSERT INTO `cc_sys_log` VALUES ('400', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"uhd1h\",\"username\":\"18391832757\"}', null, '18391832757', '45.139.179.184', null, '2021-03-03 14:45:04', '4');
INSERT INTO `cc_sys_log` VALUES ('401', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"4fadr\",\"username\":\"admin\"}', null, 'admin', '18.167.90.251', null, '2021-03-03 14:46:44', '4');
INSERT INTO `cc_sys_log` VALUES ('402', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"pq75p\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 14:50:01', '4');
INSERT INTO `cc_sys_log` VALUES ('403', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18673188911\",\"wechat\":\"18673188911\",\"userLoginName\":\"18673188911\",\"userName\":\"测试号\",\"userId\":\"\"}', null, 'admin', '18.167.90.251', null, '2021-03-03 15:18:51', '6');
INSERT INTO `cc_sys_log` VALUES ('404', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"iei4f\",\"username\":\"18673188911\"}', null, 'admin', '18.167.90.251', null, '2021-03-03 15:20:14', '1');
INSERT INTO `cc_sys_log` VALUES ('405', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"36dar\",\"username\":\"18673188911\"}', null, '18673188911', '18.167.90.251', null, '2021-03-03 15:20:23', '4');
INSERT INTO `cc_sys_log` VALUES ('406', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"9utgk\",\"username\":\"15797711069\"}', null, '15797711069', '182.96.242.202', null, '2021-03-03 16:12:20', '4');
INSERT INTO `cc_sys_log` VALUES ('407', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"oy5xw\",\"username\":\"admin\"}', null, 'admin', '18.167.90.251', null, '2021-03-03 17:52:40', '4');
INSERT INTO `cc_sys_log` VALUES ('408', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"znsgd\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 19:18:13', '4');
INSERT INTO `cc_sys_log` VALUES ('409', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2gsjq\",\"username\":\"admin\"}', null, 'admin', '18.167.90.251', null, '2021-03-03 19:42:37', '4');
INSERT INTO `cc_sys_log` VALUES ('410', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"csilk\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 20:44:46', '3');
INSERT INTO `cc_sys_log` VALUES ('411', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"13271211860\",\"wechat\":\"13271211860\",\"userLoginName\":\"13271211860\",\"userName\":\"河南刘总\",\"userId\":\"\"}', null, 'mng001', '54.255.187.223', null, '2021-03-03 20:45:07', '8');
INSERT INTO `cc_sys_log` VALUES ('412', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dukas\",\"username\":\"admin\"}', null, 'admin', '203.66.45.104', null, '2021-03-03 20:49:35', '4');
INSERT INTO `cc_sys_log` VALUES ('413', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vjk8z\",\"username\":\"admin\"}', null, 'admin', '222.244.181.144', null, '2021-03-03 20:58:22', '47');
INSERT INTO `cc_sys_log` VALUES ('414', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"919wi\",\"username\":\"admin\"}', null, 'admin', '104.248.152.28', null, '2021-03-03 20:59:31', '6');
INSERT INTO `cc_sys_log` VALUES ('415', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"hfgsv\",\"username\":\"15797711069\"}', null, '15797711069', '182.96.242.202', '江西 南昌', '2021-03-04 09:53:03', '6');
INSERT INTO `cc_sys_log` VALUES ('416', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"dyqpp\",\"username\":\"admin\"}', null, 'admin', '18.163.182.180', null, '2021-03-04 16:05:44', '5');
INSERT INTO `cc_sys_log` VALUES ('417', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"px3ch\",\"username\":\"admin\"}', null, 'admin', '18.163.182.180', null, '2021-03-04 16:06:54', '5');
INSERT INTO `cc_sys_log` VALUES ('418', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"5tfyy\",\"username\":\"admin\"}', null, 'admin', '18.163.182.180', null, '2021-03-04 16:07:42', '5');
INSERT INTO `cc_sys_log` VALUES ('419', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"9mnsu\",\"username\":\"mng001\"}', null, 'mng001', '54.255.187.223', null, '2021-03-05 09:45:55', '5');
INSERT INTO `cc_sys_log` VALUES ('420', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"m5azs\",\"username\":\"15797711069\"}', null, '15797711069', '59.53.40.2', null, '2021-03-05 15:23:57', '5');
INSERT INTO `cc_sys_log` VALUES ('421', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"sgjp7\",\"username\":\"15797711069\"}', null, '15797711069', '59.53.40.2', null, '2021-03-05 18:38:05', '5');
INSERT INTO `cc_sys_log` VALUES ('422', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"isixs\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', null, '2021-03-05 21:12:51', '5');
INSERT INTO `cc_sys_log` VALUES ('423', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"18035768397\",\"wechat\":\"18035768397\",\"userLoginName\":\"18035768397\",\"userName\":\"长沙李总\",\"userId\":\"\"}', null, 'mng001', '192.46.215.7', null, '2021-03-05 21:13:14', '11');
INSERT INTO `cc_sys_log` VALUES ('424', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"d5bmz\",\"username\":\"18035768397\"}', null, '18035768397', '117.136.24.162', null, '2021-03-05 21:14:56', '5');
INSERT INTO `cc_sys_log` VALUES ('425', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"abume\",\"username\":\"18035768397\"}', null, '18035768397', '113.240.199.95', null, '2021-03-05 22:24:10', '5');
INSERT INTO `cc_sys_log` VALUES ('426', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"wm2yk\",\"username\":\"18035768397\"}', null, '18035768397', '220.202.152.84', null, '2021-03-05 22:24:23', '5');
INSERT INTO `cc_sys_log` VALUES ('427', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"opkzg\",\"username\":\"18035768397\"}', null, '18035768397', '220.202.152.84', null, '2021-03-05 22:28:24', '5');
INSERT INTO `cc_sys_log` VALUES ('428', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kg9ms\",\"username\":\"18035768397\"}', null, '18035768397', '220.202.152.84', null, '2021-03-05 22:53:31', '5');
INSERT INTO `cc_sys_log` VALUES ('429', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nf6sa\",\"username\":\"18035768397\"}', null, '18035768397', '220.202.152.84', null, '2021-03-06 00:35:16', '7');
INSERT INTO `cc_sys_log` VALUES ('430', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gzs5m\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', null, '2021-03-06 12:58:34', '9');
INSERT INTO `cc_sys_log` VALUES ('431', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"ess5y\",\"username\":\"mng001\"}', null, 'mng001', '113.246.118.25', null, '2021-03-06 13:12:33', '5');
INSERT INTO `cc_sys_log` VALUES ('432', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"fqprs\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', '加利福尼亚 XX', '2021-03-06 15:17:56', '4');
INSERT INTO `cc_sys_log` VALUES ('433', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bmexk\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', null, '2021-03-06 16:25:51', '4');
INSERT INTO `cc_sys_log` VALUES ('434', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"2wlyn\",\"username\":\"admin\"}', null, 'admin', '18.163.103.27', null, '2021-03-07 12:29:49', '12');
INSERT INTO `cc_sys_log` VALUES ('435', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"uocaa\",\"username\":\"15797711069\"}', null, '15797711069', '59.53.40.2', null, '2021-03-07 14:17:53', '4');
INSERT INTO `cc_sys_log` VALUES ('436', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"j7jii\",\"username\":\"admin\"}', null, 'admin', '68.183.185.85', null, '2021-03-07 14:22:22', '4');
INSERT INTO `cc_sys_log` VALUES ('437', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mq8uj\",\"username\":\"18035768397\"}', null, '18035768397', '68.183.185.85', null, '2021-03-07 14:40:25', '4');
INSERT INTO `cc_sys_log` VALUES ('438', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"rvoc6\",\"username\":\"admin\"}', null, 'admin', '68.183.185.85', null, '2021-03-07 14:42:17', '4');
INSERT INTO `cc_sys_log` VALUES ('439', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vpvwl\",\"username\":\"admin\"}', null, 'admin', '18.162.61.37', null, '2021-03-07 17:02:23', '62');
INSERT INTO `cc_sys_log` VALUES ('440', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"o1gpp\",\"username\":\"admin\"}', null, 'admin', '18.162.61.37', null, '2021-03-07 18:08:47', '5');
INSERT INTO `cc_sys_log` VALUES ('441', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zsrxq\",\"username\":\"admin\"}', null, 'admin', '18.163.123.223', null, '2021-03-07 20:03:25', '5');
INSERT INTO `cc_sys_log` VALUES ('442', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nann8\",\"username\":\"18035768397\"}', null, '18035768397', '220.202.152.27', null, '2021-03-07 21:23:50', '5');
INSERT INTO `cc_sys_log` VALUES ('443', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"6fmc2\",\"username\":\"admin\"}', null, 'admin', '18.163.123.223', null, '2021-03-07 21:34:25', '6');
INSERT INTO `cc_sys_log` VALUES ('444', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"bjawy\",\"username\":\"18391832757\"}', null, '18391832757', '171.94.10.36', null, '2021-03-08 06:37:10', '5');
INSERT INTO `cc_sys_log` VALUES ('445', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"adroz\",\"username\":\"18391832757\"}', null, '18391832757', '45.139.179.184', 'Novosibirskaya XX', '2021-03-08 07:46:01', '5');
INSERT INTO `cc_sys_log` VALUES ('446', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"vrjvr\",\"username\":\"15797711069\"}', null, '15797711069', '115.153.12.103', '江西 南昌', '2021-03-08 10:45:00', '4');
INSERT INTO `cc_sys_log` VALUES ('447', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"p6wes\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', null, '2021-03-08 12:09:54', '4');
INSERT INTO `cc_sys_log` VALUES ('448', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"gnyee\",\"username\":\"mng001\"}', null, 'mng001', '192.46.215.7', null, '2021-03-08 12:44:33', '4');
INSERT INTO `cc_sys_log` VALUES ('449', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"k6fr9\",\"username\":\"admin\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 13:09:36', '5');
INSERT INTO `cc_sys_log` VALUES ('450', '保存角色信息', 'info', '/gameManagerSystem-2.0.1/role/ajax_save_role.do', 'POST', '{\"roleRemark\":\"\",\"roleId\":\"\",\"roleName\":\"风控员\",\"roleStatus\":\"0\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 13:10:19', '10');
INSERT INTO `cc_sys_log` VALUES ('451', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"123456\",\"wechat\":\"123456\",\"userLoginName\":\"bug001\",\"userName\":\"风控员\",\"userId\":\"\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 13:15:29', '10');
INSERT INTO `cc_sys_log` VALUES ('452', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"nkyjt\",\"username\":\"bug001\"}', null, 'bug001', '18.162.61.32', null, '2021-03-08 13:15:57', '4');
INSERT INTO `cc_sys_log` VALUES ('453', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"g4lae\",\"username\":\"admin\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 13:17:13', '4');
INSERT INTO `cc_sys_log` VALUES ('454', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"irfwk\",\"username\":\"bug001\"}', null, 'bug001', '18.162.61.32', null, '2021-03-08 13:19:24', '3');
INSERT INTO `cc_sys_log` VALUES ('455', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"xgnnm\",\"username\":\"admin\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 13:22:37', '4');
INSERT INTO `cc_sys_log` VALUES ('456', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"mn2by\",\"username\":\"mng001\"}', null, 'mng001', '203.66.65.56', null, '2021-03-08 13:24:42', '4');
INSERT INTO `cc_sys_log` VALUES ('457', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"danq3\",\"username\":\"bug001\"}', null, 'bug001', '18.167.90.228', null, '2021-03-08 13:46:47', '4');
INSERT INTO `cc_sys_log` VALUES ('458', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"f9www\",\"username\":\"mng001\"}', null, 'mng001', '203.66.65.56', null, '2021-03-08 14:09:41', '4');
INSERT INTO `cc_sys_log` VALUES ('459', '保存用户信息', 'info', '/gameManagerSystem-2.0.1/user/ajax_save_user.do', 'POST', '{\"userStatus\":\"0\",\"phone\":\"15766214661\",\"wechat\":\"15766214661\",\"userLoginName\":\"15766214661\",\"userName\":\"广州天河林总\",\"userId\":\"\"}', null, 'mng001', '203.66.65.56', null, '2021-03-08 14:10:24', '7');
INSERT INTO `cc_sys_log` VALUES ('460', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"zy8rw\",\"username\":\"admin\"}', null, 'admin', '18.162.61.32', null, '2021-03-08 14:13:56', '3');
INSERT INTO `cc_sys_log` VALUES ('461', '用户登陆', 'info', '/gameManagerSystem-2.0.1/loginCheck.do', 'POST', '{\"password\":\"\",\"code\":\"kuwkw\",\"username\":\"admin\"}', null, 'admin', '210.61.12.7', null, '2021-03-08 14:56:05', '3');

-- ----------------------------
-- Table structure for cc_user
-- ----------------------------
DROP TABLE IF EXISTS `cc_user`;
CREATE TABLE `cc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login_name` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_status` bigint(20) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `wechat` varchar(255) NOT NULL,
  `creator` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cc_user
-- ----------------------------
INSERT INTO `cc_user` VALUES ('8', 'admin', '超级管理员', '925947910', '0', '', '', 'admin', '2017-08-22 14:30:53', 'admin', '2017-08-22 16:12:36');
INSERT INTO `cc_user` VALUES ('161', 'mng001', '系统管理员', '123456', '0', '', '', 'admin', '2021-02-19 16:26:14', null, null);
INSERT INTO `cc_user` VALUES ('162', 'user001', 'yeah001', '123456', '0', '', '', 'admin', '2021-02-19 16:28:39', null, null);
INSERT INTO `cc_user` VALUES ('168', 'user002', 'yeah002', '123456', '0', '18692275790', '18692275790', 'admin', '2021-02-25 16:08:57', 'admin', '2021-02-25 16:11:11');
INSERT INTO `cc_user` VALUES ('169', '15797711069', '南昌陈总', '123456', '0', '15797711069', '15797711069', 'mng001', '2021-03-03 14:36:07', null, null);
INSERT INTO `cc_user` VALUES ('170', '18391832757', '四川林总', '123456', '0', '18391832757', '18391832757', 'mng001', '2021-03-03 14:44:12', null, null);
INSERT INTO `cc_user` VALUES ('171', '18673188911', '测试号', '123456', '0', '18673188911', '18673188911', 'admin', '2021-03-03 15:18:51', null, null);
INSERT INTO `cc_user` VALUES ('172', '13271211860', '河南刘总', '123456', '0', '13271211860', '13271211860', 'mng001', '2021-03-03 20:45:07', null, null);
INSERT INTO `cc_user` VALUES ('173', '18035768397', '长沙李总', '123456', '0', '18035768397', '18035768397', 'mng001', '2021-03-05 21:13:14', null, null);
INSERT INTO `cc_user` VALUES ('174', 'bug001', '风控员', '123456', '0', '123456', '123456', 'admin', '2021-03-08 13:15:29', null, null);
INSERT INTO `cc_user` VALUES ('175', '15766214661', '广州天河林总', '123456', '0', '15766214661', '15766214661', 'mng001', '2021-03-08 14:10:24', null, null);

-- ----------------------------
-- Table structure for cc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cc_user_role`;
CREATE TABLE `cc_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户和角色关系表';

-- ----------------------------
-- Records of cc_user_role
-- ----------------------------
INSERT INTO `cc_user_role` VALUES ('1', '8', '51', 'admin', '2021-03-02 19:01:38', null, null);
INSERT INTO `cc_user_role` VALUES ('16', '168', '53', 'admin', '2021-02-25 16:13:53', null, null);
INSERT INTO `cc_user_role` VALUES ('22', '161', '52', 'admin', '2021-03-02 19:28:53', null, null);
INSERT INTO `cc_user_role` VALUES ('23', '162', '53', 'admin', '2021-03-02 19:29:01', null, null);
INSERT INTO `cc_user_role` VALUES ('24', '169', '53', 'mng001', '2021-03-03 14:43:02', null, null);
INSERT INTO `cc_user_role` VALUES ('25', '170', '53', 'mng001', '2021-03-03 14:44:25', null, null);
INSERT INTO `cc_user_role` VALUES ('26', '171', '53', 'admin', '2021-03-03 15:19:19', null, null);
INSERT INTO `cc_user_role` VALUES ('27', '172', '53', 'mng001', '2021-03-03 20:45:17', null, null);
INSERT INTO `cc_user_role` VALUES ('28', '173', '53', 'mng001', '2021-03-05 21:13:42', null, null);
INSERT INTO `cc_user_role` VALUES ('29', '174', '54', 'admin', '2021-03-08 13:18:55', null, null);
INSERT INTO `cc_user_role` VALUES ('30', '175', '53', 'mng001', '2021-03-08 14:10:55', null, null);

-- ----------------------------
-- Table structure for coinfailed
-- ----------------------------
DROP TABLE IF EXISTS `coinfailed`;
CREATE TABLE `coinfailed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `nick` varchar(255) NOT NULL DEFAULT '',
  `cost` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  `tagId` int(11) NOT NULL DEFAULT '0',
  `reason` varchar(255) NOT NULL DEFAULT '',
  `time` bigint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `type` (`type`) USING BTREE,
  KEY `tagId` (`tagId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coinfailed
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfund
-- ----------------------------
DROP TABLE IF EXISTS `crowdfund`;
CREATE TABLE `crowdfund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `currBuy` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `time` bigint(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `uphoto` varchar(255) DEFAULT NULL,
  `uticket` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `issue` (`issue`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1232 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crowdfund
-- ----------------------------
INSERT INTO `crowdfund` VALUES ('1186', '20210307033', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615116547', '0', 'sera', 'http://129.226.35.186/head/man3.jpg', '20210307033100000', '29');
INSERT INTO `crowdfund` VALUES ('1187', '20210307034', 'iphone12', '14551', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615118347', null, null, null, null, '4');
INSERT INTO `crowdfund` VALUES ('1188', '20210307035', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615118683', '0', 'Kevin', 'http://129.226.35.186/head/man5.jpg', '20210307035100000', '30');
INSERT INTO `crowdfund` VALUES ('1189', '20210307036', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615120483', '0', 'Wesley', 'http://129.226.35.186/head/man5.jpg', '20210307036100000', '26');
INSERT INTO `crowdfund` VALUES ('1190', '20210307037', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615122283', '0', 'Nick', 'http://129.226.35.186/head/man2.jpg', '20210307037100000', '27');
INSERT INTO `crowdfund` VALUES ('1191', '20210307038', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615124083', '0', 'Kylie', 'http://129.226.35.186/head/man1.jpg', '20210307038100000', '25');
INSERT INTO `crowdfund` VALUES ('1192', '20210307039', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615125883', '0', 'Joyce', 'http://129.226.35.186/head/woman2.jpg', '20210307039100000', '28');
INSERT INTO `crowdfund` VALUES ('1193', '20210307040', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615127683', '0', 'Alex', 'http://129.226.35.186/head/man2.jpg', '20210307040100000', '44');
INSERT INTO `crowdfund` VALUES ('1194', '20210307041', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615129483', '0', 'Diego', 'http://129.226.35.186/head/woman2.jpg', '20210307041100000', '29');
INSERT INTO `crowdfund` VALUES ('1195', '20210307042', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615131283', '0', 'गुरुदट', 'http://129.226.35.186/head/man5.jpg', '20210307042100000', '35');
INSERT INTO `crowdfund` VALUES ('1196', '20210307043', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615133083', '0', 'हर्षिता', 'http://129.226.35.186/head/woman5.jpg', '20210307043100000', '29');
INSERT INTO `crowdfund` VALUES ('1197', '20210307044', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615134883', '0', 'नाडिश', 'http://129.226.35.186/head/man4.jpg', '20210307044100000', '45');
INSERT INTO `crowdfund` VALUES ('1199', '20210307045', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615137646', '0', 'नवरंग', 'http://129.226.35.186/head/woman4.jpg', '20210307045100000', '29');
INSERT INTO `crowdfund` VALUES ('1200', '20210307046', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615139446', '0', 'पवनाज', 'http://129.226.35.186/head/woman2.jpg', '20210307046100000', '26');
INSERT INTO `crowdfund` VALUES ('1201', '20210307047', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615141246', '0', 'रामभद्र', 'http://129.226.35.186/head/man3.jpg', '20210307047100000', '28');
INSERT INTO `crowdfund` VALUES ('1202', '20210308000', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615143046', '0', 'desdemona', 'http://129.226.35.186/head/woman5.jpg', '20210308000100000', '26');
INSERT INTO `crowdfund` VALUES ('1203', '20210308001', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615144846', '0', 'cassiel', 'http://129.226.35.186/head/man5.jpg', '20210308001100000', '29');
INSERT INTO `crowdfund` VALUES ('1204', '20210308002', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615146646', '0', 'izefia', 'http://129.226.35.186/head/man2.jpg', '20210308002100000', '29');
INSERT INTO `crowdfund` VALUES ('1205', '20210308003', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615148446', '0', 'angelina', 'http://129.226.35.186/head/man2.jpg', '20210308003100000', '24');
INSERT INTO `crowdfund` VALUES ('1206', '20210308004', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615150246', '0', 'blanche', 'http://129.226.35.186/head/woman2.jpg', '20210308004100000', '29');
INSERT INTO `crowdfund` VALUES ('1207', '20210308005', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615152046', '0', 'desdemona', 'http://129.226.35.186/head/man3.jpg', '20210308005100000', '28');
INSERT INTO `crowdfund` VALUES ('1208', '20210308006', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615153846', '0', 'cecilia', 'http://129.226.35.186/head/woman5.jpg', '20210308006100000', '27');
INSERT INTO `crowdfund` VALUES ('1209', '20210308007', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615155646', '0', 'angelinasakura', 'http://129.226.35.186/head/woman4.jpg', '20210308007100000', '26');
INSERT INTO `crowdfund` VALUES ('1210', '20210308008', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615157446', '0', 'lilith', 'http://129.226.35.186/head/woman5.jpg', '20210308008100000', '24');
INSERT INTO `crowdfund` VALUES ('1211', '20210308009', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615159246', '0', 'cassiopeia', 'http://129.226.35.186/head/woman3.jpg', '20210308009100000', '26');
INSERT INTO `crowdfund` VALUES ('1212', '20210308010', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615161046', '0', 'Henry', 'http://129.226.35.186/head/woman5.jpg', '20210308010100000', '24');
INSERT INTO `crowdfund` VALUES ('1213', '20210308011', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615162846', '0', 'Insane', 'http://129.226.35.186/head/woman1.jpg', '20210308011100000', '29');
INSERT INTO `crowdfund` VALUES ('1214', '20210308012', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615164646', '0', 'mirage ', 'http://129.226.35.186/head/man5.jpg', '20210308012100000', '25');
INSERT INTO `crowdfund` VALUES ('1215', '20210308013', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615166446', '0', 'Carl', 'http://129.226.35.186/head/man2.jpg', '20210308013100000', '27');
INSERT INTO `crowdfund` VALUES ('1216', '20210308014', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615168246', '0', 'Bruce', 'http://129.226.35.186/head/man1.jpg', '20210308014100000', '27');
INSERT INTO `crowdfund` VALUES ('1217', '20210308015', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615170046', '0', 'Evan', 'http://129.226.35.186/head/woman5.jpg', '20210308015100000', '25');
INSERT INTO `crowdfund` VALUES ('1218', '20210308016', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615171846', '0', 'Addison', 'http://129.226.35.186/head/woman2.jpg', '20210308016100000', '27');
INSERT INTO `crowdfund` VALUES ('1219', '20210308017', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615173646', '0', 'Tommy', 'http://129.226.35.186/head/man2.jpg', '20210308017100000', '29');
INSERT INTO `crowdfund` VALUES ('1220', '20210308018', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615175446', '0', 'Easter', 'http://129.226.35.186/head/woman5.jpg', '20210308018100000', '26');
INSERT INTO `crowdfund` VALUES ('1221', '20210308019', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615177246', '0', 'Karen', 'http://129.226.35.186/head/woman3.jpg', '20210308019100000', '31');
INSERT INTO `crowdfund` VALUES ('1222', '20210308020', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615179046', '0', 'गजेंद्र', 'http://129.226.35.186/head/man3.jpg', '20210308020100000', '29');
INSERT INTO `crowdfund` VALUES ('1223', '20210308021', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615180846', '0', 'हर्षद', 'http://129.226.35.186/head/woman4.jpg', '20210308021100000', '28');
INSERT INTO `crowdfund` VALUES ('1224', '20210308022', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615182646', '0', 'कंवर', 'http://129.226.35.186/head/man4.jpg', '20210308022100000', '35');
INSERT INTO `crowdfund` VALUES ('1225', '20210308023', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615184446', '0', 'मनमोहन', 'http://129.226.35.186/head/man2.jpg', '20210308023100000', '27');
INSERT INTO `crowdfund` VALUES ('1226', '20210308024', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615186246', '0', 'निरहानकर', 'http://129.226.35.186/head/man1.jpg', '20210308024100000', '25');
INSERT INTO `crowdfund` VALUES ('1227', '20210308025', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615188046', '0', 'पार्थसारथी', 'http://129.226.35.186/head/woman1.jpg', '20210308025100000', '29');
INSERT INTO `crowdfund` VALUES ('1228', '20210308026', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615189846', '0', 'रामानुज', 'http://129.226.35.186/head/man5.jpg', '20210308026100000', '26');
INSERT INTO `crowdfund` VALUES ('1229', '20210308027', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615191646', '0', 'रोशन', 'http://129.226.35.186/head/woman5.jpg', '20210308027100000', '29');
INSERT INTO `crowdfund` VALUES ('1230', '20210308028', 'iphone12', '100000', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615193446', '0', 'cecilia', 'http://129.226.35.186/head/woman3.jpg', '20210308028100000', '24');
INSERT INTO `crowdfund` VALUES ('1231', '20210308029', 'iphone12', '73223', '100000', '[\"http://129.226.35.186/goods/photo.png\"]', '1615195246', null, null, null, null, '21');

-- ----------------------------
-- Table structure for crowdfundbet
-- ----------------------------
DROP TABLE IF EXISTS `crowdfundbet`;
CREATE TABLE `crowdfundbet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue` bigint(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `coin` int(11) unsigned zerofill DEFAULT NULL,
  `ticket` varchar(255) DEFAULT NULL,
  `time` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `issue` (`issue`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crowdfundbet
-- ----------------------------
INSERT INTO `crowdfundbet` VALUES ('9859', '20210307033', '10000199', 'रोशन', '00000003402', '202103070333402', '1615116548');
INSERT INTO `crowdfundbet` VALUES ('9860', '20210307033', '10000148', 'Jacquelyn', '00000002588', '202103070335990', '1615116667');
INSERT INTO `crowdfundbet` VALUES ('9861', '20210307033', '10000115', 'Abraham', '00000000685', '202103070336675', '1615116727');
INSERT INTO `crowdfundbet` VALUES ('9862', '20210307033', '10000095', 'Ovdoes ', '00000002621', '202103070339296', '1615116787');
INSERT INTO `crowdfundbet` VALUES ('9863', '20210307033', '10000059', 'lilith', '00000002068', '2021030703311364', '1615116847');
INSERT INTO `crowdfundbet` VALUES ('9864', '20210307033', '10000040', 'danae', '00000003136', '2021030703314500', '1615116907');
INSERT INTO `crowdfundbet` VALUES ('9865', '20210307033', '10000004', 'cassiel', '00000004526', '2021030703319026', '1615116967');
INSERT INTO `crowdfundbet` VALUES ('9866', '20210307033', '10000188', 'प्राणजीवन', '00000000230', '2021030703319256', '1615117027');
INSERT INTO `crowdfundbet` VALUES ('9867', '20210307033', '10000154', 'गुरुदट', '00000003612', '2021030703322868', '1615117087');
INSERT INTO `crowdfundbet` VALUES ('9868', '20210307033', '10000136', 'Joyce', '00000003793', '2021030703326661', '1615117147');
INSERT INTO `crowdfundbet` VALUES ('9869', '20210307033', '10000101', 'Carl', '00000000982', '2021030703327643', '1615117207');
INSERT INTO `crowdfundbet` VALUES ('9870', '20210307033', '10000083', 'Dirge ', '00000003134', '2021030703330777', '1615117267');
INSERT INTO `crowdfundbet` VALUES ('9871', '20210307033', '10000046', 'sicily', '00000001898', '2021030703332675', '1615117327');
INSERT INTO `crowdfundbet` VALUES ('9872', '20210307033', '10000028', 'dolores', '00000001498', '2021030703334173', '1615117387');
INSERT INTO `crowdfundbet` VALUES ('9873', '20210307033', '10000195', 'रामप्रसाद', '00000001277', '2021030703335450', '1615117447');
INSERT INTO `crowdfundbet` VALUES ('9874', '20210307033', '10000176', 'नवदविप', '00000004375', '2021030703339825', '1615117507');
INSERT INTO `crowdfundbet` VALUES ('9875', '20210307033', '10000142', 'Tankard', '00000006320', '2021030703346145', '1615117567');
INSERT INTO `crowdfundbet` VALUES ('9876', '20210307033', '10000125', 'Easter', '00000000281', '2021030703346426', '1615117627');
INSERT INTO `crowdfundbet` VALUES ('9877', '20210307033', '10000089', 'Miss ', '00000004122', '2021030703350548', '1615117687');
INSERT INTO `crowdfundbet` VALUES ('9878', '20210307033', '10000069', 'LenaKong', '00000003860', '2021030703354408', '1615117747');
INSERT INTO `crowdfundbet` VALUES ('9879', '20210307033', '10000034', 'amaryllis', '00000003722', '2021030703358130', '1615117807');
INSERT INTO `crowdfundbet` VALUES ('9880', '20210307033', '10000016', 'snow', '00000006605', '2021030703364735', '1615117867');
INSERT INTO `crowdfundbet` VALUES ('9881', '20210307033', '10000182', 'परांजॉय', '00000004861', '2021030703369596', '1615117927');
INSERT INTO `crowdfundbet` VALUES ('9882', '20210307033', '10000164', 'कर्मजीत', '00000000957', '2021030703370553', '1615117987');
INSERT INTO `crowdfundbet` VALUES ('9883', '20210307033', '10000130', 'Kylie', '00000004496', '2021030703375049', '1615118047');
INSERT INTO `crowdfundbet` VALUES ('9884', '20210307033', '10000113', 'Denny', '00000003257', '2021030703378306', '1615118107');
INSERT INTO `crowdfundbet` VALUES ('9885', '20210307033', '10000077', 'Joseph', '00000021694', '20210307033100000', '1615118167');
INSERT INTO `crowdfundbet` VALUES ('9886', '20210307033', '10000057', 'anemone', '00000000000', '20210307033100000', '1615118227');
INSERT INTO `crowdfundbet` VALUES ('9887', '20210307033', '10000022', 'sera', '00000000000', '20210307033100000', '1615118287');
INSERT INTO `crowdfundbet` VALUES ('9888', '20210307034', '10000171', 'मनमोहन', '00000006144', '202103070346144', '1615118407');
INSERT INTO `crowdfundbet` VALUES ('9889', '20210307034', '10000153', 'गोविंद', '00000002927', '202103070349071', '1615118467');
INSERT INTO `crowdfundbet` VALUES ('9890', '20210307034', '10000120', 'Bill', '00000000302', '202103070349373', '1615118527');
INSERT INTO `crowdfundbet` VALUES ('9891', '20210307034', '10000100', 'Wilson', '00000005178', '2021030703414551', '1615118587');
INSERT INTO `crowdfundbet` VALUES ('9892', '20210307035', '10000082', 'Promise ', '00000000615', '20210307035615', '1615118684');
INSERT INTO `crowdfundbet` VALUES ('9893', '20210307035', '10000045', 'amaris', '00000002103', '202103070352718', '1615118743');
INSERT INTO `crowdfundbet` VALUES ('9894', '20210307035', '10000027', 'fiona', '00000003628', '202103070356346', '1615118803');
INSERT INTO `crowdfundbet` VALUES ('9895', '20210307035', '10000194', 'रामानुज', '00000003485', '202103070359831', '1615118863');
INSERT INTO `crowdfundbet` VALUES ('9896', '20210307035', '10000175', 'नरोत्तम', '00000002867', '2021030703512698', '1615118923');
INSERT INTO `crowdfundbet` VALUES ('9897', '20210307035', '10000141', 'Alex', '00000002667', '2021030703515365', '1615118983');
INSERT INTO `crowdfundbet` VALUES ('9898', '20210307035', '10000124', 'Kelly', '00000002410', '2021030703517775', '1615119043');
INSERT INTO `crowdfundbet` VALUES ('9899', '20210307035', '10000088', 'Allure', '00000001258', '2021030703519033', '1615119103');
INSERT INTO `crowdfundbet` VALUES ('9900', '20210307035', '10000068', 'clamp', '00000002251', '2021030703521284', '1615119163');
INSERT INTO `crowdfundbet` VALUES ('9901', '20210307035', '10000033', 'amaya', '00000003732', '2021030703525016', '1615119223');
INSERT INTO `crowdfundbet` VALUES ('9902', '20210307035', '10000015', 'felicia', '00000002505', '2021030703527521', '1615119283');
INSERT INTO `crowdfundbet` VALUES ('9903', '20210307035', '10000181', 'पलाश', '00000005925', '2021030703533446', '1615119343');
INSERT INTO `crowdfundbet` VALUES ('9904', '20210307035', '10000163', 'कंवर', '00000001363', '2021030703534809', '1615119403');
INSERT INTO `crowdfundbet` VALUES ('9905', '20210307035', '10000129', 'Aidan', '00000001965', '2021030703536774', '1615119463');
INSERT INTO `crowdfundbet` VALUES ('9906', '20210307035', '10000112', 'Charles', '00000005305', '2021030703542079', '1615119523');
INSERT INTO `crowdfundbet` VALUES ('9907', '20210307035', '10000076', 'William', '00000004144', '2021030703546223', '1615119583');
INSERT INTO `crowdfundbet` VALUES ('9908', '20210307035', '10000056', 'amaya', '00000000538', '2021030703546761', '1615119643');
INSERT INTO `crowdfundbet` VALUES ('9909', '20210307035', '10000021', 'angelina', '00000005349', '2021030703552110', '1615119703');
INSERT INTO `crowdfundbet` VALUES ('9910', '20210307035', '10000002', 'gabrielle', '00000002448', '2021030703554558', '1615119763');
INSERT INTO `crowdfundbet` VALUES ('9911', '20210307035', '10000169', 'मधुसूदन', '00000001712', '2021030703556270', '1615119823');
INSERT INTO `crowdfundbet` VALUES ('9912', '20210307035', '10000151', 'गगन', '00000005156', '2021030703561426', '1615119883');
INSERT INTO `crowdfundbet` VALUES ('9913', '20210307035', '10000118', 'Ben', '00000004462', '2021030703565888', '1615119943');
INSERT INTO `crowdfundbet` VALUES ('9914', '20210307035', '10000098', 'Diamonds ', '00000002197', '2021030703568085', '1615120003');
INSERT INTO `crowdfundbet` VALUES ('9915', '20210307035', '10000062', 'melantha', '00000002989', '2021030703571074', '1615120063');
INSERT INTO `crowdfundbet` VALUES ('9916', '20210307035', '10000044', 'celina', '00000000292', '2021030703571366', '1615120123');
INSERT INTO `crowdfundbet` VALUES ('9917', '20210307035', '10000007', 'cecilia', '00000006163', '2021030703577529', '1615120183');
INSERT INTO `crowdfundbet` VALUES ('9918', '20210307035', '10000191', 'रक्षम्बर', '00000005279', '2021030703582808', '1615120243');
INSERT INTO `crowdfundbet` VALUES ('9919', '20210307035', '10000157', 'हरिप्रीत', '00000017192', '20210307035100000', '1615120303');
INSERT INTO `crowdfundbet` VALUES ('9920', '20210307035', '10000139', 'Easter', '00000000000', '20210307035100000', '1615120363');
INSERT INTO `crowdfundbet` VALUES ('9921', '20210307035', '10000104', 'Kevin', '00000000000', '20210307035100000', '1615120423');
INSERT INTO `crowdfundbet` VALUES ('9922', '20210307036', '10000050', 'elodie', '00000002675', '202103070362675', '1615120543');
INSERT INTO `crowdfundbet` VALUES ('9923', '20210307036', '10000032', 'desdemona', '00000003048', '202103070365723', '1615120603');
INSERT INTO `crowdfundbet` VALUES ('9924', '20210307036', '10000199', 'रोशन', '00000005541', '2021030703611264', '1615120663');
INSERT INTO `crowdfundbet` VALUES ('9925', '20210307036', '10000180', 'निरहानकर', '00000004945', '2021030703616209', '1615120723');
INSERT INTO `crowdfundbet` VALUES ('9926', '20210307036', '10000146', 'Diego', '00000004094', '2021030703620303', '1615120783');
INSERT INTO `crowdfundbet` VALUES ('9927', '20210307036', '10000094', 'mirage ', '00000003268', '2021030703623571', '1615120903');
INSERT INTO `crowdfundbet` VALUES ('9928', '20210307036', '10000076', 'William', '00000004536', '2021030703628107', '1615120963');
INSERT INTO `crowdfundbet` VALUES ('9929', '20210307036', '10000039', 'cecilia', '00000000906', '2021030703629013', '1615121023');
INSERT INTO `crowdfundbet` VALUES ('9930', '20210307036', '10000021', 'angelina', '00000006575', '2021030703635588', '1615121083');
INSERT INTO `crowdfundbet` VALUES ('9931', '20210307036', '10000187', 'प्रभाकर', '00000005310', '2021030703640898', '1615121143');
INSERT INTO `crowdfundbet` VALUES ('9932', '20210307036', '10000136', 'Joyce', '00000003835', '2021030703644733', '1615121263');
INSERT INTO `crowdfundbet` VALUES ('9933', '20210307036', '10000119', 'Evan', '00000002325', '2021030703647058', '1615121323');
INSERT INTO `crowdfundbet` VALUES ('9934', '20210307036', '10000083', 'Dirge ', '00000004618', '2021030703651676', '1615121383');
INSERT INTO `crowdfundbet` VALUES ('9935', '20210307036', '10000063', 'sade', '00000006517', '2021030703658193', '1615121443');
INSERT INTO `crowdfundbet` VALUES ('9936', '20210307036', '10000012', 'louise', '00000003602', '2021030703661795', '1615121563');
INSERT INTO `crowdfundbet` VALUES ('9937', '20210307036', '10000177', 'नवद्वीप', '00000002233', '2021030703664028', '1615121623');
INSERT INTO `crowdfundbet` VALUES ('9938', '20210307036', '10000159', 'हर्षिता', '00000001007', '2021030703665035', '1615121683');
INSERT INTO `crowdfundbet` VALUES ('9939', '20210307036', '10000126', 'Addison', '00000003753', '2021030703668788', '1615121743');
INSERT INTO `crowdfundbet` VALUES ('9940', '20210307036', '10000107', 'Barry', '00000004724', '2021030703673512', '1615121803');
INSERT INTO `crowdfundbet` VALUES ('9941', '20210307036', '10000070', 'AllyZhang', '00000002584', '2021030703676096', '1615121863');
INSERT INTO `crowdfundbet` VALUES ('9942', '20210307036', '10000053', 'claudia', '00000001697', '2021030703677793', '1615121923');
INSERT INTO `crowdfundbet` VALUES ('9943', '20210307036', '10000017', 'celina', '00000003651', '2021030703681444', '1615121983');
INSERT INTO `crowdfundbet` VALUES ('9944', '20210307036', '10000106', 'Leon', '00000000103', '2021030703681547', '1615122043');
INSERT INTO `crowdfundbet` VALUES ('9945', '20210307036', '10000166', 'काशीनाथ', '00000018453', '20210307036100000', '1615122103');
INSERT INTO `crowdfundbet` VALUES ('9946', '20210307036', '10000147', 'Karen', '00000000000', '20210307036100000', '1615122163');
INSERT INTO `crowdfundbet` VALUES ('9947', '20210307036', '10000114', 'Wesley', '00000000000', '20210307036100000', '1615122223');
INSERT INTO `crowdfundbet` VALUES ('9948', '20210307037', '10000059', 'lilith', '00000002301', '202103070372301', '1615122343');
INSERT INTO `crowdfundbet` VALUES ('9949', '20210307037', '10000040', 'danae', '00000000320', '202103070372621', '1615122403');
INSERT INTO `crowdfundbet` VALUES ('9950', '20210307037', '10000005', 'ulrica', '00000000983', '202103070373604', '1615122463');
INSERT INTO `crowdfundbet` VALUES ('9951', '20210307037', '10000188', 'प्राणजीवन', '00000004077', '202103070377681', '1615122523');
INSERT INTO `crowdfundbet` VALUES ('9952', '20210307037', '10000154', 'गुरुदट', '00000005994', '2021030703713675', '1615122583');
INSERT INTO `crowdfundbet` VALUES ('9953', '20210307037', '10000137', 'Albert', '00000005115', '2021030703718790', '1615122643');
INSERT INTO `crowdfundbet` VALUES ('9954', '20210307037', '10000101', 'Carl', '00000006207', '2021030703724997', '1615122703');
INSERT INTO `crowdfundbet` VALUES ('9955', '20210307037', '10000083', 'Dirge ', '00000002546', '2021030703727543', '1615122763');
INSERT INTO `crowdfundbet` VALUES ('9956', '20210307037', '10000047', 'cecile', '00000005737', '2021030703733280', '1615122823');
INSERT INTO `crowdfundbet` VALUES ('9957', '20210307037', '10000028', 'dolores', '00000004492', '2021030703737772', '1615122883');
INSERT INTO `crowdfundbet` VALUES ('9958', '20210307037', '10000178', 'नवरंग', '00000002103', '2021030703739875', '1615123003');
INSERT INTO `crowdfundbet` VALUES ('9959', '20210307037', '10000143', 'Harriet', '00000002113', '2021030703741988', '1615123063');
INSERT INTO `crowdfundbet` VALUES ('9960', '20210307037', '10000126', 'Addison', '00000005648', '2021030703747636', '1615123123');
INSERT INTO `crowdfundbet` VALUES ('9961', '20210307037', '10000091', 'Mental ', '00000000395', '2021030703748031', '1615123183');
INSERT INTO `crowdfundbet` VALUES ('9962', '20210307037', '10000070', 'AllyZhang', '00000002260', '2021030703750291', '1615123243');
INSERT INTO `crowdfundbet` VALUES ('9963', '20210307037', '10000035', 'anemone', '00000006556', '2021030703756847', '1615123303');
INSERT INTO `crowdfundbet` VALUES ('9964', '20210307037', '10000018', 'amaris', '00000005719', '2021030703762566', '1615123363');
INSERT INTO `crowdfundbet` VALUES ('9965', '20210307037', '10000183', 'परमजीत', '00000004172', '2021030703766738', '1615123423');
INSERT INTO `crowdfundbet` VALUES ('9966', '20210307037', '10000133', 'Caiden', '00000003399', '2021030703770137', '1615123543');
INSERT INTO `crowdfundbet` VALUES ('9967', '20210307037', '10000115', 'Abraham', '00000003565', '2021030703773702', '1615123603');
INSERT INTO `crowdfundbet` VALUES ('9968', '20210307037', '10000079', 'Henry', '00000003859', '2021030703777561', '1615123663');
INSERT INTO `crowdfundbet` VALUES ('9969', '20210307037', '10000060', 'lorelei', '00000001242', '2021030703778803', '1615123723');
INSERT INTO `crowdfundbet` VALUES ('9970', '20210307037', '10000024', 'karida', '00000003145', '2021030703781948', '1615123783');
INSERT INTO `crowdfundbet` VALUES ('9971', '20210307037', '10000005', 'ulrica', '00000003496', '2021030703785444', '1615123843');
INSERT INTO `crowdfundbet` VALUES ('9972', '20210307037', '10000173', 'नाडिश', '00000014556', '20210307037100000', '1615123903');
INSERT INTO `crowdfundbet` VALUES ('9973', '20210307037', '10000154', 'गुरुदट', '00000000000', '20210307037100000', '1615123963');
INSERT INTO `crowdfundbet` VALUES ('9974', '20210307037', '10000121', 'Nick', '00000000000', '20210307037100000', '1615124023');
INSERT INTO `crowdfundbet` VALUES ('9975', '20210307038', '10000066', 'cyrene', '00000006010', '202103070386010', '1615124143');
INSERT INTO `crowdfundbet` VALUES ('9976', '20210307038', '10000048', 'angelinasakura', '00000002622', '202103070388632', '1615124203');
INSERT INTO `crowdfundbet` VALUES ('9977', '20210307038', '10000014', 'chloe', '00000006251', '2021030703814883', '1615124263');
INSERT INTO `crowdfundbet` VALUES ('9978', '20210307038', '10000162', 'कनेया', '00000003368', '2021030703818251', '1615124383');
INSERT INTO `crowdfundbet` VALUES ('9979', '20210307038', '10000145', 'Aidan', '00000006171', '2021030703824422', '1615124443');
INSERT INTO `crowdfundbet` VALUES ('9980', '20210307038', '10000093', 'Luminary ', '00000002030', '2021030703826452', '1615124563');
INSERT INTO `crowdfundbet` VALUES ('9981', '20210307038', '10000057', 'anemone', '00000002847', '2021030703829299', '1615124623');
INSERT INTO `crowdfundbet` VALUES ('9982', '20210307038', '10000037', 'gina', '00000002807', '2021030703832106', '1615124683');
INSERT INTO `crowdfundbet` VALUES ('9983', '20210307038', '10000002', 'gabrielle', '00000006549', '2021030703838655', '1615124743');
INSERT INTO `crowdfundbet` VALUES ('9984', '20210307038', '10000186', 'पवनाज', '00000004802', '2021030703843457', '1615124803');
INSERT INTO `crowdfundbet` VALUES ('9985', '20210307038', '10000135', 'Leon', '00000004048', '2021030703847505', '1615124923');
INSERT INTO `crowdfundbet` VALUES ('9986', '20210307038', '10000100', 'Wilson', '00000000567', '2021030703848072', '1615124983');
INSERT INTO `crowdfundbet` VALUES ('9987', '20210307038', '10000081', 'Martin', '00000005482', '2021030703853554', '1615125043');
INSERT INTO `crowdfundbet` VALUES ('9988', '20210307038', '10000045', 'amaris', '00000004717', '2021030703858271', '1615125103');
INSERT INTO `crowdfundbet` VALUES ('9989', '20210307038', '10000027', 'fiona', '00000001572', '2021030703859843', '1615125163');
INSERT INTO `crowdfundbet` VALUES ('9990', '20210307038', '10000192', 'रामभद्र', '00000002057', '2021030703861900', '1615125223');
INSERT INTO `crowdfundbet` VALUES ('9991', '20210307038', '10000175', 'नरोत्तम', '00000006410', '2021030703868310', '1615125283');
INSERT INTO `crowdfundbet` VALUES ('9992', '20210307038', '10000141', 'Alex', '00000002366', '2021030703870676', '1615125343');
INSERT INTO `crowdfundbet` VALUES ('9993', '20210307038', '10000123', 'JasonJohnny', '00000004554', '2021030703875230', '1615125403');
INSERT INTO `crowdfundbet` VALUES ('9994', '20210307038', '10000088', 'Allure', '00000005411', '2021030703880641', '1615125463');
INSERT INTO `crowdfundbet` VALUES ('9995', '20210307038', '10000033', 'amaya', '00000002988', '2021030703883629', '1615125583');
INSERT INTO `crowdfundbet` VALUES ('9996', '20210307038', '10000016', 'snow', '00000003282', '2021030703886911', '1615125643');
INSERT INTO `crowdfundbet` VALUES ('9997', '20210307038', '10000182', 'परांजॉय', '00000013089', '20210307038100000', '1615125703');
INSERT INTO `crowdfundbet` VALUES ('9998', '20210307038', '10000163', 'कंवर', '00000000000', '20210307038100000', '1615125763');
INSERT INTO `crowdfundbet` VALUES ('9999', '20210307038', '10000130', 'Kylie', '00000000000', '20210307038100000', '1615125823');
INSERT INTO `crowdfundbet` VALUES ('10000', '20210307039', '10000077', 'Joseph', '00000005623', '202103070395623', '1615125943');
INSERT INTO `crowdfundbet` VALUES ('10001', '20210307039', '10000058', 'michaela', '00000006445', '2021030703912068', '1615126003');
INSERT INTO `crowdfundbet` VALUES ('10002', '20210307039', '10000004', 'cassiel', '00000003913', '2021030703915981', '1615126123');
INSERT INTO `crowdfundbet` VALUES ('10003', '20210307039', '10000172', 'मार्तंड', '00000001712', '2021030703917693', '1615126183');
INSERT INTO `crowdfundbet` VALUES ('10004', '20210307039', '10000154', 'गुरुदट', '00000001954', '2021030703919647', '1615126243');
INSERT INTO `crowdfundbet` VALUES ('10005', '20210307039', '10000120', 'Bill', '00000000715', '2021030703920362', '1615126303');
INSERT INTO `crowdfundbet` VALUES ('10006', '20210307039', '10000101', 'Carl', '00000006543', '2021030703926905', '1615126363');
INSERT INTO `crowdfundbet` VALUES ('10007', '20210307039', '10000065', 'kimi', '00000000291', '2021030703927196', '1615126423');
INSERT INTO `crowdfundbet` VALUES ('10008', '20210307039', '10000046', 'sicily', '00000001010', '2021030703928206', '1615126483');
INSERT INTO `crowdfundbet` VALUES ('10009', '20210307039', '10000012', 'louise', '00000005807', '2021030703934013', '1615126543');
INSERT INTO `crowdfundbet` VALUES ('10010', '20210307039', '10000195', 'रामप्रसाद', '00000003036', '2021030703937049', '1615126603');
INSERT INTO `crowdfundbet` VALUES ('10011', '20210307039', '10000159', 'हर्षिता', '00000000597', '2021030703937646', '1615126663');
INSERT INTO `crowdfundbet` VALUES ('10012', '20210307039', '10000142', 'Tankard', '00000000090', '2021030703937736', '1615126723');
INSERT INTO `crowdfundbet` VALUES ('10013', '20210307039', '10000109', 'Albert', '00000005019', '2021030703942755', '1615126783');
INSERT INTO `crowdfundbet` VALUES ('10014', '20210307039', '10000089', 'Miss ', '00000000318', '2021030703943073', '1615126843');
INSERT INTO `crowdfundbet` VALUES ('10015', '20210307039', '10000053', 'claudia', '00000003336', '2021030703946409', '1615126903');
INSERT INTO `crowdfundbet` VALUES ('10016', '20210307039', '10000034', 'amaryllis', '00000002679', '2021030703949088', '1615126963');
INSERT INTO `crowdfundbet` VALUES ('10017', '20210307039', '10000106', 'Leon', '00000001388', '2021030703950476', '1615127023');
INSERT INTO `crowdfundbet` VALUES ('10018', '20210307039', '10000182', 'परांजॉय', '00000004278', '2021030703954754', '1615127083');
INSERT INTO `crowdfundbet` VALUES ('10019', '20210307039', '10000148', 'Jacquelyn', '00000002886', '2021030703957640', '1615127143');
INSERT INTO `crowdfundbet` VALUES ('10020', '20210307039', '10000130', 'Kylie', '00000004000', '2021030703961640', '1615127203');
INSERT INTO `crowdfundbet` VALUES ('10021', '20210307039', '10000095', 'Ovdoes ', '00000003198', '2021030703964838', '1615127263');
INSERT INTO `crowdfundbet` VALUES ('10022', '20210307039', '10000077', 'Joseph', '00000003426', '2021030703968264', '1615127323');
INSERT INTO `crowdfundbet` VALUES ('10023', '20210307039', '10000039', 'cecilia', '00000001687', '2021030703969951', '1615127383');
INSERT INTO `crowdfundbet` VALUES ('10024', '20210307039', '10000022', 'sera', '00000000116', '2021030703970067', '1615127443');
INSERT INTO `crowdfundbet` VALUES ('10025', '20210307039', '10000188', 'प्राणजीवन', '00000029933', '20210307039100000', '1615127503');
INSERT INTO `crowdfundbet` VALUES ('10026', '20210307039', '10000170', 'महंत', '00000000000', '20210307039100000', '1615127563');
INSERT INTO `crowdfundbet` VALUES ('10027', '20210307039', '10000136', 'Joyce', '00000000000', '20210307039100000', '1615127623');
INSERT INTO `crowdfundbet` VALUES ('10028', '20210307040', '10000083', 'Dirge ', '00000000516', '20210307040516', '1615127743');
INSERT INTO `crowdfundbet` VALUES ('10029', '20210307040', '10', 'daxiong', '00000000100', '20210307040616', '1615127768');
INSERT INTO `crowdfundbet` VALUES ('10030', '20210307040', '10', 'daxiong', '00000000100', '20210307040716', '1615127777');
INSERT INTO `crowdfundbet` VALUES ('10031', '20210307040', '10', 'daxiong', '00000000100', '20210307040816', '1615127782');
INSERT INTO `crowdfundbet` VALUES ('10032', '20210307040', '10', 'daxiong', '00000000100', '20210307040916', '1615127784');
INSERT INTO `crowdfundbet` VALUES ('10033', '20210307040', '10', 'daxiong', '00000000100', '202103070401016', '1615127784');
INSERT INTO `crowdfundbet` VALUES ('10034', '20210307040', '10', 'daxiong', '00000000100', '202103070401116', '1615127785');
INSERT INTO `crowdfundbet` VALUES ('10035', '20210307040', '10', 'daxiong', '00000000100', '202103070401216', '1615127785');
INSERT INTO `crowdfundbet` VALUES ('10036', '20210307040', '10', 'daxiong', '00000000100', '202103070401316', '1615127785');
INSERT INTO `crowdfundbet` VALUES ('10037', '20210307040', '10', 'daxiong', '00000000100', '202103070401416', '1615127785');
INSERT INTO `crowdfundbet` VALUES ('10038', '20210307040', '10', 'daxiong', '00000000100', '202103070401516', '1615127785');
INSERT INTO `crowdfundbet` VALUES ('10039', '20210307040', '10', 'daxiong', '00000000100', '202103070401616', '1615127786');
INSERT INTO `crowdfundbet` VALUES ('10040', '20210307040', '10', 'daxiong', '00000000100', '202103070401716', '1615127786');
INSERT INTO `crowdfundbet` VALUES ('10041', '20210307040', '10', 'daxiong', '00000000100', '202103070401816', '1615127786');
INSERT INTO `crowdfundbet` VALUES ('10042', '20210307040', '10', 'daxiong', '00000000100', '202103070401916', '1615127786');
INSERT INTO `crowdfundbet` VALUES ('10043', '20210307040', '10', 'daxiong', '00000000100', '202103070402016', '1615127786');
INSERT INTO `crowdfundbet` VALUES ('10044', '20210307040', '10000064', 'kira', '00000000612', '202103070402628', '1615127803');
INSERT INTO `crowdfundbet` VALUES ('10045', '20210307040', '10000029', 'delores', '00000005713', '202103070408341', '1615127863');
INSERT INTO `crowdfundbet` VALUES ('10046', '20210307040', '10000011', 'izefia', '00000002122', '2021030704010463', '1615127923');
INSERT INTO `crowdfundbet` VALUES ('10047', '20210307040', '10000177', 'नवद्वीप', '00000003731', '2021030704014194', '1615127983');
INSERT INTO `crowdfundbet` VALUES ('10048', '20210307040', '10000159', 'हर्षिता', '00000005488', '2021030704019682', '1615128043');
INSERT INTO `crowdfundbet` VALUES ('10049', '20210307040', '10000125', 'Easter', '00000002234', '2021030704021916', '1615128103');
INSERT INTO `crowdfundbet` VALUES ('10050', '20210307040', '10000107', 'Barry', '00000001599', '2021030704023515', '1615128163');
INSERT INTO `crowdfundbet` VALUES ('10051', '20210307040', '10000070', 'AllyZhang', '00000006013', '2021030704029528', '1615128223');
INSERT INTO `crowdfundbet` VALUES ('10052', '20210307040', '10000051', 'dolores', '00000003697', '2021030704033225', '1615128283');
INSERT INTO `crowdfundbet` VALUES ('10053', '20210307040', '10000017', 'celina', '00000000744', '2021030704033969', '1615128343');
INSERT INTO `crowdfundbet` VALUES ('10054', '20210307040', '10000106', 'Leon', '00000000391', '2021030704034360', '1615128403');
INSERT INTO `crowdfundbet` VALUES ('10055', '20210307040', '10000164', 'कर्मजीत', '00000005119', '2021030704039479', '1615128463');
INSERT INTO `crowdfundbet` VALUES ('10056', '20210307040', '10000147', 'Karen', '00000001266', '2021030704040745', '1615128523');
INSERT INTO `crowdfundbet` VALUES ('10057', '20210307040', '10000114', 'Wesley', '00000004672', '2021030704045417', '1615128583');
INSERT INTO `crowdfundbet` VALUES ('10058', '20210307040', '10000094', 'mirage ', '00000005671', '2021030704051088', '1615128643');
INSERT INTO `crowdfundbet` VALUES ('10059', '20210307040', '10000058', 'michaela', '00000001306', '2021030704052394', '1615128703');
INSERT INTO `crowdfundbet` VALUES ('10060', '20210307040', '10000039', 'cecilia', '00000006512', '2021030704058906', '1615128763');
INSERT INTO `crowdfundbet` VALUES ('10061', '20210307040', '10000003', 'raffaella ', '00000002233', '2021030704061139', '1615128823');
INSERT INTO `crowdfundbet` VALUES ('10062', '20210307040', '10000187', 'प्रभाकर', '00000002657', '2021030704063796', '1615128883');
INSERT INTO `crowdfundbet` VALUES ('10063', '20210307040', '10000153', 'गोविंद', '00000002681', '2021030704066477', '1615128943');
INSERT INTO `crowdfundbet` VALUES ('10064', '20210307040', '10000135', 'Leon', '00000005247', '2021030704071724', '1615129003');
INSERT INTO `crowdfundbet` VALUES ('10065', '20210307040', '10000100', 'Wilson', '00000004907', '2021030704076631', '1615129063');
INSERT INTO `crowdfundbet` VALUES ('10066', '20210307040', '10000082', 'Promise ', '00000002162', '2021030704078793', '1615129123');
INSERT INTO `crowdfundbet` VALUES ('10067', '20210307040', '10000045', 'amaris', '00000004264', '2021030704083057', '1615129183');
INSERT INTO `crowdfundbet` VALUES ('10068', '20210307040', '10000027', 'fiona', '00000001759', '2021030704084816', '1615129243');
INSERT INTO `crowdfundbet` VALUES ('10069', '20210307040', '10000194', 'रामानुज', '00000015184', '20210307040100000', '1615129303');
INSERT INTO `crowdfundbet` VALUES ('10070', '20210307040', '10000175', 'नरोत्तम', '00000000000', '20210307040100000', '1615129363');
INSERT INTO `crowdfundbet` VALUES ('10071', '20210307040', '10000141', 'Alex', '00000000000', '20210307040100000', '1615129423');
INSERT INTO `crowdfundbet` VALUES ('10072', '20210307041', '10000089', 'Miss ', '00000001132', '202103070411132', '1615129543');
INSERT INTO `crowdfundbet` VALUES ('10073', '20210307041', '10000069', 'LenaKong', '00000001517', '202103070412649', '1615129603');
INSERT INTO `crowdfundbet` VALUES ('10074', '20210307041', '10000034', 'amaryllis', '00000006590', '202103070419239', '1615129663');
INSERT INTO `crowdfundbet` VALUES ('10075', '20210307041', '10000016', 'snow', '00000002607', '2021030704111846', '1615129723');
INSERT INTO `crowdfundbet` VALUES ('10076', '20210307041', '10000182', 'परांजॉय', '00000002446', '2021030704114292', '1615129783');
INSERT INTO `crowdfundbet` VALUES ('10077', '20210307041', '10000164', 'कर्मजीत', '00000002217', '2021030704116509', '1615129843');
INSERT INTO `crowdfundbet` VALUES ('10078', '20210307041', '10000130', 'Kylie', '00000003333', '2021030704119842', '1615129903');
INSERT INTO `crowdfundbet` VALUES ('10079', '20210307041', '10000113', 'Denny', '00000000826', '2021030704120668', '1615129963');
INSERT INTO `crowdfundbet` VALUES ('10080', '20210307041', '10000077', 'Joseph', '00000004445', '2021030704125113', '1615130023');
INSERT INTO `crowdfundbet` VALUES ('10081', '20210307041', '10000057', 'anemone', '00000003608', '2021030704128721', '1615130083');
INSERT INTO `crowdfundbet` VALUES ('10082', '20210307041', '10000022', 'sera', '00000006406', '2021030704135127', '1615130143');
INSERT INTO `crowdfundbet` VALUES ('10083', '20210307041', '10000003', 'raffaella ', '00000005616', '2021030704140743', '1615130203');
INSERT INTO `crowdfundbet` VALUES ('10084', '20210307041', '10000170', 'महंत', '00000003958', '2021030704144701', '1615130263');
INSERT INTO `crowdfundbet` VALUES ('10085', '20210307041', '10000152', 'गजेंद्र', '00000004755', '2021030704149456', '1615130323');
INSERT INTO `crowdfundbet` VALUES ('10086', '20210307041', '10000119', 'Evan', '00000000055', '2021030704149511', '1615130383');
INSERT INTO `crowdfundbet` VALUES ('10087', '20210307041', '10000099', 'Estrus ', '00000006324', '2021030704155835', '1615130443');
INSERT INTO `crowdfundbet` VALUES ('10088', '20210307041', '10000063', 'sade', '00000001351', '2021030704157186', '1615130503');
INSERT INTO `crowdfundbet` VALUES ('10089', '20210307041', '10000045', 'amaris', '00000005781', '2021030704162967', '1615130563');
INSERT INTO `crowdfundbet` VALUES ('10090', '20210307041', '10000008', 'claudia', '00000002308', '2021030704165275', '1615130623');
INSERT INTO `crowdfundbet` VALUES ('10091', '20210307041', '10000192', 'रामभद्र', '00000000434', '2021030704165709', '1615130683');
INSERT INTO `crowdfundbet` VALUES ('10092', '20210307041', '10000158', 'हर्षद', '00000006509', '2021030704172218', '1615130743');
INSERT INTO `crowdfundbet` VALUES ('10093', '20210307041', '10000140', 'Alonso', '00000001625', '2021030704173843', '1615130803');
INSERT INTO `crowdfundbet` VALUES ('10094', '20210307041', '10000105', 'Solomon', '00000001908', '2021030704175751', '1615130863');
INSERT INTO `crowdfundbet` VALUES ('10095', '20210307041', '10000088', 'Allure', '00000004598', '2021030704180349', '1615130923');
INSERT INTO `crowdfundbet` VALUES ('10096', '20210307041', '10000050', 'elodie', '00000000579', '2021030704180928', '1615130983');
INSERT INTO `crowdfundbet` VALUES ('10097', '20210307041', '10000032', 'desdemona', '00000002296', '2021030704183224', '1615131043');
INSERT INTO `crowdfundbet` VALUES ('10098', '20210307041', '10000199', 'रोशन', '00000016776', '20210307041100000', '1615131103');
INSERT INTO `crowdfundbet` VALUES ('10099', '20210307041', '10000180', 'निरहानकर', '00000000000', '20210307041100000', '1615131163');
INSERT INTO `crowdfundbet` VALUES ('10100', '20210307041', '10000146', 'Diego', '00000000000', '20210307041100000', '1615131223');
INSERT INTO `crowdfundbet` VALUES ('10101', '20210307042', '10000094', 'mirage ', '00000004566', '202103070424566', '1615131343');
INSERT INTO `crowdfundbet` VALUES ('10102', '20210307042', '10000076', 'William', '00000004171', '202103070428737', '1615131403');
INSERT INTO `crowdfundbet` VALUES ('10103', '20210307042', '10000039', 'cecilia', '00000003419', '2021030704212156', '1615131463');
INSERT INTO `crowdfundbet` VALUES ('10104', '20210307042', '10000021', 'angelina', '00000002286', '2021030704214442', '1615131523');
INSERT INTO `crowdfundbet` VALUES ('10105', '20210307042', '10000187', 'प्रभाकर', '00000001914', '2021030704216356', '1615131583');
INSERT INTO `crowdfundbet` VALUES ('10106', '20210307042', '10000170', 'महंत', '00000006199', '2021030704222555', '1615131643');
INSERT INTO `crowdfundbet` VALUES ('10107', '20210307042', '10000135', 'Leon', '00000003922', '2021030704226477', '1615131703');
INSERT INTO `crowdfundbet` VALUES ('10108', '20210307042', '12', 'ssjj', '00000000102', '2021030704226579', '1615131747');
INSERT INTO `crowdfundbet` VALUES ('10109', '20210307042', '10000118', 'Ben', '00000003578', '2021030704230157', '1615131763');
INSERT INTO `crowdfundbet` VALUES ('10110', '20210307042', '12', 'ssjj', '00000000123', '2021030704230280', '1615131768');
INSERT INTO `crowdfundbet` VALUES ('10111', '20210307042', '8', '555', '00000000001', '2021030704230281', '1615131881');
INSERT INTO `crowdfundbet` VALUES ('10112', '20210307042', '10000063', 'sade', '00000005449', '2021030704235730', '1615131883');
INSERT INTO `crowdfundbet` VALUES ('10113', '20210307042', '10000028', 'dolores', '00000003946', '2021030704239676', '1615131943');
INSERT INTO `crowdfundbet` VALUES ('10114', '20210307042', '10000011', 'izefia', '00000005294', '2021030704244970', '1615132003');
INSERT INTO `crowdfundbet` VALUES ('10115', '20210307042', '10000159', 'हर्षिता', '00000002473', '2021030704247443', '1615132123');
INSERT INTO `crowdfundbet` VALUES ('10116', '20210307042', '12', 'ssjj', '00000000015', '2021030704247458', '1615132153');
INSERT INTO `crowdfundbet` VALUES ('10117', '20210307042', '10000126', 'Addison', '00000005546', '2021030704253004', '1615132183');
INSERT INTO `crowdfundbet` VALUES ('10118', '20210307042', '12', 'ssjj', '00000000021', '2021030704253025', '1615132223');
INSERT INTO `crowdfundbet` VALUES ('10119', '20210307042', '12', 'ssjj', '00000000021', '2021030704253046', '1615132225');
INSERT INTO `crowdfundbet` VALUES ('10120', '20210307042', '12', 'ssjj', '00000000035', '2021030704253081', '1615132233');
INSERT INTO `crowdfundbet` VALUES ('10121', '20210307042', '10000107', 'Barry', '00000004692', '2021030704257773', '1615132243');
INSERT INTO `crowdfundbet` VALUES ('10122', '20210307042', '11', 'Mozi2019', '00000000200', '2021030704257973', '1615132262');
INSERT INTO `crowdfundbet` VALUES ('10123', '20210307042', '12', 'ssjj', '00000001000', '2021030704258973', '1615132267');
INSERT INTO `crowdfundbet` VALUES ('10124', '20210307042', '10000054', 'deirdre', '00000001114', '2021030704260087', '1615132363');
INSERT INTO `crowdfundbet` VALUES ('10125', '20210307042', '10000018', 'amaris', '00000005082', '2021030704265169', '1615132423');
INSERT INTO `crowdfundbet` VALUES ('10126', '20210307042', '10000009', 'desdemona', '00000003047', '2021030704268216', '1615132483');
INSERT INTO `crowdfundbet` VALUES ('10127', '20210307042', '10000167', 'मदन', '00000001262', '2021030704269478', '1615132543');
INSERT INTO `crowdfundbet` VALUES ('10128', '20210307042', '10000148', 'Jacquelyn', '00000000616', '2021030704270094', '1615132603');
INSERT INTO `crowdfundbet` VALUES ('10129', '20210307042', '10000115', 'Abraham', '00000001945', '2021030704272039', '1615132663');
INSERT INTO `crowdfundbet` VALUES ('10130', '20210307042', '10000096', 'Queen ', '00000001792', '2021030704273831', '1615132723');
INSERT INTO `crowdfundbet` VALUES ('10131', '20210307042', '10000059', 'lilith', '00000005000', '2021030704278831', '1615132783');
INSERT INTO `crowdfundbet` VALUES ('10132', '20210307042', '10000040', 'danae', '00000003079', '2021030704281910', '1615132843');
INSERT INTO `crowdfundbet` VALUES ('10133', '20210307042', '10000005', 'ulrica', '00000018090', '20210307042100000', '1615132903');
INSERT INTO `crowdfundbet` VALUES ('10134', '20210307042', '10000188', 'प्राणजीवन', '00000000000', '20210307042100000', '1615132963');
INSERT INTO `crowdfundbet` VALUES ('10135', '20210307042', '10000154', 'गुरुदट', '00000000000', '20210307042100000', '1615133023');
INSERT INTO `crowdfundbet` VALUES ('10136', '20210307043', '10000102', 'Warren', '00000001430', '202103070431430', '1615133143');
INSERT INTO `crowdfundbet` VALUES ('10137', '20210307043', '10000085', 'Insane', '00000001529', '202103070432959', '1615133203');
INSERT INTO `crowdfundbet` VALUES ('10138', '20210307043', '10000048', 'angelinasakura', '00000005803', '202103070438762', '1615133263');
INSERT INTO `crowdfundbet` VALUES ('10139', '20210307043', '10000029', 'delores', '00000004840', '2021030704313602', '1615133323');
INSERT INTO `crowdfundbet` VALUES ('10140', '20210307043', '10000196', 'रसपरयान', '00000000284', '2021030704313886', '1615133383');
INSERT INTO `crowdfundbet` VALUES ('10141', '20210307043', '10000178', 'नवरंग', '00000000560', '2021030704314446', '1615133443');
INSERT INTO `crowdfundbet` VALUES ('10142', '20210307043', '10000143', 'Harriet', '00000002071', '2021030704316517', '1615133503');
INSERT INTO `crowdfundbet` VALUES ('10143', '20210307043', '10000126', 'Addison', '00000000609', '2021030704317126', '1615133563');
INSERT INTO `crowdfundbet` VALUES ('10144', '20210307043', '10000091', 'Mental ', '00000005143', '2021030704322269', '1615133623');
INSERT INTO `crowdfundbet` VALUES ('10145', '20210307043', '10000070', 'AllyZhang', '00000004767', '2021030704327036', '1615133683');
INSERT INTO `crowdfundbet` VALUES ('10146', '20210307043', '10000035', 'anemone', '00000002168', '2021030704329204', '1615133743');
INSERT INTO `crowdfundbet` VALUES ('10147', '20210307043', '10000018', 'amaris', '00000000659', '2021030704329863', '1615133803');
INSERT INTO `crowdfundbet` VALUES ('10148', '20210307043', '10000183', 'परमजीत', '00000006153', '2021030704336016', '1615133863');
INSERT INTO `crowdfundbet` VALUES ('10149', '20210307043', '10000166', 'काशीनाथ', '00000003652', '2021030704339668', '1615133923');
INSERT INTO `crowdfundbet` VALUES ('10150', '20210307043', '10000132', 'Larissa', '00000005095', '2021030704344763', '1615133983');
INSERT INTO `crowdfundbet` VALUES ('10151', '20210307043', '10000114', 'Wesley', '00000003552', '2021030704348315', '1615134043');
INSERT INTO `crowdfundbet` VALUES ('10152', '20210307043', '10000078', 'James', '00000006645', '2021030704354960', '1615134103');
INSERT INTO `crowdfundbet` VALUES ('10153', '20210307043', '10000059', 'lilith', '00000004144', '2021030704359104', '1615134163');
INSERT INTO `crowdfundbet` VALUES ('10154', '20210307043', '10000023', 'serafina', '00000004129', '2021030704363233', '1615134223');
INSERT INTO `crowdfundbet` VALUES ('10155', '20210307043', '10000004', 'cassiel', '00000000670', '2021030704363903', '1615134283');
INSERT INTO `crowdfundbet` VALUES ('10156', '20210307043', '10000172', 'मार्तंड', '00000002181', '2021030704366084', '1615134343');
INSERT INTO `crowdfundbet` VALUES ('10157', '20210307043', '10000153', 'गोविंद', '00000001591', '2021030704367675', '1615134403');
INSERT INTO `crowdfundbet` VALUES ('10158', '20210307043', '10000120', 'Bill', '00000006613', '2021030704374288', '1615134463');
INSERT INTO `crowdfundbet` VALUES ('10159', '20210307043', '10000101', 'Carl', '00000000954', '2021030704375242', '1615134523');
INSERT INTO `crowdfundbet` VALUES ('10160', '20210307043', '10000064', 'kira', '00000003796', '2021030704379038', '1615134583');
INSERT INTO `crowdfundbet` VALUES ('10161', '20210307043', '10000046', 'sicily', '00000002590', '2021030704381628', '1615134643');
INSERT INTO `crowdfundbet` VALUES ('10162', '20210307043', '10000012', 'louise', '00000018372', '20210307043100000', '1615134703');
INSERT INTO `crowdfundbet` VALUES ('10163', '20210307043', '10000194', 'रामानुज', '00000000000', '20210307043100000', '1615134763');
INSERT INTO `crowdfundbet` VALUES ('10164', '20210307043', '10000159', 'हर्षिता', '00000000000', '20210307043100000', '1615134823');
INSERT INTO `crowdfundbet` VALUES ('10165', '20210307044', '10000109', 'Albert', '00000003677', '202103070443677', '1615134943');
INSERT INTO `crowdfundbet` VALUES ('10166', '20210307044', '10000090', 'autistic ', '00000004120', '202103070447797', '1615135003');
INSERT INTO `crowdfundbet` VALUES ('10167', '20210307044', '10000054', 'deirdre', '00000005428', '2021030704413225', '1615135063');
INSERT INTO `crowdfundbet` VALUES ('10168', '20210307044', '10000034', 'amaryllis', '00000006187', '2021030704419412', '1615135123');
INSERT INTO `crowdfundbet` VALUES ('10169', '20210307044', '10000184', 'परिक्षित', '00000002971', '2021030704422383', '1615135243');
INSERT INTO `crowdfundbet` VALUES ('10170', '20210307044', '10000149', 'Irene', '00000001349', '2021030704423732', '1615135303');
INSERT INTO `crowdfundbet` VALUES ('10171', '20210307044', '10000132', 'Larissa', '00000000545', '2021030704424277', '1615135363');
INSERT INTO `crowdfundbet` VALUES ('10172', '20210307044', '10000097', 'Thunder', '00000005947', '2021030704430224', '1615135423');
INSERT INTO `crowdfundbet` VALUES ('10173', '20210307044', '10000078', 'James', '00000006083', '2021030704436307', '1615135483');
INSERT INTO `crowdfundbet` VALUES ('10174', '20210307044', '10000042', 'felicia', '00000006284', '2021030704442591', '1615135543');
INSERT INTO `crowdfundbet` VALUES ('10175', '20210307044', '8', '555', '00000000005', '2021030704442596', '1615135642');
INSERT INTO `crowdfundbet` VALUES ('10176', '20210307044', '8', '555', '00000000005', '2021030704442601', '1615135643');
INSERT INTO `crowdfundbet` VALUES ('10177', '20210307044', '8', '555', '00000000005', '2021030704442606', '1615135644');
INSERT INTO `crowdfundbet` VALUES ('10178', '20210307044', '8', '555', '00000000005', '2021030704442611', '1615135644');
INSERT INTO `crowdfundbet` VALUES ('10179', '20210307044', '8', '555', '00000000005', '2021030704442616', '1615135645');
INSERT INTO `crowdfundbet` VALUES ('10180', '20210307044', '8', '555', '00000000005', '2021030704442621', '1615135645');
INSERT INTO `crowdfundbet` VALUES ('10181', '20210307044', '8', '555', '00000000005', '2021030704442626', '1615135646');
INSERT INTO `crowdfundbet` VALUES ('10182', '20210307044', '8', '555', '00000000005', '2021030704442631', '1615135646');
INSERT INTO `crowdfundbet` VALUES ('10183', '20210307044', '8', '555', '00000000005', '2021030704442636', '1615135646');
INSERT INTO `crowdfundbet` VALUES ('10184', '20210307044', '8', '555', '00000000005', '2021030704442641', '1615135646');
INSERT INTO `crowdfundbet` VALUES ('10185', '20210307044', '8', '555', '00000000005', '2021030704442646', '1615135647');
INSERT INTO `crowdfundbet` VALUES ('10186', '20210307044', '8', '555', '00000000005', '2021030704442651', '1615135647');
INSERT INTO `crowdfundbet` VALUES ('10187', '20210307044', '8', '555', '00000000005', '2021030704442656', '1615135648');
INSERT INTO `crowdfundbet` VALUES ('10188', '20210307044', '8', '555', '00000000005', '2021030704442661', '1615135648');
INSERT INTO `crowdfundbet` VALUES ('10189', '20210307044', '8', '555', '00000000006', '2021030704442667', '1615135649');
INSERT INTO `crowdfundbet` VALUES ('10190', '20210307044', '8', '555', '00000000006', '2021030704442673', '1615135649');
INSERT INTO `crowdfundbet` VALUES ('10191', '20210307044', '8', '555', '00000000006', '2021030704442679', '1615135649');
INSERT INTO `crowdfundbet` VALUES ('10192', '20210307044', '10000190', 'राधानाथ', '00000000024', '2021030704442703', '1615135663');
INSERT INTO `crowdfundbet` VALUES ('10193', '20210307044', '10000173', 'नाडिश', '00000006540', '2021030704449243', '1615135723');
INSERT INTO `crowdfundbet` VALUES ('10194', '20210307044', '10000139', 'Easter', '00000003539', '2021030704452782', '1615135783');
INSERT INTO `crowdfundbet` VALUES ('10195', '20210307044', '10000100', 'Wilson', '00000000201', '2021030704452983', '1615135906');
INSERT INTO `crowdfundbet` VALUES ('10196', '20210307044', '10', 'daxiong', '00000000012', '2021030704452995', '1615136119');
INSERT INTO `crowdfundbet` VALUES ('10197', '20210307044', '10000126', 'Addison', '00000002831', '2021030704455826', '1615136806');
INSERT INTO `crowdfundbet` VALUES ('10198', '20210307044', '10000091', 'Mental ', '00000006575', '2021030704462401', '1615136866');
INSERT INTO `crowdfundbet` VALUES ('10199', '20210307044', '10000036', 'cytheria', '00000001682', '2021030704464083', '1615136986');
INSERT INTO `crowdfundbet` VALUES ('10200', '20210307044', '10000019', 'sicily', '00000004292', '2021030704468375', '1615137046');
INSERT INTO `crowdfundbet` VALUES ('10201', '20210307044', '10000184', 'परिक्षित', '00000004872', '2021030704473247', '1615137106');
INSERT INTO `crowdfundbet` VALUES ('10202', '20210307044', '10000167', 'मदन', '00000001277', '2021030704474524', '1615137166');
INSERT INTO `crowdfundbet` VALUES ('10203', '20210307044', '10000133', 'Caiden', '00000003079', '2021030704477603', '1615137226');
INSERT INTO `crowdfundbet` VALUES ('10204', '20210307044', '10000115', 'Abraham', '00000003741', '2021030704481344', '1615137286');
INSERT INTO `crowdfundbet` VALUES ('10205', '20210307044', '10000079', 'Henry', '00000001463', '2021030704482807', '1615137346');
INSERT INTO `crowdfundbet` VALUES ('10206', '20210307044', '10000060', 'lorelei', '00000000249', '2021030704483056', '1615137406');
INSERT INTO `crowdfundbet` VALUES ('10207', '20210307044', '10000024', 'karida', '00000016944', '20210307044100000', '1615137466');
INSERT INTO `crowdfundbet` VALUES ('10208', '20210307044', '10000005', 'ulrica', '00000000000', '20210307044100000', '1615137526');
INSERT INTO `crowdfundbet` VALUES ('10209', '20210307044', '10000173', 'नाडिश', '00000000000', '20210307044100000', '1615137586');
INSERT INTO `crowdfundbet` VALUES ('10210', '20210307045', '10000122', 'Peter', '00000003637', '202103070453637', '1615137706');
INSERT INTO `crowdfundbet` VALUES ('10211', '20210307045', '10000103', 'James', '00000000033', '202103070453670', '1615137766');
INSERT INTO `crowdfundbet` VALUES ('10212', '20210307045', '10000066', 'cyrene', '00000005343', '202103070459013', '1615137826');
INSERT INTO `crowdfundbet` VALUES ('10213', '20210307045', '10000048', 'angelinasakura', '00000002506', '2021030704511519', '1615137886');
INSERT INTO `crowdfundbet` VALUES ('10214', '20210307045', '10000014', 'chloe', '00000000321', '2021030704511840', '1615137946');
INSERT INTO `crowdfundbet` VALUES ('10215', '20210307045', '10000196', 'रसपरयान', '00000003422', '2021030704515262', '1615138006');
INSERT INTO `crowdfundbet` VALUES ('10216', '20210307045', '10000161', 'ऋषिकेश', '00000000717', '2021030704515979', '1615138066');
INSERT INTO `crowdfundbet` VALUES ('10217', '20210307045', '10000144', 'Gwendolyn', '00000003564', '2021030704519543', '1615138126');
INSERT INTO `crowdfundbet` VALUES ('10218', '20210307045', '10000110', 'Bruce', '00000000999', '2021030704520542', '1615138186');
INSERT INTO `crowdfundbet` VALUES ('10219', '20210307045', '10000091', 'Mental ', '00000001042', '2021030704521584', '1615138246');
INSERT INTO `crowdfundbet` VALUES ('10220', '20210307045', '10000055', 'desdemona', '00000003252', '2021030704524836', '1615138306');
INSERT INTO `crowdfundbet` VALUES ('10221', '20210307045', '10000035', 'anemone', '00000004286', '2021030704529122', '1615138366');
INSERT INTO `crowdfundbet` VALUES ('10222', '20210307045', '10000000', 'michelle', '00000004035', '2021030704533157', '1615138426');
INSERT INTO `crowdfundbet` VALUES ('10223', '20210307045', '10000184', 'परिक्षित', '00000002869', '2021030704536026', '1615138486');
INSERT INTO `crowdfundbet` VALUES ('10224', '20210307045', '10000149', 'Irene', '00000006383', '2021030704542409', '1615138546');
INSERT INTO `crowdfundbet` VALUES ('10225', '20210307045', '10000132', 'Larissa', '00000004034', '2021030704546443', '1615138606');
INSERT INTO `crowdfundbet` VALUES ('10226', '20210307045', '10000097', 'Thunder', '00000001336', '2021030704547779', '1615138666');
INSERT INTO `crowdfundbet` VALUES ('10227', '20210307045', '10000078', 'James', '00000005915', '2021030704553694', '1615138726');
INSERT INTO `crowdfundbet` VALUES ('10228', '20210307045', '10000042', 'felicia', '00000001853', '2021030704555547', '1615138786');
INSERT INTO `crowdfundbet` VALUES ('10229', '20210307045', '10000024', 'karida', '00000005952', '2021030704561499', '1615138846');
INSERT INTO `crowdfundbet` VALUES ('10230', '20210307045', '10000189', 'प्रीतम', '00000002833', '2021030704564332', '1615138906');
INSERT INTO `crowdfundbet` VALUES ('10231', '20210307045', '10000172', 'मार्तंड', '00000004504', '2021030704568836', '1615138966');
INSERT INTO `crowdfundbet` VALUES ('10232', '20210307045', '10000138', 'Andrew', '00000001485', '2021030704570321', '1615139026');
INSERT INTO `crowdfundbet` VALUES ('10233', '20210307045', '10000120', 'Bill', '00000006233', '2021030704576554', '1615139086');
INSERT INTO `crowdfundbet` VALUES ('10234', '20210307045', '10000085', 'Insane', '00000001935', '2021030704578489', '1615139146');
INSERT INTO `crowdfundbet` VALUES ('10235', '20210307045', '10000065', 'kimi', '00000000272', '2021030704578761', '1615139206');
INSERT INTO `crowdfundbet` VALUES ('10236', '20210307045', '10000029', 'delores', '00000021239', '20210307045100000', '1615139266');
INSERT INTO `crowdfundbet` VALUES ('10237', '20210307045', '10000012', 'louise', '00000000000', '20210307045100000', '1615139326');
INSERT INTO `crowdfundbet` VALUES ('10238', '20210307045', '10000178', 'नवरंग', '00000000000', '20210307045100000', '1615139386');
INSERT INTO `crowdfundbet` VALUES ('10239', '20210307046', '10000127', 'Alex', '00000004464', '202103070464464', '1615139506');
INSERT INTO `crowdfundbet` VALUES ('10240', '20210307046', '10000110', 'Bruce', '00000000160', '202103070464624', '1615139566');
INSERT INTO `crowdfundbet` VALUES ('10241', '20210307046', '10000072', 'Charles', '00000001797', '202103070466421', '1615139626');
INSERT INTO `crowdfundbet` VALUES ('10242', '20210307046', '10000054', 'deirdre', '00000000413', '202103070466834', '1615139686');
INSERT INTO `crowdfundbet` VALUES ('10243', '20210307046', '10000019', 'sicily', '00000006504', '2021030704613338', '1615139746');
INSERT INTO `crowdfundbet` VALUES ('10244', '20210307046', '10000009', 'desdemona', '00000001090', '2021030704614428', '1615139806');
INSERT INTO `crowdfundbet` VALUES ('10245', '20210307046', '10000167', 'मदन', '00000006495', '2021030704620923', '1615139866');
INSERT INTO `crowdfundbet` VALUES ('10246', '20210307046', '10000149', 'Irene', '00000004621', '2021030704625544', '1615139926');
INSERT INTO `crowdfundbet` VALUES ('10247', '20210307046', '10000115', 'Abraham', '00000003054', '2021030704628598', '1615139986');
INSERT INTO `crowdfundbet` VALUES ('10248', '20210307046', '10000096', 'Queen ', '00000006622', '2021030704635220', '1615140046');
INSERT INTO `crowdfundbet` VALUES ('10249', '20210307046', '10000060', 'lorelei', '00000006273', '2021030704641493', '1615140106');
INSERT INTO `crowdfundbet` VALUES ('10250', '20210307046', '10000006', 'quella', '00000005108', '2021030704646601', '1615140226');
INSERT INTO `crowdfundbet` VALUES ('10251', '20210307046', '10000190', 'राधानाथ', '00000004888', '2021030704651489', '1615140286');
INSERT INTO `crowdfundbet` VALUES ('10252', '20210307046', '10000139', 'Easter', '00000002446', '2021030704653935', '1615140406');
INSERT INTO `crowdfundbet` VALUES ('10253', '20210307046', '10000104', 'Kevin', '00000004711', '2021030704658646', '1615140466');
INSERT INTO `crowdfundbet` VALUES ('10254', '20210307046', '10000086', 'Figure ', '00000003347', '2021030704661993', '1615140526');
INSERT INTO `crowdfundbet` VALUES ('10255', '20210307046', '10000049', 'fiona', '00000006113', '2021030704668106', '1615140586');
INSERT INTO `crowdfundbet` VALUES ('10256', '20210307046', '10000198', 'रौनक', '00000000474', '2021030704668580', '1615140706');
INSERT INTO `crowdfundbet` VALUES ('10257', '20210307046', '10000180', 'निरहानकर', '00000002971', '2021030704671551', '1615140766');
INSERT INTO `crowdfundbet` VALUES ('10258', '20210307046', '10000146', 'Diego', '00000002014', '2021030704673565', '1615140826');
INSERT INTO `crowdfundbet` VALUES ('10259', '20210307046', '10000128', 'Ryan', '00000003815', '2021030704677380', '1615140886');
INSERT INTO `crowdfundbet` VALUES ('10260', '20210307046', '10000093', 'Luminary ', '00000004639', '2021030704682019', '1615140946');
INSERT INTO `crowdfundbet` VALUES ('10261', '20210307046', '10000075', 'Vincent', '00000005166', '2021030704687185', '1615141006');
INSERT INTO `crowdfundbet` VALUES ('10262', '20210307046', '10000037', 'gina', '00000012815', '20210307046100000', '1615141066');
INSERT INTO `crowdfundbet` VALUES ('10263', '20210307046', '10000020', 'cecile', '00000000000', '20210307046100000', '1615141126');
INSERT INTO `crowdfundbet` VALUES ('10264', '20210307046', '10000186', 'पवनाज', '00000000000', '20210307046100000', '1615141186');
INSERT INTO `crowdfundbet` VALUES ('10265', '20210307047', '10000135', 'Leon', '00000004682', '202103070474682', '1615141306');
INSERT INTO `crowdfundbet` VALUES ('10266', '20210307047', '10000118', 'Ben', '00000005148', '202103070479830', '1615141366');
INSERT INTO `crowdfundbet` VALUES ('10267', '20210307047', '10000081', 'Martin', '00000001753', '2021030704711583', '1615141426');
INSERT INTO `crowdfundbet` VALUES ('10268', '20210307047', '10000062', 'melantha', '00000003050', '2021030704714633', '1615141486');
INSERT INTO `crowdfundbet` VALUES ('10269', '20210307047', '10000027', 'fiona', '00000001470', '2021030704716103', '1615141546');
INSERT INTO `crowdfundbet` VALUES ('10270', '20210307047', '10000007', 'cecilia', '00000005092', '2021030704721195', '1615141606');
INSERT INTO `crowdfundbet` VALUES ('10271', '20210307047', '10000175', 'नरोत्तम', '00000004950', '2021030704726145', '1615141666');
INSERT INTO `crowdfundbet` VALUES ('10272', '20210307047', '10000157', 'हरिप्रीत', '00000005223', '2021030704731368', '1615141726');
INSERT INTO `crowdfundbet` VALUES ('10273', '20210307047', '10000105', 'Solomon', '00000003396', '2021030704734764', '1615141846');
INSERT INTO `crowdfundbet` VALUES ('10274', '20210307047', '10000069', 'LenaKong', '00000000235', '2021030704734999', '1615141906');
INSERT INTO `crowdfundbet` VALUES ('10275', '20210307047', '10000050', 'elodie', '00000002189', '2021030704737188', '1615141966');
INSERT INTO `crowdfundbet` VALUES ('10276', '20210307047', '10000016', 'snow', '00000002215', '2021030704739403', '1615142026');
INSERT INTO `crowdfundbet` VALUES ('10277', '20210307047', '10000199', 'रोशन', '00000001606', '2021030704741009', '1615142086');
INSERT INTO `crowdfundbet` VALUES ('10278', '20210307047', '10000163', 'कंवर', '00000002870', '2021030704743879', '1615142146');
INSERT INTO `crowdfundbet` VALUES ('10279', '20210307047', '10000146', 'Diego', '00000000293', '2021030704744172', '1615142206');
INSERT INTO `crowdfundbet` VALUES ('10280', '20210307047', '10000113', 'Denny', '00000006589', '2021030704750761', '1615142266');
INSERT INTO `crowdfundbet` VALUES ('10281', '20210307047', '10000093', 'Luminary ', '00000004744', '2021030704755505', '1615142326');
INSERT INTO `crowdfundbet` VALUES ('10282', '20210307047', '10000057', 'anemone', '00000005558', '2021030704761063', '1615142386');
INSERT INTO `crowdfundbet` VALUES ('10283', '20210307047', '10000038', 'laraine', '00000001034', '2021030704762097', '1615142446');
INSERT INTO `crowdfundbet` VALUES ('10284', '20210307047', '10000002', 'gabrielle', '00000004911', '2021030704767008', '1615142506');
INSERT INTO `crowdfundbet` VALUES ('10285', '20210307047', '10000186', 'पवनाज', '00000006387', '2021030704773395', '1615142566');
INSERT INTO `crowdfundbet` VALUES ('10286', '20210307047', '10000152', 'गजेंद्र', '00000006393', '2021030704779788', '1615142626');
INSERT INTO `crowdfundbet` VALUES ('10287', '20210307047', '10000134', 'Kelly', '00000001329', '2021030704781117', '1615142686');
INSERT INTO `crowdfundbet` VALUES ('10288', '20210307047', '10000099', 'Estrus ', '00000005142', '2021030704786259', '1615142746');
INSERT INTO `crowdfundbet` VALUES ('10289', '20210307047', '10000081', 'Martin', '00000000879', '2021030704787138', '1615142806');
INSERT INTO `crowdfundbet` VALUES ('10290', '20210307047', '10000044', 'celina', '00000012862', '20210307047100000', '1615142866');
INSERT INTO `crowdfundbet` VALUES ('10291', '20210307047', '10000026', 'blanche', '00000000000', '20210307047100000', '1615142926');
INSERT INTO `crowdfundbet` VALUES ('10292', '20210307047', '10000192', 'रामभद्र', '00000000000', '20210307047100000', '1615142986');
INSERT INTO `crowdfundbet` VALUES ('10293', '20210308000', '10000141', 'Alex', '00000005434', '202103080005434', '1615143106');
INSERT INTO `crowdfundbet` VALUES ('10294', '20210308000', '10000124', 'Kelly', '00000003463', '202103080008897', '1615143166');
INSERT INTO `crowdfundbet` VALUES ('10295', '20210308000', '10000088', 'Allure', '00000002978', '2021030800011875', '1615143226');
INSERT INTO `crowdfundbet` VALUES ('10296', '20210308000', '10000068', 'clamp', '00000003107', '2021030800014982', '1615143286');
INSERT INTO `crowdfundbet` VALUES ('10297', '20210308000', '10000033', 'amaya', '00000003540', '2021030800018522', '1615143346');
INSERT INTO `crowdfundbet` VALUES ('10298', '20210308000', '10000015', 'felicia', '00000001483', '2021030800020005', '1615143406');
INSERT INTO `crowdfundbet` VALUES ('10299', '20210308000', '10000181', 'पलाश', '00000000182', '2021030800020187', '1615143466');
INSERT INTO `crowdfundbet` VALUES ('10300', '20210308000', '10000163', 'कंवर', '00000006102', '2021030800026289', '1615143526');
INSERT INTO `crowdfundbet` VALUES ('10301', '20210308000', '10000129', 'Aidan', '00000004195', '2021030800030484', '1615143586');
INSERT INTO `crowdfundbet` VALUES ('10302', '20210308000', '10000112', 'Charles', '00000005408', '2021030800035892', '1615143646');
INSERT INTO `crowdfundbet` VALUES ('10303', '20210308000', '10000076', 'William', '00000004894', '2021030800040786', '1615143706');
INSERT INTO `crowdfundbet` VALUES ('10304', '20210308000', '10000022', 'sera', '00000004227', '2021030800045013', '1615143826');
INSERT INTO `crowdfundbet` VALUES ('10305', '20210308000', '10000003', 'raffaella ', '00000003885', '2021030800048898', '1615143886');
INSERT INTO `crowdfundbet` VALUES ('10306', '20210308000', '10000170', 'महंत', '00000005118', '2021030800054016', '1615143946');
INSERT INTO `crowdfundbet` VALUES ('10307', '20210308000', '10000120', 'Bill', '00000005503', '2021030800059519', '1615144066');
INSERT INTO `crowdfundbet` VALUES ('10308', '20210308000', '10000100', 'Wilson', '00000003902', '2021030800063421', '1615144126');
INSERT INTO `crowdfundbet` VALUES ('10309', '20210308000', '10000047', 'cecile', '00000003720', '2021030800067141', '1615144246');
INSERT INTO `crowdfundbet` VALUES ('10310', '20210308000', '10000012', 'louise', '00000001678', '2021030800068819', '1615144306');
INSERT INTO `crowdfundbet` VALUES ('10311', '20210308000', '10000195', 'रामप्रसाद', '00000001336', '2021030800070155', '1615144366');
INSERT INTO `crowdfundbet` VALUES ('10312', '20210308000', '10000160', 'हेमदेव', '00000001639', '2021030800071794', '1615144426');
INSERT INTO `crowdfundbet` VALUES ('10313', '20210308000', '10000142', 'Tankard', '00000005382', '2021030800077176', '1615144486');
INSERT INTO `crowdfundbet` VALUES ('10314', '20210308000', '10000109', 'Albert', '00000006440', '2021030800083616', '1615144546');
INSERT INTO `crowdfundbet` VALUES ('10315', '20210308000', '10000090', 'autistic ', '00000003948', '2021030800087564', '1615144606');
INSERT INTO `crowdfundbet` VALUES ('10316', '20210308000', '10000053', 'claudia', '00000012436', '20210308000100000', '1615144666');
INSERT INTO `crowdfundbet` VALUES ('10317', '20210308000', '10000034', 'amaryllis', '00000000000', '20210308000100000', '1615144726');
INSERT INTO `crowdfundbet` VALUES ('10318', '20210308000', '10000009', 'desdemona', '00000000000', '20210308000100000', '1615144786');
INSERT INTO `crowdfundbet` VALUES ('10319', '20210308001', '10000149', 'Irene', '00000002193', '202103080012193', '1615144906');
INSERT INTO `crowdfundbet` VALUES ('10320', '20210308001', '10000132', 'Larissa', '00000000624', '202103080012817', '1615144966');
INSERT INTO `crowdfundbet` VALUES ('10321', '20210308001', '10000096', 'Queen ', '00000001308', '202103080014125', '1615145026');
INSERT INTO `crowdfundbet` VALUES ('10322', '20210308001', '10000078', 'James', '00000001565', '202103080015690', '1615145086');
INSERT INTO `crowdfundbet` VALUES ('10323', '20210308001', '10000042', 'felicia', '00000004336', '2021030800110026', '1615145146');
INSERT INTO `crowdfundbet` VALUES ('10324', '20210308001', '10000023', 'serafina', '00000004191', '2021030800114217', '1615145206');
INSERT INTO `crowdfundbet` VALUES ('10325', '20210308001', '10000189', 'प्रीतम', '00000001778', '2021030800115995', '1615145266');
INSERT INTO `crowdfundbet` VALUES ('10326', '20210308001', '10000172', 'मार्तंड', '00000004031', '2021030800120026', '1615145326');
INSERT INTO `crowdfundbet` VALUES ('10327', '20210308001', '10000137', 'Albert', '00000003553', '2021030800123579', '1615145386');
INSERT INTO `crowdfundbet` VALUES ('10328', '20210308001', '10000120', 'Bill', '00000002690', '2021030800126269', '1615145446');
INSERT INTO `crowdfundbet` VALUES ('10329', '20210308001', '10000085', 'Insane', '00000002318', '2021030800128587', '1615145506');
INSERT INTO `crowdfundbet` VALUES ('10330', '20210308001', '10000064', 'kira', '00000000328', '2021030800128915', '1615145566');
INSERT INTO `crowdfundbet` VALUES ('10331', '20210308001', '10000029', 'delores', '00000003363', '2021030800132278', '1615145626');
INSERT INTO `crowdfundbet` VALUES ('10332', '20210308001', '10000012', 'louise', '00000000606', '2021030800132884', '1615145686');
INSERT INTO `crowdfundbet` VALUES ('10333', '20210308001', '10000177', 'नवद्वीप', '00000002332', '2021030800135216', '1615145746');
INSERT INTO `crowdfundbet` VALUES ('10334', '20210308001', '10000159', 'हर्षिता', '00000000341', '2021030800135557', '1615145806');
INSERT INTO `crowdfundbet` VALUES ('10335', '20210308001', '10000126', 'Addison', '00000005741', '2021030800141298', '1615145866');
INSERT INTO `crowdfundbet` VALUES ('10336', '20210308001', '10000107', 'Barry', '00000004952', '2021030800146250', '1615145926');
INSERT INTO `crowdfundbet` VALUES ('10337', '20210308001', '10000070', 'AllyZhang', '00000003348', '2021030800149598', '1615145986');
INSERT INTO `crowdfundbet` VALUES ('10338', '20210308001', '10000053', 'claudia', '00000002165', '2021030800151763', '1615146046');
INSERT INTO `crowdfundbet` VALUES ('10339', '20210308001', '10000017', 'celina', '00000002008', '2021030800153771', '1615146106');
INSERT INTO `crowdfundbet` VALUES ('10340', '20210308001', '10000106', 'Leon', '00000006257', '2021030800160028', '1615146166');
INSERT INTO `crowdfundbet` VALUES ('10341', '20210308001', '10000166', 'काशीनाथ', '00000004256', '2021030800164284', '1615146226');
INSERT INTO `crowdfundbet` VALUES ('10342', '20210308001', '10000147', 'Karen', '00000004286', '2021030800168570', '1615146286');
INSERT INTO `crowdfundbet` VALUES ('10343', '20210308001', '10000114', 'Wesley', '00000002549', '2021030800171119', '1615146346');
INSERT INTO `crowdfundbet` VALUES ('10344', '20210308001', '10000095', 'Ovdoes ', '00000003777', '2021030800174896', '1615146406');
INSERT INTO `crowdfundbet` VALUES ('10345', '20210308001', '10000058', 'michaela', '00000025104', '20210308001100000', '1615146466');
INSERT INTO `crowdfundbet` VALUES ('10346', '20210308001', '10000039', 'cecilia', '00000000000', '20210308001100000', '1615146526');
INSERT INTO `crowdfundbet` VALUES ('10347', '20210308001', '10000004', 'cassiel', '00000000000', '20210308001100000', '1615146586');
INSERT INTO `crowdfundbet` VALUES ('10348', '20210308002', '10000154', 'गुरुदट', '00000005330', '202103080025330', '1615146706');
INSERT INTO `crowdfundbet` VALUES ('10349', '20210308002', '10000137', 'Albert', '00000000579', '202103080025909', '1615146766');
INSERT INTO `crowdfundbet` VALUES ('10350', '20210308002', '10000101', 'Carl', '00000000978', '202103080026887', '1615146826');
INSERT INTO `crowdfundbet` VALUES ('10351', '20210308002', '10000083', 'Dirge ', '00000000653', '202103080027540', '1615146886');
INSERT INTO `crowdfundbet` VALUES ('10352', '20210308002', '10000047', 'cecile', '00000003427', '2021030800210967', '1615146946');
INSERT INTO `crowdfundbet` VALUES ('10353', '20210308002', '10000028', 'dolores', '00000004970', '2021030800215937', '1615147006');
INSERT INTO `crowdfundbet` VALUES ('10354', '20210308002', '10000195', 'रामप्रसाद', '00000003755', '2021030800219692', '1615147066');
INSERT INTO `crowdfundbet` VALUES ('10355', '20210308002', '10000177', 'नवद्वीप', '00000001366', '2021030800221058', '1615147126');
INSERT INTO `crowdfundbet` VALUES ('10356', '20210308002', '10000142', 'Tankard', '00000002650', '2021030800223708', '1615147186');
INSERT INTO `crowdfundbet` VALUES ('10357', '20210308002', '10000125', 'Easter', '00000005111', '2021030800228819', '1615147246');
INSERT INTO `crowdfundbet` VALUES ('10358', '20210308002', '10000090', 'autistic ', '00000001113', '2021030800229932', '1615147306');
INSERT INTO `crowdfundbet` VALUES ('10359', '20210308002', '10000069', 'LenaKong', '00000004947', '2021030800234879', '1615147366');
INSERT INTO `crowdfundbet` VALUES ('10360', '20210308002', '10000034', 'amaryllis', '00000002643', '2021030800237522', '1615147426');
INSERT INTO `crowdfundbet` VALUES ('10361', '20210308002', '10000017', 'celina', '00000003980', '2021030800241502', '1615147486');
INSERT INTO `crowdfundbet` VALUES ('10362', '20210308002', '10000182', 'परांजॉय', '00000002227', '2021030800243729', '1615147546');
INSERT INTO `crowdfundbet` VALUES ('10363', '20210308002', '10000164', 'कर्मजीत', '00000002422', '2021030800246151', '1615147606');
INSERT INTO `crowdfundbet` VALUES ('10364', '20210308002', '10000131', 'Tommy', '00000001843', '2021030800247994', '1615147666');
INSERT INTO `crowdfundbet` VALUES ('10365', '20210308002', '10000113', 'Denny', '00000001947', '2021030800249941', '1615147726');
INSERT INTO `crowdfundbet` VALUES ('10366', '20210308002', '10000077', 'Joseph', '00000001644', '2021030800251585', '1615147786');
INSERT INTO `crowdfundbet` VALUES ('10367', '20210308002', '10000058', 'michaela', '00000000004', '2021030800251589', '1615147846');
INSERT INTO `crowdfundbet` VALUES ('10368', '20210308002', '10000022', 'sera', '00000004441', '2021030800256030', '1615147906');
INSERT INTO `crowdfundbet` VALUES ('10369', '20210308002', '10000003', 'raffaella ', '00000005692', '2021030800261722', '1615147966');
INSERT INTO `crowdfundbet` VALUES ('10370', '20210308002', '10000171', 'मनमोहन', '00000003423', '2021030800265145', '1615148026');
INSERT INTO `crowdfundbet` VALUES ('10371', '20210308002', '10000152', 'गजेंद्र', '00000001476', '2021030800266621', '1615148086');
INSERT INTO `crowdfundbet` VALUES ('10372', '20210308002', '10000119', 'Evan', '00000001086', '2021030800267707', '1615148146');
INSERT INTO `crowdfundbet` VALUES ('10373', '20210308002', '10000100', 'Wilson', '00000001654', '2021030800269361', '1615148206');
INSERT INTO `crowdfundbet` VALUES ('10374', '20210308002', '10000063', 'sade', '00000030639', '20210308002100000', '1615148266');
INSERT INTO `crowdfundbet` VALUES ('10375', '20210308002', '10000045', 'amaris', '00000000000', '20210308002100000', '1615148326');
INSERT INTO `crowdfundbet` VALUES ('10376', '20210308002', '10000011', 'izefia', '00000000000', '20210308002100000', '1615148386');
INSERT INTO `crowdfundbet` VALUES ('10377', '20210308003', '10000159', 'हर्षिता', '00000005165', '202103080035165', '1615148506');
INSERT INTO `crowdfundbet` VALUES ('10378', '20210308003', '10000142', 'Tankard', '00000006127', '2021030800311292', '1615148566');
INSERT INTO `crowdfundbet` VALUES ('10379', '20210308003', '10000090', 'autistic ', '00000000665', '2021030800311957', '1615148686');
INSERT INTO `crowdfundbet` VALUES ('10380', '20210308003', '10000054', 'deirdre', '00000006192', '2021030800318149', '1615148746');
INSERT INTO `crowdfundbet` VALUES ('10381', '20210308003', '10000034', 'amaryllis', '00000001867', '2021030800320016', '1615148806');
INSERT INTO `crowdfundbet` VALUES ('10382', '20210308003', '10000009', 'desdemona', '00000006307', '2021030800326323', '1615148866');
INSERT INTO `crowdfundbet` VALUES ('10383', '20210308003', '10000183', 'परमजीत', '00000003168', '2021030800329491', '1615148926');
INSERT INTO `crowdfundbet` VALUES ('10384', '20210308003', '10000148', 'Jacquelyn', '00000006457', '2021030800335948', '1615148986');
INSERT INTO `crowdfundbet` VALUES ('10385', '20210308003', '10000097', 'Thunder', '00000006234', '2021030800342182', '1615149106');
INSERT INTO `crowdfundbet` VALUES ('10386', '20210308003', '10000043', 'snow', '00000000335', '2021030800342517', '1615149226');
INSERT INTO `crowdfundbet` VALUES ('10387', '20210308003', '10000025', 'sakura', '00000004172', '2021030800346689', '1615149286');
INSERT INTO `crowdfundbet` VALUES ('10388', '20210308003', '10000190', 'राधानाथ', '00000000200', '2021030800346889', '1615149346');
INSERT INTO `crowdfundbet` VALUES ('10389', '20210308003', '10000173', 'नाडिश', '00000005729', '2021030800352618', '1615149406');
INSERT INTO `crowdfundbet` VALUES ('10390', '20210308003', '10000139', 'Easter', '00000002295', '2021030800354913', '1615149466');
INSERT INTO `crowdfundbet` VALUES ('10391', '20210308003', '10000121', 'Nick', '00000005984', '2021030800360897', '1615149526');
INSERT INTO `crowdfundbet` VALUES ('10392', '20210308003', '10000086', 'Figure ', '00000006087', '2021030800366984', '1615149586');
INSERT INTO `crowdfundbet` VALUES ('10393', '20210308003', '10000031', 'deirdre', '00000005091', '2021030800372075', '1615149706');
INSERT INTO `crowdfundbet` VALUES ('10394', '20210308003', '10000014', 'chloe', '00000004782', '2021030800376857', '1615149766');
INSERT INTO `crowdfundbet` VALUES ('10395', '20210308003', '10000162', 'कनेया', '00000003643', '2021030800380500', '1615149886');
INSERT INTO `crowdfundbet` VALUES ('10396', '20210308003', '10000129', 'Aidan', '00000002773', '2021030800383273', '1615149946');
INSERT INTO `crowdfundbet` VALUES ('10397', '20210308003', '10000112', 'Charles', '00000003533', '2021030800386806', '1615150006');
INSERT INTO `crowdfundbet` VALUES ('10398', '20210308003', '10000075', 'Vincent', '00000013194', '20210308003100000', '1615150066');
INSERT INTO `crowdfundbet` VALUES ('10399', '20210308003', '10000056', 'amaya', '00000000000', '20210308003100000', '1615150126');
INSERT INTO `crowdfundbet` VALUES ('10400', '20210308003', '10000021', 'angelina', '00000000000', '20210308003100000', '1615150186');
INSERT INTO `crowdfundbet` VALUES ('10401', '20210308004', '10000170', 'महंत', '00000002191', '202103080042191', '1615150306');
INSERT INTO `crowdfundbet` VALUES ('10402', '20210308004', '10000152', 'गजेंद्र', '00000001809', '202103080044000', '1615150366');
INSERT INTO `crowdfundbet` VALUES ('10403', '20210308004', '10000118', 'Ben', '00000001023', '202103080045023', '1615150426');
INSERT INTO `crowdfundbet` VALUES ('10404', '20210308004', '10000099', 'Estrus ', '00000006367', '2021030800411390', '1615150486');
INSERT INTO `crowdfundbet` VALUES ('10405', '20210308004', '10000063', 'sade', '00000000768', '2021030800412158', '1615150546');
INSERT INTO `crowdfundbet` VALUES ('10406', '20210308004', '10000044', 'celina', '00000001100', '2021030800413258', '1615150606');
INSERT INTO `crowdfundbet` VALUES ('10407', '20210308004', '10000008', 'claudia', '00000001495', '2021030800414753', '1615150666');
INSERT INTO `crowdfundbet` VALUES ('10408', '20210308004', '10000192', 'रामभद्र', '00000000948', '2021030800415701', '1615150726');
INSERT INTO `crowdfundbet` VALUES ('10409', '20210308004', '10000157', 'हरिप्रीत', '00000003903', '2021030800419604', '1615150786');
INSERT INTO `crowdfundbet` VALUES ('10410', '20210308004', '10000140', 'Alonso', '00000006428', '2021030800426032', '1615150846');
INSERT INTO `crowdfundbet` VALUES ('10411', '20210308004', '10000105', 'Solomon', '00000004098', '2021030800430130', '1615150906');
INSERT INTO `crowdfundbet` VALUES ('10412', '20210308004', '10000087', 'durance ', '00000000163', '2021030800430293', '1615150966');
INSERT INTO `crowdfundbet` VALUES ('10413', '20210308004', '10000050', 'elodie', '00000004036', '2021030800434329', '1615151026');
INSERT INTO `crowdfundbet` VALUES ('10414', '20210308004', '10000032', 'desdemona', '00000002348', '2021030800436677', '1615151086');
INSERT INTO `crowdfundbet` VALUES ('10415', '20210308004', '10000198', 'रौनक', '00000006213', '2021030800442890', '1615151146');
INSERT INTO `crowdfundbet` VALUES ('10416', '20210308004', '10000180', 'निरहानकर', '00000004055', '2021030800446945', '1615151206');
INSERT INTO `crowdfundbet` VALUES ('10417', '20210308004', '10000146', 'Diego', '00000003626', '2021030800450571', '1615151266');
INSERT INTO `crowdfundbet` VALUES ('10418', '20210308004', '10000128', 'Ryan', '00000004941', '2021030800455512', '1615151326');
INSERT INTO `crowdfundbet` VALUES ('10419', '20210308004', '10000093', 'Luminary ', '00000006417', '2021030800461929', '1615151386');
INSERT INTO `crowdfundbet` VALUES ('10420', '20210308004', '10000075', 'Vincent', '00000004032', '2021030800465961', '1615151446');
INSERT INTO `crowdfundbet` VALUES ('10421', '20210308004', '10000037', 'gina', '00000001929', '2021030800467890', '1615151506');
INSERT INTO `crowdfundbet` VALUES ('10422', '20210308004', '10000020', 'cecile', '00000005569', '2021030800473459', '1615151566');
INSERT INTO `crowdfundbet` VALUES ('10423', '20210308004', '10000186', 'पवनाज', '00000000815', '2021030800474274', '1615151626');
INSERT INTO `crowdfundbet` VALUES ('10424', '20210308004', '10000168', 'मदन मोहन', '00000000927', '2021030800475201', '1615151686');
INSERT INTO `crowdfundbet` VALUES ('10425', '20210308004', '10000134', 'Kelly', '00000001086', '2021030800476287', '1615151746');
INSERT INTO `crowdfundbet` VALUES ('10426', '20210308004', '10000117', 'Kenny', '00000001050', '2021030800477337', '1615151806');
INSERT INTO `crowdfundbet` VALUES ('10427', '20210308004', '10000080', 'Gary', '00000022663', '20210308004100000', '1615151866');
INSERT INTO `crowdfundbet` VALUES ('10428', '20210308004', '10000061', 'easter', '00000000000', '20210308004100000', '1615151926');
INSERT INTO `crowdfundbet` VALUES ('10429', '20210308004', '10000026', 'blanche', '00000000000', '20210308004100000', '1615151986');
INSERT INTO `crowdfundbet` VALUES ('10430', '20210308005', '10000175', 'नरोत्तम', '00000002048', '202103080052048', '1615152106');
INSERT INTO `crowdfundbet` VALUES ('10431', '20210308005', '10000157', 'हरिप्रीत', '00000005222', '202103080057270', '1615152166');
INSERT INTO `crowdfundbet` VALUES ('10432', '20210308005', '10000123', 'JasonJohnny', '00000003515', '2021030800510785', '1615152226');
INSERT INTO `crowdfundbet` VALUES ('10433', '20210308005', '10000104', 'Kevin', '00000006097', '2021030800516882', '1615152286');
INSERT INTO `crowdfundbet` VALUES ('10434', '20210308005', '10000050', 'elodie', '00000000618', '2021030800517500', '1615152406');
INSERT INTO `crowdfundbet` VALUES ('10435', '20210308005', '10000016', 'snow', '00000005127', '2021030800522627', '1615152466');
INSERT INTO `crowdfundbet` VALUES ('10436', '20210308005', '10000199', 'रोशन', '00000003462', '2021030800526089', '1615152526');
INSERT INTO `crowdfundbet` VALUES ('10437', '20210308005', '10000163', 'कंवर', '00000000615', '2021030800526704', '1615152586');
INSERT INTO `crowdfundbet` VALUES ('10438', '20210308005', '10000146', 'Diego', '00000000854', '2021030800527558', '1615152646');
INSERT INTO `crowdfundbet` VALUES ('10439', '20210308005', '10000113', 'Denny', '00000000056', '2021030800527614', '1615152706');
INSERT INTO `crowdfundbet` VALUES ('10440', '20210308005', '10000093', 'Luminary ', '00000000884', '2021030800528498', '1615152766');
INSERT INTO `crowdfundbet` VALUES ('10441', '20210308005', '10000057', 'anemone', '00000003407', '2021030800531905', '1615152826');
INSERT INTO `crowdfundbet` VALUES ('10442', '20210308005', '10000038', 'laraine', '00000000801', '2021030800532706', '1615152886');
INSERT INTO `crowdfundbet` VALUES ('10443', '20210308005', '10000002', 'gabrielle', '00000002889', '2021030800535595', '1615152946');
INSERT INTO `crowdfundbet` VALUES ('10444', '20210308005', '10000186', 'पवनाज', '00000002624', '2021030800538219', '1615153006');
INSERT INTO `crowdfundbet` VALUES ('10445', '20210308005', '10000152', 'गजेंद्र', '00000002302', '2021030800540521', '1615153066');
INSERT INTO `crowdfundbet` VALUES ('10446', '20210308005', '10000134', 'Kelly', '00000003022', '2021030800543543', '1615153126');
INSERT INTO `crowdfundbet` VALUES ('10447', '20210308005', '10000099', 'Estrus ', '00000006583', '2021030800550126', '1615153186');
INSERT INTO `crowdfundbet` VALUES ('10448', '20210308005', '10000081', 'Martin', '00000004559', '2021030800554685', '1615153246');
INSERT INTO `crowdfundbet` VALUES ('10449', '20210308005', '10000044', 'celina', '00000006490', '2021030800561175', '1615153306');
INSERT INTO `crowdfundbet` VALUES ('10450', '20210308005', '10000026', 'blanche', '00000003400', '2021030800564575', '1615153366');
INSERT INTO `crowdfundbet` VALUES ('10451', '20210308005', '10000192', 'रामभद्र', '00000003283', '2021030800567858', '1615153426');
INSERT INTO `crowdfundbet` VALUES ('10452', '20210308005', '10000174', 'नागराज', '00000005276', '2021030800573134', '1615153486');
INSERT INTO `crowdfundbet` VALUES ('10453', '20210308005', '10000140', 'Alonso', '00000003650', '2021030800576784', '1615153546');
INSERT INTO `crowdfundbet` VALUES ('10454', '20210308005', '10000123', 'JasonJohnny', '00000005912', '2021030800582696', '1615153606');
INSERT INTO `crowdfundbet` VALUES ('10455', '20210308005', '10000087', 'durance ', '00000017304', '20210308005100000', '1615153666');
INSERT INTO `crowdfundbet` VALUES ('10456', '20210308005', '10000067', 'cassiopeia', '00000000000', '20210308005100000', '1615153726');
INSERT INTO `crowdfundbet` VALUES ('10457', '20210308005', '10000032', 'desdemona', '00000000000', '20210308005100000', '1615153786');
INSERT INTO `crowdfundbet` VALUES ('10458', '20210308006', '10000181', 'पलाश', '00000004499', '202103080064499', '1615153906');
INSERT INTO `crowdfundbet` VALUES ('10459', '20210308006', '10000163', 'कंवर', '00000006471', '2021030800610970', '1615153966');
INSERT INTO `crowdfundbet` VALUES ('10460', '20210308006', '10000113', 'Denny', '00000002323', '2021030800613293', '1615154086');
INSERT INTO `crowdfundbet` VALUES ('10461', '20210308006', '10000077', 'Joseph', '00000004932', '2021030800618225', '1615154146');
INSERT INTO `crowdfundbet` VALUES ('10462', '20210308006', '10000057', 'anemone', '00000004692', '2021030800622917', '1615154206');
INSERT INTO `crowdfundbet` VALUES ('10463', '20210308006', '10000022', 'sera', '00000000011', '2021030800622928', '1615154266');
INSERT INTO `crowdfundbet` VALUES ('10464', '20210308006', '10000003', 'raffaella ', '00000005581', '2021030800628509', '1615154326');
INSERT INTO `crowdfundbet` VALUES ('10465', '20210308006', '10000170', 'महंत', '00000005090', '2021030800633599', '1615154386');
INSERT INTO `crowdfundbet` VALUES ('10466', '20210308006', '10000120', 'Bill', '00000002232', '2021030800635831', '1615154506');
INSERT INTO `crowdfundbet` VALUES ('10467', '20210308006', '10000100', 'Wilson', '00000000340', '2021030800636171', '1615154566');
INSERT INTO `crowdfundbet` VALUES ('10468', '20210308006', '10000064', 'kira', '00000000672', '2021030800636843', '1615154626');
INSERT INTO `crowdfundbet` VALUES ('10469', '20210308006', '10000046', 'sicily', '00000002561', '2021030800639404', '1615154686');
INSERT INTO `crowdfundbet` VALUES ('10470', '20210308006', '10000011', 'izefia', '00000004314', '2021030800643718', '1615154746');
INSERT INTO `crowdfundbet` VALUES ('10471', '20210308006', '10000194', 'रामानुज', '00000003322', '2021030800647040', '1615154806');
INSERT INTO `crowdfundbet` VALUES ('10472', '20210308006', '10000159', 'हर्षिता', '00000003781', '2021030800650821', '1615154866');
INSERT INTO `crowdfundbet` VALUES ('10473', '20210308006', '10000141', 'Alex', '00000001385', '2021030800652206', '1615154926');
INSERT INTO `crowdfundbet` VALUES ('10474', '20210308006', '10000107', 'Barry', '00000000731', '2021030800652937', '1615154986');
INSERT INTO `crowdfundbet` VALUES ('10475', '20210308006', '10000089', 'Miss ', '00000002415', '2021030800655352', '1615155046');
INSERT INTO `crowdfundbet` VALUES ('10476', '20210308006', '10000051', 'dolores', '00000005519', '2021030800660871', '1615155106');
INSERT INTO `crowdfundbet` VALUES ('10477', '20210308006', '10000033', 'amaya', '00000000276', '2021030800661147', '1615155166');
INSERT INTO `crowdfundbet` VALUES ('10478', '20210308006', '10000106', 'Leon', '00000003925', '2021030800665072', '1615155226');
INSERT INTO `crowdfundbet` VALUES ('10479', '20210308006', '10000181', 'पलाश', '00000001615', '2021030800666687', '1615155286');
INSERT INTO `crowdfundbet` VALUES ('10480', '20210308006', '10000147', 'Karen', '00000000157', '2021030800666844', '1615155346');
INSERT INTO `crowdfundbet` VALUES ('10481', '20210308006', '10000130', 'Kylie', '00000000620', '2021030800667464', '1615155406');
INSERT INTO `crowdfundbet` VALUES ('10482', '20210308006', '10000094', 'mirage ', '00000032536', '20210308006100000', '1615155466');
INSERT INTO `crowdfundbet` VALUES ('10483', '20210308006', '10000076', 'William', '00000000000', '20210308006100000', '1615155526');
INSERT INTO `crowdfundbet` VALUES ('10484', '20210308006', '10000039', 'cecilia', '00000000000', '20210308006100000', '1615155586');
INSERT INTO `crowdfundbet` VALUES ('10485', '20210308007', '10000188', 'प्राणजीवन', '00000003921', '202103080073921', '1615155706');
INSERT INTO `crowdfundbet` VALUES ('10486', '20210308007', '10000171', 'मनमोहन', '00000005682', '202103080079603', '1615155766');
INSERT INTO `crowdfundbet` VALUES ('10487', '20210308007', '10000136', 'Joyce', '00000003751', '2021030800713354', '1615155826');
INSERT INTO `crowdfundbet` VALUES ('10488', '20210308007', '10000085', 'Insane', '00000003770', '2021030800717124', '1615155946');
INSERT INTO `crowdfundbet` VALUES ('10489', '20210308007', '10000064', 'kira', '00000004780', '2021030800721904', '1615156006');
INSERT INTO `crowdfundbet` VALUES ('10490', '20210308007', '10000029', 'delores', '00000005046', '2021030800726950', '1615156066');
INSERT INTO `crowdfundbet` VALUES ('10491', '20210308007', '10000178', 'नवरंग', '00000005843', '2021030800732793', '1615156186');
INSERT INTO `crowdfundbet` VALUES ('10492', '20210308007', '10000160', 'हेमदेव', '00000005759', '2021030800738552', '1615156246');
INSERT INTO `crowdfundbet` VALUES ('10493', '20210308007', '10000110', 'Bruce', '00000000535', '2021030800739087', '1615156366');
INSERT INTO `crowdfundbet` VALUES ('10494', '20210308007', '10000074', 'Bill', '00000001204', '2021030800740291', '1615156426');
INSERT INTO `crowdfundbet` VALUES ('10495', '20210308007', '10000055', 'desdemona', '00000002336', '2021030800742627', '1615156486');
INSERT INTO `crowdfundbet` VALUES ('10496', '20210308007', '10000019', 'sicily', '00000006122', '2021030800748749', '1615156546');
INSERT INTO `crowdfundbet` VALUES ('10497', '20210308007', '10000000', 'michelle', '00000001181', '2021030800749930', '1615156606');
INSERT INTO `crowdfundbet` VALUES ('10498', '20210308007', '10000168', 'मदन मोहन', '00000003899', '2021030800753829', '1615156666');
INSERT INTO `crowdfundbet` VALUES ('10499', '20210308007', '10000149', 'Irene', '00000002094', '2021030800755923', '1615156726');
INSERT INTO `crowdfundbet` VALUES ('10500', '20210308007', '10000116', 'Andrew', '00000005956', '2021030800761879', '1615156786');
INSERT INTO `crowdfundbet` VALUES ('10501', '20210308007', '10000097', 'Thunder', '00000004383', '2021030800766262', '1615156846');
INSERT INTO `crowdfundbet` VALUES ('10502', '20210308007', '10000060', 'lorelei', '00000001832', '2021030800768094', '1615156906');
INSERT INTO `crowdfundbet` VALUES ('10503', '20210308007', '10000042', 'felicia', '00000005133', '2021030800773227', '1615156966');
INSERT INTO `crowdfundbet` VALUES ('10504', '20210308007', '10000006', 'quella', '00000003177', '2021030800776404', '1615157026');
INSERT INTO `crowdfundbet` VALUES ('10505', '20210308007', '10000189', 'प्रीतम', '00000003983', '2021030800780387', '1615157086');
INSERT INTO `crowdfundbet` VALUES ('10506', '20210308007', '10000155', 'गुरुप्रसाद', '00000002226', '2021030800782613', '1615157146');
INSERT INTO `crowdfundbet` VALUES ('10507', '20210308007', '10000138', 'Andrew', '00000005106', '2021030800787719', '1615157206');
INSERT INTO `crowdfundbet` VALUES ('10508', '20210308007', '10000102', 'Warren', '00000012281', '20210308007100000', '1615157266');
INSERT INTO `crowdfundbet` VALUES ('10509', '20210308007', '10000085', 'Insane', '00000000000', '20210308007100000', '1615157326');
INSERT INTO `crowdfundbet` VALUES ('10510', '20210308007', '10000048', 'angelinasakura', '00000000000', '20210308007100000', '1615157386');
INSERT INTO `crowdfundbet` VALUES ('10511', '20210308008', '10000197', 'ऋषभदेव', '00000003671', '202103080083671', '1615157506');
INSERT INTO `crowdfundbet` VALUES ('10512', '20210308008', '10000179', 'नील माधव', '00000002478', '202103080086149', '1615157566');
INSERT INTO `crowdfundbet` VALUES ('10513', '20210308008', '10000144', 'Gwendolyn', '00000006440', '2021030800812589', '1615157626');
INSERT INTO `crowdfundbet` VALUES ('10514', '20210308008', '10000127', 'Alex', '00000002029', '2021030800814618', '1615157686');
INSERT INTO `crowdfundbet` VALUES ('10515', '20210308008', '10000092', 'Serious', '00000006371', '2021030800820989', '1615157746');
INSERT INTO `crowdfundbet` VALUES ('10516', '20210308008', '10000037', 'gina', '00000005750', '2021030800826739', '1615157866');
INSERT INTO `crowdfundbet` VALUES ('10517', '20210308008', '10000186', 'पवनाज', '00000002999', '2021030800829738', '1615157986');
INSERT INTO `crowdfundbet` VALUES ('10518', '20210308008', '10000169', 'मधुसूदन', '00000003670', '2021030800833408', '1615158046');
INSERT INTO `crowdfundbet` VALUES ('10519', '20210308008', '10000135', 'Leon', '00000004870', '2021030800838278', '1615158106');
INSERT INTO `crowdfundbet` VALUES ('10520', '20210308008', '10000117', 'Kenny', '00000004097', '2021030800842375', '1615158166');
INSERT INTO `crowdfundbet` VALUES ('10521', '20210308008', '10000081', 'Martin', '00000004214', '2021030800846589', '1615158226');
INSERT INTO `crowdfundbet` VALUES ('10522', '20210308008', '10000062', 'melantha', '00000004523', '2021030800851112', '1615158286');
INSERT INTO `crowdfundbet` VALUES ('10523', '20210308008', '10000008', 'claudia', '00000005718', '2021030800856830', '1615158406');
INSERT INTO `crowdfundbet` VALUES ('10524', '20210308008', '10000158', 'हर्षद', '00000001529', '2021030800858359', '1615158526');
INSERT INTO `crowdfundbet` VALUES ('10525', '20210308008', '10000125', 'Easter', '00000003253', '2021030800861612', '1615158586');
INSERT INTO `crowdfundbet` VALUES ('10526', '20210308008', '10000107', 'Barry', '00000002251', '2021030800863863', '1615158646');
INSERT INTO `crowdfundbet` VALUES ('10527', '20210308008', '10000069', 'LenaKong', '00000000927', '2021030800864790', '1615158706');
INSERT INTO `crowdfundbet` VALUES ('10528', '20210308008', '10000051', 'dolores', '00000006295', '2021030800871085', '1615158766');
INSERT INTO `crowdfundbet` VALUES ('10529', '20210308008', '10000017', 'celina', '00000004750', '2021030800875835', '1615158826');
INSERT INTO `crowdfundbet` VALUES ('10530', '20210308008', '10000199', 'रोशन', '00000005926', '2021030800881761', '1615158886');
INSERT INTO `crowdfundbet` VALUES ('10531', '20210308008', '10000164', 'कर्मजीत', '00000005851', '2021030800887612', '1615158946');
INSERT INTO `crowdfundbet` VALUES ('10532', '20210308008', '10000114', 'Wesley', '00000012388', '20210308008100000', '1615159066');
INSERT INTO `crowdfundbet` VALUES ('10533', '20210308008', '10000095', 'Ovdoes ', '00000000000', '20210308008100000', '1615159126');
INSERT INTO `crowdfundbet` VALUES ('10534', '20210308008', '10000059', 'lilith', '00000000000', '20210308008100000', '1615159186');
INSERT INTO `crowdfundbet` VALUES ('10535', '20210308009', '10000005', 'ulrica', '00000002097', '202103080092097', '1615159306');
INSERT INTO `crowdfundbet` VALUES ('10536', '20210308009', '10000189', 'प्रीतम', '00000004817', '202103080096914', '1615159366');
INSERT INTO `crowdfundbet` VALUES ('10537', '20210308009', '10000154', 'गुरुदट', '00000002811', '202103080099725', '1615159426');
INSERT INTO `crowdfundbet` VALUES ('10538', '20210308009', '10000137', 'Albert', '00000001374', '2021030800911099', '1615159486');
INSERT INTO `crowdfundbet` VALUES ('10539', '20210308009', '10000102', 'Warren', '00000002958', '2021030800914057', '1615159546');
INSERT INTO `crowdfundbet` VALUES ('10540', '20210308009', '10000083', 'Dirge ', '00000005606', '2021030800919663', '1615159606');
INSERT INTO `crowdfundbet` VALUES ('10541', '20210308009', '10000047', 'cecile', '00000005484', '2021030800925147', '1615159666');
INSERT INTO `crowdfundbet` VALUES ('10542', '20210308009', '10000029', 'delores', '00000003011', '2021030800928158', '1615159726');
INSERT INTO `crowdfundbet` VALUES ('10543', '20210308009', '10000195', 'रामप्रसाद', '00000005949', '2021030800934107', '1615159786');
INSERT INTO `crowdfundbet` VALUES ('10544', '20210308009', '10000144', 'Gwendolyn', '00000004285', '2021030800938392', '1615159906');
INSERT INTO `crowdfundbet` VALUES ('10545', '20210308009', '10000126', 'Addison', '00000005554', '2021030800943946', '1615159966');
INSERT INTO `crowdfundbet` VALUES ('10546', '20210308009', '10000074', 'Bill', '00000004660', '2021030800948606', '1615160086');
INSERT INTO `crowdfundbet` VALUES ('10547', '20210308009', '10000036', 'cytheria', '00000002469', '2021030800951075', '1615160146');
INSERT INTO `crowdfundbet` VALUES ('10548', '20210308009', '10000019', 'sicily', '00000000124', '2021030800951199', '1615160206');
INSERT INTO `crowdfundbet` VALUES ('10549', '20210308009', '10000185', 'पार्थसारथी', '00000003671', '2021030800954870', '1615160266');
INSERT INTO `crowdfundbet` VALUES ('10550', '20210308009', '10000167', 'मदन', '00000003632', '2021030800958502', '1615160326');
INSERT INTO `crowdfundbet` VALUES ('10551', '20210308009', '10000133', 'Caiden', '00000001467', '2021030800959969', '1615160386');
INSERT INTO `crowdfundbet` VALUES ('10552', '20210308009', '10000116', 'Andrew', '00000005973', '2021030800965942', '1615160446');
INSERT INTO `crowdfundbet` VALUES ('10553', '20210308009', '10000079', 'Henry', '00000005554', '2021030800971496', '1615160506');
INSERT INTO `crowdfundbet` VALUES ('10554', '20210308009', '10000060', 'lorelei', '00000006621', '2021030800978117', '1615160566');
INSERT INTO `crowdfundbet` VALUES ('10555', '20210308009', '10000006', 'quella', '00000002378', '2021030800980495', '1615160686');
INSERT INTO `crowdfundbet` VALUES ('10556', '20210308009', '10000174', 'नागराज', '00000003435', '2021030800983930', '1615160746');
INSERT INTO `crowdfundbet` VALUES ('10557', '20210308009', '10000156', 'हरिदासचैतन्य', '00000004214', '2021030800988144', '1615160806');
INSERT INTO `crowdfundbet` VALUES ('10558', '20210308009', '10000122', 'Peter', '00000011856', '20210308009100000', '1615160866');
INSERT INTO `crowdfundbet` VALUES ('10559', '20210308009', '10000103', 'James', '00000000000', '20210308009100000', '1615160926');
INSERT INTO `crowdfundbet` VALUES ('10560', '20210308009', '10000067', 'cassiopeia', '00000000000', '20210308009100000', '1615160986');
INSERT INTO `crowdfundbet` VALUES ('10561', '20210308010', '10000015', 'felicia', '00000001459', '202103080101459', '1615161106');
INSERT INTO `crowdfundbet` VALUES ('10562', '20210308010', '10000198', 'रौनक', '00000004382', '202103080105841', '1615161166');
INSERT INTO `crowdfundbet` VALUES ('10563', '20210308010', '10000162', 'कनेया', '00000005944', '2021030801011785', '1615161226');
INSERT INTO `crowdfundbet` VALUES ('10564', '20210308010', '10000145', 'Aidan', '00000002109', '2021030801013894', '1615161286');
INSERT INTO `crowdfundbet` VALUES ('10565', '20210308010', '10000112', 'Charles', '00000006493', '2021030801020387', '1615161346');
INSERT INTO `crowdfundbet` VALUES ('10566', '20210308010', '10000057', 'anemone', '00000006291', '2021030801026678', '1615161466');
INSERT INTO `crowdfundbet` VALUES ('10567', '20210308010', '10000003', 'raffaella ', '00000001220', '2021030801027898', '1615161586');
INSERT INTO `crowdfundbet` VALUES ('10568', '20210308010', '10000187', 'प्रभाकर', '00000001306', '2021030801029204', '1615161646');
INSERT INTO `crowdfundbet` VALUES ('10569', '20210308010', '10000153', 'गोविंद', '00000006494', '2021030801035698', '1615161706');
INSERT INTO `crowdfundbet` VALUES ('10570', '20210308010', '10000135', 'Leon', '00000005172', '2021030801040870', '1615161766');
INSERT INTO `crowdfundbet` VALUES ('10571', '20210308010', '10000100', 'Wilson', '00000003617', '2021030801044487', '1615161826');
INSERT INTO `crowdfundbet` VALUES ('10572', '20210308010', '10000082', 'Promise ', '00000004861', '2021030801049348', '1615161886');
INSERT INTO `crowdfundbet` VALUES ('10573', '20210308010', '10000045', 'amaris', '00000006630', '2021030801055978', '1615161946');
INSERT INTO `crowdfundbet` VALUES ('10574', '20210308010', '10000195', 'रामप्रसाद', '00000003697', '2021030801059675', '1615162066');
INSERT INTO `crowdfundbet` VALUES ('10575', '20210308010', '10000176', 'नवदविप', '00000003448', '2021030801063123', '1615162126');
INSERT INTO `crowdfundbet` VALUES ('10576', '20210308010', '10000142', 'Tankard', '00000003274', '2021030801066397', '1615162186');
INSERT INTO `crowdfundbet` VALUES ('10577', '20210308010', '10000125', 'Easter', '00000005356', '2021030801071753', '1615162246');
INSERT INTO `crowdfundbet` VALUES ('10578', '20210308010', '10000070', 'AllyZhang', '00000004184', '2021030801075937', '1615162366');
INSERT INTO `crowdfundbet` VALUES ('10579', '20210308010', '10000035', 'anemone', '00000003980', '2021030801079917', '1615162426');
INSERT INTO `crowdfundbet` VALUES ('10580', '20210308010', '10000017', 'celina', '00000005328', '2021030801085245', '1615162486');
INSERT INTO `crowdfundbet` VALUES ('10581', '20210308010', '10000167', 'मदन', '00000001845', '2021030801087090', '1615162606');
INSERT INTO `crowdfundbet` VALUES ('10582', '20210308010', '10000132', 'Larissa', '00000012910', '20210308010100000', '1615162666');
INSERT INTO `crowdfundbet` VALUES ('10583', '20210308010', '10000115', 'Abraham', '00000000000', '20210308010100000', '1615162726');
INSERT INTO `crowdfundbet` VALUES ('10584', '20210308010', '10000079', 'Henry', '00000000000', '20210308010100000', '1615162786');
INSERT INTO `crowdfundbet` VALUES ('10585', '20210308011', '10000025', 'sakura', '00000000921', '20210308011921', '1615162906');
INSERT INTO `crowdfundbet` VALUES ('10586', '20210308011', '10000006', 'quella', '00000002361', '202103080113282', '1615162966');
INSERT INTO `crowdfundbet` VALUES ('10587', '20210308011', '10000173', 'नाडिश', '00000003116', '202103080116398', '1615163026');
INSERT INTO `crowdfundbet` VALUES ('10588', '20210308011', '10000155', 'गुरुप्रसाद', '00000001397', '202103080117795', '1615163086');
INSERT INTO `crowdfundbet` VALUES ('10589', '20210308011', '10000122', 'Peter', '00000000563', '202103080118358', '1615163146');
INSERT INTO `crowdfundbet` VALUES ('10590', '20210308011', '10000102', 'Warren', '00000004198', '2021030801112556', '1615163206');
INSERT INTO `crowdfundbet` VALUES ('10591', '20210308011', '10000066', 'cyrene', '00000006107', '2021030801118663', '1615163266');
INSERT INTO `crowdfundbet` VALUES ('10592', '20210308011', '10000048', 'angelinasakura', '00000003984', '2021030801122647', '1615163326');
INSERT INTO `crowdfundbet` VALUES ('10593', '20210308011', '10000013', 'danae', '00000002906', '2021030801125553', '1615163386');
INSERT INTO `crowdfundbet` VALUES ('10594', '20210308011', '10000196', 'रसपरयान', '00000003357', '2021030801128910', '1615163446');
INSERT INTO `crowdfundbet` VALUES ('10595', '20210308011', '10000161', 'ऋषिकेश', '00000005590', '2021030801134500', '1615163506');
INSERT INTO `crowdfundbet` VALUES ('10596', '20210308011', '10000143', 'Harriet', '00000004281', '2021030801138781', '1615163566');
INSERT INTO `crowdfundbet` VALUES ('10597', '20210308011', '10000110', 'Bruce', '00000001381', '2021030801140162', '1615163626');
INSERT INTO `crowdfundbet` VALUES ('10598', '20210308011', '10000091', 'Mental ', '00000005956', '2021030801146118', '1615163686');
INSERT INTO `crowdfundbet` VALUES ('10599', '20210308011', '10000054', 'deirdre', '00000003612', '2021030801149730', '1615163746');
INSERT INTO `crowdfundbet` VALUES ('10600', '20210308011', '10000035', 'anemone', '00000005963', '2021030801155693', '1615163806');
INSERT INTO `crowdfundbet` VALUES ('10601', '20210308011', '10000000', 'michelle', '00000001552', '2021030801157245', '1615163866');
INSERT INTO `crowdfundbet` VALUES ('10602', '20210308011', '10000183', 'परमजीत', '00000002329', '2021030801159574', '1615163926');
INSERT INTO `crowdfundbet` VALUES ('10603', '20210308011', '10000149', 'Irene', '00000002129', '2021030801161703', '1615163986');
INSERT INTO `crowdfundbet` VALUES ('10604', '20210308011', '10000132', 'Larissa', '00000000890', '2021030801162593', '1615164046');
INSERT INTO `crowdfundbet` VALUES ('10605', '20210308011', '10000096', 'Queen ', '00000005095', '2021030801167688', '1615164106');
INSERT INTO `crowdfundbet` VALUES ('10606', '20210308011', '10000078', 'James', '00000004099', '2021030801171787', '1615164166');
INSERT INTO `crowdfundbet` VALUES ('10607', '20210308011', '10000042', 'felicia', '00000005645', '2021030801177432', '1615164226');
INSERT INTO `crowdfundbet` VALUES ('10608', '20210308011', '10000023', 'serafina', '00000001384', '2021030801178816', '1615164286');
INSERT INTO `crowdfundbet` VALUES ('10609', '20210308011', '10000189', 'प्रीतम', '00000006167', '2021030801184983', '1615164346');
INSERT INTO `crowdfundbet` VALUES ('10610', '20210308011', '10000172', 'मार्तंड', '00000004416', '2021030801189399', '1615164406');
INSERT INTO `crowdfundbet` VALUES ('10611', '20210308011', '10000137', 'Albert', '00000010601', '20210308011100000', '1615164466');
INSERT INTO `crowdfundbet` VALUES ('10612', '20210308011', '10000120', 'Bill', '00000000000', '20210308011100000', '1615164526');
INSERT INTO `crowdfundbet` VALUES ('10613', '20210308011', '10000085', 'Insane', '00000000000', '20210308011100000', '1615164586');
INSERT INTO `crowdfundbet` VALUES ('10614', '20210308012', '10000030', 'claudia', '00000004549', '202103080124549', '1615164706');
INSERT INTO `crowdfundbet` VALUES ('10615', '20210308012', '10000013', 'danae', '00000005881', '2021030801210430', '1615164766');
INSERT INTO `crowdfundbet` VALUES ('10616', '20210308012', '10000161', 'ऋषिकेश', '00000005063', '2021030801215493', '1615164886');
INSERT INTO `crowdfundbet` VALUES ('10617', '20210308012', '10000128', 'Ryan', '00000005603', '2021030801221096', '1615164946');
INSERT INTO `crowdfundbet` VALUES ('10618', '20210308012', '10000075', 'Vincent', '00000003785', '2021030801224881', '1615165066');
INSERT INTO `crowdfundbet` VALUES ('10619', '20210308012', '10000056', 'amaya', '00000002266', '2021030801227147', '1615165126');
INSERT INTO `crowdfundbet` VALUES ('10620', '20210308012', '10000020', 'cecile', '00000001222', '2021030801228369', '1615165186');
INSERT INTO `crowdfundbet` VALUES ('10621', '20210308012', '10000001', 'mica', '00000005453', '2021030801233822', '1615165246');
INSERT INTO `crowdfundbet` VALUES ('10622', '20210308012', '10000169', 'मधुसूदन', '00000002072', '2021030801235894', '1615165306');
INSERT INTO `crowdfundbet` VALUES ('10623', '20210308012', '10000150', 'गोपीनाथ', '00000003833', '2021030801239727', '1615165366');
INSERT INTO `crowdfundbet` VALUES ('10624', '20210308012', '10000117', 'Kenny', '00000005524', '2021030801245251', '1615165426');
INSERT INTO `crowdfundbet` VALUES ('10625', '20210308012', '10000098', 'Diamonds ', '00000001308', '2021030801246559', '1615165486');
INSERT INTO `crowdfundbet` VALUES ('10626', '20210308012', '10000061', 'easter', '00000005849', '2021030801252408', '1615165546');
INSERT INTO `crowdfundbet` VALUES ('10627', '20210308012', '10000043', 'snow', '00000003835', '2021030801256243', '1615165606');
INSERT INTO `crowdfundbet` VALUES ('10628', '20210308012', '10000007', 'cecilia', '00000004730', '2021030801260973', '1615165666');
INSERT INTO `crowdfundbet` VALUES ('10629', '20210308012', '10000157', 'हरिप्रीत', '00000003918', '2021030801264891', '1615165786');
INSERT INTO `crowdfundbet` VALUES ('10630', '20210308012', '10000140', 'Alonso', '00000006112', '2021030801271003', '1615165846');
INSERT INTO `crowdfundbet` VALUES ('10631', '20210308012', '10000088', 'Allure', '00000003395', '2021030801274398', '1615165966');
INSERT INTO `crowdfundbet` VALUES ('10632', '20210308012', '10000051', 'dolores', '00000003822', '2021030801278220', '1615166026');
INSERT INTO `crowdfundbet` VALUES ('10633', '20210308012', '10000032', 'desdemona', '00000000519', '2021030801278739', '1615166086');
INSERT INTO `crowdfundbet` VALUES ('10634', '20210308012', '10000199', 'रोशन', '00000001016', '2021030801279755', '1615166146');
INSERT INTO `crowdfundbet` VALUES ('10635', '20210308012', '10000181', 'पलाश', '00000001730', '2021030801281485', '1615166206');
INSERT INTO `crowdfundbet` VALUES ('10636', '20210308012', '10000146', 'Diego', '00000018515', '20210308012100000', '1615166266');
INSERT INTO `crowdfundbet` VALUES ('10637', '20210308012', '10000129', 'Aidan', '00000000000', '20210308012100000', '1615166326');
INSERT INTO `crowdfundbet` VALUES ('10638', '20210308012', '10000094', 'mirage ', '00000000000', '20210308012100000', '1615166386');
INSERT INTO `crowdfundbet` VALUES ('10639', '20210308013', '10000039', 'cecilia', '00000004270', '202103080134270', '1615166506');
INSERT INTO `crowdfundbet` VALUES ('10640', '20210308013', '10000022', 'sera', '00000004865', '202103080139135', '1615166566');
INSERT INTO `crowdfundbet` VALUES ('10641', '20210308013', '10000187', 'प्रभाकर', '00000004909', '2021030801314044', '1615166626');
INSERT INTO `crowdfundbet` VALUES ('10642', '20210308013', '10000137', 'Albert', '00000002943', '2021030801316987', '1615166746');
INSERT INTO `crowdfundbet` VALUES ('10643', '20210308013', '10000119', 'Evan', '00000004041', '2021030801321028', '1615166806');
INSERT INTO `crowdfundbet` VALUES ('10644', '20210308013', '10000083', 'Dirge ', '00000005471', '2021030801326499', '1615166866');
INSERT INTO `crowdfundbet` VALUES ('10645', '20210308013', '10000064', 'kira', '00000005892', '2021030801332391', '1615166926');
INSERT INTO `crowdfundbet` VALUES ('10646', '20210308013', '10000012', 'louise', '00000001890', '2021030801334281', '1615167046');
INSERT INTO `crowdfundbet` VALUES ('10647', '20210308013', '10000178', 'नवरंग', '00000001510', '2021030801335791', '1615167106');
INSERT INTO `crowdfundbet` VALUES ('10648', '20210308013', '10000159', 'हर्षिता', '00000006070', '2021030801341861', '1615167166');
INSERT INTO `crowdfundbet` VALUES ('10649', '20210308013', '10000126', 'Addison', '00000002807', '2021030801344668', '1615167226');
INSERT INTO `crowdfundbet` VALUES ('10650', '20210308013', '10000109', 'Albert', '00000001669', '2021030801346337', '1615167286');
INSERT INTO `crowdfundbet` VALUES ('10651', '20210308013', '10000070', 'AllyZhang', '00000001596', '2021030801347933', '1615167346');
INSERT INTO `crowdfundbet` VALUES ('10652', '20210308013', '10000053', 'claudia', '00000000634', '2021030801348567', '1615167406');
INSERT INTO `crowdfundbet` VALUES ('10653', '20210308013', '10000018', 'amaris', '00000004187', '2021030801352754', '1615167466');
INSERT INTO `crowdfundbet` VALUES ('10654', '20210308013', '10000106', 'Leon', '00000000881', '2021030801353635', '1615167526');
INSERT INTO `crowdfundbet` VALUES ('10655', '20210308013', '10000166', 'काशीनाथ', '00000006402', '2021030801360037', '1615167586');
INSERT INTO `crowdfundbet` VALUES ('10656', '20210308013', '10000148', 'Jacquelyn', '00000006173', '2021030801366210', '1615167646');
INSERT INTO `crowdfundbet` VALUES ('10657', '20210308013', '10000114', 'Wesley', '00000002407', '2021030801368617', '1615167706');
INSERT INTO `crowdfundbet` VALUES ('10658', '20210308013', '10000095', 'Ovdoes ', '00000000019', '2021030801368636', '1615167766');
INSERT INTO `crowdfundbet` VALUES ('10659', '20210308013', '10000059', 'lilith', '00000004272', '2021030801372908', '1615167826');
INSERT INTO `crowdfundbet` VALUES ('10660', '20210308013', '10000039', 'cecilia', '00000000379', '2021030801373287', '1615167886');
INSERT INTO `crowdfundbet` VALUES ('10661', '20210308013', '10000004', 'cassiel', '00000001237', '2021030801374524', '1615167946');
INSERT INTO `crowdfundbet` VALUES ('10662', '20210308013', '10000188', 'प्राणजीवन', '00000001464', '2021030801375988', '1615168006');
INSERT INTO `crowdfundbet` VALUES ('10663', '20210308013', '10000153', 'गोविंद', '00000024012', '20210308013100000', '1615168066');
INSERT INTO `crowdfundbet` VALUES ('10664', '20210308013', '10000136', 'Joyce', '00000000000', '20210308013100000', '1615168126');
INSERT INTO `crowdfundbet` VALUES ('10665', '20210308013', '10000101', 'Carl', '00000000000', '20210308013100000', '1615168186');
INSERT INTO `crowdfundbet` VALUES ('10666', '20210308014', '10000047', 'cecile', '00000003483', '202103080143483', '1615168306');
INSERT INTO `crowdfundbet` VALUES ('10667', '20210308014', '10000029', 'delores', '00000005318', '202103080148801', '1615168366');
INSERT INTO `crowdfundbet` VALUES ('10668', '20210308014', '10000195', 'रामप्रसाद', '00000004593', '2021030801413394', '1615168426');
INSERT INTO `crowdfundbet` VALUES ('10669', '20210308014', '10000144', 'Gwendolyn', '00000005143', '2021030801418537', '1615168546');
INSERT INTO `crowdfundbet` VALUES ('10670', '20210308014', '10000126', 'Addison', '00000005356', '2021030801423893', '1615168606');
INSERT INTO `crowdfundbet` VALUES ('10671', '20210308014', '10000074', 'Bill', '00000001963', '2021030801425856', '1615168726');
INSERT INTO `crowdfundbet` VALUES ('10672', '20210308014', '10000036', 'cytheria', '00000001747', '2021030801427603', '1615168786');
INSERT INTO `crowdfundbet` VALUES ('10673', '20210308014', '10000019', 'sicily', '00000002689', '2021030801430292', '1615168846');
INSERT INTO `crowdfundbet` VALUES ('10674', '20210308014', '10000185', 'पार्थसारथी', '00000006614', '2021030801436906', '1615168906');
INSERT INTO `crowdfundbet` VALUES ('10675', '20210308014', '10000167', 'मदन', '00000001787', '2021030801438693', '1615168966');
INSERT INTO `crowdfundbet` VALUES ('10676', '20210308014', '10000133', 'Caiden', '00000001471', '2021030801440164', '1615169026');
INSERT INTO `crowdfundbet` VALUES ('10677', '20210308014', '10000116', 'Andrew', '00000002854', '2021030801443018', '1615169086');
INSERT INTO `crowdfundbet` VALUES ('10678', '20210308014', '10000079', 'Henry', '00000004544', '2021030801447562', '1615169146');
INSERT INTO `crowdfundbet` VALUES ('10679', '20210308014', '10000060', 'lorelei', '00000002537', '2021030801450099', '1615169206');
INSERT INTO `crowdfundbet` VALUES ('10680', '20210308014', '10000025', 'sakura', '00000003116', '2021030801453215', '1615169266');
INSERT INTO `crowdfundbet` VALUES ('10681', '20210308014', '10000005', 'ulrica', '00000005128', '2021030801458343', '1615169326');
INSERT INTO `crowdfundbet` VALUES ('10682', '20210308014', '10000173', 'नाडिश', '00000005981', '2021030801464324', '1615169386');
INSERT INTO `crowdfundbet` VALUES ('10683', '20210308014', '10000155', 'गुरुप्रसाद', '00000000141', '2021030801464465', '1615169446');
INSERT INTO `crowdfundbet` VALUES ('10684', '20210308014', '10000121', 'Nick', '00000004347', '2021030801468812', '1615169506');
INSERT INTO `crowdfundbet` VALUES ('10685', '20210308014', '10000102', 'Warren', '00000003996', '2021030801472808', '1615169566');
INSERT INTO `crowdfundbet` VALUES ('10686', '20210308014', '10000066', 'cyrene', '00000006144', '2021030801478952', '1615169626');
INSERT INTO `crowdfundbet` VALUES ('10687', '20210308014', '10000047', 'cecile', '00000003629', '2021030801482581', '1615169686');
INSERT INTO `crowdfundbet` VALUES ('10688', '20210308014', '10000013', 'danae', '00000002932', '2021030801485513', '1615169746');
INSERT INTO `crowdfundbet` VALUES ('10689', '20210308014', '10000196', 'रसपरयान', '00000002908', '2021030801488421', '1615169806');
INSERT INTO `crowdfundbet` VALUES ('10690', '20210308014', '10000160', 'हेमदेव', '00000011579', '20210308014100000', '1615169866');
INSERT INTO `crowdfundbet` VALUES ('10691', '20210308014', '10000143', 'Harriet', '00000000000', '20210308014100000', '1615169926');
INSERT INTO `crowdfundbet` VALUES ('10692', '20210308014', '10000110', 'Bruce', '00000000000', '20210308014100000', '1615169986');
INSERT INTO `crowdfundbet` VALUES ('10693', '20210308015', '10000055', 'desdemona', '00000000607', '20210308015607', '1615170106');
INSERT INTO `crowdfundbet` VALUES ('10694', '20210308015', '10000036', 'cytheria', '00000000690', '202103080151297', '1615170166');
INSERT INTO `crowdfundbet` VALUES ('10695', '20210308015', '10000000', 'michelle', '00000004394', '202103080155691', '1615170226');
INSERT INTO `crowdfundbet` VALUES ('10696', '20210308015', '10000184', 'परिक्षित', '00000002415', '202103080158106', '1615170286');
INSERT INTO `crowdfundbet` VALUES ('10697', '20210308015', '10000150', 'गोपीनाथ', '00000005790', '2021030801513896', '1615170346');
INSERT INTO `crowdfundbet` VALUES ('10698', '20210308015', '10000132', 'Larissa', '00000004007', '2021030801517903', '1615170406');
INSERT INTO `crowdfundbet` VALUES ('10699', '20210308015', '10000097', 'Thunder', '00000005195', '2021030801523098', '1615170466');
INSERT INTO `crowdfundbet` VALUES ('10700', '20210308015', '10000079', 'Henry', '00000000171', '2021030801523269', '1615170526');
INSERT INTO `crowdfundbet` VALUES ('10701', '20210308015', '10000042', 'felicia', '00000006238', '2021030801529507', '1615170586');
INSERT INTO `crowdfundbet` VALUES ('10702', '20210308015', '10000024', 'karida', '00000001209', '2021030801530716', '1615170646');
INSERT INTO `crowdfundbet` VALUES ('10703', '20210308015', '10000190', 'राधानाथ', '00000004995', '2021030801535711', '1615170706');
INSERT INTO `crowdfundbet` VALUES ('10704', '20210308015', '10000172', 'मार्तंड', '00000005065', '2021030801540776', '1615170766');
INSERT INTO `crowdfundbet` VALUES ('10705', '20210308015', '10000138', 'Andrew', '00000004994', '2021030801545770', '1615170826');
INSERT INTO `crowdfundbet` VALUES ('10706', '20210308015', '10000121', 'Nick', '00000002940', '2021030801548710', '1615170886');
INSERT INTO `crowdfundbet` VALUES ('10707', '20210308015', '10000085', 'Insane', '00000006394', '2021030801555104', '1615170946');
INSERT INTO `crowdfundbet` VALUES ('10708', '20210308015', '10000031', 'deirdre', '00000006369', '2021030801561473', '1615171066');
INSERT INTO `crowdfundbet` VALUES ('10709', '20210308015', '10000180', 'निरहानकर', '00000004200', '2021030801565673', '1615171186');
INSERT INTO `crowdfundbet` VALUES ('10710', '20210308015', '10000162', 'कनेया', '00000005837', '2021030801571510', '1615171246');
INSERT INTO `crowdfundbet` VALUES ('10711', '20210308015', '10000112', 'Charles', '00000004836', '2021030801576346', '1615171366');
INSERT INTO `crowdfundbet` VALUES ('10712', '20210308015', '10000076', 'William', '00000006312', '2021030801582658', '1615171426');
INSERT INTO `crowdfundbet` VALUES ('10713', '20210308015', '10000022', 'sera', '00000001512', '2021030801584170', '1615171546');
INSERT INTO `crowdfundbet` VALUES ('10714', '20210308015', '10000003', 'raffaella ', '00000000670', '2021030801584840', '1615171606');
INSERT INTO `crowdfundbet` VALUES ('10715', '20210308015', '10000170', 'महंत', '00000015160', '20210308015100000', '1615171666');
INSERT INTO `crowdfundbet` VALUES ('10716', '20210308015', '10000152', 'गजेंद्र', '00000000000', '20210308015100000', '1615171726');
INSERT INTO `crowdfundbet` VALUES ('10717', '20210308015', '10000119', 'Evan', '00000000000', '20210308015100000', '1615171786');
INSERT INTO `crowdfundbet` VALUES ('10718', '20210308016', '10000064', 'kira', '00000001509', '202103080161509', '1615171906');
INSERT INTO `crowdfundbet` VALUES ('10719', '20210308016', '10000046', 'sicily', '00000001338', '202103080162847', '1615171966');
INSERT INTO `crowdfundbet` VALUES ('10720', '20210308016', '10000011', 'izefia', '00000005036', '202103080167883', '1615172026');
INSERT INTO `crowdfundbet` VALUES ('10721', '20210308016', '10000194', 'रामानुज', '00000005510', '2021030801613393', '1615172086');
INSERT INTO `crowdfundbet` VALUES ('10722', '20210308016', '10000159', 'हर्षिता', '00000003632', '2021030801617025', '1615172146');
INSERT INTO `crowdfundbet` VALUES ('10723', '20210308016', '10000141', 'Alex', '00000005936', '2021030801622961', '1615172206');
INSERT INTO `crowdfundbet` VALUES ('10724', '20210308016', '10000107', 'Barry', '00000005379', '2021030801628340', '1615172266');
INSERT INTO `crowdfundbet` VALUES ('10725', '20210308016', '10000053', 'claudia', '00000000453', '2021030801628793', '1615172386');
INSERT INTO `crowdfundbet` VALUES ('10726', '20210308016', '10000034', 'amaryllis', '00000005205', '2021030801633998', '1615172446');
INSERT INTO `crowdfundbet` VALUES ('10727', '20210308016', '10000009', 'desdemona', '00000005162', '2021030801639160', '1615172506');
INSERT INTO `crowdfundbet` VALUES ('10728', '20210308016', '10000182', 'परांजॉय', '00000005477', '2021030801644637', '1615172566');
INSERT INTO `crowdfundbet` VALUES ('10729', '20210308016', '10000132', 'Larissa', '00000001301', '2021030801645938', '1615172686');
INSERT INTO `crowdfundbet` VALUES ('10730', '20210308016', '10000096', 'Queen ', '00000000212', '2021030801646150', '1615172746');
INSERT INTO `crowdfundbet` VALUES ('10731', '20210308016', '10000078', 'James', '00000002746', '2021030801648896', '1615172806');
INSERT INTO `crowdfundbet` VALUES ('10732', '20210308016', '10000042', 'felicia', '00000000493', '2021030801649389', '1615172866');
INSERT INTO `crowdfundbet` VALUES ('10733', '20210308016', '10000023', 'serafina', '00000005889', '2021030801655278', '1615172926');
INSERT INTO `crowdfundbet` VALUES ('10734', '20210308016', '10000189', 'प्रीतम', '00000003618', '2021030801658896', '1615172986');
INSERT INTO `crowdfundbet` VALUES ('10735', '20210308016', '10000172', 'मार्तंड', '00000006003', '2021030801664899', '1615173046');
INSERT INTO `crowdfundbet` VALUES ('10736', '20210308016', '10000137', 'Albert', '00000000661', '2021030801665560', '1615173106');
INSERT INTO `crowdfundbet` VALUES ('10737', '20210308016', '10000120', 'Bill', '00000006293', '2021030801671853', '1615173166');
INSERT INTO `crowdfundbet` VALUES ('10738', '20210308016', '10000085', 'Insane', '00000003866', '2021030801675719', '1615173226');
INSERT INTO `crowdfundbet` VALUES ('10739', '20210308016', '10000064', 'kira', '00000005551', '2021030801681270', '1615173286');
INSERT INTO `crowdfundbet` VALUES ('10740', '20210308016', '10000029', 'delores', '00000005047', '2021030801686317', '1615173346');
INSERT INTO `crowdfundbet` VALUES ('10741', '20210308016', '10000012', 'louise', '00000006177', '2021030801692494', '1615173406');
INSERT INTO `crowdfundbet` VALUES ('10742', '20210308016', '10000177', 'नवद्वीप', '00000007506', '20210308016100000', '1615173466');
INSERT INTO `crowdfundbet` VALUES ('10743', '20210308016', '10000159', 'हर्षिता', '00000000000', '20210308016100000', '1615173526');
INSERT INTO `crowdfundbet` VALUES ('10744', '20210308016', '10000126', 'Addison', '00000000000', '20210308016100000', '1615173586');
INSERT INTO `crowdfundbet` VALUES ('10745', '20210308017', '10000072', 'Charles', '00000002910', '202103080172910', '1615173706');
INSERT INTO `crowdfundbet` VALUES ('10746', '20210308017', '10000054', 'deirdre', '00000005557', '202103080178467', '1615173766');
INSERT INTO `crowdfundbet` VALUES ('10747', '20210308017', '10000018', 'amaris', '00000000021', '202103080178488', '1615173826');
INSERT INTO `crowdfundbet` VALUES ('10748', '20210308017', '10000009', 'desdemona', '00000005985', '2021030801714473', '1615173886');
INSERT INTO `crowdfundbet` VALUES ('10749', '20210308017', '10000167', 'मदन', '00000002040', '2021030801716513', '1615173946');
INSERT INTO `crowdfundbet` VALUES ('10750', '20210308017', '10000148', 'Jacquelyn', '00000000860', '2021030801717373', '1615174006');
INSERT INTO `crowdfundbet` VALUES ('10751', '20210308017', '10000115', 'Abraham', '00000003548', '2021030801720921', '1615174066');
INSERT INTO `crowdfundbet` VALUES ('10752', '20210308017', '10000096', 'Queen ', '00000000149', '2021030801721070', '1615174126');
INSERT INTO `crowdfundbet` VALUES ('10753', '20210308017', '10000059', 'lilith', '00000005574', '2021030801726644', '1615174186');
INSERT INTO `crowdfundbet` VALUES ('10754', '20210308017', '10000040', 'danae', '00000003821', '2021030801730465', '1615174246');
INSERT INTO `crowdfundbet` VALUES ('10755', '20210308017', '10000005', 'ulrica', '00000000045', '2021030801730510', '1615174306');
INSERT INTO `crowdfundbet` VALUES ('10756', '20210308017', '10000188', 'प्राणजीवन', '00000002860', '2021030801733370', '1615174366');
INSERT INTO `crowdfundbet` VALUES ('10757', '20210308017', '10000154', 'गुरुदट', '00000003275', '2021030801736645', '1615174426');
INSERT INTO `crowdfundbet` VALUES ('10758', '20210308017', '10000137', 'Albert', '00000000432', '2021030801737077', '1615174486');
INSERT INTO `crowdfundbet` VALUES ('10759', '20210308017', '10000101', 'Carl', '00000002095', '2021030801739172', '1615174546');
INSERT INTO `crowdfundbet` VALUES ('10760', '20210308017', '10000083', 'Dirge ', '00000006091', '2021030801745263', '1615174606');
INSERT INTO `crowdfundbet` VALUES ('10761', '20210308017', '10000047', 'cecile', '00000005608', '2021030801750871', '1615174666');
INSERT INTO `crowdfundbet` VALUES ('10762', '20210308017', '10000028', 'dolores', '00000001133', '2021030801752004', '1615174726');
INSERT INTO `crowdfundbet` VALUES ('10763', '20210308017', '10000195', 'रामप्रसाद', '00000001836', '2021030801753840', '1615174786');
INSERT INTO `crowdfundbet` VALUES ('10764', '20210308017', '10000177', 'नवद्वीप', '00000000012', '2021030801753852', '1615174846');
INSERT INTO `crowdfundbet` VALUES ('10765', '20210308017', '10000142', 'Tankard', '00000001215', '2021030801755067', '1615174906');
INSERT INTO `crowdfundbet` VALUES ('10766', '20210308017', '10000125', 'Easter', '00000003494', '2021030801758561', '1615174966');
INSERT INTO `crowdfundbet` VALUES ('10767', '20210308017', '10000090', 'autistic ', '00000006239', '2021030801764800', '1615175026');
INSERT INTO `crowdfundbet` VALUES ('10768', '20210308017', '10000069', 'LenaKong', '00000001603', '2021030801766403', '1615175086');
INSERT INTO `crowdfundbet` VALUES ('10769', '20210308017', '10000034', 'amaryllis', '00000005846', '2021030801772249', '1615175146');
INSERT INTO `crowdfundbet` VALUES ('10770', '20210308017', '10000017', 'celina', '00000002183', '2021030801774432', '1615175206');
INSERT INTO `crowdfundbet` VALUES ('10771', '20210308017', '10000182', 'परांजॉय', '00000025568', '20210308017100000', '1615175266');
INSERT INTO `crowdfundbet` VALUES ('10772', '20210308017', '10000164', 'कर्मजीत', '00000000000', '20210308017100000', '1615175326');
INSERT INTO `crowdfundbet` VALUES ('10773', '20210308017', '10000131', 'Tommy', '00000000000', '20210308017100000', '1615175386');
INSERT INTO `crowdfundbet` VALUES ('10774', '20210308018', '10000078', 'James', '00000002973', '202103080182973', '1615175506');
INSERT INTO `crowdfundbet` VALUES ('10775', '20210308018', '10000059', 'lilith', '00000004852', '202103080187825', '1615175566');
INSERT INTO `crowdfundbet` VALUES ('10776', '20210308018', '10000023', 'serafina', '00000004001', '2021030801811826', '1615175626');
INSERT INTO `crowdfundbet` VALUES ('10777', '20210308018', '10000004', 'cassiel', '00000001535', '2021030801813361', '1615175686');
INSERT INTO `crowdfundbet` VALUES ('10778', '20210308018', '10000172', 'मार्तंड', '00000003497', '2021030801816858', '1615175746');
INSERT INTO `crowdfundbet` VALUES ('10779', '20210308018', '10000153', 'गोविंद', '00000004252', '2021030801821110', '1615175806');
INSERT INTO `crowdfundbet` VALUES ('10780', '20210308018', '10000120', 'Bill', '00000002305', '2021030801823415', '1615175866');
INSERT INTO `crowdfundbet` VALUES ('10781', '20210308018', '10000101', 'Carl', '00000001319', '2021030801824734', '1615175926');
INSERT INTO `crowdfundbet` VALUES ('10782', '20210308018', '10000064', 'kira', '00000006233', '2021030801830967', '1615175986');
INSERT INTO `crowdfundbet` VALUES ('10783', '20210308018', '10000046', 'sicily', '00000001243', '2021030801832210', '1615176046');
INSERT INTO `crowdfundbet` VALUES ('10784', '20210308018', '10000012', 'louise', '00000003743', '2021030801835953', '1615176106');
INSERT INTO `crowdfundbet` VALUES ('10785', '20210308018', '10000194', 'रामानुज', '00000005874', '2021030801841827', '1615176166');
INSERT INTO `crowdfundbet` VALUES ('10786', '20210308018', '10000159', 'हर्षिता', '00000006253', '2021030801848080', '1615176226');
INSERT INTO `crowdfundbet` VALUES ('10787', '20210308018', '10000109', 'Albert', '00000005935', '2021030801854015', '1615176346');
INSERT INTO `crowdfundbet` VALUES ('10788', '20210308018', '10000055', 'desdemona', '00000006118', '2021030801860133', '1615176466');
INSERT INTO `crowdfundbet` VALUES ('10789', '20210308018', '10000001', 'mica', '00000003789', '2021030801863922', '1615176586');
INSERT INTO `crowdfundbet` VALUES ('10790', '20210308018', '10000185', 'पार्थसारथी', '00000003872', '2021030801867794', '1615176646');
INSERT INTO `crowdfundbet` VALUES ('10791', '20210308018', '10000150', 'गोपीनाथ', '00000003640', '2021030801871434', '1615176706');
INSERT INTO `crowdfundbet` VALUES ('10792', '20210308018', '10000133', 'Caiden', '00000000873', '2021030801872307', '1615176766');
INSERT INTO `crowdfundbet` VALUES ('10793', '20210308018', '10000098', 'Diamonds ', '00000004991', '2021030801877298', '1615176826');
INSERT INTO `crowdfundbet` VALUES ('10794', '20210308018', '10000079', 'Henry', '00000002523', '2021030801879821', '1615176886');
INSERT INTO `crowdfundbet` VALUES ('10795', '20210308018', '10000043', 'snow', '00000003769', '2021030801883590', '1615176946');
INSERT INTO `crowdfundbet` VALUES ('10796', '20210308018', '10000025', 'sakura', '00000006141', '2021030801889731', '1615177006');
INSERT INTO `crowdfundbet` VALUES ('10797', '20210308018', '10000190', 'राधानाथ', '00000010269', '20210308018100000', '1615177066');
INSERT INTO `crowdfundbet` VALUES ('10798', '20210308018', '10000173', 'नाडिश', '00000000000', '20210308018100000', '1615177126');
INSERT INTO `crowdfundbet` VALUES ('10799', '20210308018', '10000139', 'Easter', '00000000000', '20210308018100000', '1615177186');
INSERT INTO `crowdfundbet` VALUES ('10800', '20210308019', '12', 'ssjj', '00000000005', '202103080195', '1615177290');
INSERT INTO `crowdfundbet` VALUES ('10801', '20210308019', '12', 'ssjj', '00000000005', '2021030801910', '1615177295');
INSERT INTO `crowdfundbet` VALUES ('10802', '20210308019', '10000087', 'durance ', '00000002540', '202103080192550', '1615177306');
INSERT INTO `crowdfundbet` VALUES ('10803', '20210308019', '12', 'ssjj', '00000000005', '202103080192555', '1615177308');
INSERT INTO `crowdfundbet` VALUES ('10804', '20210308019', '12', 'ssjj', '00000000100', '202103080192655', '1615177315');
INSERT INTO `crowdfundbet` VALUES ('10805', '20210308019', '12', 'ssjj', '00000000100', '202103080192755', '1615177356');
INSERT INTO `crowdfundbet` VALUES ('10806', '20210308019', '10000067', 'cassiopeia', '00000001084', '202103080193839', '1615177366');
INSERT INTO `crowdfundbet` VALUES ('10807', '20210308019', '10000031', 'deirdre', '00000005186', '202103080199025', '1615177426');
INSERT INTO `crowdfundbet` VALUES ('10808', '20210308019', '10000014', 'chloe', '00000003707', '2021030801912732', '1615177486');
INSERT INTO `crowdfundbet` VALUES ('10809', '20210308019', '10000180', 'निरहानकर', '00000005296', '2021030801918028', '1615177546');
INSERT INTO `crowdfundbet` VALUES ('10810', '20210308019', '10000161', 'ऋषिकेश', '00000001312', '2021030801919340', '1615177606');
INSERT INTO `crowdfundbet` VALUES ('10811', '20210308019', '10000128', 'Ryan', '00000006196', '2021030801925536', '1615177666');
INSERT INTO `crowdfundbet` VALUES ('10812', '20210308019', '10000111', 'Paul', '00000005214', '2021030801930750', '1615177726');
INSERT INTO `crowdfundbet` VALUES ('10813', '20210308019', '10000056', 'amaya', '00000006499', '2021030801937249', '1615177846');
INSERT INTO `crowdfundbet` VALUES ('10814', '20210308019', '10000002', 'gabrielle', '00000001843', '2021030801939092', '1615177966');
INSERT INTO `crowdfundbet` VALUES ('10815', '20210308019', '10000170', 'महंत', '00000002883', '2021030801941975', '1615178026');
INSERT INTO `crowdfundbet` VALUES ('10816', '20210308019', '10000152', 'गजेंद्र', '00000005450', '2021030801947425', '1615178086');
INSERT INTO `crowdfundbet` VALUES ('10817', '20210308019', '10000118', 'Ben', '00000001369', '2021030801948794', '1615178146');
INSERT INTO `crowdfundbet` VALUES ('10818', '20210308019', '10000099', 'Estrus ', '00000006035', '2021030801954829', '1615178206');
INSERT INTO `crowdfundbet` VALUES ('10819', '20210308019', '10000063', 'sade', '00000006102', '2021030801960931', '1615178266');
INSERT INTO `crowdfundbet` VALUES ('10820', '20210308019', '10000011', 'izefia', '00000000706', '2021030801961637', '1615178386');
INSERT INTO `crowdfundbet` VALUES ('10821', '20210308019', '10000194', 'रामानुज', '00000002604', '2021030801964241', '1615178446');
INSERT INTO `crowdfundbet` VALUES ('10822', '20210308019', '10000158', 'हर्षद', '00000000830', '2021030801965071', '1615178506');
INSERT INTO `crowdfundbet` VALUES ('10823', '20210308019', '10000141', 'Alex', '00000005339', '2021030801970410', '1615178566');
INSERT INTO `crowdfundbet` VALUES ('10824', '20210308019', '10000107', 'Barry', '00000002919', '2021030801973329', '1615178626');
INSERT INTO `crowdfundbet` VALUES ('10825', '20210308019', '10000088', 'Allure', '00000001399', '2021030801974728', '1615178686');
INSERT INTO `crowdfundbet` VALUES ('10826', '20210308019', '10000051', 'dolores', '00000003521', '2021030801978249', '1615178746');
INSERT INTO `crowdfundbet` VALUES ('10827', '20210308019', '10000033', 'amaya', '00000000299', '2021030801978548', '1615178806');
INSERT INTO `crowdfundbet` VALUES ('10828', '20210308019', '10000199', 'रोशन', '00000021452', '20210308019100000', '1615178866');
INSERT INTO `crowdfundbet` VALUES ('10829', '20210308019', '10000181', 'पलाश', '00000000000', '20210308019100000', '1615178926');
INSERT INTO `crowdfundbet` VALUES ('10830', '20210308019', '10000147', 'Karen', '00000000000', '20210308019100000', '1615178986');
INSERT INTO `crowdfundbet` VALUES ('10831', '20210308020', '10000095', 'Ovdoes ', '00000001940', '202103080201940', '1615179106');
INSERT INTO `crowdfundbet` VALUES ('10832', '20210308020', '10000077', 'Joseph', '00000004902', '202103080206842', '1615179166');
INSERT INTO `crowdfundbet` VALUES ('10833', '20210308020', '10000039', 'cecilia', '00000000270', '202103080207112', '1615179226');
INSERT INTO `crowdfundbet` VALUES ('10834', '20210308020', '10000022', 'sera', '00000005790', '2021030802012902', '1615179286');
INSERT INTO `crowdfundbet` VALUES ('10835', '20210308020', '10000188', 'प्राणजीवन', '00000000363', '2021030802013265', '1615179346');
INSERT INTO `crowdfundbet` VALUES ('10836', '20210308020', '10000170', 'महंत', '00000003565', '2021030802016830', '1615179406');
INSERT INTO `crowdfundbet` VALUES ('10837', '20210308020', '10000136', 'Joyce', '00000004495', '2021030802021325', '1615179466');
INSERT INTO `crowdfundbet` VALUES ('10838', '20210308020', '10000119', 'Evan', '00000005912', '2021030802027237', '1615179526');
INSERT INTO `crowdfundbet` VALUES ('10839', '20210308020', '10000082', 'Promise ', '00000002289', '2021030802029526', '1615179586');
INSERT INTO `crowdfundbet` VALUES ('10840', '20210308020', '10000063', 'sade', '00000002080', '2021030802031606', '1615179646');
INSERT INTO `crowdfundbet` VALUES ('10841', '20210308020', '10000028', 'dolores', '00000001512', '2021030802033118', '1615179706');
INSERT INTO `crowdfundbet` VALUES ('10842', '20210308020', '10000008', 'claudia', '00000003756', '2021030802036874', '1615179766');
INSERT INTO `crowdfundbet` VALUES ('10843', '20210308020', '10000176', 'नवदविप', '00000000347', '2021030802037221', '1615179826');
INSERT INTO `crowdfundbet` VALUES ('10844', '20210308020', '10000158', 'हर्षद', '00000001865', '2021030802039086', '1615179886');
INSERT INTO `crowdfundbet` VALUES ('10845', '20210308020', '10000124', 'Kelly', '00000003108', '2021030802042194', '1615179946');
INSERT INTO `crowdfundbet` VALUES ('10846', '20210308020', '10000105', 'Solomon', '00000003372', '2021030802045566', '1615180006');
INSERT INTO `crowdfundbet` VALUES ('10847', '20210308020', '10000069', 'LenaKong', '00000005416', '2021030802050982', '1615180066');
INSERT INTO `crowdfundbet` VALUES ('10848', '20210308020', '10000050', 'elodie', '00000001563', '2021030802052545', '1615180126');
INSERT INTO `crowdfundbet` VALUES ('10849', '20210308020', '10000016', 'snow', '00000000719', '2021030802053264', '1615180186');
INSERT INTO `crowdfundbet` VALUES ('10850', '20210308020', '10000199', 'रोशन', '00000001689', '2021030802054953', '1615180246');
INSERT INTO `crowdfundbet` VALUES ('10851', '20210308020', '10000163', 'कंवर', '00000002663', '2021030802057616', '1615180306');
INSERT INTO `crowdfundbet` VALUES ('10852', '20210308020', '10000146', 'Diego', '00000003461', '2021030802061077', '1615180366');
INSERT INTO `crowdfundbet` VALUES ('10853', '20210308020', '10000113', 'Denny', '00000003553', '2021030802064630', '1615180426');
INSERT INTO `crowdfundbet` VALUES ('10854', '20210308020', '10000093', 'Luminary ', '00000001359', '2021030802065989', '1615180486');
INSERT INTO `crowdfundbet` VALUES ('10855', '20210308020', '10000057', 'anemone', '00000004595', '2021030802070584', '1615180546');
INSERT INTO `crowdfundbet` VALUES ('10856', '20210308020', '10000038', 'laraine', '00000005616', '2021030802076200', '1615180606');
INSERT INTO `crowdfundbet` VALUES ('10857', '20210308020', '10000002', 'gabrielle', '00000023800', '20210308020100000', '1615180666');
INSERT INTO `crowdfundbet` VALUES ('10858', '20210308020', '10000186', 'पवनाज', '00000000000', '20210308020100000', '1615180726');
INSERT INTO `crowdfundbet` VALUES ('10859', '20210308020', '10000152', 'गजेंद्र', '00000000000', '20210308020100000', '1615180786');
INSERT INTO `crowdfundbet` VALUES ('10860', '20210308021', '10000100', 'Wilson', '00000005152', '202103080215152', '1615180906');
INSERT INTO `crowdfundbet` VALUES ('10861', '20210308021', '10000082', 'Promise ', '00000004951', '2021030802110103', '1615180966');
INSERT INTO `crowdfundbet` VALUES ('10862', '20210308021', '10000028', 'dolores', '00000004047', '2021030802114150', '1615181086');
INSERT INTO `crowdfundbet` VALUES ('10863', '20210308021', '10000195', 'रामप्रसाद', '00000002299', '2021030802116449', '1615181146');
INSERT INTO `crowdfundbet` VALUES ('10864', '20210308021', '10000176', 'नवदविप', '00000001557', '2021030802118006', '1615181206');
INSERT INTO `crowdfundbet` VALUES ('10865', '20210308021', '10000142', 'Tankard', '00000000786', '2021030802118792', '1615181266');
INSERT INTO `crowdfundbet` VALUES ('10866', '20210308021', '10000125', 'Easter', '00000002497', '2021030802121289', '1615181326');
INSERT INTO `crowdfundbet` VALUES ('10867', '20210308021', '10000089', 'Miss ', '00000003160', '2021030802124449', '1615181386');
INSERT INTO `crowdfundbet` VALUES ('10868', '20210308021', '10000069', 'LenaKong', '00000005536', '2021030802129985', '1615181446');
INSERT INTO `crowdfundbet` VALUES ('10869', '20210308021', '10000034', 'amaryllis', '00000002913', '2021030802132898', '1615181506');
INSERT INTO `crowdfundbet` VALUES ('10870', '20210308021', '10000016', 'snow', '00000006038', '2021030802138936', '1615181566');
INSERT INTO `crowdfundbet` VALUES ('10871', '20210308021', '10000182', 'परांजॉय', '00000003674', '2021030802142610', '1615181626');
INSERT INTO `crowdfundbet` VALUES ('10872', '20210308021', '10000164', 'कर्मजीत', '00000001168', '2021030802143778', '1615181686');
INSERT INTO `crowdfundbet` VALUES ('10873', '20210308021', '10000130', 'Kylie', '00000004835', '2021030802148613', '1615181746');
INSERT INTO `crowdfundbet` VALUES ('10874', '20210308021', '10000113', 'Denny', '00000001846', '2021030802150459', '1615181806');
INSERT INTO `crowdfundbet` VALUES ('10875', '20210308021', '10000077', 'Joseph', '00000004231', '2021030802154690', '1615181866');
INSERT INTO `crowdfundbet` VALUES ('10876', '20210308021', '10000057', 'anemone', '00000004918', '2021030802159608', '1615181926');
INSERT INTO `crowdfundbet` VALUES ('10877', '20210308021', '10000022', 'sera', '00000000700', '2021030802160308', '1615181986');
INSERT INTO `crowdfundbet` VALUES ('10878', '20210308021', '10000003', 'raffaella ', '00000001690', '2021030802161998', '1615182046');
INSERT INTO `crowdfundbet` VALUES ('10879', '20210308021', '10000170', 'महंत', '00000000049', '2021030802162047', '1615182106');
INSERT INTO `crowdfundbet` VALUES ('10880', '20210308021', '10000152', 'गजेंद्र', '00000004022', '2021030802166069', '1615182166');
INSERT INTO `crowdfundbet` VALUES ('10881', '20210308021', '10000119', 'Evan', '00000005881', '2021030802171950', '1615182226');
INSERT INTO `crowdfundbet` VALUES ('10882', '20210308021', '10000099', 'Estrus ', '00000005418', '2021030802177368', '1615182286');
INSERT INTO `crowdfundbet` VALUES ('10883', '20210308021', '10000063', 'sade', '00000002795', '2021030802180163', '1615182346');
INSERT INTO `crowdfundbet` VALUES ('10884', '20210308021', '10000045', 'amaris', '00000001862', '2021030802182025', '1615182406');
INSERT INTO `crowdfundbet` VALUES ('10885', '20210308021', '10000008', 'claudia', '00000017975', '20210308021100000', '1615182466');
INSERT INTO `crowdfundbet` VALUES ('10886', '20210308021', '10000192', 'रामभद्र', '00000000000', '20210308021100000', '1615182526');
INSERT INTO `crowdfundbet` VALUES ('10887', '20210308021', '10000158', 'हर्षद', '00000000000', '20210308021100000', '1615182586');
INSERT INTO `crowdfundbet` VALUES ('10888', '20210308022', '10000107', 'Barry', '00000002665', '202103080222665', '1615182706');
INSERT INTO `crowdfundbet` VALUES ('10889', '20210308022', '10000089', 'Miss ', '00000006248', '202103080228913', '1615182766');
INSERT INTO `crowdfundbet` VALUES ('10890', '20210308022', '10000051', 'dolores', '00000002679', '2021030802211592', '1615182826');
INSERT INTO `crowdfundbet` VALUES ('10891', '20210308022', '10000033', 'amaya', '00000004535', '2021030802216127', '1615182886');
INSERT INTO `crowdfundbet` VALUES ('10892', '20210308022', '10000106', 'Leon', '00000003251', '2021030802219378', '1615182946');
INSERT INTO `crowdfundbet` VALUES ('10893', '20210308022', '10000181', 'पलाश', '00000001676', '2021030802221054', '1615183006');
INSERT INTO `crowdfundbet` VALUES ('10894', '20210308022', '10000147', 'Karen', '00000000787', '2021030802221841', '1615183066');
INSERT INTO `crowdfundbet` VALUES ('10895', '20210308022', '10000130', 'Kylie', '00000003469', '2021030802225310', '1615183126');
INSERT INTO `crowdfundbet` VALUES ('10896', '20210308022', '10000094', 'mirage ', '00000001080', '2021030802226390', '1615183186');
INSERT INTO `crowdfundbet` VALUES ('10897', '20210308022', '10000076', 'William', '00000001237', '2021030802227627', '1615183246');
INSERT INTO `crowdfundbet` VALUES ('10898', '20210308022', '10000039', 'cecilia', '00000000321', '2021030802227948', '1615183306');
INSERT INTO `crowdfundbet` VALUES ('10899', '20210308022', '10', 'daxiong', '00000000100', '2021030802228048', '1615183345');
INSERT INTO `crowdfundbet` VALUES ('10900', '20210308022', '10000021', 'angelina', '00000002611', '2021030802230659', '1615183366');
INSERT INTO `crowdfundbet` VALUES ('10901', '20210308022', '10000187', 'प्रभाकर', '00000000248', '2021030802230907', '1615183426');
INSERT INTO `crowdfundbet` VALUES ('10902', '20210308022', '10000170', 'महंत', '00000003319', '2021030802234226', '1615183486');
INSERT INTO `crowdfundbet` VALUES ('10903', '20210308022', '10000135', 'Leon', '00000005722', '2021030802239948', '1615183546');
INSERT INTO `crowdfundbet` VALUES ('10904', '20210308022', '10000118', 'Ben', '00000006052', '2021030802246000', '1615183606');
INSERT INTO `crowdfundbet` VALUES ('10905', '20210308022', '22', '欧阳', '00000000007', '2021030802246007', '1615183615');
INSERT INTO `crowdfundbet` VALUES ('10906', '20210308022', '22', '欧阳', '00000000007', '2021030802246014', '1615183615');
INSERT INTO `crowdfundbet` VALUES ('10907', '20210308022', '22', '欧阳', '00000000007', '2021030802246021', '1615183617');
INSERT INTO `crowdfundbet` VALUES ('10908', '20210308022', '22', '欧阳', '00000000007', '2021030802246028', '1615183617');
INSERT INTO `crowdfundbet` VALUES ('10909', '20210308022', '22', '欧阳', '00000000007', '2021030802246035', '1615183618');
INSERT INTO `crowdfundbet` VALUES ('10910', '20210308022', '10000082', 'Promise ', '00000002713', '2021030802248748', '1615183666');
INSERT INTO `crowdfundbet` VALUES ('10911', '20210308022', '10000062', 'melantha', '00000001455', '2021030802250203', '1615183726');
INSERT INTO `crowdfundbet` VALUES ('10912', '20210308022', '10000027', 'fiona', '00000005467', '2021030802255670', '1615183786');
INSERT INTO `crowdfundbet` VALUES ('10913', '20210308022', '10000008', 'claudia', '00000001583', '2021030802257253', '1615183846');
INSERT INTO `crowdfundbet` VALUES ('10914', '20210308022', '10000175', 'नरोत्तम', '00000006619', '2021030802263872', '1615183906');
INSERT INTO `crowdfundbet` VALUES ('10915', '20210308022', '10000157', 'हरिप्रीत', '00000003371', '2021030802267243', '1615183966');
INSERT INTO `crowdfundbet` VALUES ('10916', '20210308022', '10000124', 'Kelly', '00000004472', '2021030802271715', '1615184026');
INSERT INTO `crowdfundbet` VALUES ('10917', '20210308022', '10000104', 'Kevin', '00000000731', '2021030802272446', '1615184086');
INSERT INTO `crowdfundbet` VALUES ('10918', '20210308022', '10000068', 'clamp', '00000005245', '2021030802277691', '1615184146');
INSERT INTO `crowdfundbet` VALUES ('10919', '20210308022', '10000050', 'elodie', '00000005762', '2021030802283453', '1615184206');
INSERT INTO `crowdfundbet` VALUES ('10920', '20210308022', '10000015', 'felicia', '00000016547', '20210308022100000', '1615184266');
INSERT INTO `crowdfundbet` VALUES ('10921', '20210308022', '10000198', 'रौनक', '00000000000', '20210308022100000', '1615184326');
INSERT INTO `crowdfundbet` VALUES ('10922', '20210308022', '10000163', 'कंवर', '00000000000', '20210308022100000', '1615184386');
INSERT INTO `crowdfundbet` VALUES ('10923', '20210308023', '10000113', 'Denny', '00000006326', '202103080236326', '1615184506');
INSERT INTO `crowdfundbet` VALUES ('10924', '20210308023', '10000094', 'mirage ', '00000002971', '202103080239297', '1615184566');
INSERT INTO `crowdfundbet` VALUES ('10925', '20210308023', '10000057', 'anemone', '00000005764', '2021030802315061', '1615184626');
INSERT INTO `crowdfundbet` VALUES ('10926', '20210308023', '10000004', 'cassiel', '00000002894', '2021030802317955', '1615184746');
INSERT INTO `crowdfundbet` VALUES ('10927', '20210308023', '10000187', 'प्रभाकर', '00000001139', '2021030802319094', '1615184806');
INSERT INTO `crowdfundbet` VALUES ('10928', '20210308023', '10000153', 'गोविंद', '00000000547', '2021030802319641', '1615184866');
INSERT INTO `crowdfundbet` VALUES ('10929', '20210308023', '10000136', 'Joyce', '00000003281', '2021030802322922', '1615184926');
INSERT INTO `crowdfundbet` VALUES ('10930', '20210308023', '10000100', 'Wilson', '00000001485', '2021030802324407', '1615184986');
INSERT INTO `crowdfundbet` VALUES ('10931', '20210308023', '10000082', 'Promise ', '00000004183', '2021030802328590', '1615185046');
INSERT INTO `crowdfundbet` VALUES ('10932', '20210308023', '10000046', 'sicily', '00000004888', '2021030802333478', '1615185106');
INSERT INTO `crowdfundbet` VALUES ('10933', '20210308023', '10000027', 'fiona', '00000004235', '2021030802337713', '1615185166');
INSERT INTO `crowdfundbet` VALUES ('10934', '20210308023', '10000194', 'रामानुज', '00000004634', '2021030802342347', '1615185226');
INSERT INTO `crowdfundbet` VALUES ('10935', '20210308023', '10000176', 'नवदविप', '00000003751', '2021030802346098', '1615185286');
INSERT INTO `crowdfundbet` VALUES ('10936', '20210308023', '10000141', 'Alex', '00000006459', '2021030802352557', '1615185346');
INSERT INTO `crowdfundbet` VALUES ('10937', '20210308023', '10000124', 'Kelly', '00000004224', '2021030802356781', '1615185406');
INSERT INTO `crowdfundbet` VALUES ('10938', '20210308023', '10000069', 'LenaKong', '00000002018', '2021030802358799', '1615185526');
INSERT INTO `crowdfundbet` VALUES ('10939', '20210308023', '10000034', 'amaryllis', '00000006113', '2021030802364912', '1615185586');
INSERT INTO `crowdfundbet` VALUES ('10940', '20210308023', '10000017', 'celina', '00000000886', '2021030802365798', '1615185646');
INSERT INTO `crowdfundbet` VALUES ('10941', '20210308023', '10000182', 'परांजॉय', '00000006157', '2021030802371955', '1615185706');
INSERT INTO `crowdfundbet` VALUES ('10942', '20210308023', '10000164', 'कर्मजीत', '00000001578', '2021030802373533', '1615185766');
INSERT INTO `crowdfundbet` VALUES ('10943', '20210308023', '10000131', 'Tommy', '00000002427', '2021030802375960', '1615185826');
INSERT INTO `crowdfundbet` VALUES ('10944', '20210308023', '10000113', 'Denny', '00000000194', '2021030802376154', '1615185886');
INSERT INTO `crowdfundbet` VALUES ('10945', '20210308023', '10000077', 'Joseph', '00000001699', '2021030802377853', '1615185946');
INSERT INTO `crowdfundbet` VALUES ('10946', '20210308023', '10000058', 'michaela', '00000003712', '2021030802381565', '1615186006');
INSERT INTO `crowdfundbet` VALUES ('10947', '20210308023', '10000022', 'sera', '00000018435', '20210308023100000', '1615186066');
INSERT INTO `crowdfundbet` VALUES ('10948', '20210308023', '10000003', 'raffaella ', '00000000000', '20210308023100000', '1615186126');
INSERT INTO `crowdfundbet` VALUES ('10949', '20210308023', '10000171', 'मनमोहन', '00000000000', '20210308023100000', '1615186186');
INSERT INTO `crowdfundbet` VALUES ('10950', '20210308024', '10000120', 'Bill', '00000000994', '20210308024994', '1615186306');
INSERT INTO `crowdfundbet` VALUES ('10951', '20210308024', '10000101', 'Carl', '00000002141', '202103080243135', '1615186366');
INSERT INTO `crowdfundbet` VALUES ('10952', '20210308024', '10000064', 'kira', '00000005018', '202103080248153', '1615186426');
INSERT INTO `crowdfundbet` VALUES ('10953', '20210308024', '10000046', 'sicily', '00000005092', '2021030802413245', '1615186486');
INSERT INTO `crowdfundbet` VALUES ('10954', '20210308024', '10000012', 'louise', '00000005479', '2021030802418724', '1615186546');
INSERT INTO `crowdfundbet` VALUES ('10955', '20210308024', '10000194', 'रामानुज', '00000006080', '2021030802424804', '1615186606');
INSERT INTO `crowdfundbet` VALUES ('10956', '20210308024', '10000143', 'Harriet', '00000001954', '2021030802426758', '1615186726');
INSERT INTO `crowdfundbet` VALUES ('10957', '20210308024', '10000109', 'Albert', '00000006067', '2021030802432825', '1615186786');
INSERT INTO `crowdfundbet` VALUES ('10958', '20210308024', '10000090', 'autistic ', '00000003158', '2021030802435983', '1615186846');
INSERT INTO `crowdfundbet` VALUES ('10959', '20210308024', '10000054', 'deirdre', '00000004217', '2021030802440200', '1615186906');
INSERT INTO `crowdfundbet` VALUES ('10960', '20210308024', '10000000', 'michelle', '00000003119', '2021030802443319', '1615187026');
INSERT INTO `crowdfundbet` VALUES ('10961', '20210308024', '10000184', 'परिक्षित', '00000005594', '2021030802448913', '1615187086');
INSERT INTO `crowdfundbet` VALUES ('10962', '20210308024', '10000149', 'Irene', '00000006467', '2021030802455380', '1615187146');
INSERT INTO `crowdfundbet` VALUES ('10963', '20210308024', '10000098', 'Diamonds ', '00000001406', '2021030802456786', '1615187266');
INSERT INTO `crowdfundbet` VALUES ('10964', '20210308024', '10000079', 'Henry', '00000002131', '2021030802458917', '1615187326');
INSERT INTO `crowdfundbet` VALUES ('10965', '20210308024', '10000043', 'snow', '00000005656', '2021030802464573', '1615187386');
INSERT INTO `crowdfundbet` VALUES ('10966', '20210308024', '10000025', 'sakura', '00000002861', '2021030802467434', '1615187446');
INSERT INTO `crowdfundbet` VALUES ('10967', '20210308024', '10000190', 'राधानाथ', '00000006046', '2021030802473480', '1615187506');
INSERT INTO `crowdfundbet` VALUES ('10968', '20210308024', '10000140', 'Alonso', '00000002634', '2021030802476114', '1615187626');
INSERT INTO `crowdfundbet` VALUES ('10969', '20210308024', '10000122', 'Peter', '00000005082', '2021030802481196', '1615187686');
INSERT INTO `crowdfundbet` VALUES ('10970', '20210308024', '10000087', 'durance ', '00000001236', '2021030802482432', '1615187746');
INSERT INTO `crowdfundbet` VALUES ('10971', '20210308024', '10000067', 'cassiopeia', '00000004629', '2021030802487061', '1615187806');
INSERT INTO `crowdfundbet` VALUES ('10972', '20210308024', '10000031', 'deirdre', '00000012939', '20210308024100000', '1615187866');
INSERT INTO `crowdfundbet` VALUES ('10973', '20210308024', '10000014', 'chloe', '00000000000', '20210308024100000', '1615187926');
INSERT INTO `crowdfundbet` VALUES ('10974', '20210308024', '10000180', 'निरहानकर', '00000000000', '20210308024100000', '1615187986');
INSERT INTO `crowdfundbet` VALUES ('10975', '20210308025', '10000129', 'Aidan', '00000002878', '202103080252878', '1615188106');
INSERT INTO `crowdfundbet` VALUES ('10976', '20210308025', '10000112', 'Charles', '00000005984', '202103080258862', '1615188166');
INSERT INTO `crowdfundbet` VALUES ('10977', '20210308025', '10000075', 'Vincent', '00000001160', '2021030802510022', '1615188226');
INSERT INTO `crowdfundbet` VALUES ('10978', '20210308025', '10000056', 'amaya', '00000001186', '2021030802511208', '1615188286');
INSERT INTO `crowdfundbet` VALUES ('10979', '20210308025', '10000021', 'angelina', '00000001620', '2021030802512828', '1615188346');
INSERT INTO `crowdfundbet` VALUES ('10980', '20210308025', '10000001', 'mica', '00000001685', '2021030802514513', '1615188406');
INSERT INTO `crowdfundbet` VALUES ('10981', '20210308025', '10000169', 'मधुसूदन', '00000003915', '2021030802518428', '1615188466');
INSERT INTO `crowdfundbet` VALUES ('10982', '20210308025', '10000151', 'गगन', '00000002797', '2021030802521225', '1615188526');
INSERT INTO `crowdfundbet` VALUES ('10983', '20210308025', '10000117', 'Kenny', '00000000124', '2021030802521349', '1615188586');
INSERT INTO `crowdfundbet` VALUES ('10984', '20210308025', '10000098', 'Diamonds ', '00000002102', '2021030802523451', '1615188646');
INSERT INTO `crowdfundbet` VALUES ('10985', '20210308025', '10000062', 'melantha', '00000005153', '2021030802528604', '1615188706');
INSERT INTO `crowdfundbet` VALUES ('10986', '20210308025', '10000043', 'snow', '00000003059', '2021030802531663', '1615188766');
INSERT INTO `crowdfundbet` VALUES ('10987', '20210308025', '10000007', 'cecilia', '00000000636', '2021030802532299', '1615188826');
INSERT INTO `crowdfundbet` VALUES ('10988', '20210308025', '10000191', 'रक्षम्बर', '00000003065', '2021030802535364', '1615188886');
INSERT INTO `crowdfundbet` VALUES ('10989', '20210308025', '10000156', 'हरिदासचैतन्य', '00000005759', '2021030802541123', '1615188946');
INSERT INTO `crowdfundbet` VALUES ('10990', '20210308025', '10000139', 'Easter', '00000005898', '2021030802547021', '1615189006');
INSERT INTO `crowdfundbet` VALUES ('10991', '20210308025', '10000104', 'Kevin', '00000004004', '2021030802551025', '1615189066');
INSERT INTO `crowdfundbet` VALUES ('10992', '20210308025', '10000086', 'Figure ', '00000003913', '2021030802554938', '1615189126');
INSERT INTO `crowdfundbet` VALUES ('10993', '20210308025', '10000049', 'fiona', '00000005890', '2021030802560828', '1615189186');
INSERT INTO `crowdfundbet` VALUES ('10994', '20210308025', '10000031', 'deirdre', '00000002270', '2021030802563098', '1615189246');
INSERT INTO `crowdfundbet` VALUES ('10995', '20210308025', '10000197', 'ऋषभदेव', '00000006378', '2021030802569476', '1615189306');
INSERT INTO `crowdfundbet` VALUES ('10996', '20210308025', '10000179', 'नील माधव', '00000002101', '2021030802571577', '1615189366');
INSERT INTO `crowdfundbet` VALUES ('10997', '20210308025', '10000145', 'Aidan', '00000002226', '2021030802573803', '1615189426');
INSERT INTO `crowdfundbet` VALUES ('10998', '20210308025', '10000127', 'Alex', '00000004944', '2021030802578747', '1615189486');
INSERT INTO `crowdfundbet` VALUES ('10999', '20210308025', '10000092', 'Serious', '00000001442', '2021030802580189', '1615189546');
INSERT INTO `crowdfundbet` VALUES ('11000', '20210308025', '10000074', 'Bill', '00000004594', '2021030802584783', '1615189606');
INSERT INTO `crowdfundbet` VALUES ('11001', '20210308025', '10000036', 'cytheria', '00000015217', '20210308025100000', '1615189666');
INSERT INTO `crowdfundbet` VALUES ('11002', '20210308025', '10000019', 'sicily', '00000000000', '20210308025100000', '1615189726');
INSERT INTO `crowdfundbet` VALUES ('11003', '20210308025', '10000185', 'पार्थसारथी', '00000000000', '20210308025100000', '1615189786');
INSERT INTO `crowdfundbet` VALUES ('11004', '20210308026', '10000134', 'Kelly', '00000006595', '202103080266595', '1615189906');
INSERT INTO `crowdfundbet` VALUES ('11005', '20210308026', '10000117', 'Kenny', '00000002151', '202103080268746', '1615189966');
INSERT INTO `crowdfundbet` VALUES ('11006', '20210308026', '10000080', 'Gary', '00000001902', '2021030802610648', '1615190026');
INSERT INTO `crowdfundbet` VALUES ('11007', '20210308026', '10000061', 'easter', '00000006553', '2021030802617201', '1615190086');
INSERT INTO `crowdfundbet` VALUES ('11008', '20210308026', '10000007', 'cecilia', '00000001313', '2021030802618514', '1615190206');
INSERT INTO `crowdfundbet` VALUES ('11009', '20210308026', '10000175', 'नरोत्तम', '00000004524', '2021030802623038', '1615190266');
INSERT INTO `crowdfundbet` VALUES ('11010', '20210308026', '10000157', 'हरिप्रीत', '00000003760', '2021030802626798', '1615190326');
INSERT INTO `crowdfundbet` VALUES ('11011', '20210308026', '10000123', 'JasonJohnny', '00000004897', '2021030802631695', '1615190386');
INSERT INTO `crowdfundbet` VALUES ('11012', '20210308026', '10000104', 'Kevin', '00000006086', '2021030802637781', '1615190446');
INSERT INTO `crowdfundbet` VALUES ('11013', '20210308026', '10000050', 'elodie', '00000001946', '2021030802639727', '1615190566');
INSERT INTO `crowdfundbet` VALUES ('11014', '20210308026', '10000016', 'snow', '00000000491', '2021030802640218', '1615190626');
INSERT INTO `crowdfundbet` VALUES ('11015', '20210308026', '10000199', 'रोशन', '00000006375', '2021030802646593', '1615190686');
INSERT INTO `crowdfundbet` VALUES ('11016', '20210308026', '10000163', 'कंवर', '00000005113', '2021030802651706', '1615190746');
INSERT INTO `crowdfundbet` VALUES ('11017', '20210308026', '10000146', 'Diego', '00000004386', '2021030802656092', '1615190806');
INSERT INTO `crowdfundbet` VALUES ('11018', '20210308026', '10000113', 'Denny', '00000001864', '2021030802657956', '1615190866');
INSERT INTO `crowdfundbet` VALUES ('11019', '20210308026', '10000093', 'Luminary ', '00000003768', '2021030802661724', '1615190926');
INSERT INTO `crowdfundbet` VALUES ('11020', '20210308026', '10000057', 'anemone', '00000002433', '2021030802664157', '1615190986');
INSERT INTO `crowdfundbet` VALUES ('11021', '20210308026', '10000038', 'laraine', '00000005414', '2021030802669571', '1615191046');
INSERT INTO `crowdfundbet` VALUES ('11022', '20210308026', '10000002', 'gabrielle', '00000005440', '2021030802675011', '1615191106');
INSERT INTO `crowdfundbet` VALUES ('11023', '20210308026', '10000153', 'गोविंद', '00000004119', '2021030802679130', '1615191226');
INSERT INTO `crowdfundbet` VALUES ('11024', '20210308026', '10000135', 'Leon', '00000001285', '2021030802680415', '1615191286');
INSERT INTO `crowdfundbet` VALUES ('11025', '20210308026', '10000100', 'Wilson', '00000001515', '2021030802681930', '1615191346');
INSERT INTO `crowdfundbet` VALUES ('11026', '20210308026', '10000082', 'Promise ', '00000005931', '2021030802687861', '1615191406');
INSERT INTO `crowdfundbet` VALUES ('11027', '20210308026', '10000045', 'amaris', '00000012139', '20210308026100000', '1615191466');
INSERT INTO `crowdfundbet` VALUES ('11028', '20210308026', '10000027', 'fiona', '00000000000', '20210308026100000', '1615191526');
INSERT INTO `crowdfundbet` VALUES ('11029', '20210308026', '10000194', 'रामानुज', '00000000000', '20210308026100000', '1615191586');
INSERT INTO `crowdfundbet` VALUES ('11030', '20210308027', '10000142', 'Tankard', '00000002215', '202103080272215', '1615191706');
INSERT INTO `crowdfundbet` VALUES ('11031', '20210308027', '10000125', 'Easter', '00000001393', '202103080273608', '1615191766');
INSERT INTO `crowdfundbet` VALUES ('11032', '20210308027', '10000089', 'Miss ', '00000001832', '202103080275440', '1615191826');
INSERT INTO `crowdfundbet` VALUES ('11033', '20210308027', '10000069', 'LenaKong', '00000000479', '202103080275919', '1615191886');
INSERT INTO `crowdfundbet` VALUES ('11034', '20210308027', '10000034', 'amaryllis', '00000004312', '2021030802710231', '1615191946');
INSERT INTO `crowdfundbet` VALUES ('11035', '20210308027', '10000016', 'snow', '00000000230', '2021030802710461', '1615192006');
INSERT INTO `crowdfundbet` VALUES ('11036', '20210308027', '10000182', 'परांजॉय', '00000005047', '2021030802715508', '1615192066');
INSERT INTO `crowdfundbet` VALUES ('11037', '20210308027', '10000164', 'कर्मजीत', '00000006412', '2021030802721920', '1615192126');
INSERT INTO `crowdfundbet` VALUES ('11038', '20210308027', '10000130', 'Kylie', '00000002762', '2021030802724682', '1615192186');
INSERT INTO `crowdfundbet` VALUES ('11039', '20210308027', '10000113', 'Denny', '00000001754', '2021030802726436', '1615192246');
INSERT INTO `crowdfundbet` VALUES ('11040', '20210308027', '10000077', 'Joseph', '00000004255', '2021030802730691', '1615192306');
INSERT INTO `crowdfundbet` VALUES ('11041', '20210308027', '10000057', 'anemone', '00000005295', '2021030802735986', '1615192366');
INSERT INTO `crowdfundbet` VALUES ('11042', '20210308027', '10000022', 'sera', '00000002481', '2021030802738467', '1615192426');
INSERT INTO `crowdfundbet` VALUES ('11043', '20210308027', '10000003', 'raffaella ', '00000003331', '2021030802741798', '1615192486');
INSERT INTO `crowdfundbet` VALUES ('11044', '20210308027', '10000170', 'महंत', '00000001988', '2021030802743786', '1615192546');
INSERT INTO `crowdfundbet` VALUES ('11045', '20210308027', '10000152', 'गजेंद्र', '00000006462', '2021030802750248', '1615192606');
INSERT INTO `crowdfundbet` VALUES ('11046', '20210308027', '10000119', 'Evan', '00000005415', '2021030802755663', '1615192666');
INSERT INTO `crowdfundbet` VALUES ('11047', '20210308027', '10000099', 'Estrus ', '00000002099', '2021030802757762', '1615192726');
INSERT INTO `crowdfundbet` VALUES ('11048', '20210308027', '10000063', 'sade', '00000003445', '2021030802761207', '1615192786');
INSERT INTO `crowdfundbet` VALUES ('11049', '20210308027', '10000045', 'amaris', '00000002058', '2021030802763265', '1615192846');
INSERT INTO `crowdfundbet` VALUES ('11050', '20210308027', '10000008', 'claudia', '00000004673', '2021030802767938', '1615192906');
INSERT INTO `crowdfundbet` VALUES ('11051', '20210308027', '10000192', 'रामभद्र', '00000002627', '2021030802770565', '1615192966');
INSERT INTO `crowdfundbet` VALUES ('11052', '20210308027', '10000158', 'हर्षद', '00000001389', '2021030802771954', '1615193026');
INSERT INTO `crowdfundbet` VALUES ('11053', '20210308027', '10000140', 'Alonso', '00000002548', '2021030802774502', '1615193086');
INSERT INTO `crowdfundbet` VALUES ('11054', '20210308027', '10000105', 'Solomon', '00000002208', '2021030802776710', '1615193146');
INSERT INTO `crowdfundbet` VALUES ('11055', '20210308027', '10000088', 'Allure', '00000003382', '2021030802780092', '1615193206');
INSERT INTO `crowdfundbet` VALUES ('11056', '20210308027', '10000050', 'elodie', '00000019908', '20210308027100000', '1615193266');
INSERT INTO `crowdfundbet` VALUES ('11057', '20210308027', '10000032', 'desdemona', '00000000000', '20210308027100000', '1615193326');
INSERT INTO `crowdfundbet` VALUES ('11058', '20210308027', '10000199', 'रोशन', '00000000000', '20210308027100000', '1615193386');
INSERT INTO `crowdfundbet` VALUES ('11059', '20210308028', '10000147', 'Karen', '00000003412', '202103080283412', '1615193506');
INSERT INTO `crowdfundbet` VALUES ('11060', '20210308028', '10000130', 'Kylie', '00000004168', '202103080287580', '1615193566');
INSERT INTO `crowdfundbet` VALUES ('11061', '20210308028', '10000094', 'mirage ', '00000004337', '2021030802811917', '1615193626');
INSERT INTO `crowdfundbet` VALUES ('11062', '20210308028', '10000076', 'William', '00000002870', '2021030802814787', '1615193686');
INSERT INTO `crowdfundbet` VALUES ('11063', '20210308028', '10000039', 'cecilia', '00000005070', '2021030802819857', '1615193746');
INSERT INTO `crowdfundbet` VALUES ('11064', '20210308028', '10000021', 'angelina', '00000003487', '2021030802823344', '1615193806');
INSERT INTO `crowdfundbet` VALUES ('11065', '20210308028', '10000171', 'मनमोहन', '00000003390', '2021030802826734', '1615193926');
INSERT INTO `crowdfundbet` VALUES ('11066', '20210308028', '10000136', 'Joyce', '00000006318', '2021030802833052', '1615193986');
INSERT INTO `crowdfundbet` VALUES ('11067', '20210308028', '10000119', 'Evan', '00000005631', '2021030802838683', '1615194046');
INSERT INTO `crowdfundbet` VALUES ('11068', '20210308028', '10000064', 'kira', '00000005023', '2021030802843706', '1615194166');
INSERT INTO `crowdfundbet` VALUES ('11069', '20210308028', '10000013', 'danae', '00000004915', '2021030802848621', '1615194286');
INSERT INTO `crowdfundbet` VALUES ('11070', '20210308028', '10000178', 'नवरंग', '00000003949', '2021030802852570', '1615194346');
INSERT INTO `crowdfundbet` VALUES ('11071', '20210308028', '10000160', 'हेमदेव', '00000000985', '2021030802853555', '1615194406');
INSERT INTO `crowdfundbet` VALUES ('11072', '20210308028', '10000127', 'Alex', '00000003364', '2021030802856919', '1615194466');
INSERT INTO `crowdfundbet` VALUES ('11073', '20210308028', '10000109', 'Albert', '00000006346', '2021030802863265', '1615194526');
INSERT INTO `crowdfundbet` VALUES ('11074', '20210308028', '10000072', 'Charles', '00000004866', '2021030802868131', '1615194586');
INSERT INTO `crowdfundbet` VALUES ('11075', '20210308028', '10000019', 'sicily', '00000005926', '2021030802874057', '1615194706');
INSERT INTO `crowdfundbet` VALUES ('11076', '20210308028', '10000169', 'मधुसूदन', '00000001549', '2021030802875606', '1615194826');
INSERT INTO `crowdfundbet` VALUES ('11077', '20210308028', '10000150', 'गोपीनाथ', '00000001580', '2021030802877186', '1615194886');
INSERT INTO `crowdfundbet` VALUES ('11078', '20210308028', '10000117', 'Kenny', '00000000554', '2021030802877740', '1615194946');
INSERT INTO `crowdfundbet` VALUES ('11079', '20210308028', '10000098', 'Diamonds ', '00000005743', '2021030802883483', '1615195006');
INSERT INTO `crowdfundbet` VALUES ('11080', '20210308028', '10000061', 'easter', '00000016517', '20210308028100000', '1615195066');
INSERT INTO `crowdfundbet` VALUES ('11081', '20210308028', '10000043', 'snow', '00000000000', '20210308028100000', '1615195126');
INSERT INTO `crowdfundbet` VALUES ('11082', '20210308028', '10000007', 'cecilia', '00000000000', '20210308028100000', '1615195186');
INSERT INTO `crowdfundbet` VALUES ('11083', '20210308029', '10000157', 'हरिप्रीत', '00000000371', '20210308029371', '1615195306');
INSERT INTO `crowdfundbet` VALUES ('11084', '20210308029', '10000140', 'Alonso', '00000004633', '202103080295004', '1615195366');
INSERT INTO `crowdfundbet` VALUES ('11085', '20210308029', '10000104', 'Kevin', '00000002688', '202103080297692', '1615195426');
INSERT INTO `crowdfundbet` VALUES ('11086', '20210308029', '10000087', 'durance ', '00000000377', '202103080298069', '1615195486');
INSERT INTO `crowdfundbet` VALUES ('11087', '20210308029', '10000050', 'elodie', '00000006386', '2021030802914455', '1615195546');
INSERT INTO `crowdfundbet` VALUES ('11088', '20210308029', '10000031', 'deirdre', '00000003948', '2021030802918403', '1615195606');
INSERT INTO `crowdfundbet` VALUES ('11089', '20210308029', '10000198', 'रौनक', '00000005502', '2021030802923905', '1615195666');
INSERT INTO `crowdfundbet` VALUES ('11090', '20210308029', '10000180', 'निरहानकर', '00000006451', '2021030802930356', '1615195726');
INSERT INTO `crowdfundbet` VALUES ('11091', '20210308029', '10000129', 'Aidan', '00000000691', '2021030802931047', '1615195846');
INSERT INTO `crowdfundbet` VALUES ('11092', '20210308029', '10000094', 'mirage ', '00000002867', '2021030802933914', '1615195906');
INSERT INTO `crowdfundbet` VALUES ('11093', '20210308029', '10000075', 'Vincent', '00000006276', '2021030802940190', '1615195966');
INSERT INTO `crowdfundbet` VALUES ('11094', '20210308029', '10000038', 'laraine', '00000005543', '2021030802945733', '1615196026');
INSERT INTO `crowdfundbet` VALUES ('11095', '20210308029', '10000021', 'angelina', '00000006310', '2021030802952043', '1615196086');
INSERT INTO `crowdfundbet` VALUES ('11096', '20210308029', '10000170', 'महंत', '00000000346', '2021030802952389', '1615196206');
INSERT INTO `crowdfundbet` VALUES ('11097', '20210308029', '10000136', 'Joyce', '00000000860', '2021030802953249', '1615196266');
INSERT INTO `crowdfundbet` VALUES ('11098', '20210308029', '10000118', 'Ben', '00000001570', '2021030802954819', '1615196326');
INSERT INTO `crowdfundbet` VALUES ('11099', '20210308029', '10000082', 'Promise ', '00000002232', '2021030802957051', '1615196386');
INSERT INTO `crowdfundbet` VALUES ('11100', '20210308029', '10000063', 'sade', '00000005761', '2021030802962812', '1615196446');
INSERT INTO `crowdfundbet` VALUES ('11101', '20210308029', '10000027', 'fiona', '00000005003', '2021030802967815', '1615196506');
INSERT INTO `crowdfundbet` VALUES ('11102', '20210308029', '10000008', 'claudia', '00000004968', '2021030802972783', '1615196566');
INSERT INTO `crowdfundbet` VALUES ('11103', '20210308029', '10000176', 'नवदविप', '00000000440', '2021030802973223', '1615196626');

-- ----------------------------
-- Table structure for freeze
-- ----------------------------
DROP TABLE IF EXISTS `freeze`;
CREATE TABLE `freeze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `orderId` int(11) NOT NULL DEFAULT '0',
  `coin` int(11) NOT NULL DEFAULT '0',
  `orderType` int(11) NOT NULL DEFAULT '0',
  `time` bigint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `orderId` (`orderId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of freeze
-- ----------------------------

-- ----------------------------
-- Table structure for gamerec
-- ----------------------------
DROP TABLE IF EXISTS `gamerec`;
CREATE TABLE `gamerec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recordCode` varchar(255) NOT NULL DEFAULT '' COMMENT '对局码',
  `gameId` int(11) NOT NULL DEFAULT '0',
  `gameResult` varchar(255) NOT NULL DEFAULT '',
  `beginTime` bigint(1) NOT NULL DEFAULT '0',
  `endTime` bigint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `recordCode` (`recordCode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='游戏对局记录';

-- ----------------------------
-- Records of gamerec
-- ----------------------------

-- ----------------------------
-- Table structure for gameuser
-- ----------------------------
DROP TABLE IF EXISTS `gameuser`;
CREATE TABLE `gameuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc` varchar(255) NOT NULL DEFAULT '',
  `pwd` varchar(255) NOT NULL,
  `plat` int(11) NOT NULL DEFAULT '0',
  `phone` varchar(255) NOT NULL DEFAULT '',
  `nick` varchar(255) NOT NULL DEFAULT '',
  `sex` int(11) NOT NULL DEFAULT '0',
  `photo` varchar(255) NOT NULL DEFAULT '',
  `freezed` int(11) NOT NULL,
  `isTourist` int(11) NOT NULL,
  `isLeader` int(11) NOT NULL,
  `coin` int(11) NOT NULL DEFAULT '0',
  `agentId` int(11) NOT NULL,
  `presenterId` int(11) NOT NULL,
  `regTime` bigint(11) NOT NULL DEFAULT '0',
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `acc` (`acc`,`plat`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of gameuser
-- ----------------------------
INSERT INTO `gameuser` VALUES ('1', '8895532476', '123456', '0', '8895532476', 'NehaSingh', '1', '', '0', '1', '0', '10000', '8', '0', '1615116833', '0');
INSERT INTO `gameuser` VALUES ('2', '7381001426', '123456', '0', '7381001426', 'Tina', '1', '', '0', '1', '0', '0', '8', '0', '1615116833', '76');
INSERT INTO `gameuser` VALUES ('3', '8480836252', '123456', '0', '8480836252', 'gains', '1', '', '0', '1', '0', '4160', '8', '0', '1615116879', '160');
INSERT INTO `gameuser` VALUES ('4', '8895495461', '123456', '0', '8895495461', 'NehaSingh', '0', '', '0', '1', '0', '890', '8', '0', '1615116931', '5');
INSERT INTO `gameuser` VALUES ('5', '8895536356', 'wangyi198', '0', '8895536356', 'tuned', '1', '', '0', '1', '0', '470', '169', '0', '1615117029', '36');
INSERT INTO `gameuser` VALUES ('6', '8480835373', '123456', '0', '8480835373', 'Aaron', '1', '', '0', '1', '0', '5660', '8', '0', '1615117088', '28');
INSERT INTO `gameuser` VALUES ('7', '8480835083', '123456', '0', '8480835083', 'crystal', '1', '', '0', '1', '0', '9350', '8', '0', '1615117128', '12');
INSERT INTO `gameuser` VALUES ('8', '8790071999', '123456', '0', '8790071999', '555', '1', '', '0', '1', '0', '91811', '171', '0', '1615120481', '161');
INSERT INTO `gameuser` VALUES ('9', '8790072000', '123456', '0', '8790072000', 'daxiong', '1', '', '0', '1', '0', '10000', '171', '0', '1615127024', '0');
INSERT INTO `gameuser` VALUES ('10', '8790072034', '123456', '0', '8790072034', 'daxiong', '1', '', '0', '1', '0', '913768', '171', '0', '1615127447', '293');
INSERT INTO `gameuser` VALUES ('11', '7366978877', '123456', '0', '7366978877', 'Mozi2019', '1', '', '0', '1', '0', '4190', '8', '0', '1615128573', '37');
INSERT INTO `gameuser` VALUES ('12', '7133002598', '121314', '0', '7133002598', 'ssjj', '1', '', '0', '1', '0', '1398', '8', '0', '1615129017', '44');
INSERT INTO `gameuser` VALUES ('13', '9988999889', '123456', '0', '9988999889', 'nike', '1', '', '0', '1', '0', '10000', '8', '0', '1615129854', '0');
INSERT INTO `gameuser` VALUES ('14', '7983447310', 'ning061917', '0', '7983447310', 'lzknw', '1', '', '0', '1', '0', '2270', '8', '0', '1615169080', '36');
INSERT INTO `gameuser` VALUES ('15', '8765567800', '123456', '0', '8765567800', 'ricky', '1', '', '0', '1', '0', '10000', '8', '0', '1615176148', '0');
INSERT INTO `gameuser` VALUES ('16', '9123644789', '123456', '0', '9123644789', 'wu', '0', '', '0', '1', '0', '10000', '8', '0', '1615176820', '0');
INSERT INTO `gameuser` VALUES ('17', '7893653563', 'qwe55555', '0', '7893653563', 'Anil', '1', '', '0', '1', '0', '10000', '8', '0', '1615176929', '0');
INSERT INTO `gameuser` VALUES ('18', '8765567811', '123456', '0', '8765567811', 'Anil', '1', '', '0', '1', '0', '10000', '8', '0', '1615177072', '0');
INSERT INTO `gameuser` VALUES ('19', '8765567812', '123456', '0', '8765567812', 'jie', '1', '', '0', '1', '0', '10000', '8', '0', '1615177199', '0');
INSERT INTO `gameuser` VALUES ('20', '7986562362', '123456', '0', '7986562362', 'Knil', '1', '', '0', '1', '0', '10000', '8', '0', '1615177787', '0');
INSERT INTO `gameuser` VALUES ('21', '8765567813', '123456', '0', '8765567813', 'jier', '1', '', '0', '1', '0', '10000', '8', '0', '1615178128', '0');
INSERT INTO `gameuser` VALUES ('22', '7082811509', '0914qwer', '0', '7082811509', '欧阳', '1', '', '0', '1', '0', '275', '8', '0', '1615183530', '62');
INSERT INTO `gameuser` VALUES ('23', '8765567814', '123456', '0', '8765567814', 'jj', '1', '', '0', '1', '0', '10', '8', '0', '1615183948', '39');
INSERT INTO `gameuser` VALUES ('24', '8337951687', 'wanlu736353.', '0', '8337951687', 'anna', '1', '', '0', '1', '0', '3900', '169', '0', '1615184492', '36');
INSERT INTO `gameuser` VALUES ('25', '8527820668', '123456', '0', '8527820668', '东哥', '1', '', '0', '1', '0', '10000', '8', '0', '1615189947', '0');
INSERT INTO `gameuser` VALUES ('26', '7892535467', '7891234567', '0', '7892535467', '7891234567', '1', '', '0', '1', '0', '10000', '171', '0', '1615193433', '0');
INSERT INTO `gameuser` VALUES ('27', '8976456321', '987101', '0', '8976456321', '888', '1', '', '0', '1', '0', '10000', '171', '0', '1615196484', '0');

-- ----------------------------
-- Table structure for mineralbills
-- ----------------------------
DROP TABLE IF EXISTS `mineralbills`;
CREATE TABLE `mineralbills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `nick` varchar(255) NOT NULL DEFAULT '',
  `mineral` int(11) NOT NULL DEFAULT '0',
  `cost` int(11) NOT NULL DEFAULT '0',
  `freeze` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  `tagId` int(11) NOT NULL DEFAULT '0',
  `reason` varchar(255) NOT NULL DEFAULT '',
  `time` bigint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='矿石账单';

-- ----------------------------
-- Records of mineralbills
-- ----------------------------

-- ----------------------------
-- Table structure for mineralcode
-- ----------------------------
DROP TABLE IF EXISTS `mineralcode`;
CREATE TABLE `mineralcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeNo` varchar(255) NOT NULL DEFAULT '',
  `mineral` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0 :有效/1：已用/2:废弃',
  `codeDesc` varchar(255) NOT NULL DEFAULT '' COMMENT '矿石码描述',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '矿石码商品类型 0：腕力球',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '消费者id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `codeNo` (`codeNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='矿石卡用于冲矿';

-- ----------------------------
-- Records of mineralcode
-- ----------------------------

-- ----------------------------
-- Table structure for rbball
-- ----------------------------
DROP TABLE IF EXISTS `rbball`;
CREATE TABLE `rbball` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue` bigint(11) NOT NULL,
  `lotteryResult` varchar(255) DEFAULT NULL,
  `lotteryPool` int(11) NOT NULL,
  `lotteryPrice` int(11) NOT NULL,
  `time` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `issue` (`issue`)
) ENGINE=InnoDB AUTO_INCREMENT=5636 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rbball
-- ----------------------------
INSERT INTO `rbball` VALUES ('5175', '20210307340', '7', '0', '0', '1615116600');
INSERT INTO `rbball` VALUES ('5176', '20210307341', '0', '0', '0', '1615116780');
INSERT INTO `rbball` VALUES ('5177', '20210307342', '8', '0', '0', '1615116960');
INSERT INTO `rbball` VALUES ('5178', '20210307343', '9', '0', '0', '1615117140');
INSERT INTO `rbball` VALUES ('5179', '20210307344', '9', '0', '0', '1615117320');
INSERT INTO `rbball` VALUES ('5180', '20210307345', '0', '0', '0', '1615117500');
INSERT INTO `rbball` VALUES ('5181', '20210307346', '2', '0', '0', '1615117680');
INSERT INTO `rbball` VALUES ('5182', '20210307347', '0', '0', '0', '1615117860');
INSERT INTO `rbball` VALUES ('5183', '20210307348', '9', '0', '0', '1615118040');
INSERT INTO `rbball` VALUES ('5184', '20210307349', '4', '0', '0', '1615118220');
INSERT INTO `rbball` VALUES ('5185', '20210307350', '8', '0', '0', '1615118400');
INSERT INTO `rbball` VALUES ('5186', '20210307351', '1', '0', '0', '1615118580');
INSERT INTO `rbball` VALUES ('5187', '20210307352', '9', '0', '0', '1615118760');
INSERT INTO `rbball` VALUES ('5188', '20210307353', '9', '0', '0', '1615118940');
INSERT INTO `rbball` VALUES ('5189', '20210307354', '3', '0', '0', '1615119120');
INSERT INTO `rbball` VALUES ('5190', '20210307355', '9', '0', '0', '1615119300');
INSERT INTO `rbball` VALUES ('5191', '20210307356', '1', '0', '0', '1615119480');
INSERT INTO `rbball` VALUES ('5192', '20210307357', '1', '0', '0', '1615119660');
INSERT INTO `rbball` VALUES ('5193', '20210307358', '2', '0', '0', '1615119840');
INSERT INTO `rbball` VALUES ('5194', '20210307359', '3', '0', '0', '1615120020');
INSERT INTO `rbball` VALUES ('5195', '20210307360', '0', '0', '0', '1615120200');
INSERT INTO `rbball` VALUES ('5196', '20210307361', '2', '0', '0', '1615120380');
INSERT INTO `rbball` VALUES ('5197', '20210307362', '7', '0', '0', '1615120560');
INSERT INTO `rbball` VALUES ('5198', '20210307363', '2', '0', '0', '1615120740');
INSERT INTO `rbball` VALUES ('5199', '20210307364', '0', '0', '0', '1615120920');
INSERT INTO `rbball` VALUES ('5200', '20210307365', '0', '0', '0', '1615121100');
INSERT INTO `rbball` VALUES ('5201', '20210307366', '0', '0', '0', '1615121280');
INSERT INTO `rbball` VALUES ('5202', '20210307367', '5', '0', '0', '1615121460');
INSERT INTO `rbball` VALUES ('5203', '20210307368', '1', '0', '0', '1615121640');
INSERT INTO `rbball` VALUES ('5204', '20210307369', '2', '0', '0', '1615121820');
INSERT INTO `rbball` VALUES ('5205', '20210307370', '0', '0', '0', '1615122000');
INSERT INTO `rbball` VALUES ('5206', '20210307371', '8', '0', '0', '1615122180');
INSERT INTO `rbball` VALUES ('5207', '20210307372', '0', '0', '0', '1615122360');
INSERT INTO `rbball` VALUES ('5208', '20210307373', '8', '0', '0', '1615122540');
INSERT INTO `rbball` VALUES ('5209', '20210307374', '3', '0', '0', '1615122720');
INSERT INTO `rbball` VALUES ('5210', '20210307375', '0', '0', '0', '1615122900');
INSERT INTO `rbball` VALUES ('5211', '20210307376', '2', '0', '0', '1615123080');
INSERT INTO `rbball` VALUES ('5212', '20210307377', '7', '0', '0', '1615123260');
INSERT INTO `rbball` VALUES ('5213', '20210307378', '7', '0', '0', '1615123440');
INSERT INTO `rbball` VALUES ('5214', '20210307379', '5', '0', '0', '1615123620');
INSERT INTO `rbball` VALUES ('5215', '20210307380', '6', '0', '0', '1615123800');
INSERT INTO `rbball` VALUES ('5216', '20210307381', '5', '0', '0', '1615123980');
INSERT INTO `rbball` VALUES ('5217', '20210307382', '2', '0', '0', '1615124160');
INSERT INTO `rbball` VALUES ('5218', '20210307383', '4', '0', '0', '1615124340');
INSERT INTO `rbball` VALUES ('5219', '20210307384', '4', '0', '0', '1615124520');
INSERT INTO `rbball` VALUES ('5220', '20210307385', '9', '0', '0', '1615124700');
INSERT INTO `rbball` VALUES ('5221', '20210307386', '6', '0', '0', '1615124880');
INSERT INTO `rbball` VALUES ('5222', '20210307387', '9', '0', '0', '1615125060');
INSERT INTO `rbball` VALUES ('5223', '20210307388', '6', '0', '0', '1615125240');
INSERT INTO `rbball` VALUES ('5224', '20210307389', '0', '0', '0', '1615125420');
INSERT INTO `rbball` VALUES ('5225', '20210307390', '6', '0', '0', '1615125600');
INSERT INTO `rbball` VALUES ('5226', '20210307391', '5', '0', '0', '1615125780');
INSERT INTO `rbball` VALUES ('5227', '20210307392', '7', '0', '0', '1615125960');
INSERT INTO `rbball` VALUES ('5228', '20210307393', '0', '0', '0', '1615126140');
INSERT INTO `rbball` VALUES ('5229', '20210307394', '4', '0', '0', '1615126320');
INSERT INTO `rbball` VALUES ('5230', '20210307395', '6', '0', '0', '1615126500');
INSERT INTO `rbball` VALUES ('5231', '20210307396', '1', '0', '0', '1615126680');
INSERT INTO `rbball` VALUES ('5232', '20210307397', '5', '0', '0', '1615126860');
INSERT INTO `rbball` VALUES ('5233', '20210307398', '8', '0', '0', '1615127040');
INSERT INTO `rbball` VALUES ('5234', '20210307399', '6', '0', '0', '1615127220');
INSERT INTO `rbball` VALUES ('5235', '20210307400', '0', '0', '0', '1615127400');
INSERT INTO `rbball` VALUES ('5236', '20210307401', '0', '0', '0', '1615127580');
INSERT INTO `rbball` VALUES ('5237', '20210307402', '9', '0', '0', '1615127760');
INSERT INTO `rbball` VALUES ('5238', '20210307403', '7', '0', '0', '1615127940');
INSERT INTO `rbball` VALUES ('5239', '20210307404', '0', '0', '0', '1615128120');
INSERT INTO `rbball` VALUES ('5240', '20210307405', '7', '0', '0', '1615128300');
INSERT INTO `rbball` VALUES ('5241', '20210307406', '5', '0', '0', '1615128480');
INSERT INTO `rbball` VALUES ('5242', '20210307407', '8', '0', '0', '1615128660');
INSERT INTO `rbball` VALUES ('5243', '20210307408', '9', '0', '0', '1615128840');
INSERT INTO `rbball` VALUES ('5244', '20210307409', '3', '0', '0', '1615129020');
INSERT INTO `rbball` VALUES ('5245', '20210307410', '3', '0', '0', '1615129200');
INSERT INTO `rbball` VALUES ('5246', '20210307411', '0', '0', '0', '1615129380');
INSERT INTO `rbball` VALUES ('5247', '20210307412', '0', '0', '0', '1615129560');
INSERT INTO `rbball` VALUES ('5248', '20210307413', '1', '0', '0', '1615129740');
INSERT INTO `rbball` VALUES ('5249', '20210307414', '0', '0', '0', '1615129920');
INSERT INTO `rbball` VALUES ('5250', '20210307415', '6', '0', '0', '1615130100');
INSERT INTO `rbball` VALUES ('5251', '20210307416', '8', '0', '0', '1615130280');
INSERT INTO `rbball` VALUES ('5252', '20210307417', '2', '0', '0', '1615130460');
INSERT INTO `rbball` VALUES ('5253', '20210307418', '8', '0', '0', '1615130640');
INSERT INTO `rbball` VALUES ('5254', '20210307419', '7', '0', '0', '1615130820');
INSERT INTO `rbball` VALUES ('5255', '20210307420', '4', '0', '0', '1615131000');
INSERT INTO `rbball` VALUES ('5256', '20210307421', '7', '0', '0', '1615131180');
INSERT INTO `rbball` VALUES ('5257', '20210307422', '4', '0', '0', '1615131360');
INSERT INTO `rbball` VALUES ('5258', '20210307423', '5', '0', '0', '1615131540');
INSERT INTO `rbball` VALUES ('5259', '20210307424', '2', '0', '0', '1615131720');
INSERT INTO `rbball` VALUES ('5260', '20210307425', '6', '0', '0', '1615131900');
INSERT INTO `rbball` VALUES ('5261', '20210307426', '7', '0', '0', '1615132080');
INSERT INTO `rbball` VALUES ('5262', '20210307427', '2', '0', '0', '1615132260');
INSERT INTO `rbball` VALUES ('5263', '20210307428', '5', '0', '0', '1615132440');
INSERT INTO `rbball` VALUES ('5264', '20210307429', '0', '0', '0', '1615132620');
INSERT INTO `rbball` VALUES ('5265', '20210307430', '1', '0', '0', '1615132800');
INSERT INTO `rbball` VALUES ('5266', '20210307431', '0', '0', '0', '1615132980');
INSERT INTO `rbball` VALUES ('5267', '20210307432', '5', '0', '0', '1615133160');
INSERT INTO `rbball` VALUES ('5268', '20210307433', '8', '0', '0', '1615133340');
INSERT INTO `rbball` VALUES ('5269', '20210307434', '8', '0', '0', '1615133520');
INSERT INTO `rbball` VALUES ('5270', '20210307435', '7', '0', '0', '1615133700');
INSERT INTO `rbball` VALUES ('5271', '20210307436', '6', '0', '0', '1615133880');
INSERT INTO `rbball` VALUES ('5272', '20210307437', '3', '0', '0', '1615134060');
INSERT INTO `rbball` VALUES ('5273', '20210307438', '0', '0', '0', '1615134240');
INSERT INTO `rbball` VALUES ('5274', '20210307439', '7', '0', '0', '1615134420');
INSERT INTO `rbball` VALUES ('5275', '20210307440', '8', '0', '0', '1615134600');
INSERT INTO `rbball` VALUES ('5276', '20210307441', '3', '0', '0', '1615134780');
INSERT INTO `rbball` VALUES ('5277', '20210307442', '9', '0', '0', '1615134960');
INSERT INTO `rbball` VALUES ('5278', '20210307443', '4', '0', '0', '1615135140');
INSERT INTO `rbball` VALUES ('5279', '20210307444', '2', '0', '0', '1615135320');
INSERT INTO `rbball` VALUES ('5280', '20210307445', '2', '0', '0', '1615135500');
INSERT INTO `rbball` VALUES ('5281', '20210307446', null, '0', '0', '1615135680');
INSERT INTO `rbball` VALUES ('5282', '20210307447', '7', '0', '0', '1615135860');
INSERT INTO `rbball` VALUES ('5283', '20210307448', '1', '0', '0', '1615136040');
INSERT INTO `rbball` VALUES ('5284', '20210307449', '1', '0', '0', '1615136220');
INSERT INTO `rbball` VALUES ('5285', '20210307450', '2', '0', '0', '1615136400');
INSERT INTO `rbball` VALUES ('5286', '20210307451', '0', '0', '0', '1615136580');
INSERT INTO `rbball` VALUES ('5287', '20210307452', '8', '0', '0', '1615136760');
INSERT INTO `rbball` VALUES ('5288', '20210307453', '5', '0', '0', '1615136940');
INSERT INTO `rbball` VALUES ('5289', '20210307454', '1', '0', '0', '1615137120');
INSERT INTO `rbball` VALUES ('5290', '20210307455', '1', '0', '0', '1615137300');
INSERT INTO `rbball` VALUES ('5291', '20210307456', '8', '0', '0', '1615137480');
INSERT INTO `rbball` VALUES ('5292', '20210307457', '5', '0', '0', '1615137660');
INSERT INTO `rbball` VALUES ('5293', '20210307458', '5', '0', '0', '1615137840');
INSERT INTO `rbball` VALUES ('5294', '20210307459', '0', '0', '0', '1615138020');
INSERT INTO `rbball` VALUES ('5295', '20210307460', '8', '0', '0', '1615138200');
INSERT INTO `rbball` VALUES ('5296', '20210307461', '6', '0', '0', '1615138380');
INSERT INTO `rbball` VALUES ('5297', '20210307462', '9', '0', '0', '1615138560');
INSERT INTO `rbball` VALUES ('5298', '20210307463', '4', '0', '0', '1615138740');
INSERT INTO `rbball` VALUES ('5299', '20210307464', '4', '0', '0', '1615138920');
INSERT INTO `rbball` VALUES ('5300', '20210307465', '8', '0', '0', '1615139100');
INSERT INTO `rbball` VALUES ('5301', '20210307466', '4', '0', '0', '1615139280');
INSERT INTO `rbball` VALUES ('5302', '20210307467', '9', '0', '0', '1615139460');
INSERT INTO `rbball` VALUES ('5303', '20210307468', '0', '0', '0', '1615139640');
INSERT INTO `rbball` VALUES ('5304', '20210307469', '1', '0', '0', '1615139820');
INSERT INTO `rbball` VALUES ('5305', '20210307470', '2', '0', '0', '1615140000');
INSERT INTO `rbball` VALUES ('5306', '20210307471', '5', '0', '0', '1615140180');
INSERT INTO `rbball` VALUES ('5307', '20210307472', '5', '0', '0', '1615140360');
INSERT INTO `rbball` VALUES ('5308', '20210307473', '7', '0', '0', '1615140540');
INSERT INTO `rbball` VALUES ('5309', '20210307474', '5', '0', '0', '1615140720');
INSERT INTO `rbball` VALUES ('5310', '20210307475', '3', '0', '0', '1615140900');
INSERT INTO `rbball` VALUES ('5311', '20210307476', '3', '0', '0', '1615141080');
INSERT INTO `rbball` VALUES ('5312', '20210307477', '2', '0', '0', '1615141260');
INSERT INTO `rbball` VALUES ('5313', '20210307478', '1', '0', '0', '1615141440');
INSERT INTO `rbball` VALUES ('5314', '20210307479', '9', '0', '0', '1615141620');
INSERT INTO `rbball` VALUES ('5315', '20210308000', '9', '0', '0', '1615141800');
INSERT INTO `rbball` VALUES ('5316', '20210308001', '7', '0', '0', '1615141980');
INSERT INTO `rbball` VALUES ('5317', '20210308002', '8', '0', '0', '1615142160');
INSERT INTO `rbball` VALUES ('5318', '20210308003', '0', '0', '0', '1615142340');
INSERT INTO `rbball` VALUES ('5319', '20210308004', '0', '0', '0', '1615142520');
INSERT INTO `rbball` VALUES ('5320', '20210308005', '7', '0', '0', '1615142700');
INSERT INTO `rbball` VALUES ('5321', '20210308006', '7', '0', '0', '1615142880');
INSERT INTO `rbball` VALUES ('5322', '20210308007', '6', '0', '0', '1615143060');
INSERT INTO `rbball` VALUES ('5323', '20210308008', '0', '0', '0', '1615143240');
INSERT INTO `rbball` VALUES ('5324', '20210308009', '4', '0', '0', '1615143420');
INSERT INTO `rbball` VALUES ('5325', '20210308010', '7', '0', '0', '1615143600');
INSERT INTO `rbball` VALUES ('5326', '20210308011', '1', '0', '0', '1615143780');
INSERT INTO `rbball` VALUES ('5327', '20210308012', '2', '0', '0', '1615143960');
INSERT INTO `rbball` VALUES ('5328', '20210308013', '5', '0', '0', '1615144140');
INSERT INTO `rbball` VALUES ('5329', '20210308014', '4', '0', '0', '1615144320');
INSERT INTO `rbball` VALUES ('5330', '20210308015', '0', '0', '0', '1615144500');
INSERT INTO `rbball` VALUES ('5331', '20210308016', '6', '0', '0', '1615144680');
INSERT INTO `rbball` VALUES ('5332', '20210308017', '9', '0', '0', '1615144860');
INSERT INTO `rbball` VALUES ('5333', '20210308018', '1', '0', '0', '1615145040');
INSERT INTO `rbball` VALUES ('5334', '20210308019', '2', '0', '0', '1615145220');
INSERT INTO `rbball` VALUES ('5335', '20210308020', '8', '0', '0', '1615145400');
INSERT INTO `rbball` VALUES ('5336', '20210308021', '5', '0', '0', '1615145580');
INSERT INTO `rbball` VALUES ('5337', '20210308022', '3', '0', '0', '1615145760');
INSERT INTO `rbball` VALUES ('5338', '20210308023', '5', '0', '0', '1615145940');
INSERT INTO `rbball` VALUES ('5339', '20210308024', '8', '0', '0', '1615146120');
INSERT INTO `rbball` VALUES ('5340', '20210308025', '0', '0', '0', '1615146300');
INSERT INTO `rbball` VALUES ('5341', '20210308026', '5', '0', '0', '1615146480');
INSERT INTO `rbball` VALUES ('5342', '20210308027', '4', '0', '0', '1615146660');
INSERT INTO `rbball` VALUES ('5343', '20210308028', '7', '0', '0', '1615146840');
INSERT INTO `rbball` VALUES ('5344', '20210308029', '0', '0', '0', '1615147020');
INSERT INTO `rbball` VALUES ('5345', '20210308030', '5', '0', '0', '1615147200');
INSERT INTO `rbball` VALUES ('5346', '20210308031', '2', '0', '0', '1615147380');
INSERT INTO `rbball` VALUES ('5347', '20210308032', '5', '0', '0', '1615147560');
INSERT INTO `rbball` VALUES ('5348', '20210308033', '2', '0', '0', '1615147740');
INSERT INTO `rbball` VALUES ('5349', '20210308034', '3', '0', '0', '1615147920');
INSERT INTO `rbball` VALUES ('5350', '20210308035', '4', '0', '0', '1615148100');
INSERT INTO `rbball` VALUES ('5351', '20210308036', '7', '0', '0', '1615148280');
INSERT INTO `rbball` VALUES ('5352', '20210308037', '9', '0', '0', '1615148460');
INSERT INTO `rbball` VALUES ('5353', '20210308038', '7', '0', '0', '1615148640');
INSERT INTO `rbball` VALUES ('5354', '20210308039', '5', '0', '0', '1615148820');
INSERT INTO `rbball` VALUES ('5355', '20210308040', '7', '0', '0', '1615149000');
INSERT INTO `rbball` VALUES ('5356', '20210308041', '4', '0', '0', '1615149180');
INSERT INTO `rbball` VALUES ('5357', '20210308042', '2', '0', '0', '1615149360');
INSERT INTO `rbball` VALUES ('5358', '20210308043', '3', '0', '0', '1615149540');
INSERT INTO `rbball` VALUES ('5359', '20210308044', '0', '0', '0', '1615149720');
INSERT INTO `rbball` VALUES ('5360', '20210308045', '1', '0', '0', '1615149900');
INSERT INTO `rbball` VALUES ('5361', '20210308046', '5', '0', '0', '1615150080');
INSERT INTO `rbball` VALUES ('5362', '20210308047', '7', '0', '0', '1615150260');
INSERT INTO `rbball` VALUES ('5363', '20210308048', '0', '0', '0', '1615150440');
INSERT INTO `rbball` VALUES ('5364', '20210308049', '6', '0', '0', '1615150620');
INSERT INTO `rbball` VALUES ('5365', '20210308050', '3', '0', '0', '1615150800');
INSERT INTO `rbball` VALUES ('5366', '20210308051', '5', '0', '0', '1615150980');
INSERT INTO `rbball` VALUES ('5367', '20210308052', '8', '0', '0', '1615151160');
INSERT INTO `rbball` VALUES ('5368', '20210308053', '0', '0', '0', '1615151340');
INSERT INTO `rbball` VALUES ('5369', '20210308054', '4', '0', '0', '1615151520');
INSERT INTO `rbball` VALUES ('5370', '20210308055', '9', '0', '0', '1615151700');
INSERT INTO `rbball` VALUES ('5371', '20210308056', '6', '0', '0', '1615151880');
INSERT INTO `rbball` VALUES ('5372', '20210308057', '1', '0', '0', '1615152060');
INSERT INTO `rbball` VALUES ('5373', '20210308058', '3', '0', '0', '1615152240');
INSERT INTO `rbball` VALUES ('5374', '20210308059', '6', '0', '0', '1615152420');
INSERT INTO `rbball` VALUES ('5375', '20210308060', '6', '0', '0', '1615152600');
INSERT INTO `rbball` VALUES ('5376', '20210308061', '4', '0', '0', '1615152780');
INSERT INTO `rbball` VALUES ('5377', '20210308062', '1', '0', '0', '1615152960');
INSERT INTO `rbball` VALUES ('5378', '20210308063', '9', '0', '0', '1615153140');
INSERT INTO `rbball` VALUES ('5379', '20210308064', '8', '0', '0', '1615153320');
INSERT INTO `rbball` VALUES ('5380', '20210308065', '1', '0', '0', '1615153500');
INSERT INTO `rbball` VALUES ('5381', '20210308066', '0', '0', '0', '1615153680');
INSERT INTO `rbball` VALUES ('5382', '20210308067', '4', '0', '0', '1615153860');
INSERT INTO `rbball` VALUES ('5383', '20210308068', '8', '0', '0', '1615154040');
INSERT INTO `rbball` VALUES ('5384', '20210308069', '6', '0', '0', '1615154220');
INSERT INTO `rbball` VALUES ('5385', '20210308070', '5', '0', '0', '1615154400');
INSERT INTO `rbball` VALUES ('5386', '20210308071', '6', '0', '0', '1615154580');
INSERT INTO `rbball` VALUES ('5387', '20210308072', '0', '0', '0', '1615154760');
INSERT INTO `rbball` VALUES ('5388', '20210308073', '8', '0', '0', '1615154940');
INSERT INTO `rbball` VALUES ('5389', '20210308074', '2', '0', '0', '1615155120');
INSERT INTO `rbball` VALUES ('5390', '20210308075', '6', '0', '0', '1615155300');
INSERT INTO `rbball` VALUES ('5391', '20210308076', '9', '0', '0', '1615155480');
INSERT INTO `rbball` VALUES ('5392', '20210308077', '0', '0', '0', '1615155660');
INSERT INTO `rbball` VALUES ('5393', '20210308078', '1', '0', '0', '1615155840');
INSERT INTO `rbball` VALUES ('5394', '20210308079', '8', '0', '0', '1615156020');
INSERT INTO `rbball` VALUES ('5395', '20210308080', '3', '0', '0', '1615156200');
INSERT INTO `rbball` VALUES ('5396', '20210308081', '4', '0', '0', '1615156380');
INSERT INTO `rbball` VALUES ('5397', '20210308082', '9', '0', '0', '1615156560');
INSERT INTO `rbball` VALUES ('5398', '20210308083', '1', '0', '0', '1615156740');
INSERT INTO `rbball` VALUES ('5399', '20210308084', '0', '0', '0', '1615156920');
INSERT INTO `rbball` VALUES ('5400', '20210308085', '2', '0', '0', '1615157100');
INSERT INTO `rbball` VALUES ('5401', '20210308086', '4', '0', '0', '1615157280');
INSERT INTO `rbball` VALUES ('5402', '20210308087', '2', '0', '0', '1615157460');
INSERT INTO `rbball` VALUES ('5403', '20210308088', '1', '0', '0', '1615157640');
INSERT INTO `rbball` VALUES ('5404', '20210308089', '9', '0', '0', '1615157820');
INSERT INTO `rbball` VALUES ('5405', '20210308090', '9', '0', '0', '1615158000');
INSERT INTO `rbball` VALUES ('5406', '20210308091', '8', '0', '0', '1615158180');
INSERT INTO `rbball` VALUES ('5407', '20210308092', '9', '0', '0', '1615158360');
INSERT INTO `rbball` VALUES ('5408', '20210308093', '3', '0', '0', '1615158540');
INSERT INTO `rbball` VALUES ('5409', '20210308094', '1', '0', '0', '1615158720');
INSERT INTO `rbball` VALUES ('5410', '20210308095', '3', '0', '0', '1615158900');
INSERT INTO `rbball` VALUES ('5411', '20210308096', '4', '0', '0', '1615159080');
INSERT INTO `rbball` VALUES ('5412', '20210308097', '2', '0', '0', '1615159260');
INSERT INTO `rbball` VALUES ('5413', '20210308098', '6', '0', '0', '1615159440');
INSERT INTO `rbball` VALUES ('5414', '20210308099', '7', '0', '0', '1615159620');
INSERT INTO `rbball` VALUES ('5415', '20210308100', '0', '0', '0', '1615159800');
INSERT INTO `rbball` VALUES ('5416', '20210308101', '0', '0', '0', '1615159980');
INSERT INTO `rbball` VALUES ('5417', '20210308102', '5', '0', '0', '1615160160');
INSERT INTO `rbball` VALUES ('5418', '20210308103', '6', '0', '0', '1615160340');
INSERT INTO `rbball` VALUES ('5419', '20210308104', '6', '0', '0', '1615160520');
INSERT INTO `rbball` VALUES ('5420', '20210308105', '5', '0', '0', '1615160700');
INSERT INTO `rbball` VALUES ('5421', '20210308106', '4', '0', '0', '1615160880');
INSERT INTO `rbball` VALUES ('5422', '20210308107', '6', '0', '0', '1615161060');
INSERT INTO `rbball` VALUES ('5423', '20210308108', '8', '0', '0', '1615161240');
INSERT INTO `rbball` VALUES ('5424', '20210308109', '9', '0', '0', '1615161420');
INSERT INTO `rbball` VALUES ('5425', '20210308110', '7', '0', '0', '1615161600');
INSERT INTO `rbball` VALUES ('5426', '20210308111', '9', '0', '0', '1615161780');
INSERT INTO `rbball` VALUES ('5427', '20210308112', '5', '0', '0', '1615161960');
INSERT INTO `rbball` VALUES ('5428', '20210308113', '4', '0', '0', '1615162140');
INSERT INTO `rbball` VALUES ('5429', '20210308114', '7', '0', '0', '1615162320');
INSERT INTO `rbball` VALUES ('5430', '20210308115', '9', '0', '0', '1615162500');
INSERT INTO `rbball` VALUES ('5431', '20210308116', '3', '0', '0', '1615162680');
INSERT INTO `rbball` VALUES ('5432', '20210308117', '4', '0', '0', '1615162860');
INSERT INTO `rbball` VALUES ('5433', '20210308118', '2', '0', '0', '1615163040');
INSERT INTO `rbball` VALUES ('5434', '20210308119', '3', '0', '0', '1615163220');
INSERT INTO `rbball` VALUES ('5435', '20210308120', '6', '0', '0', '1615163400');
INSERT INTO `rbball` VALUES ('5436', '20210308121', '9', '0', '0', '1615163580');
INSERT INTO `rbball` VALUES ('5437', '20210308122', '7', '0', '0', '1615163760');
INSERT INTO `rbball` VALUES ('5438', '20210308123', '8', '0', '0', '1615163940');
INSERT INTO `rbball` VALUES ('5439', '20210308124', '4', '0', '0', '1615164120');
INSERT INTO `rbball` VALUES ('5440', '20210308125', '4', '0', '0', '1615164300');
INSERT INTO `rbball` VALUES ('5441', '20210308126', '5', '0', '0', '1615164480');
INSERT INTO `rbball` VALUES ('5442', '20210308127', '6', '0', '0', '1615164660');
INSERT INTO `rbball` VALUES ('5443', '20210308128', '6', '0', '0', '1615164840');
INSERT INTO `rbball` VALUES ('5444', '20210308129', '5', '0', '0', '1615165020');
INSERT INTO `rbball` VALUES ('5445', '20210308130', '1', '0', '0', '1615165200');
INSERT INTO `rbball` VALUES ('5446', '20210308131', '5', '0', '0', '1615165380');
INSERT INTO `rbball` VALUES ('5447', '20210308132', '4', '0', '0', '1615165560');
INSERT INTO `rbball` VALUES ('5448', '20210308133', '2', '0', '0', '1615165740');
INSERT INTO `rbball` VALUES ('5449', '20210308134', '6', '0', '0', '1615165920');
INSERT INTO `rbball` VALUES ('5450', '20210308135', '2', '0', '0', '1615166100');
INSERT INTO `rbball` VALUES ('5451', '20210308136', '0', '0', '0', '1615166280');
INSERT INTO `rbball` VALUES ('5452', '20210308137', '8', '0', '0', '1615166460');
INSERT INTO `rbball` VALUES ('5453', '20210308138', '8', '0', '0', '1615166640');
INSERT INTO `rbball` VALUES ('5454', '20210308139', '9', '0', '0', '1615166820');
INSERT INTO `rbball` VALUES ('5455', '20210308140', '5', '0', '0', '1615167000');
INSERT INTO `rbball` VALUES ('5456', '20210308141', '2', '0', '0', '1615167180');
INSERT INTO `rbball` VALUES ('5457', '20210308142', '5', '0', '0', '1615167360');
INSERT INTO `rbball` VALUES ('5458', '20210308143', '5', '0', '0', '1615167540');
INSERT INTO `rbball` VALUES ('5459', '20210308144', '8', '0', '0', '1615167720');
INSERT INTO `rbball` VALUES ('5460', '20210308145', '8', '0', '0', '1615167900');
INSERT INTO `rbball` VALUES ('5461', '20210308146', '7', '0', '0', '1615168080');
INSERT INTO `rbball` VALUES ('5462', '20210308147', '5', '0', '0', '1615168260');
INSERT INTO `rbball` VALUES ('5463', '20210308148', '9', '0', '0', '1615168440');
INSERT INTO `rbball` VALUES ('5464', '20210308149', '7', '0', '0', '1615168620');
INSERT INTO `rbball` VALUES ('5465', '20210308150', '8', '0', '0', '1615168800');
INSERT INTO `rbball` VALUES ('5466', '20210308151', '1', '0', '0', '1615168980');
INSERT INTO `rbball` VALUES ('5467', '20210308152', '0', '0', '0', '1615169160');
INSERT INTO `rbball` VALUES ('5468', '20210308153', '2', '0', '0', '1615169340');
INSERT INTO `rbball` VALUES ('5469', '20210308154', '6', '0', '0', '1615169520');
INSERT INTO `rbball` VALUES ('5470', '20210308155', '6', '0', '0', '1615169700');
INSERT INTO `rbball` VALUES ('5471', '20210308156', '0', '0', '0', '1615169880');
INSERT INTO `rbball` VALUES ('5472', '20210308157', '5', '0', '0', '1615170060');
INSERT INTO `rbball` VALUES ('5473', '20210308158', '5', '0', '0', '1615170240');
INSERT INTO `rbball` VALUES ('5474', '20210308159', '6', '0', '0', '1615170420');
INSERT INTO `rbball` VALUES ('5475', '20210308160', '2', '0', '0', '1615170600');
INSERT INTO `rbball` VALUES ('5476', '20210308161', '3', '0', '0', '1615170780');
INSERT INTO `rbball` VALUES ('5477', '20210308162', '9', '0', '0', '1615170960');
INSERT INTO `rbball` VALUES ('5478', '20210308163', '5', '0', '0', '1615171140');
INSERT INTO `rbball` VALUES ('5479', '20210308164', '3', '0', '0', '1615171320');
INSERT INTO `rbball` VALUES ('5480', '20210308165', '1', '0', '0', '1615171500');
INSERT INTO `rbball` VALUES ('5481', '20210308166', '8', '0', '0', '1615171680');
INSERT INTO `rbball` VALUES ('5482', '20210308167', '6', '0', '0', '1615171860');
INSERT INTO `rbball` VALUES ('5483', '20210308168', '8', '0', '0', '1615172040');
INSERT INTO `rbball` VALUES ('5484', '20210308169', '3', '0', '0', '1615172220');
INSERT INTO `rbball` VALUES ('5485', '20210308170', '6', '0', '0', '1615172400');
INSERT INTO `rbball` VALUES ('5486', '20210308171', '3', '0', '0', '1615172580');
INSERT INTO `rbball` VALUES ('5487', '20210308172', '5', '0', '0', '1615172760');
INSERT INTO `rbball` VALUES ('5488', '20210308173', '0', '0', '0', '1615172940');
INSERT INTO `rbball` VALUES ('5489', '20210308174', '9', '0', '0', '1615173120');
INSERT INTO `rbball` VALUES ('5490', '20210308175', '7', '0', '0', '1615173300');
INSERT INTO `rbball` VALUES ('5491', '20210308176', '6', '0', '0', '1615173480');
INSERT INTO `rbball` VALUES ('5492', '20210308177', '5', '0', '0', '1615173660');
INSERT INTO `rbball` VALUES ('5493', '20210308178', '1', '0', '0', '1615173840');
INSERT INTO `rbball` VALUES ('5494', '20210308179', '9', '0', '0', '1615174020');
INSERT INTO `rbball` VALUES ('5495', '20210308180', '3', '0', '0', '1615174200');
INSERT INTO `rbball` VALUES ('5496', '20210308181', '3', '0', '0', '1615174380');
INSERT INTO `rbball` VALUES ('5497', '20210308182', '1', '0', '0', '1615174560');
INSERT INTO `rbball` VALUES ('5498', '20210308183', '3', '0', '0', '1615174740');
INSERT INTO `rbball` VALUES ('5499', '20210308184', '9', '0', '0', '1615174920');
INSERT INTO `rbball` VALUES ('5500', '20210308185', '2', '0', '0', '1615175100');
INSERT INTO `rbball` VALUES ('5501', '20210308186', '6', '0', '0', '1615175280');
INSERT INTO `rbball` VALUES ('5502', '20210308187', '4', '0', '0', '1615175460');
INSERT INTO `rbball` VALUES ('5503', '20210308188', '9', '0', '0', '1615175640');
INSERT INTO `rbball` VALUES ('5504', '20210308189', '2', '0', '0', '1615175820');
INSERT INTO `rbball` VALUES ('5505', '20210308190', '6', '0', '0', '1615176000');
INSERT INTO `rbball` VALUES ('5506', '20210308191', '9', '0', '0', '1615176180');
INSERT INTO `rbball` VALUES ('5507', '20210308192', '9', '0', '0', '1615176360');
INSERT INTO `rbball` VALUES ('5508', '20210308193', '8', '0', '0', '1615176540');
INSERT INTO `rbball` VALUES ('5509', '20210308194', '7', '0', '0', '1615176720');
INSERT INTO `rbball` VALUES ('5510', '20210308195', '4', '0', '0', '1615176900');
INSERT INTO `rbball` VALUES ('5511', '20210308196', '0', '0', '0', '1615177080');
INSERT INTO `rbball` VALUES ('5512', '20210308197', '8', '0', '0', '1615177260');
INSERT INTO `rbball` VALUES ('5513', '20210308198', '7', '0', '0', '1615177440');
INSERT INTO `rbball` VALUES ('5514', '20210308199', '6', '0', '0', '1615177620');
INSERT INTO `rbball` VALUES ('5515', '20210308200', '5', '0', '0', '1615177800');
INSERT INTO `rbball` VALUES ('5516', '20210308201', '6', '0', '0', '1615177980');
INSERT INTO `rbball` VALUES ('5517', '20210308202', '6', '0', '0', '1615178160');
INSERT INTO `rbball` VALUES ('5518', '20210308203', '2', '0', '0', '1615178340');
INSERT INTO `rbball` VALUES ('5519', '20210308204', '4', '0', '0', '1615178520');
INSERT INTO `rbball` VALUES ('5520', '20210308205', '0', '0', '0', '1615178700');
INSERT INTO `rbball` VALUES ('5521', '20210308206', '2', '0', '0', '1615178880');
INSERT INTO `rbball` VALUES ('5522', '20210308207', '5', '0', '0', '1615179060');
INSERT INTO `rbball` VALUES ('5523', '20210308208', '8', '0', '0', '1615179240');
INSERT INTO `rbball` VALUES ('5524', '20210308209', '1', '0', '0', '1615179420');
INSERT INTO `rbball` VALUES ('5525', '20210308210', '4', '0', '0', '1615179600');
INSERT INTO `rbball` VALUES ('5526', '20210308211', '7', '0', '0', '1615179780');
INSERT INTO `rbball` VALUES ('5527', '20210308212', '4', '0', '0', '1615179960');
INSERT INTO `rbball` VALUES ('5528', '20210308213', '8', '0', '0', '1615180140');
INSERT INTO `rbball` VALUES ('5529', '20210308214', '5', '0', '0', '1615180320');
INSERT INTO `rbball` VALUES ('5530', '20210308215', '8', '0', '0', '1615180500');
INSERT INTO `rbball` VALUES ('5531', '20210308216', '3', '0', '0', '1615180680');
INSERT INTO `rbball` VALUES ('5532', '20210308217', '1', '0', '0', '1615180860');
INSERT INTO `rbball` VALUES ('5533', '20210308218', '9', '0', '0', '1615181040');
INSERT INTO `rbball` VALUES ('5534', '20210308219', '9', '0', '0', '1615181220');
INSERT INTO `rbball` VALUES ('5535', '20210308220', '0', '0', '0', '1615181400');
INSERT INTO `rbball` VALUES ('5536', '20210308221', '0', '0', '0', '1615181580');
INSERT INTO `rbball` VALUES ('5537', '20210308222', '2', '0', '0', '1615181760');
INSERT INTO `rbball` VALUES ('5538', '20210308223', '0', '0', '0', '1615181940');
INSERT INTO `rbball` VALUES ('5539', '20210308224', '7', '0', '0', '1615182120');
INSERT INTO `rbball` VALUES ('5540', '20210308225', '5', '0', '0', '1615182300');
INSERT INTO `rbball` VALUES ('5541', '20210308226', '7', '0', '0', '1615182480');
INSERT INTO `rbball` VALUES ('5542', '20210308227', '4', '0', '0', '1615182660');
INSERT INTO `rbball` VALUES ('5543', '20210308228', '1', '0', '0', '1615182840');
INSERT INTO `rbball` VALUES ('5544', '20210308229', '3', '0', '0', '1615183020');
INSERT INTO `rbball` VALUES ('5545', '20210308230', '7', '0', '0', '1615183200');
INSERT INTO `rbball` VALUES ('5546', '20210308231', '5', '0', '0', '1615183380');
INSERT INTO `rbball` VALUES ('5547', '20210308232', '5', '0', '0', '1615183560');
INSERT INTO `rbball` VALUES ('5548', '20210308233', '9', '0', '0', '1615183740');
INSERT INTO `rbball` VALUES ('5549', '20210308234', '7', '0', '0', '1615183920');
INSERT INTO `rbball` VALUES ('5550', '20210308235', '5', '0', '0', '1615184100');
INSERT INTO `rbball` VALUES ('5551', '20210308236', '3', '0', '0', '1615184280');
INSERT INTO `rbball` VALUES ('5552', '20210308237', '7', '0', '0', '1615184460');
INSERT INTO `rbball` VALUES ('5553', '20210308238', '2', '0', '0', '1615184640');
INSERT INTO `rbball` VALUES ('5554', '20210308239', '7', '0', '0', '1615184820');
INSERT INTO `rbball` VALUES ('5555', '20210308240', '2', '0', '0', '1615185000');
INSERT INTO `rbball` VALUES ('5556', '20210308241', '4', '0', '0', '1615185180');
INSERT INTO `rbball` VALUES ('5557', '20210308242', '9', '0', '0', '1615185360');
INSERT INTO `rbball` VALUES ('5558', '20210308243', '2', '0', '0', '1615185540');
INSERT INTO `rbball` VALUES ('5559', '20210308244', '1', '0', '0', '1615185720');
INSERT INTO `rbball` VALUES ('5560', '20210308245', '3', '0', '0', '1615185900');
INSERT INTO `rbball` VALUES ('5561', '20210308246', '8', '0', '0', '1615186080');
INSERT INTO `rbball` VALUES ('5562', '20210308247', '6', '0', '0', '1615186260');
INSERT INTO `rbball` VALUES ('5563', '20210308248', '3', '0', '0', '1615186440');
INSERT INTO `rbball` VALUES ('5564', '20210308249', '0', '0', '0', '1615186620');
INSERT INTO `rbball` VALUES ('5565', '20210308250', '8', '0', '0', '1615186800');
INSERT INTO `rbball` VALUES ('5566', '20210308251', '4', '0', '0', '1615186980');
INSERT INTO `rbball` VALUES ('5567', '20210308252', '4', '0', '0', '1615187160');
INSERT INTO `rbball` VALUES ('5568', '20210308254', '6', '0', '0', '1615187232');
INSERT INTO `rbball` VALUES ('5569', '20210308255', '3', '0', '0', '1615187240');
INSERT INTO `rbball` VALUES ('5570', '20210308256', '3', '0', '0', '1615187252');
INSERT INTO `rbball` VALUES ('5571', '20210308253', '5', '0', '0', '1615187340');
INSERT INTO `rbball` VALUES ('5575', '20210308257', '3', '0', '0', '1615188060');
INSERT INTO `rbball` VALUES ('5576', '20210308258', '0', '0', '0', '1615188240');
INSERT INTO `rbball` VALUES ('5577', '20210308259', '9', '0', '0', '1615188420');
INSERT INTO `rbball` VALUES ('5578', '20210308260', '6', '0', '0', '1615188529');
INSERT INTO `rbball` VALUES ('5580', '20210308261', '1', '0', '0', '1615188613');
INSERT INTO `rbball` VALUES ('5582', '20210308262', '2', '0', '0', '1615188960');
INSERT INTO `rbball` VALUES ('5583', '20210308263', '4', '0', '0', '1615189140');
INSERT INTO `rbball` VALUES ('5584', '20210308264', '8', '0', '0', '1615189320');
INSERT INTO `rbball` VALUES ('5585', '20210308265', '2', '0', '0', '1615189500');
INSERT INTO `rbball` VALUES ('5586', '20210308266', '7', '0', '0', '1615189680');
INSERT INTO `rbball` VALUES ('5587', '20210308267', '4', '0', '0', '1615189860');
INSERT INTO `rbball` VALUES ('5588', '20210308268', '4', '0', '0', '1615190040');
INSERT INTO `rbball` VALUES ('5589', '20210308269', '4', '0', '0', '1615190220');
INSERT INTO `rbball` VALUES ('5590', '20210308270', '7', '0', '0', '1615190400');
INSERT INTO `rbball` VALUES ('5591', '20210308271', '5', '0', '0', '1615190580');
INSERT INTO `rbball` VALUES ('5592', '20210308272', '2', '0', '0', '1615190760');
INSERT INTO `rbball` VALUES ('5593', '20210308273', '1', '0', '0', '1615190940');
INSERT INTO `rbball` VALUES ('5594', '20210308274', '4', '0', '0', '1615191120');
INSERT INTO `rbball` VALUES ('5595', '20210308275', '3', '0', '0', '1615191300');
INSERT INTO `rbball` VALUES ('5596', '20210308276', '3', '0', '0', '1615191480');
INSERT INTO `rbball` VALUES ('5597', '20210308277', '7', '0', '0', '1615191660');
INSERT INTO `rbball` VALUES ('5598', '20210308278', '4', '0', '0', '1615191840');
INSERT INTO `rbball` VALUES ('5599', '20210308279', '1', '0', '0', '1615192020');
INSERT INTO `rbball` VALUES ('5600', '20210308280', '3', '0', '0', '1615192077');
INSERT INTO `rbball` VALUES ('5601', '20210308281', '9', '0', '0', '1615192085');
INSERT INTO `rbball` VALUES ('5602', '20210308282', '3', '0', '0', '1615192180');
INSERT INTO `rbball` VALUES ('5603', '20210308283', '6', '0', '0', '1615192193');
INSERT INTO `rbball` VALUES ('5605', '20210308284', '5', '0', '0', '1615192202');
INSERT INTO `rbball` VALUES ('5606', '20210308285', '3', '0', '0', '1615192210');
INSERT INTO `rbball` VALUES ('5607', '20210308286', '8', '0', '0', '1615192224');
INSERT INTO `rbball` VALUES ('5608', '20210308287', '3', '0', '0', '1615192232');
INSERT INTO `rbball` VALUES ('5609', '20210308288', '9', '0', '0', '1615192241');
INSERT INTO `rbball` VALUES ('5610', '20210308289', '5', '0', '0', '1615192257');
INSERT INTO `rbball` VALUES ('5611', '20210308290', '4', '0', '0', '1615192265');
INSERT INTO `rbball` VALUES ('5622', '20210308291', '5', '0', '0', '1615194180');
INSERT INTO `rbball` VALUES ('5623', '20210308292', '3', '0', '0', '1615194360');
INSERT INTO `rbball` VALUES ('5624', '20210308293', '6', '0', '0', '1615194540');
INSERT INTO `rbball` VALUES ('5625', '20210308294', '4', '0', '0', '1615194720');
INSERT INTO `rbball` VALUES ('5626', '20210308295', '6', '0', '0', '1615194900');
INSERT INTO `rbball` VALUES ('5627', '20210308296', '8', '0', '0', '1615195080');
INSERT INTO `rbball` VALUES ('5628', '20210308297', '0', '0', '0', '1615195260');
INSERT INTO `rbball` VALUES ('5629', '20210308298', '5', '0', '0', '1615195440');
INSERT INTO `rbball` VALUES ('5630', '20210308299', '0', '0', '0', '1615195620');
INSERT INTO `rbball` VALUES ('5631', '20210308300', '3', '0', '0', '1615195800');
INSERT INTO `rbball` VALUES ('5632', '20210308301', '4', '0', '0', '1615195980');
INSERT INTO `rbball` VALUES ('5633', '20210308302', '7', '0', '0', '1615196160');
INSERT INTO `rbball` VALUES ('5634', '20210308303', '1', '0', '0', '1615196340');
INSERT INTO `rbball` VALUES ('5635', '20210308304', '3', '0', '0', '1615196520');

-- ----------------------------
-- Table structure for rbballbet
-- ----------------------------
DROP TABLE IF EXISTS `rbballbet`;
CREATE TABLE `rbballbet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `coin` int(11) NOT NULL,
  `issue` bigint(11) NOT NULL,
  `bet` varchar(255) NOT NULL,
  `time` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=698 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rbballbet
-- ----------------------------
INSERT INTO `rbballbet` VALUES ('584', '8', '10', '20210307396', 'green', '1615126735');
INSERT INTO `rbballbet` VALUES ('585', '8', '10', '20210307396', 'green', '1615126736');
INSERT INTO `rbballbet` VALUES ('586', '10', '100', '20210307402', '7', '1615127902');
INSERT INTO `rbballbet` VALUES ('587', '11', '10', '20210307407', 'green', '1615128730');
INSERT INTO `rbballbet` VALUES ('588', '11', '10', '20210307407', 'red', '1615128794');
INSERT INTO `rbballbet` VALUES ('589', '11', '100', '20210307408', 'green', '1615128861');
INSERT INTO `rbballbet` VALUES ('590', '12', '100', '20210307411', 'green', '1615129388');
INSERT INTO `rbballbet` VALUES ('591', '11', '10', '20210307411', '6', '1615129417');
INSERT INTO `rbballbet` VALUES ('592', '11', '10', '20210307411', '9', '1615129437');
INSERT INTO `rbballbet` VALUES ('593', '8', '10', '20210307413', 'green', '1615129744');
INSERT INTO `rbballbet` VALUES ('594', '8', '10', '20210307413', 'green', '1615129778');
INSERT INTO `rbballbet` VALUES ('595', '10', '10', '20210307413', '7', '1615129882');
INSERT INTO `rbballbet` VALUES ('596', '10', '10000', '20210307414', '6', '1615129925');
INSERT INTO `rbballbet` VALUES ('597', '12', '100', '20210307420', 'green', '1615131108');
INSERT INTO `rbballbet` VALUES ('598', '12', '100', '20210307421', 'green', '1615131274');
INSERT INTO `rbballbet` VALUES ('599', '12', '100', '20210307427', 'green', '1615132323');
INSERT INTO `rbballbet` VALUES ('600', '14', '100', '20210308154', 'red', '1615169584');
INSERT INTO `rbballbet` VALUES ('601', '14', '100', '20210308154', 'purple', '1615169633');
INSERT INTO `rbballbet` VALUES ('602', '14', '100', '20210308154', 'green', '1615169636');
INSERT INTO `rbballbet` VALUES ('603', '14', '100', '20210308156', 'green', '1615169916');
INSERT INTO `rbballbet` VALUES ('604', '14', '100', '20210308156', 'purple', '1615169920');
INSERT INTO `rbballbet` VALUES ('605', '14', '100', '20210308156', 'red', '1615169943');
INSERT INTO `rbballbet` VALUES ('606', '14', '10', '20210308159', '8', '1615170457');
INSERT INTO `rbballbet` VALUES ('607', '14', '1000', '20210308159', 'green', '1615170468');
INSERT INTO `rbballbet` VALUES ('608', '14', '10', '20210308159', 'red', '1615170473');
INSERT INTO `rbballbet` VALUES ('609', '14', '100', '20210308170', 'red', '1615172511');
INSERT INTO `rbballbet` VALUES ('610', '14', '100', '20210308170', 'purple', '1615172513');
INSERT INTO `rbballbet` VALUES ('611', '14', '100', '20210308170', 'green', '1615172515');
INSERT INTO `rbballbet` VALUES ('612', '11', '100', '20210308175', 'green', '1615173423');
INSERT INTO `rbballbet` VALUES ('613', '11', '100', '20210308175', 'red', '1615173427');
INSERT INTO `rbballbet` VALUES ('614', '11', '100', '20210308185', 'green', '1615175215');
INSERT INTO `rbballbet` VALUES ('615', '11', '100', '20210308185', 'red', '1615175219');
INSERT INTO `rbballbet` VALUES ('616', '12', '100', '20210308197', 'green', '1615177263');
INSERT INTO `rbballbet` VALUES ('617', '6', '10', '20210308217', 'red', '1615180912');
INSERT INTO `rbballbet` VALUES ('618', '4', '10', '20210308220', '6', '1615181445');
INSERT INTO `rbballbet` VALUES ('619', '10', '100', '20210308229', 'red', '1615183104');
INSERT INTO `rbballbet` VALUES ('620', '10', '100', '20210308229', '5', '1615183137');
INSERT INTO `rbballbet` VALUES ('621', '10', '100', '20210308229', '6', '1615183142');
INSERT INTO `rbballbet` VALUES ('622', '10', '100', '20210308229', '7', '1615183145');
INSERT INTO `rbballbet` VALUES ('623', '10', '100', '20210308229', '8', '1615183148');
INSERT INTO `rbballbet` VALUES ('624', '10', '100', '20210308229', '9', '1615183150');
INSERT INTO `rbballbet` VALUES ('625', '10', '100', '20210308229', '0', '1615183153');
INSERT INTO `rbballbet` VALUES ('626', '10', '100', '20210308229', '1', '1615183155');
INSERT INTO `rbballbet` VALUES ('627', '10', '100', '20210308229', '2', '1615183158');
INSERT INTO `rbballbet` VALUES ('628', '10', '100', '20210308229', '3', '1615183160');
INSERT INTO `rbballbet` VALUES ('629', '10', '100', '20210308229', '4', '1615183162');
INSERT INTO `rbballbet` VALUES ('630', '11', '100', '20210308231', 'green', '1615183474');
INSERT INTO `rbballbet` VALUES ('631', '11', '100', '20210308231', 'red', '1615183477');
INSERT INTO `rbballbet` VALUES ('632', '22', '100', '20210308232', 'red', '1615183654');
INSERT INTO `rbballbet` VALUES ('633', '22', '100', '20210308232', 'red', '1615183661');
INSERT INTO `rbballbet` VALUES ('634', '22', '100', '20210308232', '0', '1615183677');
INSERT INTO `rbballbet` VALUES ('635', '22', '100', '20210308232', '1', '1615183679');
INSERT INTO `rbballbet` VALUES ('636', '22', '100', '20210308232', '2', '1615183681');
INSERT INTO `rbballbet` VALUES ('637', '22', '100', '20210308232', '3', '1615183683');
INSERT INTO `rbballbet` VALUES ('638', '22', '100', '20210308232', '4', '1615183686');
INSERT INTO `rbballbet` VALUES ('639', '4', '6000', '20210308232', 'red', '1615183687');
INSERT INTO `rbballbet` VALUES ('640', '4', '3000', '20210308233', 'red', '1615183779');
INSERT INTO `rbballbet` VALUES ('641', '2', '10', '20210308234', 'red', '1615183922');
INSERT INTO `rbballbet` VALUES ('642', '2', '10', '20210308234', 'red', '1615183923');
INSERT INTO `rbballbet` VALUES ('643', '4', '0', '20210308234', 'red', '1615183933');
INSERT INTO `rbballbet` VALUES ('644', '4', '100', '20210308234', 'red', '1615183943');
INSERT INTO `rbballbet` VALUES ('645', '7', '100', '20210308234', 'green', '1615184030');
INSERT INTO `rbballbet` VALUES ('646', '5', '10', '20210308235', 'red', '1615184163');
INSERT INTO `rbballbet` VALUES ('647', '5', '100', '20210308236', 'red', '1615184356');
INSERT INTO `rbballbet` VALUES ('648', '12', '10', '20210308237', 'red', '1615184593');
INSERT INTO `rbballbet` VALUES ('649', '12', '10', '20210308237', 'green', '1615184598');
INSERT INTO `rbballbet` VALUES ('650', '23', '10', '20210308238', 'purple', '1615184712');
INSERT INTO `rbballbet` VALUES ('651', '12', '10', '20210308238', 'red', '1615184720');
INSERT INTO `rbballbet` VALUES ('652', '12', '10', '20210308238', 'green', '1615184723');
INSERT INTO `rbballbet` VALUES ('653', '23', '10', '20210308238', 'green', '1615184737');
INSERT INTO `rbballbet` VALUES ('654', '23', '10', '20210308239', 'red', '1615184827');
INSERT INTO `rbballbet` VALUES ('655', '5', '200', '20210308239', 'red', '1615184869');
INSERT INTO `rbballbet` VALUES ('656', '5', '100', '20210308239', 'red', '1615184891');
INSERT INTO `rbballbet` VALUES ('657', '2', '100', '20210308239', 'red', '1615184902');
INSERT INTO `rbballbet` VALUES ('658', '5', '100', '20210308240', 'green', '1615185063');
INSERT INTO `rbballbet` VALUES ('659', '5', '100', '20210308240', 'green', '1615185069');
INSERT INTO `rbballbet` VALUES ('660', '5', '100', '20210308240', 'green', '1615185072');
INSERT INTO `rbballbet` VALUES ('661', '5', '100', '20210308240', 'green', '1615185074');
INSERT INTO `rbballbet` VALUES ('662', '24', '100', '20210308240', 'red', '1615185112');
INSERT INTO `rbballbet` VALUES ('663', '24', '100', '20210308241', 'green', '1615185229');
INSERT INTO `rbballbet` VALUES ('664', '5', '100', '20210308241', 'red', '1615185239');
INSERT INTO `rbballbet` VALUES ('665', '24', '100', '20210308243', 'green', '1615185611');
INSERT INTO `rbballbet` VALUES ('666', '24', '100', '20210308243', 'green', '1615185611');
INSERT INTO `rbballbet` VALUES ('667', '24', '100', '20210308243', 'green', '1615185612');
INSERT INTO `rbballbet` VALUES ('668', '24', '100', '20210308243', 'green', '1615185612');
INSERT INTO `rbballbet` VALUES ('669', '24', '100', '20210308243', 'purple', '1615185617');
INSERT INTO `rbballbet` VALUES ('670', '24', '100', '20210308243', 'purple', '1615185618');
INSERT INTO `rbballbet` VALUES ('671', '24', '100', '20210308244', 'green', '1615185825');
INSERT INTO `rbballbet` VALUES ('672', '24', '100', '20210308244', 'green', '1615185826');
INSERT INTO `rbballbet` VALUES ('673', '5', '10', '20210308245', 'red', '1615185908');
INSERT INTO `rbballbet` VALUES ('674', '5', '10', '20210308246', 'red', '1615186119');
INSERT INTO `rbballbet` VALUES ('675', '6', '10', '20210308247', 'red', '1615186403');
INSERT INTO `rbballbet` VALUES ('676', '5', '1000', '20210308248', 'green', '1615186501');
INSERT INTO `rbballbet` VALUES ('677', '5', '1000', '20210308248', 'red', '1615186505');
INSERT INTO `rbballbet` VALUES ('678', '6', '10', '20210308248', 'purple', '1615186569');
INSERT INTO `rbballbet` VALUES ('679', '6', '1000', '20210308249', 'purple', '1615186688');
INSERT INTO `rbballbet` VALUES ('680', '5', '100', '20210308255', 'red', '1615187799');
INSERT INTO `rbballbet` VALUES ('681', '3', '10', '20210308257', 'purple', '1615188113');
INSERT INTO `rbballbet` VALUES ('682', '3', '10', '20210308258', 'purple', '1615188261');
INSERT INTO `rbballbet` VALUES ('683', '3', '10', '20210308258', 'red', '1615188275');
INSERT INTO `rbballbet` VALUES ('684', '3', '10', '20210308258', 'green', '1615188279');
INSERT INTO `rbballbet` VALUES ('685', '5', '100', '20210308259', 'red', '1615188499');
INSERT INTO `rbballbet` VALUES ('686', '5', '1000', '20210308259', 'red', '1615188557');
INSERT INTO `rbballbet` VALUES ('687', '5', '1000', '20210308259', 'red', '1615188558');
INSERT INTO `rbballbet` VALUES ('688', '3', '100', '20210308281', '9', '1615192405');
INSERT INTO `rbballbet` VALUES ('689', '6', '1000', '20210308281', '9', '1615192408');
INSERT INTO `rbballbet` VALUES ('690', '3', '1000', '20210308281', '9', '1615192410');
INSERT INTO `rbballbet` VALUES ('691', '3', '1000', '20210308281', '9', '1615192424');
INSERT INTO `rbballbet` VALUES ('692', '3', '1000', '20210308281', '9', '1615192428');
INSERT INTO `rbballbet` VALUES ('693', '6', '1000', '20210308281', 'green', '1615192441');
INSERT INTO `rbballbet` VALUES ('694', '6', '10', '20210308282', 'red', '1615192705');
INSERT INTO `rbballbet` VALUES ('695', '6', '100', '20210308284', '5', '1615192922');
INSERT INTO `rbballbet` VALUES ('696', '6', '100', '20210308284', 'green', '1615193046');
INSERT INTO `rbballbet` VALUES ('697', '6', '100', '20210308284', 'green', '1615193051');

-- ----------------------------
-- Table structure for tradeorder
-- ----------------------------
DROP TABLE IF EXISTS `tradeorder`;
CREATE TABLE `tradeorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderLocal` varchar(255) NOT NULL DEFAULT '',
  `orderRemote` varchar(255) NOT NULL DEFAULT '',
  `plat` int(11) NOT NULL DEFAULT '0',
  `uid` int(11) NOT NULL DEFAULT '0',
  `agentId` int(11) NOT NULL,
  `cost` float(11,2) NOT NULL DEFAULT '0.00',
  `currency` varchar(255) NOT NULL DEFAULT '',
  `coin` int(11) NOT NULL DEFAULT '0',
  `accountOut` varchar(255) NOT NULL DEFAULT '',
  `accountIn` varchar(255) NOT NULL DEFAULT '',
  `orderType` int(11) NOT NULL DEFAULT '0',
  `freezeId` int(11) NOT NULL DEFAULT '0',
  `time` bigint(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderLocal` (`orderLocal`) USING BTREE,
  UNIQUE KEY `orderRemote` (`orderRemote`) USING BTREE,
  KEY `agentId` (`agentId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tradeorder
-- ----------------------------
INSERT INTO `tradeorder` VALUES ('1', 'OrderIn20210307180858423815876', '76906', '0', '8', '171', '100.00', 'INR', '100', '', '', '1', '0', '1615120739', '2');
INSERT INTO `tradeorder` VALUES ('2', 'OrderIn20210307200250764560476', '76908', '0', '10', '171', '200.00', 'INR', '200', '', '', '1', '0', '1615127571', '2');
INSERT INTO `tradeorder` VALUES ('3', 'OrderIn20210307202725164762115', '76909', '0', '11', '8', '100.00', 'INR', '100', '', '', '1', '0', '1615129045', '2');
INSERT INTO `tradeorder` VALUES ('4', 'OrderIn20210307204705643495692', '76910', '0', '13', '8', '9999.00', 'INR', '9999', '', '', '1', '0', '1615130226', '2');
INSERT INTO `tradeorder` VALUES ('5', 'OrderIn20210307205059841355927', '76911', '0', '11', '8', '100.00', 'INR', '100', '', '', '1', '0', '1615130460', '2');
INSERT INTO `tradeorder` VALUES ('6', 'OrderIn20210307211122118252504', '76912', '0', '11', '8', '200.00', 'INR', '200', '', '', '1', '0', '1615131682', '2');
INSERT INTO `tradeorder` VALUES ('7', 'OrderIn20210308095413312508556', '76914', '0', '12', '8', '1000.00', 'INR', '1000', '', '', '1', '0', '1615177454', '2');
INSERT INTO `tradeorder` VALUES ('8', 'OrderIn20210308095417020798516', '76915', '0', '12', '8', '1000.00', 'INR', '1000', '', '', '1', '0', '1615177457', '2');
INSERT INTO `tradeorder` VALUES ('9', 'OrderIn20210308095417329604586', '76916', '0', '12', '8', '1000.00', 'INR', '1000', '', '', '1', '0', '1615177457', '2');
INSERT INTO `tradeorder` VALUES ('10', 'OrderIn20210308095447451554565', '76917', '0', '12', '8', '100000.00', 'INR', '100000', '', '', '1', '0', '1615177487', '2');
INSERT INTO `tradeorder` VALUES ('11', 'OrderIn20210308133701171274210', '76920', '0', '24', '169', '100.00', 'INR', '100', '', '', '1', '0', '1615190821', '2');
INSERT INTO `tradeorder` VALUES ('12', 'OrderIn20210308142754406436845', '76921', '0', '11', '8', '200.00', 'INR', '200', '', '', '1', '0', '1615193874', '2');

-- ----------------------------
-- Table structure for usermineral
-- ----------------------------
DROP TABLE IF EXISTS `usermineral`;
CREATE TABLE `usermineral` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `mineral` int(11) NOT NULL DEFAULT '0',
  `freeze` varchar(255) NOT NULL DEFAULT '',
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='玩家矿石';

-- ----------------------------
-- Records of usermineral
-- ----------------------------
