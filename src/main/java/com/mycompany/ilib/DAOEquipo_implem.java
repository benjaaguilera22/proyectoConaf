
package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOequipo;
import com.mycompany.models.Equipo;
import com.mysql.cj.result.Row;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;


public class DAOEquipo_implem extends Database implements DAOequipo{

    @Override
    public void registrar(com.mycompany.models.Equipo equipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO equipo (serie_equipo, numero_equipo, ubicacion_equipo, responsable_equipo, usuario_final, orden_compra, licitacion_equipo, estado_equipo, patente_equipo, id_radio, provincia_equipo, nombre_modelo_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, equipo.getSerie_equipo());
            st.setInt(2, equipo.getNumero_equipo());
            st.setString(3, equipo.getUbicacion_equipo());
            st.setString(4, equipo.getResponsable_equipo());
            st.setString(5, equipo.getUsuario_final());
            st.setString(6, equipo.getOrden_compra());
            st.setString(7, equipo.getLicitacion());
            st.setString(8, equipo.getEstado_equipo());
            st.setString(9, equipo.getPatente_equipo());
            st.setString(10, equipo.getId_radio());
            st.setString(11, equipo.getProvincia_equipo());
            st.setString(12, equipo.getNombre_modelo_id());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(com.mycompany.models.Equipo equipo) throws Exception {
         try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("UPDATE equipo SET serie_equipo = ?, numero_equipo = ?, ubicacion_equipo = ?, responsable_equipo = ?, usuario_final = ?, orden_compra = ?, licitacion_equipo = ?, estado_equipo = ?, patente_equipo = ?, id_radio = ?, provincia_equipo = ?, nombre_modelo_id = ? WHERE serie_equipo  = ?");
        st.setString(1, equipo.getSerie_equipo());
        st.setInt(2, equipo.getNumero_equipo());
        st.setString(3, equipo.getUbicacion_equipo());
        st.setString(4, equipo.getResponsable_equipo());
        st.setString(5, equipo.getUsuario_final());
        st.setString(6, equipo.getOrden_compra());
        st.setString(7, equipo.getLicitacion());
        st.setString(8, equipo.getEstado_equipo());
        st.setString(9, equipo.getPatente_equipo());
        st.setString(10, equipo.getId_radio());
        st.setString(11, equipo.getProvincia_equipo());
        st.setString(12, equipo.getNombre_modelo_id());
        st.setString(13, equipo.getSerie_equipo());  // Agrega el valor para el parámetro de comparación WHERE
        st.executeUpdate();
        st.close();
    } catch(Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }
           
    @Override
    public com.mycompany.models.Equipo getusuariobyserie(String serie_equipo) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM equipo WHERE serie_equipo = ?");
        st.setString(1, serie_equipo);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            Equipo equipo = new Equipo();
            equipo.setSerie_equipo(rs.getString("serie_equipo"));
            equipo.setNumero_equipo(rs.getInt("numero_equipo"));
            equipo.setUbicacion_equipo(rs.getString("ubicacion_equipo"));
            equipo.setResponsable_equipo(rs.getString("responsable_equipo"));
            equipo.setUsuario_final(rs.getString("usuario_final"));
            equipo.setOrden_compra(rs.getString("orden_compra"));
            equipo.setLicitacion(rs.getString("licitacion_equipo"));
            equipo.setEstado_equipo(rs.getString("estado_equipo"));
            equipo.setPatente_equipo(rs.getString("patente_equipo"));
            equipo.setId_radio(rs.getString("id_radio"));
            equipo.setProvincia_equipo(rs.getString("provincia_equipo"));
            equipo.setNombre_modelo_id(rs.getString("nombre_modelo_id"));

            return equipo;
        }

