/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.ModelException;
import Main.Util;
import Model.Model.Levada;
import Model.Model.Notas;
import java.awt.Color;
import javax.swing.JLabel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Be
 */
public class CordaControllerTest {
    
    Notas bass;
    Levada[] levada;
    
    public CordaControllerTest() {
    }
 
    @Before
    public void setUp() throws ModelException {
      bass = new Notas(Util.BASS);
      levada=new Levada[10];
      for(int i=0;i<levada.length;i++)
           levada[i]=new Levada(bass);
    }
    
    /**
     * Testa getnomes e compara com nomes pegos das notas de bass
     */
    @Test
    public void testGetNomes() {
         String [] bassNames= bass.getNomes();
        
        
        System.out.println("getNomes");
        CordaController instance = new CordaController(Util.BASS);
        int oitava = 1;
        String[] expResult = null;
        String[] result = instance.getNomes(oitava);
        for(int i=0;i<result.length;i++){
            assertSame(bassNames[i+12*oitava],result[i]);
        }
     
    }

    /**
     * Test of getQtd method, of class CordaController.
     */
    @Test
    public void testGetQtd() {
        System.out.println("getQtd");
        CordaController instance = new CordaController(Util.BASS);
        int expResult = 60; // 9 sons de baixo
        int result = instance.getQtd();
        assertEquals(expResult, result);
    }

    /**
     * Test of switchNota method, of class CordaController.
     */
    @Test
    public void testSwitchNotaBass() {
           System.out.println("switchNota");
           int selec = 0;
           String text = "D2";
           int j = 0;
           CordaController instance = new CordaController(Util.BASS);
           String st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "G2";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "G2";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
           
           text = "D2";
           j = 0;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
    }
    
    
    
    @Test
    public void testSwitchNotaGuitar() {
           System.out.println("switchNota");
           int selec = 0;
           String text = "D2";
           int j = 0;
           CordaController instance = new CordaController(Util.GUITAR1);
           String st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "G2";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "G2";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
           
           text = "D2";
           j = 0;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
    }

    /**
     * Test of removeNota method, of class CordaController.
     */
    @Test
    public void testRemoveNota() {
         System.out.println("removeNota");
           int selec = 0;
           String text = "D3";
           int j = 0;
           CordaController instance = new CordaController(Util.GUITAR1);
           instance.switchNota(selec, text, j); // insere nota
           String st = instance.removeNota(selec, text, j);  // remove
           assertEquals("Removeu " + text + ", posicao "+ j, st);
    }
    
     @Test
    public void testMaxTempos() {
        System.out.println("maxtempos");
           CordaController instance = new CordaController(Util.GUITAR1);
           // instance.switchNota(selec, text, j);
           int tam = instance.l[0].getTamanho();
           assertEquals(tam, 16);
           
           instance.setMaxTempo(0, 10);
           tam = instance.l[0].getTamanho();
           assertEquals(tam, 11);
        
    }
    
}
