/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.personal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface personalDao {
    int add (personal per) throws SQLException;
    personal getById(int id);
    List<personal> getAll() throws SQLException;
    int update(personal C) throws SQLException;
    void delete(int id) throws SQLException;
    List<personal> getProfesores();
    List<personal> getPersonal();
}
