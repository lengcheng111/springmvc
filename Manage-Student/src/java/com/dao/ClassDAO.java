/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ClassDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truonglv
 */
public class ClassDAO {

    public List<ClassDTO> getClasses() throws SQLException, ClassNotFoundException {
        try {
            Connection connect = Connector.connect();
            String query = "SELECT * FROM public.\"class\"";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<ClassDTO> classes = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classes.add(new ClassDTO(id, name));
            }
            return classes;
        } finally {
            Connector.closeConnection();
        }
    }
}
