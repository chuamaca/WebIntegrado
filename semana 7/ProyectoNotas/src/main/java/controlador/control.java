package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import dao.Negocio;

public class control extends HttpServlet {
    
    Negocio obj = new Negocio();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            lisAlu(request, response);
        }
        if (op == 2) {
            lisPago(request, response);
        }
        if (op == 3) {
            lisNota(request, response);
        }
        
        if (op == 4) {
            getAlu(request, response);
        }
        
        if (op == 5) {
            AgregarAlu(request, response);
        }
        
    }
    
    protected void lisAlu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        String nome = request.getParameter("nom");
        request.setAttribute("dato", obj.lisAlu(cod));
        request.setAttribute("nome", nome);
        
        String pag = "/pagAlumno.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void lisPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        String nome = request.getParameter("nom");
        request.setAttribute("dato", obj.LisPago(cod));
        request.setAttribute("nom", nome);
        
        String pag = "/pagPagos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void lisNota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        String noma = request.getParameter("nom");
        request.setAttribute("dato", obj.LisNota(cod));
        request.setAttribute("nom", noma);
        String pag = "/pagNotas.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void getAlu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dato", obj.getAlu());
        request.setAttribute("titulo", "Adicion De Alumnos");
        request.setAttribute("nro", 5);
        request.setAttribute("alu", new Alumno());
        
        String pag = "/pagAlumnoCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void AgregarAlu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Alumno a = new Alumno();
        int sw = 0;
        String codeigo=request.getParameter("coda");
        System.out.println("coda: " + codeigo);
        
        if (request.getParameter("coda") != "" ) {
            sw = 1;
            a.setCoda(request.getParameter("coda"));
            
        }
        
        a.setApe(request.getParameter("ape"));
        a.setNoma(request.getParameter("noma"));
        a.setCoda(request.getParameter("code"));
        a.setProce(request.getParameter("proce"));
        
        if (sw == 0) {
            obj.AgregarALumno(a);
        } else {
            obj.ModificarALumno(a);
        }
        
        request.setAttribute("dato", obj.getAlu());
        request.setAttribute("titulo", "Adicion De Alumnos");
        request.setAttribute("nro", 5);
        request.setAttribute("alu", new Alumno());
        
        String pag = "/pagAlumnoCrud.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void EditarAlu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cod = request.getParameter("cod");
        
        request.setAttribute("dato", obj.getAlu());
        request.setAttribute("titulo", "Modificar Alumno");
        request.setAttribute("nro", 5);
        request.setAttribute("alu", obj.busAlu(cod));
        
        String pag = "/pagAlumnoCrud.jsp";
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
