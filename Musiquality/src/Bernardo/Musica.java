/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bernardo;

import Bernardo.TestAudio;
import Main.TPES;
import Model.Model.Levada;

/**
 *
 * @author Be
 */
public class Musica {
    
    public static int tocando;
    
    // Ta tocando isso quando aperta o play
    public static void playMusica(int bpm){
       if (tocando == 0){
            playLevadas(bpm);
       }
    }
    /* Toca os tempos 0 de todas as levadas de todos os instrumentos, depois toca os
    tempos 1, 2, etc.. */
    public static void playLevadas(int bpm){
        tocando = 1;
        int tempo, levadaCnt;
        float wait = 1000*15/bpm;  // tempo de espera entre 2 tempos
        int waitTime = (int)wait;
        System.out.print("Comecando a tocar em "+ bpm +" bpm\n");
        Levada aux;
        for(tempo=0; tempo<16; tempo++){
            for(levadaCnt = 0;levadaCnt<10;levadaCnt++){
                aux =  TPES.g.drum.controller.levada[levadaCnt];
                aux.setBpm(150);
                aux.playLinkedList(aux.dashboard[tempo]);

                aux =  TPES.g.g1.controller.l[levadaCnt];
                aux.setBpm(150);
                aux.playLinkedList(aux.dashboard[tempo]);

                aux =  TPES.g.g2.controller.l[levadaCnt];
                aux.setBpm(150);
                aux.playLinkedList(aux.dashboard[tempo]);

                aux =  TPES.g.bass.controller.l[levadaCnt];
                aux.setBpm(150);
                aux.playLinkedList(aux.dashboard[tempo]);
            }     
            bpmDelay(waitTime);
        }
        tocando = 0;
    }    
    private static void bpmDelay(int waitTime){
        waitTime = (int)waitTime;
        // Calcula em ms o tempo de espera ente um tempo e outro
        // Cada compasso sao 4 batidas, logo cada tempo tem 1/4 do tempo da batida
        try{Thread.sleep(waitTime);}
        catch(InterruptedException e){}
    }    
    
}
