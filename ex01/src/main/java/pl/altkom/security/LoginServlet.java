package pl.altkom.security;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Copyright 2016-06-11 the original author or authors.
 */
@WebServlet(name = "MyServlet", urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("LOGIN");
        
        String user = request.getParameter("login");
        String pass = request.getParameter("pass");

        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        JdbcTemplate jdbc = wac.getBean(JdbcTemplate.class);
        
        String sql = "select * from users where login = '" + user + "' and pass = '" + pass + "'";
        
        System.out.println(sql);
        
        List<Map<String, Object>> res = jdbc.queryForList(sql);
        
        System.out.println(res);
        
        ServletOutputStream out = response.getOutputStream();
        
        if(res.size() > 0)
            out.println("zalogowany");
        else 
            out.println("nie zalogowany");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        
        
        
        
    }
}
