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
public class ListaEnlazadaClientes {

    //Variables
    NodoListaClientes cabeza;

    //Metodos
    public void inserta(Cliente cliente) {
        if (cabeza == null) {
            cabeza = new NodoListaClientes(cliente);
        } else {
            NodoListaClientes aux = cabeza;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            NodoListaClientes temp = new NodoListaClientes(cliente);
            aux.setNext(temp);
        }
    }

    public void elimina(Cliente cliente) {
        if (cabeza != null) {
            if (cabeza.getCliente() == cliente) {
                cabeza = cabeza.getNext();
            } else {
                NodoListaClientes anterior = cabeza;
                NodoListaClientes actual = cabeza.getNext();
                while (actual.getNext() != null) {
                    if (actual.getCliente() == cliente) {
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

    @Override
    public String toString() {
        NodoListaClientes aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += " -> " + aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }

}
