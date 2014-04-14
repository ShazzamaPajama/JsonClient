/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsonclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

/**
 *
 * @author paul.koroski
 */
public class Jsonclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), 1337);
            System.out.println("Connected to Server");
            PrintWriter ClientOut = new PrintWriter(client.getOutputStream(), true);
            JsonWriter Jwriter = Json.createWriter(ClientOut);
            BufferedReader inputreader = new BufferedReader(new InputStreamReader(System.in));
            
            while (true){
                String input = inputreader.readLine();
                
                JsonObject message = Json.createObjectBuilder()
                        .add("Message", input)
                        .build();
                
            
                ClientOut.println(message);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Jsonclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
