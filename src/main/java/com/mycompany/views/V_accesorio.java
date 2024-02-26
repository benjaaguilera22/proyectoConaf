package com.mycompany.views;

import com.mycompany.ilib.DAOaccesorio_imple;
import com.mycompany.ilib.Dashboard;
import com.mycompany.interfaces.DAOaccesorio;
import com.mycompany.models.Accesorio;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class V_accesorio extends javax.swing.JPanel {

    public V_accesorio () {
        initComponents();
        InitStyles();
        LoadAccesorios(); // Cambiado el nombre del método
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        
    }
    
    private void LoadAccesorios() {
        try {
            DAOaccesorio daoAccesorio = new DAOaccesorio_imple();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            List<Accesorio> listaAccesorios = daoAccesorio.list();

            listaAccesorios.forEach((u) -> model.addRow(new Object[]{u.getId_accesorio(), u.getNombre_accesorio(), u.getCodigo_modelo(), u.getStock_accesorio(),u.getCodigo_modelo_a()}));
            
            // Crea un renderizador personalizado para centrar
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            // Aplica el renderizador a todas las columnas
            for (int i = 0; i < model.getColumnCount(); i++) {
                jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
            // Resto del código...
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        bookSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        title.setText("Accesorios");

        bookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSearchActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 153, 51));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(0, 153, 51));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Editar");
        editButton.setBorderPainted(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 153, 51));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Nuevo");
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Accesorio", "Nombre Accesorio", "Modelo Accesorio", "Stock Accesorio","Codigo Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addGap(176, 176, 176))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(bookSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)))
                        .addGap(50, 50, 50))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(addButton))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
    }//GEN-LAST:event_jTable1MousePressed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Dashboard.ShowJPanel(new Upaccesorio());
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (jTable1.getSelectedRow() > -1) {
        try {
            // Obtener el nombre del accesorio de la fila seleccionada
            String nombreAccesorio = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
            
            // Crear instancia del DAO de accesorio
            DAOaccesorio dao = new DAOaccesorio_imple();
            
            // Obtener el accesorio por su nombre
            Accesorio accesorio = dao.getaccesorio(nombreAccesorio);
            
            // Mostrar la vista de actualización de accesorio
            Dashboard.ShowJPanel(new Upaccesorio(accesorio));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el accesorio a editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       try {
            DAOaccesorio daoAccesorio = new DAOaccesorio_imple();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String campo = bookSearch.getText();

            // Si no se proporciona un campo, cargar todos los accesorios
            if (campo.isEmpty()) {
                LoadAccesorios();
            } else {
                // Realizar la búsqueda por nombre de accesorio
                daoAccesorio.list().stream()
                        .filter(acc -> acc.getNombre_accesorio().toLowerCase().contains(campo.toLowerCase()))
                        .forEach((u) -> model.addRow(new Object[]{u.getId_accesorio(), u.getNombre_accesorio(), u.getCodigo_modelo(), u.getStock_accesorio(),u.getCodigo_modelo_a()}));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void bookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}