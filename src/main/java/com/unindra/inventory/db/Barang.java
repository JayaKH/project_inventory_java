/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.inventory.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herwi
 */
public class Barang {
    
    public ResultSet fetchAll() {
        Connection conn = Db.getInstance().conn;
        ResultSet result = null;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeQuery ("SELECT * FROM tb_barang");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public ResultSet fetchByKode(String kode) {
        Connection conn = Db.getInstance().conn;
        ResultSet result = null;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeQuery ("SELECT * FROM tb_barang WHERE `kode_part` LIKE '%"+ kode +"%'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public boolean create(String kode, String nama, String kategori, String keterangan) {
        java.util.Date now = new java.util.Date();
        Date date = new Date(now.getTime());
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("INSERT INTO `tb_barang`(`tanggal`, `kode_part`, `nama_part`, `kategori`, `jumlah`, `keterangan`) "
                    + "VALUES ('"+ date.toString() +"','"+ kode +"','"+ nama +"','"+ kategori +"',"+ 0 +",'"+ keterangan +"')");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
    public boolean update(String kode, String nama, String kategori, String keterangan) {
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("UPDATE `tb_barang` SET "
                    + "`nama_part`='"+ nama +"',"
                    + "`kategori`='"+ kategori +"',"
                    + "`keterangan`='"+ keterangan +"' "
                    + "WHERE `kode_part`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
     public boolean delete(String kode) {
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("DELETE FROM `tb_barang` WHERE `kode_part`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
}
