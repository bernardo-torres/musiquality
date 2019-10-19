/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

import Exceptions.ModelException;
import Exceptions.SystemException;
import Model.Persistencia.Persistencia;
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
    public Persistencia per;
    
    /*
    O Dashboard é uma variável responsável por definir as notas que serão tocadas;
    cada lista representa um tempo e contém os nomes das notas que serão tocadas naquele tempo
    
    Se o dashboard conter a nota "invalida", ele deverá ser ignorado durante a excecução 
    
    */
    
    private LinkedList<String>[] dashboard;
    
    public Levada(Notas n){
        this.n = n;
        this.bpm=100;
        this.tam=16;
        per = Persistencia.getPersistencia();
        dashboard = new LinkedList[tam];
        for(int i = 0;i<dashboard.length;i++){
            dashboard[i] = new LinkedList<>();
        }
        
    }

    public void setTamanhoMax(int nTempos) throws SystemException {
        if(nTempos < 0 || nTempos>dashboard.length)
            throw new SystemException("O tamanho " + nTempos + " eh inválido!");
        this.tam = nTempos;
        for(int i=tam;i<dashboard.length;i++)
                dashboard[i].clear();
    }

    public void switchNota(String nome,int tempo) throws SystemException{
        if(tempo<0 || tempo>=tam)
            throw new SystemException("Tamanho invalido!");
        //System.out.println("Foi");
        if(!dashboard[tempo].contains(nome))
            dashboard[tempo].add(nome);
        else
            dashboard[tempo].remove(nome);
        this.print(dashboard[tempo]);
    }
    
    public void addNota(String nome, int tempo) throws SystemException{
        if(tempo<0 || tempo>=tam)
            throw new SystemException("Tamanho invalido!");
        //System.out.println("Foi");
        if(!dashboard[tempo].contains(nome))
            dashboard[tempo].add(nome);
        this.print(dashboard[tempo]);
    }
    

    public void removeNota(int posicao,String nome) throws SystemException, ModelException{
        if(posicao<0||posicao>=dashboard.length)
            throw new SystemException("Posicao invalida!");
        System.out.println("remove");
        boolean remove = dashboard[posicao].remove(nome);
        if (remove == false)
            throw new ModelException ("A nota "+ nome + " não está no tempo " + posicao);
        this.print(dashboard[posicao]);
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
    
    private void print(LinkedList l){
        for(int i=0;i<l.size();i++)
            System.out.print(l.get(i)+"\t");
        System.out.println();
    }

    public boolean contains(String nome, int j) {
        return dashboard[j].contains(nome);
    }
    
    public void playLevada(){
        int tempo;
        float wait = 1000*15/bpm;
        int waitTime = (int)wait;
        System.out.println(wait);
        System.out.print("Comecando a tocar em "+ bpm +" bpm\n");
        for(tempo=0; tempo<16; tempo++){
            playLinkedList(dashboard[tempo]);
            bpmDelay(waitTime);
        }
    }
    
    private void bpmDelay(int waitTime){
        waitTime = (int)waitTime;
        // Calcula em ms o tempo de espera ente um tempo e outro
        // Cada compasso sao 4 batidas, logo cada tempo tem 1/4 do tempo da batida
        try{Thread.sleep(waitTime);}
        catch(InterruptedException e){}
    }
    // Itera na lista do tempo e toca todas as notas
    public void playLinkedList(LinkedList l){
        int notePosition;
        Nota nota;
        for(int i=0;i<l.size();i++){
            notePosition = per.bateriaHash.get(l.get(i));
            nota = per.getBateria()[notePosition];
            nota.tocar();
            System.out.print("Pegou nota "+ l.get(i) +", posicao " + notePosition + "\n");
        }
    }
}
