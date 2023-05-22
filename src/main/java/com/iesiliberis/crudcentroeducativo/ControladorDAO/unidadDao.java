/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import com.iesiliberis.crudcentroeducativo.entidades.aula;
import com.iesiliberis.crudcentroeducativo.entidades.personal;
import com.iesiliberis.crudcentroeducativo.entidades.unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface unidadDao {
    int add (unidad c) throws SQLException;
    unidad getById(int id);
    List<unidad> getAll() throws SQLException;
    int update(unidad U) throws SQLException;
    void delete(int id) throws SQLException;
    List<alumno> getalumnosbyid(int id);
    aula getaula(int id);
    personal getTutor(int id);
}
