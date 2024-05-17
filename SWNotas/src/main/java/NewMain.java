
import dao.Negocio;
import util.MySQLConexion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Cesar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MySQLConexion.getConexion();
        Negocio neg= new Negocio();
        System.out.println("" + neg.listaEspecialidad().toString() );
    }
    
}
