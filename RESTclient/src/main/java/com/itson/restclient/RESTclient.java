/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.restclient;

//import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.itson.restentidades.Alumno;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author gilberto.borrego
 */
public class RESTclient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget base = client.
                target("http://localhost:8080/RESTTomeePlume/resources");
        base = base.path("Alumnos");
        System.out.println("\nGet por ID: \n" + getId(base,3)); 
        System.out.println("\nPost: \n" +post(base)); 
        System.out.println("\nGet todos: \n" +getAll(base)); 
    }
    
    static String getId(WebTarget base, int id){
        base = base.path("1");
        Response get = base.request().get();                
        if (get.getStatus()==200){    
            Alumno resp = get.readEntity(Alumno.class);            
            return resp.toString();
        }
        else
            return "error "+get.getStatus();
    }
    
    static String getAll(WebTarget base){
        Response get = base.request().get();                
        if (get.getStatus()==200){    
            List<Alumno> resp = get.readEntity(new GenericType<List<Alumno>>() {});  
            String str="";
            for (Alumno alumno : resp)
                str+=alumno.toString()+"\n";            
            return str;
        }
        else
            return "error "+get.getStatus();
    }           
    
    static String post(WebTarget base){
        Response post = base.request()
                .post(Entity.entity(
                        new Alumno("3","Fulano de Tal","ISW"),
                        MediaType.APPLICATION_JSON));
        if (post.getStatus()==201){    
            Alumno resp = post.readEntity(Alumno.class);            
            return resp.toString();
        }
        else
            return "error "+post.getStatus();        
    }
    
}
