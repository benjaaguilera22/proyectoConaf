
package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOaccesorio;
import com.mycompany.models.Accesorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOaccesorio_imple extends Database implements DAOaccesorio{

    @Override
    public void registrar(Accesorio accesorio) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("INSERT INTO accesorio (id_accesorio, nombre_accesorio, codigo_modelo, stock_accesorio,codigo_modelo_a) VALUES (?, ?, ?, ?,?)");
        st.setInt(1, accesorio.getId_accesorio());
        st.setString(2, accesorio.getNombre_accesorio());
        st.setString(3, accesorio.getCodigo_modelo());
        st.setInt(4, accesorio.getStock_accesorio());
        st.setString(5,accesorio.getCodigo_modelo_a());
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public void modificar(Accesorio accesorio) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("UPDATE accesorio SET nombre_accesorio = ?, codigo_modelo = ?, stock_accesorio = ?, codigo_modelo_a = ? WHERE id_accesorio = ?");
        st.setString(1, accesorio.getNombre_accesorio());
        st.setString(2, accesorio.getCodigo_modelo());
        st.setInt(3, accesorio.getStock_accesorio());
        st.setString(4, accesorio.getCodigo_modelo_a());
        st.setInt(5, accesorio.getId_accesorio());
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public List<Accesorio> list() throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM accesorio");
        ResultSet rs = st.executeQuery();

        List<Accesorio> listaAccesorios = new ArrayList<>();

        while (rs.next()) {
            Accesorio accesorio = new Accesorio();
            accesorio.setId_accesorio(rs.getInt("id_accesorio"));
            accesorio.setNombre_accesorio(rs.getString("nombre_accesorio"));
            accesorio.setCodigo_modelo(rs.getString("codigo_modelo"));
            accesorio.setStock_accesorio(rs.getInt("stock_accesorio"));
            accesorio.setCodigo_modelo_a(rs.getString("codigo_modelo_a"));  // Corregido aquí

            listaAccesorios.add(accesorio);
        }

        return listaAccesorios;
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public Accesorio getaccesorio(String nombre_accesorio) throws Exception {
       try {
            this.Conectar();
            String sqlQuery = "SELECT * FROM accesorio WHERE nombre_accesorio = ?";
            try (PreparedStatement st = this.conexion.prepareStatement(sqlQuery)) {
                st.setString(1, nombre_accesorio);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        Accesorio accesorio = new Accesorio();
                        accesorio.setId_accesorio(rs.getInt("id_accesorio"));
                        accesorio.setNombre_accesorio(rs.getString("nombre_accesorio"));
                        accesorio.setCodigo_modelo(rs.getString("codigo_modelo"));
                        accesorio.setStock_accesorio(rs.getInt("stock_accesorio"));
                        accesorio.setCodigo_modelo_a(rs.getString("codigo_modelo_a"));

                        return accesorio;
                    } else {
                        throw new Exception("Accesorio no encontrado para el nombre accesorio : " + nombre_accesorio);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void actualizarStock(String nombre_accesorio, int nuevo_stock) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("UPDATE accesorio SET stock_accesorio = ? WHERE nombre_accesorio = ?");
        st.setInt(1, nuevo_stock);
        st.setString(2, nombre_accesorio);
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    
}
    
    

