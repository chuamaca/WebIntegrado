/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interfaces.ITienda;
import Util.MySQLConexion;
import beans.Articulo;
import beans.Categoria;
import beans.Cliente;
import beans.Compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class Negocio implements ITienda {

    String LISTA_CATEGORIA_SQL = "Select IdCategoria, Descripcion, Imagen From Categorias";
    String LISTA_ARTICULOS_SQL = "select IdArticulo, descripcion, imagen, PrecioUnidad, Stock from Articulos where IdCategoria=? ";
    String ARTICULO_SQL = "select IdArticulo, descripcion, imagen, PrecionUnidad, Stock from Articulos where IdArticulo=? ";
    private static String USUARIO_SQL = "SELECT IdCliente, Apellidos, Nombres FROM Clientes where IdCliente=? and PassWord=?";

    @Override
    public List<Categoria> ListaCategoria() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        List<Categoria> listaCategorias = new ArrayList<>();

        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(LISTA_CATEGORIA_SQL);
            rs = st.executeQuery();

            while (rs.next()) {

                categoria = new Categoria();
                categoria.setCodc(rs.getString(1));
                categoria.setNomc(rs.getString(2));
                categoria.setImagen(rs.getString(3));

                listaCategorias.add(categoria);
            }

            System.out.println("listaCategorias:" + listaCategorias);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

        }

        return listaCategorias;

    }

    @Override
    public List<Articulo> ListaArticulo(String id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Articulo articulo = null;
        List<Articulo> listaArticulos = new ArrayList<>();

        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(LISTA_ARTICULOS_SQL);
            st.setString(0, id);
            rs = st.executeQuery();

            while (rs.next()) {

                articulo = new Articulo();
                articulo.setCoda(rs.getString(1));
                articulo.setNomart(rs.getString(2));
                articulo.setImagen(rs.getString(3));
                articulo.setPrecio(rs.getDouble(4));
                articulo.setStk(rs.getInt(5));

                listaArticulos.add(articulo);
            }

            System.out.println("ListaArticulo>>>>>>>:" + listaArticulos);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

        }

        return listaArticulos;

    }

    @Override
    public Articulo BuscarArticulo(String id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Articulo articulo = null;

        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(ARTICULO_SQL);
            st.setString(0, id);
            rs = st.executeQuery();
            if (rs.next()) {
                articulo = new Articulo();
                articulo.setCoda(rs.getString(1));
                articulo.setNomart(rs.getString(2));
                articulo.setImagen(rs.getString(3));
                articulo.setPrecio(rs.getDouble(4));
                articulo.setStk(rs.getInt(5));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

        }

        return articulo;

    }

    @Override
    public Cliente BuscarCliente(String user, String pass) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(USUARIO_SQL);
            st.setString(0, user);
            st.setString(2, pass);
            rs = st.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();

                cliente.setCodc(rs.getString(1));
                cliente.setApe(rs.getString(2));
                cliente.setNom(rs.getString(3));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

        }

        return cliente;

    }

    @Override
    public String grabar(List<Compra> listacompra, String cliente) {
        double smt = 0;
        String factura = "";
        for (Compra x : listacompra) {

            smt = smt + x.total();
        }

        Connection cn = MySQLConexion.getConexion();

        try {
            CallableStatement st = cn.prepareCall("{call spfactura(?,?)}");
            st.setString(1, cliente);
            st.setDouble(2, smt);
            ResultSet rs = st.executeQuery();
            rs.next();

            factura = rs.getString(1);

            CallableStatement st2 = cn.prepareCall("{call spdetalle(?,?,?)}");
            for (Compra x : listacompra) {

                st2.setString(1, factura);
                st2.setString(2, x.getCoda());
                st2.setInt(3, x.getCantidad());
                st2.executeUpdate();
            }

        } catch (Exception eX) {
        }

        return factura;
    }

}
