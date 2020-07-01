package com.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dao.Student;
import com.dao.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author truonglv
 */
@WebServlet(urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        StudentDAO dao = new StudentDAO();
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Student> students = dao.getStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        } else if ("Delete".equals(action)) {
            String id = request.getParameter("id");
            dao.delete(Integer.valueOf(id));
            response.sendRedirect("StudentController?action=list");
        } else if ("DeleteCookie".equals(action)) {
            String name = request.getParameter("name");
            Cookie[] cookies = request.getCookies();
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals(name)) {
                    cooky.setMaxAge(0);
                    cooky.setPath("/");
                    cooky.setDomain("localhost");
                    response.addCookie(cooky);
                }
            }
            response.sendRedirect("StudentController?action=ViewCart");
        } else if ("AddCart".equals(action)) {
            String id = request.getParameter("id");
            Student studentById = dao.getStudentById(Integer.parseInt(id));
            Cookie cookie = new Cookie(id, studentById.getName());
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            response.sendRedirect("StudentController?action=list");
        } else if ("ViewCart".equals(action)) {
            Cookie[] cookies = request.getCookies();
            request.setAttribute("cookies", cookies);
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
