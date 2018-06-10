/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import java.util.Collection;
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
public class PacientesTest {
    
    public PacientesTest() {
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

    /**
     * Test of getDni method, of class Pacientes.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Pacientes instance = new Pacientes();
        String expResult = "75698752P";
        instance.setDni(expResult);
        String result = instance.getDni();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNombre method, of class Pacientes.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Pacientes instance = new Pacientes();
        String expResult = "Pepe";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNumeroSS method, of class Pacientes.
     */
    @Test
    public void testGetNumeroSS() {
        System.out.println("getNumeroSS");
        Pacientes instance = new Pacientes();
        String expResult = "951233654789";
        instance.setNumeroSS(expResult);
        String result = instance.getNumeroSS();
        assertEquals(expResult, result);
    }



    /**
     * Test of getPassword method, of class Pacientes.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Pacientes instance = new Pacientes();
        String expResult = "Pass";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
        
    }




    /**
     * Test of hashCode method, of class Pacientes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Pacientes instance = new Pacientes();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Pacientes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Pacientes instance = new Pacientes();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

 
    
}
