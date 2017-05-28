package com.alex.dao.connection;

import com.alex.domain.Laptop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Executor {

    private static Logger LOGGER = LoggerFactory.getLogger(Executor.class.getName());


    public boolean insertLaptop(Laptop laptop, String query) {
        try (ConnectionProxy connectionProxy = TransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connectionProxy.prepareStatement(query)) {
            statement.setInt(1, laptop.getRam());
            statement.setString(2, laptop.getCpu());
            statement.setString(3, laptop.getScreen());
            statement.setInt(4, laptop.getPrice());
            statement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    public Laptop findById(Long id, String query)  {
        Laptop laptop = null;
        try (ConnectionProxy connectionProxy = TransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connectionProxy.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptop = new Laptop(resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
            }
            return laptop;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new IllegalStateException("problem with executing query", e);
        }
    }

    public List<Laptop> getAllLaptops(String query)  {
        List<Laptop> list = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionHelper.getInstance().getConnection();
             Statement statement = connectionProxy.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(new Laptop(resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new IllegalStateException("problem with executing query", e);
        }
        return list;
    }

    public void deleteLaptop(Long id, String query)  {
        try (ConnectionProxy connectionProxy = TransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connectionProxy.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            LOGGER.info("Deleted successfully!");
        } catch (SQLException e) {
            LOGGER.error("SQL exception (request or table failed): " + e);
        }
    }

    public Laptop updateLaptop(Laptop laptop, String query) {
        try (ConnectionProxy connectionProxy = TransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connectionProxy.prepareStatement(query)) {
            statement.setInt(1, laptop.getRam());
            statement.setString(2, laptop.getCpu());
            statement.setString(3, laptop.getScreen());
            statement.setInt(4, laptop.getPrice());
            statement.setLong(5, laptop.getId());
            statement.executeUpdate();
            LOGGER.info("Updated successfully!");
            LOGGER.info(laptop.toString());
        } catch (SQLException e) {
            LOGGER.error("SQL exception (request or table failed): " + e);
        }
        return laptop;
    }
}
