package com.mycompany.models;



public class mantenciones {
    private int id_mantencion;
    private String serie_equipo;
    private String fecha_mantencion;
    private String comentario;

    public void setId_mantencion(int id_mantencion) {
        this.id_mantencion = id_mantencion;
    }

    public void setSerie_equipo(String serie_equipo) {
        this.serie_equipo = serie_equipo;
    }

    public void setFecha_mantencion(String fecha_mantencion) {
        this.fecha_mantencion = fecha_mantencion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_mantencion() {
        return id_mantencion;
    }

    public String getSerie_equipo() {
        return serie_equipo;
    }

    public String getFecha_mantencion() {
        return fecha_mantencion;
    }

    public String getComentario() {
        return comentario;
    }
    
}

    