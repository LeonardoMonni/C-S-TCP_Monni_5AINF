/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monni Leonardo
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;


    public Server(int porta) {
        this.porta = porta;
        try {
            this.serverSocket = new ServerSocket(this.porta);
            System.out.println("Server in esecuzione e in attesa di una richiesta");
        } 
        
        catch(BindException ex){
            System.err.println("Porta gia in utilizzo!");
            System.err.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Errore nella fase di connessione con il client");
            System.err.println(ex.getMessage());
        }
    }

    public Socket attendi(){
        try{
            if(serverSocket != null){
                this.clientSocket = serverSocket.accept();
                System.out.println("Connessione effettuatta correttamente");
            }
        }
        catch (NullPointerException ex){
            System.err.println(ex.getMessage());
        }
        
        catch (SocketException ex){
            System.err.println(ex.getMessage());
        }
        
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        
        return clientSocket;      
    } 
    
    

    public void scrivi(){

    }

    public void leggi(){

    }

    public void chiudi(){
        try{
            if(serverSocket != null){
                this.clientSocket.close();
                System.out.println("Connessione chiusa con il client!");
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    public void termina(){
        try{
            if(serverSocket != null && clientSocket.isClosed()){
                serverSocket.close();
            } 
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
            
    }
    
    
}