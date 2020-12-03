# StudentManagement
 
```sql
create table user
(
    id         varchar(20)                                not null comment 'id'
        primary key,
    password   varchar(20)                                not null comment '密码',
    is_teacher tinyint(1)                                 not null comment '是否为老师',
    avatar     text                                       null comment '头像',
    name       varchar(15)                                not null comment '姓名',
    gender     tinyint unsigned default '0'               not null comment '性别',
    phone      varchar(11)                                null comment '电话',
    email      varchar(30)                                null comment '邮箱',
    student_id varchar(20)                                null comment '学号',
    dormitory  varchar(20)                                null comment '宿舍',
    class_id   int unsigned                               null comment '班级id',
    create_at  datetime         default CURRENT_TIMESTAMP not null comment '创建时间',
    update_at  datetime         default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

create table class
(
    id              int unsigned auto_increment comment 'id'
        primary key,
    name            varchar(20)       not null comment '班级名',
    school          varchar(20)       not null comment '学校名',
    department      varchar(20)       not null comment '院系名',
    major           varchar(20)       not null comment '专业名',
    year            smallint unsigned not null comment '年级',
    creator_user_id varchar(20)       not null comment '创建班级用户id',
    invite_code     varchar(8)        not null comment '邀请码'
);
```
