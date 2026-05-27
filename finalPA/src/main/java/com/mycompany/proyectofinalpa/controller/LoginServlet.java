package com.mycompany.proyectofinalpa.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
            throws ServletException, IOException{
        
        String password = request.getParameter("password");
        
        if(password.equals("2026")){
            response.sendRedirect("jsp/dashboard.jsp");
        }else {
            response.sendRedirect("jsp/login.jsp");
        }
    }
}