/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.autorizaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raúl
 */
public class autorizacionesDaoImp implements autorizacionesDao {

    @Override
    public int add(autorizaciones a) throws SQLException {
                String sql="insert into autorizado(idalumno,idautorizado) values (?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, a.getIdalumno());
            pstmt.setInt(2, a.getIdautorizado());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int idalumno, int idautorizado) throws SQLException {
            String sql="delete from autorizado where idalumno=?,idautorizado=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, idalumno);
            pstmt.setInt(2, idautorizado);
            pstmt.executeUpdate();
            System.out.println("eliminado correctamente");
            pstmt.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            
        }
    }
    
}
