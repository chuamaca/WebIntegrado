package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Negocio;
import beans.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class tienda extends HttpServlet {

    Negocio obj = new Negocio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            lisArt(request, response);
        }
        if (op == 2) {
            busArt(request, response);
        }
        if (op == 3) {
            detArt(request, response);
        }

        if (op == 4) {
            delItem(request, response);
        }

        if (op == 5) {
            login(request, response);
        }

        if (op == 6) {
            grabarfacturaydetalle(request, response);
        }

    }

    protected void lisArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        request.setAttribute("dato", obj.lisArticulo(cod));
        String pag = "/pagArticulo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("usr");
        String password = request.getParameter("pas");

        Cliente cliente = obj.busCliente(user.trim(), password.trim());
        HttpSession session = request.getSession();
        String pag = "";
        if (cliente == null) {
            request.setAttribute("mensaje", "usuario o clave incorrecto");
            pag = "/pagLogin.jsp";
        } else {
            session.setAttribute("cliente", cliente);
            pag = "/pagConfirma.jsp";
        }

        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void detArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Crear una Session
        HttpSession sesion = request.getSession();
        String coda = request.getParameter("coda");
        int can = Integer.parseInt(request.getParameter("cantidad"));

        Articulo art = obj.busArticulo(coda);
        Compra compra = new Compra();
        compra.setCoda(coda);
        compra.setNomart(art.getNomart());
        compra.setPrecio(art.getPrecio());
        compra.setCantidad(can);
        compra.setImagen(art.getImagen());
        List<Compra> lista;
        if (sesion.getAttribute("canasta") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<Compra>) sesion.getAttribute("canasta");
        }
        lista.add(compra);
        sesion.setAttribute("canasta", lista);
        String pag = "/pagCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void delItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Crear una Session
        HttpSession sesion = request.getSession();
        String ind = request.getParameter("ind");
        List<Compra> lista = (ArrayList<Compra>) sesion.getAttribute("canasta");
        lista.remove(ind);

        sesion.setAttribute("canasta", lista);
        String pag = "/pagCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void grabarfacturaydetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Crear una Session
        HttpSession sesion = request.getSession();
        List<Compra> lista = (ArrayList<Compra>) sesion.getAttribute("canasta");
        Cliente cliente = (Cliente) sesion.getAttribute("cliente");
        double total = (double) sesion.getAttribute("total");
        String fac = obj.grabaFactura(lista, cliente.getCodc());
        String cad = "Factura Nro  " + fac;
        cad+= "\n cliente " + cliente.getApe() + ", " + cliente.getNom();
        cad+= "\n Total compra " + total;
        sesion.setAttribute("canasta", null);
        sesion.setAttribute("cliente", null);
        response.sendRedirect("generaQr?texto="+cad);

//        sesion.setAttribute("canasta", lista);
//        String pag = "/pagCompra.jsp";
//        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void graba(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession ses=request.getSession() ;//crear una sesion
       List<Compra> lista= (ArrayList<Compra>)ses.getAttribute("canasta");
       Cliente cli=(Cliente)ses.getAttribute("cliente");
       double total=(double)ses.getAttribute("total");
       //graba la factura y el detalle
       String fac=obj.grabaFactura(lista, cli.getCodc());
       String cad="Factura Nro :"+fac;
       cad+="\n Cliente "+cli.getApe()+","+cli.getNom();
       cad+="\n Total Compra "+total;
       ses.setAttribute("canasta", null);
       ses.setAttribute("cliente", null);
       response.sendRedirect("generaQr?texto="+cad);
       //ses.setAttribute("canasta", lista);
       //String pag="/pagCompra.jsp";
      //request.getRequestDispatcher(pag).forward(request, response);
       
    }

    protected void busArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        request.setAttribute("dato", obj.busArticulo(cod));
        String pag = "/pagDetalle.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
