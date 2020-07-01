package com.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.model.ClassDTO;
import com.dao.ClassDAO;
import com.model.StudentDTO;
import com.dao.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            List<StudentDTO> students = dao.getStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        } else if ("Delete".equals(action)) {
            String id = request.getParameter("id");
            dao.delete(Integer.valueOf(id));
            response.sendRedirect("StudentController?action=list");
        } else if ("Save".equals(action)) {
            // lấy thong tin sinh vien
            String id = request.getParameter("txtId");
            String txtFistName = request.getParameter("txtFistName");
            String txtLastName = request.getParameter("txtLastName");
            String txtEmail = request.getParameter("txtEmail");
            String txtGender = request.getParameter("txtGender");
            String txtAddress = request.getParameter("txtAddress");
            String txtIdClass = request.getParameter("idClass"); // lấy từ name của combobox
            // khởi tạo 1 đối tượng sinh viên và gán giá trị 
            StudentDTO student = new StudentDTO(Integer.parseInt(id), txtFistName, txtLastName, txtEmail, txtGender, txtAddress, Integer.parseInt(txtIdClass));
            dao.insert(student);
            response.sendRedirect("StudentController?action=list");
        } else if ("Edit".equals(action)) {
            ClassDAO classDAO = new ClassDAO();
            List<ClassDTO> classes = classDAO.getClasses();
            String id = request.getParameter("id");
            // get student by id
            StudentDTO studentById = dao.getStudentById(Integer.parseInt(id));
            request.setAttribute("studentById", studentById);
            request.setAttribute("classes", classes);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else if ("Update".equals(action)) {
            // get student info
            String id = request.getParameter("txtId");
            String txtFistName = request.getParameter("txtFistName");
            String txtLastName = request.getParameter("txtLastName");
            String txtEmail = request.getParameter("txtEmail");
            String txtGender = request.getParameter("txtGender");
            String txtAddress = request.getParameter("txtAddress");
            String txtIdClass = request.getParameter("idClass");
            // khởi tạo 1 đối tượng sinh viên và gán giá trị 
            StudentDTO student = new StudentDTO(Integer.parseInt(id), txtFistName, txtLastName, txtEmail, txtGender, txtAddress, Integer.parseInt(txtIdClass));
            // call dao to update student
            dao.update(student);
            // send redirect to list student
            response.sendRedirect("StudentController?action=list");
        } else if ("order".equals(action)) {
            List<StudentDTO> orderStudents = dao.orderStudents();
            request.setAttribute("students", orderStudents);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        } else if ("AddNew".equals(action)) {
            //B1. get list class / theloai
            ClassDAO classDao = new ClassDAO();
            List<ClassDTO> classes = classDao.getClasses();
            //B2. set list vao request rồi đẩy sang trang newStudent.jsp
            request.setAttribute("classes", classes);
            request.getRequestDispatcher("newStudent.jsp").forward(request, response);
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
