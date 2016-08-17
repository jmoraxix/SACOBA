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
    private NodoCola frente;
    private NodoCola ultimo;

    //Constructor
    public ColaSecuencias() {
    }

    public ColaSecuencias(NodoCola nodo) {
        enCola(nodo);
    }

    //Metodos
    public void enCola(NodoCola d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    public NodoCola desencola() {
        NodoCola aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    @Override
    public String toString() {
        String s = "";
        NodoCola aux = frente;
        while (aux != null) {
            s += "-> " + aux + "\n";
            aux = aux.getAtras();
        }
        return s; // retorno s
    }

}
