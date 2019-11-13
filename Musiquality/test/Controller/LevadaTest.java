package Controller;

import Exceptions.ModelException;
import Main.Util;
import Model.Model.Levada;
import Model.Model.Notas;
import Model.Persistencia.Persistencia;
import View.MainView;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class LevadaTest {
    
   Notas drum;
   int tam;
   int bpm;
   Persistencia per;
   
   MainView g=new MainView();
   
   @Before
    public void setUp() throws ModelException {
        drum = new Notas(Util.DRUM);
        per = Persistencia.getPersistencia();
        this.bpm=100;
        this.tam=16;
        LinkedList[] dashboard = new LinkedList[tam];
        for(int i = 0;i<dashboard.length;i++){
            dashboard[i] = new LinkedList<>();
        }
    }
    
    
    public LevadaTest(){


    }
    
    @Test
    public void testGetBpm() {
        System.out.println("getBpm");
        Levada instance = new Levada(drum);
        int expResult = 100;
        int result = instance.getBpm();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTamanho() {
        System.out.println("getTamanho");
        Levada instance = new Levada(drum);
        int expResult = 16;
        int result = instance.getTamanho();
        assertEquals(expResult, result);
    }


    @Test
    public void testContains() {
        System.out.println("contains");
        String nome = "Kick";
        int j = 0;
        Levada instance = new Levada(drum);
        boolean expResult = false;
        boolean result = instance.contains(nome, j);
        assertEquals(expResult, result);
    }

}
