/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Monni Leonardo
 */
public class Main_Client{

    public static void main(String[] args) {
        Client client = new Client("Leonardo","Verde");
        client.connetti("127.0.0.1", 1789);
        client.chiudi();
        
            
    }
    
}
