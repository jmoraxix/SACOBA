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
 * @author Alejandro
 */
public class Pila {

    //Variables
    private NodoPila top;

    //Metodos
    public void push(NodoPila nodo) {
        if (top == null) {
            top = nodo;
        } else {
            nodo.setAbajo(top);
            top = nodo;
        }

    }

    public NodoPila pop() {
        NodoPila c = top;
        if (top != null) {
            top = top.getAbajo();
            c.setAbajo(null);
        }
        return c;
    }

    public String toString() {
        String cl = "";
        NodoPila aux = top;
        while (aux != null) {
            cl += "->" + aux;
            aux = aux.getAbajo();
        }
        return cl;
    }
}
