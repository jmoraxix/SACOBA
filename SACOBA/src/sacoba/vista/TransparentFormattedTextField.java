package sacoba.vista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Crea un FormattedTextField con transparencia
 *
 * @author jmora
 */
public class TransparentFormattedTextField extends JFormattedTextField {

    // Constructores
    public TransparentFormattedTextField() {
        super();
        init();
    }

    public TransparentFormattedTextField(String text) {
        super(text);
        init();
    }

    public TransparentFormattedTextField(int columns) {
        super(columns);
        init();
    }

    public TransparentFormattedTextField(MaskFormatter maskFormatter) {
        super();
        maskFormatter.setPlaceholderCharacter('_');
        setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
    }

    protected void init() {
        setOpaque(false);
        setForeground(Color.black);
    }

    /**
     * Recibe una mascara y la asigna como formato de la caja de texto
     *
     * @param maskFormatter Formato a asignar
     */
    public void setMask(MaskFormatter maskFormatter) {
        maskFormatter.setPlaceholderCharacter('_');
        setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
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
