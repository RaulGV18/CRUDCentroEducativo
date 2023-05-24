/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raúl
 */
public class matriculaDaoImp implements matriculaDao {
     private static matriculaDaoImp instance;
    
    static{
        instance=new matriculaDaoImp();
    }
    public static matriculaDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(matricula mat) throws SQLException {
        String sql="insert into matricula(idalumno,idunidad,descripcion,fMatricula,fBaja) values (?,?,?,?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, mat.getIdalumno());
            pstmt.setInt(2, mat.getIdunidad());
            pstmt.setString(3, mat.getDescripcion());
            pstmt.setDate(4, mat.getfMatricula());
            pstmt.setDate(5, mat.getfBaja());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public matricula getById(int id) {
        String sql="select * from matricula where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                matricula mat = new matricula();
                mat.setId(rs.getInt("idmatricula"));
                mat.setIdalumno(rs.getInt("idalumno"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setfMatricula(rs.getDate("fMatricula"));
                mat.setfBaja(rs.getDate("fBaja"));
                pstmt.close();
                cn.close();
                return mat;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<matricula> getAll() throws SQLException {
        String sql="select * from matricula";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List <matricula> lista = new ArrayList <>();
            while (rs.next()){
                matricula mat = new matricula();
                mat.setId(rs.getInt("idmatricula"));
                mat.setIdalumno(rs.getInt("idalumno"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setfMatricula(rs.getDate("fMatricula"));
                mat.setfBaja(rs.getDate("fBaja"));
                lista.add(mat);
                return lista;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public int update(matricula mat) throws SQLException {
        String sql="update matricula set idalumno=?,idunidad=?,descripcion=?,fMatricula=?,fBaja=? where idmatricula=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, mat.getIdalumno());
            pstmt.setInt(2, mat.getIdunidad());
            pstmt.setString(3, mat.getDescripcion());
            pstmt.setDate(4, mat.getfMatricula());
            pstmt.setDate(5, mat.getfBaja());
            pstmt.setInt(6, mat.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from matricula where idmatricula=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("eliminado correctamente");
            pstmt.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            
        }
    }

    @Override
    public matricula getbyAlumnoycurso(int idalumno, int id) throws SQLException {
        String sql="select * from matricula where idalumno=? and idunidad=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, idalumno);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                matricula mat = new matricula();
                mat.setId(rs.getInt("idmatricula"));
                mat.setIdalumno(rs.getInt("idalumno"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setfMatricula(rs.getDate("fMatricula"));
                mat.setfBaja(rs.getDate("fBaja"));
                return mat;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }
    
}
