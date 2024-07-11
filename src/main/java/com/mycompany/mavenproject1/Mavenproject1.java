
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mavenproject1 {

    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Insercion de datos
            
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'jandrea');");
            System.out.println();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Actualizacion de datos 
            
            
            statement.execute("UPDATE `usuarios` SET `nombre` = 'nataliaj' WHERE `usuarios`.`id` = 3;");
            System.out.println();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Borrado o eliminacion de datos
            
            
            statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`id` = 3");
            System.out.println();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
