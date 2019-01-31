insert into customer (id,name,address,city,telephone) values (1, 'Cliente 1','Centro','Medellin','3129993339');
insert into customer (id,name,address,city,telephone) values (2, 'Cliente 2','Centro','Medellin','3129993335');

insert into card (id,number,ccv,fk_customer) values (1, '831282',123,1);
insert into card (id,number,ccv,fk_customer) values (2, '931282',124,1);

insert into consume (id,date,description,amount,fk_card) values (1, '2017-02-01 12:00:05','Gasto por compras',10000,1);
insert into consume (id,date,description,amount,fk_card) values (2, '2017-02-01 12:00:05','Pago servicios',20000,1);
insert into consume (id,date,description,amount,fk_card) values (3, '2017-02-01 12:00:05','Pago mercancia',30000,1);
