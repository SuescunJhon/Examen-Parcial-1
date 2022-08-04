/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jhons
 */
public class PronosticoVentasModelo {
    public PronosticoVentasModelo(){
        ventas = new ArrayList<>();
    }
    
    public void setAniosPronosticar(int aniosPronosticar){
        this.aniosPronosticar = aniosPronosticar;
    }
    
    public void agregarAnio(double cantidadVentas){
        int anioAnterior = 0;
        if(!ventas.isEmpty()){
            anioAnterior = ventas.get(ventas.size() - 1).getAnio();
        }
        anioAnterior++;
        ventas.add(new Venta(cantidadVentas,anioAnterior));
    }
    
    public void borrarAnio(int index){
        ventas.remove(index);
        
        for(int i=0; i<ventas.size() ; i++){
            ventas.get(i).setAnio(i+1);
        }
    }
    
    public void modificarAnio(double cantidadVentas, int index){
        ventas.get(index).setCantidadVentas(cantidadVentas);
    }
    
    public int calcularTotalAnios(){
        int total = 0;
        for(int i=0; i<ventas.size() ; i++){
            total += ventas.get(i).getAnio();
        }
        return total;
    }
    
    public double calcularTotalVentas(){
        double total = 0;
        for(int i=0; i<ventas.size() ; i++){
            total += ventas.get(i).getCantidadVentas();
        }
        return total;
    }
    
    public int calcularTotalAnioCuadrado(){
        int total = 0;
        for(int i=0 ; i<ventas.size(); i++){
            total += ventas.get(i).calcularAnioCuadrado();
        }
        return total;
    }
    
    public double calcularTotalVentasCuadrado(){
        double total = 0;
        for (int i=0 ; i<ventas.size() ; i++){
            total += ventas.get(i).calcularVentasCuadrado();
        }
        return total;
    }
    
    public double calcularTotalAnioPorVentas(){
        double total = 0;
        for (int i=0 ; i<ventas.size() ; i++){
            total += ventas.get(i).calcularAnioPorVentas();
        }
        return total;
    }
    
    public double calcularB(){
        double b;
        int n = aniosPronosticar;
        double sumaXY = calcularTotalAnioPorVentas();
        int sumaX = calcularTotalAnios();
        double sumaY = calcularTotalVentas();
        double sumaX2 = calcularTotalAnioCuadrado();
        
        b = ( n * sumaXY - sumaX * sumaY ) / ( n * sumaX2 - Math.pow(sumaX, 2));
        return b;
    }
    
    public double calcularA(){
        double a;
        int n = aniosPronosticar;
        int sumaX = calcularTotalAnios();
        double sumaY = calcularTotalVentas();
        double b = calcularB();
        
        a = (sumaY - b * sumaX) / n;
        return a;
    }
    
    public double calcularCrecimiento(){
        double c;
        double b = calcularB();
        int n = aniosPronosticar;
        double sumaY = calcularTotalVentas();
        
        c = (b * n) / sumaY;
        return c;
    }
    
    public double pronostico(int periodo){
        double pronostico;
        double a = calcularA();
        double b = calcularB();
        
        pronostico = a + b * periodo;
        return pronostico;
    }
    
    public ArrayList<Venta> getVentas(){
        return ventas;
    }
    
    // variables de instancia
    ArrayList<Venta> ventas;
    int aniosPronosticar;
}

class Venta{
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
