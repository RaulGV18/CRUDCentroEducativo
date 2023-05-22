/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raúl
 */
public interface UsuarioDao {
    int add (usuario u) throws SQLException;
    usuario getById(int id);
    List<usuario> getAll() throws SQLException;
    int update(usuario u) throws SQLException;
    void delete(int id) throws SQLException;
    boolean valida(String usuario,String password) throws SQLException;
}
