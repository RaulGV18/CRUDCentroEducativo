/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.aula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface aulaDao {
    int add (aula a) throws SQLException;
    aula getById(int id);
    List<aula> getAll() throws SQLException;
    int update(aula a) throws SQLException;
    void delete(int id) throws SQLException;
}
