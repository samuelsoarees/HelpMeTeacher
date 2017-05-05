/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import piweb.controller.builderbean.BuilderBeanAluno;
import piweb.model.AdministradorModel;
import piweb.model.AlunoModel;
import piweb.model.ChatModel;
import piweb.model.ProfessorModel;
import piweb.model.entidades.Administrador;
import piweb.model.entidades.Aluno;
import piweb.model.entidades.Chat;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "cAdmin")
@SessionScoped
public class ControladorAdministrador  implements Serializable{

    private AdministradorModel admModel;
    private AlunoModel alunoModel;
    private ProfessorModel profModel;

    private Professor selectedProf;
    private Aluno selectedAluno;

    @PostConstruct
    public void construir() {
        admModel = new AdministradorModel();
        alunoModel = new AlunoModel();
        profModel = new ProfessorModel();
    }

    public String alteraAdm() {
        Administrador a = (Administrador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AdminLogado");

        admModel.alteraAdm(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(a.getNome() + " foi alterado com sucesso"));
        return "TelaAdmin.xhtml";

    }

    public String alterarAluno() {
        boolean b = true;
        if (alunoModel.validaEmail(selectedAluno.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltAluno:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }

        if (alunoModel.validaEmailIgualAlt(selectedAluno) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltAluno:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Email já está cadastrado"));
        }

        if (b) {
            alunoModel.alterarAluno(selectedAluno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(selectedAluno.getNome() + " foi alterado com sucesso"));
            return "TelaAdmin.xhtml";
        }

        return null;

    }

    public String alterar() {
        boolean b = true;

        if (profModel.validaEmailValido(selectedProf.getEmail()) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }

        if (profModel.validaEmailIgualAlt(selectedProf) == false) {
            b = false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email já cadastrado"));
        }
        
        if(profModel.validaMatricula(selectedProf.getnMatricula())==false){
            b=false;
            FacesContext.getCurrentInstance().addMessage("formAltProf:nMatricula",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "A matricula já existe"));
        }

        if (b) {
            profModel.alteraProfessorDAO(selectedProf);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(selectedProf.getNome() + " foi alterado com sucesso"));
            return "TelaAdmin.xhtml";
        }

        return null;
    }

    public boolean verificaLogadoAdmin() {
        boolean b = true;
        Administrador a = (Administrador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AdminLogado");
        if (a == null) {
            b = false;
        }
        return b;
    }

    public String deletaProfessor() {
        ChatModel cm = new ChatModel();

        List<Chat> c = cm.recuperaChatProfessor(selectedProf.getId());

        for (int i = 0; i < c.size(); i++) {
            cm.deletaChat(c.get(i));
        }

        profModel.deletarProfessorDAO(selectedProf);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O " + selectedProf.getNome() + " foi deletado com sucesso"));
        return "RecuperaTodosProfessores.xhtml";
    }

    public String deletaAlunoAdm() {
        ChatModel cm = new ChatModel();

        List<Chat> c = cm.recuperaChatAluno(selectedAluno.getId());

        for (int i = 0; i < c.size(); i++) {
            cm.deletaChat(c.get(i));
        }

        alunoModel.deletarAlunoDAO(selectedAluno);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O " + selectedAluno.getNome() + " foi deletado com sucesso"));

        return "RecuperaTodosAlunosAdm.xhtml";
    }

    public String fazerLogoutAdm() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "TelaLogin.xhtml";
    }

    public List recuperaTodosAlunos() {
        return alunoModel.recuperarTodosAlunos();
    }

    public List recuperaTodosProfessores() {
        return profModel.recuperaTodosProfessoresDAO();
    }

    public Aluno getSelectedAluno() {
        return selectedAluno;
    }

    public void setSelectedAluno(Aluno selectedAluno) {
        this.selectedAluno = selectedAluno;
    }

    public Professor getSelectedProf() {
        return selectedProf;
    }

    public void setSelectedProf(Professor selectedProf) {
        this.selectedProf = selectedProf;
    }

}
