package dao;

import interfaces.Itienda;
import java.util.*;
import java.sql.*;
import modelo.Articulo;
import modelo.Cliente;
import modelo.FacturaDetalle;
import util.MySQLConexion;

public class Negocio implements Itienda {

    @Override
    public List<Articulo> lisArticulo(String id) {
        List<Articulo> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select IdArticulo ,Descripcion , PrecioUnidad , Stock  from articulos";
            PreparedStatement st = cn.prepareStatement(sql);
      
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Articulo p = new Articulo();

                /*
              CREATE TABLE  articulos (
  IdArticulo char(5) NOT NULL  PRIMARY KEY,
  Descripcion varchar(45) ,
  PrecioUnidad numERIC(6,1) NOT NULL ,
  Stock integer  );*/
                p.setIdArticulo(rs.getString(1));
                p.setDescripcion(rs.getString(2));
                p.setPrecioUnidad(rs.getDouble(3));
                p.setStock(rs.getInt(4));

                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Articulo busArticulo(String id) {
        Articulo p = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select IdArticulo ,Descripcion , PrecioUnidad , Stock  from articulos a where IdArticulo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Articulo();
                p.setIdArticulo(rs.getString(1));
                p.setDescripcion(rs.getString(2));
                p.setPrecioUnidad(rs.getDouble(3));
                p.setStock(rs.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;

    }

    @Override
    public Cliente busCliente(String usr, String pas) {
        Cliente p = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select tarjeta , nombre , credito from clientes where tarjeta=? and PassWord=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, usr);
            st.setString(2, pas);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Cliente();
                p.setTarjeta(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setCredito(rs.getDouble(3));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public String grabaFactura(List<FacturaDetalle> lista, String tarjeta) {
        String fac = "";
        double smt = 0;
        for (FacturaDetalle x : lista) {
            smt = smt + x.total();
        }
        Connection cn = MySQLConexion.getConexion();
        try {
            CallableStatement st = cn.prepareCall("{call spfactura(?,?)}");
            st.setString(1, tarjeta);
            st.setDouble(2, smt);
            ResultSet rs = st.executeQuery();
            rs.next();
            fac = rs.getString(1);
            CallableStatement st2 = cn.prepareCall("{call spdetalle(?,?,?)}");
            for (FacturaDetalle c : lista) {
                st2.setString(1, fac);
                st2.setString(2, c.getIdArticulo());
                st2.setInt(3, c.getCantidad());
                st2.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fac;
    }

}
