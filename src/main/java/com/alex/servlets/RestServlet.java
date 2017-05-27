package com.alex.servlets;



import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex.dao.LaptopDAOImpl;
import com.alex.domain.Laptop;
import com.google.gson.Gson;

@WebServlet(name = "RestServlet",urlPatterns = { "/all" })
public class RestServlet extends javax.servlet.http.HttpServlet {

    private LaptopDAOImpl dao=new LaptopDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String configJson=null;
        try {
            configJson = new Gson().toJson(dao.getAllLaptops());
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().write(configJson);
    }
}
