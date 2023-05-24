/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.matricula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface matriculaDao {
    int add (matricula mat) throws SQLException;
    matricula getById(int id);
    List<matricula> getAll() throws SQLException;
    int update(matricula mat) throws SQLException;
    void delete(int id) throws SQLException;
    matricula getbyAlumnoycurso(int idalumno,int idunidad) throws SQLException;
}
