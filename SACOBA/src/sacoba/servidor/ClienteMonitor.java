/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class ClienteMonitor implements Runnable{

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    
    public ClienteMonitor(final Socket socket)
    {
        this.socket = socket;
        createStream();
    }

     private void createStream() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    @Override
    public void run() {
        //TODO definir comportamiento del servidor al recibir la data

    }
 
    private void notificarUsuario(final String usuario, final String secuencia, final String caja) {
        try {
            ArrayList<String> mensaje = new ArrayList<String>();
            mensaje.add("usuario");
            mensaje.add(usuario);
            mensaje.add(secuencia);
            mensaje.add(caja);
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void notificarCambioCola(final int cola, final int cantidad) {
        try {
            ArrayList<String> mensaje = new ArrayList<String>();
            mensaje.add("cola");
            mensaje.add(Integer.toString(cola));
            mensaje.add(Integer.toString(cantidad));
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
