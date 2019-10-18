/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
     
     public TestAudio (){
       
      
         clip1 = createClip("/Sounds/Baixo/A1.wav");
         clip2 = createClip("/Sounds/Bateria/Caixa.wav");
         int i = 0;
         // clip.start();
         for(i=0; i<3; i++){
            playClip(clip1);
            playClip(clip2);
            try{Thread.sleep(1000);}
            catch(InterruptedException e){}
         }
         playClip(clip1);
         playClip(clip2);
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         playClip(clip2);
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         playClip(clip2);
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         playClip(clip1);
         playClip(clip2);
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         playClip(clip2);
         try{Thread.sleep(200);}
         catch(InterruptedException e){}
         
         clip1.close();
         // clip2.close();
     }
     
     public static Clip createClip(String url) {
        try{
            URL soundURL = TestAudio.class.getResource(url);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            createdClip = AudioSystem.getClip();
            createdClip.open(audioStream);
        }
        catch(LineUnavailableException lue){lue.printStackTrace();}
        catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
        catch(IOException ioe){ioe.printStackTrace();}
        return createdClip;
    }
     /**
 * play sound clip
 */
    public static void playClip(Clip clip) {
        if (clip != null) {
            try {
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
