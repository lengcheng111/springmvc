package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CRUD student table
 *
 * @author truonglv
 */
public class StudentDAO {

    public List<Student> getStudents() throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "SELECT id, name  FROM public.\"Student\"";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                students.add(new Student(id, name));
            }
            return students;
        } finally {
            Connector.closeConnection();
        }
    }

    public List<Student> searchStudent(String nameSearch) throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        try {
            Connection connect = Connector.connect();
            String query = "SELECT id, name FROM public.\"Student\" where name like ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, "%" + nameSearch + "%");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                students.add(new Student(id, name));
            }
        } finally {
            Connector.closeConnection();
        }
        return students;
    }

    public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "select * from public.\"Student\" where id = ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Student(id, name);
            }
            return null;
        } finally {
            Connector.closeConnection();
        }
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "delete from public.\"Student\" where id = ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }

    public int insert(Student student) throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "INSERT INTO public.\"Student\"(id, name)  VALUES (?, ?);";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setInt(1, student.getId());
            prepareStatement.setString(2, student.getName());
            return prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }

    public int update(Student student) throws SQLException, ClassNotFoundException {
        String query = "UPDATE public.\"Student\"  SET name=? WHERE id = ?;";
        try {
            Connection connect = Connector.connect();
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, student.getName());
            prepareStatement.setInt(2, student.getId());
            return prepareStatement.executeUpdate();
        } finally {
            Connector.closeConnection();
        }
    }
}
