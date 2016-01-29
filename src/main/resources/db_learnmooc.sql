/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_learnmooc

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-01-27 21:26:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_answer_log
-- ----------------------------
DROP TABLE IF EXISTS `t_answer_log`;
CREATE TABLE `t_answer_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `preview_id` int(11) DEFAULT NULL,
  `question_title` varchar(255) DEFAULT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  `user_score` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `description` text,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `course_video_url` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_elective_log
-- ----------------------------
DROP TABLE IF EXISTS `t_elective_log`;
CREATE TABLE `t_elective_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `expt_id` int(11) DEFAULT NULL,
  `expt_name` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_expt
-- ----------------------------
DROP TABLE IF EXISTS `t_expt`;
CREATE TABLE `t_expt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `goal` text,
  `principle` text,
  `content` text,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_preview
-- ----------------------------
DROP TABLE IF EXISTS `t_preview`;
CREATE TABLE `t_preview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `expt_id` int(11) DEFAULT NULL,
  `expt_name` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_preview_content
-- ----------------------------
DROP TABLE IF EXISTS `t_preview_content`;
CREATE TABLE `t_preview_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `size` bigint(32) DEFAULT NULL,
  `txt` text,
  `url` varchar(255) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `exptName` varchar(255) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `videoPicPath` varchar(255) DEFAULT NULL,
  `videoUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content_a` varchar(255) DEFAULT NULL,
  `content_b` varchar(255) DEFAULT NULL,
  `content_c` varchar(255) DEFAULT NULL,
  `content_d` varchar(255) DEFAULT NULL,
  `content_e` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `preview_id` int(11) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `timepoint` int(11) DEFAULT NULL,
  `expt_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_study_log
-- ----------------------------
DROP TABLE IF EXISTS `t_study_log`;
CREATE TABLE `t_study_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `preview_content_id` int(11) DEFAULT NULL,
  `preview_id` int(11) DEFAULT NULL,
  `study_time` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
