package sacoba.vista;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 * Crea un ComboBox con transparencia
 *
 * @author jmora
 * @param <Object>
 */
public class TransparentComboBox<Object> extends JComboBox<Object> {

    //Constructores de la clase
    public TransparentComboBox(ComboBoxModel<Object> aModel) {
        super(aModel);
    }

    public TransparentComboBox(Object[] items) {
        super(items);
    }

    public TransparentComboBox(Vector<Object> items) {
        super(items);
    }

    public TransparentComboBox() {
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
