/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

/**
 *
 * @author Raúl
 */
public class unidad {
    private int id;
    private String codigo;
    private String Nombre;
    private String Observaciones;
    private int idcurso;
    private int idtutor;
    private int idaula;

    public unidad(int id, String codigo, String Nombre, String Observaciones, int idcurso, int idtutor, int idaula) {
        this.id = id;
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Observaciones = Observaciones;
        this.idcurso = idcurso;
        this.idtutor = idtutor;
        this.idaula = idaula;
    }

    public unidad(String codigo, String Nombre, String Observaciones, int idcurso, int idtutor, int idaula) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Observaciones = Observaciones;
        this.idcurso = idcurso;
        this.idtutor = idtutor;
        this.idaula = idaula;
    }

    public unidad(int id,String codigo, String Nombre, String Observaciones, int idcurso) {
        this.id=id;
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Observaciones = Observaciones;
        this.idcurso = idcurso;
    }
    

    public unidad() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }
    
}
