/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts.search;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import sample.tblUser.tblUserDAO;
import sample.tblUser.tblUserDTO;

/**
 *
 * @author nguyenducthanh
 */
public class SearchLastNameStrutsActionForm extends org.apache.struts.action.ActionForm {
    private String searchValue;
    private List<tblUserDTO> listAccounts;
   
    public SearchLastNameStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
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

    public void searchLastName(){
        tblUserDAO dao = new tblUserDAO();
        try {
            dao.searchLastName(searchValue);
            this.listAccounts = dao.getListUsers();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
  
}
