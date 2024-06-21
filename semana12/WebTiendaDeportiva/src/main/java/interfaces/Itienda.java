package interfaces;
import java.util.*;
import modelo.*;
public interface Itienda {
 
  List<Articulo> lisArticulo(String id);
  Articulo busArticulo(String id);
  Cliente busCliente(String usr,String pas);
  String grabaFactura(List<FacturaDetalle> lista,String codc);
    
    
}
