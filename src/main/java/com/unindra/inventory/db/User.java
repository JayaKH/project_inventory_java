/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.inventory.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herwi
 */
public class User {
    
    public boolean check(String username, String password) {
        Connection conn = Db.getInstance().conn;
        boolean match = false;
        
        try {
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery ("SELECT * FROM tb_user WHERE " + 
                    "username='" + username + "'" + " AND " + 
                    "password='" + password + "'");
            match = result.next();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return match;
    }
    
}
