/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Monni Leonardo
 */
public class Server{

    
    public static void main(String[] args) {
        try{
        ServerSocket serverSocket = new ServerSocket(1789);
        System.out.println("Server in esecuzione e in attesa di una richiesta");
        Socket socket = serverSocket.accept();
        serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
