use bdnotas;
DROP PROCEDURE  if exists spadiAlu ;
DELIMITER //
CREATE PROCEDURE spadiAlu
(ape varchar(30),nom varchar(30),es char(3), pro char(1))
begin
declare coda char(5);
declare cuenta int;
select right(max(idalumno),4)+1 into cuenta from alumno;
set coda=concat('A',Lpad(cuenta,4,'0'));
insert into alumno values(coda, ape,nom,es,pro);
end //
DELIMITER ; 

DROP PROCEDURE  if exists spModiAlu ;
CREATE PROCEDURE spModiAlu
(coda char(5),ape varchar(30),nom varchar(30),es char(3), pro char(1))
update alumno set apealumno=ape,nomalumno=nom, idesp=es,
   proce=pro where idalumno=coda;

DROP PROCEDURE  if exists spDelAlu ;

CREATE PROCEDURE spDelAlu(coda char(5))
delete from alumno where idalumno=coda;

DROP PROCEDURE  if exists spnota ;
CREATE PROCEDURE spnota(coda char(5))

select c.idcurso,c.nomcurso,exaparcial, exafinal
from curso c, notas n where c.idcurso=n.idcurso
and idalumno=coda;


 
