/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p.chavdarov
 */
public class RequestConfiguratorTest {
    
    public RequestConfiguratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class RequestConfigurator.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String propertyFile = "";
        RequestConfigurator expResult = null;
        RequestConfigurator result = RequestConfigurator.create(propertyFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Configurate method, of class RequestConfigurator.
     */
    @Test
    public void testConfigurate_HttpPost() {
        System.out.println("Configurate");
        HttpPost request = null;
        RequestConfigurator instance = null;
        HttpPost expResult = null;
        HttpPost result = instance.Configurate(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Configurate method, of class RequestConfigurator.
     */
    @Test
    public void testConfigurate_HttpGet() {
        System.out.println("Configurate");
        HttpGet request = null;
        RequestConfigurator instance = null;
        HttpGet expResult = null;
        HttpGet result = instance.Configurate(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Configurate method, of class RequestConfigurator.
     */
    @Test
    public void testConfigurate_HttpPut() {
        System.out.println("Configurate");
        HttpPut request = null;
        RequestConfigurator instance = null;
        HttpPut expResult = null;
        HttpPut result = instance.Configurate(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
