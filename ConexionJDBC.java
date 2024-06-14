/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionjdbc;

/**
 *
 * @author User
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionJDBC {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/login_db";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            // TODO code application logic here
         
           Class.forName("com.mysql.cj.jdbc.Driver");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO login_db(nombre_completo,telefono,correo,contrasena) VALUES('CARLOS','31098765','carlost@gmail','123')");
            rs = statement.executeQuery("SELECT * FROM login_db");
            rs.next();
            do{
                System.out.println(rs.getInt("id")+" : "+rs.getString("nombre_completo")+" : "+rs.getString("telefono"));
            }while(rs.next());    
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    

