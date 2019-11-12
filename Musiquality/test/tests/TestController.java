/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Controller.CordaController;
import Controller.DrumController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuário
 */
public class TestController {
    
    public TestController() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        DrumController d=new DrumController();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void test(){
        assertEquals(true,true);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
