package com.alex.dao.connection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;


public class ConnectionProxy implements AutoCloseable {

    private final Connection connection;
    private static Logger LOGGER = LoggerFactory.getLogger(ConnectionProxy.class.getName());

    public ConnectionProxy(Connection connection){
        this.connection = connection;
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void begin(){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.error("some problem with database connection ", e);
        }
    }

    public void commit(){
        try {
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("some problem with database connection ", e);
        }
    }

    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error("some problem with database connection ", e);
        }
    }

    public void close() {
        if (!TransactionHelper.getInstance().isTransactionActive()) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("some problem with database connection ", e);
            }
        }
    }
}
