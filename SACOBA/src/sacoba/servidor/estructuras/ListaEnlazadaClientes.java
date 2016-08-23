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

import sacoba.servidor.ClienteServidor;
import sacoba.servidor.beans.Notificacion;
import sacoba.servidor.beans.Persona;

/**
 *
 * @author jmora
 */
public class ListaEnlazadaClientes {

    //Variables
    NodoListaClientes cabeza;

    //Metodos
    /**
     *
     * @param cliente
     */
    public void insertarCliente(ClienteServidor cliente) {
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

    /**
     *
     * @param cliente
     */
    public void eliminarCliente(ClienteServidor cliente) {
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

    public void notificarCambioCola(Notificacion notificacion, final String cantidad) {
        if (cabeza != null) {
            NodoListaClientes nodo = cabeza;
            while (nodo != null) {
                nodo.getCliente().notificarCambioColaACliente(notificacion, cantidad);
                nodo = nodo.getNext();
            }
        }
    }

    public void notificarUsuarioAMonitores(String secuencia, Persona persona, final String caja) {
        if (cabeza != null) {
            NodoListaClientes nodo = cabeza;
            while (nodo != null) {
                nodo.getCliente().notificarUsuarioAMonitor(secuencia, persona, caja);
                nodo = nodo.getNext();
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
