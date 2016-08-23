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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import sacoba.servidor.ClienteServidor;
import sacoba.servidor.beans.Notificacion;

/**
 *
 * @author ulacit
 */
public class PuertaView extends Cliente {

    ButtonGroup options;

    /**
     * Creates new form PuertaView
     */
    public PuertaView() {
        super();
        initComponents();

        try {
            MaskFormatter mascara_cedula = new MaskFormatter("#-####-####");
            txtCedula.setMask(mascara_cedula);
        } catch (ParseException ex) {
            Logger.getLogger(PuertaView.class.getName()).log(Level.SEVERE, null, ex);
        }

        options = new ButtonGroup();
        options.add(jbop2);
        options.add(jbop1);
        options.add(jbop3);
        options.add(jbop4);
        options.add(jbop5);
        options.add(jbop6);
        options.add(jbop7);
        options.add(jbop8);
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
                    case NOTIFICA_SECUENCIA:
                        notificaSecuencia(datos);
                        break;
                    case ACTUALIZA_PLATAFORMA:
                        actualizaPlataforma(datos);
                        break;
                    case ACTUALIZA_TRAMITES:
                        actualizaTramites(datos);
                        break;
                    case ACTUALIZA_CUENTAS:
                        actualizaCuentas(datos);
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
    private void entraUsuario() {
        String codigo = getCodeFromButton();
        if (codigo != null) {
            if (!this.txtCedula.getText().equals("")) {
                try {
                    System.out.println("Envia datos");
                    out.writeUTF(Notificacion.ENTRA_USUARIO.getValor() + ";" + codigo + ";" + this.txtCedula.getText());
                    out.flush();
                } catch (IOException ex) {
                    Logger.getLogger(CajaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Por favor seleccione una opción antes de continuar.",
                        "No se puede continuar",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione una opción antes de continuar. Si no conoce la opción deseada selecione la opción \"Otro\".",
                    "No se puede continuar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
        Recibe la secuenca del usuario y la muestra en pantalla
     */
    private void notificaSecuencia(String[] datos) {
        System.out.println("Secuencia recibida: " + datos[1]);
        JOptionPane.showMessageDialog(this,
                "Su número de secuencia es: " + datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Plataforma
     */
    private void actualizaPlataforma(String[] datos) {
        this.lblPlataforma.setText(datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Tramites
     */
    private void actualizaTramites(String[] datos) {
        this.lblTramites.setText(datos[1]);
    }

    /*
        Recibe el nuevo numero de usuarios en la cola de Cuentas
     */
    private void actualizaCuentas(String[] datos) {
        this.lblCuentas.setText(datos[1]);
    }

    //Otros metodos
    private String getCodeFromButton() {
        String codigo = null;

        if (jbop1.isSelected()) {
            codigo = "P1";
        } else if (jbop2.isSelected()) {
            codigo = "P2";
        } else if (jbop3.isSelected()) {
            codigo = "P3";
        } else if (jbop4.isSelected()) {
            codigo = "P4";
        } else if (jbop5.isSelected()) {
            codigo = "T1";
        } else if (jbop6.isSelected()) {
            codigo = "T2";
        } else if (jbop7.isSelected()) {
            codigo = "C1";
        } else if (jbop8.isSelected()) {
            codigo = "C2";
        }

        return codigo;
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
        lblOpcion = new javax.swing.JLabel();
        txtCedula = new sacoba.vista.TransparentFormattedTextField();
        lblCedula = new javax.swing.JLabel();
        panelUsuarioIzq = new sacoba.vista.PanelConFondo("fondo_panel.png");
        jbop1 = new javax.swing.JRadioButton();
        jbop2 = new javax.swing.JRadioButton();
        jbop3 = new javax.swing.JRadioButton();
        jbop4 = new javax.swing.JRadioButton();
        panelUsuarioDer1 = new sacoba.vista.PanelConFondo("fondo_panel.png");
        jbop5 = new javax.swing.JRadioButton();
        jbop6 = new javax.swing.JRadioButton();
        panelUsuarioDer2 = new sacoba.vista.PanelConFondo("fondo_panel.png");
        jbop7 = new javax.swing.JRadioButton();
        jbop8 = new javax.swing.JRadioButton();
        lblContinuar = new javax.swing.JLabel();
        btnContinuar = new sacoba.vista.PanelConFondo("flecha.png");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 650));
        setSize(new java.awt.Dimension(950, 650));

        lblTitulo.setFont(LETRA_TITULO);
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Bienvenido");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);
        lblTitulo.setBounds(10, 0, 530, 50);

        lblOpcion.setFont(LETRA_TEXTO_1);
        lblOpcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOpcion.setText("Seleccione una opción:");
        lblOpcion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelUsuario.add(lblOpcion);
        lblOpcion.setBounds(40, 90, 270, 30);

        txtCedula.setToolTipText("Ingrese su cédula");
        txtCedula.setFont(LETRA_TEXTO_3);
        panelUsuario.add(txtCedula);
        txtCedula.setBounds(240, 50, 190, 30);

        lblCedula.setFont(LETRA_TEXTO_2);
        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCedula.setText("Digite su cédula:");
        lblCedula.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelUsuario.add(lblCedula);
        lblCedula.setBounds(80, 50, 150, 30);

        jbop1.setFont(LETRA_TEXTO_3);
        jbop1.setText("Depositar a cuenta");
        jbop1.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioIzq.add(jbop1);
        jbop1.setBounds(20, 20, 190, 30);

        jbop2.setFont(LETRA_TEXTO_3);
        jbop2.setText("Cambio de moneda");
        jbop2.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioIzq.add(jbop2);
        jbop2.setBounds(20, 50, 190, 30);

        jbop3.setFont(LETRA_TEXTO_3);
        jbop3.setText("Pagar servicio");
        jbop3.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioIzq.add(jbop3);
        jbop3.setBounds(20, 80, 190, 30);

        jbop4.setFont(LETRA_TEXTO_3);
        jbop4.setText("Transferencia");
        jbop4.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioIzq.add(jbop4);
        jbop4.setBounds(20, 110, 190, 30);

        panelUsuario.add(panelUsuarioIzq);
        panelUsuarioIzq.setBounds(40, 130, 230, 160);

        jbop5.setFont(LETRA_TEXTO_3);
        jbop5.setText("Préstamos");
        jbop5.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioDer1.add(jbop5);
        jbop5.setBounds(20, 0, 190, 30);

        jbop6.setFont(LETRA_TEXTO_3);
        jbop6.setText("Tarjetas");
        jbop6.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioDer1.add(jbop6);
        jbop6.setBounds(20, 30, 190, 30);

        panelUsuario.add(panelUsuarioDer1);
        panelUsuarioDer1.setBounds(280, 140, 230, 60);

        jbop7.setFont(LETRA_TEXTO_3);
        jbop7.setText("Cuentas");
        jbop7.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioDer2.add(jbop7);
        jbop7.setBounds(20, 0, 190, 30);

        jbop8.setFont(LETRA_TEXTO_3);
        jbop8.setText("Otro");
        jbop8.setToolTipText("Seleccione el proceso deseado");
        panelUsuarioDer2.add(jbop8);
        jbop8.setBounds(20, 30, 190, 30);

        panelUsuario.add(panelUsuarioDer2);
        panelUsuarioDer2.setBounds(280, 220, 230, 60);

        lblContinuar.setFont(LETRA_TEXTO_2);
        lblContinuar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContinuar.setText("Continuar");
        lblContinuar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelUsuario.add(lblContinuar);
        lblContinuar.setBounds(260, 290, 150, 50);

        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinuarMouseClicked(evt);
            }
        });
        panelUsuario.add(btnContinuar);
        btnContinuar.setBounds(420, 290, 80, 50);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
        entraUsuario();
    }//GEN-LAST:event_btnContinuarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sacoba.vista.PanelConFondo btnContinuar;
    private sacoba.vista.PanelConFondo img_cuentas;
    private sacoba.vista.PanelConFondo img_plataforma;
    private sacoba.vista.PanelConFondo img_tramites;
    private javax.swing.JRadioButton jbop1;
    private javax.swing.JRadioButton jbop2;
    private javax.swing.JRadioButton jbop3;
    private javax.swing.JRadioButton jbop4;
    private javax.swing.JRadioButton jbop5;
    private javax.swing.JRadioButton jbop6;
    private javax.swing.JRadioButton jbop7;
    private javax.swing.JRadioButton jbop8;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContinuar;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblOpcion;
    private javax.swing.JLabel lblPlataforma;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloCuentas;
    private javax.swing.JLabel lblTituloPlataforma;
    private javax.swing.JLabel lblTituloTramites;
    private javax.swing.JLabel lblTramites;
    private sacoba.vista.PanelConFondo panelClientes;
    private sacoba.vista.PanelConFondo panelTitulo;
    private sacoba.vista.PanelConFondo panelUsuario;
    private sacoba.vista.PanelConFondo panelUsuarioDer1;
    private sacoba.vista.PanelConFondo panelUsuarioDer2;
    private sacoba.vista.PanelConFondo panelUsuarioIzq;
    private sacoba.vista.TransparentFormattedTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
