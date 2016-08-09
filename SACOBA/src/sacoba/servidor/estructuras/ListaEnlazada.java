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
public class ListaEnlazada {

    //Variables
    NodoLista cabeza;

    //Metodos
    public void inserta(Pila p) {

        if (cabeza == null) {
            cabeza = new NodoLista(p);
        } else {
            NodoLista aux = cabeza;

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            NodoLista temp = new NodoLista(p);
            aux.setNext(temp);
        }
    }

    @Override
    public String toString() {
        NodoLista aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += aux + "";
            aux = aux.getNext();
        }
        return s;
    }

}
