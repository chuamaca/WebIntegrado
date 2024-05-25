/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import beans.Articulo;
import beans.Categoria;
import beans.Cliente;
import beans.Compra;
import java.util.List;

/**
 *
 * @author Cesar
 */
public interface ITienda {

    List<Categoria> ListaCategoria();

    List<Articulo> ListaArticulo(String id);

    Articulo BuscarArticulo(String id);

    Cliente BuscarCliente(String user, String pass);

    String grabar(List<Compra> compra, String cliente);
}
