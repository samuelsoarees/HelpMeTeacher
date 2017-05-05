/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import piweb.controller.builderbean.BuilderBeanProfessor;
import piweb.model.AlunoModel;
import piweb.model.ProfessorModel;
import piweb.model.entidades.Professor;

@ManagedBean(name = "cProfessor")
@SessionScoped
public class ControladorProfessor {
    
    private ProfessorModel pm;
    private BuilderBeanProfessor bProf;
    private AlunoModel am;
    private Professor selectedProfessor;
    
    @PostConstruct
    public void construir() {
        pm = new ProfessorModel();
        bProf = new BuilderBeanProfessor();
        am = new AlunoModel();
    }
    
    public String inserir() {
        boolean b = true;
        
        if (pm.validaSenhaIgual(bProf) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadProf:confirmaSenha",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Senhas diferentes"));
        }
        
        if (pm.validaEmailValido(bProf.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }
        
        if (pm.validaEmailIgualCad(bProf.criaProfessor())==false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email já cadastrado"));
        }
        
        if(pm.validaMatricula(bProf.getnMatricula())==false){
            b=false;
            FacesContext.getCurrentInstance().addMessage("formCadProf:nMatricula",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "A matricula já existe"));
        }
        
        if (b) {
            pm.inserirProfessorDAO(bProf.criaProfessor());
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O Professor " + bProf.getNome() + " foi Cadastrado com sucesso", ""));
            
             
            return "TelaAdmin.xhtml";
        }
        
        return null;
    }
    
    public String deletar(){
        Professor p;
        p=(Professor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProfessorLogado");
        pm.deletarProfessorDAO(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(p.getNome() + " foi deletado com sucesso", ""));
        return "TelaLogin.xhtml";
        
    }
    
    
    
    public String alterar(){
        Professor p=(Professor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProfessorLogado");
        boolean b=true;
        
     
        
        if (pm.validaEmailValido(p.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }
        
        if (pm.validaEmailIgualAlt(p)==false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email já cadastrado"));
        }
        
        
        if(pm.validaMatricula(bProf.getnMatricula())==false){
            b=false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:nMatricula",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "A matricula já existe"));
        }
        
        if(b){
        pm.alteraProfessorDAO(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(p.getNome() + " foi alterado com sucesso"));
        return "TelaProfessor.xhtml";
        }
        
        return null;
    }
    
    public List recuperaTodosProfessores(){
      return  pm.recuperaTodosProfessoresDAO();
    }

    public Professor getSelectedProfessor() {
        return selectedProfessor;
    }

    public void setSelectedProfessor(Professor selectedProfessor) {
        this.selectedProfessor = selectedProfessor;
    }
    
    
    
    
    public ProfessorModel getPm() {
        return pm;
    }
    
    public void setPm(ProfessorModel pm) {
        this.pm = pm;
    }
    
    public BuilderBeanProfessor getbProf() {
        return bProf;
    }
    
    public void setbProf(BuilderBeanProfessor bProf) {
        this.bProf = bProf;
    }
    
}
