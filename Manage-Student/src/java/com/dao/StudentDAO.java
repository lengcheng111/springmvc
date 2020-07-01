package com.dao;

import com.model.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD student table
 *
 * @author truonglv
 */
public class StudentDAO {

    public List<StudentDTO> getStudents() throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "SELECT * FROM public.\"student\""; // order by id asc
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<StudentDTO> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idClass = resultSet.getInt("id_class");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                String ipAddress = resultSet.getString("ip_address");
                students.add(new StudentDTO(id, firstName, lastName, email, gender, ipAddress, idClass));
            }
            return students;
        } finally {
            Connector.closeConnection();
        }
    }

    public List<StudentDTO> orderStudents() throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "SELECT * FROM public.\"student\" order by first_name"; // order by id asc
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<StudentDTO> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idClass = resultSet.getInt("id_class");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                String ipAddress = resultSet.getString("ip_address");
                students.add(new StudentDTO(id, firstName, lastName, email, gender, ipAddress, idClass));
            }
            return students;
        } finally {
            Connector.closeConnection();
        }
    }

    public List<StudentDTO> searchStudent(String nameSearch) throws SQLException, ClassNotFoundException {
        List<StudentDTO> students = new ArrayList<>();
        try {
            Connection connect = Connector.connect();
            String query = "SELECT * FROM public.\"student\" where first_name like ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, "%" + nameSearch + "%");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idClass = resultSet.getInt("id_class");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                String ipAddress = resultSet.getString("ip_address");
                students.add(new StudentDTO(id, firstName, lastName, email, gender, ipAddress, idClass));
            }
        } finally {
            Connector.closeConnection();
        }
        return students;
    }

    public StudentDTO getStudentById(int id) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "select * from public.\"student\" where id = ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                int idData = resultSet.getInt("id");
                int idClass = resultSet.getInt("id_class");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                String ipAddress = resultSet.getString("ip_address");
                return new StudentDTO(idData, firstName, lastName, email, gender, ipAddress, idClass);
            }
            return null;
        } finally {
            Connector.closeConnection();
        }
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "delete from public.\"student\" where id = ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }

    public int insert(StudentDTO student) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "INSERT INTO public.student( id, first_name, last_name, email, gender, ip_address, id_class) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, student.getId());
            prepareStatement.setString(2, student.getFirstName());
            prepareStatement.setString(3, student.getLastName());
            prepareStatement.setString(4, student.getEmail());
            prepareStatement.setString(5, student.getGender());
            prepareStatement.setString(6, student.getIpAddress());
            prepareStatement.setInt(7, student.getIdClass());
            return prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }

    public int update(StudentDTO student) throws SQLException, ClassNotFoundException {
        String query = "UPDATE public.student SET first_name=?, last_name=?, email=?, gender=?, ip_address=?, id_class=? WHERE id=?;";
        try {
            Connection connect = Connector.connect();
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, student.getFirstName());
            prepareStatement.setString(2, student.getLastName());
            prepareStatement.setString(3, student.getEmail());
            prepareStatement.setString(4, student.getGender());
            prepareStatement.setString(5, student.getIpAddress());
            prepareStatement.setInt(6, student.getIdClass());
            prepareStatement.setInt(7, student.getId());
            return prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }
}
