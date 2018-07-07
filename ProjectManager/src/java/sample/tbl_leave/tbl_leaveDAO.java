/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_leave;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import sample.DBUtils.DBConnection;

/**
 *
 * @author nguyenducthanh
 */
public class tbl_leaveDAO implements Serializable {

    public int insertLeave(java.sql.Date fromDate, java.sql.Date toDate,
            boolean accept, String empID, String requestReason, String rejectReason) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            conn = DBConnection.makeConnection();
            if (conn != null) {
                String sql = "insert into tbl_leave(fromDate,toDate,accept,empID,requestReason,rejectReason)\n"
                        + "values (?,?,?,?,?,?)";

                ps = conn.prepareStatement(sql);
                ps.setDate(1, fromDate);
                ps.setDate(2, toDate);
                ps.setBoolean(3, accept);
                ps.setString(4, empID);
                ps.setString(5, requestReason);
                ps.setString(6, rejectReason);
                result = ps.executeUpdate();
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;

    }

    public List<tbl_leaveDTO> getLeavesOfEmp(String empID) throws SQLException, NamingException {
        List<tbl_leaveDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if (conn != null) {
                String sql = "Select leaveID, fromDate, toDate, accept, requestReason"
                        + ", rejectReason from tbl_leave where empID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, empID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int leaveID = rs.getInt("leaveID");
                    Date fromDate = rs.getDate("fromDate");
                    Date toDate = rs.getDate("toDate");
                    boolean accept = rs.getBoolean("accept");
                    String requestReason = rs.getString("requestReason");
                    String rejectReason = rs.getString("rejectReason");
                    tbl_leaveDTO dto = new tbl_leaveDTO(leaveID, fromDate, toDate, accept, empID, requestReason, rejectReason);
                    result.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<viewLeavesAsManagerDTO> getLeavesForSearch(java.sql.Date fromDate, java.sql.Date toDate) throws SQLException, NamingException {
        List<viewLeavesAsManagerDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if (conn != null) {
                String sql = "select l.leaveID, e.employeeID, e.name, e.salary, e.address, e.email, e.phone, l.accept,l.requestReason,l.rejectReason, d.name as depName\n"
                        + "from (tbl_employee e inner join tbl_leave l on e.employeeID = l.empID) inner join tbl_department d on d.depID=e.depID \n"
                        + "WHERE DATEDIFF(day,?, l.fromDate ) >= 0 AND DATEDIFF(day , l.toDate, ?) >= 0"
                        + "order by l.leaveID";
                ps = conn.prepareStatement(sql);
                ps.setDate(1, fromDate);
                ps.setDate(2, toDate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String leaveID = rs.getString("leaveID");
                    String empID = rs.getString("employeeID");
                    String name = rs.getString("name");
                    float salary = rs.getFloat("salary");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String depName = rs.getString("depName");
                    boolean accept = rs.getBoolean("accept");
                    String requestReason = rs.getString("requestReason");
                    String rejectReason = rs.getString("rejectReason");
                    viewLeavesAsManagerDTO dto = new viewLeavesAsManagerDTO(leaveID, empID, name, salary, address, email, phone, depName, accept, requestReason, rejectReason);
                    result.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public int updateAcceptLeave(boolean accept, String rejectReason, int leaveID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            conn = DBConnection.makeConnection();
            if (conn != null) {
                String sql = "update tbl_leave set accept = ?, rejectReason = ? where leaveID = ?";
                ps = conn.prepareStatement(sql);
                ps.setBoolean(1, accept);
                ps.setString(2, rejectReason);
                ps.setInt(3, leaveID);
                result = ps.executeUpdate();
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;

    }
}

