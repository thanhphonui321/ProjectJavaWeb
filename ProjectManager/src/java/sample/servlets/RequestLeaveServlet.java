/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.tbl_employee.showEmpInfoDTO;
import sample.tbl_leave.tbl_leaveDAO;

/**
 *
 * @author nguyenducthanh
 */
@WebServlet(name = "RequestLeaveServlet", urlPatterns = {"/RequestLeaveServlet"})
public class RequestLeaveServlet extends HttpServlet {
    private final String viewAllLeavesServlet = "viewAllLeaves";
    private final String requestLeavePage = "requestLeave.jsp";

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
        String from = request.getParameter("txtFrom");
        String to = request.getParameter("txtTo");
        String reason = request.getParameter("txtReason");
        HttpSession session = request.getSession();
        showEmpInfoDTO empID = (showEmpInfoDTO) session.getAttribute("EMPINFO");
        String url = requestLeavePage;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            java.util.Date utilDateFrom = dateFormat.parse(from);
            java.util.Date utilDateTo = dateFormat.parse(to);
            if (utilDateFrom.compareTo(utilDateTo) > 0){
                throw new ParseException("Wrong day", 0);
            }
            java.sql.Date sqlDateFrom = new java.sql.Date(utilDateFrom.getTime());
            java.sql.Date sqlDateTo = new java.sql.Date(utilDateTo.getTime());
            tbl_leaveDAO dao = new tbl_leaveDAO();
            int result = dao.insertLeave(sqlDateFrom, sqlDateTo, false, empID.getEmployeeID(), reason, "Pending");
            if (result > 0){
                url = viewAllLeavesServlet;
            }
        } catch (ParseException ex) {
            request.setAttribute("FAULT", "Wrong day");
            ex.printStackTrace();
        } catch (SQLException ex) {
            request.setAttribute("FAULT", "Request failed, please try again");
            ex.printStackTrace();
        } catch (NamingException ex) {
            request.setAttribute("FAULT", "Connect failed, please try again");
            ex.printStackTrace();
        }  finally {
            if (url == viewAllLeavesServlet){
                response.sendRedirect(url);
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
