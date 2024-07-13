package dao;
//se realiza todas las operaciones que se van a ejecutar en las
// paginas jsp

import java.sql.*;
import java.util.*;
import beans.*;
import util.MySQLConexion;

public class Negocio {

    public List<Alumno> LisAlu() {
        List<Alumno> lista = new ArrayList();
        String sql = "select idalumno, apealumno, nomalumno from alumno";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Alumno> LisEsp(String id) {
        List<Alumno> lista = new ArrayList();
        String sql = "select idalumno, apealumno, nomalumno from alumno"
                + " where Idesp =?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //filtrar por nombre o apellido
    public List<Alumno> LisAlu(String cad) {
        List<Alumno> lista = new ArrayList();
        String sql = "select idalumno, apealumno, nomalumno from alumno "
                + " where apealumno like ? or nomalumno like ?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, "%" + cad + "%");
            st.setString(2, "%" + cad + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Especialidad> LisESp() {
        List<Especialidad> lista = new ArrayList();
        String sql = "select idesp, nomesp from especialidad";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Especialidad a = new Especialidad(rs.getString(1), rs.getString(2));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Curso> LisCurso() {
        List<Curso> lista = new ArrayList();
        String sql = "select IdCurso, NomCurso from curso";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Curso a = new Curso(rs.getString(1), rs.getString(2));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<MCategoria> LisCategoria() {
        List<MCategoria> lista = new ArrayList();
        String sql = "select IdCategoria , Nombre from Categorias";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MCategoria a = new MCategoria(rs.getInt(1), rs.getString(2));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<MProducto> LisCategoriaProducto(int IdCategoria) {
        List<MProducto> lista = new ArrayList();
        String sql = "SELECT IdProducto, Codigo, p.Nombre, Stock, PrecioVenta, p.IdCategoria\n"
                + "FROM productos p inner join categorias c\n"
                + "on  p.IdCategoria = c.IdCategoria \n"
                + "where c.IdCategoria =?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setInt(1, IdCategoria);
            ResultSet rs = st.executeQuery();
            System.out.println("RS: " + rs.toString());
            while (rs.next()) {
                MProducto a = new MProducto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDouble(5), rs.getInt(6));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //busqueda de un alumno por codigo
    public Alumno BusAlu(String cod) {
        Alumno a = null;
        String sql = "select idalumno, apealumno, nomalumno from alumno where idalumno=?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public void graba(Alumno a) {
        String sql = "{call spAdiAlu(?,?,?,?)}";
        try {
            CallableStatement st = MySQLConexion.getConexion().prepareCall(sql);
            st.setString(1, a.getApe());
            st.setString(2, a.getNoma());
            st.setString(3, a.getCodes());
            st.setString(4, a.getColegio());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    /////////////////////////

    //listar los pagos de un alumno 
    public List<Pagos> LisPago(String cod) {
        List<Pagos> lista = new ArrayList();
        String sql = "select ciclo, fecha,monto from Pagos where idalumno=?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pagos a = new Pagos(rs.getString(1), rs.getString(2), rs.getDouble(3));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Notas> LisNotCurso(String IdCurso) {
        List<Notas> lista = new ArrayList();
        String sql = "SELECT a.IdAlumno,a.ApeAlumno,a.NomAlumno,n.ExaParcial,n.ExaFinal,((n.ExaParcial+n.ExaFinal)/2) as Promedio FROM notas n \n"
                + "INNER JOIN alumno a on a.IdAlumno = n.IdAlumno\n"
                + "inner join curso c on c.IdCurso = n.IdCurso\n"
                + "where n.IdCurso=?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, IdCurso);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Notas a = new Notas(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Notas> LisNotCursoG() {
        List<Notas> lista = new ArrayList();
        String sql = "SELECT a.IdAlumno,a.ApeAlumno,a.NomAlumno,n.ExaParcial,n.ExaFinal,((n.ExaParcial+n.ExaFinal)/2) as Promedio FROM notas n \n"
                + "INNER JOIN alumno a on a.IdAlumno = n.IdAlumno\n"
                + "inner join curso c on c.IdCurso = n.IdCurso";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Notas a = new Notas(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
