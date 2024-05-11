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
public class BarangKeluar {
    
    public ResultSet fetchAll() {
        Connection conn = Db.getInstance().conn;
        ResultSet result = null;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeQuery ("SELECT * FROM tb_brg_keluar");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public ResultSet fetchDetailAll() {
        Connection conn = Db.getInstance().conn;
        ResultSet result = null;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeQuery ("SELECT * FROM tb_detail_brg_keluar");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public ResultSet fetchDetailByIdBk(String kode) {
        Connection conn = Db.getInstance().conn;
        ResultSet result = null;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeQuery ("SELECT * FROM tb_detail_brg_keluar "
                    + "WHERE `id_bk`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public boolean create(String kode, String pemasok, String keterangan) {
        java.util.Date now = new java.util.Date();
        Date date = new Date(now.getTime());
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("INSERT INTO `tb_brg_keluar`(`tanggal`, `id_bk`, `supplier`, `keterangan`) "
                    + "VALUES ('"+ date.toString() +"','"+ kode +"','"+ pemasok +"','"+ keterangan +"')");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
    public boolean createDetail(String kode, String kodeBM, String pemasok, 
            String kodeBarang, String namaBarang, int jumlah, String keterangan) {
        java.util.Date now = new java.util.Date();
        Date date = new Date(now.getTime());
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("INSERT INTO `tb_detail_brg_keluar`(`tanggal`, `id_detail_bk`, `id_bk`, `supplier`, `kode_part`, `nama_part`, `jumlah`, `keterangan`) "
                    + "VALUES ('"+ date.toString() +"','"+ kode +"','"+ kodeBM +"','"+ pemasok +"','"+ kodeBarang +"','"+ namaBarang +"',"+ jumlah +",'"+ keterangan +"')");  
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
    public boolean update(String kode, String pemasok, String keterangan) {
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("UPDATE `tb_brg_keluar` SET "
                    + "`supplier`='"+ pemasok +"',"
                    + "`keterangan`='"+ keterangan +"' "
                    + "WHERE `id_bk`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
    public boolean updateDetail(String kode, 
            String kodeBarang, String namaBarang, int jumlah, String keterangan) {
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("UPDATE `tb_detail_brg_keluar` SET "
                    + "`kode_part`='"+ kodeBarang +"',"
                    + "`nama_part`='"+ namaBarang +"',"
                    + "`jumlah`="+ jumlah +","
                    + "`keterangan`='"+ keterangan +"' "
                    + "WHERE `id_detail_bk`='"+ kode +"'");
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
            result = stmt.executeUpdate("DELETE FROM `tb_brg_keluar` WHERE `id_bk`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
     
     public boolean deleteDetail(String kode) {
        Connection conn = Db.getInstance().conn;
        int result = 0;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            result = stmt.executeUpdate("DELETE FROM `tb_detail_brg_keluar` WHERE `id_detail_bk`='"+ kode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
}
