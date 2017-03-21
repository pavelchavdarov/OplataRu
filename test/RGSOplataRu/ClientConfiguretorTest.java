/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p.chavdarov
 */
public class ClientConfiguretorTest {
    
    public ClientConfiguretorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class ClientConfiguretor.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String propertyFile = "";
        ClientConfiguretor expResult = null;
        ClientConfiguretor result = ClientConfiguretor.create(propertyFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConfigureSocketLayer method, of class ClientConfiguretor.
     */
    @Test
    public void testConfigureSocketLayer() {
        System.out.println("ConfigureSocketLayer");
        ClientConfiguretor instance = null;
        CloseableHttpClient expResult = null;
        CloseableHttpClient result = instance.ConfigureSocketLayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConfigureTarger method, of class ClientConfiguretor.
     */
    @Test
    public void testConfigureTarger() {
        System.out.println("ConfigureTarger");
        ClientConfiguretor instance = null;
        HttpHost expResult = null;
        HttpHost result = instance.ConfigureTarger();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
