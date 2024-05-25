# Eliminando objetos si ya existen
DROP DATABASE IF EXISTS bdTienda;
CREATE DATABASE bdTienda;
USE bdTienda;
CREATE TABLE  articulos (
  IdArticulo char(6) NOT NULL ,
  IdCategoria char(5) NOT NULL ,
  Descripcion varchar(30) NOT NULL,
  PrecioUnidad decimal(8,1) NOT NULL ,
  Stock int  NOT NULL ,
  Imagen varchar(30) NOT NULL ,
  PRIMARY KEY (IdArticulo)
)  ;

INSERT INTO articulos VALUES('ART01', 'CAT01', 'Delicia de Fresa', '26', '20', 'TRT253_ch.jpg');  
INSERT INTO articulos VALUES('ART02', 'CAT01', 'Torta Regalo para el', '19', '15', 'TRT242_ch.jpg');  
INSERT INTO articulos VALUES('ART03', 'CAT01', 'Paquete para fiestas Infantile', '94', '15', 'TRT166_ch.jpg');  
INSERT INTO articulos VALUES('ART04', 'CAT01', 'Tres leches de Lucuma', '16', '16', 'TRT419_ch.jpg');  
INSERT INTO articulos VALUES('ART05', 'CAT01', 'Merengado Capuccino', '16', '18', 'TRT417_ch.jpg');  
INSERT INTO articulos VALUES('ART06', 'CAT01', 'Torta de Nuez', '16', '15', 'TRT259_ch.jpg');  
INSERT INTO articulos VALUES('ART07', 'CAT01', 'Merengado de Lucuma', '19', '19', 'CLA040_ch.jpg');  
INSERT INTO articulos VALUES('ART09', 'CAT01', 'Torta de Durazno', '18', '25', 'TRT467_ch.gif');  
INSERT INTO articulos VALUES('ART10', 'CAT02', 'Arreglo es una ni', '34', '25', 'FLR308_ch.jpg');  
INSERT INTO articulos VALUES('ART11', 'CAT02', 'Topiario de Girasoles', '29', '30', 'flr015_ch.jpg');  
INSERT INTO articulos VALUES('ART12', 'CAT02', 'Arreglo Andalucia', '19', '35', 'ROS069_ch.jpg');  
INSERT INTO articulos VALUES('ART13', 'CAT02', 'Arreglo Corazon x 6 rosas', '34', '30', 'FLR500_ch.jpg');  
INSERT INTO articulos VALUES('ART14', 'CAT02', 'Arreglo Torre de Amor', '26', '25', 'FLR212_ch.jpg');  
INSERT INTO articulos VALUES('ART15', 'CAT02', 'Arreglo CopaCabana', '29', '20', 'ROS071_ch.jpg');  
INSERT INTO articulos VALUES('ART16', 'CAT02', 'Arreglo Corazon Apasionado', '62', '35', 'FLR508_ch.jpg');  
INSERT INTO articulos VALUES('ART17', 'CAT02', 'Caja de Docenas de Rosas', '25', '30', 'FLR394_ch.jpg');  
INSERT INTO articulos VALUES('ART18', 'CAT02', 'Arreglo x 10 Rosas', '56', '30', 'FLR517_ch.jpg');  
INSERT INTO articulos VALUES('ART08', 'CAT01', 'Torta de Durazno', '18', '32', 'TRT467_ch.gif');  
INSERT INTO articulos VALUES('ART19', 'CAT03', 'Ralph Lauren Ralph Cool 100ml', '75', '30', 'per020_ch.jpg');  
INSERT INTO articulos VALUES('ART20', 'CAT03', 'Tous - Tous Edt 50 ml', '60', '15', 'PER028_CH.jpg');  
INSERT INTO articulos VALUES('ART21', 'CAT03', 'Givenchy Very Irresistible Sen', '73', '20', 'PER279_ch.jpg');  
INSERT INTO articulos VALUES('ART22', 'CAT03', 'Adidas for Women - Fresh Vibes', '13', '105', 'PER271_ch.jpg');  
INSERT INTO articulos VALUES('ART23', 'CAT03', 'Christian Dior Miss Dior Highe', '67', '10', 'PER284_ch.JPG');  
INSERT INTO articulos VALUES('ART24', 'CAT03', 'Beneton UCB 06 Man Edt 75 Ml', '42', '20', 'PER294_ch.jpg');  
INSERT INTO articulos VALUES('ART25', 'CAT03', 'Escada Magnetism Edp 75 ML Vap', '89', '22', 'per286_ch.jpg');  
INSERT INTO articulos VALUES('ART26', 'CAT03', 'Elizabeth Arden Provocative In', '58', '25', 'PER300_ch.jpg');  
INSERT INTO articulos VALUES('ART27', 'CAT03', 'Swiss Army Altitude Edt 100 Ml', '59', '30', 'PER305_ch.jpg');  




CREATE TABLE categorias (
  IdCategoria char(5) NOT NULL  ,
  Descripcion varchar(30) NOT NULL  ,
  Imagen varchar(30) ,
  PRIMARY KEY (IdCategoria)
);  


INSERT INTO categorias VALUES('CAT01', 'Pasteles y Tortas', 'ofe_TRT13.jpg') ; 
INSERT INTO categorias VALUES('CAT02', 'Flores', 'ofe_flr07.jpg')  ;
INSERT INTO categorias VALUES('CAT03', 'Perfumes', 'ofe_per06.jpg')  ;
INSERT INTO categorias VALUES('CAT04', 'Libros', 'ofe_lib05.jpg')  ;
INSERT INTO categorias VALUES('CAT05', 'Juguetes', 'ofe_jug05.jpg')  ;
INSERT INTO categorias VALUES('CAT06', 'Entretenimiento Familiar', 'FIE004_gr.jpg')  ;




CREATE TABLE  clientes (
  IdCliente char(8) NOT NULL ,
  Apellidos varchar(30) NOT NULL  ,
  Nombres varchar(30) NOT NULL  ,
  Direccion varchar(30) NOT NULL  ,
  Email varchar(30) NOT NULL  ,
  Edad int NOT NULL ,
  PassWord char(8) NOT NULL ,
  PRIMARY KEY (IdCliente)
);  



INSERT INTO clientes VALUES('CLI00001', 'Vera Perez', 'Alberto', 'AV.AREQUIPA 190', 'perez@yahoo.es', '39', '123456');  
INSERT INTO clientes VALUES('CLI00002', 'Aliaga Mendez', 'Carlos', 'AV.AREQUIPA 567', 'pdiaz@yahoo.es', '23', 'alfa') ; 
INSERT INTO clientes VALUES('CLI00003', 'Castro Diaz', 'Ricardo', 'AV.AREQUIPA 1045', 'jmendez@yahoo.es', '25', 'omega');  



CREATE TABLE faccab (
  NroFactura char(8) NOT NULL,
  FechaFactura datetime NOT NULL  ,
  IdCliente char(8) NOT NULL ,
  MontoTotal decimal(10,0) NOT NULL  ,
  PRIMARY KEY (NroFactura)
) ; 




CREATE TABLE  facdet (
  NroFactura char(8) NOT NULL ,
  IdArticulo char(6) NOT NULL  ,
   Cantidad int NOT NULL ,
   primary key(Nrofactura,Idarticulo)
); 


select * from articulos;
