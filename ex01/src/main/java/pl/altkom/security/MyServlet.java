package pl.altkom.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Copyright 2016-06-11 the original author or authors.
 */
@WebServlet(name = "MyServlet", urlPatterns = "/test")
public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("GET");

        Map<String, String[]> params = request.getParameterMap();

        for(Map.Entry<String, String[]> item : params.entrySet()) {
            System.out.println(item.getKey() + " -> " + Arrays.toString(item.getValue()));
        }

    }
}
