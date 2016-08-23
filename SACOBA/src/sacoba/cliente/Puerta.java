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
import javax.swing.JOptionPane;
import sacoba.servidor.ClienteServidor;
import sacoba.servidor.beans.Notificacion;

/**
 *
 * @author jdmoralo
 */
public class Puerta extends Cliente {
    
    private PuertaView view;

    public Puerta(PuertaView view) {
        this.view = view;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Recibe un dato de entrada
                System.out.println("Esperando datos");
                String entrada = in.readUTF();
                System.out.println(entrada);
                String[] datos = entrada.split(";"); // Divide los datos de la entrada en cada ';'
                System.out.println(Notificacion.convertirValor(Integer.parseInt(datos[0])));
                switch (Notificacion.convertirValor(Integer.parseInt(datos[0]))) {
                    case NOTIFICA_SECUENCIA:
                        notificaSecuencia(datos);
                        break;
                    case ACTUALIZA_PLATAFORMA:
                        actualizaPlataforma(datos);
                        break;
                    case ACTUALIZA_TRAMITES:
                        actualizaTramites(datos);
                        break;
                    case ACTUALIZA_CUENTAS:
                        actualizaCuentas(datos);
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
    public void entraUsuario() {
        String codigo = view.getCodeFromButton();
        if (codigo != null) {
            if (!view.getTxtCedula().equals("")) {
                try {
                    System.out.println("Envia datos");
                    out.writeUTF(Notificacion.ENTRA_USUARIO.getValor() + ";" + codigo + ";" + view.getTxtCedula());
                    out.flush();
                } catch (IOException ex) {
                    Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(view,
                        "Por favor seleccione una opción antes de continuar.",
                        "No se puede continuar",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view,
                    "Por favor seleccione una opción antes de continuar. Si no conoce la opción deseada selecione la opción \"Otro\".",
                    "No se puede continuar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
        Recibe la secuenca del usuario y la muestra en pantalla
     */
    private void notificaSecuencia(String[] datos) {
        System.out.println("Secuencia recibida: " + datos[1]);
        JOptionPane.showMessageDialog(view,
                "Su número de secuencia es: " + datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Plataforma
     */
    private void actualizaPlataforma(String[] datos) {
        view.setTxtPlataforma(datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Tramites
     */
    private void actualizaTramites(String[] datos) {
        view.setTxtTramites(datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Cuentas
     */
    private void actualizaCuentas(String[] datos) {
        view.setTxtCuentas(datos[1]);
    }
    
}
