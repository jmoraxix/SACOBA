/*
 * Semana 3
 * Jose David Mora Loria
 */
package sacoba.servidor.estructuras;

import sacoba.cliente.Cliente;

/**
 *
 * @author jmora
 */
public class NodoPila {

    private Cliente cliente;
    private NodoPila abajo;

    public NodoPila(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }

    @Override
    public String toString() {
        return "" + "" + cliente + "\n";
    }

}
