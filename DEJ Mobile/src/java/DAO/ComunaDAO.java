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
public class ComunaDAO {

    public List<ENTITY.Comuna> getLista() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List<ENTITY.Comuna> listar = (List<ENTITY.Comuna>) session.createCriteria(ENTITY.Comuna.class).list();
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
