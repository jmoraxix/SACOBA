/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.vista;

import javax.swing.JFrame;
import sacoba.vista.base.PanelConFondo;

/**
 * Define un panel y mantiene la base para los demas paneles
 *
 * @author jmora
 */
public class VentanaBase extends JFrame {

    public static final int ANCHO = 900;
    public static final int ALTO = 450;

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
