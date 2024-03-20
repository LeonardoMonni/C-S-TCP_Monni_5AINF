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
public class Main_Server{

    
    public static void main(String[] args) {
        Server server = new Server(1789);
        server.attendi();
        server.chiudi();
        server.termina();
        
        
        
        }
    }
