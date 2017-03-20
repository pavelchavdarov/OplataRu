/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import RGSCommonUtils.UniversalConnectionInterface;
import RGSCommonUtils.UniversalConnectionInterfaceImp;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p.chavdarov
 */
public class OplataRuAPI {
    private static UniversalConnectionInterface Connection;
    
    public static void init() throws IOException{
        
        if (Connection == null){
//            Properties prop = new Properties();
//            prop.load(OplataRuAPI.class.getResourceAsStream("/OplataRu.properties"));

            Connection = new UniversalConnectionInterfaceImp();
            Connection.setConfigurator(new Configuretor("/OplataRu.properties"));
            
//            Connection.setTarget(   prop.getProperty("Url"),
//                                    Integer.valueOf(prop.getProperty("Port")).intValue(), 
//                                    prop.getProperty("Schema"));
//            
//            Connection.setProxy(prop.getProperty("proxyUrl"),
//                                    Integer.valueOf(prop.getProperty("proxyPort")).intValue(), 
//                                    prop.getProperty("proxySchema"));
            Connection.Configurate();
        }
        
        
        
        
    }
}
