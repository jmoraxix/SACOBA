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

//    public void insertarHijo(String padre, String info) {
//        NodoArbol aux = new NodoArbol();
//
//        if (raiz == null) {
//            raiz = aux;
//        } else if (padre.equals("")) {
//            System.out.println("Padre vacio");
//        } else {
//            this.insertarHijo_rec(raiz, padre, info);
//        }
//    }
//
//    private void insertarHijo_rec(NodoArbol nodoActual, String padre, String theInfo) {
//        if (nodoActual.getInfo().equals(padre)) {
//            nodoActual.HijosList.add(new NodoArbol(theInfo));
//            System.out.println("Nodo insertado= " + theInfo);
//        } else {
//            for (int i = 0; i < nodoActual.HijosList.size(); i++) {
//                this.insertarHijo((NodoArbol) nodoActual.HijosList.get(i), padre, theInfo);
//            }
//        }
//    }
    private void creaEstructura() {
//        insertarHijo(" ", "Banco");
//        insertarHijo("Banco", "Tramites");
//        insertarHijo("Banco", "Plataforma");
//        insertarHijo("Banco", "Cuentas");
    }

}
