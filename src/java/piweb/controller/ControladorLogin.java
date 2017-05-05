/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import piweb.model.AdministradorModel;
import piweb.model.AlunoModel;
import piweb.model.ProfessorModel;
import piweb.model.entidades.Administrador;
import piweb.model.entidades.Aluno;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
@ManagedBean(name="cLogin")
@SessionScoped
public class ControladorLogin implements Serializable{

    private String email;
    private String senha;
    private AlunoModel am;
    private ProfessorModel pm;
    private AdministradorModel adminM;
    
    @PostConstruct
    public void construir(){
        am= new AlunoModel();
        pm= new ProfessorModel();
        adminM= new AdministradorModel();
    }
    
    public String fazerLogin(){
        
        String ret="";
        Aluno a=am.recuperarAlunoEmailSenhaDAO(email, senha);
        if(a!=null){
            this.setAlunoLogado(a);
            ret="TelaAluno.xhtml";
        }
        
        Professor p= pm.recuperarProfessorEmailSenhaDAO(email, senha);
        if(p!=null){
             this.setProfessorLogado(p);
            ret="TelaProfessor.xhtml";
            
        }
        
        email.toUpperCase();
        Administrador adm= adminM.recuperaAdmLoginSenha(email, senha);
        if(adm!=null){
            this.setAdmLogado(adm);
            ret="TelaAdmin.xhtml";
        }
            
        if(adm==null && a==null && p==null){
            
        FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Falha no Login","Email ou senha invalidos"));
        }  
        
        email="";
        senha="";
        
        return ret;
    }
    
    
    public String fazerLogout(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         return "TelaLogin.xhtml";
    
    }
    
    
    
    
    
    private void setAlunoLogado(Aluno a){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AlunoLogado", a);
    }
    
    private void setProfessorLogado(Professor p){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ProfessorLogado", p);
    }
    
    
    private void setAdmLogado(Administrador adm){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AdminLogado", adm);
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    
}
