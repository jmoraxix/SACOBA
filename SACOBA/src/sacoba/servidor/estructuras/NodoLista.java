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
public class NodoLista {

    //Variables
    private Pila dato;
    private NodoLista next;

    //Constructor
    public NodoLista(Pila dato) {
        this.dato = dato;
    }

    //Metodos
    public void setDato(Pila dato) {
        this.dato = dato;
    }

    public Pila getDato() {
        return dato;
    }

    public NodoLista getNext() {
        return next;
    }

    public void setNext(NodoLista next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + "" + dato + '\n';
    }

}
