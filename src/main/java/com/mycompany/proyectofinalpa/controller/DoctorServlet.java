package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.conexion.TDBMedicos;
import com.mycompany.proyectofinalpa.conexion.TDBRegistroAtencion;
import com.mycompany.proyectofinalpa.model.RegistroAtencion;
import com.mycompany.proyectofinalpa.model.TurnoMedico;
import com.mycompany.proyectofinalpa.structures.ColaTriaje;
import java.io.IOException;
import java.sql.ResultSet;
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
        try {
            String nombreMedico = request.getParameter("nombreMedico");
            int turId = Integer.parseInt(request.getParameter("turId"));

            // Buscar médico por nombre en la BD
            TDBMedicos tdbMedicos = new TDBMedicos();
            ResultSet rsMedico = tdbMedicos.getMedicos();
            int medId = -1;
            while(rsMedico.next()){
                if(rsMedico.getString("med_nombre").equalsIgnoreCase(nombreMedico)){
                    medId = rsMedico.getInt("med_id");
                    break;
                }
            }

            if(medId == -1){
                // Médico no encontrado
                response.sendRedirect(request.getContextPath() + "/jsp/doctorPanel.jsp?error=1");
                return;
            }

            // Guardar registro de atención
            RegistroAtencion registro = new RegistroAtencion();
            registro.setTurId(turId);
            registro.setMedId(medId);

            TDBRegistroAtencion tdbRegistro = new TDBRegistroAtencion();
            tdbRegistro.insertarRegistroAtencion(registro);

            // Desencolar de la ColaTriaje
            ColaTriaje cola = TriajeServlet.getCola();
            cola.desencolar();

            response.sendRedirect(request.getContextPath() + "/jsp/doctorPanel.jsp?exito=1");

        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect(request.getContextPath() + "/jsp/doctorPanel.jsp?error=2");
        }
    }
}