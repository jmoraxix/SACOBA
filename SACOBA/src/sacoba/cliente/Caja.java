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
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.servidor.ClienteServidor;
import sacoba.servidor.beans.Notificacion;

/**
 *
 * @author jdmoralo
 */
public class Caja extends Cliente {
    
    private CajaView view;

    public Caja(CajaView caja) {
        this.view = caja;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                // Recibe un dato de entrada
                String entrada = in.readUTF();
                System.out.println(entrada);
                String[] datos = entrada.split(";"); // Divide los datos de la entrada en cada ';'

                switch (Notificacion.convertirValor(Integer.parseInt(datos[0]))) {
                    case CLIENTE_A_CAJA:
                        clienteACaja(datos);
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Metodos de TCP
    /*
     Envia una notificacion al servidor de que la caja esta vacia
     */
    public void liberarCaja() {
        try {
            System.out.println("Liberar caja");
            String ncaja = view.getNumCaja();
            out.writeUTF(Notificacion.LIBERAR_CAJA.getValor() + ";" + ncaja );
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean enviarUsuarioNuevo(String cedula, String nombre, String apellido, boolean isEmpleado) {
        try {
            System.out.println("Crear usuario nuevo");
            out.writeUTF(Notificacion.CREAR_USUARIO.getValor() + ";" + cedula + ";" + nombre + ";" + apellido + ";" + (isEmpleado ? 1 : 0));
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
     Recibe la secuenca generada para el usuario por el servidor y la muestra en pantalla
     */
    private void clienteACaja(String[] datos) {
        view.setTxtSecuencia(datos[1]);
        view.setTxtNombreUsuario(datos[2]);
        
        char tipo = datos[1].charAt(0);
        if (tipo == 'P') {
        view.setTxtTramite("Plataforma");
        } else if (tipo == 'T') {
        view.setTxtTramite("Tramites");
        } else if (tipo == 'C') {
        view.setTxtTramite("Cuentas");
        }
    }

    
}
