-- Member Role 추가
alter table member ADD COLUMN role varchar(100) not null comment '권한';