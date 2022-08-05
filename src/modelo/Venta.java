/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhons
 */
public class Venta {
    
    public Venta(double cantidadVentas, int anio){
        this.cantidadVentas = cantidadVentas;
        this.anio = anio;
    }
    
    public int calcularAnioCuadrado(){
        return (int)Math.pow(anio,2);
    }
    
    public double calcularVentasCuadrado(){
        return Math.pow(cantidadVentas, 2);
    }
    
    public double calcularAnioPorVentas(){
        return anio * cantidadVentas;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public void setCantidadVentas(double cantidadVentas){
        this.cantidadVentas = cantidadVentas;
    }

    public double getCantidadVentas(){
        return cantidadVentas;
    }
    
    private double cantidadVentas;
    private int anio;
}
