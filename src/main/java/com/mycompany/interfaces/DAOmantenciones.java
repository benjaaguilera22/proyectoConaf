package com.mycompany.interfaces;

import com.mycompany.models.mantenciones;
import java.util.List;

public interface DAOmantenciones {
    public void registrar(mantenciones mantencion) throws Exception;
    public void modificar(mantenciones mantencion) throws Exception;
   // public void eliminar(reporte_equipo reporte) throws Exception;
    public List <mantenciones> listar() throws Exception;
    public void actualizarFechaMantencion(int idMantencion, String nuevaFecha) throws Exception;

}   

