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
import piweb.model.entidades.Mensagem;

/**
 *
 * @author Samuel
 */
public class MensagemDAO extends DAO {

    @Override
    public List recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deletarMensagem(Mensagem m) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            this.manager.getTransaction().begin();
            m = manager.find(Mensagem.class, m.getId());
            manager.remove(m);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }

    }
    
    public List recuperarTodasMensagens(int idChat)  {
         String hql="FROM Mensagem m WHERE chat_id=:id_chat";
      List <Mensagem> msg=null;
        manager=HibernateUtil.getInstance().getFactory().createEntityManager();
        
        
        try{
        Query query= manager.createQuery(hql);
        msg=(List<Mensagem>) query.setParameter("id_chat", idChat).getResultList();
        }catch(Exception e){
            
        }finally{
            manager.close();
            
        }
        return msg;
    }
}