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

import javax.swing.JOptionPane;
import sacoba.vista.VentanaBase;

/**
 *
 * @author jmora
 */
public class ClienteTCP extends VentanaBase {

    /**
     * Crea el menu principal para seleccionar un nuevo cliente
     */
    public ClienteTCP() {
        initComponents();

        //Pide la IP del servidor y no se cierra el dialog a menos que ingrese un valor válido
        if (Cliente.getSERVER_IP() == null) {
            String ip = JOptionPane.showInputDialog(this, "Digita la IP del servidor", "IP requerida", JOptionPane.WARNING_MESSAGE);
            Cliente.setSERVER_IP(ip==null?"localhost":ip);
        }
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
        lblTitulo1 = new javax.swing.JLabel();
        panelContenido = new sacoba.vista.PanelConFondo("fondo_panel.png");
        lblTitulo2 = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();
        lblPuerta = new javax.swing.JLabel();
        lblMonitor = new javax.swing.JLabel();
        btnCajero = new sacoba.vista.PanelConFondo("cajero.png");
        btnPuerta = new sacoba.vista.PanelConFondo("puerta.png");
        btnMonitor = new sacoba.vista.PanelConFondo("monitor.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo1.setFont(LETRA_TITULO);
        lblTitulo1.setText("Sistema de Asistencia de Control Bancario");
        panelTitulo.add(lblTitulo1);
        lblTitulo1.setBounds(40, 10, 710, 30);

        lblTitulo2.setFont(LETRA_TEXTO_1);
        lblTitulo2.setText("Seleccione el tipo de cliente:");
        panelContenido.add(lblTitulo2);
        lblTitulo2.setBounds(40, 40, 480, 30);

        lblCajero.setFont(LETRA_TEXTO_2);
        lblCajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCajero.setText("Cajero");
        panelContenido.add(lblCajero);
        lblCajero.setBounds(600, 270, 150, 30);

        lblPuerta.setFont(LETRA_TEXTO_2);
        lblPuerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuerta.setText("Puerta");
        panelContenido.add(lblPuerta);
        lblPuerta.setBounds(120, 270, 150, 30);

        lblMonitor.setFont(LETRA_TEXTO_2);
        lblMonitor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonitor.setText("Monitor");
        panelContenido.add(lblMonitor);
        lblMonitor.setBounds(360, 270, 150, 30);

        btnCajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCajeroMouseClicked(evt);
            }
        });
        panelContenido.add(btnCajero);
        btnCajero.setBounds(590, 100, 170, 170);

        btnPuerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPuertaMouseClicked(evt);
            }
        });
        panelContenido.add(btnPuerta);
        btnPuerta.setBounds(120, 100, 150, 170);

        btnMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMonitorMouseClicked(evt);
            }
        });
        panelContenido.add(btnMonitor);
        btnMonitor.setBounds(350, 100, 170, 170);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPuertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPuertaMouseClicked
        this.dispose();
        PuertaView puerta = new PuertaView();
        puerta.setVisible(true);
    }//GEN-LAST:event_btnPuertaMouseClicked

    private void btnMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMonitorMouseClicked
        this.dispose();
        new MonitorView().setVisible(true);
    }//GEN-LAST:event_btnMonitorMouseClicked

    private void btnCajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajeroMouseClicked
        this.dispose();
        new CajaLogin().setVisible(true);
    }//GEN-LAST:event_btnCajeroMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteTCP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sacoba.vista.PanelConFondo btnCajero;
    private sacoba.vista.PanelConFondo btnMonitor;
    private sacoba.vista.PanelConFondo btnPuerta;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblMonitor;
    private javax.swing.JLabel lblPuerta;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private sacoba.vista.PanelConFondo panelContenido;
    private sacoba.vista.PanelConFondo panelTitulo;
    // End of variables declaration//GEN-END:variables
}
