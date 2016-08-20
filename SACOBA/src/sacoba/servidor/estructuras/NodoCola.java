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
    private final Persona persona;
    private NodoCola atras;

    //Constructor

    /**
     *
     * @param secuencia
     * @param usuario
     */
    public NodoCola(String secuencia, Persona usuario) {
        this.secuencia = secuencia;
        this.persona = usuario;
    }

    //Getters & setters

    /**
     *
     * @return
     */
    public String getSecuencia() {
        return secuencia;
    }

    /**
     *
     * @return
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     *
     * @return
     */
    public NodoCola getAtras() {
        return atras;
    }

    /**
     *
     * @param atras
     */
    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }

    //Metodos
    @Override
    public String toString() {
        return secuencia + ": " + persona;
    }

}
