package com.alex.dao;

import com.alex.domain.Laptop;

import java.util.List;

public class MyLaptopDAO extends AbstractDao<Laptop> {

    private final static String getAll = "SELECT * FROM laptop";
    private final static String getById = "SELECT * FROM laptop WHERE id=?";
    private final static String insertLaptop = "INSERT INTO laptop\n" +
            "(ram, cpu, screen,price)\n" +
            "VALUES(?,?,?,?);";
    private final static String updateLaptop = "UPDATE laptop SET ram = ?,cpu=?," +
            "screen=?,price=? WHERE id = ?";
    private final static String delete = "DELETE FROM laptop " +
            "WHERE id = ?";


    public boolean insert(Laptop laptop) {
        return getExecutor().insertLaptop(laptop, insertLaptop);
    }

    public Laptop findById(Long id) {
        return getExecutor().findById(id, getById);
    }

    public List<Laptop> getAll(){
        return getExecutor().getAllLaptops(getAll);
    }
    public void delete (Long id){
        getExecutor().deleteLaptop(id,delete);
    }
    public Laptop update(Laptop laptop){
        return getExecutor().updateLaptop(laptop,updateLaptop);
    }
}
