# StudentManagement
 
```sql
create table `user` (
	`id` varchar(20) primary key comment "id",
	`password` varchar(20) not null comment "密码",
	`is_teacher` boolean not null comment "是否为老师",
	`avatar` text comment "头像",
	`name` varchar(15) comment "姓名",
	`gender` tinyint unsigned not null default 0 comment "性别",
	`phone` varchar(11) comment "电话",
	`email` varchar(30) comment "邮箱",
	`student_id` varchar(20) comment "学号",
	`dormitory` varchar(20) comment "宿舍",
    `class_id` integer unsigned comment "班级id",
	`create_at` datetime not null default now() comment "创建时间",
	`update_at` datetime not null default now() on update now() comment "更新时间"
)engine=InnoDB default charset=utf8mb4 collate=utf8mb4_general_ci;

create table `class` (
	`id` integer unsigned primary key auto_increment comment "id",
	`name` varchar(20) not null comment "班级名",
	`school` varchar(20) not null comment "学校名",
	`department` varchar(20) not null comment "院系名",
	`major` varchar(20) not null comment "专业名",
	`year` smallint unsigned not null comment "年级",
	`creator_user_id` varchar(20) not null comment "创建班级用户id",
	`invite_code` varchar(8) not null comment "邀请码"
)engine=InnoDB default charset=utf8mb4 collate=utf8mb4_general_ci;
```
