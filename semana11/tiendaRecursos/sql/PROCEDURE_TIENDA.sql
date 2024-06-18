
USE BDTIENDA;
DELIMITER @@
DROP PROCEDURE IF EXISTS SPdetalle @@
CREATE PROCEDURE SPdetalle(fac CHAR(8), coda char(6),  can int)
BEGIN
insert into facdet values (fac,coda, can);
update articulos set stock= stock -can where idarticulo=coda;
END@@

DROP PROCEDURE IF EXISTS SPFACTURA @@
CREATE PROCEDURE SPFACTURA(in codc char(8),in tot numeric(8,1))
BEGIN
declare nro int;
declare fac char(8);
select ifnull(max(nrofactura),0) + 1  from faccab into nro;
set fac = lpad(nro,8,'0');
insert into faccab values (fac,current_date(),codc,tot);
select fac;
END@@
DELIMITER ;
