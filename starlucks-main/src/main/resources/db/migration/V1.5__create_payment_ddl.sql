create table payment
(
    id           bigint unsigned auto_increment comment '식별값',
    order_id     bigint unsigned not null comment '주문 식별값',
    amount       bigint unsigned not null comment '금액',
    payment_type varchar(32)     not null comment '결제 구분',
    create_dtm   datetime default current_timestamp comment '생성 일시',
    update_dtm   datetime default null comment '수정 일시',
    constraint primary key (id)
) comment '결제';
