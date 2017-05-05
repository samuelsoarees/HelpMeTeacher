/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import piweb.model.AlunoModel;
import piweb.controller.builderbean.BuilderBeanAluno;
import piweb.model.ProfessorModel;
import piweb.model.entidades.Administrador;
import piweb.model.entidades.Aluno;

/**
 *
 * @author Samuel
 */



@ManagedBean(name="cAluno")
@ViewScoped
public class ControladorAluno {
// empty message
    private BuilderBeanAluno bAluno;
    private AlunoModel am;
    private ProfessorModel pm;

    @PostConstruct
    public void construir() {
        this.bAluno = new BuilderBeanAluno();
        this.am = new AlunoModel();
        this.pm = new ProfessorModel();
    }

    public String inserir() {
        
        boolean b = true;
        if (am.validaEmail(bAluno.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadAluno:emailE",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }

        if (am.validaEmailIgualCad(bAluno.criaAluno()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadAluno:emailE", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Email já está cadastrado"));
        }

        if (am.validaSenhaIgual(bAluno) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formCadAluno:confirmaSenha",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Senhas diferentes"));
        }

        if (b) {
            am.inserirAlunoDAO(bAluno.criaAluno());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Aluno " + bAluno.getNome() + " foi Cadastrado com sucesso", ""));
            
            Administrador adm=(Administrador)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AdminLogado");
            
            if(adm!=null){
                return "TelaAdmin.xhtml";
            }else{
                return "TelaLogin.xhtml";
            }
            
            
        }

        return null;

    }

    public String alterar() {
        Aluno a = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AlunoLogado");
        
        
            
        boolean b = true;
        if (am.validaEmail(a.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltAluno:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }

        if (am.validaEmailIgualAlt(a) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltAluno:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Email já está cadastrado"));
        }

        
        if(b){
        am.alterarAluno(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(a.getNome() + " foi alterado com sucesso"));
        return "TelaAluno.xhtml";
        }
        
        
        return null;

        
    }

    public String deletar() {
        Aluno a = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AlunoLogado");
        am.deletarAlunoDAO(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(a.getNome() + " foi deletado com sucesso", ""));

        return "TelaLogin.xhtml";
    }

    public boolean verificaAlunoLogado(){
        boolean b= true;
        Aluno a = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AlunoLogado");
        
        if(a==null){
            b=false;
        }
        return b;
    }
    
    public BuilderBeanAluno getbAluno() {
        return bAluno;
    }

    public void setbAluno(BuilderBeanAluno bAluno) {
        this.bAluno = bAluno;
    }

    public AlunoModel getAm() {
        return am;
    }

    public void setAm(AlunoModel am) {
        this.am = am;
    }
}
