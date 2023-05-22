/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iesiliberis.crudcentroeducativo;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.ControladorDAO.CursoAcademicoDaoImp;
import com.iesiliberis.crudcentroeducativo.ControladorDAO.alumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Raúl
 */
public class CRUDCentroEducativo {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        //Connection cnlocal= MyDataSource.getconnection();
        //CursoAcademicoDaoImp curs=CursoAcademicoDaoImp.getInstance();
        //System.out.println(curs.getById(1));
        //CursoAcademico cur= new cursoacademico(2021,2022,"javier");
        //System.out.println(curs.add(cur));
        //curs.delete(4);
        alumnoDaoImp al=alumnoDaoImp.getInstance();
        System.out.println(al.getById(1).getfNacimiento());
        alumno alum= new alumno("paco","sanchez","uceda","1999-07-03",679746253,);
        
    }
}
