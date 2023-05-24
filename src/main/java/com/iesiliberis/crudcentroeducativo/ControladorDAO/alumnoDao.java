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
public interface alumnoDao {
    int add (alumno a) throws SQLException;
    alumno getById(int id);
    List<alumno> getAll() throws SQLException;
    int update(alumno C) throws SQLException;
    void delete(int id) throws SQLException;
    List<autorizado> getautorizados(int id);
    List<alumno> getalumnoscurso(int id);
    List<alumno> getalumnosnotincurso(int id);
    
}
