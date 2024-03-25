/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monni Leonardo
 */
public class Client {
    String nome;
    String colore;
    Socket socket; 
    Scanner scanner;
    BufferedReader input;
    BufferedWriter output;
    static final String RESET = "\u001B[0m";
    
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
        if(socket != null && !socket.isClosed()){
            System.err.println("Scrivi: "+ RESET);
            String messaggio = scanner.nextLine();
            System.out.println(messaggio+RESET);
            try{
                output.write(messaggio);
                output.newLine();
                output.flush();
                if(messaggio.equalsIgnoreCase("chiudi")){
                    chiudi();
                }
            } catch (IOException ex){
            System.err.println(ex.getMessage());
            }
        }  
    }
    
    public void leggi(){
        if(socket != null && !socket.isClosed()){
            String messaggioRicevuto = null;
            try{
                messaggioRicevuto = input.readLine();
                System.out.println(messaggioRicevuto+RESET);
                if(messaggioRicevuto == null){
                    chiudi();
                } else if(messaggioRicevuto.equalsIgnoreCase("chiudi")){
                    chiudi();
                }
            } catch (IOException ex){
            System.err.println(ex.getMessage());
            }
        }  
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
