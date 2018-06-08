/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.Utils.DataChecks;
import com.inso.model.Farmacia;
import com.inso.model.Medico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eva
 */
public class CajaBlancaNegraTests {
    
    DataChecks datachecks;
    public CajaBlancaNegraTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        datachecks = DataChecks.getInstance();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSelectedFarmacia method, of class AdminController.
     */
    @Test
    public void testCajaBlanca() {
        //Sabiendo que la primera comprobacion es de letra mayuscula
        assertFalse(datachecks.checkCIF("a123"));
        //Sabiendo que la segunda comprobacion es de que el tamaño es 9
        assertFalse(datachecks.checkCIF("A1234"));
        //Sabiendo que la tercera comprobación es si encuentra letras en medio
        assertFalse(datachecks.checkCIF("A1234A547"));
        
        assertTrue(datachecks.checkCIF("A12344547"));
    }

    
        /**
     * Test of getSelectedFarmacia method, of class AdminController.
     */
    @Test
    public void testCajaNegra() {
        //Sabiendo que los numeros de cuenta validos tienen el siguiente formato
        assertTrue(datachecks.checkCIF("ES1236547896541236547896"));
        assertFalse(datachecks.checkCIF("ES1236547NO6541236547896"));
    }
    
}
