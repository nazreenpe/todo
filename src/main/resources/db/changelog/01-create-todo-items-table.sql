--liquibase formatted sql

--changeset nasreen:1

create table todo_items (
    id varchar (36),
    title varchar (256),
    item_order int ,
    completed boolean ,
    created_at timestamp with time zone ,
    updated_at timestamp with time zone
);

--rolback DELETE TABLE todo_items