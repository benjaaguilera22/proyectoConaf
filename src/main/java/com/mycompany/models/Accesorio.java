package com.mycompany.models;


public class Accesorio {
    private int id_accesorio;
    private String nombre_accesorio;
    private String codigo_modelo;
    private int stock_accesorio;
    private String codigo_modelo_a;

    public void setCodigo_modelo_a(String codigo_modelo_a) {
        this.codigo_modelo_a = codigo_modelo_a;
    }

    public void setId_accesorio(int id_accesorio) {
        this.id_accesorio = id_accesorio;
    }

    public String getCodigo_modelo_a() {
        return codigo_modelo_a;
    }

    public void setNombre_accesorio(String nombre_accesorio) {
        this.nombre_accesorio = nombre_accesorio;
    }

    public void setCodigo_modelo(String codigo_modelo) {
        this.codigo_modelo = codigo_modelo;
    }

    public void setStock_accesorio(int stock_accesorio) {
        this.stock_accesorio = stock_accesorio;
    }

    public int getId_accesorio() {
        return id_accesorio;
    }

    public String getNombre_accesorio() {
        return nombre_accesorio;
    }

    public String getCodigo_modelo() {
        return codigo_modelo;
    }

    public int getStock_accesorio() {
        return stock_accesorio;
    }
    
    
}
