drop table if exists contact;

create table contact (
  id long auto_increment primary key,
  first_name varchar(32),
  last_name varchar(32),
  birth_date date
);