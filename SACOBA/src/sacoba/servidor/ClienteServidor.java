/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.servidor.beans.Notificacion;
import sacoba.servidor.beans.Persona;

/**
 *
 * @author jmora
 */
public class ClienteServidor extends Thread {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final Socket socket;
    private final Servidor servidor;
    private boolean isRunning = true;

    /**
     *
     */
    public final static int RECIBIR_USUARIO = 1;

    /**
     *
     * @param servidor
     * @param socket
     */
    public ClienteServidor(final Servidor servidor, final Socket socket) {
        this.servidor = servidor;
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
        while (isRunning) {
            try {
                // Recibe un dato de entrada
                String entrada = in.readUTF();
                System.out.println(entrada);
                String[] datos = entrada.split(";"); // Divide los datos de la entrada en cada ';'

                switch (Notificacion.convertirValor(Integer.parseInt(datos[0]))) {
                    case ENTRA_USUARIO:
                        recibirUsuario(datos);
                        break;
                    case LIBERAR_CAJA:
                        //liberarCaja();
                        break;
                    default:
                        throw new AssertionError(Notificacion.convertirValor(Integer.parseInt(datos[0])).name());
                }

            } catch (IOException ex) {
                //Logger.getLogger(ClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Cliente desconectado");
                isRunning = false;
            }
        }
    }

    /**
     *
     * @param datos
     */
    public void recibirUsuario(String[] datos) {
        /*
            TODO    
        1.  Toma ambos strings. Busca la persona por la cedula en servidor.getPersonas() y añade la persona a la cola debida
        2.  Llama servidor.notificarCambioCola(Notificacion.<tipo de notificacion>, <nueva cantidad de personas en la cola>) y le notifica 
        cuantas personas hay ahora en esa cola
        3. Envia secuencia de vuelta al mismo cliente con el codigo comentado abajo
        
        datos[1] -> Cedula
        datos[2] -> ID del proceso a hacer
         */

//        try {
//            out.writeUTF(Notificacion.NOTIFICA_SECUENCIA.getValor() + ";" + secuencia);
//            out.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     *
     * @param notificacion
     * @param cantidad
     */
    public void notificarCambioCola(Notificacion notificacion, final int cantidad) {
//        try {
//            out.writeUTF(Notificacion.AVANZA_CLIENTE.getValor() + ";" + secuencia + ": " + persona + " pasar a caja  #" + caja);
//            out.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void notificarUsuarioMonitor(final String usuario, String secuencia, Persona persona, final String caja) {
        try {
            out.writeUTF(Notificacion.AVANZA_CLIENTE.getValor() + ";" + secuencia + ": " + persona + " pasar a caja #" + caja);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
