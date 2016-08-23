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
import java.util.ArrayList;
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
                    case CREAR_USUARIO:
                        crearUsuario(datos);
                        break;

                    default:
                        throw new AssertionError(Notificacion.convertirValor(Integer.parseInt(datos[0])).name());
                }

            } catch (IOException ex) {
                //Logger.getLogger(ClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.println("Cliente desconectado");
                servidor.agregarLog("Cliente desconectado");
                isRunning = false;
            }
        }
    }

    /**
     * Recibe los datos de un usuario que entra por el cliente puerta
     *
     * @param datos
     */
    public void recibirUsuario(String[] datos) {
        /*
         TODO Recibir usuarios desde los cliente
         1.  Toma ambos strings. Busca la persona por la cedula en servidor.getPersonas(). Si la encuentra la guarda en una
         variable auxiliar.  Si no crea una persona "Invitada".
         2. Inserta la persona a la cola debida en servidor.insertarUsuarioEnCola(String idCola, Persona persona) y recibe 
         la secuencia correspondiente
         3. Llama servidor.notificarCambioColaACliente(Notificacion.<tipo de notificacion>, <nueva cantidad de personas en la cola>) y le notifica 
         cuantas personas hay ahora en esa cola
         3. Envia secuencia de vuelta al mismo cliente con el codigo comentado abajo
        
         datos[1] -> Cedula
         datos[2] -> ID del proceso a hacer
         */

        System.out.println("1");
        //Consigue la persona registrada en la lista de personas
        ArrayList<Persona> personas = servidor.getPersonas();
        System.out.println("2");
        Persona cliente = null;
        for (Persona persona : personas) {
            if (datos[1].equals(persona.getCedula())) {
                cliente = persona;
            }
        }
        System.out.println("3");
        if (cliente == null) {
            cliente = new Persona(datos[1], "Invitado", "");
        }
        System.out.println("4");

        //Lo inserta a la cola respectiva
        String[] valores = servidor.insertarUsuarioEnCola(datos[2], cliente).split(";");
        System.out.println(valores);
        String secuencia = valores[0];
        String cantidadEnCola = valores[1];

        //Enviamos la secuencia al cliente
        try {
            System.out.println("Envia secuencia");
            out.writeUTF(Notificacion.NOTIFICA_SECUENCIA.getValor() + ";" + secuencia);
            out.flush();
            System.out.println("Envia secuencia");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Notificamos a los clientes un cambio de cola
        Notificacion notificacion = null;
        if (secuencia.charAt(1) == 'P') {
            notificacion = Notificacion.ACTUALIZA_PLATAFORMA;
        } else if (secuencia.charAt(1) == 'T') {
            notificacion = Notificacion.ACTUALIZA_TRAMITES;
        } else if (secuencia.charAt(1) == 'C') {
            notificacion = Notificacion.ACTUALIZA_CUENTAS;
        }
        servidor.notificarCambioCola(notificacion, cantidadEnCola);
    }

    /**
     * Envia una notificacion del cambio de una cola a todos los clientes
     *
     * @param notificacion
     * @param cantidad
     */
    public void notificarCambioColaACliente(Notificacion notificacion, final String cantidad) {
        try {
            System.out.println("notificarCambioColaACliente");
            out.writeUTF(notificacion.getValor() + ";" + cantidad);
            out.flush();
            System.out.println("notificarCambioColaACliente");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Notifica a todos los clientes de un usuario que avanzo en la cola
     *
     * @param secuencia
     * @param persona
     * @param caja
     */
    public void notificarUsuarioAMonitor(String secuencia, Persona persona, final String caja) {
        try {
            out.writeUTF(Notificacion.AVANZA_CLIENTE.getValor() + ";" + secuencia + ": " + persona + " pasar a caja #" + caja);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearUsuario(String[] datos) {

    }
}
