/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface CursoAcademicoDAO {
    int add (cursoacademico c) throws SQLException;
    cursoacademico getById(int id);
    List<cursoacademico> getAll() throws SQLException;
    int update(cursoacademico C) throws SQLException;
    void delete(int id) throws SQLException;
    
    
}
