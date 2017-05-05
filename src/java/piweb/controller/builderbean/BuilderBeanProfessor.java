/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.controller.builderbean;

import javax.faces.bean.ManagedBean;


import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
@ManagedBean(name = "bProf")
public class BuilderBeanProfessor {

    private String nome;
    private String email;
    private String senha;
    private String confirmaSenha;
    private String nMatricula;
    private String materiaLeciona;
    private long telefone;
    private char sexo;

    public BuilderBeanProfessor() {

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

    public String getMateriaLeciona() {
        return materiaLeciona;
    }

    public void setMateriaLeciona(String materiaLeciona) {
        this.materiaLeciona = materiaLeciona;
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

    public String getnMatricula() {
        return nMatricula;
    }

    public void setnMatricula(String nMatricula) {
        this.nMatricula = nMatricula;
    }
    
    
    

    public Professor criaProfessor() {
        return new Professor(nome, email, senha, nMatricula, materiaLeciona, telefone, sexo);
    }

}
