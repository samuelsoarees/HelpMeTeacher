/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Samuel
 */
@Entity
public class Chat extends Observable implements Serializable{
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    
    private List<Mensagem> mensagens;
    @OneToOne
    private Professor prof;
    @OneToOne
    private Aluno aluno;
    
    public Chat(List mensagem,Professor p,Aluno a){
        this.aluno=a;
        this.prof=p;
        this.mensagens=mensagem;
    }
    
    public Chat(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
   
    
}
