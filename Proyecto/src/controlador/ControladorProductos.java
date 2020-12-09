/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author raulj
 */
public class ControladorProductos {
    
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
    
    public ArrayList<Producto> listarProductos()
    {
        try{
            
            ArrayList<Producto> listaProductos=new ArrayList<>();
            
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            
            PreparedStatement ps = con.prepareStatement("SELECT NOMBRE,DESCRIPCION,MARCA,PRECIO,CODIGO_DE_BARRAS "
                    + "FROM PRODUCTO");
        
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                Producto produ = new Producto();
                
                produ.setNombre(rs.getString("nombre"));
                produ.setDescripcion(rs.getString("descripcion"));
                produ.setMarca(rs.getString("marca"));
                produ.setPrecio(rs.getInt("precio"));
                produ.setCodigoDeBarras(rs.getString("codigo_de_barras"));
                
                listaProductos.add(produ);
            
            }
            
            return listaProductos;
            
            
        }catch(Exception ex){
            
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Producto> buscarPorNombre(String nombre)
    {
        return new ArrayList<>();
    }
    
}
