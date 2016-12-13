/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAL.HibernateUtil;
import ENTITY.Minuto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alfonzork
 */
public class MinutoDAO {
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<ENTITY.Minuto> getLista() throws Exception {
        session.beginTransaction();
        try {
            List<ENTITY.Minuto> listar = (List<ENTITY.Minuto>) session.createCriteria(ENTITY.Minuto.class).list();
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
    
    public ENTITY.Minuto getMinutbyDesc(String descrip) throws Exception {
        try {
            session.beginTransaction();
            ENTITY.Minuto tmp = (ENTITY.Minuto) session.createCriteria(ENTITY.Minuto.class).add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return tmp;
        } catch (Exception e) {
            System.err.print(e.getMessage());
            session.close();
            throw e;
        }
    }

    public Minuto getMinutbyDesc(Minuto min) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
