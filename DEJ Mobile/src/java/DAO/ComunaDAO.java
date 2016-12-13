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
public class ComunaDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<ENTITY.Comuna> getLista() throws Exception {
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

    public ENTITY.Comuna getComunabyId(int id) throws Exception {
        try {
            session.beginTransaction();
            ENTITY.Comuna tmp = (ENTITY.Comuna) session.createCriteria(ENTITY.Comuna.class).add(Restrictions.eq("idComuna", id)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return tmp;
        } catch (Exception e) {
            System.err.print(e.getMessage());
            session.close();
            throw e;
        }
    }

    public ENTITY.Comuna getComunabyNombre(String nombre) throws Exception {
        try {
            session.beginTransaction();
            ENTITY.Comuna tmp = (ENTITY.Comuna) session.createCriteria(ENTITY.Comuna.class).add(Restrictions.eq("nombreComuna", nombre)).uniqueResult();
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
