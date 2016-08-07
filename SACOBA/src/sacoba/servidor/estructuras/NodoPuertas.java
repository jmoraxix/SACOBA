/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.servidor.estructuras;

/**
 *
 * @author alejandro
 */
class NodoPuertas {
    private int cliente;
    private NodoPuertas referencia;

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cleinte) {
        this.cliente = cleinte;
    }

    public NodoPuertas getAbajo() {
        return referencia;
    }

    public void setAbajo(NodoPuertas abajo) {
        this.referencia = abajo;
    }

    public NodoPuertas(int cliente, NodoPuertas abajo) {
        this.cliente = cliente;
        this.referencia = abajo;
    }

    @Override
    public String toString() {
        return "NodoPuertas{" + "Cliente=" + cliente + ", Referencia=" + referencia + '}';
    }
    
}
