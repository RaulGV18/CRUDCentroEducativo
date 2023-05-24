/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import com.iesiliberis.crudcentroeducativo.entidades.autorizado;
import com.iesiliberis.crudcentroeducativo.entidades.parentesco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raúl
 */
public class alumnoDaoImp implements alumnoDao {
    private static alumnoDaoImp instance;
    
    static{
        instance=new alumnoDaoImp();
    }
    
    public alumnoDaoImp(){
        
    }
    
    public static alumnoDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(alumno a) throws SQLException {
        String sql="insert into alumno(nombre,apellido1,apellido2,fNacimiento,telefono,email,dni,direccion,poblacion,provincia,cp) values (?,?,?,?,?,?,?,?,?,?,?);";
        
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getApellido1());
            pstmt.setString(3, a.getApellido2());
            pstmt.setDate(4, a.getfNacimiento());
            pstmt.setInt(5, a.getTelefono());
            pstmt.setString(6, a.getEmail());
            pstmt.setString(7, a.getDni());
            pstmt.setString(8, a.getDireccion());
            pstmt.setString(9, a.getPoblacion());
            pstmt.setString(10, a.getProvincia());
            pstmt.setString(11, a.getCp());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }
    

    @Override
    public alumno getById(int id) {
        String sql="select * from alumno where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                alumno a = new alumno();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido1(rs.getString("apellido1"));
                a.setApellido2(rs.getString("apellido2"));
                a.setfNacimiento(rs.getDate("fNacimiento"));
                a.setTelefono(rs.getInt("telefono"));
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
    public List<alumno> getAll() throws SQLException {
        String sql = "Select * from centroeducativo.alumno";
        List <alumno> lista = new ArrayList <alumno>();
        
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
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
    public int update(alumno A) throws SQLException {
         String sql="update alumno set dni=?,nombre=?,apellido1=?,apellido2=?,fNacimiento=?,telefono=?,email=?,direccion=?,poblacion=?,provincia=?,cp=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, A.getDni());
            pstmt.setString(2, A.getNombre());
            pstmt.setString(3, A.getApellido1());
            pstmt.setString(4, A.getApellido2());
            pstmt.setDate(5, A.getfNacimiento());
            pstmt.setInt(6, A.getTelefono());
            pstmt.setString(7, A.getEmail());
            pstmt.setString(8, A.getDireccion());
            pstmt.setString(9, A.getPoblacion());
            pstmt.setString(10, A.getProvincia());
            pstmt.setString(11, A.getCp());
            pstmt.setInt(12, A.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from alumno where id=?;";
        
        
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
    public List<autorizado> getautorizados(int id) {
        String sql = "Select a.* from autorizado a join autorizaciones aut where a.id=aut.idautorizado and aut.idalumno=?";
        List <autorizado> lista = new ArrayList <>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                if(rs.getString("parentesto").equals("TUTOR1")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.TUTOR1));
                }
                if (rs.getString("parentesto").equals("TUTOR2")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.TUTOR2));
                }
                if (rs.getString("parentesto").equals("OTROS")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.OTROS));
                }
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<alumno> getalumnoscurso(int id) {
        String sql = "Select al.* from alumno al join matricula mat where al.id=mat.idalumno and mat.idunidad=? and mat.fbaja is null";
        List <alumno> lista = new ArrayList <alumno>();
        
        
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
    public List<alumno> getalumnosnotincurso(int id) {
        String sql = "SELECT alumno.* FROM alumno LEFT JOIN matricula ON alumno.id = matricula.idalumno WHERE matricula.idunidad IS NULL OR matricula.idunidad <> ? and matricula.fBaja is null";
        List <alumno> lista = new ArrayList <alumno>();
        
        
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
    
}
