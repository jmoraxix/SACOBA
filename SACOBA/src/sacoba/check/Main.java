package com.company;

import java.util.LinkedList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        Cliente cliente = new Cliente();
        cliente.pushPuerta("Puerta 1");
        cliente.pushPuerta("Puerta 2");
        cliente.pushPuerta("Puerta 3");

        cliente.popTopePuerta();

        String tope = cliente.peekTopePuerta();
        System.out.println("tope = " + tope);

        cliente.pushCajero("Cajero 1");
        cliente.pushCajero("Cajero 2");

        cliente.popTopeCajero();

        String topeCajero = cliente.peekTopeCajero();
        System.out.println("topeCajero = " + topeCajero);

        listaClientes.add(cliente);

    }
}
