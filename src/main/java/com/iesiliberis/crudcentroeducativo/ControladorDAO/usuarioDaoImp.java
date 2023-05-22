/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.ControladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.usuario;
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
public class usuarioDaoImp implements UsuarioDao {
     private static usuarioDaoImp instance;
    
    static{
        instance=new usuarioDaoImp();
    }
    public static usuarioDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(usuario u) throws SQLException {
        String sql="insert into alumno(usuario,password) values (?,?);";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, u.getUsuario());
            pstmt.setString(2, u.getContraseña());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public usuario getById(int id) {
        String sql="select * from usuario where id=?";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                usuario usu = new usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContraseña(rs.getString("password"));
                pstmt.close();
                cn.close();
                return usu;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<usuario> getAll() throws SQLException {
           String sql = "Select * from centroeducativo.usuario";
        List <usuario> lista = new ArrayList <>();
        
        try (Connection cn = MyDataSource.getconnection();){
            PreparedStatement pstm = cn.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                lista.add(new usuario(rs.getInt("id"),rs.getString("usuario"),rs.getString("password")));
                
            }
        } catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
        return lista;
    }

    @Override
    public int update(usuario u) throws SQLException {
                        
         String sql="update usuario set usuario=? and password=? where id=?;";
        
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            pstmt.setString(1, u.getUsuario());
            pstmt.setString(2, u.getContraseña());
            pstmt.setInt(3, u.getId());
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        
         String sql="delete from usuario where id=?;";
        
        
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
    public boolean valida(String usuario, String password) throws SQLException {
        
        String sql="select * from usuario";
        
        try {
            Connection cn=MyDataSource.getconnection();
            PreparedStatement pstmt= cn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                usuario usu = new usuario();
                usu.setUsuario(rs.getString("usuario"));
                usu.setContraseña(rs.getString("password"));
                if (usuario.equals(usu.getUsuario())){
                    if (password.equals(usu.getContraseña())){
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            return false;
        }
    }
    
}
