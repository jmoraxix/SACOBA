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
public class NodoArbol {

    //Variables
    private NodoArbol siguiente;
    private NodoArbol padre;
    private ListaEnlazadaHojas procesos;
    private ColaSecuencias colaSecuencias;
    private final String id;
    private String titulo;
    private int totalClientes;
    private int indice;

    //Constructor
    /**
     * Crea un nuevo nodo del arbol
     *
     * @param padre Nodo padre del nodo actual
     * @param id ID del nodo actual
     * @param titulo Titulo del nodo
     */
    public NodoArbol(NodoArbol padre, String id, String titulo) {
        this.padre = padre;
        this.id = id;
        this.titulo = titulo;
        this.indice = 0;
        this.totalClientes = 0;
        this.procesos = new ListaEnlazadaHojas();
    }

    //Getters & setters
    public int getTotalClientes() {
        return totalClientes;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public NodoArbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArbol siguiente) {
        this.siguiente = siguiente;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    //Metodos
    public NodoArbol getHoja(String id) {
        return procesos.getHoja(id);
    }

    public boolean esHoja() {
        return procesos.estaVacia();
    }

    public int cantidadHojas() {
        return procesos.contar();
    }

    public void aumentarIndice() {
        if (this.indice == cantidadHojas()) {
            System.out.println("Indice del nodo " + this.titulo + " aumenta");
            this.indice = 1;
            if (padre != null) {
                padre.aumentarIndice();
            }
        } else {
            this.indice++;
        }
    }

    private void aumentarClientes() {
        this.totalClientes++;
    }

    private void disminuirClientes() {
        this.totalClientes--;
    }

    public void insertarHoja(String idPadre, NodoArbol nodo) {
        if (this.colaSecuencias == null) { //Si la cola de usuarios no esta vacia, no se puede agregar otro hijo
            if (this.id.equals(idPadre)) {// Si este nodo es el padre lo inserta
                procesos.insertaNodo(nodo);
                nodo.setPadre(this);
                this.indice = 1;
            } else { //Si no es el padre, lo inserto al hijo con ese ID
                NodoArbol aux = this.procesos.getHoja(idPadre);
                if (aux != null) {
                    aux.insertarHoja(idPadre, nodo);
                }
            }
        }
    }

    public String insertarUsuario(String idCola, Persona usuario) {
        if (this.esHoja()) {
            padre.aumentarClientes();
            String secuencia =  String.valueOf(this.id.charAt(0)) + String.valueOf(padre.getTotalClientes());
            if (this.colaSecuencias == null) {
                NodoColaSecuencias nodo = new NodoColaSecuencias(secuencia, usuario);
                this.colaSecuencias = new ColaSecuencias(nodo);
            } else {
                colaSecuencias.enCola(new NodoColaSecuencias(secuencia, usuario));
            }
            return secuencia + ";" + padre.getTotalClientes();
        } else {
            NodoArbol nodo = this.procesos.getHoja(idCola);
            return nodo.insertarUsuario(idCola, usuario);
        }
    }

    public NodoColaSecuencias siguienteUsuario() {
        if (this.indice != 0) {
            return this.procesos.irAlNodo(this.indice).siguienteUsuario();
        } else {
            if(this.colaSecuencias == null)
                return padre.siguienteUsuario();
            
            NodoColaSecuencias siguiente = this.colaSecuencias.desencola();
            padre.aumentarIndice();
            padre.disminuirClientes();

            if (siguiente != null) {
                return siguiente;
            } else {
                return padre.siguienteUsuario();
            }
        }
    }

}
