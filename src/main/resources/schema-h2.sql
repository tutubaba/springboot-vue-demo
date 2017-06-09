DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `u_name` VARCHAR(255) DEFAULT NULL ,
  `state` int(2) DEFAULT NULL ,
  PRIMARY KEY (`u_id`)
);
insert into user values(1,'user1',1);
insert into user values(2,'user2',1);