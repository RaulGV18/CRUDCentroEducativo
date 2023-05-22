/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

import java.util.Objects;

/**
 *
 * @author Raúl
 */
public class curso {
    int id;
    String Codigo;
    String nombre;
    String observaciones;
    int idcursoacademico;

    public curso(String Codigo, String nombre, String observaciones,int idcurso) {
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.idcursoacademico=idcurso;
    }
      public curso(int id,String Codigo, String nombre, String observaciones,int idcurso) {
        this.id=id;
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.idcursoacademico=idcurso;
    }

    public curso() {
    }
      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdcursoacademico() {
        return idcursoacademico;
    }

    public void setIdcursoacademico(int idcursoacademico) {
        this.idcursoacademico = idcursoacademico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.Codigo);
        hash = 29 * hash + this.idcursoacademico;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final curso other = (curso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idcursoacademico != other.idcursoacademico) {
            return false;
        }
        return Objects.equals(this.Codigo, other.Codigo) && Objects.equals(this.idcursoacademico, other.idcursoacademico);
        
    }

    @Override
    public String toString() {
        return "curso{" + "id=" + id + ", Codigo=" + Codigo + ", nombre=" + nombre + ", observaciones=" + observaciones + ", idcursoacademico=" + idcursoacademico + '}';
    }
    
}
