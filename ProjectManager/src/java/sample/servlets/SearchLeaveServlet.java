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
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.tbl_leave.tbl_leaveDAO;
import sample.tbl_leave.viewLeavesAsManagerDTO;

/**
 *
 * @author nguyenducthanh
 */
@WebServlet(name = "SearchLeaveServlet", urlPatterns = {"/SearchLeaveServlet"})
public class SearchLeaveServlet extends HttpServlet {
    private final String searchLeavePage = "searchLeave.jsp";

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
        try {
            HttpSession session = request.getSession();
            session.setAttribute("SEARCHLIST", null);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            java.util.Date utilFrom = dateFormat.parse(from);
            java.util.Date utilTo = dateFormat.parse(to);
            java.sql.Date sqlFrom = new java.sql.Date(utilFrom.getTime());
            java.sql.Date sqlTo = new java.sql.Date(utilTo.getTime());
            tbl_leaveDAO dao = new tbl_leaveDAO();
            List<viewLeavesAsManagerDTO> dto = dao.getLeavesForSearch(sqlFrom, sqlTo);
            session.setAttribute("SEARCHLIST", dto);
        } catch (ParseException ex) {
            request.setAttribute("FAULT", "Wrong date");
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(searchLeavePage);
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
