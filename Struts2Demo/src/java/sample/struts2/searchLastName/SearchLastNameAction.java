/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.searchLastName;

import java.util.List;
import sample.tblUser.tblUserDAO;
import sample.tblUser.tblUserDTO;

/**
 *
 * @author nguyenducthanh
 */
public class SearchLastNameAction {
    
    private String searchValue;
    private List<tblUserDTO> listAccounts;
    private String SUCCESS = "success";
    
    public SearchLastNameAction() {
    }
    
    public String execute() throws Exception {
        tblUserDAO dao = new tblUserDAO();
        dao.searchLastName(searchValue);
        this.listAccounts = dao.getListUsers();
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the listAccounts
     */
    public List<tblUserDTO> getListAccounts() {
        return listAccounts;
    }

    /**
     * @param listAccounts the listAccounts to set
     */
    public void setListAccounts(List<tblUserDTO> listAccounts) {
        this.listAccounts = listAccounts;
    }
    
    
}
