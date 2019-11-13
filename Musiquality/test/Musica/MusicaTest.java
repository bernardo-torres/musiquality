/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Musica;

import Exceptions.SystemException;
import static Main.TPES.g;
import View.MainView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Be
 */
public class MusicaTest {
    
    public MusicaTest() {
    }
   


    /**
     * Test of playLevadas method, of class Musica.
     */
    @Test(expected = NullPointerException.class)
    public void testPlayLevadas() {
        System.out.println("playLevadas");
        int bpm = 100;
        int a = Musica.playLevadas(bpm);
        assertEquals(a,1);
        
    }
    
    @Test
     public void bpmDelayTest(){
  
        int waitTime = 100;
        // Calcula em ms o tempo de espera ente um tempo e outro
        // Cada compasso sao 4 batidas, logo cada tempo tem 1/4 do tempo da batida
        long initTime = System.currentTimeMillis();
        try{Thread.sleep(waitTime);}
        catch(InterruptedException e){}
        long curTime = System.currentTimeMillis();
        assertEquals(initTime + waitTime,curTime);
    }    
   
    
}
