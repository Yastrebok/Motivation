create schema 'motivation';

create table user
(
  user_id   int auto_increment
    primary key,
  password  int          null,
  age       int          null,
  email     varchar(255) null,
  user_name varchar(255) null
)
  engine = MyISAM;

create table subject
(
  subject_id   int auto_increment
    primary key,
  rate         int          null,
  subject_name varchar(255) null
)
  engine = MyISAM;

create table multiplier
(
  id         int auto_increment
    primary key,
  rate       int not null,
  mark       int not null,
  multiplier int not null,
  constraint multiplier_id_uindex
  unique (id)
)
  engine = InnoDB;

create table marks_data
(
  id         int auto_increment,
  subject_id int                                 not null,
  rate       int                                 not null,
  mark       int                                 not null,
  user_id    int                                 not null,
  date       timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  constraint subject_id_uindex
  unique (id)
)
  engine = InnoDB;
