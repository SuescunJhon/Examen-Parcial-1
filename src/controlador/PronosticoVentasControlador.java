/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
            try{
                if (e.getActionCommand().equalsIgnoreCase("Agregar Año")) {
                    metodoExepcionesAgregar();
                    int ultimoLista = modelo.getVentas().size();
                    modelo.agregarAnio(Double.parseDouble(vista.getDatosDeVenta()));
                    vista.setDatosDeVenta("");
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
                    int anios = Integer.parseInt(vista.getAniosAPronosticar());
                    metodoExcepcionesCalcular();
                    modelo.setAniosPronosticar(anios);
                    vista.actualizarPronosticoDeVentas(modelo);
                    vista.setAniosAPronosticar("");
                }

                vista.actualizarHistoricoDeVentas(modelo);
            } catch (MyException ae){
                JOptionPane.showMessageDialog(null,ae.getMessage());
            } catch (NumberFormatException oe){
                JOptionPane.showMessageDialog(null, "Error: Digite un número");
            }
        }
        
        public void metodoExepcionesAgregar() throws MyException {
            if(vista.getDatosDeVenta().equalsIgnoreCase("")){
                throw new MyException("Error: el campo cantidad de venta es obligatorio");
            }
        }
        
        public void metodoExcepcionesCalcular() throws MyException{
            if(vista.getAniosAPronosticar().equalsIgnoreCase("")){
                throw new MyException("Error: el campo cantidad año pronostico es obligatorio");
            } else if(Integer.parseInt(vista.getAniosAPronosticar()) <= 2){
                throw new MyException("Error: El pronostico de ventas debe ser mayor a 2");
            } else if(modelo.getVentas().size() < 3){
                throw new MyException("Error: se necesitan minimo 3 años en historico de ventas");
            }
        }
        
    }
    
    class MyException extends Exception {
        public MyException(String mensaje){
        super(mensaje);
    }
}
    
}
