drop table if exists c_cust;

create table c_cust
(
    CUST_ID   bigint(16) auto_increment comment '用户唯一标识'
        primary key,
    MOBILE    varchar(16)  null comment '手机号',
    CUST_NAME varchar(64)  null comment '用户名称',
    CUST_TYPE varchar(8)   null comment '用户类型',
    PASSWORD  varchar(256) null comment '密码',
    STATE     smallint(2)  null comment '状态;0为失效，1:为生效'
);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (1, '15960322601', 'linCheng', '01', '123', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (2, '15960322601', '林城', '01', '@WSX2wsx', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (3, '15960322602', '顶替', '01', '135', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (4, '15960322603', '工', '01', '12', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (5, '15960322604', '人', '01', '235', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (6, '15960322605', '包', '01', '214', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (7, '15960322606', '主', '01', '1tqt', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (8, '15960322607', '感觉', '01', '235', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (9, '15960322608', '然后', '01', '1235', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (10, '15960322610', '推脱', '01', 'qwer', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (11, '15960322609', '你', '01', 'wer', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (12, '15960322611', '和', '01', 'rweh', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (13, '15960322612', '放', '01', 'eqr', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (14, '15960322613', '拉', '01', 'sdfw', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (15, '15960322615', '脸色', '01', 'asdg', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (16, '15960322614', '肠子', '01', 're', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (17, '15960322617', '欠妥', '01', 'qwe', 1);
INSERT INTO study.c_cust (CUST_ID, MOBILE, CUST_NAME, CUST_TYPE, PASSWORD, STATE) VALUES (18, '15960322618', '主持人', '01', 'sdga', 1);



drop table if exists study_mybatis_plus;
create table study_mybatis_plus
(
    ID    bigint auto_increment
        primary key,
    NAME  varchar(64) null,
    AGE   int(16)     null,
    EMAIL varchar(64) null
);
INSERT INTO study.study_mybatis_plus (ID, NAME, AGE, EMAIL) VALUES (1, '张三', 20, '2@qq.com');
INSERT INTO study.study_mybatis_plus (ID, NAME, AGE, EMAIL) VALUES (2, '李四', 18, '3@qq.com');

drop table if exists study_mybatis_plus_ar;
create table study_mybatis_plus_ar
(
    ID          int(16) auto_increment
        primary key,
    NAME        varchar(32)            null,
    STUDY_AR    varchar(32)            null,
    CREATE_TIME datetime               null,
    MOBILE      varchar(32)            null,
    AGE         int(4)                 null,
    state       varchar(1) default '1' null
);

INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (1, '张四', '', '2021-11-03 22:00:07', '158', 10, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (2, '张三', '学习一下哈哈哈', '2021-11-03 21:40:52', '1586600', 20, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (3, '林黄', null, '2021-11-03 23:33:50', '159', 21, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (4, '林友', null, '2021-11-03 23:33:52', '168', 22, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (5, '李王', null, '2021-11-03 23:33:52', '168', 32, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (6, '李上', null, '2021-11-03 23:33:53', null, 21, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (7, '赵多', null, '2021-11-03 23:35:25', '168', 31, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (8, '张表', '学习一下哈哈哈', '2021-11-03 23:35:26', '168', 27, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (9, '张清', null, '2021-11-03 23:35:27', '168', 18, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (10, '巫代', '学习一下哈哈哈', '2021-11-03 23:35:27', null, 24, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (11, '陈克', null, '2021-11-03 23:35:28', '168', 25, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (12, '陈春', '学习一下哈哈哈', '2021-11-03 23:35:29', null, 16, '1');
INSERT INTO study.study_mybatis_plus_ar (ID, NAME, STUDY_AR, CREATE_TIME, MOBILE, AGE, state) VALUES (13, '江山', null, '2021-11-03 23:35:29', null, 19, '1');


create table sys_role
(
    ROLE_ID   bigint auto_increment comment '角色id'
        primary key,
    ROLE_CODE varchar(64) null comment '角色编码',
    ROLE_NAME varchar(64) null comment '角色名称',
    STATE     smallint(2) null comment '0:失效,1:生效'
);
INSERT INTO study.sys_role (ROLE_ID, ROLE_CODE, ROLE_NAME, STATE) VALUES (1, 'normal', '普通用户', 1);
INSERT INTO study.sys_role (ROLE_ID, ROLE_CODE, ROLE_NAME, STATE) VALUES (3, 'admin', '管理员', 1);
INSERT INTO study.sys_role (ROLE_ID, ROLE_CODE, ROLE_NAME, STATE) VALUES (4, 'superAdmin', '超级管理', 1);


create table sys_user_role
(
    USER_ROLE_ID bigint auto_increment comment '角色信息关联主键'
        primary key,
    ROLE_ID      bigint      null comment '角色id',
    CUST_ID      bigint      null comment '用户id',
    STATE        smallint(2) null comment '0:失效,1:生效'
);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (1, 1, 2, 1);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (2, 3, 2, 1);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (3, 4, 2, 1);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (4, 1, 1, 1);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (5, 3, 1, 1);
INSERT INTO study.sys_user_role (USER_ROLE_ID, ROLE_ID, CUST_ID, STATE) VALUES (6, 4, 1, 1);


