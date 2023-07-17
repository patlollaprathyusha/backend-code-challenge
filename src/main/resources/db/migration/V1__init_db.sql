create table User
(
    id        bigint              not null primary key,
    firstName varchar(255)        not null,
    lastName  varchar(255)        not null,
    username  varchar(255) unique not null,
    password  varchar(255)        not null -- WHAT!? NOT ENCRYPTED!? ;-)
);

insert into User
    (id, firstName, lastName, username, password)
values (1, 'Phil', 'Ingwell', 'PhilIngwell', 'Password123') ,
    (2, 'Anna', 'Conda', 'AnnaConda', 'Password234');

create table Address
(
    id        bigint              not null primary key,
    address1 varchar(255)        not null,
    address2  varchar(255)        ,
    city  varchar(255)            not null,
    state  varchar(100)        not null,
    postal  varchar(10)        not null

);

insert into Address
    (id, address1, address2, city, state,postal)
values (1, '1417 Timberwolf Dr', null, 'Holland', 'Ohio','43528') ,
    (2, 'Dr', 'Apt 102', 'Fort Worth', 'Texas','76006');


ALTER table User ADD column  addressId long ;
ALTER table User ADD FOREIGN KEY(addressId)  REFERENCES Address(id);

UPDATE USER set addressId =1 where id=1;
UPDATE USER set addressId =2 where id=2;
