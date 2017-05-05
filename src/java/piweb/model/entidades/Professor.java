/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.entidades;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.enterprise.event.ObserverException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "Professor")
public class Professor implements Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column(unique = true)
    private String email;
    @Column
    private String senha;
    @Column
    private String nMatricula;
    @Column
    private String materiaLeciona;
    @Column
    private long telefone;
    @Column
    private char sexo;

    public Professor() {

    }

    public Professor(String nome, String email, String senha,String nMatricula,String materiaLeciona,long telefone,char sexo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nMatricula=nMatricula;
        this.materiaLeciona=materiaLeciona;
        this.telefone=telefone;
        this.sexo=sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
