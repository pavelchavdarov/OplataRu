/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import RGSCommonUtils.UniversalConnectionInterface;
import RGSCommonUtils.UniversalConnectionInterfaceImp;
import RGSDigestTools.SignatureTool;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p.chavdarov
 */
public class OplataRuAPI {
    private static UniversalConnectionInterface Connection;
    // mandatory fields
    private static String agentId;
    private static String payMethod;
    private static SignatureTool singTool;
    
    private static void init() throws Exception{
        
        if (Connection == null){
//            Properties prop = new Properties();
//            prop.load(OplataRuAPI.class.getResourceAsStream("/OplataRu.properties"));

            Connection = new OplataConnection();
            Connection.setClientConfigurator(ClientConfiguretor.create("/RGSOplataRu/OplataClient.properties"));
            Connection.setRequestConfigurator(RequestConfigurator.create("/RGSOplataRu/OplataRequest.properties"));
            
//            Connection.setTarget(   prop.getProperty("Url"),
//                                    Integer.valueOf(prop.getProperty("Port")).intValue(), 
//                                    prop.getProperty("Schema"));
//            
//            Connection.setProxy(prop.getProperty("proxyUrl"),
//                                    Integer.valueOf(prop.getProperty("proxyPort")).intValue(), 
//                                    prop.getProperty("proxySchema"));
            Connection.Configurate();
            
            // API parameters initialisation
            Properties prop = new Properties();
            prop.load(OplataRuAPI.class.getResourceAsStream("/RGSOplataRu/OplataAPI.properties"));
            agentId = prop.getProperty("agentId");
            payMethod = prop.getProperty("payMethod");
            
            singTool = new SignatureTool("SHA1withRSA");
            prop.load(OplataRuAPI.class.getResourceAsStream("/RGSOplataRu/OplataCrypto.properties"));
            singTool.initKeysWithAndFile(  prop.getProperty("keyStorePath"), 
                                prop.getProperty("keyStorePasswd"),
                                prop.getProperty("DSAlias"),
                                prop.getProperty("privKeyPasswd"),
                                prop.getProperty("pubKeyPath"));
            
            
        }
    }
    
    public static String Func5300(String terminal, String serviceCode, String payParams) throws Exception {
        String result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        init();
        String request =   "mti=" + 5300 + 
                    "&" + "agent_id=" + agentId +
                    "&" + "pay_dt=" + sdf.format(new Date()) +
                    "&" + "terminal=" + terminal +
                    "&" + "service_code=" + serviceCode + 
                    "&" + "pay_method=" + payMethod + 
                    "&" + payParams;
                ;
        String sign = singTool.sign(request);
        request = request + "&" + "sign=" + sign;
        System.out.println("request= "+request);
        result = Connection.POST_Request("/", request);
        System.out.println("result= "+result);
        return result;
    }
    
    
    
}
