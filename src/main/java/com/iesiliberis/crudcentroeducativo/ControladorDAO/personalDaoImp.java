/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.personal;
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
public class personalDaoImp implements personalDao {
    private static personalDaoImp instance;
    
    static{
        instance=new personalDaoImp();
    }
    
    public personalDaoImp(){
        
    }
    
    public static personalDaoImp getInstance(){
        return instance;
    }
    @Override
    public int add(personal per) throws SQLException {
           String sql="insert into personal(dni,nombre,apellido1,apellido2,direccion,poblacion,provincia,cp,telefono,email,tipo) values (?,?,?,?,?,?,?,?,?,?,?);";
        
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, per.getDni());
            pstmt.setString(2, per.getNombre());
            pstmt.setString(3, per.getApellido1());
            pstmt.setString(4, per.getApellido2());
            pstmt.setString(5, per.getDireccion());
            pstmt.setString(6, per.getPoblacion());
            pstmt.setString(7, per.getProvincia());
            pstmt.setString(8, per.getCp());
            pstmt.setString(9, per.getTelefono());
            pstmt.setString(10, per.getEmail());
            pstmt.setInt(11, per.getTipo());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }
    


    @Override
    public personal getById(int id) {
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

    @Override
    public List<personal> getAll() throws SQLException {
        String sql = "Select * from centroeducativo.personal";
        List <personal> lista = new ArrayList <>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new personal(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("Telefono"),rs.getString("email"),rs.getInt("tipo")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(personal A) throws SQLException {
        String sql="update personal set dni=?,nombre=?,apellido1=?,apellido2=?,direccion=?,cp=?,poblacion=?,provincia=?,telefono=?,email=?,tipo=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, A.getDni());
            pstmt.setString(2, A.getNombre());
            pstmt.setString(3, A.getApellido1());
            pstmt.setString(4, A.getApellido2());
            pstmt.setString(9, A.getTelefono());
            pstmt.setString(10, A.getEmail());
            pstmt.setString(5, A.getDireccion());
            pstmt.setString(7, A.getPoblacion());
            pstmt.setString(8, A.getProvincia());
            pstmt.setString(6, A.getCp());
            pstmt.setInt(11, A.getTipo());
            pstmt.setInt(12, A.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from personal where id=?;";
        
        
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
    public List<personal> getProfesores() {
        String sql = "Select * from centroeducativo.personal where tipo=1";
        List <personal> lista = new ArrayList <>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new personal(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("Telefono"),rs.getString("email"),rs.getInt("tipo")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<personal> getPersonal() {
        String sql = "Select * from centroeducativo.personal where tipo=0";
        List <personal> lista = new ArrayList <>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new personal(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("Telefono"),rs.getString("email"),rs.getInt("tipo")));
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }
    }

