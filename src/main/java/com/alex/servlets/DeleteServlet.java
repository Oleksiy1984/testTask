package com.alex.servlets;


import com.alex.dao.MyLaptopDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DeleteServlet",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    private MyLaptopDAO dao = new MyLaptopDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        dao.delete(Long.parseLong(id));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("Laptop with id " + id + " has been deleted!");
        out.flush();
        out.close();
    }
}
