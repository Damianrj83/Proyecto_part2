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

create table main_empresa (
  id                            bigint auto_increment not null,
  buscar                        varchar(255),
  constraint pk_main_empresa primary key (id)
);

create table profesional (
  id                            bigint auto_increment not null,
  create_account_id             bigint,
  due_date                      datetime(6),
  cedula                        varchar(255),
  nombre                        varchar(255),
  apellido1                     varchar(255),
  apellido2                     varchar(255),
  genero                        tinyint(1) default 0,
  nacionalidad                  varchar(255),
  lugar_residencia              varchar(255),
  direccion_exacta              varchar(255),
  telefono1                     varchar(255),
  telefono2                     varchar(255),
  nivel_academico               varchar(255),
  tipo_de_colegio               varchar(255),
  estudia                       varchar(255),
  ano_titulo                    varchar(255),
  nombre_titulo                 varchar(255),
  institucion_titulo            varchar(255),
  salario_aspirar               varchar(255),
  residencia_preferida          varchar(255),
  experiencia_laboral           varchar(255),
  constraint uq_profesional_create_account_id unique (create_account_id),
  constraint pk_profesional primary key (id)
);

alter table profesional add constraint fk_profesional_create_account_id foreign key (create_account_id) references create_account (id) on delete restrict on update restrict;


# --- !Downs

alter table profesional drop foreign key fk_profesional_create_account_id;

drop table if exists create_account;

drop table if exists cuenta;

drop table if exists empresa;

drop table if exists main_empresa;

drop table if exists profesional;

