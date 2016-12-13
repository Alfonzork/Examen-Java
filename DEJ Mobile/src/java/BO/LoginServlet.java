/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ClienteDAO;
import ENTITY.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.scripts.JS;

/**
 *
 * @author Luis Fredes & José Villaseca
 */
public class LoginServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            int psw;

            try {
                String sess = request.getParameter("txtRut");
                psw = Integer.parseInt(request.getParameter("txtPass"));
                sess = sess.replace("-", "");

                DAO.ClienteDAO clDao = new ClienteDAO();
                ENTITY.Cliente clEnt = clDao.getClientebyRut(sess);

                if (sess.equals(clEnt.getRutCliente()) && psw == clEnt.getClave()) {
                    request.setAttribute("alertMsg", "Inicio de Session OK!!");
                    request.getSession().setAttribute("userSes", clEnt);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    request.getRequestDispatcher("paso1.jsp").forward(request, response);
                    request.getRequestDispatcher("paso2.jsp").forward(request, response);
                    request.getRequestDispatcher("planes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("alertMsg", "Usuario y/o Clave Incorrecto!!");
                request.getRequestDispatcher("./login.jsp").forward(request, response);
            }

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
