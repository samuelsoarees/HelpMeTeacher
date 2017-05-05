/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import piweb.model.ChatModel;
import piweb.model.entidades.Aluno;
import piweb.model.entidades.Chat;
import piweb.model.entidades.Mensagem;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "cChat")
@SessionScoped

public class ControladorChat {

    private ChatModel cm;
    private Chat selectedChat;
    private String mensagem;

    @PostConstruct
    public void construtor() {
        cm = new ChatModel();
    }

    public String criarChat(Professor p) {
        List<Mensagem> mensagens = new ArrayList();
        Aluno a = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AlunoLogado");

        Chat c = new Chat(mensagens, p, a);

        if (cm.validaChatExistente(a, p) == false) {
            Chat c2 = cm.recuperaChatEspecifico(a, p);

            setSelectedChat(c2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O chat já foi criado", ""));

            return "TelaConversaAluno.xhtml";
        } else {
            cm.inserir(c);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O chat foi criado com sucesso."));

            return "TelaAluno.xhtml";
        }
    }

    public List recuperaChatAluno() {
        Aluno a = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AlunoLogado");

        return cm.recuperaChatAluno(a.getId());
    }
    
    public List recuperaChatsProfessor(){
        Professor p=(Professor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProfessorLogado");
        
        return cm.recuperaChatProfessor(p.getId());
    }

    public String deletaChat() {
        Chat c = selectedChat;

        cm.deletaChat(c);
        return "TelaAluno.xhtml";
    }

    public String atualizaChatAddMensagemAluno() {

        cm.alterarChatAlunoAddMensagem(selectedChat, mensagem);

        this.mensagem = "";
        return "TelaConversaAluno.xhtml";
    }
    public String atualizaChatAddMensagemProfessor() {

        cm.alterarChatProfessorAddMensagem(selectedChat, mensagem);

        this.mensagem = "";
        return "TelaConversaProfessor.xhtml";
    }

    public List recuperaMensagemChat() {
        return cm.recuperaTodasMensagens(selectedChat.getId());
    }
    
    

    public Chat getSelectedChat() {
        return selectedChat;
    }

    public void setSelectedChat(Chat selectedChat) {
        this.selectedChat = selectedChat;
    }

    public ChatModel getCm() {
        return cm;
    }

    public void setCm(ChatModel cm) {
        this.cm = cm;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
