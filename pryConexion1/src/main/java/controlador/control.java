/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.PrestamoDAO;
import modelo.Prestamo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
public class control extends HttpServlet {

    PrestamoDAO obj = new PrestamoDAO();

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
            adiccion(request, response);
        }
        if (op == 2) {
            consulta(request, response);
        }
        if (op == 3) {
            //cambia
            actualiza(request, response);
        }
        if (op == 4) {
            anula(request, response);
        }

    }

    protected void adiccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Prestamo p = new Prestamo();
        p.setCliente(request.getParameter("cliente"));
        p.setMonto(Double.parseDouble(request.getParameter("monto")));
        p.setMeses(Integer.parseInt(request.getParameter("mes")));
        obj.adicion(p);
        String path = "/pagListado.jsp";
        request.getRequestDispatcher(path).forward(request, response);

    }

    protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        request.setAttribute("dato", obj.consulta(nro));
        String path = "/pagEdit.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    protected void actualiza(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Prestamo p = new Prestamo();
        p.setNropre(Integer.parseInt(request.getParameter("nro")));
        p.setCliente(request.getParameter("cliente"));
        p.setMonto(Double.parseDouble(request.getParameter("monto")));
        p.setMeses(Integer.parseInt(request.getParameter("mes")));
        obj.modifica(p);
        String path = "/pagListado.jsp";
        request.getRequestDispatcher(path).forward(request, response);

    }

    protected void anula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.anular(nro);
        String path = "/pagListado.jsp";
        request.getRequestDispatcher(path).forward(request, response);
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
