/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.autorizaciones;
import java.sql.SQLException;

/**
 *
 * @author Raúl
 */
public interface autorizacionesDao {
    int add (autorizaciones a) throws SQLException;
    void delete(int idalumno,int idautorizado) throws SQLException;
}
