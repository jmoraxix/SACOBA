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
public class ListaEnlazadaHojas {

    //Variables
    NodoArbol cabeza;

    //Constructor
    public ListaEnlazadaHojas() {
    }

    public ListaEnlazadaHojas(NodoArbol cabeza) {
        this.cabeza = cabeza;
    }

    //Metodos
    public void insertaNodo(NodoArbol nodo) {
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            NodoArbol aux = cabeza;

            while (aux != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    /**
     * Modifica el nombre del nodo
     *
     * @param nombreAnt
     * @param nombreNuevo
     */
    public void modificaNombre(String nombreAnt, String nombreNuevo) {
        if (cabeza != null) {
            if (cabeza.getTitulo().equalsIgnoreCase(nombreAnt)) {
                cabeza.setTitulo(nombreNuevo);
            } else {
                NodoArbol actual = cabeza.getSiguiente();
                while (actual.getSiguiente() != null) {
                    if (actual.getTitulo().equalsIgnoreCase(nombreAnt)) {
                        actual.setTitulo(nombreNuevo);
                    } else {
                        actual = actual.getSiguiente();
                    }
                }
            }
        }
    }

    /**
     * Elimina el nodo con el nombre recibido
     *
     * @param nombre Nombre del nodo a eliminar
     */
    public void elimina(String nombre) {
        if (cabeza != null) {
            if (cabeza.getTitulo().equalsIgnoreCase(nombre)) {
                cabeza = cabeza.getSiguiente();
            } else {
                NodoArbol anterior = cabeza;
                NodoArbol actual = cabeza.getSiguiente();
                while (actual.getSiguiente() != null) {
                    if (actual.getTitulo().equalsIgnoreCase(nombre)) {
                        anterior.setSiguiente(actual.getSiguiente());
                        actual.setSiguiente(null);
                    } else {
                        anterior = actual;
                        actual = actual.getSiguiente();
                    }
                }
            }
        }
    }

    /**
     *
     * @param ID
     * @return
     */
    public NodoArbol getHoja(String ID) {
        NodoArbol buscado = null;
        if (cabeza != null) {
            if (cabeza.getId().equalsIgnoreCase(ID)) {
                buscado = cabeza;
            } else {
                NodoArbol aux = cabeza;
                while (aux.getSiguiente() != null) {
                    if (aux.getId().equalsIgnoreCase(ID)) {
                        buscado = aux;
                    } else {
                        aux = aux.getSiguiente();
                    }
                }
            }
        }
        return buscado;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    @Override
    public String toString() {
        NodoArbol aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += " -> " + aux + "\n";
            aux = aux.getSiguiente();
        }
        return s;
    }

}
