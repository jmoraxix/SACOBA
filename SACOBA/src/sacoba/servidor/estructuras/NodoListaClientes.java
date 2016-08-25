/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor.estructuras;

import sacoba.servidor.ClienteServidor;

/**
 *
 * @author jmora
 */
public class NodoListaClientes {

    //Variables
    private ClienteServidor cliente;
    private NodoListaClientes next;

    //Constructor
    /**
     *
     * @param cliente
     */
    public NodoListaClientes(ClienteServidor cliente) {
        this.cliente = cliente;
        next = null;
    }

    //Metodos
    /**
     *
     * @return
     */
    public ClienteServidor getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(ClienteServidor cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public NodoListaClientes getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(NodoListaClientes next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return cliente.toString();
    }

}
