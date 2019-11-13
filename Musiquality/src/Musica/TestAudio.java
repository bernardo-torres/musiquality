/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Musica;

import Model.Model.Nota;
import Model.Persistencia.Persistencia;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author bernardo
 */
public class TestAudio {
    
     public static Mixer mixer;
     public static Clip clip1;
     public static Clip clip2;
     public static Clip createdClip;
     public Persistencia per;
     public static Nota nota;
     
     public TestAudio (){
       
         Nota nota2 = null;
         per = Persistencia.getPersistencia();
         
         nota = per.getBaixo()[0];
         nota2 = per.getBateria()[0];
         System.out.println(nota2.getNome());
         System.out.println(nota2.getURL());
         
         System.out.println("Aqui\n");
         int i = 0;
         // clip.start();
         for(i=0; i<3; i++){
            nota.tocar();
            nota2.tocar();
            try{Thread.sleep(1000);}
            catch(InterruptedException e){}
         }
         nota.tocar();
         nota2.tocar();
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         nota2.tocar();
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         nota2.tocar();
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         nota.tocar();
         nota2.tocar();
         try{Thread.sleep(100);}
         catch(InterruptedException e){}
         nota2.tocar();
         try{Thread.sleep(100);}
         catch(InterruptedException e){}
         nota.tocar();
         try{Thread.sleep(100);}
         catch(InterruptedException e){}
         nota.tocar();
         try{Thread.sleep(100);}
         catch(InterruptedException e){}
         nota.tocar();
         nota.tocar();
         nota.tocar();
         nota.tocar();
         nota.tocar();
         nota.tocar();
         
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         
         // clip1.close();
         // clip2.close();
     }
     
    
}
