/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.MVentas;
import Model.MVentasAnio;
import Model.MVentasArticulo;
import Util.MySQLConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Cesar
 */
public class Dventas {
    
    private static String SQL_SP = "{call spmes(?)}";
     private static String SQL_VENTAARTICULO_SP = "{call sptopsixok(?)}";
       private static String SQL_VENTA_ANIO_SP = "{call ventasanio(?)}";

  
    public List<MVentas> Select(int anio) {
        
        System.out.println("select " + anio);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MVentas ventas = null;
        List<MVentas> listaventas = new ArrayList<>();

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement st=conn.prepareCall(SQL_SP);
            st.setInt(1, anio);
            
            rs=st.executeQuery();
      
            while (rs.next()) {
           
                ventas = new MVentas();
                ventas.setMes(rs.getInt(1));
                ventas.setMonto(rs.getDouble(2));
         

                listaventas.add(ventas);
            }
            
            System.out.println("listaventas:" +  listaventas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
           
        }

        return listaventas;
    }
    
     public List<MVentasArticulo> SelectVentasArticulo(int anio) {
        
        System.out.println("select " + anio);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MVentasArticulo ventas = null;
        List<MVentasArticulo> listaventas = new ArrayList<>();

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement st=conn.prepareCall(SQL_VENTAARTICULO_SP);
            st.setInt(1, anio);
            
            rs=st.executeQuery();
      
            while (rs.next()) {
           
                ventas = new MVentasArticulo();
                ventas.setArt_nom(rs.getString(1));
                ventas.setArt_can(rs.getInt(2));
         

                listaventas.add(ventas);
            }
            
            System.out.println("listaventas:" +  listaventas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
           
        }
        return listaventas;
    }
     
      public List<MVentasAnio> SelectVentasAnio() {
        
       
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MVentasAnio ventas = null;
        List<MVentasAnio> listaventas = new ArrayList<>();

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement st=conn.prepareCall(SQL_VENTA_ANIO_SP);
            rs=st.executeQuery();
            while (rs.next()) {
           
                ventas = new MVentasAnio();
                ventas.setAnio(rs.getInt(1));
                ventas.setCantidad(rs.getInt(2)); 
                listaventas.add(ventas);
            }
            
            System.out.println("listaventas:" +  listaventas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
           
        }
        return listaventas;
    }
}
