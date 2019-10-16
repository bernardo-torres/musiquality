/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

import Exceptions.ModelException;
import Exceptions.SystemException;
import java.util.LinkedList;

/**
 *
 * @author Usuário
 * 
 * 1 - Closed HH
 * 2 - Open HH
 * 3 - Bumbo
 * 4 - Caixa
 * 5 - Tom 1
 * 6 - Tom 2
 * 7 - Surdo
 * 8 - Crash
 * 9 - Ride
 * 
 */
public class Levada{
    private final Notas n;
    private int tam;
    private int bpm;
    
    /*
    O Dashboard é uma variável responsável por definir as notas que serão tocadas;
    cada lista representa um tempo e contém os nomes das notas que serão tocadas naquele tempo
    
    Se o dashboard conter a nota "invalida", ele deverá ser ignorado durante a excecução 
    
    */
    
    private LinkedList<String>[] dashboard;
    
    public Levada(Notas n,int contraTempos){
        this.n = n;
        this.tam = contraTempos;
        this.bpm=0;
        
        dashboard = new LinkedList[tam];
        for(int i = 0;i<dashboard.length;i++){
            dashboard[i] = new LinkedList<>();
        }
        
    }

    public void setTamanhoMax(int nTempos) throws SystemException {
        if(nTempos<0 || nTempos>=dashboard.length)
            throw new SystemException("Tamanho inválido!");
        this.tam = nTempos;
        for(int i=tam;i<dashboard.length;i++)
                dashboard[i].clear();
    }

    public void addNota(String nome, int tempo) throws SystemException{
        if(tempo<0 || tempo>=dashboard.length)
            throw new SystemException("Tamanho invalido!");
        
        if(!dashboard[tempo].contains(nome))
            dashboard[tempo].add(nome);
        
    }

    public void removeNota(int posicao,String nome) throws SystemException, ModelException{
        if(posicao<0||posicao>=dashboard.length)
            throw new SystemException("Posicao invalida!");
        
        boolean remove = dashboard[posicao].remove(nome);
        
        if (remove == false)
            throw new ModelException ("A nota "+ nome + " não está no tempo " + posicao);
    }

    public void limpaNotas() {
        for(int i=0;i<tam;i++)  dashboard[i].clear();
    }

    public void tocar(){}
    public void parar(){}
    public void pausar(){}

    public int getBpm() {return bpm;}
    public void setBpm(int bpm) {this.bpm = bpm;}
    public int getTamanho() {return tam;}
    
    public LinkedList<String> getTempo(int t) throws SystemException{
        if(t>=tam)
            throw new SystemException("Índice inválido!");
        return dashboard[t];
    }
}
