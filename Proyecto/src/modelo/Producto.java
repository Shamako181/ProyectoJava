/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author raulj
 */
public class Producto {
    
    private String nombre;
    private int Precio;
    private String marca;
    private String descripcion;
    private String codigoDeBarras;
    
    public Producto()
    {
    }

    public Producto(String nombre, int Precio, String descripcion, String codigoDeBarras,String marca) {
        this.nombre = nombre;
        this.Precio = Precio;
        this.descripcion = descripcion;
        this.codigoDeBarras = codigoDeBarras;
        this.marca=marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }    
    
}
