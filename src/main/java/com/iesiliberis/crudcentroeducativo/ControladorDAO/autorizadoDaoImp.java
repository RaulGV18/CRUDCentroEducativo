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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raúl
 */
public class autorizadoDaoImp implements autorizadoDao {
    private static autorizadoDaoImp instance;
    
    static{
        instance=new autorizadoDaoImp();
    }
    
    public autorizadoDaoImp(){
        
    }
    
    public static autorizadoDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(autorizado a) throws SQLException {
        String sql="insert into autorizado(dni,nombre,apellido1,apellido2,parentesto) values (?,?,?,?,?);";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, a.getDni());
            pstmt.setString(2, a.getNombre());
            pstmt.setString(3, a.getApellido1());
            pstmt.setString(4, a.getApellido2());
            pstmt.setString(5, a.getParent().toString());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public autorizado getById(int id) {
                String sql="select * from autorizado where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                autorizado au = new autorizado();
                au.setId(rs.getInt("id"));
                au.setDni(rs.getString("dni"));
                au.setNombre(rs.getString("nombre"));
                au.setApellido1(rs.getString("apellido1"));
                au.setApellido2(rs.getString("apellido2"));
                if(rs.getString("parentesco").equals("TUTOR1")){
                    au.setParent(parentesco.TUTOR1);
                }
                if (rs.getString("parentesco").equals("TUTOR2")){
                    au.setParent(parentesco.TUTOR2);
                }
                if (rs.getString("parentesco").equals("OTROS")){
                    au.setParent(parentesco.OTROS);
                }
                
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
    public List<autorizado> getAll() throws SQLException {
        String sql = "Select * from centroeducativo.autorizado";
        List <autorizado> lista = new ArrayList <>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                if(rs.getString("parentesco").equals("TUTOR1")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.TUTOR1));
                }
                if (rs.getString("parentesco").equals("TUTOR2")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.TUTOR2));
                }
                if (rs.getString("parentesco").equals("OTROS")){
                    lista.add(new autorizado(rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),parentesco.OTROS));
                }
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(autorizado a) throws SQLException {
        String sql="update autorizado set nombre=?,apellido1=?,apellido2=?,parentesto=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getApellido1());
            pstmt.setString(3, a.getApellido2());
            pstmt.setString(4, a.getParent().toString());
            pstmt.setInt(5, a.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
                String sql="delete from autorizado where id=?;";
        
        
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
    public alumno devolvAlumno(autorizado aut) throws SQLException {
        String sql="select * from alumno where id=(select idalumno from autorizaciones where idautorizado=?)";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, aut.getId());
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
    public autorizado devolvAutorizadodni(String DNI) {
        String sql="select * from autorizado where dni=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, DNI);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                autorizado au = new autorizado();
                au.setId(rs.getInt("id"));
                au.setDni(rs.getString("dni"));
                au.setNombre(rs.getString("nombre"));
                au.setApellido1(rs.getString("apellido1"));
                au.setApellido2(rs.getString("apellido2"));
                if(rs.getString("parentesto").equals("TUTOR1")){
                    au.setParent(parentesco.TUTOR1);
                }
                if (rs.getString("parentesto").equals("TUTOR2")){
                    au.setParent(parentesco.TUTOR2);
                }
                if (rs.getString("parentesto").equals("OTROS")){
                    au.setParent(parentesco.OTROS);
                }
                
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
    public void addautorizado(int idalumno, int idautorizado) {
        String sql="insert into autorizaciones(idalumno,idautorizado) values (?,?);";
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, idalumno);
            pstmt.setInt(2, idautorizado);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }
    
}
