
create database `mybatis`;

use `mybatis`;

create table `user` (
    `id` int(20) not null primary key,
    `name` varchar(30) default null,
    `pwd` varchar(30) default null
)engine=innodb default charset=utf8;

insert into `user` (`id`, `name`, `pwd`) values
(1, '张三', '123456'),
(2, '李四', '123456'),
(3, '王五', '123456')

