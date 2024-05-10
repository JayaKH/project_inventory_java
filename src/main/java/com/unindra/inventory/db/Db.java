/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.inventory.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herwi
 */
public class Db {
    
    public Connection conn;
    
    private static Db instance;
    
    private Db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dsn = "jdbc:mysql://localhost:3306/db_focon";
            conn = DriverManager.getConnection(dsn, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        
        return instance;
    }
    
}
