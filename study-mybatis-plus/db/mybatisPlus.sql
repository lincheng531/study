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


