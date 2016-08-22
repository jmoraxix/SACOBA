/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package Server;

import Client.VentanaCliente;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Diego
 */
public class Server extends JFrame {

    JTextArea txaMostrar;

    public Server() {
        super("Consola servidor");
        txaMostrar = new JTextArea();

        this.setContentPane(new JScrollPane(txaMostrar));
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.getContentPane().setBackground(Color.red);

    }

    public void mostrar(String msg) {
        txaMostrar.append(msg + "\n");
    }

    public void runServer() {
        ServerSocket serv = null;//para comunicacion
        ServerSocket serv2 = null;//para enviar mensajes
        boolean listening = true;
        try {
            serv = new ServerSocket(8081);
            serv2 = new ServerSocket(8082);
            mostrar(".::Servidor activo :");
            while (listening) {
                Socket sock = null, sock2 = null;
                try {
                    mostrar("Esperando Usuarios");
                    sock = serv.accept();
                    sock2 = serv2.accept();
                } catch (IOException e) {
                    mostrar("Accept failed: " + serv + ", " + e.getMessage());
                    continue;
                }
                ThreadServer user = new ThreadServer(sock, sock2, this);
                user.start();
            }

        } catch (IOException e) {
            mostrar("error :" + e);
        }
    }

    public static void main(String abc[]) throws IOException {
        Server ser = new Server();
        ser.runServer();
        Image icon = Toolkit.getDefaultToolkit()
                .getImage(Server.class.getResource("/Imagenes/logo_principal_icono.png"));
        ser.setIconImage(icon);
        
    }
}
