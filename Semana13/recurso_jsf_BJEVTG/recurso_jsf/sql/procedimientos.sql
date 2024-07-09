Procedure simple
DROP procedure IF EXISTS bdnotas.spnota;
create procedure bdnotas.spnota(cod char(5))
select c.idcurso, nomcurso, exaparcial, exafinal
from curso c inner join notas n
on c.idcurso=n.idcurso where idalumno=cod;

--ejecutar el procedure
call bdnotas.spnota("A0005");
select right(max(idalumno),4)+1 from bdnotas.alumno;
--generar el codigo y del alumno e insertar
drop procedure if exists bdnotas.adicion;

delimiter @@
create procedure bdnotas.spAdiAlu(ape varchar(30),nom varchar(30), esp char(3),
pro char(1))
begin
declare cuenta int;
declare coda char(5);
select right(max(idalumno),4)+1 into cuenta from bdnotas.alumno;
set coda=concat("A",lpad(cuenta,4,'0'));
insert into alumno values(coda,ape,nom,esp,pro);
end @@
delimiter;

call bdnotas.spAdiAlu("Pantaleon","Juan","E02","N");

SELECT*FROM BDNOTAS.alumno;
