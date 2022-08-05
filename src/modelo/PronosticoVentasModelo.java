/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Vector;

/**
 *
 * @author jhons
 */
public class PronosticoVentasModelo {
    public PronosticoVentasModelo(){
        ventas = new Vector<>();
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
    
    public Vector<Venta> getVentas(){
        return ventas;
    }
    
    public void borrarPronostico(){
        ventas.clear();
    }
    
    public Object[] retornarFila(int index){
        Object[] obj = new Object[5];
        obj[0] = ventas.get(index).getAnio();
        obj[1] = ventas.get(index).getCantidadVentas();
        obj[2] = ventas.get(index).calcularAnioCuadrado();
        obj[3] = ventas.get(index).calcularVentasCuadrado();
        obj[4] = ventas.get(index).calcularAnioPorVentas();
        return obj;
    }
    
    public Object[] retornarFilaPronostico(int index){
        Object[] obj = new Object[aniosPronosticar];
        int ultimoEnFila = ventas.size();
        obj[0] = ventas.get(ultimoEnFila-1).getAnio() + index + 1;
        Formatter formato = new Formatter();
        formato.format("%.2f",pronostico(ultimoEnFila + index + 1));
        obj[1] = formato.toString();
        return obj;
    }
    
    public int getAniosPronosticar(){
        return aniosPronosticar;
    }
    
    // variables de instancia
    Vector<Venta> ventas;
    int aniosPronosticar;
}


