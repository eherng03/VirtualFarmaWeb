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
public class FarmaciaTest {
    
    public FarmaciaTest() {
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
     * Test of getCif method, of class Farmacia.
     */
    @Test
    public void testCif() {
        System.out.println("Cif");
        Farmacia instance = new Farmacia();
        String expResult = "";
        instance.setCif(expResult);
        String result = instance.getCif();
        
        assertEquals(expResult, result);
    }


    /**
     * Test of getNombre method, of class Farmacia.
     */
    @Test
    public void testNombre() {
        System.out.println("Nombre");
        Farmacia instance = new Farmacia();
        String expResult = "Lola";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }




    /**
     * Test of setHorario method, of class Farmacia.
     */
    @Test
    public void testHorario() {
        System.out.println("Horario");
        String expResult = "De 1 a 2";
        Farmacia instance = new Farmacia();
        instance.setHorario(expResult);
        String result = instance.getHorario();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDireccion method, of class Farmacia.
     */
    @Test
    public void testDireccion() {
        System.out.println("Direccion");
        Farmacia instance = new Farmacia();
        String expResult = "Calle ancha";
        instance.setDireccion(expResult);
        String result = instance.getDireccion();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNumeroCuenta method, of class Farmacia.
     */
    @Test
    public void testNumeroCuenta() {
        System.out.println("NumeroCuenta");
        Farmacia instance = new Farmacia();
        String expResult = "ES2365478965412365478965";
        instance.setNumeroCuenta(expResult);
        String result = instance.getNumeroCuenta();
        assertEquals(expResult, result);
    }

  

    /**
     * Test of getNombreDueno method, of class Farmacia.
     */
    @Test
    public void testNombreDueno() {
        System.out.println("NombreDueno");
        Farmacia instance = new Farmacia();
        String expResult = "Jose";
        instance.setNombreDueno(expResult);
        String result = instance.getNombreDueno();
        assertEquals(expResult, result);
    }

   

    /**
     * Test of getTelefono method, of class Farmacia.
     */
    @Test
    public void testTelefono() {
        System.out.println("Telefono");
        Farmacia instance = new Farmacia();
        String expResult = "987654321";
        instance.setTelefono(expResult);
        String result = instance.getTelefono();
        assertEquals(expResult, result);
    }

   

    /**
     * Test of getEmail method, of class Farmacia.
     */
    @Test
    public void testEmail() {
        System.out.println("Email");
        Farmacia instance = new Farmacia();
        String expResult = "hola@gmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPassword method, of class Farmacia.
     */
    @Test
    public void testPassword() {
        System.out.println("Password");
        Farmacia instance = new Farmacia();
        String expResult = "password";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of hashCode method, of class Farmacia.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Farmacia instance = new Farmacia();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductosCollection method, of class Farmacia.
     */
    @Test
    public void testProductosCollection() {
        System.out.println("getProductosCollection");
        Farmacia instance = new Farmacia();
        Collection<Productos> expResult = null;
        Collection<Productos> result = instance.getProductosCollection();
        assertEquals(expResult, result);
    }

   

    /**
     * Test of equals method, of class Farmacia.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Farmacia instance = new Farmacia();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

  
    
}
