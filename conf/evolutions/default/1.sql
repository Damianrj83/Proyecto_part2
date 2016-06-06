# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table create_account (
  id                            bigint auto_increment not null,
  contrasena                    varchar(255),
  email                         varchar(255),
  tipo_usuario                  varchar(255),
  constraint pk_create_account primary key (id)
);

create table estudiante (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  carnet                        varchar(255),
  correo                        varchar(255),
  constraint pk_estudiante primary key (id)
);

create table login (
  id                            bigint auto_increment not null,
  contrasena                    varchar(255),
  email                         varchar(255),
  constraint pk_login primary key (id)
);


# --- !Downs

drop table if exists create_account;

drop table if exists estudiante;

drop table if exists login;

