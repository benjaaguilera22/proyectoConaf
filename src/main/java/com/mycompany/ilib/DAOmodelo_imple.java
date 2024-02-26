
package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOmodelo_equipo;
import com.mycompany.models.modelo_equipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOmodelo_imple extends Database implements DAOmodelo_equipo {

    @Override
    public void registrar(modelo_equipo m_equipo) throws Exception {
        try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("INSERT INTO modelo_equipo (nombre_modelo) VALUES (?)");
        st.setString(1, m_equipo.getNombre_modelo());
        st.executeUpdate();
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }
    }

    @Override
    public void modificar(modelo_equipo m_equipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<modelo_equipo> listar() throws Exception {
        List<modelo_equipo> listaModelos = new ArrayList<>();

    try {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM modelo_equipo");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            modelo_equipo modeloEquipo = new modelo_equipo();
            modeloEquipo.setId_modelo(rs.getInt("id_modelo"));
            modeloEquipo.setNombre_modelo(rs.getString("nombre_modelo"));

            listaModelos.add(modeloEquipo);
        }
    } catch (Exception e) {
        throw e;
    } finally {
        this.Cerrar();
    }

    return listaModelos;
}
    }
    

