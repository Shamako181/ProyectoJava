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
import modelo.Usuario;
/**
 *
 * @author carol
 */
public class ControladorUsuarios {
    
    public void guardarUsuario(Usuario usu)
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
    
    public ArrayList<Usuario> listarUsuarios()
    {
        try
        {
            ArrayList<Usuario> listaUsuarios = new ArrayList<>(); //LISTA VACÍA EN DONDE SE CARGARAN LOS PRODUCTOS
            
            Conexion conexion = new Conexion(); //OBJETO QUE CONFIGURA LA CONEXIÓN A LA BASE DE DATOS
            Connection con = conexion.getConnection(); //OBJETO QUE NECESITO PARA PODER HACER CONSULTAS A LA BASE DE DATOS
            
            //PREPARO MI CONSULTA SELECT PARA PODER RESCATAR LA INFORMACIÓN
            PreparedStatement ps = con.prepareStatement("SELECT NOMBRE, CORREO, CONTRASEÑA FROM USUARIO;");
            
            ResultSet rs = ps.executeQuery(); //executeQuery ME PERMITE EJECUTAR SELECT
            
            //COMIENZO A RECORRER MI RESULTSET
            while(rs.next()) {
                //POR CADA VALOR ENCONTRADO EN EL RESULTSET VAMOS A CREAR UN PRODUCTO
                Usuario usuario = new Usuario();
                
                usuario.setNombre(rs.getString(1));
                usuario.setCorreo(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                
                
                listaUsuarios.add(usuario);
            }
            
            return listaUsuarios;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Usuario> buscarUsuarioPorNombre(String nombre) 
    {
        try
        {
            ArrayList<Usuario> listaUsuario = new ArrayList<>();
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            
            PreparedStatement ps = con.prepareStatement("SELECT NOMBRE, CORREO, CONTRASEÑA FROM USUARIO WHERE NOMBRE LIKE ?;");
            ps.setString(1, nombre + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setNombre(rs.getString(1));
                u.setCorreo(rs.getString(2));
                u.setContraseña(rs.getString(3));
                
                
                listaUsuario.add(u);
            }
            
            return listaUsuario;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    
    
}
