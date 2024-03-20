/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monni Leonardo
 */
public class Client {
    private String nome;
    private String colore;
    private Socket socket; 
    
    Client(String nomeDefault, String coloreDefault){
        this.nome = nomeDefault;
        this.colore = coloreDefault;
    }
    
    public void connetti(String nomeServer, int portaServer){
        try {
            System.out.println("Client " + nome + " in esecuzione!");
            this.socket = new Socket(nomeServer, portaServer);
            System.out.println("Connessione avvenuta con successo con il server: " + nomeServer);
        } 
        catch (ConnectException ex) { // il server non è in ascolto
            System.err.println(ex.getMessage());
        }
        catch (UnknownHostException ex) { // host sconosciuto
            System.err.println(ex.getMessage());
        }
        
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
    }
    
    public void chiudi(){
        try{
            if(socket != null){
                socket.close();
                System.out.println("Connessione chiusa con il server!");
                }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }  
    }
}
