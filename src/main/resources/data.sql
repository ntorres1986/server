insert into customer (id,name,address,city,telephone) values (1, 'Cliente 1','Centro','Medellin','3129993339');
insert into customer (id,name,address,city,telephone) values (2, 'Cliente 2','Centro','Medellin','3129993335');


insert into card (id,number,ccv,card_type,fk_customer) values (1, '831282',123,'Debito',1);
insert into card (id,number,ccv,card_type,fk_customer) values (2, '931282',124,'Credito',1);

insert into consume (id,date,description,amount,fk_card) values (1, '2017-02-01 12:00:05','Gasto por compras',10000,1);
insert into consume (id,date,description,amount,fk_card) values (2, '2017-02-01 12:00:05','Pago servicios',20000,1);
insert into consume (id,date,description,amount,fk_card) values (3, '2017-02-01 12:00:05','Pago mercancia',30000,1);

insert into adviser (id,name,specialty) values (1, 'Juan David Ramirez','Cajero');
insert into adviser (id,name,specialty) values (2, 'Andrea Castaño','Contabilidad');
insert into adviser (id,name,specialty) values (3, 'Cristian Camilo','Asesor');
