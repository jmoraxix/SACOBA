/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.vista.VentanaBase;

/**
 *
 * @author jmora
 */
public abstract class Cliente extends VentanaBase implements Runnable {

    protected static String SERVER_IP;
    protected static int SERVER_PORT = 2356;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;
    protected Socket socket;

    public Cliente() {
        try {
            System.out.println(SERVER_IP);
            if (SERVER_IP.equals("localhost")) {
                socket = new Socket(InetAddress.getLocalHost(), SERVER_PORT);
            } else {
                socket = new Socket(SERVER_IP, SERVER_PORT);
            }
            createStream();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public abstract void run();

    private void createStream() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getSERVER_IP() {
        return SERVER_IP;
    }

    public static void setSERVER_IP(String SERVER_IP) {
        Cliente.SERVER_IP = SERVER_IP;
    }
}
