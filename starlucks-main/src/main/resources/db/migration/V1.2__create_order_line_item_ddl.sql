create table order_line_item
(
    id         bigint unsigned auto_increment comment '식별값',
    order_id   bigint unsigned not null comment '주문 식별값',
    `name`     varchar(32)     not null comment '이름',
    size       varchar(16)     not null comment '사이즈',
    price      int             not null comment '금액',
    create_dtm datetime default current_timestamp comment '생성 일시',
    update_dtm datetime default null comment '수정 일시',
    constraint primary key (id)
) comment '주문 라인 항목';
