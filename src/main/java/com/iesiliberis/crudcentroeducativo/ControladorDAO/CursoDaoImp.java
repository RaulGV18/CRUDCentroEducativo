/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import com.iesiliberis.crudcentroeducativo.entidades.curso;
import com.iesiliberis.crudcentroeducativo.entidades.unidad;
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
public class CursoDaoImp implements CursoDao {
    private static CursoDaoImp instance;
    
    static{
        instance=new CursoDaoImp();
    }
    
    public CursoDaoImp(){
        
    }
    
    public static CursoDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(curso c) throws SQLException {
        String sql="insert into curso(codigo,nombre,observaciones,idcursoacademico) values (?,?,?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, c.getCodigo());
            pstmt.setString(2, c.getNombre());
            pstmt.setString(3, c.getObservaciones());
            pstmt.setInt(4, c.getIdcursoacademico());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public curso getById(int id) {
        String sql="select * from curso where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                curso curs = new curso();
                curs.setId(rs.getInt("id"));
                curs.setCodigo(rs.getString("codigo"));
                curs.setNombre(rs.getString("nombre"));
                curs.setObservaciones(rs.getString("Observaciones"));
                curs.setIdcursoacademico(rs.getInt("idcursoacademico"));
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
    public List<curso> getAll() throws SQLException {
        String sql = "Select * from centroeducativo.curso";
        List <curso> lista = new ArrayList <curso>();
        
        int cont = 0;
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new curso(rs.getInt("id"),rs.getString("codigo"),rs.getString("nombre"),rs.getString("Observaciones"),rs.getInt("idcursoacademico")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(curso c) throws SQLException {
        String sql="update curso set codigo=?,nombre=?,observaciones=?,idcursoacademico=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, c.getCodigo());
            pstmt.setString(2, c.getNombre());
            pstmt.setString(3, c.getObservaciones());
            pstmt.setInt(4, c.getIdcursoacademico());
            pstmt.setInt(5, c.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from curso where id=?;";
        
        
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
    public cursoacademico devolvCurso(curso c) throws SQLException {
        String sql="select * from cursoacademico where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, c.getIdcursoacademico());
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
    public List<curso> getAllByCursoAcademico(int idcursaca) throws SQLException {
        String sql = "Select * from centroeducativo.curso where idcursoacademico=?";
        List <curso> lista = new ArrayList <>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idcursaca);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new curso(rs.getInt("id"),rs.getString("codigo"),rs.getString("nombre"),rs.getString("Observaciones"),idcursaca));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<unidad> getunidades(int id) {
        String sql = "Select * from centroeducativo.unidad where idcurso=?";
        List <unidad> lista = new ArrayList <>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new unidad(rs.getInt("id"),rs.getString("codigo"),rs.getString("nombre"), rs.getString("Observaciones"),rs.getInt("idcurso"),rs.getInt("idtutor"),rs.getInt("idaula")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }
    
}
