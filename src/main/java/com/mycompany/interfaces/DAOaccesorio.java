package com.mycompany.interfaces;

import com.mycompany.models.Accesorio;
import java.util.List;

public interface DAOaccesorio {
    public void registrar(Accesorio accesorio ) throws Exception;
    public void modificar(Accesorio accesorio) throws Exception;
    // public void eliminar(int numero_equipo) throws Exception;
    public List <Accesorio> list() throws Exception;
    public Accesorio getaccesorio(String nombre_accesorio) throws Exception;
     public void actualizarStock(String nombre_accesorio, int nuevo_stock) throws Exception;
    
    
}
    

