///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.teamhydra.Controllers;
//
//import com.teamhydra.util.DBUtill;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author adipasith
// */
//public class VerificationServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet VerificationServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet VerificationServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //processRequest(request, response);
//        
//                String token = request.getParameter("token");
//                
//                try {
//            // Check if the token exists in the verification_tokens table
//            String sql = "SELECT * FROM verification_tokens WHERE token = ?";
//            PreparedStatement stmt = DBUtill.setStatment(sql);
//            stmt.setString(1, token);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int userId = rs.getInt("user_id");
//                String email = rs.getString("email");
//                                // Update the is_verified column to true
//                String sql2 = "UPDATE verification_tokens SET is_verified = true WHERE user_id = ? AND email = ?";
//                PreparedStatement stmt2 = DBUtill.setStatment(sql2);
//                stmt2.setInt(1, userId);
//                stmt2.setString(2, email);
//                stmt2.executeUpdate();
//                                // Redirect to home page or any other desired page
//                response.sendRedirect("home.jsp");
//            } else {
//                // Invalid token
//                response.sendRedirect("error.jsp");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
