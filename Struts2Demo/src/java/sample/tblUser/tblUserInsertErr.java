/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tblUser;

import java.io.Serializable;

/**
 *
 * @author nguyenducthanh
 */
public class tblUserInsertErr implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String fullnameLengthErr;
    private String userIsExisted;

    /**
     * @return the usernameLengthErr
     */
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    /**
     * @param usernameLengthErr the usernameLengthErr to set
     */
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the confirmNotMatch
     */
    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    /**
     * @param confirmNotMatch the confirmNotMatch to set
     */
    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    /**
     * @return the fullnameLengthErr
     */
    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    /**
     * @param fullnameLengthErr the fullnameLengthErr to set
     */
    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    /**
     * @return the userIsExisted
     */
    public String getUserIsExisted() {
        return userIsExisted;
    }

    /**
     * @param userIsExisted the userIsExisted to set
     */
    public void setUserIsExisted(String userIsExisted) {
        this.userIsExisted = userIsExisted;
    }
    
    
}
