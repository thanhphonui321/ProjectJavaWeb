/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_leave;

import java.io.Serializable;

/**
 *
 * @author nguyenducthanh
 */
public class viewLeavesAsManagerDTO implements Serializable{
    private String empID;
    private String name;
    private float salary;
    private String address;
    private String email;
    private String phone;
    private boolean accept;
    private String requestReason;
    private String rejectReason;

    public viewLeavesAsManagerDTO() {
    }

    public viewLeavesAsManagerDTO(String empID, String name, float salary, String address, String email, String phone, boolean accept, String requestReason, String rejectReason) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.accept = accept;
        this.requestReason = requestReason;
        this.rejectReason = rejectReason;
    }

    
    

    /**
     * @return the empID
     */
    public String getEmpID() {
        return empID;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(String empID) {
        this.empID = empID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public float getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    /**
     * @return the requestReason
     */
    public String getRequestReason() {
        return requestReason;
    }

    /**
     * @param requestReason the requestReason to set
     */
    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    /**
     * @return the rejectReason
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * @param rejectReason the rejectReason to set
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    /**
     * @return the accept
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * @param accept the accept to set
     */
    public void setAccept(boolean accept) {
        this.accept = accept;
    }
    
    
}
