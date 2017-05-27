package com.alex.servlets;

import com.alex.dao.LaptopDAOImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "FindByIdServlet",urlPatterns = { "/laptop" })
public class FindByIdServlet extends HttpServlet {

    private LaptopDAOImpl dao= new LaptopDAOImpl();
    private String configJson=null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        try {
            configJson = new Gson().toJson(dao.findById(Long.parseLong(id)));
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().write(configJson);
    }
}
