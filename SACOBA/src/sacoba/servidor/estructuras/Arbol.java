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
 * @author Marce
 */
public class Arbol {

    public NodoArbol raiz;

    public NodoArbol nodoActual;

    public Arbol() {
        raiz = null;
    }

    public void insertarHijo(String padre, String id, String titulo) {
        NodoArbol aux = new NodoArbol(id, titulo);

        if (raiz == null) {
            raiz = aux;
        } else {

            this.insertarHijo_rec(raiz, padre, aux);
        }
    }

    private void insertarHijo_rec(NodoArbol nodoActual, String padre, NodoArbol hijo) {
        if (nodoActual.getTitulo().equals(padre)) {
            nodoActual.insertarHoja(hijo);
            System.out.println("Nodo insertado: " + hijo.getTitulo());
        } else {
//            for (int i = 0; i < nodoActual.getHoja(padre).size(); i++) {
//                this.insertarHijo((NodoArbol) nodoActual.HijosList.get(i), padre, titulo);
//            }
        }
    }

    private void creaEstructura() {
//        insertarHijo(" ", "Banco");
//        insertarHijo("Banco", "Tramites");
//        insertarHijo("Banco", "Plataforma");
//        insertarHijo("Banco", "Cuentas");
    }

}
