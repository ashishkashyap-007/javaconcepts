package com.ashish.java.concepts.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DoPostExampleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");

        out.println("<html><body>");
        out.println("<h1>POST Request Received</h1>");
        out.println("<p>Hello, " + name + "!</p>");
        out.println("</body></html>");
    }
}
