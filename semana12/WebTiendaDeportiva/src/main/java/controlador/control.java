/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.Negocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

/**
 *
 * @author Cesar
 */
public class control extends HttpServlet {
    Negocio obj= new Negocio();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
     
      protected void busArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        request.setAttribute("dato", obj.busArticulo(cod));
        String pag = "/pagDetalle.jsp";
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
        FacturaDetalle compra = new FacturaDetalle();
        compra.setIdArticulo(coda);
        compra.setDescripcion(art.getDescripcion());
        compra.setPrecioUnidad(art.getPrecioUnidad());
        compra.setCantidad(can);
  
        List<FacturaDetalle> lista;
        if (sesion.getAttribute("canasta") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<FacturaDetalle>) sesion.getAttribute("canasta");
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
        List<FacturaDetalle> lista = (ArrayList<FacturaDetalle>) sesion.getAttribute("canasta");
        lista.remove(ind);

        sesion.setAttribute("canasta", lista);
        String pag = "/pagCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void grabarfacturaydetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Crear una Session
        HttpSession sesion = request.getSession();
        List<FacturaDetalle> lista = (ArrayList<FacturaDetalle>) sesion.getAttribute("canasta");
        Cliente cliente = (Cliente) sesion.getAttribute("cliente");
        double total = (double) sesion.getAttribute("total");
        String fac = obj.grabaFactura(lista, cliente.getTarjeta());
        String cad = "Factura Nro  " + fac;
        cad+= "\n cliente " + cliente.getNombre();
        cad+= "\n Total compra " + total;
        sesion.setAttribute("canasta", null);
        sesion.setAttribute("cliente", null);
        response.sendRedirect("generaQr?texto="+cad);

//        sesion.setAttribute("canasta", lista);
//        String pag = "/pagCompra.jsp";
//        request.getRequestDispatcher(pag).forward(request, response);
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
