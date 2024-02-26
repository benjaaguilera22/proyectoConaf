package com.mycompany.views;

import com.mycompany.ilib.DAOEquipo_implem;
import com.mycompany.ilib.DAOmodelo_imple;
import com.mycompany.ilib.Dashboard;
import com.mycompany.interfaces.DAOequipo;
import com.mycompany.models.Equipo;
import com.mycompany.models.modelo_equipo;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class V_equipo extends javax.swing.JPanel {

    public V_equipo () {
        initComponents();
        InitStyles();
        LoadEquipo();
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        bookSearch.putClientProperty("JTextField.placeholderText", "Ingrese el título del libro a buscar.");
    }
    
    private void LoadEquipo() {
       try {
        DAOequipo dao = new DAOEquipo_implem();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        List<Equipo> equipos = dao.listar();

        if (equipos.isEmpty()) {
            System.out.println("No se encontraron equipos en el método listarEquipos.");
        } else {
            System.out.println("Cantidad de equipos recuperados: " + equipos.size());

            equipos.forEach((u) -> model.addRow(new Object[]{
                    u.getSerie_equipo(),
                    u.getNumero_equipo(),
                    u.getUbicacion_equipo(),
                    u.getResponsable_equipo(),
                    u.getUsuario_final(),
                    u.getOrden_compra(),
                    u.getLicitacion(),
                    u.getEstado_equipo(),
                    u.getPatente_equipo(),
                    u.getId_radio(),
                    u.getProvincia_equipo(),
                    u.getNombre_modelo_id()
            }));
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cargar equipos en LoadEquipo: " + e.getMessage());
    }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        bookSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        mantencionbutton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add_model = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        title.setText("Equipos");

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

        mantencionbutton.setBackground(new java.awt.Color(0, 153, 51));
        mantencionbutton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mantencionbutton.setForeground(new java.awt.Color(255, 255, 255));
        mantencionbutton.setText("Mantencion");
        mantencionbutton.setBorderPainted(false);
        mantencionbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mantencionbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantencionbuttonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(0, 153, 51));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Editar Ficha");
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
        addButton.setText("Nuevo Equipo");
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
                "Serie Equipo", "Número Equipo", "Ubicación Equipo", "Responsable Equipo",
                "Usuario Final", "Orden de Compra", "Licitación Equipo", "Estado Equipo",
                "Patente Equipo", "ID Radio", "Provincia Equipo", "Nombre Modelo ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add_model.setBackground(new java.awt.Color(0, 153, 51));
        add_model.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add_model.setForeground(new java.awt.Color(255, 255, 255));
        add_model.setText("Nuevo Modelo");
        add_model.setBorderPainted(false);
        add_model.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_modelActionPerformed(evt);
            }
        });

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
                                .addComponent(bookSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(339, 339, 339)
                                .addComponent(add_model, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mantencionbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mantencionbutton)
                    .addComponent(editButton)
                    .addComponent(addButton)
                    .addComponent(add_model))
                .addGap(69, 69, 69))
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
        Dashboard.ShowJPanel(new UpEquipo());
    }//GEN-LAST:event_addButtonActionPerformed

    private void mantencionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantencionbuttonActionPerformed
       // Obtener la fila seleccionada desde la tabla (supongamos que tienes una tabla llamada jTableEquipos)
    int selectedRow = jTable1.getSelectedRow();

    // Verificar si se seleccionó una fila
    if (selectedRow != -1) {
        // Obtener el número de serie de la columna "Serie Equipo" (índice 0)
        String serieEquipo = jTable1.getValueAt(selectedRow, 0).toString();

        // Verificar si el número de serie no está vacío
        if (!serieEquipo.isEmpty()) {
            Dashboard.ShowJPanel(new mantencion_accesorios(serieEquipo));
        } else {
            // Manejar el caso en que el número de serie esté vacío
            System.out.println("Error: El número de serie está vacío.");
        }
    } else {
        // Manejar el caso en que no se haya seleccionado ninguna fila
        System.out.println("Error: No se ha seleccionado ninguna fila.");
    }
    }//GEN-LAST:event_mantencionbuttonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (jTable1.getSelectedRow() > -1) {
        try {
            String serieEquipo = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            DAOequipo dao = new DAOEquipo_implem();
            
            // Obtener la información del equipo directamente de la tabla
            Equipo equipo = new Equipo();
            equipo.setSerie_equipo(serieEquipo);
            equipo.setNumero_equipo((int) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            equipo.setUbicacion_equipo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            equipo.setResponsable_equipo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
            equipo.setUsuario_final((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4));
            equipo.setOrden_compra((String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
            equipo.setLicitacion((String) jTable1.getValueAt(jTable1.getSelectedRow(), 6));
            equipo.setEstado_equipo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 7));
            equipo.setPatente_equipo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 8));
            equipo.setId_radio((String) jTable1.getValueAt(jTable1.getSelectedRow(), 9));
            equipo.setProvincia_equipo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 10));
            equipo.setNombre_modelo_id((String) jTable1.getValueAt(jTable1.getSelectedRow(), 11));
            
            // Mostrar el panel de edición con la información del equipo
            Dashboard.ShowJPanel(new UpEquipo(equipo));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el equipo a editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
        DAOequipo dao = new DAOEquipo_implem();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String campo = bookSearch.getText();

        // Si no se proporciona un campo, cargar todos los equipos
        if (campo.isEmpty()) {
            dao.listar().forEach((u) -> {
                model.addRow(new Object[]{
                        u.getSerie_equipo(),
                        u.getNumero_equipo(),
                        u.getUbicacion_equipo(),
                        u.getResponsable_equipo(),
                        u.getUsuario_final(),
                        u.getOrden_compra(),
                        u.getLicitacion(),
                        u.getEstado_equipo(),
                        u.getPatente_equipo(),
                        u.getId_radio(),
                        u.getProvincia_equipo(),
                        u.getNombre_modelo_id()
                });
            });
        } else {
            // Realizar la búsqueda en cualquier campo
            dao.buscarEquipos(campo, campo, campo, campo, campo, campo, campo, campo, campo, campo, campo, campo).forEach((u) -> {
                model.addRow(new Object[]{
                        u.getSerie_equipo(),
                        u.getNumero_equipo(),
                        u.getUbicacion_equipo(),
                        u.getResponsable_equipo(),
                        u.getUsuario_final(),
                        u.getOrden_compra(),
                        u.getLicitacion(),
                        u.getEstado_equipo(),
                        u.getPatente_equipo(),
                        u.getId_radio(),
                        u.getProvincia_equipo(),
                        u.getNombre_modelo_id()
                });
            });
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void bookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSearchActionPerformed

    private void add_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_modelActionPerformed
       // Mostrar un cuadro de diálogo para ingresar el nombre del nuevo modelo
        String nuevoModelo = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo modelo:", "Nuevo Modelo", JOptionPane.PLAIN_MESSAGE);

        // Verificar si se ingresó un nombre de modelo
        if (nuevoModelo != null && !nuevoModelo.isEmpty()) {
            try {
                // Crear un objeto de modelo_equipo con el nombre ingresado
                modelo_equipo nuevoModeloEquipo = new modelo_equipo();
                nuevoModeloEquipo.setNombre_modelo(nuevoModelo);

                // Crear una instancia de DAOmodelo_imple y llamar al método registrar
                DAOmodelo_imple daoModelo = new DAOmodelo_imple();
                daoModelo.registrar(nuevoModeloEquipo);

                // Actualizar la vista de modelos (puedes agregar una función de actualización si es necesario)
                // Ejemplo: LoadModelos();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al registrar el nuevo modelo: " + e.getMessage());
            }
        } else {
            System.out.println("Error: No se ingresó un nombre de modelo.");
        }
    }//GEN-LAST:event_add_modelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton add_model;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mantencionbutton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}