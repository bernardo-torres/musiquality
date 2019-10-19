/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bernardo;

import Bernardo.TestAudio;
import Main.TPES;

/**
 *
 * @author Be
 */
public class Musica {
    
    // Ta tocando isso quando aperta o play
    public static void playMusica(){
        TPES.g.drum.controller.levada[0].playLevada();
        
        // Audio de teste
        // TestAudio a = new TestAudio();
    }
}
