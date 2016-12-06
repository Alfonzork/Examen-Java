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
public class ClienteDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public boolean Add(ENTITY.Cliente c) throws Exception {
        session.beginTransaction();
        try {
            session.save(c);
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

    public boolean Update(ENTITY.Cliente c) throws Exception {
        session.beginTransaction();
        try {
            session.update(c);
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

    public boolean Delete(ENTITY.Cliente c) throws Exception {
        session.beginTransaction();
        try {
            session.delete(c);
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

    public List<ENTITY.Cliente> getLista() throws Exception {
        session.beginTransaction();
        try {
            List<ENTITY.Cliente> listar = (List<ENTITY.Cliente>) session.createCriteria(ENTITY.Cliente.class).list();
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

    public ENTITY.Cliente getClientebyRut(String rut) throws Exception {
        try {
            session.beginTransaction();
            ENTITY.Cliente tmp = (ENTITY.Cliente) session.createCriteria(ENTITY.Cliente.class).add(Restrictions.eq("rutCliente", rut)).uniqueResult();
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
