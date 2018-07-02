/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_employee;

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
public class tbl_employeeDAO implements Serializable {

    public showEmpInfoDTO getEmpInfoInRequestLeave(String empID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if (conn != null) {
                String sql = "select emp.employeeID as ID, emp.name as Name, dep.name as Department, emp.salary as Salary \n" +
"from tbl_employee emp inner join tbl_department dep on emp.depID = dep.depID\n" +
"where emp.employeeID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, empID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String empName = rs.getString("Name");
                    String depName = rs.getString("Department");
                    Float salary = rs.getFloat("Salary");
                    showEmpInfoDTO dto = new showEmpInfoDTO(empID, empName, depName, salary);
                    return dto;
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
        return null;
    }
}
