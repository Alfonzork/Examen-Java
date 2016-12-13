/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alfonzork
 */
public class CuotaDAO {
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<ENTITY.CuotaNavegacion> getLista() throws Exception {
        session.beginTransaction();
        try {
            List<ENTITY.CuotaNavegacion> listar = (List<ENTITY.CuotaNavegacion>) session.createCriteria(ENTITY.CuotaNavegacion.class).list();
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
    
    public ENTITY.CuotaNavegacion getCuotabyDesc(String descrip) throws Exception {
        try {
            session.beginTransaction();
            ENTITY.CuotaNavegacion tmp = (ENTITY.CuotaNavegacion) session.createCriteria(ENTITY.CuotaNavegacion.class).add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return tmp;
        } catch (Exception e) {
            System.err.print(e.getMessage());
            session.close();
            throw e;
        }
    }
}
