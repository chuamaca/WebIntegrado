DROP DATABASE IF EXISTS bdTienda2;
CREATE DATABASE bdTienda2;
USE bdTienda2;


CREATE TABLE  articulos (
  IdArticulo char(5) NOT NULL  PRIMARY KEY,
  Descripcion varchar(45) ,
  PrecioUnidad numERIC(6,1) NOT NULL ,
  Stock integer  );  

 
INSERT INTO ARTICULOS VALUES('POL01','Sweat Capuche Molleton Blanc ',34,20) ;
INSERT INTO ARTICULOS VALUES('CHA02','Zip Chaqueta Rayada Ultra3',88,21) ;
INSERT INTO ARTICULOS VALUES('CHA03','Zip Chaqueta Negro Azulado',128,20) ;
INSERT INTO ARTICULOS VALUES('CHA01','Zip Chaqueta AUL',188,10) ;
INSERT INTO ARTICULOS VALUES('POL02','Pull Col Rond Ultra Coton Cuello',36,12);  
INSERT INTO ARTICULOS VALUES('POL03','Pull Col Rond Ultra Coton Gris',56,12)  ;
INSERT INTO ARTICULOS VALUES('MAL01','Bolsa Deporte Con Ruedas',49,10) ; 
INSERT INTO ARTICULOS VALUES('ZAP01','Zapatillas Euro ',80,10)  ;
INSERT INTO ARTICULOS VALUES(' R01',' rro Umbro azul ',30,10)  ;
INSERT INTO ARTICULOS VALUES('PAN01','Pantalones De Vellón Used ',22,13);  
INSERT INTO ARTICULOS VALUES('PAN02','Pantalones Urban ',39,14)  ;
INSERT INTO ARTICULOS VALUES(' R02','Bonnet Tricot Noir ',15,11)  ;

 
  

CREATE TABLE  clientes (
   tarjeta char(5) NOT NULL  primary key ,
  nombre varchar(30) NOT NULL  ,
  credito  numERIC(8,1),
  PassWord varchar(15) NOT NULL 
  
);   

 
INSERT INTO clientes VALUES('11111', 'Anacleto Calderon , Juan', 2000, '123456') ;  
INSERT INTO clientes VALUES('22222', 'Vilchez Cardenas , Ana', 1300, 'alfa')  ;
INSERT INTO clientes VALUES('33333', 'Ramos Villar,Colonia', 1600, 'beta')  ;

  

  
 

CREATE TABLE faccab (
  NroFactura char(8) NOT NULL,
  FechaFactura date NOT NULL  ,
  tarjeta char(5) NOT NULL ,
  MontoTotal numeric(10,2) NOT NULL  ,
  PRIMARY KEY (NroFactura)
);   

 

CREATE TABLE  facdet (
  NroFactura char(8) NOT NULL ,
  IdArticulo char(5) NOT NULL  ,
   Cantidad integer NOT NULL ,
   primary key(Nrofactura,Idarticulo)
) ;  

 
select * from articulos