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

/**
 *
 * @author jmora
 */
public class ColaSecuencias {

    //Variables
    private NodoColaSecuencias frente;
    private NodoColaSecuencias ultimo;

    //Constructor

    /**
     *
     */
    public ColaSecuencias() {
    }

    /**
     *
     * @param nodo
     */
    public ColaSecuencias(NodoColaSecuencias nodo) {
        enCola(nodo);
    }

    //Metodos

    /**
     *
     * @param d
     */
    public void enCola(NodoColaSecuencias d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    /**
     *
     * @return
     */
    public NodoColaSecuencias desencola() {
        NodoColaSecuencias aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }

    /**
     *
     * @return
     */
    public boolean estaVacia() {
        return frente == null;
    }

    @Override
    public String toString() {
        String s = "";
        NodoColaSecuencias aux = frente;
        while (aux != null) {
            s += "-> " + aux + "\n";
            aux = aux.getAtras();
        }
        return s; // retorno s
    }

}
