package RGSOplataRu;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class RequestConfigurator implements RGSCommonUtils.RequestConfigurator {

    public static RequestConfigurator create(String propertyFile) throws IOException {
        return new RequestConfigurator(propertyFile);
    }
    private final String сontentType;
    private final String сharSet;
    private final String Authorization;
    private final String AuthString;
    
    private final HttpHost proxy;

    private RequestConfigurator(String propertyFile) throws IOException {
        Properties prop = new Properties();
        prop.load(OplataRuAPI.class.getResourceAsStream(propertyFile));
        
        this.сontentType = prop.getProperty("ContentType");
        this.Authorization = prop.getProperty("Authorization");
        this.сharSet = prop.getProperty("charset");
        
        String login = prop.getProperty("basicLogin");
        String password = prop.getProperty("basicPassword");
        this.AuthString = Base64.encodeBase64String((login + ":" + password).getBytes());

        String urlProxy = prop.getProperty("urlProxy");
        int portProxy = Integer.valueOf(prop.getProperty("portProxy")).intValue();
        String schemaProxy = prop.getProperty("schemaProxy");
        // for test only
        proxy = null;//new HttpHost(urlProxy, portProxy, schemaProxy);
    }

    
    
    @Override
    public HttpPost Configurate(HttpPost request) {
        RequestConfig config;
        if(this.proxy != null)
            config = RequestConfig.custom().setProxy(this.proxy).build();
        else
            config = RequestConfig.custom().build();
        request.setConfig(config);
        
        
        request.setHeader("Content-Type", сontentType);
        request.setHeader("charset", сharSet);
        request.setHeader("Authorization", Authorization + " " + AuthString);
        return request;
    }

    @Override
    public HttpGet Configurate(HttpGet request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HttpPut Configurate(HttpPut request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
