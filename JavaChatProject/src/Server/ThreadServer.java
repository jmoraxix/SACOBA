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

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Diego
 */
public class ThreadServer extends Thread {

    Socket scli = null;
    Socket scli2 = null;
    DataInputStream entrada = null;
    DataOutputStream salida1 = null;
    DataOutputStream salida2 = null;
    public static Vector<ThreadServer> clientesActivos = new Vector();
    String nameUser;
    Server serv;

    public ThreadServer(Socket scliente, Socket scliente2, Server serv) {
        scli = scliente;
        scli2 = scliente2;
        this.serv = serv;
        nameUser = "";
        clientesActivos.add(this);
        serv.mostrar("cliente agregado: " + this);
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String name) {
        nameUser = name;
    }

    public void run() {
        serv.mostrar(".::Esperando Mensajes :");

        try {
            entrada = new DataInputStream(scli.getInputStream());
            salida1 = new DataOutputStream(scli.getOutputStream());
            salida2 = new DataOutputStream(scli2.getOutputStream());
            this.setNameUser(entrada.readUTF());
            enviaUserActivos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int opcion = 0, numUsers = 0;
        String amigo = "", mencli = "";

        while (true) {
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1://envio de mensage a todos
                        mencli = entrada.readUTF();
                        serv.mostrar("mensaje recibido " + mencli);
                        enviaMsg(mencli);
                        break;
                    case 2://envio de lista de activos
                        numUsers = clientesActivos.size();
                        salida1.writeInt(numUsers);
                        for (int i = 0; i < numUsers; i++) {
                            salida1.writeUTF(clientesActivos.get(i).nameUser);
                        }
                        break;
                    case 3: // envia mensage a uno solo
                        amigo = entrada.readUTF();//captura nombre de amigo
                        mencli = entrada.readUTF();//mensage enviado
                        enviaMsg(amigo, mencli);
                        break;
                }
            } catch (IOException e) {
                System.out.println("El cliente termino la conexion");
                break;
            }
        }
        serv.mostrar("Se removio un usuario");
        clientesActivos.removeElement(this);
        try {
            serv.mostrar("Se desconecto un usuario");
            scli.close();
        } catch (Exception et) {
            serv.mostrar("no se puede cerrar el socket");
        }
    }

    public void enviaMsg(String mencli2) {
        ThreadServer user = null;
        for (int i = 0; i < clientesActivos.size(); i++) {
            serv.mostrar("MENSAJE DEVUELTO:" + mencli2);
            try {
                user = clientesActivos.get(i);
                user.salida2.writeInt(1);//opcion de mensage 
                user.salida2.writeUTF("" + this.getNameUser() + " >" + mencli2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviaUserActivos() {
        ThreadServer user = null;
        for (int i = 0; i < clientesActivos.size(); i++) {
            try {
                user = clientesActivos.get(i);
                if (user == this) {
                    continue;//ya se lo envie
                }
                user.salida2.writeInt(2);//opcion de agregar 
                user.salida2.writeUTF(this.getNameUser());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void enviaMsg(String amigo, String mencli) {
        ThreadServer user = null;
        for (int i = 0; i < clientesActivos.size(); i++) {
            try {
                user = clientesActivos.get(i);
                if (user.nameUser.equals(amigo)) {
                    user.salida2.writeInt(3);//opcion de mensage amigo   
                    user.salida2.writeUTF(this.getNameUser());
                    user.salida2.writeUTF("" + this.getNameUser() + ">" + mencli);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
