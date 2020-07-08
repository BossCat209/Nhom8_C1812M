/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import services.ConnectDB;

/**
 *
 * @author huanh
 */
public class Connect {
    public static Connection conn = null;
    public static String testConnect(){
        conn = ConnectDB.getConnection();
        try {
            conn = ConnectDB.getConnection();
            return "Thành công";
        } catch (Exception e) {
            return "Thất bại";
        }
    }
}
