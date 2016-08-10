/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.vista;

import javax.swing.JFrame;

/**
 * Define un panel y mantiene la base para los demas paneles
 *
 * @author jmora
 */
public class VentanaBase extends JFrame {

    public static final int ANCHO = 950;
    public static final int ALTO = 650;

    public VentanaBase() {
        // Declaracion b�sica de la venta
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ANCHO, ALTO);
        setTitle("SACOBA");
//        try {
//            Image icon = Toolkit.getDefaultToolkit().getImage(HotelLounge.class.getResource("vista/imagenes/logo_principal.png"));
//            setIconImage(icon);
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, null, e);
//        }
        this.setContentPane(new PanelConFondo("fondo_principal.png"));
    }

}