        return null; // Retorna null si no se encuentra ningún equipo con la serie proporcionada

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener equipo por serie: " + e.getMessage());
        throw e; // Puedes lanzar la excepción nuevamente si es necesario
    } finally {
        this.Cerrar();
    }
    }
    public List<com.mycompany.models.Equipo> buscarEquipos(String valor1, String valor2, String valor3, String valor4, String valor5,
                                   String valor6, String valor7, String valor8, String valor9, String valor10,
                                   String valor11, String valor12) throws Exception {
    try {
        this.Conectar();

        // Construir la consulta SQL con todos los campos que deseas buscar
        String sql = "SELECT * FROM equipo "
                   + "WHERE serie_equipo LIKE ? OR "
                   + "numero_equipo LIKE ? OR "
                   + "ubicacion_equipo LIKE ? OR "
                   + "responsable_equipo LIKE ? OR "
                   + "usuario_final LIKE ? OR "
                   + "orden_compra LIKE ? OR "
                   + "licitacion_equipo LIKE ? OR "
                   + "estado_equipo LIKE ? OR "
                   + "patente_equipo LIKE ? OR "
                   + "id_radio LIKE ? OR "
                   + "provincia_equipo LIKE ? OR "
                   + "nombre_modelo_id LIKE ?";

        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {
            // Establecer el valor del parámetro para cada campo
            pstmt.setString(1, "%" + valor1 + "%");
            pstmt.setString(2, "%" + valor2 + "%");
            pstmt.setString(3, "%" + valor3 + "%");
            pstmt.setString(4, "%" + valor4 + "%");
            pstmt.setString(5, "%" + valor5 + "%");
            pstmt.setString(6, "%" + valor6 + "%");
            pstmt.setString(7, "%" + valor7 + "%");
            pstmt.setString(8, "%" + valor8 + "%");
            pstmt.setString(9, "%" + valor9 + "%");
            pstmt.setString(10, "%" + valor10 + "%");
            pstmt.setString(11, "%" + valor11 + "%");
            pstmt.setString(12, "%" + valor12 + "%");

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Crear una lista para almacenar los resultados
            List<Equipo> resultados = new ArrayList<>();

            // Iterar sobre los resultados y construir objetos Equipo
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setSerie_equipo(rs.getString("serie_equipo"));
                equipo.setNumero_equipo(rs.getInt("numero_equipo"));
                equipo.setUbicacion_equipo(rs.getString("ubicacion_equipo"));
                equipo.setResponsable_equipo(rs.getString("responsable_equipo"));
                equipo.setUsuario_final(rs.getString("usuario_final"));
                equipo.setOrden_compra(rs.getString("orden_compra"));
                equipo.setLicitacion(rs.getString("licitacion_equipo"));
                equipo.setEstado_equipo(rs.getString("estado_equipo"));
                equipo.setPatente_equipo(rs.getString("patente_equipo"));
                equipo.setId_radio(rs.getString("id_radio"));
                equipo.setProvincia_equipo(rs.getString("provincia_equipo"));
                equipo.setNombre_modelo_id(rs.getString("nombre_modelo_id"));

                resultados.add(equipo);
            }

            return resultados;
        }

    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public List<Equipo> listar() throws Exception {
         try {
        this.Conectar();
        String sql = "SELECT * FROM equipo";
        
        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<Equipo> equipos = new ArrayList<>();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                // Configurar las propiedades del objeto Equipo según los campos de la tabla
                equipo.setSerie_equipo(rs.getString("serie_equipo"));
                equipo.setNumero_equipo(rs.getInt("numero_equipo"));
                equipo.setUbicacion_equipo(rs.getString("ubicacion_equipo"));
                equipo.setResponsable_equipo(rs.getString("responsable_equipo"));
                equipo.setUsuario_final(rs.getString("usuario_final"));
                equipo.setOrden_compra(rs.getString("orden_compra"));
                equipo.setLicitacion(rs.getString("licitacion_equipo"));
                equipo.setEstado_equipo(rs.getString("estado_equipo"));
                equipo.setPatente_equipo(rs.getString("patente_equipo"));
                equipo.setId_radio(rs.getString("id_radio"));
                equipo.setProvincia_equipo(rs.getString("provincia_equipo"));
                equipo.setNombre_modelo_id(rs.getString("nombre_modelo_id"));

                equipos.add(equipo);
            }

            return equipos;
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al listar equipos: " + e.getMessage());
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public void cargarDesdeExcel(File archivoExcel) throws Exception {
         try (FileInputStream fileInputStream = new FileInputStream(archivoExcel);
         Workbook workbook = new XSSFWorkbook(fileInputStream)) {

        Sheet sheet = workbook.getSheetAt(0);

        // Itera sobre las filas del archivo Excel
        int numRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < numRows; i++) {  // Empieza desde 1 para omitir la fila de encabezados
            org.apache.poi.ss.usermodel.Row row = sheet.getRow(i);

            // Lee datos de cada celda y asigna a variables
            String serieEquipo = getStringValue(row.getCell(0));
            
            // Verifica si la serie_equipo está duplicada
            if (serieEquipoExiste(serieEquipo)) {
                System.out.println("Equipo con serie duplicada: " + serieEquipo);
                continue;  // Salta a la siguiente iteración si la serie está duplicada
            }

            int numeroEquipo = getNumericValue(row.getCell(1));
            String ubicacionEquipo = getStringValue(row.getCell(2));
            String responsableEquipo = getStringValue(row.getCell(3));
            String usuarioFinal = getStringValue(row.getCell(4));
            String ordenCompra = getStringValue(row.getCell(5));
            String licitacionEquipo = getStringValue(row.getCell(6));
            String estadoEquipo = getStringValue(row.getCell(7));
            String patenteEquipo = getStringValue(row.getCell(8));
            String idRadio = getStringValue(row.getCell(9));
            String provinciaEquipo = getStringValue(row.getCell(10));
            String nombreModeloId = getStringValue(row.getCell(11));

            // Crea un objeto Equipo y asigna los valores
            Equipo equipo = new Equipo();
            equipo.setSerie_equipo(serieEquipo);
            equipo.setNumero_equipo(numeroEquipo);
            equipo.setUbicacion_equipo(ubicacionEquipo);
            equipo.setResponsable_equipo(responsableEquipo);
            equipo.setUsuario_final(usuarioFinal);
            equipo.setOrden_compra(ordenCompra);
            equipo.setLicitacion(licitacionEquipo);
            equipo.setEstado_equipo(estadoEquipo);
            equipo.setPatente_equipo(patenteEquipo);
            equipo.setId_radio(idRadio);
            equipo.setProvincia_equipo(provinciaEquipo);
            equipo.setNombre_modelo_id(nombreModeloId);

            // Registra el equipo en la base de datos
            registrar(equipo);
        }
    } catch (IOException | OfficeXmlFileException e) {
        // Manejo específico de excepciones
        throw e;
    }
}

private boolean serieEquipoExiste(String serieEquipo) throws SQLException {
    try {
        this.Conectar();
        String sql = "SELECT COUNT(*) FROM equipo WHERE serie_equipo = ?";
        
        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {
            pstmt.setString(1, serieEquipo);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.Cerrar();
    }

    return false;
}

private String getStringValue(Cell cell) {
    // Revisa el tipo de celda y obtén el valor correspondiente
    if (cell != null) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Formatea el valor numérico como cadena
                return String.valueOf(cell.getNumericCellValue());
            default:
                // Agrega casos adicionales según sea necesario (BOOLEAN, FORMULA, etc.)
                return "0";
        }
    } else {
        return "0"; // Devuelve "0" en lugar de cadena vacía para celdas nulas
    }
}

