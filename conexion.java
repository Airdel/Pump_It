/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author Marval
 */
public class conexion {
    public boolean conectar(){
        boolean c;
      try {
         
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         
         
      }
      catch(ClassNotFoundException cnfex) {
      
         System.out.println("Problema al cargar o "
                + "registrar:  MS Access JDBC driver");
         cnfex.printStackTrace();
         return false;
      }
      
      try{
         conn = DriverManager.getConnection(dbURL);
         System.out.println("Conexion establecidaaaaaaAAAA");
         c=true;
         
      }
      catch(SQLException ex){
       
         System.out.println("error de conexion"+ex.getMessage()+" - "+ex.getSQLState());
         return false;
      }
      System.out.println("Proceso de conexión finalizado.");
      return c;
   }
   private Connection conn = null;
   //C:\Users\marva\Dropbox (Tecnológico)\ED\Pump_it!\src\Data
   private String msAccDB = "C:\\Users\\marva\\Dropbox (Tecnológico)\\ED\\Pump_it!\\src\\Data\\Pump_ItDB.accdb";
   private String dbURL = "jdbc:ucanaccess://"+msAccDB;


}
