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

import java.awt.Font;
import javax.swing.JFrame;

/**
 * Define un panel y mantiene la base para las demas ventanas
 *
 * @author jmora
 */
public class VentanaBase extends JFrame {

    public final static Font LETRA_TITULO = new Font("Andale Mono", Font.BOLD, 24);
    public final static Font LETRA_TEXTO_1 = new Font("Andale Mono", Font.PLAIN, 16);
    public final static Font LETRA_TEXTO_2 = new Font("Andale Mono", Font.PLAIN, 14);
    public final static Font LETRA_TEXTO_3 = new Font("Andale Mono", Font.PLAIN, 12);
    public final static int ANCHO = 950;
    public final static int ALTO = 650;

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
