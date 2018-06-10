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
public class MedicoTest {
    
    public MedicoTest() {
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
     * Test of getDni method, of class Medico.
     */
    @Test
    public void testDni() {
        System.out.println("Dni");
        Medico instance = new Medico();
        String expResult = "71589647P";
        instance.setDni(expResult);
        String result = instance.getDni();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNombre method, of class Medico.
     */
    @Test
    public void testNombre() {
        System.out.println("Nombre");
        Medico instance = new Medico();
        String expResult = "Pepe López";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);

    }


    /**
     * Test of getNumeroSS method, of class Medico.
     */
    @Test
    public void testNumeroSS() {
        System.out.println("NumeroSS");
        Medico instance = new Medico();
        String expResult = "123456789632";
        instance.setNumeroSS(expResult);
        String result = instance.getNumeroSS();
        assertEquals(expResult, result);
    }


    /**
     * Test of getDireccion method, of class Medico.
     */
    @Test
    public void testDireccion() {
        System.out.println("Direccion");
        Medico instance = new Medico();
        String expResult = "Calle Padre Isla";
        instance.setDireccion(expResult);
        String result = instance.getDireccion();
        assertEquals(expResult, result);
    }



    /**
     * Test of getEmail method, of class Medico.
     */
    @Test
    public void testEmail() {
        System.out.println("Email");
        Medico instance = new Medico();
        String expResult = "pepe@gmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }


    /**
     * Test of getCentroMedico method, of class Medico.
     */
    @Test
    public void testCentroMedico() {
        System.out.println("CentroMedico");
        Medico instance = new Medico();
        String expResult = "Condesa";
        instance.setCentroMedico(expResult);
        String result = instance.getCentroMedico();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPassword method, of class Medico.
     */
    @Test
    public void testPassword() {
        System.out.println("Password");
        Medico instance = new Medico();
        String expResult = "hola1234";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }


    /**
     * Test of getRecetasCollection method, of class Medico.
     */
    @Test
    public void testRecetasCollection() {
        System.out.println("RecetasCollection");
        Medico instance = new Medico();
        Collection<Recetas> expResult = null;
        Collection<Recetas> result = instance.getRecetasCollection();
        assertEquals(expResult, result);
    }


    /**
     * Test of hashCode method, of class Medico.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medico instance = new Medico();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Medico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Medico instance = new Medico();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    
}
