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

import sacoba.cliente.Cliente;

/**
 *
 * @author jmora
 */
public class NodoListaClientes {

    //Variables
    private Cliente cliente;
    private NodoListaClientes next;

    //Constructor

    /**
     *
     * @param cliente
     */
    public NodoListaClientes(Cliente cliente) {
        this.cliente = cliente;
        next = null;
    }

    //Metodos

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
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
