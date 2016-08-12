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
    private ColaUsuarios colaUsuarios;
    private final String id;
    private String titulo;
    private int totalClientes;
    private int indice;

    //Constructor
    public NodoArbol(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.indice = 0;
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

    //Metodos
    public NodoArbol getHoja(String id) {
        return procesos.getHoja(id);
    }

    public boolean esHoja() {
        return procesos.estaVacia();
    }

    public void insertarHoja(NodoArbol nodo) {
        if (this.colaUsuarios.estaVacia()) { //Si la cola de usuarios no esta vacia, no se puede agregar otro hijo
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
//                this.colaUsuarios = new ColaUsuarios(new NodoCola(id.getBytes()[1] + "", usuario));
//            } else {
//                procesos.insertaNodo(nodo);
//            }
//        }
//    }
}
