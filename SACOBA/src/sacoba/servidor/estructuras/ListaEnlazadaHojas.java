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

            while (aux.getSiguiente() != null) {
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
     * Encuentra una hoja en la lista.
     *
     * @param ID
     * @return Retorna una hoja con el ID recibido. Si no la encuentra retorna
     * nulo
     */
    public NodoArbol getHoja(String ID) {
        NodoArbol buscado = null;
        if (cabeza != null) {
            if (cabeza.getId().equals(ID)) {
                buscado = cabeza;
            } else {
                NodoArbol aux = cabeza;
                while (aux.getSiguiente() != null) {
                    if (aux.getId().equals(ID)) {
                        buscado = aux;
                    }
                    aux = aux.getSiguiente();
                }
                if (buscado == null) {
                    aux = cabeza;
                    while (aux.getSiguiente() != null) {
                        if (aux.getId().substring(0, 1) == ID.substring(0, 1)) {
                            buscado = aux;
                        }
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

    public int contar() {
        int conteo = 0;
        if (this.cabeza != null) {
            NodoArbol aux = cabeza;
            while (aux.getSiguiente() != null) {
                conteo++;
                aux = aux.getSiguiente();
            }
        }
        return conteo;
    }

    public NodoArbol irAlNodo(int numNodo) {
        NodoArbol nodo = null;
        int conteo = 1;
        if (this.cabeza != null) {
            NodoArbol aux = cabeza;
            while (aux.getSiguiente() != null) {
                if (conteo == numNodo) {
                    nodo = aux;
                }
                conteo++;
                aux = aux.getSiguiente();
            }
        }
        return nodo;
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
