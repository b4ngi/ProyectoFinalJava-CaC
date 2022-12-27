/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bangho
 */
@WebServlet(urlPatterns = {"/checkuser"})
public class checkuser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            Persistencia base = new Persistencia();
            ResultSet rs = base.consultaSQL("SELECT * FROM usuarios WHERE usuario = " + "'" + request.getParameter("inputEmail") + "'");
            
            if(!rs.first()){
                out.println("Usuario no encontrado <BR>");
                out.println("<a href='login.html'> Volver a intentar </a>");
            } else{
                
                if(!rs.getString("clave").equals(request.getParameter("inputPassword"))){
                    //out.println(rs.getString("clave"));
                    //out.println(request.getParameter("inputPassword"));
                    out.println("Clave incorrecta <BR>");
                    out.println("<a href='login.html'> Volver a intentar </a>");
                } else {
                    //out.println("<h1>Servlet checkuser at " + request.getContextPath() + "</h1>");
                    out.println("<h1> Acceso correcto </h1><BR>");
                    out.println("Usuario: "+rs.getString("usuario") + "<BR>");
                    out.println("Clave: "+ rs.getString("clave") + "<BR>");
                    out.println("Nombre y Apellido: "+ rs.getString("nombreyapellido") + "<BR><BR>");
                    out.println("<a href='pedido.html'> Realizar pedido </a> <BR>");
                    out.println("<a href='index.html'> Volver a la pagina principal </a>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
