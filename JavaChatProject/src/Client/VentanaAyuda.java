/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.URL;
/**
 *
 * @author Diego
 */
public class VentanaAyuda extends JFrame{
    
    /** Creates a new instance of VentanaAyuda */
     JScrollPane panelPrincipal;
    JEditorPane html;
    public VentanaAyuda() {
        super("Ventana de Ayuda :");
        setSize(600,700);
        setLocation(450,0);
        panelPrincipal=new JScrollPane();
        
        try{ 
            URL url=getClass().getResource("Proyecto - Chat - Programacion Concurrente Cliente-Servidor.html");
            html=new JEditorPane(url);
            html.setEditable(false);
            setVisible(true);
             
        }catch(Exception e){
            e.getMessage();
        }
        
        JViewport jv=panelPrincipal.getViewport();
        jv.add(html);
        
        setContentPane(panelPrincipal);
    }
    
}