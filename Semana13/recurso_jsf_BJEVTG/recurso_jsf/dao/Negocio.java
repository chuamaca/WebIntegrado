package dao;
//se realiza todas las operaciones que se van a ejecutar en las
// paginas jsp
import java.sql.*;
import java.util.*;
import beans.*;
import util.MySQLConexion;
public class Negocio {
 public List<Alumno> LisAlu(){
 List<Alumno> lista=new ArrayList();
 String sql="select idalumno, apealumno, nomalumno from alumno";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
      Alumno a=new Alumno(rs.getString(1),rs.getString(2),rs.getString(3));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }  
 
 public List<Especialidad> LisESp(){
 List<Especialidad> lista=new ArrayList();
 String sql="select idesp, nomesp from especialidad";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
      Especialidad a=new Especialidad(rs.getString(1),rs.getString(2));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }  
 
 //busqueda de un alumno por codigo
 public Alumno BusAlu(String cod){
 Alumno a=null;
 String sql="select idalumno, apealumno, nomalumno from alumno where idalumno=?";
 try{
  PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
  st.setString(1, cod);
  ResultSet  rs=st.executeQuery();
  if(rs.next()){
       a=new Alumno(rs.getString(1),rs.getString(2),rs.getString(3));
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return a;
 }  
 
 public void graba(Alumno a){
    String sql="{call spAdiAlu(?,?,?,?)}";
 try{
  CallableStatement st=MySQLConexion.getConexion().prepareCall(sql);
  st.setString(1, a.getApe());
  st.setString(2, a.getNoma());
  st.setString(3, a.getCodes());
  st.setString(4, a.getColegio());
  st.executeUpdate();
 }catch(SQLException  ex){
   ex.printStackTrace();
 } 
     
     
     
 }
 /////////////////////////
 
 //listar los pagos de un alumno 
 public List<Pagos> LisPago(String cod){
 List<Pagos> lista=new ArrayList();
 String sql="select ciclo, fecha,monto from Pagos where idalumno=?";
 try{
 PreparedStatement st=MySQLConexion.getConexion().prepareStatement(sql);
   st.setString(1, cod);
  ResultSet  rs=st.executeQuery();
  while(rs.next()){
      Pagos a=new Pagos(rs.getString(1),rs.getString(2),rs.getDouble(3));
      lista.add(a);
  }
 }catch(SQLException  ex){
   ex.printStackTrace();
 }
 return lista;
 }   
 
 
}
