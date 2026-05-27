package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.model.Paciente;
import com.mycompany.proyectofinalpa.conexion.TDBPacientes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PatientServlet", urlPatterns = {"/PatientServlet"})
public class PatientServlet extends HttpServlet {
    
    TDBPacientes db = new TDBPacientes();
    
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int documento = Integer.parseInt(
                request.getParameter("documento")
        );
        
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        String informacionEspecial = 
                request.getParameter("informacionEspecial");
        
         Paciente paciente = new Paciente();

        paciente.setDocumento(documento);
        paciente.setNombre(nombre);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setGenero(genero);
        paciente.setInformacionEspecial(informacionEspecial);
        
        
        db.insertarPaciente(paciente);
        
        System.out.println("Paciente registrado:");
        System.out.println(paciente.getNombre());

        response.sendRedirect("patients.jsp");

    }
}