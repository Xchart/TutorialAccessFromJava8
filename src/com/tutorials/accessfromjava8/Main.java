/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorials.accessfromjava8;

/**
 *
 * @author RicardoI
 */

import java.sql.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection conn=DriverManager
                    .getConnection("jdbc:ucanaccess://G://tutorial.accdb;jackcessOpener=com.tutorials.utils.CryptCodecOpener",
                                    "sa", "f4c1l#");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            String datos = "";
            while(rs.next()){
                datos += rs.getString("nombre");
                datos += " < - > ";
                datos +=  rs.getString("password");
                datos += "\n";
            }
            System.out.println(datos);
            
        }catch(SQLException sqlEx){
            System.err.println(sqlEx.getMessage());
        }
    }
    
}