private int getNumericValue(Cell cell) {
    // Revisa el tipo de celda y obtén el valor correspondiente
    if (cell != null) {
        switch (cell.getCellType()) {
            case NUMERIC:
                // Devuelve el valor numérico como entero
                return (int) cell.getNumericCellValue();
            default:
                // Puedes ajustar este valor predeterminado según sea necesario
                return 0;
        }
    } else {
        return 0;
    }
}
    

    @Override
    public void exportarAExcel(File archivoExcel) throws Exception {
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(archivoExcel)) {
            Sheet sheet = workbook.createSheet("DatosEquipos");

            // Crear la fila de encabezados
            org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);
            String[] headers = {"Serie Equipo", "Número Equipo", "Ubicación Equipo", "Responsable Equipo",
                    "Usuario Final", "Orden Compra", "Licitación Equipo", "Estado Equipo", "Patente Equipo", "ID Radio",
                    "Provincia Equipo", "Nombre Modelo ID"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Obtener datos de la base de datos
            List<Equipo> equipos = listar();

            // Rellenar filas con datos
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

            // Escribir el libro al archivo
            workbook.write(fileOut);

        } catch (Exception e) {
            throw e;
        }
    }

    private List<String> obtenerEquiposExistentes(File archivoExcel) {
        List<String> equiposExistentes = new ArrayList<>();

    try (FileInputStream fileInputStream = new FileInputStream(archivoExcel);
         Workbook workbook = new XSSFWorkbook(fileInputStream)) {

        Sheet sheet = workbook.getSheetAt(0);

        // Itera sobre las filas del archivo Excel
        int numRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < numRows; i++) {  // Empieza desde 1 para omitir la fila de encabezados
            org.apache.poi.ss.usermodel.Row row = sheet.getRow(i);

            // Lee la serie de cada equipo y agrega a la lista de equipos existentes
            String serieEquipo = getStringValue(row.getCell(0));
            equiposExistentes.add(serieEquipo);
        }
    } catch (Exception e) {
        // Maneja la excepción según tus necesidades
        e.printStackTrace();
    }

    return equiposExistentes;
    }
    }

    



