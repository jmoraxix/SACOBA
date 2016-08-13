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

/**
 *
 * @author Marce
 */
public class Empleado extends Persona {

    private String usuario, passwd, departamento, puesto;

    public Empleado(String usuario, int cedula, String nombre, String apellido1) {
        super(cedula, nombre, apellido1);
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean checkPasswd(String passwd) {
        return this.passwd.equals(passwd);
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
