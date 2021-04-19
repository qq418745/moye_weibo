/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - weibo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weibo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `weibo`;

/*Table structure for table `t_admin_user` */

DROP TABLE IF EXISTS `t_admin_user`;

CREATE TABLE `t_admin_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  UNIQUE KEY `admin_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin_user` */

insert  into `t_admin_user`(`user_id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_text` varchar(256) DEFAULT NULL COMMENT '评论内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `weibo_id` int(11) NOT NULL COMMENT '微博id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`comment_id`,`comment_text`,`create_time`,`weibo_id`,`user_id`) values (3,'1','2021-04-18 12:04:05',18,1),(4,'1','2021-04-18 12:04:08',18,1),(5,'keyi','2021-04-18 12:06:02',18,1),(6,'11','2021-04-18 12:06:09',18,1),(7,'2333','2021-04-18 12:07:55',17,1),(8,'RE','2021-04-18 12:08:02',15,1),(9,'11','2021-04-18 12:09:17',15,1),(10,'222','2021-04-18 12:50:13',15,1),(11,'222','2021-04-18 15:49:40',18,1),(12,'11','2021-04-19 14:05:47',25,1),(13,'可以','2021-04-19 14:32:41',29,1),(14,'好玩吗','2021-04-19 14:32:50',28,1),(15,'你好','2021-04-19 14:35:08',30,3),(16,'好玩吗','2021-04-19 14:37:15',32,4),(17,'名字很好','2021-04-19 14:37:26',29,4),(18,'激动啥','2021-04-19 14:39:48',31,5),(19,'游戏','2021-04-19 14:43:02',36,6),(20,'222','2021-04-19 14:46:05',29,6),(21,'222','2021-04-19 14:46:06',29,6),(22,'222','2021-04-19 14:46:08',29,6),(23,'这个是啥','2021-04-19 14:52:58',34,1);

/*Table structure for table `t_favorite` */

DROP TABLE IF EXISTS `t_favorite`;

CREATE TABLE `t_favorite` (
  `favorite_id` varchar(48) NOT NULL COMMENT '收藏id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `weibo_id` int(11) NOT NULL COMMENT '微博id',
  PRIMARY KEY (`favorite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_favorite` */

insert  into `t_favorite`(`favorite_id`,`user_id`,`create_time`,`weibo_id`) values ('17_1_1618722491721',1,'2021-04-18 13:08:11',17),('18_1_1618728406178',1,'2021-04-18 14:46:46',18),('28_3_1618814114679',3,'2021-04-19 14:35:14',28),('31_3_1618814112380',3,'2021-04-19 14:35:12',31),('33_4_1618814224282',4,'2021-04-19 14:37:04',33);

/*Table structure for table `t_follow` */

DROP TABLE IF EXISTS `t_follow`;

CREATE TABLE `t_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `follow_user_id` int(11) DEFAULT NULL COMMENT '用户粉丝id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_follow` */

insert  into `t_follow`(`id`,`user_id`,`follow_user_id`) values (2,2,1),(6,1,2),(7,4,3),(8,5,4),(9,5,3),(10,5,1),(11,6,5),(12,6,1),(13,6,2),(14,1,6);

/*Table structure for table `t_like` */

DROP TABLE IF EXISTS `t_like`;

