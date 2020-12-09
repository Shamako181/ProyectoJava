/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelo.Usuario;
/**
 *
 * @author carol
 */
public class ControladorUsuarios {
    
    public void guardarUsaurio(Usuario usu)
    {
         try
        {
            Conexion conexion = new Conexion();  
            Connection con = conexion.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuario VALUES(?, ?, ?)");
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getCorreo());
            ps.setString(3, usu.getContraseña());

            ps.executeUpdate();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
