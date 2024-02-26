package com.mycompany.interfaces;

import com.mycompany.models.Equipo;
import java.io.File;
import java.util.List;


public interface DAOequipo {
    public void registrar(Equipo equipo) throws Exception;
    public void modificar(Equipo equipo) throws Exception;
    public List <Equipo> listar() throws Exception;
    public Equipo getusuariobyserie(String serie_equipo) throws Exception;
    public List<Equipo> buscarEquipos(String valor1, String valor2, String valor3, String valor4, String valor5,
                                   String valor6, String valor7, String valor8, String valor9, String valor10,
                                   String valor11, String valor12) throws Exception;
    void cargarDesdeExcel(File archivoExcel) throws Exception;
    void exportarAExcel(File archivoExcel) throws Exception;
    
    
    
    
    
}
