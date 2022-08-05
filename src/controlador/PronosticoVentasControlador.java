/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PronosticoVentasModelo;
import vista.PronosticoVentasVista;

/**
 *
 * @author jhons
 */
public class PronosticoVentasControlador {
    private PronosticoVentasModelo modelo = new PronosticoVentasModelo();
    private PronosticoVentasVista vista = new PronosticoVentasVista();
    
    
    public PronosticoVentasControlador(PronosticoVentasModelo modelo, PronosticoVentasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnAgregarAnioListener(new ManejadorEventos());
        this.vista.addBtnBorrarAnioListener(new ManejadorEventos());
        this.vista.addBtnModificarAnioListener(new ManejadorEventos());
        this.vista.addBtnNuevoPronosticoListener(new ManejadorEventos());
        this.vista.addBtnCalcularPronosticoListener(new ManejadorEventos());
    }
    
    class ManejadorEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Agregar Año")) {
                int ultimoLista = modelo.getVentas().size();
                modelo.agregarAnio(vista.getDatosDeVenta());
            }
            if (e.getActionCommand().equalsIgnoreCase("Borrar Año")) {
                int numLista = vista.numeroFilaSeleccionada();
                modelo.borrarAnio(numLista);
            }
            if (e.getActionCommand().equalsIgnoreCase("Modificar Año")) {
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Nuevo Pronostico")) {
                modelo.borrarPronostico();
                vista.borrarPronosticoDeVentas();
                vista.setPronosticoDeVentas("");
            }
            if (e.getActionCommand().equalsIgnoreCase("calcular pronostico")) {
                modelo.setAniosPronosticar(vista.getAniosAPronosticar());
                vista.actualizarPronosticoDeVentas(modelo);
            }
            
            vista.actualizarHistoricoDeVentas(modelo);
        }
        
    }
    
}
