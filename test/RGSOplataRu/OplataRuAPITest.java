/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p.chavdarov
 */
public class OplataRuAPITest {
    
    public OplataRuAPITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Func5300 method, of class OplataRuAPI.
     */
    @Test
    public void testFunc5300() throws Exception {
        System.out.println("Func5300");
        String terminal = "57500001";
        String serviceCode = "55555";
        String payParams = "account=1234567890";
        String expResult = "";
        String result = OplataRuAPI.Func5300(terminal, serviceCode, payParams);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
