create table member(
    id int(10) NOT NULL AUTO_INCREMENT,
    nickname varchar(20) NOT NULL,
    email varchar(20) NOT NULL,
    password varchar(30) NOT NULL,
    CONSTRAINT primary key(id)
);