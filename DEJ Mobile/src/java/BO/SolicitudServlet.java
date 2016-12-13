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
public class SolicitudServlet extends HttpServlet {

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
            
            int total = 0, detalle4;
            java.util.Date fecha = new Date();
            String entrega = "", detalle1 = "", detalle2 = "", detalle3 = "";
            String cuota = request.getParameter("ddlCuota");
            String min = request.getParameter("rbMinuto");
            boolean domc = false;
            
            DAO.CuotaDAO cuotta = new CuotaDAO();
            DAO.MinutoDAO minutt = new MinutoDAO();
            DAO.SolicitudDAO soliDAO = new SolicitudDAO();
           
            if (request.getParameter("cvDomicilio").equalsIgnoreCase("ON")) {
                domc = true;
                if (domc) {
                    entrega = "Entrega del Chip en Domicilio";
                }
            }else { entrega = "NO";}
            try {
                ENTITY.CuotaNavegacion cuo = cuotta.getCuotabyDesc(cuota);
                ENTITY.Minuto minu = minutt.getMinutbyDesc(min);
                
                total = cuo.getPrecio() + minu.getPrecio();
                ENTITY.Solicitud solic = new Solicitud(cuo, minu, entrega, total, fecha);

                detalle1 = cuo.getDescripcion();
                detalle2 = minu.getDescripcion();
                detalle3 = entrega;
                detalle4 = total;
                request.getSession().setAttribute("detalle1", detalle1);
                request.getSession().setAttribute("detalle2", detalle2);
                request.getSession().setAttribute("detalle3", detalle3);
                request.getSession().setAttribute("detalle4", detalle4);
                request.setAttribute("alertMsg", "Si estas de acuedo confirma tu Plan");
                request.getRequestDispatcher("paso2.jsp").forward(request, response);

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
