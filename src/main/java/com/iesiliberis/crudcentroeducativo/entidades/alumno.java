/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Raúl
 */
public class alumno {
    private int id; 
    private String nombre;
    private String apellido1;  
    private String apellido2;  
    private Date fNacimiento; 
    private int telefono; 
    private String email;
    private String dni; 
    private String direccion;
    private String poblacion;
    private String provincia; 
    private String cp;

    public alumno(String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String email, String dni, String direccion, String poblacion, String provincia, String cp) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fNacimiento = fNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.cp = cp;
    }

    public alumno(int id, String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String email, String dni, String direccion, String poblacion, String provincia, String cp) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fNacimiento = fNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.cp = cp;
    }

    public alumno(String nombre, String apellido1, String apellido2, int telefono, String email, String dni, String direccion, String poblacion, String provincia, String cp) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.cp = cp;
    }
    
    

    public alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.dni);
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
        final alumno other = (alumno) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.dni, other.dni);
    }
    

    
}
