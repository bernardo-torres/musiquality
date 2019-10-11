/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistencia;

import Model.Model.Nota;

/**
 *
 * @author Usuário
 */

/*
Classe responsável por salvar e carregar os dados. É feita em forma de Singleton
*/
public class Persistencia{
    private static Persistencia persist;
    //URL onde serão salvos dados de configuração do programa. Isso inclui 
    //os nomes dos arquivos e das notas referentes a cada um dos instrumentos,
    //assim como as músicas criadas e similares.
    private final String urlCfg;
    
    private Nota[] bateria;
    private Nota[] baixo;
    private Nota[] Guitarra1;
    private Nota[] Guitarra2;
    
    private Persistencia(){
        this.urlCfg="";
        this.setNotas();
    }
    
    public static Persistencia getPersistencia(){
        if(persist==null)
            persist=new Persistencia();
        return persist;
    }
    
    /*
    Funções relacionadas à persistência de dados deverão ser implementadas
    */
    
    public Nota[] getBateria(){return null;}    
    public Nota[] getBaixo(){return null;}    
    public Nota[] getGuitarra1(){return null;}    
    public Nota[] getGuitarra2(){return null;}    

        
    private void setNotas() {
        
    }
    
    
}
