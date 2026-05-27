package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.conexion.TDBTurnosMedicos;

import com.mycompany.proyectofinalpa.model.TurnoMedico;
import com.mycompany.proyectofinalpa.structures.ColaTriaje;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TriajeServlet")
public class TriageServlet extends HttpServlet {

    // COLA GLOBAL DEL SISTEMA
    private static ColaTriaje cola = new ColaTriaje();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int pacId = Integer.parseInt(
                    request.getParameter("paciente")
            );

            int nivelTriaje = Integer.parseInt(
                    request.getParameter("nivelTriaje")
            );

            TurnoMedico turno = new TurnoMedico();

            turno.setPacId(pacId);

            String codigoTurno = "T-" + System.currentTimeMillis();

            turno.setCodigoTurno(codigoTurno);

            turno.setNivelTriaje(nivelTriaje);

            turno.setEstado("EN ESPERA");

            LocalDateTime fechaActual = LocalDateTime.now();

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            turno.setFechaIngreso(
                    fechaActual.format(formato)
            );

            TDBTurnosMedicos tdb =
                    new TDBTurnosMedicos();

            tdb.insertarTurnoMedico(turno);

            cola.encolar(turno);

            response.sendRedirect(
                    request.getContextPath()
                    + "/jsp/waitingRoom.jsp"
            );
 
        } catch (Exception e) {

            System.out.println(e);

            response.sendRedirect(
                    request.getContextPath()
                    + "/jsp/triage.jsp"
            );

        }

    }

    // MÉTODO PARA QUE DOCTORSERVLET
    // PUEDA ACCEDER A LA COLA
    public static ColaTriaje getCola() {

        return cola;

    }

}