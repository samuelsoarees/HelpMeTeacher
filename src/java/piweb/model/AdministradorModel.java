/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model;

import piweb.model.DAO.AdministradorDAO;
import piweb.model.entidades.Administrador;

/**
 *
 * @author Samuel
 */
public class AdministradorModel {
    private AdministradorDAO ad= new AdministradorDAO();
    
    
    
    public Administrador recuperaAdmLoginSenha(String login,String senha){
        return ad.recuperarLoginSenha(login, senha);
    }
    
    public void alteraAdm(Administrador a){
        ad.alterar(a);
    }
    
}
