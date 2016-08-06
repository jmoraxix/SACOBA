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
 * @author jmora
 */
public class ClientePuerta extends ClienteServidor {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    
    public ClientePuerta(final Socket socket){
        super(socket);
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
        while(true){
            recibirCliente();
        }
    }

    /*
        

    */
    public void recibirCliente(){
        //TODO programar como se reciben los datos de las puertas en el servidor
        try {
//            String info = in.readUTF();
//            System.out.println(info);
//            sendData("Hola");
            ArrayList<String> cliente = new ArrayList<String>();
            for(String cl : (String) in.readObject()){
                Object o = in.readObject();
                cliente.add(cl);
            }
        } catch (IOException | ClassNotFoundException ioe) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    private void enviarSecuencia(){
        
    }
    public void notificarCambioCola(final int cola, final int cantidad) {
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
