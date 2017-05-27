package com.alex.dao;

import com.alex.domain.Laptop;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LaptopDAOImpl implements LaptopDAO{

    private final static String getAll ="SELECT * FROM laptop";
    private final static String getById ="SELECT * FROM laptop WHERE id=?";


    @Override
    public List<Laptop> getAllLaptops() throws SQLException, IOException, PropertyVetoException {
        List<Laptop> list=new ArrayList<>();
        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAll)){
            while (resultSet.next()) {
                list.add(new Laptop(resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        }
        return list;
    }

    @Override
    public void deleteLaptop(Long id) {

    }

    @Override
    public Laptop findById(Long id) throws IOException, PropertyVetoException, SQLException {
        Laptop laptop=null;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getById)
             ){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptop=new Laptop(resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
            }
        }
        return laptop;
    }
}
