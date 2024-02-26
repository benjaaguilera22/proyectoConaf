
package com.mycompany.controllers;

import com.mycompany.ilib.DAOEquipo_implem;
import com.mycompany.models.Equipo;
import com.mysql.cj.result.Row;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MiControlador {

    private final DAOEquipo_implem daoEquipo;  // Reemplaza con el nombre real de tu implementación de DAOEquipo

    public MiControlador() {
        this.daoEquipo = new DAOEquipo_implem();
    }

    public void importarDesdeExcel(File archivoExcel) {
        try {
            daoEquipo.cargarDesdeExcel(archivoExcel);
        } catch (Exception e) {
            // Maneja las excepciones, muestra un mensaje de error, etc.
            e.printStackTrace();
        }
    }

    public void exportarAExcel(File archivoExcel) {
        try {
        // Obtén la lista de equipos desde la base de datos
        List<Equipo> equipos = daoEquipo.listar();

        // Crea un nuevo libro de Excel
        Workbook workbook = new XSSFWorkbook();

        // Crea una nueva hoja en el libro
        Sheet sheet = workbook.createSheet("Equipos");

        // Crea el encabezado
            org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);
        String[] headers = {"Serie", "Número", "Ubicación", "Responsable", "Usuario Final", "Orden de Compra", "Licitación", "Estado", "Patente", "ID Radio", "Provincia", "Nombre Modelo ID"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Llena la hoja con los datos de los equipos
        int rowNum = 1;
        for (Equipo equipo : equipos) {
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(equipo.getSerie_equipo());
            row.createCell(1).setCellValue(equipo.getNumero_equipo());
            row.createCell(2).setCellValue(equipo.getUbicacion_equipo());
            row.createCell(3).setCellValue(equipo.getResponsable_equipo());
            row.createCell(4).setCellValue(equipo.getUsuario_final());
            row.createCell(5).setCellValue(equipo.getOrden_compra());
            row.createCell(6).setCellValue(equipo.getLicitacion());
            row.createCell(7).setCellValue(equipo.getEstado_equipo());
            row.createCell(8).setCellValue(equipo.getPatente_equipo());
            row.createCell(9).setCellValue(equipo.getId_radio());
            row.createCell(10).setCellValue(equipo.getProvincia_equipo());
            row.createCell(11).setCellValue(equipo.getNombre_modelo_id());
        }

        // Guarda el libro en el archivo Excel
        try (FileOutputStream fileOut = new FileOutputStream(archivoExcel)) {
            workbook.write(fileOut);
        }

        // Cierra el libro
        workbook.close();
    } catch (Exception e) {
        // Maneja las excepciones, muestra un mensaje de error, etc.
        e.printStackTrace();
    }
    }
}

