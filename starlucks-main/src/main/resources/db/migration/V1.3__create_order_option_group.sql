create table order_option_group
(
    id                 bigint unsigned auto_increment comment '식별값',
    order_line_item_id bigint unsigned not null comment '주문 라인 항목 식별값',
    `name`             varchar(32)     not null comment '이름',
    create_dtm         datetime default current_timestamp comment '생성 일시',
    update_dtm         datetime default null comment '수정 일시',
    constraint primary key (id)
) comment '주문 옵션 그룹';
