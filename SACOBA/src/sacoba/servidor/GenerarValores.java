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

        personas.add(new Persona("123456789", "Usuario", "Uno"));
        personas.add(new Persona("987654321", "Karla", "Vargas"));
        personas.add(new Persona("123412341", "Jose", "Hernández "));
        personas.add(new Persona("234523452", "Gerardo", "Castro"));
        personas.add(new Persona("345634563", "Jose", "Castro"));
        personas.add(new Persona("456745674", "María", "Sánchez"));
        personas.add(new Persona("567856785", "Víctor", "Jiménez"));
        personas.add(new Persona("678967896", "Manuel", "Hernández "));
    }

    private void generarEmpleados() {
        ArrayList<Empleado> empleados = servidor.getEmpleados();

        empleados.add(new Empleado("jmora", "625245656", "Jose", "Mora"));
        empleados.add(new Empleado("user", "626326234", "Karla", "Vargas"));
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
