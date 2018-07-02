/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nguyenducthanh
 */
public class DBConnection implements Serializable {

    public static Connection makeConnection() throws SQLException, NamingException {
        Context myContext = new InitialContext();
        Context tomcatContext = (Context) myContext.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatContext.lookup("Connect1272");
        Connection conn = ds.getConnection();
        return conn;
    }
}
