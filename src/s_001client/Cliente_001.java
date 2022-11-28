/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_001client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virgi
 */
public class Cliente_001 implements Runnable{
    
   
    private int puerto;
    private String mensaje;

    public Cliente_001(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
  
    @Override
    public void run() {
     
        final String HOST = "localhost";
        //DataInputStream entrada;
        DataOutputStream salida;
            
        try {
          
            Socket socket = new Socket(HOST, puerto);
            
         // entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF(mensaje);
            
           
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente_001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
   
}
