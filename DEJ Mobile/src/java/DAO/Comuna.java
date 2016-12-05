/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAL.HibernateUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import org.hibernate.Session;

/**
 *
 * @author Alfonzork
 */
public class Comuna {
    
    public List<ENTITY.Comuna> listarComuna() throws Exception
    {
    Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<ENTITY.Comuna> listar = (List<ENTITY.Comuna>) session.createCriteria(ENTITY.Comuna.class).list();
           session.getTransaction().commit();
           session.close();
           return listar;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            session.close();
            throw e;
        }
    
    }
}
