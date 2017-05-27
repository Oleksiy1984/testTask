package com.alex.servlets;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alex.dao.LaptopDAOImpl;
import com.google.gson.Gson;

@WebServlet(name = "GetAllServlet",urlPatterns = { "/laptops" })
public class GetAllServlet extends javax.servlet.http.HttpServlet {

    private LaptopDAOImpl dao=new LaptopDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = null;
        try {
            json = new Gson().toJson(dao.getAllLaptops());
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
