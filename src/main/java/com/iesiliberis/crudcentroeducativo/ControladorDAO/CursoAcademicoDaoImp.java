/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raúl
 */
public class CursoAcademicoDaoImp implements CursoAcademicoDAO {
    private static CursoAcademicoDaoImp instance;
    
    static{
        instance=new CursoAcademicoDaoImp();
    }
    
    public CursoAcademicoDaoImp(){
        
    }
    
    public static CursoAcademicoDaoImp getInstance(){
        return instance;
    }
    
    
    @Override
    public int add(cursoacademico c) throws SQLException {
        String sql="insert into cursoacademico(yearinicio,yearfin,descripcion) values (?,?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, c.getYearinicio());
            pstmt.setInt(2, c.getYearfin());
            pstmt.setString(3, c.getDescripcion());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public cursoacademico getById(int id) {
        String sql="select * from cursoacademico where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                cursoacademico curs = new cursoacademico();
                curs.setId(rs.getInt("id"));
                curs.setYearinicio(rs.getInt("yearinicio"));
                curs.setYearfin(rs.getInt("yearfin"));
                curs.setDescripcion(rs.getString("descripcion"));
                pstmt.close();
                cn.close();
                return curs;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<cursoacademico> getAll() throws SQLException {
         String sql = "Select * from centroeducativo.cursoacademico order by yearinicio desc";
        List <cursoacademico> lista = new ArrayList <cursoacademico>();
        
        int cont = 0;
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new cursoacademico(rs.getInt("yearinicio"), rs.getInt("yearfin"), rs.getString("descripcion")));
                lista.get(cont).setId(rs.getInt("id"));
                cont++;
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(cursoacademico C) throws SQLException {
                
         String sql="update cursoacademico set yearinicio=?,yearfin=?,descripcion=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, C.getYearinicio());
            pstmt.setInt(2, C.getYearfin());
            pstmt.setString(3, C.getDescripcion());
            pstmt.setInt(4, C.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        
         String sql="delete from cursoacademico where id=?;";
        
        
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
}
