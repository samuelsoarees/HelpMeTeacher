/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import piweb.model.dados.hibernate.HibernateUtil;
import piweb.model.entidades.Aluno;

/**
 *
 * @author Samuel
 */
public abstract class DAO implements DAOInterface {
   
   protected EntityManager manager;
    
    
    public Object inserir(Object t) {
        manager= HibernateUtil.getInstance().getFactory().createEntityManager();
        try{
            manager.getTransaction().begin();
            manager.persist(t);
            manager.getTransaction().commit();
            
        }catch(Exception e){
            
        }finally{
            manager.close();
        }
        
        
        return t;
    }


    public Object alterar(Object t) {
   
        manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try{
            this.manager.getTransaction().begin();
            t=this.manager.merge(t);
            this.manager.getTransaction().commit();
            
        }catch(Exception e){
            
        }finally{
            manager.close();
        }
        return t;
    }
    
    public abstract List recuperarTodos()throws Exception;
}
