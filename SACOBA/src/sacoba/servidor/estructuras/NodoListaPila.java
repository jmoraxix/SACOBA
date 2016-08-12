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

import sacoba.cliente.Cliente;

/**
 *
 * @author jmora
 */
public class NodoListaPila {

    //Variables
    private String titulo;
    private Pila clientes;
    private NodoListaPila next;

    //Constructor
    public NodoListaPila(String titulo) {
        this.titulo = titulo;
        this.clientes = new Pila();
        next = null;
    }

    //Metodos
    public Pila getClientes() {
        return clientes;
    }

    public void setClientes(Pila clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.push(new NodoPila(cliente));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public NodoListaPila getNext() {
        return next;
    }

    public void setNext(NodoListaPila next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return titulo + "\n"
                + clientes.toString();
    }

}
