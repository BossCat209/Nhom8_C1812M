/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import services.ConnectDB;

/**
 *
 * @author huanh
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = ConnectDB.getConnection();
        if (conn != null) {
            System.out.println("Connect");
        }else{
            System.err.println("Error");
        }
    }
    
}
