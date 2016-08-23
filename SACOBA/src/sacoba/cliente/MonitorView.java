/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.servidor.ClienteServidor;
import sacoba.servidor.beans.Notificacion;
import sacoba.vista.TransparentTextArea;
import sacoba.vista.VentanaBase;

/**
 *
 * @author ulacit
 */
public class MonitorView extends VentanaBase {

    Monitor monitor;
    
    /**
     * Crea un nuevo cliente Monitor
     */
    public MonitorView() {
        super();
        initComponents();
        
        monitor = new Monitor(this);
        monitor.start();
    }
    
    //Getters and setters
    public void addSiguiente(String siguiente) {
        this.txtSigue.setText(siguiente + "\n" + txtSigue.getText());
    }
    
    public void setTxtCuentas(String lblCuentas) {
        this.lblCuentas.setText(lblCuentas);
    }

    public void setTxtPlataforma(String lblPlataforma) {
        this.lblPlataforma.setText(lblPlataforma);
    }

    public void setTxtTramites(String lblTramites) {
        this.lblTramites.setText(lblTramites);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new sacoba.vista.PanelConFondo("fondo_panel.png");
        lblTitulo = new javax.swing.JLabel();
        panelClientes = new sacoba.vista.PanelConFondo("fondo_panel.png");
        lblTituloCuentas = new javax.swing.JLabel();
        lblTituloPlataforma = new javax.swing.JLabel();
        lblTituloTramites = new javax.swing.JLabel();
        lblCuentas = new javax.swing.JLabel();
        lblPlataforma = new javax.swing.JLabel();
        lblTramites = new javax.swing.JLabel();
        img_cuentas = new sacoba.vista.PanelConFondo("account-balance-blanco.png");
        img_tramites = new sacoba.vista.PanelConFondo("tramite_blanco.png");
        img_plataforma = new sacoba.vista.PanelConFondo("group_blanco.png");
        panelContenido = new sacoba.vista.PanelConFondo("fondo_panel.png");
        lblTitulo2 = new javax.swing.JLabel();
        panelScrollContenido = new javax.swing.JScrollPane();
        txtSigue = new sacoba.vista.TransparentTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 650));
        setSize(new java.awt.Dimension(950, 650));

        lblTitulo.setFont(LETRA_TITULO);
        lblTitulo.setText("¡Bienvenido! Pronto le atenderemos");
        panelTitulo.add(lblTitulo);
        lblTitulo.setBounds(30, 0, 860, 50);

        panelClientes.setEnabled(false);

        lblTituloCuentas.setFont(LETRA_TEXTO_2);
        lblTituloCuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloCuentas.setText("Cuentas:");
        lblTituloCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelClientes.add(lblTituloCuentas);
        lblTituloCuentas.setBounds(130, 300, 100, 40);

        lblTituloPlataforma.setFont(LETRA_TEXTO_2);
        lblTituloPlataforma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloPlataforma.setText("Plataforma:");
        lblTituloPlataforma.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelClientes.add(lblTituloPlataforma);
        lblTituloPlataforma.setBounds(130, 70, 100, 40);

        lblTituloTramites.setFont(LETRA_TEXTO_2);
        lblTituloTramites.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloTramites.setText("Trámites:");
        lblTituloTramites.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelClientes.add(lblTituloTramites);
        lblTituloTramites.setBounds(130, 180, 100, 40);

        lblCuentas.setFont(LETRA_TEXTO_1);
        lblCuentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuentas.setText("0");
        lblCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelClientes.add(lblCuentas);
        lblCuentas.setBounds(200, 300, 60, 40);

        lblPlataforma.setFont(LETRA_TEXTO_1);
        lblPlataforma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlataforma.setText("0");
        lblPlataforma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelClientes.add(lblPlataforma);
        lblPlataforma.setBounds(200, 70, 60, 40);

        lblTramites.setFont(LETRA_TEXTO_1);
        lblTramites.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTramites.setText("0");
        lblTramites.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelClientes.add(lblTramites);
        lblTramites.setBounds(200, 180, 60, 40);
        panelClientes.add(img_cuentas);
        img_cuentas.setBounds(50, 290, 70, 70);
        panelClientes.add(img_tramites);
        img_tramites.setBounds(50, 170, 70, 70);
        panelClientes.add(img_plataforma);
        img_plataforma.setBounds(50, 60, 70, 70);

        lblTitulo2.setFont(LETRA_TEXTO_1);
        lblTitulo2.setText("En este momento estamos atendiendo:");
        panelContenido.add(lblTitulo2);
        lblTitulo2.setBounds(40, 50, 450, 40);

        txtSigue.setEditable(false);
        txtSigue.setColumns(20);
        txtSigue.setRows(10);
        txtSigue.setFont(LETRA_TEXTO_3);
        panelScrollContenido.setViewportView(txtSigue);

        panelContenido.add(panelScrollContenido);
        panelScrollContenido.setBounds(40, 100, 450, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sacoba.vista.PanelConFondo img_cuentas;
    private sacoba.vista.PanelConFondo img_plataforma;
    private sacoba.vista.PanelConFondo img_tramites;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblPlataforma;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTituloCuentas;
    private javax.swing.JLabel lblTituloPlataforma;
    private javax.swing.JLabel lblTituloTramites;
    private javax.swing.JLabel lblTramites;
    private sacoba.vista.PanelConFondo panelClientes;
    private sacoba.vista.PanelConFondo panelContenido;
    private javax.swing.JScrollPane panelScrollContenido;
    private sacoba.vista.PanelConFondo panelTitulo;
    private sacoba.vista.TransparentTextArea txtSigue;
    // End of variables declaration//GEN-END:variables
}
