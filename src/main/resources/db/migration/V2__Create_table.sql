create table my_db.employees(
                                id int not null auto_increment primary key,
                                name varchar(50) not null,
                                surname varchar(50) not null,
                                department varchar(50) not null,
                                salary int not null);