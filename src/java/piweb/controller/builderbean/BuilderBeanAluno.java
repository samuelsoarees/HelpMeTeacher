/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller.builderbean;

import javax.faces.bean.ManagedBean;
import piweb.model.entidades.Aluno;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "bAluno")
public class BuilderBeanAluno {

    private String nome;
    private String email;
    private String senha;
    private String confirmaSenha;
    private String materiafavorita;
    private long telefone;
    private char sexo;

    public BuilderBeanAluno() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getMateriafavorita() {
        return materiafavorita;
    }

    public void setMateriafavorita(String materiafavorita) {
        this.materiafavorita = materiafavorita;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Aluno criaAluno() {
        return new Aluno(nome, email, senha, materiafavorita, telefone, sexo);
    }

}
