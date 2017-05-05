/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import piweb.controller.builderbean.BuilderBeanAluno;
import piweb.model.DAO.AlunoDAO;
import piweb.model.entidades.Aluno;

/**
 *
 * @author Samuel
 */
public class AlunoModel {
 
    private AlunoDAO ad=new AlunoDAO();
    
    
    public AlunoModel(){
        
    }
    
    public void inserirAlunoDAO(Aluno a){
        ad.inserir(a);
    }
    
    public boolean validaEmailIgualCad(Aluno a){
        ProfessorModel pm= new ProfessorModel();
        boolean ret=true;
        if(pm.recuperaProfessorEmailDAO(a.getEmail()) != null|| ad.recuperaAlunoEmailDao(a.getEmail())!=null){
            ret= false;
        }
        return ret;
    }
    
    public boolean validaEmailIgualAlt(Aluno a){
        ProfessorModel pm= new ProfessorModel();
        boolean ret=true;
        
        if(pm.recuperaProfessorEmailDAO(a.getEmail())!=null){
            ret=false;
        }
        return ret;
    }
    
    
    public boolean validaEmail(String email){
          boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
    
    public boolean validaSenhaIgual(BuilderBeanAluno b){
       boolean retorno =true;
        
        if(!b.getSenha().equals(b.getConfirmaSenha())){
            retorno=false;
        }
        return retorno;
    }
    
    public Aluno recuperarAlunoEmailSenhaDAO(String email,String senha){
       
        return ad.recuperarPorEmailSenhaDAO(email,senha);
        
    }
    
    public List recuperarTodosAlunos(){
        return ad.recuperarTodos();
    }
    
    public Aluno alterarAluno(Aluno a){
        Aluno aluno=(Aluno)ad.alterar(a);
        return aluno;
                
    }
    
    public void deletarAlunoDAO(Aluno a){
        ad.deletarAluno(a);
    }
    
    public Aluno recuperarAlunoEmailDAO(String email){
        return ad.recuperaAlunoEmailDao(email);
    }
    
    
}
