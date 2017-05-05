/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller.builderbean;

import javax.faces.bean.ManagedBean;
import piweb.model.entidades.Administrador;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "bAdministrador")
public class BuilderBeanAdministrador {
    private String nome;
    private String login;
    private String senha;
    private String confirmaSenha;
    
    
    public BuilderBeanAdministrador(){
        
    }
 
    public BuilderBeanAdministrador(String nome,String login,String senha,String confirmaSenha){
        this.nome=nome;
        this.login= login;
        this.senha=senha;
        this.confirmaSenha=confirmaSenha;
                
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    
    public Administrador criaAdministrador(){
        return new Administrador(this.nome, this.login, this.senha);
    }
}
