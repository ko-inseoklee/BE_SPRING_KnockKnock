create table user (
    id int primary key auto_increment,
    email varchar(30),
    name varchar(10),
    phone_number varchar(15),
    password varchar(255),
    nickname varchar(15),
    birth int,
    sex varchar(5),
    job varchar(15)
);

create table matching_age (
    age_id int,
    matching_id int,
    requirement_age int,
    primary key (age_id,matching_id)
);


create table matching (
    id int primary key auto_increment,
    title varchar(20),
    topic varchar(10),
    creator int,
    participant int,
    created_time DATE
)

ALTER TABLE knockknock.matching MODIFY COLUMN id int(11) auto_increment NOT NULL;
ALTER TABLE knockknock.matching_age MODIFY COLUMN age_id int(11) auto_increment NOT NULL;



create table phone_auth (
    id int primary key auto_increment,
                            phone_number varchar(20)   not null,
                            auth_code         varchar(10)   not null,
                            sending_time timestamp not null
);