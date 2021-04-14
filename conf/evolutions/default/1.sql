# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table project (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  constraint pk_project primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists project;

drop table if exists user;

