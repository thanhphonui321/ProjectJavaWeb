/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.DBUtils.DBConnection;

/**
 *
 * @author nguyenducthanh
 */
public class tbl_accountDAO implements Serializable {

    public int checkLogin(String username, String password) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.makeConnection();
            if (conn!= null){
                ps = conn.prepareStatement("Select accountID, password, role from tbl_account where accountID=? AND password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()){
                    int role = rs.getInt("role");
                    return role;
                }
            }
        }
        finally{
            if (rs!= null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn!= null){
                conn.close();
            }
        }
        return -1;
    }
}
