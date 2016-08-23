/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor;

import java.util.ArrayList;
import sacoba.servidor.beans.Empleado;
import sacoba.servidor.beans.Persona;
import sacoba.servidor.estructuras.Arbol;

/**
 *
 * @author jmora
 */
public class GenerarValores {

    Servidor servidor;

    /**
     * Genera los valores para modificar los datos actuales en el servidor
     *
     * @param servidor
     */
    public GenerarValores(Servidor servidor) {
        this.servidor = servidor;
        generarPersonas();
        generarEmpleados();
        generarArbol();
    }

    private void generarPersonas() {
        ArrayList<Persona> personas = servidor.getPersonas();

        personas.add(new Persona("1-2345-6789", "Usuario", "Uno"));
        personas.add(new Persona("9-8765-4321", "Karla", "Vargas"));
        personas.add(new Persona("1-2341-2341", "Jose", "Hernández "));
        personas.add(new Persona("2-3452-3452", "Gerardo", "Castro"));
        personas.add(new Persona("3-4563-4563", "Jose", "Castro"));
        personas.add(new Persona("4-5674-5674", "María", "Sánchez"));
        personas.add(new Persona("5-6785-6785", "Víctor", "Jiménez"));
        personas.add(new Persona("6-7896-7896", "Manuel", "Hernández "));
    }

    private void generarEmpleados() {
        ArrayList<Empleado> empleados = servidor.getEmpleados();

        empleados.add(new Empleado("jmora", "6-2524-5656", "Jose", "Mora"));
        empleados.add(new Empleado("user", "6-2632-6234", "Karla", "Vargas"));
    }

    private void generarArbol() {
        Arbol arbol = servidor.getArbol();
        arbol.insertarHoja("", "BO", "Banco");

        arbol.insertarHoja("BO", "P0", "Plataforma");
        arbol.insertarHoja("BO", "T0", "Tramites");
        arbol.insertarHoja("BO", "C0", "Cuentas");

        arbol.insertarHoja("P0", "P1", "Depositar");
        arbol.insertarHoja("P0", "P2", "Cambio de moneda");
        arbol.insertarHoja("P0", "P3", "Pago servicios");
        arbol.insertarHoja("P0", "P4", "Transferencia");

        arbol.insertarHoja("T0", "T1", "Prestamos");
        arbol.insertarHoja("T0", "T2", "Tarjetas");

        arbol.insertarHoja("C0", "C1", "Cuentas");
        arbol.insertarHoja("C0", "C2", "Otro");
    }

}
