package com.alex.servlets;

import com.alex.dao.LaptopDAO;
import com.alex.dao.LaptopDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DeleteServlet",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    private LaptopDAO dao = new LaptopDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            dao.deleteLaptop(Long.parseLong(id));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("Laptop with id " + id + " has been deleted!");
        out.flush();
        out.close();
    }
}
