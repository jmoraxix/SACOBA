/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor.beans;

import java.util.Date;

/**
 *
 * @author Marce
 */
public class Persona {

    //Variables
    private String nombre, apellido1, apellido2, email, cedula, telefono;
    private Direccion direccion;
    private Date nacimiento;

    /**
     * Constructor de la clase con los parametros basicos
     *
     * @param cedula Cedula de la persona
     * @param nombre Nombre de la persona
     * @param apellido1 Primer apellido de la persona
     */
    public Persona(String cedula, String nombre, String apellido1) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
    }

    /**
     * Constructor de la clase con todos los parametros
     *
     * @param cedula Cedula de la persona
     * @param nombre Nombre de la persona
     * @param apellido1 Primer apellido de la persona
     * @param apellido2 Segundo apellido de la persona
     * @param email Correo electronico de la persona
     * @param telefono Telefono de la persona
     * @param direccion Direccion de la persona
     * @param nacimiento Fecha de nacimiento de la persona
     */
    public Persona(String cedula, String nombre, String apellido1, String apellido2, String email, String telefono, Direccion direccion, Date nacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
    }

    //Getters and setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

}
