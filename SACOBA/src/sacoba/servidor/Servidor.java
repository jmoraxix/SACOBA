/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private List<Cliente> clients;
    private ExecutorService service;

    public Servidor() {
        try {
            service = Executors.newCachedThreadPool();
            clients = new ArrayList<>();
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
                ClienteServidor client = new ClienteServidor(socket);
                service.submit(client);
                System.out.println("Accept 2");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
