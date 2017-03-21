/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author p.chavdarov
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({RGSOplataRu.RequestConfiguratorTest.class, RGSOplataRu.OplataConnectionTest.class, RGSOplataRu.ClientConfiguretorTest.class, RGSOplataRu.OplataRuAPITest.class})
public class RGSOplataRuSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
