/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

import Exceptions.ModelException;
import Exceptions.SystemException;

/**
 *
 * @author Usuário
 */

/*
    Determina um conjunto de notas para um determinado instrumento
*/
public interface Notas {
    public String getNomeNota(int indice) throws SystemException;
    public int getIndiceNota(String nome) throws ModelException;
    
    public void tocar(int indice) throws SystemException;
    public void tocar(String nome) throws ModelException;
    
    public String[] getNomes();
    
    public int getQtd();
}
