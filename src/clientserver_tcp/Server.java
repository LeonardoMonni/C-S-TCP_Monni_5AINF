/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserver_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
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
    Scanner scanner;
    BufferedReader input;
    BufferedWriter output;
    


    public Server(int porta) {
        this.porta = porta;
        this.scanner = new Scanner(System.in);
        try {
            this.serverSocket = new ServerSocket(this.porta);
            System.out.println("Server in esecuzione e in attesa di una richiesta sulla porta: " + this.porta);
            this.clientSocket=attendi();
            if(clientSocket != null){
                System.out.println("Connessione effettuatta correttamente");
                output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            comunica();
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
            return serverSocket.accept();
            
        }
        catch (NullPointerException ex){
            System.err.println(ex.getMessage());
            return null;
        }
        
        catch (SocketException ex){
            System.err.println(ex.getMessage());
            return null;
        }
        
        catch (IOException ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    } 
    
    public void comunica(){
        while(!serverSocket.isClosed() && !clientSocket.isClosed()){
            leggi();
            scrivi();
        }
    }
    
    

    public void scrivi(){
        if(!serverSocket.isClosed()&& !clientSocket.isClosed()){
            System.err.println("Scrivi: ");
            String messaggio = scanner.nextLine();
            System.out.println(messaggio);
            try{
                output.write(messaggio);
                output.newLine();
                output.flush();
                if(messaggio == null){
                    chiudi();
                    termina();
                } else if(messaggio.equalsIgnoreCase("chiudi")){
                    chiudi();
                    termina();
                }
            } catch (IOException ex){
            System.err.println(ex.getMessage());
            }
                    
        }

    }

    public void leggi(){
        if(!serverSocket.isClosed()&& !clientSocket.isClosed()){
            String messaggioRicevuto = null;
            try{
                messaggioRicevuto = input.readLine();
                System.out.println(messaggioRicevuto);
                if(messaggioRicevuto == null){
                    chiudi();
                    termina();
                }  else if(messaggioRicevuto.equalsIgnoreCase("chiudi")){
                    chiudi();
                    termina();
                }
            } catch (IOException ex){
            System.err.println(ex.getMessage());
            }
        }
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