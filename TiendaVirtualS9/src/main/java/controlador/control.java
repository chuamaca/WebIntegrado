/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Negocio;
import beans.*;

/**
 *
 * @author Cesar
 */
public class control extends HttpServlet {
    
    Negocio obj = new Negocio();

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
            listaArticulos(request, response);
        }
        if (op==2) {
            buscaArticulo(request, response);
        }
        
    
        
    }
    
    protected void listaArticulos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        System.out.println("control listarArticulos+ " + op);
        String cod = request.getParameter("cod");
        request.setAttribute("dato", obj.ListaArticulo(cod));
        System.out.println("lista:::  "+  obj.ListaArticulo(cod));
        
        String pag = "/articulo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    }
    
    protected void detalleArticulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        
    }
    
    protected void buscaArticulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int op = Integer.parseInt(request.getParameter("opc"));
        String cod = request.getParameter("cod");
        request.setAttribute("dato", obj.BuscarArticulo(cod));
        
        String pag = "/articulodetalle.jsp";
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
