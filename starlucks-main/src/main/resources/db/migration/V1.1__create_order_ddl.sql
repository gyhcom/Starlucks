create table `order`
(
    id          bigint unsigned auto_increment comment '식별값',
    store_id    bigint unsigned not null comment '매장 식별값',
    member_id   bigint unsigned not null comment '회원 식별값',
    payment_id  bigint unsigned not null comment '결제 식별값',
    total_price int unsigned comment '총 금액',
    `status`    varchar(32)     not null default 'WAIT' comment '상태',
    create_dtm  datetime                 default current_timestamp comment '생성일시',
    update_dtm  datetime                 default null comment '수정일시',
    constraint primary key (id)
) comment '주문';
