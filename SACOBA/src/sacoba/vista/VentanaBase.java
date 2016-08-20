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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Define un panel y mantiene la base para las demas ventanas
 *
 * @author jmora
 */
public class VentanaBase extends JFrame {

    //VARIABLES DE LA APLICACION
    public final static Font LETRA_TITULO = new Font("Andale Mono", Font.BOLD, 24);
    public final static Font LETRA_TEXTO_1 = new Font("Andale Mono", Font.PLAIN, 16);
    public final static Font LETRA_TEXTO_2 = new Font("Andale Mono", Font.PLAIN, 14);
    public final static Font LETRA_TEXTO_3 = new Font("Andale Mono", Font.PLAIN, 12);
    public final static int ANCHO = 950;
    public final static int ALTO = 650;

    //VARIABLES DE LA BARRAR DE MENU
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem m_nosotros;
    private javax.swing.JMenuItem m_salir;
    private javax.swing.JPopupMenu.Separator jSeparator1;

    //STRING SOBRE NOSOTROS
    private static final String SOBRE_NOSOTROS = "Sistema de Asistencia de Control Bancario\n"
            + "SACOBA\n\n"
            + "Marcela Cascante Quiros\n"
            + "Diego Delgado Cerdas\n"
            + "Alejandro Loaiza Arguedas\n"
            + "Jose David Mora Loria\n";

    public VentanaBase() {
        // Declaracion basica de la venta
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ANCHO, ALTO);
        setTitle("SACOBA");
        try {
            InputStream imgStream = VentanaBase.class.getResourceAsStream("imagenes/logo.png");
            BufferedImage myImg = ImageIO.read(imgStream);
            setIconImage(myImg);
        } catch (Exception e) {
            Logger.getLogger(VentanaBase.class.getName()).log(Level.SEVERE, null, e);
        }
        this.setContentPane(new PanelConFondo("fondo_principal.png"));

        //Creacion de la barra de menu
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        m_nosotros = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        m_salir = new javax.swing.JMenuItem();

        jMenu1.setText("SACOBA");

        m_nosotros.setText("Sobre nosotros");
        m_nosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null,
                        SOBRE_NOSOTROS,
                        "Sobre nosotros",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        jMenu1.add(m_nosotros);
        jMenu1.add(jSeparator1);

        m_salir.setText("Salir");
        m_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        jMenu1.add(m_salir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
    }

    /**
     * Recibe un TextField y le asigna un eveno que evita que se le agreguen
     * caracteres numericos
     *
     * @param TextField Caja de texto a modificar
     */
    public static void soloLetras(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    /**
     * Recibe un TextField y le asigna un eveno que evita que se le agreguen
     * caracteres que no sean numericos
     *
     * @param TextField Caja de texto a modificar
     */
    public static void soloNumeros(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

}
