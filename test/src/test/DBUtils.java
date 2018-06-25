/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenducthanh
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        try {
            // load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao connection String
            String url = "jdbc:sqlserver://localhost:1433;databaseName=EmployeeDB";
            // lay ket noi
            Connection conn = DriverManager.getConnection(url, "sa", "Ducthanh981");
            //tra ve ket noi
            return conn;
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
