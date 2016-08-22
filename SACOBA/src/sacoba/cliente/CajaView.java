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

/**
 *
 * @author ulacit
 */
public class CajaView extends Cliente {

    private String numCaja;

    /**
     * Crea un nuevo cliente Puerta
     *
     * @param numCaja Numero de caja en la que el empleado esta iniciando el
     * cliente
     */
    public CajaView(String numCaja) {
        super();
        this.numCaja = numCaja;
        initComponents();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Recibe un dato de entrada
                String entrada = in.readUTF();
                System.out.println(entrada);
                String[] datos = entrada.split(";"); // Divide los datos de la entrada en cada ';'

                switch (Notificacion.convertirValor(Integer.parseInt(datos[0]))) {
                    case CLIENTE_A_CAJA:
                        clienteACaja(datos);
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Metodos de TCP
    /*
        Envia una notificacion al servidor de que la caja esta vacia
     */
    private void liberarCaja() {
        try {
            out.writeUTF(Notificacion.LIBERAR_CAJA.getValor() + ";" + numCaja);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        Recibe la secuenca generada para el usuario por el servidor y la muestra en pantalla
     */
    private void clienteACaja(String[] datos) {
        this.txtSecuencia.setText(datos[1]);
        this.txtNombreUsuario.setText(datos[2]);
        this.txtTramite.setText(datos[3]);
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
        lblUsuario1 = new javax.swing.JLabel();
        txtNombreUsuario = new sacoba.vista.TransparentTextField();
        btnVolver = new sacoba.vista.PanelConFondo("flecha-volver.png");
        lblVolver = new javax.swing.JLabel();
        lblAbrirChat = new javax.swing.JLabel();
        txtSecuencia = new sacoba.vista.TransparentTextField();
        lblUsuario3 = new javax.swing.JLabel();
        txtTramite = new sacoba.vista.TransparentTextField();
        btnLiberar = new sacoba.vista.PanelConFondo("avanzar.png");
        lblLiberar = new javax.swing.JLabel();
        btnAbrirChat = new sacoba.vista.PanelConFondo("chat.png");
        lblUsuario4 = new javax.swing.JLabel();

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
        lblTitulo2.setText("Próximo cliente:");
        panelUsuario.add(lblTitulo2);
        lblTitulo2.setBounds(90, 90, 250, 40);

        lblUsuario1.setFont(LETRA_TEXTO_2);
        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario1.setText("Nombre:");
        panelUsuario.add(lblUsuario1);
        lblUsuario1.setBounds(100, 180, 150, 30);

        txtNombreUsuario.setEditable(false);
        txtNombreUsuario.setToolTipText("Ingrese un usuario");
        txtNombreUsuario.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtNombreUsuario);
        txtNombreUsuario.setBounds(260, 180, 240, 30);

        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        panelUsuario.add(btnVolver);
        btnVolver.setBounds(40, 40, 50, 50);

        lblVolver.setFont(LETRA_TEXTO_3);
        lblVolver.setText("Volver");
        panelUsuario.add(lblVolver);
        lblVolver.setBounds(100, 50, 160, 30);

        lblAbrirChat.setFont(LETRA_TEXTO_2);
        lblAbrirChat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAbrirChat.setText("Abrir chat corporativo");
        panelUsuario.add(lblAbrirChat);
        lblAbrirChat.setBounds(560, 50, 220, 30);

        txtSecuencia.setEditable(false);
        txtSecuencia.setToolTipText("Ingrese un usuario");
        txtSecuencia.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtSecuencia);
        txtSecuencia.setBounds(260, 140, 110, 30);

        lblUsuario3.setFont(LETRA_TEXTO_2);
        lblUsuario3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario3.setText("Trámite:");
        panelUsuario.add(lblUsuario3);
        lblUsuario3.setBounds(100, 220, 150, 30);

        txtTramite.setEditable(false);
        txtTramite.setToolTipText("Ingrese un usuario");
        txtTramite.setFont(LETRA_TEXTO_2);
        panelUsuario.add(txtTramite);
        txtTramite.setBounds(260, 220, 240, 30);

        btnLiberar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLiberarMouseClicked(evt);
            }
        });
        panelUsuario.add(btnLiberar);
        btnLiberar.setBounds(720, 240, 70, 60);

        lblLiberar.setFont(LETRA_TEXTO_3);
        lblLiberar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLiberar.setText("Liberar caja");
        panelUsuario.add(lblLiberar);
        lblLiberar.setBounds(680, 300, 150, 30);

        btnAbrirChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirChatMouseClicked(evt);
            }
        });
        panelUsuario.add(btnAbrirChat);
        btnAbrirChat.setBounds(790, 30, 70, 60);

        lblUsuario4.setFont(LETRA_TEXTO_2);
        lblUsuario4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario4.setText("Secuencia:");
        panelUsuario.add(lblUsuario4);
        lblUsuario4.setBounds(100, 140, 150, 30);

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

    private void btnLiberarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLiberarMouseClicked
        liberarCaja();
    }//GEN-LAST:event_btnLiberarMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        new CajaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnAbrirChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirChatMouseClicked
        try {
            System.out.println("hola");
            Runtime.getRuntime().exec("java -jar lib/SACOBA_Chat_Client.jar " + Cliente.getSERVER_IP());
        } catch (IOException ex) {
            Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAbrirChatMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sacoba.vista.PanelConFondo btnAbrirChat;
    private sacoba.vista.PanelConFondo btnLiberar;
    private sacoba.vista.PanelConFondo btnVolver;
    private javax.swing.JLabel lblAbrirChat;
    private javax.swing.JLabel lblLiberar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblVolver;
    private sacoba.vista.PanelConFondo panelTitulo;
    private sacoba.vista.PanelConFondo panelUsuario;
    private sacoba.vista.TransparentTextField txtNombreUsuario;
    private sacoba.vista.TransparentTextField txtSecuencia;
    private sacoba.vista.TransparentTextField txtTramite;
    // End of variables declaration//GEN-END:variables
}
