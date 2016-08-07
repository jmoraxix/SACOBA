/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.servidor.estructuras;

import sacoba.servidor.beans.Secuencia;

/**
 *
 * @author Marce
 */
public class Cola {
    Secuencia dato;
    NodoArbol next;

    public Cola(Secuencia dato, NodoArbol next) {
        this.dato = dato;
        this.next = next;
    }

    public Secuencia getDato() {
        return dato;
    }

    public void setDato(Secuencia dato) {
        this.dato = dato;
    }

    public NodoArbol getNext() {
        return next;
    }

    public void setNext(NodoArbol next) {
        this.next = next;
    }
    
    
}
