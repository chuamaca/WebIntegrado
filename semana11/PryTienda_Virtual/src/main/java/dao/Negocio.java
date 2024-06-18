
package dao;

import beans.Articulo;
import beans.Categoria;
import beans.Cliente;
import beans.Compra;
import interfaces.Itienda;
import java.util.*;
import java.sql.*;
import util.MySQLConexion;

public class Negocio implements Itienda{

    @Override
    public List<Categoria> lisCategoria() {
       List<Categoria> lista=new ArrayList();
      Connection cn=MySQLConexion.getConexion();
      try{
          String sql="select Idcategoria,descripcion,imagen from Categorias";
          PreparedStatement st=cn.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          while(rs.next()){
              Categoria p=new Categoria();
              p.setCodc(rs.getString(1));
              p.setNomc(rs.getString(2));
              p.setImagen(rs.getString(3));
             lista.add(p);
          }
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return lista;
    
    
    }

    @Override
    public List<Articulo> lisArticulo(String id) {
   List<Articulo> lista=new ArrayList();
      Connection cn=MySQLConexion.getConexion();
      try{
          String sql="select IdArticulo,descripcion,imagen,PrecioUnidad,stock"
                  + " from Articulos where idcategoria=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          while(rs.next()){
              Articulo p=new Articulo();
              p.setCoda(rs.getString(1));
              p.setNomart(rs.getString(2));
              p.setImagen(rs.getString(3));
              p.setPrecio(rs.getDouble(4));
              p.setStk(rs.getInt(5));
             lista.add(p);
          }
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return lista;
    }

    @Override
    public Articulo busArticulo(String id) {
       Articulo p=null;
      Connection cn=MySQLConexion.getConexion();
      try{
          String sql="select IdArticulo,descripcion,imagen,PrecioUnidad,stock"
                  + " from Articulos where idArticulo=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Articulo();
              p.setCoda(rs.getString(1));
              p.setNomart(rs.getString(2));
              p.setImagen(rs.getString(3));
              p.setPrecio(rs.getDouble(4));
              p.setStk(rs.getInt(5));
           }
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return p; 

    }

    @Override
    public Cliente busCliente(String usr, String pas) {
      Cliente p=null;
      Connection cn=MySQLConexion.getConexion();
      try{
          String sql="select Nombres,apellidos "
                  + " from clientes where Idcliente=? and password=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, usr);
          st.setString(2, pas);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Cliente();
              p.setCodc(usr);
              p.setApe(rs.getString(2));
              p.setNom(rs.getString(1));
               }
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return p; 
 }

    @Override
    public String grabaFactura(List<Compra> lista, String codc) {
     String fac="";
     double smt=0;
     for(Compra x:lista)smt=smt+x.total();
     Connection cn=MySQLConexion.getConexion();
     try{
         CallableStatement st=cn.prepareCall("{call spfactura(?,?)}");
         st.setString(1, codc);
         st.setDouble(2,smt);
         ResultSet rs=st.executeQuery();
         rs.next();
         fac=rs.getString(1);
          CallableStatement st2=cn.prepareCall("{call spdetalle(?,?,?)}");
          for(Compra c:lista){
              st2.setString(1, fac);
              st2.setString(2, c.getCoda());
              st2.setInt(3, c.getCantidad());
              st2.executeUpdate();
          } 
     }catch(Exception ex){
       ex.printStackTrace();
     }
    
    return fac;
    }
    
}
