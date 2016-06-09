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

create table cuenta (
  id                            bigint auto_increment not null,
  contrasena_actual             varchar(255),
  nueva_contrasena              varchar(255),
  repetir                       varchar(255),
  constraint pk_cuenta primary key (id)
);

create table empresa (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  cfi                           varchar(255),
  tipo_empresa                  varchar(255),
  descripcion                   varchar(255),
  constraint pk_empresa primary key (id)
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

create table main_empresa (
  id                            bigint auto_increment not null,
  buscar                        varchar(255),
  constraint pk_main_empresa primary key (id)
);

create table profesional (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  apellido1                     varchar(255),
  apellido2                     varchar(255),
  genero                        tinyint(1) default 0,
  fecha_nacimiento              varchar(255),
  nacionalidad                  varchar(255),
  lugar_residencia              varchar(255),
  direccion_exacta              varchar(255),
  telefono1                     varchar(255),
  telefono2                     varchar(255),
  constraint pk_profesional primary key (id)
);


# --- !Downs

drop table if exists create_account;

drop table if exists cuenta;

drop table if exists empresa;

drop table if exists estudiante;

drop table if exists login;

drop table if exists main_empresa;

drop table if exists profesional;

