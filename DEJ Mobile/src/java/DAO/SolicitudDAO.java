/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Alfonzork
 */
public class SolicitudDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public boolean Add(ENTITY.Solicitud s) throws Exception {
        session.beginTransaction();
        try {
            session.save(s);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            System.err.println(e.getMessage());
            throw e;
        }
    }
    
    public List<ENTITY.Solicitud> getLista() throws Exception {
        session.beginTransaction();
        try {
            List<ENTITY.Solicitud> listar = (List<ENTITY.Solicitud>) session.createCriteria(ENTITY.Solicitud.class).list();
            session.getTransaction().commit();
            return listar;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            System.err.println(e.getMessage());
            throw e;
        } finally {
            session.close();
        }
    }
}
