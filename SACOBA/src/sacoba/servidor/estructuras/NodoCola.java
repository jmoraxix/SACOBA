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
 * @author marce
 */
public class NodoCola {

    //Variables
    private String secuencia;
    private Cliente cliente;
    private NodoCola atras;

    //Constructor
    public NodoCola(String secuencia) {
        this.secuencia = secuencia;
    }

    //Getters & setters
    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }

    //Metodos
    @Override
    public String toString() {
        return "NodoCola {" + "Secuencia = " + secuencia + '}';
    } // Retorna la informacion en String

}
