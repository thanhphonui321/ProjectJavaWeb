/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyenducthanh
 */
public class DieuphoiServlet extends HttpServlet {
    private final String loginServlet = "LoginServlet";
    private final String loginPage = "login.html";
    private final String searchServlet = "SearchLastNameServlet";
    private final String deleteRecordServlet = "DeleteRecordServlet";
    private final String updateRecordServlet = "UpdateRecordServlet";
    private final String startUpServlet = "StartUpServlet";
    private final String addItemToCart = "AddItemToCartServlet";
    private final String viewCartPage = "viewCart.jsp";
    private final String removeItemServlet = "RemoveItemServlet";
    private final String createNewAccountServlet = "CreateNewAccountServlet";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String button = request.getParameter("btnAction");
        String url = loginPage; 
        try {
            if (button == null){
                url = startUpServlet; 
            }
            else if (button.equals("Login")){
                url = loginServlet;
            }
            else if (button.equals("SearchPage")){
                url = searchServlet;
            }
            else if (button.equals("deleteRecord")){
                url = deleteRecordServlet;
            }
            else if (button.equals("UpdateRecord")){
                url = updateRecordServlet;
            }
            else if (button.equals("Add phone to your cart")){
                url = addItemToCart;
            }
            else if (button.equals("View your cart")){
                url = viewCartPage;
            }
            else if (button.equals("Remove Item")){
                url = removeItemServlet;
            }
            else if (button.equals("Register")){
                url = createNewAccountServlet;
            }
        }
        finally{
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
