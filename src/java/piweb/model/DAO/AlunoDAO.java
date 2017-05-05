/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;
import javax.persistence.Query;
import piweb.model.dados.hibernate.HibernateUtil;
import piweb.model.entidades.Aluno;

/**
 *
 * @author Samuel
 */
public class AlunoDAO extends DAO {

    public void deletarAluno(Aluno a) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            this.manager.getTransaction().begin();
            a = manager.find(Aluno.class, a.getId());
            manager.remove(a);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }

    }

    public Aluno recuperarPorEmailSenhaDAO(String email, String senha){
        String hql = "FROM Aluno a WHERE email=:emailP and senha=:senhaP";
        Aluno a=null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);

            a=(Aluno) query.setParameter("emailP", email).setParameter("senhaP", senha).getSingleResult();
            
            
        } catch (Exception e) {
           e.getMessage();
                   
        } finally{
            manager.close();
        }
        return a;
    }

    @Override
    public List recuperarTodos()  {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        String hql="FROM Aluno";
        try {

            return manager.createQuery(hql).getResultList();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }
        return null;
    }
    
    public Aluno recuperaAlunoEmailDao(String email){
         String hql="FROM Aluno a WHERE email=:emailP";
       Aluno a= null;
        manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        
        
        try{
        Query query= manager.createQuery(hql);
        a= (Aluno) query.setParameter("emailP", email).getSingleResult();
        }catch(Exception e){
            
        }finally{
            manager.close();
        }
        
        return a;
    }

}
