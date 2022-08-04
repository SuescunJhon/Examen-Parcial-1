/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhons
 */
public class Prueba_PronosticoVentas {
    
    public static void main(String args[]){
        PronosticoVentasModelo p = new PronosticoVentasModelo();
        p.setAniosPronosticar(5);
        p.agregarAnio(220);
        p.agregarAnio(245);
        p.agregarAnio(250);
        p.agregarAnio(258);
        p.agregarAnio(273.5);
        
        for(int i = 0 ; i < p.getVentas().size() ; i++){
            System.out.println(p.getVentas().get(i).getAnio());
        }
        p.borrarAnio(2);
        System.out.println();
        for(int i = 0 ; i < p.getVentas().size() ; i++){
            System.out.println(p.getVentas().get(i).getAnio());
        }
        
        /*
        System.out.println(p.calcularCrecimiento());
        System.out.println("6 " + p.pronostico(6) );
        System.out.println("7 " + p.pronostico(7) );
        System.out.println("8 " + p.pronostico(8) );
        System.out.println("9 " + p.pronostico(9) );
        System.out.println("10 " + p.pronostico(10) );
        */
    }
}
