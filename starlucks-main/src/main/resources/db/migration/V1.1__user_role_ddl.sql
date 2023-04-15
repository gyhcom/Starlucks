-- Member Role 추가
alter table member ADD COLUMN role varchar(20) not null comment '권한';