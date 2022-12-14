/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.PronosticoVentasModelo;
import modelo.Venta;

/**
 *
 * @author Santiago
 */
public class PronosticoVentasVista extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    
    DefaultTableModel modeloTablaHistoricoDeVentas = new DefaultTableModel(){
        boolean[] canEdit = new boolean[]{false,false,false,false,false};
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];
        }
    };
    DefaultTableModel modeloTablaPronosticoDeVentas = new DefaultTableModel();

    public PronosticoVentasVista() {
        cargarModeloTablaHistoricoDeVentas();
        cargarModeloTablaPronosticoDeVentas();
        initComponents();
        initComponents2();
        
    }
    
    private void initComponents2(){
        txtPronosticoDeVentas.setEditable(false);
        txtTotalHistoricoAnio.setEditable(false);
        txtTotalHistoricoCantidadDeVentas.setEditable(false);
        txtTotalHistoricoX2.setEditable(false);
        txtTotalHistoricoY2.setEditable(false);
        txtTotalHistoricoXY.setEditable(false);
    }
    
    
    // Getters y Setters para el controlador
    public String getDatosDeVenta() {
        return txtDatosDeVenta.getText();
    }
    public String getAniosAPronosticar() {
        return txtAniosAPronosticar.getText();
    }
    public void setDatosDeVenta(String t){
        txtDatosDeVenta.setText(t);
    }
    public void setAniosAPronosticar(String t){
        txtAniosAPronosticar.setText(t);
    }
    public void setTotalHistoricoAnio(int anios) {
         txtTotalHistoricoAnio.setText(anios+"");
    }
    public void setTotalHistoricoCantidad(double cantidad) {
        txtTotalHistoricoCantidadDeVentas.setText(cantidad+"");
    }
    public void setTotalHistoricoX2(int x2) {
        txtTotalHistoricoX2.setText(x2+"");
    }
    public void setTotalHistoricoY2(double y2) {
        txtTotalHistoricoY2.setText(y2+"");
    }
    public void setTotalHistoricoXY(double xy) {
        txtTotalHistoricoXY.setText(xy+"");
    }
    public void setPronosticoDeVentas(String t) {
        txtPronosticoDeVentas.setText(t);
    }
    
    public void agregarDatosFilaHistoricoDeVentas(Object[] datos) {
        modeloTablaHistoricoDeVentas.addRow(datos);
    }
    
    public int numeroFilaSeleccionada(){
        return tablaHistoricoDeVentas.getSelectedRow();
    }
    
    public void actualizarHistoricoDeVentas(PronosticoVentasModelo modelo){
        while(tablaHistoricoDeVentas.getRowCount() != 0){
            modeloTablaHistoricoDeVentas.removeRow(0);
        }
        
        for(int i=0 ; i<modelo.getVentas().size() ; i++){
            modeloTablaHistoricoDeVentas.addRow(modelo.retornarFila(i));
        }
        
        txtTotalHistoricoAnio.setText(""+modelo.calcularTotalAnios());
        txtTotalHistoricoCantidadDeVentas.setText(""+ modelo.calcularTotalVentas());
        txtTotalHistoricoX2.setText(""+ modelo.calcularTotalAnioCuadrado());
        txtTotalHistoricoY2.setText(""+ modelo.calcularTotalVentasCuadrado());
        txtTotalHistoricoXY.setText("" + modelo.calcularTotalAnioPorVentas());
    }
    
    public void actualizarPronosticoDeVentas(PronosticoVentasModelo modelo){
        for(int i=0 ; i<modelo.getAniosPronosticar() ; i++){
            modeloTablaPronosticoDeVentas.addRow(modelo.retornarFilaPronostico(i));
        }
        Formatter formato = new Formatter();
        formato.format("%.2f",modelo.calcularCrecimiento() * 100);
        txtPronosticoDeVentas.setText( formato.toString()+ "%");
    }
    
    public void borrarPronosticoDeVentas(){
        while(tablaPronosticoDeVentas.getRowCount() != 0){
            modeloTablaPronosticoDeVentas.removeRow(0);
        }
    }
    
    
    
    // Modelos de tabla
    public void cargarModeloTablaHistoricoDeVentas() {
        modeloTablaHistoricoDeVentas.addColumn("X");
        modeloTablaHistoricoDeVentas.addColumn("Y");
        modeloTablaHistoricoDeVentas.addColumn("X^2");
        modeloTablaHistoricoDeVentas.addColumn("Y^2");
        modeloTablaHistoricoDeVentas.addColumn("XY");
        //modeloTablaHistoricoDeVentas.isCellEditable(0,0);
    }
    
    public void cargarModeloTablaPronosticoDeVentas() {
        modeloTablaPronosticoDeVentas.addColumn("A??o");
        modeloTablaPronosticoDeVentas.addColumn("Pron??stico de Ventas");
    }
    
    // Listeners
    public void addBtnAgregarAnioListener(ActionListener e) {
        btnAgregarAnio.addActionListener(e);
    }
    public void addBtnBorrarAnioListener(ActionListener e) {
        btnBorrarAnio.addActionListener(e);
    }
    public void addBtnModificarAnioListener(ActionListener e) {
        btnModificarAnio.addActionListener(e);
    }
    public void addBtnNuevoPronosticoListener(ActionListener e) {
        btnNuevoPronostico.addActionListener(e);
    }
    public void addBtnCalcularPronosticoListener(ActionListener e){
        btnCalcularPronostico.addActionListener(e);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDatosDeVenta = new javax.swing.JTextField();
        txtAniosAPronosticar = new javax.swing.JTextField();
        btnAgregarAnio = new javax.swing.JButton();
        btnBorrarAnio = new javax.swing.JButton();
        btnNuevoPronostico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistoricoDeVentas = new javax.swing.JTable();
        txtTotalHistoricoAnio = new javax.swing.JTextField();
        txtTotalHistoricoCantidadDeVentas = new javax.swing.JTextField();
        txtTotalHistoricoX2 = new javax.swing.JTextField();
        txtTotalHistoricoY2 = new javax.swing.JTextField();
        txtTotalHistoricoXY = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPronosticoDeVentas = new javax.swing.JTable();
        txtPronosticoDeVentas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnModificarAnio = new javax.swing.JButton();
        btnCalcularPronostico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("DATOS DE VENTA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("CONTROLES");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("A??OS A PRONOSTICAR");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("HIST??RICO DE VENTAS");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("PRON??STICO DE VENTAS");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setText("Cantidad de Venta");

        jLabel7.setText("Cantidad");

        jLabel8.setText("Total");

        jLabel9.setText("Crecimiento en Promedio");

        txtAniosAPronosticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAniosAPronosticarActionPerformed(evt);
            }
        });

        btnAgregarAnio.setText("Agregar A??o");

        btnBorrarAnio.setText("Borrar A??o");

        btnNuevoPronostico.setText("Nuevo Pronostico");

        tablaHistoricoDeVentas.setModel(modeloTablaHistoricoDeVentas);
        tablaHistoricoDeVentas.setFocusable(false);
        tablaHistoricoDeVentas.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaHistoricoDeVentas);

        tablaPronosticoDeVentas.setModel(modeloTablaPronosticoDeVentas);
        tablaPronosticoDeVentas.setEnabled(false);
        jScrollPane2.setViewportView(tablaPronosticoDeVentas);

        jLabel10.setText("A??o");

        jLabel11.setText("Cantidad de Ventas");

        btnModificarAnio.setText("Modificar A??o");

        btnCalcularPronostico.setText("Calcular Pronostico");
        btnCalcularPronostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPronosticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDatosDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtAniosAPronosticar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnNuevoPronostico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBorrarAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAgregarAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnModificarAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnCalcularPronostico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(51, 51, 51))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPronosticoDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127)
                                        .addComponent(txtTotalHistoricoCantidadDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalHistoricoX2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalHistoricoY2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalHistoricoXY, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(72, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTotalHistoricoAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDatosDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAniosAPronosticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevoPronostico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcularPronostico)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalHistoricoAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHistoricoCantidadDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHistoricoX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHistoricoY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHistoricoXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPronosticoDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAniosAPronosticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAniosAPronosticarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAniosAPronosticarActionPerformed

    private void btnCalcularPronosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPronosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularPronosticoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAnio;
    private javax.swing.JButton btnBorrarAnio;
    private javax.swing.JButton btnCalcularPronostico;
    private javax.swing.JButton btnModificarAnio;
    private javax.swing.JButton btnNuevoPronostico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tablaHistoricoDeVentas;
    private javax.swing.JTable tablaPronosticoDeVentas;
    private javax.swing.JTextField txtAniosAPronosticar;
    private javax.swing.JTextField txtDatosDeVenta;
    private javax.swing.JTextField txtPronosticoDeVentas;
    private javax.swing.JTextField txtTotalHistoricoAnio;
    private javax.swing.JTextField txtTotalHistoricoCantidadDeVentas;
    private javax.swing.JTextField txtTotalHistoricoX2;
    private javax.swing.JTextField txtTotalHistoricoXY;
    private javax.swing.JTextField txtTotalHistoricoY2;
    // End of variables declaration//GEN-END:variables
}
