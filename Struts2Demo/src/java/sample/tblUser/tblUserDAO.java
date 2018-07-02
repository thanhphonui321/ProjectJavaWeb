/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tblUser;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author nguyenducthanh
 */
public class tblUserDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException, /*ClassNotFoundException*/ NamingException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        // 1. Open connecion
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                // 2. Tao cau lenh truy van
                String sql = "SELECT * from tblUser WHERE username = ? AND password = ?";
                // 3. Thuc hien truy van va truyen tham so
                psm = conn.prepareStatement(sql);
                psm.setString(1, username);
                psm.setString(2, password);

                // 4 Thuc thi cau lenh
                rs = psm.executeQuery();

                if (rs.next()) {
                    return true;
                }
            }// end if conn
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return false;
    }

    private List<tblUserDTO> listUsers;

    public List<tblUserDTO> getListUsers() {
        return listUsers;
    }

    public void searchLastName(String searchValue) throws /*ClassNotFoundException*/ NamingException, SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        // 1. Open connecion
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                // 2. Tao cau lenh truy van
                String sql = "SELECT * from tblUser WHERE lastname like ?";
                // 3. Thuc hien truy van va truyen tham so
                psm = conn.prepareStatement(sql);
                psm.setString(1, "%" + searchValue + "%");

                // 4 Thuc thi cau lenh
                rs = psm.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    tblUserDTO dto = new tblUserDTO(username, password, lastname, role);

                    if (this.listUsers == null) {
                        this.listUsers = new ArrayList<>();
                    }
                    this.listUsers.add(dto);
                }

            }// end if conn
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    public boolean deleteRecord(String username) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement psm = null;
        // 1. Open connecion
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                // 2. Tao cau lenh truy van
                String sql = "delete from tblUser where username=?";
                // 3. Thuc hien truy van va truyen tham so
                psm = conn.prepareStatement(sql);
                psm.setString(1, username);

                // 4 Thuc thi cau lenh
                int result = psm.executeUpdate();
                if (result > 0) {
                    return true;
                }

            }// end if conn
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return false;
    }
    
    public boolean updateRecord(String username, String password, boolean isAdmin) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement psm = null;
        // 1. Open connecion
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                // 2. Tao cau lenh truy van
                String sql = "update tblUser set password=?, isAdmin=? where username=?";
                // 3. Thuc hien truy van va truyen tham so
                psm = conn.prepareStatement(sql);
                psm.setString(1, password);
                psm.setBoolean(2, isAdmin);
                psm.setString(3, username);

                // 4 Thuc thi cau lenh
                int result = psm.executeUpdate();
                if (result > 0) {
                    return true;
                }

            }// end if conn
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return false;
    }

    public boolean createAccount(String username, String password, String fullname, boolean isAdmin) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        int result = 0;
        //1. Open connection
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                //2. Create sql
                String sql = "insert into tblUser(username, password, lastname, isAdmin) values(?,?,?,?)";

                //3. Thực hiện truy vấn và truyền tham số -> Tạo PreparedStatement
                psm = conn.prepareStatement(sql);
                psm.setString(1, username);
                psm.setString(2, password);
                psm.setString(3, fullname);
                psm.setBoolean(4, isAdmin);
                //4. Thực hiện câu lệnh
                result = psm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            }
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;

    }
}
