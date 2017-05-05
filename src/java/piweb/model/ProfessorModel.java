/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import piweb.controller.builderbean.BuilderBeanProfessor;
import piweb.model.DAO.ProfessorDAO;
import piweb.model.entidades.Professor;

/**
 *
 * @author Samuel
 */
public class ProfessorModel {

    private ProfessorDAO pd = new ProfessorDAO();

    public Professor inserirProfessorDAO(Professor p) {
        pd.inserir(p);
        return p;
    }
    
    public boolean validaMatricula(String matricula){
        boolean b= true;
        Professor p = pd.recuperaPorMatricula(matricula);
        
        if(p!=null){
            b=false;
        }
        
        
        return b;
    }

    public boolean validaEmailIgualCad(Professor p) {
        AlunoModel am = new AlunoModel();
        boolean ret = true;
        if (pd.recuperaPorEmail(p.getEmail()) != null || am.recuperarAlunoEmailDAO(p.getEmail()) != null) {
            ret = false;
        }
        return ret;
    }
    
    public boolean validaEmailIgualAlt(Professor p){
        AlunoModel am= new AlunoModel();
        boolean ret=true;
        
        if(am.recuperarAlunoEmailDAO(p.getEmail())!=null){
            ret=false;
        }
        return ret;
    }

    public boolean validaEmailValido(String email) {
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

    public boolean validaSenhaIgual(BuilderBeanProfessor p) {
        boolean retorno = true;
        if (!p.getSenha().equals(p.getConfirmaSenha())) {
            retorno = false;
        }
        return retorno;
    }
    
    
    public List recuperaTodosProfessoresDAO(){
         return pd.recuperarTodos();
    }

    public void deletarProfessorDAO(Professor p) {
        pd.deletarProfessor(p);
    }
    
    public void alteraProfessorDAO(Professor p){
        pd.alterar(p);
    }

    public Professor recuperarProfessorEmailSenhaDAO(String email, String senha) {
        return pd.recuperarPorEmailSenhaP(email, senha);

    }

    public Professor recuperaProfessorEmailDAO(String email) {
        return pd.recuperaPorEmail(email);
    }

}
