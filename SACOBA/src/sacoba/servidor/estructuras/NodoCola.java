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

import sacoba.servidor.beans.Persona;

/**
 *
 * @author marce
 */
public class NodoCola {

    //Variables
    private final String secuencia;
    private final Persona usuario;
    private NodoCola atras;

    //Constructor
    public NodoCola(String secuencia, Persona cliente) {
        this.secuencia = secuencia;
        this.usuario = cliente;
    }

    //Getters & setters
    public String getSecuencia() {
        return secuencia;
    }

    public Persona getUsuario() {
        return usuario;
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
        return "NodoCola{" + "secuencia=" + secuencia + ", cliente=" + usuario + '}';
    }

}
