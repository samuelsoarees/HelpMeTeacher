/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller.builderbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import piweb.model.entidades.Aluno;
import piweb.model.entidades.Chat;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "bChat")
public class BuilderBeanChat {

    private List mensagem;
    private Professor p;
    private Aluno a;

    public BuilderBeanChat() {

    }

    public List getMensagem() {
        return mensagem;
    }

    public void setMensagem(List mensagem) {
        this.mensagem = mensagem;
    }

    public Professor getP() {
        return p;
    }

    public void setP(Professor p) {
        this.p = p;
    }

    public Aluno getA() {
        return a;
    }

    public void setA(Aluno a) {
        this.a = a;
    }

    public Chat criarChat() {
        return new Chat(mensagem, p, a);
    }
}
