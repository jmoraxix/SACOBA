/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.cliente.vista;

import sacoba.vista.VentanaBase;

/**
 *
 * @author ulacit
 */
public class CajaLogin extends VentanaBase {

    /**
     * Creates new form PuertaView
     */
    public CajaLogin() {
        initComponents();
        setSize(VentanaBase.ANCHO, VentanaBase.ALTO);
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
        panelUsuario = new sacoba.vista.PanelConFondo("fondo_panel.png");
        lblTitulo2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        txtUsuario = new sacoba.vista.TransparentTextField();
        txtPasswd = new sacoba.vista.TransparentPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblCaja = new javax.swing.JLabel();
        txtCaja = new sacoba.vista.TransparentTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 650));
        setSize(new java.awt.Dimension(950, 650));

        lblTitulo.setFont(LETRA_TITULO);
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Asistencia de Control Bancario");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);
        lblTitulo.setBounds(10, 0, 880, 50);

        lblTitulo2.setFont(LETRA_TEXTO_1);
        lblTitulo2.setText("Ingreso al sistema");
        panelUsuario.add(lblTitulo2);
        lblTitulo2.setBounds(40, 60, 250, 40);

        lblUsuario.setFont(LETRA_TEXTO_2);
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("Contraseña:");
        panelUsuario.add(lblUsuario);
        lblUsuario.setBounds(30, 150, 180, 30);

        lblUsuario1.setFont(LETRA_TEXTO_2);
        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario1.setText("Usuario:");
        panelUsuario.add(lblUsuario1);
        lblUsuario1.setBounds(30, 110, 180, 30);

        txtUsuario.setToolTipText("Ingrese un usuario");
        txtUsuario.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtUsuario);
        txtUsuario.setBounds(220, 110, 200, 30);

        txtPasswd.setForeground(new java.awt.Color(0, 0, 0));
        txtPasswd.setToolTipText("Ingrese una contraseña");
        txtPasswd.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtPasswd);
        txtPasswd.setBounds(220, 150, 200, 30);

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        panelUsuario.add(btnEntrar);
        btnEntrar.setBounds(320, 230, 100, 30);

        lblCaja.setFont(LETRA_TEXTO_2);
        lblCaja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCaja.setText("Caja #:");
        panelUsuario.add(lblCaja);
        lblCaja.setBounds(30, 190, 180, 30);

        txtCaja.setToolTipText("Ingrese un usuario");
        txtCaja.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtCaja);
        txtCaja.setBounds(220, 190, 40, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (this.txtUsuario.getText().equals("Admin") && String.copyValueOf(this.txtPasswd.getPassword()).equals("123")) {
            new CajaView().setVisible(true);
            this.dispose();
        } else {
            // TODO Mensaje de error
            //JOptionPane
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private sacoba.vista.PanelConFondo panelTitulo;
    private sacoba.vista.PanelConFondo panelUsuario;
    private sacoba.vista.TransparentTextField txtCaja;
    private sacoba.vista.TransparentPasswordField txtPasswd;
    private sacoba.vista.TransparentTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}