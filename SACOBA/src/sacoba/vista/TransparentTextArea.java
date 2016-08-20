package sacoba.vista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextArea;

/**
 * Crea un TextArea con transparencia
 *
 * @author jmora
 */
public class TransparentTextArea extends JTextArea {

    // Constructores
    public TransparentTextArea() {
        super();
        init();
    }

    public TransparentTextArea(String text) {
        super(text);
        init();
    }

    protected void init() {
        setOpaque(false);
        setForeground(Color.black);
    }

    //Metodos graficos para crear una transparencia en el objeto
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        super.paint(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g2d);
        g2d.dispose();
    }

}
