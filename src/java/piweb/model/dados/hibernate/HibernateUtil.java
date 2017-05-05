/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.dados.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Samuel
 */
public class HibernateUtil {
    
    private static HibernateUtil myself;
    private EntityManagerFactory factory;
    
    private HibernateUtil(){
        
       factory= Persistence.createEntityManagerFactory("persistencia");
    }
    
    public EntityManagerFactory getFactory(){
        return factory;
    }
    
    public static HibernateUtil getInstance(){
        if(myself==null){
            myself=new HibernateUtil();
        }
        
        return myself;
    }
    
    
}
