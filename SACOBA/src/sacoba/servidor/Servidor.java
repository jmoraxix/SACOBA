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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.cliente.Cliente;

/**
 *
 * @author Marce
 */
public class Servidor {

    private ServerSocket serverSocket;
    private Socket socket;
    private ExecutorService service;

    /*
    TODO    Lista enlazada de clientes
            1.  Se agrega una pila de ClientePuerta
            2.  Se agrega una pila de ClienteMonitore
            3.  Se agrega una pila de ClienteCaja
     */
    private List<Cliente> clientes;

    public Servidor() {
        try {
            service = Executors.newCachedThreadPool();
            //TODO  Inicializar la lista enlazada clientes
            clientes = new ArrayList<>();
            //TODO  Inicilalizar y agregar las pilas 
            serverSocket = new ServerSocket(2356);
            Accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Accept() {
        try {
            while (true) {
                System.out.println("Accept 1");
                socket = serverSocket.accept();
                //TODO Segun el tipo del cliente se declara tipo ClientePuerta, ClienteMonitor, ClienteCaja y se agreagan a la pila correspondientes
//                ClienteServidor client = new ClienteServidor(socket);
//                service.submit(client);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    /*
    public Pila getPuertas(){
        return clientes.getItem(1);
    }
    public Pila getMonitores(){
        return clientes.getItem(2);
    }
    public Pila getCajas(){
        return clientes.getItem(3);
    }
     */
}
