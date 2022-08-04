/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicoMVP;

import controlador.PronosticoVentasControlador;
import modelo.PronosticoVentasModelo;
import vista.PronosticoVentasVista;

/**
 *
 * @author Santiago
 */
public class Principal {
    public static void main(String[] args) {
        PronosticoVentasModelo modelo = new PronosticoVentasModelo();
        PronosticoVentasVista vista = new PronosticoVentasVista();
        PronosticoVentasControlador controlador = new PronosticoVentasControlador(modelo, vista);
    }
}
