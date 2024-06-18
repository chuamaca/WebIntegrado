package interfaces;
import java.util.*;
import beans.*;
public interface Itienda {
  List<Categoria> lisCategoria();
  List<Articulo> lisArticulo(String id);
  Articulo busArticulo(String id);
  Cliente busCliente(String usr,String pas);
  String grabaFactura(List<Compra> lista,String codc);
    
    
}