CREATE TABLE `t_like` (
  `like_id` varchar(48) NOT NULL COMMENT '点赞id',
  `weibo_id` int(11) NOT NULL COMMENT '微博id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_like` */

insert  into `t_like`(`like_id`,`weibo_id`,`user_id`,`create_time`) values ('15_1_1618728164632',15,1,'2021-04-18 14:42:44'),('16_1_1618722502665',16,1,'2021-04-18 13:08:22'),('17_1_1618722490151',17,1,'2021-04-18 13:08:10'),('27_3_1618814116640',27,3,'2021-04-19 14:35:16'),('29_4_1618814239172',29,4,'2021-04-19 14:37:19'),('30_3_1618814110544',30,3,'2021-04-19 14:35:10'),('31_4_1618814237546',31,4,'2021-04-19 14:37:17'),('35_1_1618815167701',35,1,'2021-04-19 14:52:47');

/*Table structure for table `t_weibo` */

DROP TABLE IF EXISTS `t_weibo`;

CREATE TABLE `t_weibo` (
  `weibo_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微博id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `post_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `content` varchar(256) NOT NULL COMMENT '文字内容',
  `pic1` varchar(50) DEFAULT NULL COMMENT '图片',
  `pic2` varchar(50) DEFAULT NULL,
  `pic3` varchar(50) DEFAULT NULL,
  `pic4` varchar(50) DEFAULT NULL,
  `pic5` varchar(50) DEFAULT NULL,
  `pic6` varchar(50) DEFAULT NULL,
  `pic7` varchar(50) DEFAULT NULL,
  `pic8` varchar(50) DEFAULT NULL,
  `pic9` varchar(50) DEFAULT NULL,
  `topic` varchar(24) DEFAULT NULL COMMENT '话题',
  PRIMARY KEY (`weibo_id`),
  KEY `FK_Relationship_1` (`user_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`user_id`) REFERENCES `t_weibo_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `t_weibo` */

insert  into `t_weibo`(`weibo_id`,`user_id`,`post_time`,`content`,`pic1`,`pic2`,`pic3`,`pic4`,`pic5`,`pic6`,`pic7`,`pic8`,`pic9`,`topic`) values (15,1,'2021-03-31 16:59:41','说是26°但我感觉体感温度是32°………………快热溶了',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,2,'2021-04-14 21:41:02','1111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,2,'2021-04-14 21:41:04','222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,1,'2021-04-19 10:40:46','#猫猫能量 虎斑暹罗世界第一——',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,1,'2021-04-19 10:54:27','#猫猫能量  中华田园橘橘猫天下第一',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'猫猫能量'),(23,1,'2021-04-19 10:55:16','#江南百景图  没开杭州之前我觉得我是个身怀400W铜钱的巨佬，开了杭州之后充分意识到了制作组的恶意，一块地就要100多W你闹呢。。。。。。。。。',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'江南百景图'),(24,1,'2021-04-19 10:56:02','#无心上班只想撸猫  无聊 无聊',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'无心上班只想撸猫'),(25,1,'2021-04-19 10:56:19','#攻控推文自我记录 1v1《虚拟巨星饲养日记》by紫舞玥鸢 普通 1v1《沉落》 by初禾 普通 1v1《淘宝小哥和他的主顾》by顾臣臣 普通 短',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'攻控推文自我记录'),(26,2,'2021-04-19 14:27:48','#修炼手札  开始玩《修炼手札》。',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'修炼手札'),(27,2,'2021-04-19 14:28:11','今天的天气刚刚好! 好看',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,2,'2021-04-19 14:28:36','#修炼手札  我已经开始玩了',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'修炼手札'),(29,2,'2021-04-19 14:31:23','对不起，是我有毒，我走哪个哪个就涨，其实我才是黄旭东本东',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,1,'2021-04-19 14:32:32','这周日要上班啊？哦，那没事了……不愉快的一天',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,3,'2021-04-19 14:34:20','第一天  有点激动',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,3,'2021-04-19 14:34:48','#江南百景图  感觉我的脑子最近经常离线',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'江南百景图'),(33,4,'2021-04-19 14:36:56','有时候真的羡慕什么都学得很快的人。我学习的时候总是得复盘好几遍才记住，得花比别人多的时间才赶得上他们。',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,5,'2021-04-19 14:39:01','我跟朋友说图森科技要上市了，创办人还是交大的，他说那他要气死了，我说也许他胸襟宽广呢，这完全可以看成是对他个人魅力的欣赏。事情从不同角度理解会有完全不同的感受。想起以前CBA有位功勋卓著的老帅蒋兴权，球迷喜爱他称之为骨灰级教练，蒋兴权知道后暴怒，以为是球迷诅咒他。',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,5,'2021-04-19 14:39:11','困得要死，喝了一瓶红参感觉没啥卵用。',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,5,'2021-04-19 14:39:31','#江南百景图  这个是什么',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'江南百景图'),(39,6,'2021-04-19 14:45:05','#江南百景图  我在搜索宋朝的一些绘图，结果杀出几张魔道的，放过我行不行啊！！！！啊！！',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'江南百景图'),(40,1,'2021-04-19 14:50:00','又理了一下，我反感某两位主演大概是因为仿佛看到当初的某两位……………………营销模式太像了',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_weibo_user` */

DROP TABLE IF EXISTS `t_weibo_user`;

CREATE TABLE `t_weibo_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `face` varchar(50) DEFAULT NULL COMMENT '头像',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `bir` date DEFAULT NULL COMMENT '出生日期',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `hobby` varchar(128) DEFAULT NULL COMMENT '爱好',
  `job` varchar(64) DEFAULT NULL COMMENT '职业',
  `user_explain` varchar(256) DEFAULT NULL COMMENT '说明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_logo` varchar(64) DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_weibo_user` */

insert  into `t_weibo_user`(`user_id`,`username`,`password`,`nickname`,`face`,`sex`,`bir`,`province`,`city`,`email`,`hobby`,`job`,`user_explain`,`create_time`,`user_logo`) values (1,'1','c4ca4238a0b923820dcc509a6f75849b','moye',NULL,NULL,NULL,'南京',NULL,'1@122','打豆豆 吃饭','学生','哈哈哈','2021-03-18 10:20:07','../../img/user_logo/tow_2.jpg'),(2,'2','c81e728d9d4c2f636f067f89cc14862c','三娃',NULL,NULL,NULL,'南京',NULL,'1@1','睡觉 打豆豆','吃饭','我真好!','2021-04-14 21:40:20','../../img/user_logo/gourd_4.jpg'),(3,'3','eccbc87e4b5ce2fe28308fd9f2a7baf3','绿头',NULL,NULL,NULL,'杭州',NULL,'3@3','打球 吃饭','篮球','我....','2021-04-19 14:21:39','../../img/user_logo/tow_1.jpg'),(4,'4','a87ff679a2f3e71d9181a67b7542122c','伊万',NULL,NULL,NULL,'新疆',NULL,'4@4','开车','火车司机','我 开车很快..','2021-04-19 14:35:45','../../img/user_logo/tow_6.jpg'),(5,'5','e4da3b7fbbce2345d7772b0674a318d5','bency',NULL,NULL,NULL,'陕西',NULL,'5@5','游戏','学生','我 飞的很快...','2021-04-19 14:37:51','../../img/user_logo/tow_4.jpg'),(6,'6','1679091c5a880faf6fb5e6087eb1b2dc','平川丶K',NULL,NULL,NULL,'保密',NULL,'6@6','吃','学生','我...','2021-04-19 14:41:20','../../img/user_logo/tow_3.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
