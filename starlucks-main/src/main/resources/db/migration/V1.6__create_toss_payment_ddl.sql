create table toss_payment
(
    id         bigint unsigned auto_increment comment '식별값',
    toss_id    varchar(191) not null comment '토스 식별값',
    create_dtm datetime default current_timestamp comment '생성 일시',
    update_dtm datetime default null comment '수정 일시',
    constraint primary key (id)
) comment '토스 결제';
