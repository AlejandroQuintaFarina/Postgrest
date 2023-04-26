-- alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table if exists produtos  cascade;

drop type if exists public.cid cascade;

CREATE TYPE public.cid AS
(
cidade varchar(25),
cp integer
);

create table produtos(
codigo varchar(3),
descricion varchar(17),
prezo numeric(6,2),
ci public.cid,
primary key (codigo));

show datestyle;
set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;


insert into produtos values ('p1','mistos',4,('vigo',3)::public.cid);
insert into produtos values ('p2','casas',4,('ourense',4));
select *  from produtos;
select ci from produtos;
select (ci).cidade from produtos;

