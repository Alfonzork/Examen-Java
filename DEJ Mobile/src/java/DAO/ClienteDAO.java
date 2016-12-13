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
    
    public boolean validarRut (String rut) throws Exception
    {
        int a,b,c,d,e,f,g,h,i,j,l,dv,m,aa,bb,cc,dd,ee,ff,gg,hh;     
       String cadenaNueva = rut.substring(0, rut.length()-1);
       char car=rut.charAt(rut.length()-1);
       char vd='a';
        a=Integer.parseInt(cadenaNueva);
    
        b=a/10000000; bb=a%10000000;
        c=bb/1000000; cc=a%1000000;
        d=cc/100000; dd=a%100000;
        e=dd/10000; ee=a%10000;
        f=ee/1000; ff=a%1000;
        g=ff/100; gg=a%100;
        h=gg/10; hh=a%10;
        i=hh/1; 
        
        j=(b*3)+(c*2)+(d*7)+(e*6)+(f*5)+(g*4)+(h*3)+(i*2);
        l = j%11;
        if(l == 10){ 
            vd ='k';
        }if(l==11){
            dv=0;
        }else{dv = l;}
        if(car==dv || car==vd){
            return true;
        }
        return true;
    }
}
