package com.mycompany.views;

import com.mycompany.controllers.MiControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Excel extends javax.swing.JPanel {

    private final MiControlador controlador;

    public Excel(MiControlador controlador) {
        this.controlador = controlador;
        initComponents(); 

        procesar_excel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoProcesar();
            }
        });

        export_excel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarAExcel();
            }
        });
    }

    private void mostrarDialogoProcesar() {
        String[] opciones = {"Importar Excel", "Exportar Excel"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione la operación", "Procesar Excel", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            importarDesdeExcel();
        } else if (seleccion == 1) {
            exportarAExcel();
        }
    }

    private void importarDesdeExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Excel", "xlsx"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            // Llama al método en el controlador para importar desde Excel
            controlador.importarDesdeExcel(archivoSeleccionado);
        }
    }

    private void exportarAExcel() {
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Excel", "xlsx"));

    int seleccion = fileChooser.showSaveDialog(this);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivoExcel = fileChooser.getSelectedFile();

        // Asegúrate de que la extensión sea .xlsx
        if (!archivoExcel.getName().toLowerCase().endsWith(".xlsx")) {
            archivoExcel = new File(archivoExcel.getParentFile(), archivoExcel.getName() + ".xlsx");
        }

        try {
            // Llama al método en el controlador para exportar a Excel
            controlador.exportarAExcel(archivoExcel);
        } catch (Exception ex) {
            // Maneja la excepción adecuadamente (muestra un mensaje, registra en el log, etc.)
            ex.printStackTrace();
        }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inport_excel = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        export_excel = new javax.swing.JToggleButton();
        procesar_excel = new javax.swing.JToggleButton();

        jLabel1.setText("Agregar Equipos via Excel");

        inport_excel.setText("IMPORTAR EXCEL");

        jLabel2.setText("Exportar Excel con datos Equipos");

        export_excel.setText("EXPORTAR EXCEL");

        procesar_excel.setText("Procesar Excel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(inport_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(452, 452, 452)
                        .addComponent(export_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addGap(409, 409, 409)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(procesar_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(420, 420, 420))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inport_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(export_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(procesar_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton export_excel;
    private javax.swing.JToggleButton inport_excel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton procesar_excel;
    // End of variables declaration//GEN-END:variables
}
