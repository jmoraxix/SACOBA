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
public class Cola {

    //Variables
    private NodoCola frente;
    private NodoCola ultimo;

    //Constructor
    public Cola() {
    }

    public Cola(NodoCola frente) {
        this.enCola(frente);
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

    public String toString() {
        String s = "";
        NodoCola aux = frente;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s; // retorno s
    }
}
