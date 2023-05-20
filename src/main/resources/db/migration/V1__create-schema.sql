create table thing(id number(19) primary key not null , name varchar2(255)  not null , amount number(10) not null);
create sequence thing_seq minvalue 1 start with 1 nocache nocycle;