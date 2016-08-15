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

import sacoba.cliente.Cliente;

/**
 *
 * @author jmora
 */
public class ListaEnlazadaPilas {

    //Variables
    NodoListaPila cabeza;

    //Metodos
    public void inserta(String nombre) {
        if (cabeza == null) {
            cabeza = new NodoListaPila(nombre);
        } else {
            NodoListaPila aux = cabeza;

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            NodoListaPila temp = new NodoListaPila(nombre);
            aux.setNext(temp);
        }
    }

    public void insertaEnPila(String nomPila, Cliente cliente) {
        if (cabeza.getTitulo().equalsIgnoreCase(nomPila)) {
            cabeza.addCliente(cliente);
        } else {
            NodoListaPila actual = cabeza.getNext();
            while (actual.getNext() != null) {
                if (actual.getTitulo().equalsIgnoreCase(nomPila)) {
                    actual.addCliente(cliente);
                } else {
                    actual = actual.getNext();
                }
            }
        }
    }

    public void modificaNombre(String nombreAnt, String nombreNuevo) {
        if (cabeza != null) {
            if (cabeza.getTitulo().equalsIgnoreCase(nombreAnt)) {
                cabeza.setTitulo(nombreNuevo);
            } else {
                NodoListaPila actual = cabeza.getNext();
                while (actual.getNext() != null) {
                    if (actual.getTitulo().equalsIgnoreCase(nombreAnt)) {
                        actual.setTitulo(nombreNuevo);
                    } else {
                        actual = actual.getNext();
                    }
                }
            }
        }
    }

    public void elimina(String nombre) {
        if (cabeza != null) {
            if (cabeza.getTitulo().equalsIgnoreCase(nombre)) {
                cabeza = cabeza.getNext();
            } else {
                NodoListaPila anterior = cabeza;
                NodoListaPila actual = cabeza.getNext();
                while (actual.getNext() != null) {
                    if (actual.getTitulo().equalsIgnoreCase(nombre)) {
                        anterior.setNext(actual.getNext());
                        actual.setNext(null);
                    } else {
                        anterior = actual;
                        actual = actual.getNext();
                    }
                }
            }
        }
    }

    public PilaClientes getPila(String nombre) {
        PilaClientes resultado = null;
        if (cabeza != null) {
            if (cabeza.getTitulo().equalsIgnoreCase(nombre)) {
                resultado = cabeza.getClientes();
            } else {
                NodoListaPila anterior = cabeza;
                NodoListaPila actual = cabeza.getNext();
                while (actual.getNext() != null) {
                    if (actual.getTitulo().equalsIgnoreCase(nombre)) {
                        resultado = actual.getClientes();
                    } else {
                        anterior = actual;
                        actual = actual.getNext();
                    }
                }
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        NodoListaPila aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += " -> " + aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }

}
