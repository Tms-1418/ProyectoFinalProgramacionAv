package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.model.Paciente;
import com.mycompany.proyectofinalpa.conexion.TDBPacientes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {
    
    TDBPacientes db = new TDBPacientes();
    
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if("insertar".equals(accion)){
            int documento = Integer.parseInt(request.getParameter("documento"));
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
            response.sendRedirect(request.getContextPath()+ 
                "jsp/pacientes.jsp");
        }else if("actualizar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            
            Paciente paciente = new Paciente();
            paciente.setId(id);
            paciente.setNombre(nombre);
            
            db.actualizarPaciente(paciente);
            response.sendRedirect(request.getContextPath()+ 
                    "/jsp/pacientes.jsp?exito=2");
            
        }
    }
}