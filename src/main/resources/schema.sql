CREATE TABLE IF NOT EXISTS photos (
    id bigint primary key not null AUTO_INCREMENT,
    file_name varchar(255),
    content_type varchar(255),
    data binary LARGE OBJECT
);