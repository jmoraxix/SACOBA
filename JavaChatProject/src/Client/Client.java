/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package Client;

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Client {

    public static String IP_SERVER = "";
    VentanaCliente vent;
    DataInputStream entrada = null;
    DataOutputStream salida = null;
    DataInputStream entrada2 = null;
    Socket comunication = null;//para la comunicacion
    Socket comunication2 = null;//para recibir msg

    String nomCliente = "";

    /**
     * Creates a new instance of Cliente
     */
    public Client(VentanaCliente vent) throws IOException {
        this.vent = vent;
    }

    public void conexion() throws IOException {
        try {
            comunication = new Socket(Client.IP_SERVER, 8081);
            comunication2 = new Socket(Client.IP_SERVER, 8082);
            entrada = new DataInputStream(comunication.getInputStream());
            salida = new DataOutputStream(comunication.getOutputStream());
            entrada2 = new DataInputStream(comunication2.getInputStream());

            while (nomCliente.equals("")) {
                nomCliente = JOptionPane.showInputDialog("Introducir Nick :");
            }

            vent.setNombreUser(nomCliente);
            salida.writeUTF(nomCliente);
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        new ThreadCliente(entrada2, vent).start();
    }

    public String getNombre() {
        return nomCliente;
    }

    public Vector<String> pedirUsuarios() {
        Vector<String> users = new Vector();
        try {
            salida.writeInt(2);
            int numUsers = entrada.readInt();
            for (int i = 0; i < numUsers; i++) {
                users.add(entrada.readUTF());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public void flujo(String mens) {
        try {
            System.out.println("el mensaje enviado desde el cliente es :"
                    + mens);
            salida.writeInt(1);
            salida.writeUTF(mens);
        } catch (IOException e) {
            System.out.println("error...." + e);
        }
    }

    public void flujo(String amigo, String mens) {
        try {
            System.out.println("el mensaje enviado desde el cliente es :"
                    + mens);
            salida.writeInt(3);//opcion de mensage a amigo
            salida.writeUTF(amigo);
            salida.writeUTF(mens);
        } catch (IOException e) {
            System.out.println("error...." + e);
        }
    }

}
