/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.aula;
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
public class aulaDaoImp implements aulaDao {
    private static aulaDaoImp instance;
    
    static{
        instance=new aulaDaoImp();
    }
    
    public aulaDaoImp(){
        
    }
    
    public static aulaDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(aula a) throws SQLException {
        String sql="insert into aula(codigo,descripcion) values (?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, a.getCodigo());
            pstmt.setString(2, a.getDescripcion());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public aula getById(int id) {
        String sql="select * from aula where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                aula au = new aula();
                au.setId(rs.getInt("id"));
                au.setCodigo(rs.getString("codigo"));
                au.setDescripcion(rs.getString("descripcion"));
                pstmt.close();
                cn.close();
                return au;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<aula> getAll() throws SQLException {
        String sql = "Select * from centroeducativo.aula";
        List <aula> lista = new ArrayList <aula>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new aula(rs.getInt("id"),rs.getString("codigo"),rs.getString("descripcion")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(aula a) throws SQLException {
        String sql="update aula set codigo=?,descripcion=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, a.getCodigo());
            pstmt.setString(2, a.getDescripcion());
            pstmt.setInt(3, a.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from aula where id=?;";
        
        
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
