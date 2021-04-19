# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

<<<<<<< HEAD
=======
create table project (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  constraint pk_project primary key (id)
);

>>>>>>> origin/test
create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

<<<<<<< HEAD
=======
drop table if exists project;

>>>>>>> origin/test
drop table if exists user;

