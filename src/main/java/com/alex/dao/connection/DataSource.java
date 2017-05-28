package com.alex.dao.connection;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static final DataSource instance = new DataSource();
    private final PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
    private static Logger LOGGER = LoggerFactory.getLogger(DataSource.class.getName());

    private DataSource(){
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/database.properties"));
            Class.forName(properties.getProperty("db.driver"));
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUser(properties.getProperty("db.user"));
            dataSource.setPassword(properties.getProperty("db.password"));
        }  catch (IOException e) {
            LOGGER.error("problem with reading properties file ", e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("problem with loading sql driver ", e);
        }
    }

    public static DataSource getInstance(){
        return instance;
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("some problem with database connection ", e);
            return null;
        }
    }
}
