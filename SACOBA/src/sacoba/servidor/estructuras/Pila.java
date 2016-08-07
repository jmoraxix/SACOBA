package sacoba.servidor.estructuras;

/**
 *
 * @author Alejandro
 */
public class Pila {

    private NodoPuertas top;

    public void push(NodoPuertas c) {
        if (top == null) {
            top = c;
        } else {
            c.setAbajo(top);
            top = c;
        }

    }

    public NodoPuertas pop() {
        NodoPuertas c = top;
        if (top != null) {
            top = top.getAbajo();
            c.setAbajo(null);
        }
        return c;
    }

    public String toString() {
        String cl = "";
        NodoPuertas aux = top;
        while (aux != null) {
            cl += aux;
            aux = aux.getAbajo();
        }
        return cl;
    }
}
