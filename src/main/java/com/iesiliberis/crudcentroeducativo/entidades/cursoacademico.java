/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

/**
 *
 * @author Raúl
 */
public class cursoacademico {
    private int id;
    private int yearinicio;
    private int yearfin;
    private String Descripcion;

    public cursoacademico(int yearinicio, int yearfin, String Descripcion) {
        this.yearinicio = yearinicio;
        this.yearfin = yearfin;
        this.Descripcion = Descripcion;
    }

    public cursoacademico(int id, int yearinicio, int yearfin, String Descripcion) {
        this.id = id;
        this.yearinicio = yearinicio;
        this.yearfin = yearfin;
        this.Descripcion = Descripcion;
    }
    

    public cursoacademico() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearinicio() {
        return yearinicio;
    }

    public void setYearinicio(int yearinicio) {
        this.yearinicio = yearinicio;
    }

    public int getYearfin() {
        return yearfin;
    }

    public void setYearfin(int yearfin) {
        this.yearfin = yearfin;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "CursoAcademico{" + "id=" + id + ", yearinicio=" + yearinicio + ", yearfin=" + yearfin + ", Descripcion=" + Descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.yearinicio;
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
        final cursoacademico other = (cursoacademico) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.yearinicio == other.yearinicio;
    }
    
}
