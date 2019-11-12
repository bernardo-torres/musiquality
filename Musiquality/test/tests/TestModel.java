/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Exceptions.ModelException;
import Exceptions.SystemException;
import Main.Util;
import Model.Model.Nota;
import Model.Model.Notas;
import Model.Persistencia.Persistencia;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuário
 */
public class TestModel {
    Notas drum;
    Notas bass;
    Notas guitar1;
    Notas guitar2;
    
    Nota [] d;
    Nota [] b;
    Nota [] g1;
    Nota [] g2;
    
    Persistencia p;
    
    
    public TestModel() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ModelException {
        drum = new Notas(Util.DRUM);
        bass = new Notas(Util.BASS);
        guitar1 = new Notas(Util.GUITAR1);
        guitar2 = new Notas (Util.GUITAR2);
        p=Persistencia.getPersistencia();
        d=p.getBateria();
        b=p.getBaixo();
        g1=p.getGuitarra1();
        g2=p.getGuitarra2();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test (expected = ModelException.class)
    public void testFailNota() throws ModelException{
        Nota n0 = new Nota("fail","------");
    }
    
    @Test (expected = ModelException.class)
    public void testFailNotas() throws ModelException{
        Notas n0 = new Notas(-1);
    }
    
    @Test (expected = ModelException.class)
    public void testFailTocar1() throws ModelException{
        drum.tocar("Piano C3");
    }
    
    @Test (expected = SystemException.class)
    public void testFailTocar2() throws SystemException{
        drum.tocar(100);
    }
    
    @Test (expected = ModelException.class)
    public void testFailGet1() throws ModelException{
        drum.getIndiceNota("G3");
    }
    
    @Test (expected = SystemException.class)
    public void testFailGet2() throws SystemException{
        drum.getNomeNota(100);
    }
    
    @Test
    public void testNullNota() throws ModelException{
        Nota n0=new Nota("Test","nofile");
        assertEquals(n0.tocar(),false);
        
    }
    
    @Test
    public void testNota() throws ModelException{
        Nota n1=new Nota("Test","/Sounds/Bateria/Tom.wav");
        assertEquals(n1.tocar(),true);
        assertEquals(n1.getNome(),"Test");
        assertEquals(n1.getURL(),"/Sounds/Bateria/Tom.wav");
    }
    
    @Test
    public void testPersistencia(){
        assertNotNull(p.getBaixo());
        assertNotNull(p.getBateria());
        assertNotNull(p.getGuitarra1());
        assertNotNull(p.getGuitarra2());
        
    }
    
    @Test
    public void testGetNomeNota() throws SystemException{
        for(int i=0;i<d.length;i++)
            assertEquals(drum.getNomeNota(i),d[i].getNome());
        
        for(int i=0;i<b.length;i++)
            assertEquals(bass.getNomeNota(i),b[i].getNome());
        
        for(int i=0;i<g1.length;i++)
            assertEquals(guitar1.getNomeNota(i),g1[i].getNome());
        
        for(int i=0;i<g2.length;i++)
            assertEquals(guitar2.getNomeNota(i),g2[i].getNome());
        
    }
    
    @Test
    public void testGetIndiceNota() throws ModelException{
        for(int i=0;i<d.length;i++)
            assertEquals(drum.getIndiceNota(d[i].getNome()),i);
        
        for(int i=0;i<b.length;i++)
            assertEquals(bass.getIndiceNota(b[i].getNome()),i);
        
        for(int i=0;i<g1.length;i++)
            assertEquals(guitar1.getIndiceNota(g1[i].getNome()),i);
        
        for(int i=0;i<g2.length;i++)
            assertEquals(guitar2.getIndiceNota(g2[i].getNome()),i);
    
    }
    
    @Test
    public void testGetQTD(){
        assertEquals(drum.getQtd(),d.length);
        assertEquals(bass.getQtd(),b.length);
        assertEquals(guitar1.getQtd(),g1.length);
        assertEquals(guitar2.getQtd(),g2.length);
    }
    
    @Test
    public void testTocar1() throws SystemException{
        for(int i=0;i<drum.getQtd();i++){
            if(drum.notas[i].getURL().equals("nofile"))
                assertEquals(drum.tocar(i),false);
            else
                assertEquals(drum.tocar(i),true);
        }
 
        for(int i=0;i<bass.getQtd();i++){
            if(bass.notas[i].getURL().equals("nofile"))
                assertEquals(bass.tocar(i),false);
            else
                assertEquals(bass.tocar(i),true);
        }
        
        for(int i=0;i<guitar1.getQtd();i++){
            if(guitar1.notas[i].getURL().equals("nofile"))
                assertEquals(guitar1.tocar(i),false);
            else
                assertEquals(guitar1.tocar(i),true);
        }
        
        for(int i=0;i<guitar2.getQtd();i++){
            if(guitar2.notas[i].getURL().equals("nofile"))
                assertEquals(guitar2.tocar(i),false);
            else
                assertEquals(guitar2.tocar(i),true);
        }
    }
    
    @Test
    public void TestTocar2() throws ModelException{
        for(int i=0;i<drum.getQtd();i++){
            if(drum.notas[i].getURL().equals("nofile"))
                assertEquals(drum.tocar(d[i].getNome()),false);
            else
                assertEquals(drum.tocar(d[i].getNome()),true);
        }
 
        for(int i=0;i<bass.getQtd();i++){
            if(bass.notas[i].getURL().equals("nofile"))
                assertEquals(bass.tocar(b[i].getNome()),false);
            else
                assertEquals(bass.tocar(b[i].getNome()),true);
        }
        
        for(int i=0;i<guitar1.getQtd();i++){
            if(guitar1.notas[i].getURL().equals("nofile"))
                assertEquals(guitar1.tocar(g1[i].getNome()),false);
            else
                assertEquals(guitar1.tocar(g1[i].getNome()),true);
        }
        
        for(int i=0;i<guitar2.getQtd();i++){
            if(guitar2.notas[i].getURL().equals("nofile"))
                assertEquals(guitar2.tocar(g2[i].getNome()),false);
            else
                assertEquals(guitar2.tocar(g2[i].getNome()),true);
        }
    }
    
    
    @Test
    public void TestGetNomes(){
        String [] nDrum=drum.getNomes();
        String [] nBass=bass.getNomes();
        String [] nGuitar1=guitar1.getNomes();
        String [] nGuitar2=guitar2.getNomes();
        
        for(int i=0;i<nDrum.length;i++){
            assertSame(nDrum[i],d[i].getNome());
        }
        
        for(int i=0;i<nBass.length;i++){
            assertSame(nBass[i],b[i].getNome());
        }
        
        for(int i=0;i<nGuitar1.length;i++){
            assertSame(nGuitar1[i],g1[i].getNome());
        }
        
        for(int i=0;i<nGuitar2.length;i++){
            assertSame(nGuitar2[i],g2[i].getNome());
        }
        
    }
    
    
    
}
