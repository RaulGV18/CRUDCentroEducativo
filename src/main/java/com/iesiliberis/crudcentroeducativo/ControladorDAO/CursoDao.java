/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import com.iesiliberis.crudcentroeducativo.entidades.curso;
import com.iesiliberis.crudcentroeducativo.entidades.unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface CursoDao {
    int add (curso c) throws SQLException;
    curso getById(int id);
    List<curso> getAll() throws SQLException;
    List<curso> getAllByCursoAcademico(int idcursaca) throws SQLException;
    int update(curso c) throws SQLException;
    void delete(int id) throws SQLException;
    cursoacademico devolvCurso(curso c) throws SQLException;
    List<unidad> getunidades(int id);
}
