/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import sacoba.servidor.beans.Empleado;
import sacoba.servidor.beans.Notificacion;
import sacoba.servidor.beans.Persona;
import sacoba.servidor.estructuras.Arbol;
import sacoba.servidor.estructuras.ListaEnlazadaClientes;
import sacoba.vista.VentanaBase;

/**
 *
 * @author jmora
 */
public class Servidor extends VentanaBase {

    //Variables Globales
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private Arbol arbol = new Arbol();

    //Variables de TCP
    private static int SERVER_PORT = 2356;
    private ServerSocket serverSocket;
    private Socket socket;
    private ExecutorService service;
    private ListaEnlazadaClientes clientes;

    //Variables para manejo de la interfaz
    private String txtLog = new String();

    /**
     * Creates new form Servidor
     */
    public Servidor() {
        new GenerarValores(this);
        initComponents();

        //Inicializa la lista enlazada para almacenar clientes
        clientes = new ListaEnlazadaClientes();
        txtCajaLog.setText(txtLog);

        try {
            agregarLog("Inicia servidor");
            //System.out.println("Inicia servidor");
            service = Executors.newCachedThreadPool();
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException ex) {
            agregarError(ex.toString());
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Metodos de TCP
    private void aceptarClientes() {
        try {
            while (true) {
                socket = serverSocket.accept();
                agregarLog("Cliente entrante");
                //System.out.println("Cliente entrante");
                ClienteServidor client = new ClienteServidor(this, socket);
                service.submit(client);
                this.clientes.insertarCliente(client);
                agregarLog("Cliente agregado");
                //System.out.println("Cliente agregado");
            }
        } catch (IOException ex) {
            agregarError(ex.toString());
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envia una notificacion de actualizacion de cola a todos los clientes
     *
     * @param notificacion Tipo de notificacion
     * @param cantidad Nueva cantidad de personas en la cola
     */
    public void notificarCambioCola(Notificacion notificacion, final String cantidad) {
        clientes.notificarCambioCola(notificacion, cantidad);
    }

    public void notificarUsuarioAMonitores(String secuencia, Persona persona, final String caja) {
        clientes.notificarUsuarioAMonitores(secuencia, persona, caja);
    }

    public synchronized String insertarUsuarioEnCola(String idCola, Persona persona) {
        return arbol.insertarUsuario(idCola, persona);
    }

    //Metodos para manejo de la interfaz
    /**
     * Agrega un log a la consola y/o interfaz
     *
     * @param msj Mensaje a mostrar
     */
    public synchronized void agregarLog(String msj) {
        Date fecha = new Date(System.currentTimeMillis());
        this.txtLog = fecha.toString() + " - " + msj + "\n" + txtLog;
        this.txtCajaLog.setText(txtLog);
        System.out.println(txtLog);
    }

    /**
     *
     * @param msj
     */
    public synchronized void agregarError(String msj) {
        Date fecha = new Date(System.currentTimeMillis());
        this.txtLog = fecha.toString() + " - " + "ERROR: " + msj + "\n" + txtLog;
        this.txtCajaLog.setText(txtLog);
    }

    //Getters & setters
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public synchronized void addPersona(Persona persona) {
        this.personas.add(persona);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public synchronized void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public String getTxtLog() {
        return txtLog;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public ListaEnlazadaClientes getClientes() {
        return clientes;
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
        panelScrollContenido = new javax.swing.JScrollPane();
        txtCajaLog = new sacoba.vista.TransparentTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(950, 650));
        setMinimumSize(new java.awt.Dimension(950, 650));
        setSize(new java.awt.Dimension(950, 650));

        lblTitulo1.setFont(LETRA_TITULO);
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Sistema de Asistencia de Control Bancario");
        lblTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(lblTitulo1);
        lblTitulo1.setBounds(10, 0, 880, 50);

        txtCajaLog.setEditable(false);
        txtCajaLog.setColumns(20);
        txtCajaLog.setRows(10);
        txtCajaLog.setFont(LETRA_TEXTO_3);
        panelScrollContenido.setViewportView(txtCajaLog);

        panelContenido.add(panelScrollContenido);
        panelScrollContenido.setBounds(20, 30, 850, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Inicia el servidor del chat
                try {
                    Runtime.getRuntime().exec("java -jar lib/SACOBA_Chat_Server.jar");
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

                Servidor server = new Servidor();
                server.setVisible(true);
                server.aceptarClientes();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitulo1;
    private sacoba.vista.PanelConFondo panelContenido;
    private javax.swing.JScrollPane panelScrollContenido;
    private sacoba.vista.PanelConFondo panelTitulo;
    private sacoba.vista.TransparentTextArea txtCajaLog;
    // End of variables declaration//GEN-END:variables
}
