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

/**
 *
 * @author jmora
 */
public class GenerarValores {

    Servidor servidor;

    /**
     *
     * @param servidor
     */
    public GenerarValores(Servidor servidor) {
        this.servidor = servidor;
        generarPersonas();
        generarEmpleados();
    }

    private void generarPersonas() {
        ArrayList<Persona> personas = servidor.getPersonas();

        personas.add(new Persona("123456789", "Usuario", "Uno"));
        personas.add(new Persona("626326234", "Karla", "Vargas"));
        personas.add(new Persona("987654322", "Jose", "Hernández "));
        personas.add(new Persona("123457654", "Gerardo", "Castro"));
        personas.add(new Persona("123656754", "Jose", "Mora"));
        personas.add(new Persona("162544565", "María", "Sánchez"));
        personas.add(new Persona("117827737", "Víctor", "Jiménez"));
        personas.add(new Persona("654373537", "Manuel", "Hernández "));

    }

    private void generarEmpleados() {
        ArrayList<Empleado> empleados = servidor.getEmpleados();

//        empleados.add(new Empleado("jmora", "123456789", "Usuario", "Uno"));
//        empleados.add(new Empleado("user", "626326234", "Karla", "Vargas"));
//        empleados.add(new Empleado("", "987654322", "Jose", "Hernández "));
    }

}
