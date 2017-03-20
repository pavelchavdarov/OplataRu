/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import RGSCommonUtils.ClientConfigurator;
import RGSCommonUtils.TrustStoreLoader;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

/**
 *
 * @author p.chavdarov
 */
public class Configuretor implements ClientConfigurator{

    private String keyStoreResouce;
    private String keyStorePassword;
    private String trustStoreResouce;
    private String trustStorePassword;
    private String urlTarget;
    private String portTarget;
    private String schemaTarget;
    private String urlProxy;
    private String portProxy;
    private String schemaProxy;

    public Configuretor(String keyStoreResouce, String keyStorePassword, String trustStoreResouce, String trustStorePassword, String urlTarget, String portTarget, String schemaTarget, String urlProxy, String portProxy, String schemaProxy) {
        this.keyStoreResouce = keyStoreResouce;
        this.keyStorePassword = keyStorePassword;
        this.trustStoreResouce = trustStoreResouce;
        this.trustStorePassword = trustStorePassword;
        this.urlTarget = urlTarget;
        this.portTarget = portTarget;
        this.schemaTarget = schemaTarget;
        this.urlProxy = urlProxy;
        this.portProxy = portProxy;
        this.schemaProxy = schemaProxy;
    }

    public Configuretor(String propertyFile) throws IOException {
        Properties prop = new Properties();
        prop.load(OplataRuAPI.class.getResourceAsStream(propertyFile));
        
        this.keyStoreResouce = prop.getProperty("keyStoreResouce");
        this.keyStorePassword = prop.getProperty("keyStorePassword");
        this.trustStoreResouce = prop.getProperty("trustStoreResouce");
        this.trustStorePassword = prop.getProperty("trustStorePassword");
        this.urlTarget = prop.getProperty("urlTarget");
        this.portTarget = prop.getProperty("portTarget");
        this.schemaTarget = prop.getProperty("schemaTarget");
        this.urlProxy = prop.getProperty("urlProxy");
        this.portProxy = prop.getProperty("portProxy");
        this.schemaProxy = prop.getProperty("schemaProxy");
    }
    
    
    
    
    
    @Override
    public CloseableHttpClient ConfigureSocketLayer() {
        try {
            KeyStore keyStore = null;
            KeyStore trustStore = null;
            if (keyStoreResouce != null && keyStorePassword != null)
                keyStore = TrustStoreLoader.loadKeyStore(keyStoreResouce,keyStorePassword);
            if (trustStoreResouce != null && trustStorePassword != null)
                trustStore = TrustStoreLoader.loadTrustStore(trustStoreResouce,trustStorePassword);
            
            SSLContext context = TrustStoreLoader.getTLSContext(keyStore, keyStorePassword, trustStore);
            
            SSLConnectionSocketFactory SSLsf = new SSLConnectionSocketFactory(context, new DefaultHostnameVerifier());
            
            Registry<ConnectionSocketFactory> registry  = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", SSLsf)
                    .register("http", new PlainConnectionSocketFactory())
                    .build();
            HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(registry);
            
            
            return HttpClientBuilder.create()
                    .setConnectionManager(ccm)
                    .build();
        } catch (KeyStoreException ex) {
            Logger.getLogger(Configuretor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Configuretor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Configuretor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuretor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(Configuretor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public HttpHost ConfigureTarger() {
        return new HttpHost(urlTarget,Integer.valueOf(portTarget).intValue(),schemaTarget);
    }

    @Override
    public HttpHost ConfigureProxy() {
        return new HttpHost(urlProxy,Integer.valueOf(portProxy).intValue(),schemaProxy);
    }
    
    
}
