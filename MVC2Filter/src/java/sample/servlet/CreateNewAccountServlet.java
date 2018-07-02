/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.tblUser.tblUserDAO;
import sample.tblUser.tblUserInsertErr;

/**
 *
 * @author nguyenducthanh
 */
@WebServlet(name = "CreateNewAccountServlet", urlPatterns = {"/CreateNewAccountServlet"})
public class CreateNewAccountServlet extends HttpServlet {

    String loginPage = "login.html";
    String errInsertPage = "createNewAccount.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific isError occurs
     * @throws IOException if an I/O isError occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        tblUserInsertErr errors = new tblUserInsertErr();
        boolean isError = false;
        String url = errInsertPage;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtFullName");

            if (username.length() < 6 || username.length() > 20) {
                isError = true;
                errors.setUsernameLengthErr("Username length is from 6 to 20 character");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                isError = true;
                errors.setPasswordLengthErr("Password length is from 6 to 30 character");
            } else if (!confirm.trim().equals(password.trim())) {
                isError = true;
                errors.setConfirmNotMatch("Password is not matched");
            }
            if (fullname.length() < 2 || fullname.length() > 50) {
                isError = true;
                errors.setFullnameLengthErr("Full name length is from 2 to 50 character");
            }
            if (isError) {
                //Chuyển lỗi sang trang báo lỗi
                request.setAttribute("ERROR", errors);
            } else {
                tblUserDAO dao = new tblUserDAO();
                boolean result = dao.createAccount(username, password, fullname, false);
                if (result) {
                    url = loginPage;
                }
            }

            /* TODO output your page here. You may use following sample code. */
        } catch (NamingException ex) {
            log("CreateAccountServlet_NamingException" + ex.getMessage());
        } catch (SQLException ex) {
            log("CreateNewAccountServlet_SQlException "+ex.getMessage());
            if (ex.getMessage().contains("duplicate")){
                errors.setUserIsExisted("Username is existed");
                request.setAttribute("ERROR", errors);
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific isError occurs
     * @throws IOException if an I/O isError occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific isError occurs
     * @throws IOException if an I/O isError occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
