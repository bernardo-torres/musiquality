/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Usuário
 */

    /*
    Elemento básico da música. Pode ser tanto nota musical quanto nome do tambor 
    da bateria responsável pelo som 
    */
public class Nota {
    private final String nome;
    private final String url;
    private Clip clip;
    //Mais variáveis devem ser adicionadas para representar o som da nota
    
    public Nota(String nome, String myUrl) {
        this.nome = nome;
        this.url = myUrl;
        // Testa se arquivo existe (nao é nofile). Se nao for, cria clipe com o url
        if (Objects.equals(this.url, new String("nofile"))){
            System.out.print("Tentou-se carregar nota " + nome + " que nao possui arquivo\n");
            // this.clip = null;
        }
        else{
            // System.out.print("URL = " + this.url+ "\n");
           createClip(url);
        }
    }
    //Nome da nota
    public String getNome(){return this.nome;}
    // Endereço da nota no computado
    public String getURL(){return this.url;}
    //Define a URL da nota. Se ela for inválida, lança exceção
    public void tocar(){
        if (clip == null){
            System.out.print("Imposivel tocar nota " + nome + " , clip nao foi inicializado\n");
        }
        else{
            playClip(); 
        }
        // Som.tocar(url);
    }
    
    // Cria um clip de musica com o URL do arquivo, fica armazenado na variavel clip.
     public void createClip(String url) {
        try{
            URL soundURL = Nota.class.getResource(url);
            System.out.println("Carregando arquivo "+ url);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }
        catch(LineUnavailableException lue){lue.printStackTrace();}
        catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
        catch(IOException ioe){ioe.printStackTrace();}
    }
     /**
 * play sound clip
 */
    public void playClip() {
        if (clip != null) {
            try {
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
                // System.out.println("Tocou?\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            // System.out.println("Tocou ou nao carai\n");
        }
    }

}
