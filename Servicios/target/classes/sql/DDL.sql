-- Active: 1716665739087@servicios

drop database if exists servicios;
create database servicios;
use servicios;
drop table if exists clientes;

create table clientes(
    id int auto_increment primary key,
    apellido varchar(25) not null check(length(apellido)>=2),
    nombre varchar(25) not null check(length(nombre)>=2),  
    edad int not null check(edad>=18 and edad<=120),
    email varchar(50) not null,
    telefono varchar (25),
    activo boolean default true
);

drop table if exists servicios;

create table servicios (
    id int auto_increment primary key,
    nombre varchar(50) not null,
    descripcion varchar(200),
    tipo varchar (50) not null check(tipo in('Programación', 'Comunicación')),
    cliente_id int,
    activo boolean default true
);

alter table servicios
    add constraint FK_Servicios_Clientes
    foreign key (id) 
    references clientes(id)
    on update cascade
    on delete restrict;

drop table if exists productos;

create table productos (
    id int auto_increment primary key,
    nombre varchar(50) not null,
    precio double not null,
    stock int not null,
    activo boolean default true
);

alter table productos
add constraint FK_Productos_Clientes
Foreign Key (id)
references clientes(id)
on update cascade
on delete restrict;

drop table if exists empleados;

create table empleados (
    id int auto_increment primary key,
    apellido varchar(25) not null check(length(apellido)>=2), 
    nombre varchar(25) not null,
    salario double not null,
    fecha_contrato date not null,
    activo boolean default true
);
