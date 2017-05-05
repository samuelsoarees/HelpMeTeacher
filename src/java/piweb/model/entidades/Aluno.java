/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.entidades;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
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
@Table(name="Aluno")
public class Aluno  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column(unique=true)
    private String email;
    @Column
    private String senha;
    @Column
    private String materiaFavorita;
    @Column
    private long telefone;
    @Column
    private char sexo;
            
   
    public Aluno(){
        
    }
    
    public Aluno(String nome,String email,String senha,String materiaFavorita,long telefone,char sexo){
     this.nome=nome;
     this.email=email;
     this.senha=senha;
     
     this.materiaFavorita=materiaFavorita;
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

    public String getMateriaFavorita() {
        return materiaFavorita;
    }

    public void setMateriaFavorita(String materiaFavorita) {
        this.materiaFavorita = materiaFavorita;
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

    
    
    
    

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", email=" + email + '}';
    }

   

   
    
    
}
