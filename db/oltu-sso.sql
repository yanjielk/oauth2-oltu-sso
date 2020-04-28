
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sso_client
-- ----------------------------
DROP TABLE IF EXISTS `sso_client`;
CREATE TABLE `sso_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(255) NOT NULL,
  `client_id` varchar(255) NOT NULL,
  `client_secret` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sso_client
-- ----------------------------
BEGIN;
INSERT INTO `sso_client` VALUES (1, 'admin', '0f112be3-ffd2-4957-9e7f-57db8842d3d0', 'e3234b95-3c3d-4ece-aa87-2099abd7dfa2');
COMMIT;

-- ----------------------------
-- Table structure for sso_user
-- ----------------------------
DROP TABLE IF EXISTS `sso_user`;
CREATE TABLE `sso_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sso_user
-- ----------------------------
BEGIN;
INSERT INTO `sso_user` VALUES (1, 'admin', '4f4d23b5f3466c8bbb841bce991832d89fd77c1bc4bff9cef0fa2720d0e588e5', 'GSGUw68fhhL9Re1z7nA8');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
