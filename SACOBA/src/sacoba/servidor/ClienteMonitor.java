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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class ClienteMonitor extends ClienteServidor {

    public ClienteMonitor(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        //TODO definir comportamiento del servidor al recibir la data

    }

    private void notificarUsuario(final String usuario, final String secuencia, final String caja) {
        try {
            out.writeInt(1); //Tipo de transaccion 1: Notifica usuario
            out.writeUTF(secuencia + " - " + usuario + " a caja #" + caja);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void notificarCambioCola(final int cola, final int cantidad) {
        try {
            out.writeInt(2); //Tipo de transaccion 2: Notifica un cambio en las colas
            //out.writeInt(1); //Numero de la cola: 1 Plataforma, 2 Tramites, 3 Cuentas
            out.writeInt(cantidad);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
