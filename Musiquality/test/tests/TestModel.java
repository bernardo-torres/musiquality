/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Exceptions.ModelException;
import Model.Model.Nota;
import Model.Model.Notas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuário
 */
public class TestModel {
    
    public TestModel() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        Nota n0 = new Nota("fail","nofile.txt");
    }
    
    @Test (expected = ModelException.class)
    public void testFailNotas() throws ModelException{
        Notas n0 = new Notas(-1);
    }
}
