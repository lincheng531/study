drop table if exists oss_file_info;

/*==============================================================*/
/* Table: oss_file_info                                         */
/*==============================================================*/
create table oss_file_info
(
   ossFileInfoId        bigint not null auto_increment comment '主键',
   fileType             int comment '文件类型',
   ossFileName          varchar(512) comment 'oss文件名称',
   fileName             varchar(64) comment '文件名称',
   md5Hex               varchar(64) comment '文件md5',
   remark               varchar(128)  comment '备注',
   addTime              datetime default CURRENT_TIMESTAMP comment '添加时间',
   modifyTime           datetime default CURRENT_TIMESTAMP comment '修改时间',
   operatorId           bigint comment '操作操作账号Id',
   operatorName         varchar(64) comment '操作账号名',
   primary key (ossFileInfoId)
);

alter table oss_file_info comment 'oss文件管理表';




drop table if exists oss_file_business;

/*==============================================================*/
/* Table: oss_file_business                                     */
/*==============================================================*/
create table oss_file_business
(
   ossFileBusinessId    bigint not null auto_increment comment '主键',
   ossFileInfoId        bigint not null comment '文件信息ID',
   businessId           varchar(128)  not null comment '关联业务ID',
   businessType         int not null comment '业务类型',
   userId               bigint comment '用户ID',
   robotId              bigint comment '机器人ID',
   remark               varchar(128)  comment '备注',
   addTime              datetime default CURRENT_TIMESTAMP comment '添加时间',
   modifyTime           datetime default CURRENT_TIMESTAMP comment '修改时间',
   operatorId           bigint comment '操作操作账号Id',
   operatorName         varchar(64) comment '操作账号名',
   primary key (ossFileBusinessId)
);

alter table oss_file_business comment '文件业务表';


