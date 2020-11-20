# StudentManagement
 
```sql
create table `user` (
	`id` varchar(20) primary key comment "id",
	`password` varchar(20) not null comment "密码",
	`create_at` datetime not null default now() comment "创建时间",
	`update_at` datetime not null default now() on UPDATE now() comment "更新时间",
	`delete_at` datetime comment "删除时间"
)engine=InnoDB default charset=utf8mb4 collate=utf8mb4_general_ci;
```
