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
public class NodoArbol {

    //Variables
    private NodoArbol siguiente;
    private ListaEnlazadaHojas procesos;
    private ColaSecuencias colaSecuencias;
    private final String id;
    private String titulo;
    private int totalClientes;
    private int indice;

    //Constructor

    /**
     *
     * @param id
     * @param titulo
     */
    public NodoArbol(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.indice = 0;
        this.procesos = new ListaEnlazadaHojas();
    }

    //Getters & setters

    /**
     *
     * @return
     */
    public int getTotalClientes() {
        return totalClientes;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public NodoArbol getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(NodoArbol siguiente) {
        this.siguiente = siguiente;
    }

    //Metodos

    /**
     *
     * @param id
     * @return
     */
    public NodoArbol getHoja(String id) {
        return procesos.getHoja(id);
    }

    /**
     *
     * @return
     */
    public boolean esHoja() {
        return procesos.estaVacia();
    }

    /**
     *
     * @param nodo
     */
    public void insertarHoja(NodoArbol nodo) {
        if (this.colaSecuencias.estaVacia()) { //Si la cola de usuarios no esta vacia, no se puede agregar otro hijo
            if (procesos == null) {
                this.procesos = new ListaEnlazadaHojas(nodo);
            } else {
                procesos.insertaNodo(nodo);
            }
        }
    }

//    public void insertarUsuario(Persona usuario) {
//        if (this.esHoja()) {
//            if (this.colaUsuarios == null) {
//                this.colaUsuarios = new ColaSecuencias(new NodoCola(id.getBytes()[1] + "", usuario));
//            } else {
//                procesos.insertaNodo(nodo);
//            }
//        }
//    }
}
