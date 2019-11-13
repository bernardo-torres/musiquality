/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.ModelException;
import Exceptions.SystemException;
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
public class DrumControllerTest {
    
    Notas bat;
    Levada[] levada;
    
    public DrumControllerTest() {
    }
    
    @Before
    public void setUp() throws ModelException {
      bat = new Notas(Util.DRUM);
      levada=new Levada[10];
      for(int i=0;i<levada.length;i++)
           levada[i]=new Levada(bat);
    }
    

    /**
     * Testa getnomes e compara com nomes pegos das notas de bat
     */
    @Test
    public void testGetNomes() {
         String [] nDrum= bat.getNomes();
        
        
        System.out.println("getNomes");
        DrumController instance = new DrumController();
        
        String[] expResult = null;
        String[] result = instance.getNomes();
        for(int i=0;i<nDrum.length;i++){
            assertSame(nDrum[i],result[i]);
        }
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getQtd method, of class DrumController.
     */
    @Test
    public void testGetQtd() {
        System.out.println("getQtd");
        DrumController instance = new DrumController();
        int expResult = 9; // 9 sons de bateria
        int result = instance.getQtd();
        assertEquals(expResult, result);
    }

    /**
        * Testa adicionar notas em um dashboard e remover
        */
       @Test
       public void testSwitchNota() {
           System.out.println("switchNota");
           int selec = 0;
           String text = "Kick";
           int j = 0;
           DrumController instance = new DrumController();
           String st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "Snare";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Adicionou " + text + ", posicao "+ j, st);
           
           text = "Snare";
           j = 1;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
           
           text = "Kick";
           j = 0;
           st = instance.switchNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);


       }
    /**
     * Test of removeNota method, of class DrumController.
     */
    @Test
    public void testRemoveNota() {
        System.out.println("removeNota");
           int selec = 0;
           String text = "Kick";
           int j = 0;
           DrumController instance = new DrumController();
           instance.switchNota(selec, text, j);
           String st = instance.removeNota(selec, text, j);
           assertEquals("Removeu " + text + ", posicao "+ j, st);
    
        
    }
    
    @Test (expected = SystemException.class)
    public void testRemoveNotaFail() {
        System.out.println("removeNota");
           int selec = 0;
           String text = "Kick";
           int j = 5;
           DrumController instance = new DrumController();
           // instance.switchNota(selec, text, j);
           String st = instance.removeNota(selec, text, j);
        
    }
    
    
     @Test
    public void testMaxTempos() {
        System.out.println("maxtempos");
           DrumController instance = new DrumController();
           // instance.switchNota(selec, text, j);
           int tam = instance.levada[0].getTamanho();
           assertEquals(tam, 16);
           
           instance.setMaxTempo(0, 10);
           tam = instance.levada[0].getTamanho();
           assertEquals(tam, 11);
        
    }
    
}
