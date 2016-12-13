/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DAO.ClienteDAO;
import DAO.SolicitudDAO;
import ENTITY.Cliente;
import DAL.HibernateUtil;

/**
 *
 * @author Alfonzork
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        DAO.SolicitudDAO solDAO = new SolicitudDAO();
        DAO.ClienteDAO cliDAO = new ClienteDAO();

        for (ENTITY.Solicitud sol : solDAO.getLista()) {
            ENTITY.Cliente cl = (ENTITY.Cliente) cliDAO.getLista();
            ENTITY.CuotaNavegacion cu = sol.getCuotaNavegacion();
            ENTITY.Minuto mi = sol.getMinuto();
            System.out.println(sol.getIdSolicitud());
            System.out.println(cu.getDescripcion());
            System.out.println(mi.getDescripcion());
            System.out.println(cl.getDireccion());
            System.out.println(cl.getTelefono());
            System.out.println(cl.getComuna());
            System.out.println(sol.getFechaSolicitud());
            System.out.println(sol.getTotal());
        }

    }
}
