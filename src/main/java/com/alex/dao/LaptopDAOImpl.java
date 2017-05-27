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
    private final static String insertLaptop="INSERT INTO laptop\n" +
            "(ram, cpu, screen,price)\n" +
            "VALUES(?,?,?,?);";


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
    @Override
    public Laptop insertLaptop(Laptop laptop) throws IOException, PropertyVetoException {
            try(Connection connection = DataSource.getInstance().getConnection();
                PreparedStatement st = connection.prepareStatement(insertLaptop, Statement.RETURN_GENERATED_KEYS)) {
                st.setInt(1, laptop.getRam());
                st.setString(2, laptop.getCpu());
                st.setString(3, laptop.getScreen());
                st.setInt(4, laptop.getPrice());
                st.executeUpdate();
                //retrieve generated id from database
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        laptop.setId(generatedKeys.getLong(1));
                    }
                    else {
                        throw new SQLException("No id obtained.");
                    }
                }
                System.out.println("Inserted successfully!");
                System.out.println(laptop);
            } catch (SQLException e) {
                System.err.println("SQL exception (request or table failed): " + e);
            }

        return laptop;
    }
}
