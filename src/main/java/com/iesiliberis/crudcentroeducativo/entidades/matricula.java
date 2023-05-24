/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

import java.sql.Date;

/**
 *
 * @author Raúl
 */
public class matricula {
    int id,idalumno,idunidad;
    String descripcion;
    Date fMatricula,fBaja;

    public matricula(int idalumno, int idunidad, String descripcion, Date fMatricula, Date fBaja) {
        this.idalumno = idalumno;
        this.idunidad = idunidad;
        this.descripcion = descripcion;
        this.fMatricula = fMatricula;
        this.fBaja = fBaja;
    }

    public matricula(int id, int idalumno, int idunidad, String descripcion, Date fMatricula, Date fBaja) {
        this.id = id;
        this.idalumno = idalumno;
        this.idunidad = idunidad;
        this.descripcion = descripcion;
        this.fMatricula = fMatricula;
        this.fBaja = fBaja;
    }

    public matricula() {
    }

    public matricula(int id, int idalumno, int idunidad, String descripcion, Date fMatricula) {
        this.id = id;
        this.idalumno = idalumno;
        this.idunidad = idunidad;
        this.descripcion = descripcion;
        this.fMatricula = fMatricula;
    }

    public matricula(int idalumno, int idunidad, String descripcion, Date fMatricula) {
        this.idalumno = idalumno;
        this.idunidad = idunidad;
        this.descripcion = descripcion;
        this.fMatricula = fMatricula;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(int idunidad) {
        this.idunidad = idunidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getfMatricula() {
        return fMatricula;
    }

    public void setfMatricula(Date fMatricula) {
        this.fMatricula = fMatricula;
    }

    public Date getfBaja() {
        return fBaja;
    }

    public void setfBaja(Date fBaja) {
        this.fBaja = fBaja;
    }
    
    
}
