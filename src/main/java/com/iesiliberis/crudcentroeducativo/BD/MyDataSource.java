/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raúl
 */
public class MyDataSource {
    private static final String driver="";
    private static final String url="jdbc:mysql://127.0.0.1:3306/centroeducativo";
    private static final String user= "raul";
    private static final String pass="raul";
    private static Connection cn;
    
    static {
        try {
            cn=DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
            System.out.println("error");
        }
    }
    
    public static Connection getconnection() throws SQLException{
        if (cn==null || cn.isClosed()){
            cn=DriverManager.getConnection(url,user,pass);
        }
        System.out.println("conexion establecida");
        return cn;
    }
}
