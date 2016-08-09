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
public class Direccion {
    private String provincia, canton, distrito, exacta;

    public Direccion(String provincia, String canton, String distrito, String exacta) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.exacta = exacta;
    }    

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getExacta() {
        return exacta;
    }

    public void setExacta(String exacta) {
        this.exacta = exacta;
    }
    
    @Override
    public String toString() {
        return provincia + ", " + canton + ", " + distrito + ". " + exacta;
    }
}
