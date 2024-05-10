/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unindra.inventory;

//import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.unindra.inventory.db.Db;
import com.unindra.inventory.view.Login;

/**
 *
 * @author herwi
 */
public class Inventory {

    public static void main(String[] args) {
        Db db =  Db.getInstance();
//        
//        FlatLaf.registerCustomDefaultsSource( "com.unindra.inventory.themes" );
        FlatLightLaf.setup();
        
        Login frame = new Login();
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}
