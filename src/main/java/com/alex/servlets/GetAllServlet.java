package com.alex.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alex.dao.MyLaptopDAO;
import com.google.gson.Gson;

@WebServlet(name = "GetAllServlet",urlPatterns = { "/laptops" })
public class GetAllServlet extends javax.servlet.http.HttpServlet {

    private MyLaptopDAO dao = new MyLaptopDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = null;
        json = new Gson().toJson(dao.getAll());
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
