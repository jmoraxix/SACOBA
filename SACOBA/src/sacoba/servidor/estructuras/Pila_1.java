/*
 * Semana 3
 * Jose David Mora Loria
 */
package sacoba.servidor.estructuras;

/**
 *
 * @author gumana
 */
public class Pila_1 {

    private NodoPila top;

    public void push(NodoPila d) {  //Coloca un elemento en la pila
        if (top == null) {  //Si la pila está vacía, top = d
            top = d;
        } else {  //Si no está vacía, se coloca arriba y actualiza top
            d.setAbajo(top);
            top = d;
        }
    }

    public NodoPila pop() {  // Saca un elemento de la pila
        NodoPila d = top;   // guardo temporalmente el top en d
        if (top != null) {  // si la pila no está vacia, actualizamos el top hacia abajo
            top = top.getAbajo();
            d.setAbajo(null);  // elimino el enlace
        }
        return d;  // retorno el top anterior (d)
    }
    private NodoPila pop2() {  // Saca un elemento de la pila
        NodoPila d = top;   // guardo temporalmente el top en d
        if (top.getAbajo() != null) {  // si la pila no está vacia, actualizamos el top hacia abajo
            top = top.getAbajo();
            d.setAbajo(null);  // elimino el enlace
        } else {
            top = null;
        }
        return d;  // retorno el top anterior (d)
    }

    public String toString() {  //Inspecciono la pila (internamente) sin eliminar nodos
        String s = "";  // Defino s como un String vacío
        NodoPila aux = top;  // pongo en un auxiliar (aux) el top actual
        while (aux != null) {  // mientras aux no se nulo se hace el ciclo
            s += aux;     //Concateno aux a s (se llama al toString de aux)
            aux = aux.getAbajo();  //actualizo aux como el de abajo...
        }
        return s;  // retorno s
    }
    
    /***** Métodos construidos *****/
    public boolean buscar(int valor){
        if(this.top.getDato() == valor)
            return true;
        else 
            return buscar_aux(valor, top.getAbajo());
    }
    private boolean buscar_aux(int valor, NodoPila nodo){
        if(nodo.getDato() == valor)
            return true;
        else if(nodo.getAbajo() == null)
            return false;
        else 
            return buscar_aux(valor, nodo.getAbajo());
    }
    
    public NodoPila saque(int valor){
        if(top.getDato() == valor)
            return this.pop();
        else
            return saque_aux(valor, top.getAbajo(), top);
    }
    private NodoPila saque_aux(int valor, NodoPila nodo, NodoPila anterior){
        if(nodo.getDato() == valor){
            anterior.setAbajo(nodo.getAbajo());
            nodo.setAbajo(null);
            return nodo;
        } else if(nodo.getAbajo() == null)
            return null;
        else
            return saque_aux(valor, nodo.getAbajo(), nodo);
    }
    
    public void ordenar(){
        if(top != null && top.getAbajo() != null)
            bubbleSort(top, 0);
    }
    private void bubbleSort(NodoPila nodo, int n) {
        if(nodo.getAbajo() == null && n != 0)
            bubbleSort(top, 0);
        else if(nodo.getAbajo() != null){
            if(nodo.getDato() > nodo.getAbajo().getDato()){
                int temp = nodo.getDato();
                nodo.setDato(nodo.getAbajo().getDato());
                nodo.getAbajo().setDato(temp);
                n++;
            }
            bubbleSort(nodo.getAbajo(), n);
        }
    }
}
