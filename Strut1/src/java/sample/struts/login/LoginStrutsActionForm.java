/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts.login;

import java.sql.SQLException;
import javax.naming.NamingException;
import sample.tblUser.tblUserDAO;

/**
 *
 * @author nguyenducthanh
 */
public class LoginStrutsActionForm extends org.apache.struts.action.ActionForm {

    private String username;
    private String password;

    /**
     *
     */
    public LoginStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkLogin() {
        try {
            tblUserDAO dao = new tblUserDAO();

            boolean result = dao.checkLogin(username, password);

            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
