/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.entidades;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author Samuel
 */

    @Entity
public class Mensagem {
   
   
        public enum ORIGEM{
            ALUNO,
            PROFESSOR;
            
            public int getNumero() {
                
                return this.ordinal();
            }
            
        }
        
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   @Column
   private String mensagem;
   @Column
   private ORIGEM origem;
   @ManyToOne
   private Chat chat;
   @Column
   private Timestamp hora;
   
    
    public Mensagem(){
    }
    
    public Mensagem(String mensagem,ORIGEM origem,Chat chat,Timestamp hora){
        this.mensagem=mensagem;
        this.origem=origem;
        this.chat=chat;
        this.hora=hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ORIGEM getOrigem() {
        return origem;
    }

    public void setOrigem(ORIGEM origem) {
        this.origem = origem;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }
    
    

    
}


