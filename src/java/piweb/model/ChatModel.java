/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import piweb.model.DAO.ChatDAO;
import piweb.model.DAO.MensagemDAO;
import piweb.model.entidades.Aluno;
import piweb.model.entidades.Chat;
import piweb.model.entidades.Mensagem;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
public class ChatModel {

    private ChatDAO cd = new ChatDAO();

    public void inserir(Chat c) {
        cd.inserir(c);
    }

    public List recuperaChatAluno(int id) {
        return cd.recuperarChatAluno(id);

    }
    
    public List recuperaChatProfessor(int id){
        return cd.recuperarChatProfessor(id);
    }

    public void deletaChat(Chat c) {
        MensagemDAO md= new MensagemDAO();
        List <Mensagem> listaMensagens= md.recuperarTodasMensagens(c.getId());
        
        for(int i = 0;i<listaMensagens.size();i++){
            md.deletarMensagem(listaMensagens.get(i));
        }
        
        cd.deletarChat(c);
    }

    public Chat recuperaChatEspecifico(Aluno a, Professor p) {
        return cd.recuperarChatAlunoProfessor(a.getId(), p.getId());

    }
    
    public void alterarChatProfessorAddMensagem(Chat c, String mensagem) {
        Calendar cal = Calendar.getInstance();
        Timestamp hora = new Timestamp(cal.getTimeInMillis());
        MensagemDAO md= new MensagemDAO();
        
        Mensagem m = new Mensagem(mensagem, Mensagem.ORIGEM.PROFESSOR, c, hora);
        
        
        md.inserir(m);
        
        c.getMensagens().add(m);

        cd.alterar(c);

    }

    public void alterarChatAlunoAddMensagem(Chat c, String mensagem) {
        Calendar cal = Calendar.getInstance();
        Timestamp hora = new Timestamp(cal.getTimeInMillis());
        MensagemDAO md= new MensagemDAO();
        
        
        
        Mensagem m = new Mensagem(mensagem, Mensagem.ORIGEM.ALUNO, c, hora);
        
        md.inserir(m);
        
        c.getMensagens().add(m);

        cd.alterar(c);

    }

    public boolean validaChatExistente(Aluno a, Professor p) {
        boolean b = true;
        if (cd.recuperarChatAlunoProfessor(a.getId(), p.getId()) != null) {
            b = false;
        }
        return b;

    }
    
    public List recuperaTodasMensagens(int id_chat){
        MensagemDAO md= new MensagemDAO();
        
        return md.recuperarTodasMensagens(id_chat);
    }

}
