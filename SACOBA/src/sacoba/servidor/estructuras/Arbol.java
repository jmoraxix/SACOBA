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

import sacoba.servidor.beans.Persona;

/**
 *
 * @author Marce
 */
public class Arbol {

    public NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertarHoja(String idPadre, String id, String titulo) {
        NodoArbol aux = new NodoArbol(null, id, titulo);
        if (raiz == null) {
            raiz = aux;
        } else {
            raiz.insertarHoja(idPadre, aux);
        }
    }

    public String insertarUsuario(String idCola, Persona persona) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.insertarUsuario(idCola, persona);
        }
    }

    public NodoColaSecuencias siguienteUsuario() {
        if (raiz == null) {
            return null;
        } else {
            return raiz.siguienteUsuario();
        }
    }
}
