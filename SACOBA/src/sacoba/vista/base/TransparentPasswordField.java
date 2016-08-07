package sacoba.vista.base;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPasswordField;

/**
 *
 * @author jmora
 */
public class TransparentPasswordField extends JPasswordField {

    private static final long serialVersionUID = 1959323179223226142L;

    public TransparentPasswordField() {
        super();
        init();
    }

    public TransparentPasswordField(String text) {
        super(text);
        init();
    }

    public TransparentPasswordField(int columns) {
        super(columns);
        init();
    }

    public TransparentPasswordField(String text, int columns) {
        super(text, columns);
        init();
    }

    protected void init() {
        setOpaque(false);
    }

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
