package com.company;

import java.util.Stack;

public class Cliente {
    private Stack<String> puertas = new Stack<>();
    private Stack<String> monitores = new Stack<>();
    private Stack<String> cajeros = new Stack<>();
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void pushPuerta(String puerta){
        puertas.push(puerta);
    }

    public String peekTopePuerta(){
        return puertas.peek();
    }

    public String popTopePuerta(){
        return puertas.pop();
    }

    public boolean emptyPuerta(){
        return puertas.empty();
    }

    //Cajeros
    public void pushCajero(String cajero){
        cajeros.push(cajero);
    }

    public String peekTopeCajero(){
        return cajeros.peek();
    }

    public String popTopeCajero(){
        return cajeros.pop();
    }

    public boolean emptyCajero(){
        return cajeros.empty();
    }

    //Monitores
    public void pushMonitor(String monitor){
        monitores.push(monitor);
    }

    public String peekTopeMonitor(){
        return monitores.peek();
    }

    public String popTopeMonitor(){
        return monitores.pop();
    }

    public boolean emptyMonitor(){
        return monitores.empty();
    }
}
