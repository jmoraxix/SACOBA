/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmora
 */
public class ClientePuerta extends ClienteServidor {

    public ClientePuerta(final Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        while (true) {
            recibirCliente();
        }
    }

    public void recibirCliente() {
        //TODO Programar como se reciben los datos de las puertas en el servidor
        try {
            String info = in.readUTF();
            System.out.println(info);
        } catch (IOException ioe) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    private void enviarSecuencia() {

    }

    public void notificarCambioCola(final int cola, final int cantidad) {
        try {
            //TODO igual que en la clase ClienteMonitor
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
