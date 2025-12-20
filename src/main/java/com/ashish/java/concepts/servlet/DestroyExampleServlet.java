package com.ashish.java.concepts.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.SQLException;

public class DestroyExampleServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //Initialization logic similar to InitExampleServlet
    }

    @Override
    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
