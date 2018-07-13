/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.login;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import sample.tblUser.tblUserDAO;

/**
 *
 * @author nguyenducthanh
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "search.jsp"),
    @Result(name = "fail", location = "invalid.html")
})
public class LoginAction {
    private String username;
    private String password;
    
    private String FAIL = "fail";
    private String SUCCESS = "success";
    public LoginAction() {
    }
    @Action("/login")
    public String execute() throws Exception {
        tblUserDAO dao = new tblUserDAO();
        boolean result = dao.checkLogin(username, password);
        String url = FAIL;
        if (result){
            url = SUCCESS;
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", username);
        }
        return url;
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
    
}
