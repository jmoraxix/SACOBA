package sacoba.vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;
import sacoba.SACOBA;

/**
 *
 * @author jmora Extiende JPanel. Define un panel y le asigna un fondo
 */
public class PanelConFondo extends JPanel {

    /**
     * Define un JPanel normal. Puede cambiarse el fondo usando su respectivo
     * setter.
     */
    public PanelConFondo() {
        setForeground(SystemColor.controlHighlight);
        setLayout(null);
    }

    /**
     * Crea JPanel y le defina una imagen de fondo.
     *
     * @param urlImagen Nombre de la imagen de fondo.
     */
    public PanelConFondo(String urlImagen) {
        this();
        definirBorde(urlImagen);
    }

    private void definirBorde(String url) {
        try {
            URL imagen = SACOBA.class.getResource("vista/imagenes/" + url);
            BufferedImage img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder(img);
            this.setBorder(borde);
        } catch (IOException ioe) {
            Logger.getLogger(PanelConFondo.class.getName()).log(Level.SEVERE, null, ioe);
        } catch (Exception e) {
            Logger.getLogger(PanelConFondo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

/**
 * @author jmora 17/11/2012 Clase para generar un borde para el panel y
 * asignarselo como fondo.
 */
class BgBorder implements Border {

    private BufferedImage mImagen = null;

    public BgBorder(BufferedImage pImagen) {
        mImagen = pImagen;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width,
            int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}
