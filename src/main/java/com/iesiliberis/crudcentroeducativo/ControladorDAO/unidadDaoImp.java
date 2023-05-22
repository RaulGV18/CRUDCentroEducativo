/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import com.iesiliberis.crudcentroeducativo.entidades.aula;
import com.iesiliberis.crudcentroeducativo.entidades.personal;
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
public class unidadDaoImp implements unidadDao {
    private static unidadDaoImp instance;
    
    static{
        instance=new unidadDaoImp();
    }
    
    public unidadDaoImp(){
        
    }
    
    public static unidadDaoImp getInstance(){
        return instance;
    }
    @Override
    public int add(unidad c) throws SQLException {
          String sql="insert into unidad(codigo,nombre,Observaciones,idcurso,idtutor,idaula) values (?,?,?,?,?,?);";
        
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, c.getCodigo());
            pstmt.setString(2, c.getNombre());
            pstmt.setString(3, c.getObservaciones());
            pstmt.setInt(4, c.getIdcurso());
            pstmt.setInt(5, c.getIdtutor());
            pstmt.setInt(6, c.getIdaula());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public unidad getById(int id) {
        String sql="select * from unidad where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                unidad a = new unidad();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setCodigo(rs.getString("codigo"));
                a.setObservaciones(rs.getString("Observaciones"));
                a.setIdcurso(rs.getInt("idcurso"));
                a.setIdtutor(rs.getInt("idtutor"));
                a.setIdaula(rs.getInt("idaula"));
                pstmt.close();
                cn.close();
                return a;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<unidad> getAll() throws SQLException {
                String sql = "Select * from centroeducativo.unidad";
        List <unidad> lista = new ArrayList <>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new unidad(rs.getInt("id"),rs.getString("codigo"),rs.getString("nombre"), rs.getString("Observaciones"),rs.getInt("idcurso"),rs.getInt("idtutor"),rs.getInt("idaula")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(unidad U) throws SQLException {
        String sql="update unidad set codigo=?,nombre=?,Observaciones=?,idcurso=?,idtutor=?,idaula=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, U.getCodigo());
            pstmt.setString(2, U.getNombre());
            pstmt.setString(3, U.getObservaciones());
            pstmt.setInt(4, U.getIdcurso());
            pstmt.setInt(5, U.getIdtutor());
            pstmt.setInt(6, U.getIdaula());
            pstmt.setInt(7, U.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from unidad where id=?;";
        
        
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
    public List<alumno> getalumnosbyid(int id) {
        String sql = "Select a.* from alumno a join matricula m where a.id=m.idalumno and m.idunidad=?";
        List <alumno> lista = new ArrayList <>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new alumno(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"),rs.getDate("fNacimiento"),Integer.parseInt(rs.getString("Telefono")),rs.getString("email"),rs.getString("dni"),rs.getString("direccion"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("cp")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public aula getaula(int id) {
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
    public personal getTutor(int id) {
       String sql="select * from personal where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                personal a = new personal();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido1(rs.getString("apellido1"));
                a.setApellido2(rs.getString("apellido2"));
                a.setTipo(rs.getInt("tipo"));
                a.setTelefono(rs.getString("telefono"));
                a.setEmail(rs.getString("email"));
                a.setDni(rs.getString("dni"));
                a.setDireccion(rs.getString("direccion"));
                a.setPoblacion(rs.getString("poblacion"));
                a.setProvincia(rs.getString("provincia"));
                a.setCp(rs.getString("cp"));
                pstmt.close();
                cn.close();
                return a;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }
    
}
