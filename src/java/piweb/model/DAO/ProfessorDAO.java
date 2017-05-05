/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;
import javax.persistence.Query;
import piweb.model.dados.hibernate.HibernateUtil;
import piweb.model.entidades.Professor;


/**
 *
 * @author Samuel
 */
public class ProfessorDAO extends DAO{

   
    public Professor recuperarPorEmailSenhaP(String email,String senha) {
       String hql="FROM Professor p WHERE email=:emailP and senha=:senhaP";
       Professor p= null;
       manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        try{
           Query query=manager.createQuery(hql);
           
           p=(Professor) query.setParameter("emailP", email).setParameter("senhaP", senha).getSingleResult();
           
           
       }catch(Exception e){
           e.getMessage();
       }finally{
            manager.close();
        }
       return p;
    }
    
    
    public Professor recuperaPorMatricula(String matricula){
        
       String hql="FROM Professor p WHERE nMatricula=:matricula";
       Professor p= null;
       manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        try{
           Query query=manager.createQuery(hql);
           
           p=(Professor) query.setParameter("matricula", matricula).getSingleResult();
           
           
       }catch(Exception e){
           e.getMessage();
       }finally{
            manager.close();
        }
       return p;
    }

    
    @Override
    public List recuperarTodos() {
       manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       String hql="FROM Professor";
       
       List <Professor> listaProf=null;
        try {

            listaProf= manager.createQuery(hql).getResultList();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }
        return listaProf;
    }
    
    
    
    
    public Professor recuperaPorEmail(String email){
        String hql="FROM Professor p WHERE email=:emailP";
        Professor p= null;
        manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        
        
        try{
        Query query= manager.createQuery(hql);
        p= (Professor) query.setParameter("emailP", email).getSingleResult();
        }catch(Exception e){
            
        }finally{
            manager.close();
        }
        
        
        return p;
    }
    
    
    
      public void deletarProfessor(Professor p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            this.manager.getTransaction().begin();
            p = manager.find(Professor.class, p.getId());
            manager.remove(p);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }

    }
    
}
    