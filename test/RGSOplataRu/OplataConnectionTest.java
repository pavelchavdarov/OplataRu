/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import java.sql.Clob;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p.chavdarov
 */
public class OplataConnectionTest {
    
    public OplataConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of POST_Request method, of class OplataConnection.
     */
    @Test
    public void testPOST_Request() throws Exception {
        System.out.println("POST_Request");
        String p_uri = "";
        Object[] p_objects = null;
        OplataConnection instance = new OplataConnection();
        String expResult = "";
        String result = instance.POST_Request(p_uri, p_objects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of POST_RequestDBClob method, of class OplataConnection.
     */
    @Test
    public void testPOST_RequestDBClob() throws Exception {
        System.out.println("POST_RequestDBClob");
        String p_uri = "";
        Object[] p_objects = null;
        OplataConnection instance = new OplataConnection();
        Clob expResult = null;
        Clob result = instance.POST_RequestDBClob(p_uri, p_objects);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
