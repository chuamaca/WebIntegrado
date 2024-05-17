/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import modelo.Prestamo;
import util.MySQLConexion;

/**
 *
 * @author Cesar
 */
public class PrestamoDAO {
    //adicionar

    public void adicion(Prestamo p) {
        try {
            Connection cn = MySQLConexion.getConexion();
            String sql = "INSERT INTO PRESTAMO VALUES(null,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, p.getCliente());
            st.setDouble(2, p.getMonto());
            st.setInt(3, p.getMeses());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // modificar
    public void modifica(Prestamo p) {
        try {
            Connection cn = MySQLConexion.getConexion();
            String sql = "UPDATE PRESTAMO SET cliente=?, monto=?, meses=? where nropre=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, p.getCliente());
            st.setDouble(2, p.getMonto());
            st.setInt(3, p.getMeses());
            st.setInt(4, p.getNropre());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // anular
    public void anular(int nropre) {
        try {
            Connection cn = MySQLConexion.getConexion();
            String sql = "DELETE FROM PRESTAMO where nropre=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, nropre);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //consultar

    public List<Prestamo> listado() {
        List<Prestamo> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select nropre, cliente, monto, meses from prestamo";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setNropre(rs.getInt(1));
                p.setCliente(rs.getString(2));
                p.setMonto(rs.getDouble(3));
                p.setMeses(rs.getInt(4));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;

    }

    public Prestamo consulta(int nropre) {
        Prestamo p = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select nropre, cliente, monto, meses from prestamo where nropre=?";

            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, nropre);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                p = new Prestamo();
                p.setNropre(rs.getInt(1));
                p.setCliente(rs.getString(2));
                p.setMonto(rs.getDouble(3));
                p.setMeses(rs.getInt(4));

            }

        } catch (Exception e) {
        }
        return p;

    }
}
