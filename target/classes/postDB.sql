create table Pakage(
    package_name      varchar(25) primary key,
    price          decimal(10,2),
    package_number    int
)engine = InnoDB;

create table Unit(
 unit_name          varchar(25) primary key
)engine = InnoDB;

create table Post_office(
  package_name    varchar(25),
  unit_name    varchar(25) ,
  number       int
) engine=InnoDB;

create table User_account(
id_account           int primary key,
ordertime           time,
id_curler          int
)engine = InnoDB;

create table Package_and_User(
package_name   varchar(25),
id_table  int,
order_amount  decimal(10,3)
) engine = InnoDB;

create table Curler(
id_curler   int primary key,
name        varchar(10),
lastname    varchar(10)
)engine=InnoDB;
/***************************/
alter table Post_office
add constraint fk_post_office_package
foreign key (package_name)
references Pakage (package_name)
on delete cascade on update set null;

alter table Post_office
add constraint fk_post_office_unit
foreign key (unit_name)
references Unit (unit_name)
on delete cascade on update set null;


alter table User_account
add constraint fk_table_curler
foreign key (id_curler)
references Curler  (id_curler)
on delete cascade on update set null;

alter table Package_and_User
add constraint fk_order_account
foreign key (id_account)
references User_account (id_account)
on delete cascade on update set null;

alter table Package_and_User
add constraint fk_order_package
foreign key (package_name)
references Pakage (package_name)
on delete cascade on update set null;
