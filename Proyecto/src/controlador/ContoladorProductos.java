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
import modelo.Producto;

/**
 *
 * @author raulj
 */
public class ContoladorProductos {
    
    public void guardarProducto(Producto pro)
    {
        try
        {
            Conexion conexion = new Conexion();  
            Connection con = conexion.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO producto VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getPrecio());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getCodigoDeBarras());
            ps.setString(5, pro.getMarca());
            
            
            ps.executeUpdate(); 
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public String crearCodigo(String nombre,int Precio)
    {
        
        
        return "Hola";
        
    }
    
}
