package com.alex.servlets;

import com.alex.dao.MyLaptopDAO;
import com.alex.domain.Laptop;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HttpServer", urlPatterns = {"/server"})
public class HttpServer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Laptop laptop = new Gson().fromJson(read(request).toString(), Laptop.class);
        MyLaptopDAO.getInstance().update(laptop);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write(laptop + " has been updated successfully!");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String json = new Gson().toJson(MyLaptopDAO.getInstance().findById(Long.parseLong(id)));
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Laptop laptop = new Gson().fromJson(read(request).toString(), Laptop.class);
        MyLaptopDAO.getInstance().insert(laptop);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("A new laptop " + laptop + " has been created.");
        out.flush();
        out.close();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MyLaptopDAO.getInstance().delete(Long.parseLong(id));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("Laptop with id " + id + " has been deleted!");
        out.flush();
        out.close();
    }

    private static StringBuffer read(HttpServletRequest request) {
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
        return sb;
    }

}
