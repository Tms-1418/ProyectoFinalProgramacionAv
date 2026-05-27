package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.model.RegistroAtencion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DoctorServlet", urlPatterns = {"/DoctorServlet"})
public class DoctorServlet extends HttpServlet {

    @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
       
       int turId = Integer.parseInt(request.getParameter("turId"));
       
       int medId = Integer.parseInt(request.getParameter("medId"));
       
       RegistroAtencion registro = new RegistroAtencion();
       
       registro.setTurId(turId);
       registro.setMedId(medId);
       
       System.out.println("Paciente atendido");
       System.out.println("Turno: " + registro.getTurId());
       
       response.sendRedirect("jsp/doctorPanel.jsp");
   }   
}