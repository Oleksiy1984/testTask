package com.alex.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alex.dao.MyLaptopDAO;
import com.google.gson.Gson;

@WebServlet(name = "GetAllServlet",urlPatterns = { "/laptops" })
public class GetAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = null;
        json = new Gson().toJson(MyLaptopDAO.getInstance().getAll());
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
