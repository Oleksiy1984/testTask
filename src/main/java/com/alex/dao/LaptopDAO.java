package com.alex.dao;

import com.alex.domain.Laptop;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LaptopDAO {
    List<Laptop> getAllLaptops() throws SQLException, IOException, PropertyVetoException;
    void deleteLaptop (Long id);
    Laptop findById(Long id) throws SQLException,IOException,PropertyVetoException;
    Laptop insertLaptop(Laptop laptop) throws SQLException,IOException,PropertyVetoException;
}
