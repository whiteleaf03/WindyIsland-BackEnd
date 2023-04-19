drop database if exists blog;
create database blog;
use blog;

create table article
(
    id          bigint auto_increment comment '主键'
        primary key,
    author      varchar(32)          not null comment '作者',
    title       varchar(32)          not null comment '文章标题',
    `describe`  varchar(32)          not null comment '文章副标题',
    borderColor varchar(16)          not null comment '封面外边框颜色',
    cover       varchar(512)         not null comment '文章封面图片路径',
    content     longtext             not null comment '文章内容 富文本形式',
    view        bigint     default 0 not null comment '浏览量',
    comment     bigint     default 0 not null comment '评论量',
    createTime  bigint               not null comment '创建日期',
    updateTime  bigint               not null comment '更新日期',
    isDelete    tinyint(1) default 0 not null comment '是否删除',
    constraint cover
        unique (cover),
    constraint `describe`
        unique (`describe`),
    constraint title
        unique (title)
)
    charset = utf8;

create table articleclassification
(
    articleId        bigint not null comment '文章id',
    classificationId bigint not null comment '分类id'
)
    charset = utf8;

create table articletag
(
    articleId bigint not null comment '文章id',
    tagId     bigint not null comment '标签id'
)
    charset = utf8;

create table classification
(
    id         bigint auto_increment comment '主键'
        primary key,
    name       varchar(32)          not null comment '分类名',
    updateTime bigint               not null comment '上传日期',
    isDelete   tinyint(1) default 0 not null comment '是否删除',
    constraint name
        unique (name)
)
    charset = utf8;

create table essay
(
    id         bigint auto_increment comment '主键'
        primary key,
    title      varchar(32)          not null comment '随笔标题',
    `describe` varchar(128)         not null comment '随笔副标题',
    cover      varchar(256)         not null comment '随笔封面图片路径',
    content    longtext             not null comment '随笔内容 富文本形式',
    createTime bigint               not null comment '创建日期',
    updateTime bigint               not null comment '更新日期',
    isDelete   tinyint(1) default 0 not null comment '是否删除',
    constraint cover
        unique (cover),
    constraint title
        unique (title)
)
    charset = utf8;

create table message
(
    id         bigint auto_increment comment '主键'
        primary key,
    nickname   varchar(64)          not null comment '昵称',
    email      varchar(128)         not null comment '邮箱',
    content    varchar(256)         not null comment '评论',
    updateTime bigint               not null comment '评论日期',
    status     tinyint(1) default 0 not null comment '状态 0 未审核 1 已过审 -1 被封禁',
    isDelete   tinyint(1) default 0 not null comment '是否删除'
)
    charset = utf8;

create table picture
(
    id         bigint auto_increment comment '主键'
        primary key,
    name       varchar(256)         not null comment '文件名',
    updateTime bigint               not null comment '上传日期',
    isDelete   tinyint(1) default 0 not null comment '是否删除'
)
    charset = utf8;

create table tag
(
    id         bigint auto_increment comment '主键'
        primary key,
    name       varchar(32)          not null comment '标签名',
    updateTime bigint               not null comment '上传日期',
    isDelete   tinyint(1) default 0 not null comment '是否删除',
    constraint name
        unique (name)
)
    charset = utf8;