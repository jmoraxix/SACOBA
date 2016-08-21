/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Diego
 */
public class VentanaCliente extends JFrame implements ActionListener {
    
    String mensajeCliente;
    JTextArea panMostrar;
    JTextField txtMensage;
    JButton butEnviar;
    JLabel lblNomUser;
    JList lstActivos;
    JButton butPrivado;
    Client cliente;
    
    JMenuBar barraMenu;
    JMenu JMAyuda;
    JMenuItem help;
    JMenu JMAcerca;
    JMenuItem acercaD;
    VentanaAyuda va;
    
    JOptionPane AcercaDe;
    
    Vector<String> nomUsers;
    VentanaPrivada ventPrivada;

    /**
     * Creates a new instance of Cliente
     *
     * @throws java.io.IOException
     */
    public VentanaCliente() throws IOException {
        super("Cliente Chat");
        
        this.getContentPane().setBackground(Color.red);
        txtMensage = new JTextField(30);
        butEnviar = new JButton("Enviar");
        lblNomUser = new JLabel("Usuario <<  >>");
        lblNomUser.setHorizontalAlignment(JLabel.CENTER);
        panMostrar = new JTextArea();
        panMostrar.setColumns(25);
        txtMensage.addActionListener(this);
        butEnviar.addActionListener(this);
        lstActivos = new JList();
        butPrivado = new JButton("Privado");
        butPrivado.addActionListener(this);
        
        barraMenu = new JMenuBar();
        JMAyuda = new JMenu("Ayuda");
        help = new JMenuItem("Ayuda");
        help.setActionCommand("help");
        help.addActionListener(this);
        
        JMAcerca = new JMenu("Acerca de");
        acercaD = new JMenuItem("Creditos");
        acercaD.setActionCommand("Acerca");
        acercaD.addActionListener(this);
        
        JMAyuda.add(help);
        JMAcerca.add(acercaD);
        barraMenu.add(JMAcerca);
        barraMenu.add(JMAyuda);
        
        panMostrar.setEditable(false);
        panMostrar.setForeground(Color.BLUE);
        panMostrar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(25, 10, 80)));
        
        JPanel panAbajo = new JPanel();
        panAbajo.setLayout(new BorderLayout());
        panAbajo.add(new JLabel("  Ingrese mensage a enviar:"), BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);
        JPanel panRight = new JPanel();
        panRight.setLayout(new BorderLayout());
        panRight.add(lblNomUser, BorderLayout.NORTH);
        panRight.add(new JScrollPane(panMostrar), BorderLayout.CENTER);
        panRight.add(panAbajo, BorderLayout.SOUTH);
        JPanel panLeft = new JPanel();
        panLeft.setLayout(new BorderLayout());
        panLeft.add(new JScrollPane(this.lstActivos), BorderLayout.CENTER);
        panLeft.add(this.butPrivado, BorderLayout.NORTH);
        JSplitPane sldCentral = new JSplitPane();
        sldCentral.setDividerLocation(100);
        sldCentral.setDividerSize(7);
        sldCentral.setOneTouchExpandable(true);
        sldCentral.setLeftComponent(panLeft);
        sldCentral.setRightComponent(panRight);
        
        setLayout(new BorderLayout());
        add(sldCentral, BorderLayout.CENTER);
        add(barraMenu, BorderLayout.NORTH);
        
        txtMensage.requestFocus();//pedir el focus	

        cliente = new Client(this);
        cliente.conexion();
        nomUsers = new Vector();
        ponerActivos(cliente.pedirUsuarios());
        
        ventPrivada = new VentanaPrivada(cliente);
        
        setSize(450, 430);
        setLocation(120, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setNombreUser(String user) {
        lblNomUser.setText("Usuario " + user);
    }
    
    public void mostrarMsg(String msg) {
        this.panMostrar.append(msg + "\n");
    }
    
    public void ponerActivos(Vector datos) {
        nomUsers = datos;
        ponerDatosList(this.lstActivos, nomUsers);
    }
    
    public void agregarUser(String user) {
        nomUsers.add(user);
        ponerDatosList(this.lstActivos, nomUsers);
    }
    
    public void retirraUser(String user) {
        nomUsers.remove(user);
        ponerDatosList(this.lstActivos, nomUsers);
    }
    
    private void ponerDatosList(JList list, final Vector datos) {
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {
                return datos.size();
            }
            
            @Override
            public Object getElementAt(int i) {
                return datos.get(i);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        String comand = (String) evt.getActionCommand();
        if (comand.compareTo("help") == 0) {
            va = new VentanaAyuda();
            va.setVisible(true);
        }
        if (comand.compareTo("Acerca") == 0) {
            JOptionPane.showMessageDialog(this, "Alejandro Gutierrez \n"
                    + " Daniel Castellano \n"
                    + "Diego Delgado", "Desarrollado por", JOptionPane.INFORMATION_MESSAGE);
        }
        if (evt.getSource() == this.butEnviar || evt.getSource() == this.txtMensage) {
            String mensaje = txtMensage.getText();
            cliente.flujo(mensaje);
            txtMensage.setText("");
        } else if (evt.getSource() == this.butPrivado) {
            int pos = this.lstActivos.getSelectedIndex();
            if (pos >= 0) {
                ventPrivada.setAmigo(nomUsers.get(pos));
                ventPrivada.setVisible(true);
            }
        }
    }
    
    public void mensageAmigo(String amigo, String msg) {
        ventPrivada.setAmigo(amigo);
        ventPrivada.mostrarMsg(msg);
        ventPrivada.setVisible(true);
    }
    
    public static void main(String args[]) {
        try {
            Client.IP_SERVER = args[0];
        } catch (IndexOutOfBoundsException ex) {
            while (Client.IP_SERVER.equals("")) {
                Client.IP_SERVER = JOptionPane.showInputDialog("Introducir IP_SERVER :", "localhost");
            }
            
        }
        try {
            VentanaCliente p = new VentanaCliente();
            
            Image icon = Toolkit.getDefaultToolkit()
                    .getImage(VentanaCliente.class.getResource("/Imagenes/logo_principal_icono.png"));
            p.setIconImage(icon);
        } catch (IOException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
