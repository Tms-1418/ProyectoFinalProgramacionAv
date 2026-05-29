package com.mycompany.proyectofinalpa.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/InicioSesionServlet"})
public class InicioSesionServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
            throws ServletException, IOException{
        
        String password = request.getParameter("password");
        
        if(password.equals("2026")){
            response.sendRedirect("jsp/panel.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + 
                    "jsp/inicioSesion.jsp");
        }
    }
}