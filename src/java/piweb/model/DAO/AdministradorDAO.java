/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;
import javax.persistence.Query;
import piweb.model.dados.hibernate.HibernateUtil;
import piweb.model.entidades.Administrador;

/**
 *
 * @author Samuel
 */
public class AdministradorDAO extends DAO {

    @Override
    public List recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Administrador recuperarLoginSenha(String login, String senha) {
        String hql = "FROM Administrador a WHERE login=:loginA and senha=:senhaA";
        Administrador a = null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            Query query = manager.createQuery(hql);

            a = (Administrador) query.setParameter("loginA", login).setParameter("senhaA", senha).getSingleResult();

        } catch (Exception e) {
            e.getMessage();

        } finally {
            manager.close();
        }
        return a;
    }

    public void deletarAdministrador(Administrador a) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            this.manager.getTransaction().begin();
            a = manager.find(Administrador.class, a.getId());
            manager.remove(a);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            manager.close();
        }

    }

}
