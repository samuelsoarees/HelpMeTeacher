/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piweb.model.DAO;

import java.util.List;

/**
 *
 * @author Samuel
 */
public interface DAOInterface <T>{
    
    
    public Object inserir(T t);
    public Object alterar(T t);
    public List<T> recuperarTodos()throws Exception;
    
    
    
}
