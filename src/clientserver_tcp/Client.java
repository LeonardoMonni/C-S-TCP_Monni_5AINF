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
public class Client{

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 1789);
            socket.close(); //chiisura client socket 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
