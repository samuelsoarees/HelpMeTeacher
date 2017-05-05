/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;
import piweb.model.dados.hibernate.HibernateUtil;
import piweb.model.entidades.Chat;

/**
 *
 * @author Samuel
 */
public class ChatDAO extends DAO {

    @Override
    public List recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void deletarChat(Chat c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            
            
            
            
            this.manager.getTransaction().begin();
            c = manager.find(Chat.class, c.getId());
            manager.remove(c);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }

    }
    
    
    //Recupera todos os chats que o professor possui
    public List recuperarChatProfessor(int id){
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        String hql="FROM Chat WHERE prof_id=:idP";
        try {

            return manager.createQuery(hql).setParameter("idP", id).getResultList();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }
        return null;
    }

    
    
    //Recupera todos os chats que o aluno possui
    public List recuperarChatAluno(int id){
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        String hql="FROM Chat WHERE aluno_id=:idA";
        try {

            return manager.createQuery(hql).setParameter("idA", id).getResultList();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }
        return null;
    }
    
    
     public Chat recuperarChatAlunoProfessor(int idAlu,int idProf){
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        String hql="FROM Chat WHERE aluno_id=:idA and prof_id=:idP";
        try {

            return(Chat) manager.createQuery(hql).setParameter("idA", idAlu).setParameter("idP", idProf).getSingleResult();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }
        return null;
    }
}
