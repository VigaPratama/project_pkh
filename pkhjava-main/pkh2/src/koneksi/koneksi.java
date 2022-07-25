/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.*;

/**
 *
 * @author Me
 */
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
       try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("berhasil koneksi");
       }catch(ClassNotFoundException ex){
          System.out.println("gagal Koneksi "+ex);
       }
       String url = "jdbc:mysql://localhost:3306/pkh";
       try{
          koneksi = DriverManager.getConnection(url, "root", "");
          System.out.print("Berhasil Koneksi Database");
       }catch (SQLException ex){
          System.out.println("Gagal Koneksi Database"+ex);
       }
       return koneksi;
    }
}
