/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.net.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ThreadCliente extends Thread{
   DataInputStream entrada;
   VentanaCliente vcli;
   public ThreadCliente (DataInputStream entrada,VentanaCliente vcli) throws IOException
   {
      this.entrada=entrada;
      this.vcli=vcli;
   }
   public void run()
   {
      String menser="",amigo="";
      int opcion=0;
      while(true)
      {         
         try{
            opcion=entrada.readInt();
            switch(opcion)
            {
               case 1://mensage enviado
                  menser=entrada.readUTF();
                  System.out.println("ECO del servidor:"+menser);
                  vcli.mostrarMsg(menser);            
                  break;
               case 2://se agrega
                  menser=entrada.readUTF();
                  vcli.agregarUser(menser);                  
                  break;
               case 3://mensage de amigo
                  amigo=entrada.readUTF();
                  menser=entrada.readUTF();
                  vcli.mensageAmigo(amigo,menser);
                  System.out.println("ECO del servidor:"+menser);
                  break;
            }
         }
         catch (IOException e){
            System.out.println("Error en la comunicación "+"Información para el usuario");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }

   
}
