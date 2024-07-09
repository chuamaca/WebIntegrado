package dao;
//se realiza todas las operaciones que se van a ejecutar en las
// paginas jsp
import java.sql.*;
import java.util.*;
import beans.*;
import util.MySQLConexion;
public class Negocio {
 public List<Cliente> LisCli(){
 List<Cliente> lista=new ArrayList();
 String sql="select cli_cod, cli_nom, cli_cre from clientes";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
     Cliente a=new Cliente(rs.getString(1),rs.getString(2),rs.getDouble(3));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }  
  public List<Facturas> LisFac(String id){
 List<Facturas> lista=new ArrayList();
 String sql="select Fac_num, Fac_fec, Fac_igv from fac_cabe where cli_cod=?";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  st.setString(1, id);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
     Facturas a=new Facturas(rs.getString(1),rs.getString(2),rs.getString(3));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }  
  public List<Detalle> LisDeta(String id){
 List<Detalle> lista=new ArrayList();
 String sql="select A.art_cod,Art_nom, art_pre, art_can from fac_deta d , articulos a where d.art_cod=a.art_cod and fac_num=?";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  st.setString(1, id);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
     Detalle a=new Detalle(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }  
 
 
 
}
