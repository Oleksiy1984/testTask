package com.alex.servlets;

import com.alex.dao.MyLaptopDAO;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "FindByIdServlet",urlPatterns = { "/laptop" })
public class FindByIdServlet extends HttpServlet {

    private String json = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        json = new Gson().toJson(MyLaptopDAO.getInstance().findById(Long.parseLong(id)));
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
