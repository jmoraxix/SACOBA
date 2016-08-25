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
import static sacoba.servidor.beans.Notificacion.ACTUALIZA_CUENTAS;
import static sacoba.servidor.beans.Notificacion.ACTUALIZA_PLATAFORMA;
import static sacoba.servidor.beans.Notificacion.ACTUALIZA_TRAMITES;
import static sacoba.servidor.beans.Notificacion.AVANZA_CLIENTE;

/**
 *
 * @author jdmoralo
 */
public class Monitor extends Cliente {
    
    private MonitorView view;

    public Monitor(MonitorView view) {
        this.view = view;
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
                    case ACTUALIZA_PLATAFORMA:
                        actualizaPlataforma(datos);
                        break;
                    case ACTUALIZA_TRAMITES:
                        actualizaTramites(datos);
                        break;
                    case ACTUALIZA_CUENTAS:
                        actualizaCuentas(datos);
                        break;
                    case AVANZA_CLIENTE:
                        avanzaCliente(datos);
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void avanzaCliente(String[] datos){
        view.addSiguiente(datos[1]);
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
