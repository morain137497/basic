-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: localhost    Database: basic
-- ------------------------------------------------------
-- Server version	5.7.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `b_relation_rule`
--

DROP TABLE IF EXISTS `b_relation_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_relation_rule` (
  `rule_id` int(11) NOT NULL COMMENT '规则id',
  `relation_rule_id` int(11) NOT NULL COMMENT '关联规则id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关联规则表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_relation_rule`
--

LOCK TABLES `b_relation_rule` WRITE;
/*!40000 ALTER TABLE `b_relation_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_relation_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_role`
--

DROP TABLE IF EXISTS `b_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `remarks` varchar(20) DEFAULT NULL COMMENT '角色备注',
  `is_del` int(11) NOT NULL DEFAULT '1' COMMENT '0、删除，1、正常',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0、冻结，1、正常',
  `c_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_role`
--

LOCK TABLES `b_role` WRITE;
/*!40000 ALTER TABLE `b_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_role_rule`
--

DROP TABLE IF EXISTS `b_role_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_role_rule` (
  `rule_id` int(11) NOT NULL COMMENT '规则id',
  `role_id` int(11) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色规则表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_role_rule`
--

LOCK TABLES `b_role_rule` WRITE;
/*!40000 ALTER TABLE `b_role_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_role_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_rule`
--

DROP TABLE IF EXISTS `b_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sign` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0、目录，1、页面，2、操作，3、关联规则',
  `name` varchar(20) NOT NULL COMMENT '规则名称',
  `page_path` varchar(50) DEFAULT NULL COMMENT '前端页面路径',
  `request_path` varchar(50) DEFAULT NULL COMMENT '数据请求路径',
  `request_type` varchar(10) DEFAULT NULL COMMENT '数据请求方式',
  `icon` varchar(30) DEFAULT NULL COMMENT '目录图标',
  `p_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级规则id',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序，值越小，排序越靠前',
  `is_del` int(11) NOT NULL DEFAULT '1' COMMENT '0、删除，1、正常',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0、冻结，1、正常',
  `c_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_rule`
--

LOCK TABLES `b_rule` WRITE;
/*!40000 ALTER TABLE `b_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_user`
--

DROP TABLE IF EXISTS `b_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sign` tinyint(1) NOT NULL DEFAULT '2' COMMENT '0、超级管理员，1、管理员，2、用户(根据业务修改)',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `mobile_number` varchar(15) DEFAULT NULL COMMENT '手机号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `is_del` int(11) NOT NULL DEFAULT '1' COMMENT '0、删除，1、正常',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0、冻结，1、正常',
  `c_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_user`
--

LOCK TABLES `b_user` WRITE;
/*!40000 ALTER TABLE `b_user` DISABLE KEYS */;
INSERT INTO `b_user` VALUES (1,2,'root',NULL,'root',1,1,'2021-02-25 11:45:00','2021-02-25 11:45:00');
/*!40000 ALTER TABLE `b_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_user_role`
--

DROP TABLE IF EXISTS `b_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_user_role`
--

LOCK TABLES `b_user_role` WRITE;
/*!40000 ALTER TABLE `b_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-02 12:10:31
