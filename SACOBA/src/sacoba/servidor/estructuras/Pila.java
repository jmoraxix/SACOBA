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
    public void push(NodoPila c) {
        if (top == null) {
            top = c;
        } else {
            c.setAbajo(top);
            top = c;
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
            cl += aux;
            aux = aux.getAbajo();
        }
        return cl;
    }
}
