
package com.mycompany.interfaces;

import com.mycompany.models.modelo_equipo;
import java.util.List;


public interface DAOmodelo_equipo {
    public void registrar(modelo_equipo m_equipo) throws Exception;
    public void modificar(modelo_equipo m_equipo) throws Exception;
   // public void eliminar(reporte_equipo reporte) throws Exception;
    public List <modelo_equipo> listar() throws Exception;
    
}
