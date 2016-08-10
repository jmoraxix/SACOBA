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

import java.util.ArrayList;

/**
 *
 * @author Marce
 */
public class NodoArbol {

    private Proceso raiz;
    public ArrayList<NodoArbol> HijosList = new ArrayList<NodoArbol>();
    private String info = "";

    public NodoArbol(String theInfo) {
        this.setInfo(theInfo);
    }

    public void setInfo(String theInfo) {
        this.info = theInfo;
    }

    public String getInfo() {
        return info;
    }
    

    public Proceso getRaiz() {
        return raiz;
    }

    public void setRaiz(Proceso raiz) {
        this.raiz = raiz;
    }

    public ArrayList<NodoArbol> getHijosList() {
        return HijosList;
    }

    public void setHijosList(ArrayList<NodoArbol> HijosList) {
        this.HijosList = HijosList;
    }

}
