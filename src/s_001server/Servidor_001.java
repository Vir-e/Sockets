/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_001server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virgi
 */
public class Servidor_001 extends Observable implements Runnable {
    
    private int puerto;

    public Servidor_001(int puerto) {
        this.puerto=puerto;
    }
    
    

    @Override
    public void run() {
        
       
        ServerSocket server=null;
        Socket socket=null;
        DataInputStream flujoEntrada;
        DataOutputStream flujoSalida;
        
            
            
        try {   
            server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            // Siempre esta escuchando peticiones
            while(true){
                // Espero a que un cliente se conecte
                socket = server.accept();
                System.out.println("Cliente conectado");
                
                flujoEntrada = new DataInputStream(socket.getInputStream());
                //flujoSalida = new DataOutputStream(socket.getOutputStream());
                
                // Leo el mensaje del cliente
                String mensaje = flujoEntrada.readUTF();
                
                // NOTIFICAR AL OBJETO OBSERVABLE DE QUE HA HABIDO CAMBIOS
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                //
            
                socket.close();
                System.out.println("Cliente desconectado");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor_001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
   
}
