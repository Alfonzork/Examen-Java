/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Fredes & José Villaseca
 */
public class crudCliente extends HttpServlet {

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
            try {

                int clave, confirmaClave;
                String rut = request.getParameter("txtRut");
                rut = rut.replace("-", "");
                clave = Integer.parseInt(request.getParameter("txtClave"));
                confirmaClave = Integer.parseInt(request.getParameter("txtConfirmaClave"));
                String nombre = request.getParameter("txtNombre");
                String ApellidoPaterno = request.getParameter("txtApePaterno");
                String ApellidoMaterno = request.getParameter("txtApeMaterno");
                String direccion = request.getParameter("txtDireccion");
                int numeracion = Integer.parseInt(request.getParameter("txtNumeracion"));
                String com = request.getParameter("ddlComuna");
                int telefono = Integer.parseInt(request.getParameter("txtTelefono"));

                if (clave == confirmaClave) {
                    DAO.ComunaDAO comDAO = new DAO.ComunaDAO();
                    ENTITY.Comuna comuna = comDAO.getComunabyNombre(com);
                    ENTITY.Cliente nuevoCliente = new ENTITY.Cliente(rut, comuna, clave, nombre, ApellidoPaterno, ApellidoMaterno, direccion, numeracion, telefono);
                    DAO.ClienteDAO clienteDao = new DAO.ClienteDAO();

                    if (clienteDao.Add(nuevoCliente)) {
                        request.setAttribute("alertMsg", "Cliente Agregado Exitosamente!!");
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    } else {
                        request.setAttribute("alertMsg", "Ocurrio un error en el Ingreso");
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                }
                else 
                {
                request.setAttribute("alertMsg", "Confirma Clave no es Valida");
                }

            } catch (Exception e) {
                request.setAttribute("alertMsg", "Ocurrio un Error Inesperado:");
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
