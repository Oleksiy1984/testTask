package com.alex.servlets;

import com.alex.dao.LaptopDAOImpl;
import com.alex.domain.Laptop;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertLaptopServlet",urlPatterns = { "/add" })
public class InsertLaptopServlet extends HttpServlet {

    private LaptopDAOImpl dao = new LaptopDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Laptop laptop = new Gson().fromJson(sb.toString(), Laptop.class);

        try {
            dao.insertLaptop(laptop);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("A new laptop " + laptop + " has been created.");
        out.flush();
        out.close();
    }
}
