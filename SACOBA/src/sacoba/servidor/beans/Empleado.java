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

    /**
     *
     * @param usuario
     * @param cedula
     * @param nombre
     * @param apellido1
     */
    public Empleado(String usuario, String cedula, String nombre, String apellido1) {
        super(cedula, nombre, apellido1);
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @param passwd
     * @return
     */
    public boolean checkPasswd(String passwd) {
        return this.passwd.equals(passwd);
    }

    /**
     *
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     *
     * @return
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     *
     * @param departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     *
     * @return
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     *
     * @param puesto
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
