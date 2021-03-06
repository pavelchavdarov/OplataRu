/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGSOplataRu;

import RGSCommonUtils.UniversalConnectionInterfaceImp;
import static RGSCommonUtils.oraDAO.Stream2Clob;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.sql.SQLException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;

/**
 *
 * @author p.chavdarov
 */
public class OplataConnection extends UniversalConnectionInterfaceImp{

    @Override
    public String POST_Request(String p_uri, Object... p_objects) throws IOException {
        String result = "";
        HttpPost request = new HttpPost(p_uri);
        request = getRequestConfigurator().Configurate(request);
        
        if (p_objects.length > 0 ) {
            HttpEntity reqEntity =
                    EntityBuilder.create().setText((String) p_objects[0])
                    .setContentType(ContentType.create(request.getFirstHeader("Content-Type").getValue(), 
                            Charset.forName(request.getFirstHeader("charset").getValue())))
                    .build();

            request.setEntity(reqEntity);
//            System.out.println("target= "+target);
//            System.out.println("httpClient= "+httpClient);
//            System.out.println("request= "+request.getFirstHeader("charset").getValue());
//            System.out.println("request= "+request.getFirstHeader("Content-Type").getValue());
//            System.out.println("request entity= " + request.getEntity());
            
//            System.out.println("request headers:");
//            for( Header h : request.getAllHeaders()){
//                
//                System.out.println(h.getName() + ":" + h.getValue());
//            }
            CloseableHttpResponse responce = httpClient.execute(target, request);
            result = responceToString(responce);
        }

        return result;
    }
    
    public Clob POST_RequestDBClob(String p_uri, Object... p_objects) throws IOException, SQLException {
        Clob result = null;
        HttpPost request = new HttpPost(p_uri);
        request = getRequestConfigurator().Configurate(request);

        if (p_objects.length > 0 ) {

            HttpEntity reqEntity = EntityBuilder.create()
                    .setText((String) p_objects[0])
                    //.setContentType(ContentType.create("text/plain", Charset.forName("utf-8")))
                    .build();

            request.setEntity(reqEntity);
//            System.out.println("target: "+target);
//            System.out.println("httpClient: "+httpClient);
//            System.out.println("request: "+request);
            CloseableHttpResponse responce = httpClient.execute(target, request);
            result = Stream2Clob(responce.getEntity().getContent());
        }

        return result;
    }

}
