/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ClienteDAO;
import DAO.CuotaDAO;
import DAO.MinutoDAO;
import DAO.SolicitudDAO;
import ENTITY.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Fredes & José Villaseca
 */
public class ConfirmaPlanServlet extends HttpServlet {

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

            java.util.Date fecha = new Date();
            String detalle1 = request.getParameter("txtdetalle1");
            String detalle2 = request.getParameter("txtdetalle2");
            String detalle3 = request.getParameter("txtdetalle3");
            int detalle4 = Integer.parseInt(request.getParameter("txtdetalle4"));
            String rut = request.getParameter("txtrut"); 

            DAO.CuotaDAO cuotta = new CuotaDAO();
            DAO.MinutoDAO minutt = new MinutoDAO();
            DAO.SolicitudDAO soliDAO = new SolicitudDAO();
            DAO.ClienteDAO clienDAO = new ClienteDAO();

            try {
                ENTITY.CuotaNavegacion cuo = cuotta.getCuotabyDesc(detalle1);
                ENTITY.Minuto minu = minutt.getMinutbyDesc(detalle2);
                ENTITY.Cliente clinete = clienDAO.getClientebyRut(rut);
                ENTITY.Solicitud solic = new Solicitud(clinete, cuo, minu, detalle3, detalle4, fecha);
                if (soliDAO.Add(solic)) {
                    request.getSession().setAttribute("solicitud", solic);
                    request.setAttribute("alertMsg", "Plan Solicitado OK");
                    request.getRequestDispatcher("planes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("alertMsg", "Error Inesperado");
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
