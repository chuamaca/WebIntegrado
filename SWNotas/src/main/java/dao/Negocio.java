/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import modelo.Especialidad;
import modelo.Pago;
import util.MySQLConexion;

/**
 *
 * @author Cesar
 */
public class Negocio {

    public List<Especialidad> listaEspecialidad() {
        System.out.println("listaEspecialidad");
        List<Especialidad> lista = new ArrayList();
        Connection cnx = MySQLConexion.getConexion();

        try {
            String SQL = "SELECT Idesp, Nomesp FROM especialidad";
            PreparedStatement st = cnx.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Especialidad obj = new Especialidad();
                obj.setIdesp(rs.getString(1));
                obj.setNomesp(rs.getString(2));

                lista.add(obj);
            }

        } catch (Exception e) {
        }

        return lista;
    }

    public List<Alumno> listaAlumno(String Idesp) {
        System.out.println("lsita");
        List<Alumno> lista = new ArrayList();
        Connection cnx = MySQLConexion.getConexion();

        try {
            String SQL = "SELECT IdAlumno, ApeAlumno, NomAlumno, Idesp, PROCE FROM alumno where Idesp=?";
            PreparedStatement st = cnx.prepareStatement(SQL);
            st.setString(1, Idesp);
            ResultSet rs = st.executeQuery();
            System.out.println("ResultSet");

            while (rs.next()) {

                System.out.println("rs: " + rs);
                Alumno obj = new Alumno();
                obj.setIdAlumno(rs.getString(1));
                obj.setApeAlumno(rs.getString(2));
                obj.setNomAlumno(rs.getString(3));
                obj.setIdesp(rs.getString(4));
                obj.setPROCE(rs.getString(5));

                lista.add(obj);
            }

        } catch (Exception e) {
        }

        return lista;
    }

    public List<Pago> listaPagos(String IdAlumno) {
        List<Pago> lista = new ArrayList();
        Connection cnx = MySQLConexion.getConexion();

        try {
            String SQL = "SELECT IdAlumno, CICLO, NCUOTA, MONTO, FECHA FROM pagos where IdAlumno=?";
            PreparedStatement st = cnx.prepareStatement(SQL);
            st.setString(1, IdAlumno);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Pago obj = new Pago();
                obj.setIdAlumno(rs.getString(1));
                obj.setCICLO(rs.getString(2));
                obj.setNCUOTA(rs.getInt(3));
                obj.setMONTO(rs.getDouble(4));
                obj.setFECHA(rs.getString(5));

                lista.add(obj);
            }

        } catch (Exception e) {
        }

        return lista;
    }

    public List<Curso> listaCurso(String IdAlumno) {
        
        List<Curso> lista = new ArrayList();
        Connection cnx = MySQLConexion.getConexion();

        try {
            String SQL = "SELECT n.IdCurso, NomCurso, credito, ExaParcial , ExaFinal  FROM curso c inner join notas n on c.IdCurso =n.IdCurso where n.IdAlumno =?";
            PreparedStatement st = cnx.prepareStatement(SQL);
            st.setString(1, IdAlumno);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("rs: " + rs);
                Curso obj = new Curso();
                obj.setIdCurso(rs.getString(1));
                obj.setNomCurso(rs.getString(2));
                obj.setCredito(rs.getInt(3));
                obj.setExaParcial(rs.getInt(4));
                obj.setExaFinal(rs.getInt(5));

                lista.add(obj);
            }

        } catch (Exception e) {
        }

        return lista;
    }

}
