package com.mycompany.proyectofinalpa.controller;

import com.mycompany.proyectofinalpa.conexion.TDBTurnosMedicos;
import com.mycompany.proyectofinalpa.model.SignosVitales;
import com.mycompany.proyectofinalpa.model.TurnoMedico;
import com.mycompany.proyectofinalpa.structures.ColaTriaje;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TriajeServlet")
public class TriajeServlet extends HttpServlet {

    private static ColaTriaje cola = new ColaTriaje();

    private int calcularNivelTriaje(SignosVitales sv) {
        double temp = sv.getTemperatura();
        int fc = sv.getFrecuenciaCardiaca();
        int sat = sv.getSaturacionOxigeno();
        int dolor = sv.getNivelDolor();

        if (sat < 85 || fc > 150 || temp > 40) return 1;
        if (sat < 90 || fc > 120 || temp > 39) return 2;
        if (dolor >= 7 || temp > 38)            return 3;
        if (dolor >= 4)                          return 4;
        return 5;
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombrePaciente = request.getParameter("nombrePaciente");
            double temperatura = Double.parseDouble(request.getParameter("temperatura"));
            int frecuenciaCardiaca = Integer.parseInt(request.getParameter("frecuenciaCardiaca"));
            int saturacionOxigeno = Integer.parseInt(request.getParameter("saturacionOxigeno"));
            int nivelDolor = Integer.parseInt(request.getParameter("nivelDolor"));
            String motivoConsulta = request.getParameter("motivoConsulta");
            String fechaIngreso = request.getParameter("fechaIngreso");

            SignosVitales sv = new SignosVitales();
            sv.setTemperatura(temperatura);
            sv.setFrecuenciaCardiaca(frecuenciaCardiaca);
            sv.setSaturacionOxigeno(saturacionOxigeno);
            sv.setNivelDolor(nivelDolor);
            sv.setMotivoConsulta(motivoConsulta);

            int nivelTriaje = calcularNivelTriaje(sv);

            TurnoMedico turno = new TurnoMedico();
            turno.setNombrePaciente(nombrePaciente);
            turno.setCodigoTurno("T-" + System.currentTimeMillis());
            turno.setNivelTriaje(nivelTriaje);
            turno.setEstado("EN ESPERA");
            turno.setFechaIngreso(fechaIngreso);

            TDBTurnosMedicos tdb = new TDBTurnosMedicos();
            tdb.insertarTurnoMedico(turno);
            cola.encolar(turno);

            response.sendRedirect(request.getContextPath() + "/jsp/salaEspera.jsp");

        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect(request.getContextPath() + "/jsp/triaje.jsp");
        }
    }

    public static ColaTriaje getCola() {
        return cola;
    }
}