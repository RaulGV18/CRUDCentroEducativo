/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import com.iesiliberis.crudcentroeducativo.entidades.autorizado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface autorizadoDao {
    int add (autorizado a) throws SQLException;
    autorizado getById(int id);
    List<autorizado> getAll() throws SQLException;
    int update(autorizado a) throws SQLException;
    void delete(int id) throws SQLException;
    alumno devolvAlumno(autorizado a) throws SQLException;
    autorizado devolvAutorizadodni(String DNI);
    void addautorizado(int idalumno,int idautorizado);
}
