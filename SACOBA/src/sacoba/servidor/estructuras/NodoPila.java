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
public class NodoPila {

    //Variables
    private Cliente cliente;
    private NodoPila abajo;

    //Constructor
    public NodoPila(Cliente cliente) {
        this.cliente = cliente;
    }

    //Getters & setters
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

    //Metodos
    @Override
    public String toString() {
        return "" + "" + cliente + "\n";
    }

}
