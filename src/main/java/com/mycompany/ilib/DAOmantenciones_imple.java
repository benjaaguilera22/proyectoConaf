
package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOmantenciones;
import com.mycompany.models.mantenciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 
public class DAOmantenciones_imple extends Database implements DAOmantenciones{

    @Override
    public void registrar(mantenciones mantencion) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("INSERT INTO mantencion (serie_equipo, fecha_mantencion, comentario) VALUES (?, ?, ?)");
        st.setString(1, mantencion.getSerie_equipo());
        st.setString(2, mantencion.getFecha_mantencion());
        st.setString(3, mantencion.getComentario());
        st.executeUpdate();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public void modificar(mantenciones mantencion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<mantenciones> listar() throws Exception {
        List<mantenciones> lista = new ArrayList<>();

    try {
        this.Conectar();
        String query = "SELECT * FROM mantencion";
        PreparedStatement st = this.conexion.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            mantenciones mantencion = new mantenciones();
            mantencion.setId_mantencion(rs.getInt("id_mantencion"));
            mantencion.setSerie_equipo(rs.getString("serie_equipo"));
            mantencion.setFecha_mantencion(rs.getString("fecha_mantencion"));
            mantencion.setComentario(rs.getString("comentario"));

            lista.add(mantencion);
        }
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }

    return lista;
}

    @Override
    public void actualizarFechaMantencion(int idMantencion, String nuevaFecha) throws Exception {
         try {
        this.Conectar();
        String query = "UPDATE mantencion SET fecha_mantencion = ? WHERE id_mantencion = ?";
        PreparedStatement st = this.conexion.prepareStatement(query);
        st.setString(1, nuevaFecha);
        st.setInt(2, idMantencion);
        st.executeUpdate();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }
   }
    

