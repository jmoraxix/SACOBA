/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacoba.vista.base;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Extiende PanelConFondo. Crea un boton con una imagen y un titulo
 *
 * @author jmora
 */
public class TransparentButton extends PanelConFondo {

    private JButton btn;

    /**
     * Crea un panel con un boton invisible y una imagen de fondo.
     *
     * @param urlImagen Nombre de la imagen de fondo.
     * @param titulo Título del botón.
     */
    public TransparentButton(String urlImagen, String titulo) {
        super(urlImagen);
        setOpaque(false);
        setLayout(new BorderLayout(0, 0));

        this.btn = new JButton();
        this.btn.setOpaque(false);
        this.btn.setContentAreaFilled(false);
        this.btn.setBorderPainted(false);
        add(this.btn, BorderLayout.CENTER);
        add(new JLabel(titulo), BorderLayout.SOUTH);
    }

    /**
     * Retorna el botón invisible del panel. Puede ser utilizado para asignarle
     * un evento del tipo click.
     *
     * @return
     */
    public JButton getBtn() {
        return this.btn;
    }
}
