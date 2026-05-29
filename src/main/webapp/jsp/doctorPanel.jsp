<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.proyectofinalpa.structures.ColaTriaje"%>
<%@page import="com.mycompany.proyectofinalpa.controller.TriajeServlet"%>
<%@page import="com.mycompany.proyectofinalpa.model.TurnoMedico"%>

<!DOCTYPE html>
<html>
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Panel Médico</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
    <% if("1".equals(request.getParameter("exito"))){ %>
        <script>alert("Atención finalizada correctamente.");</script>
    <% } %>
    <% if("1".equals(request.getParameter("error"))){ %>
        <script>alert("Médico no encontrado. Verifique el nombre.");</script>
    <% } %>
    
    <div class="container">
        <h1>Panel Médico</h1>
        <div class="card">
            <h2>Paciente Actual</h2>
            <%
                ColaTriaje cola = TriajeServlet.getCola();
                TurnoMedico turno = cola.verSiguiente();
                if(turno != null){
            %>
            <table>
                <thead>
                    <tr>
                        <th>Código Turno</th>
                        <th>Nombre Paciente</th>
                        <th>Nivel Triaje</th>
                        <th>Estado</th>
                        <th>Fecha Ingreso</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%= turno.getCodigoTurno() %></td>
                        <td><%= turno.getNombrePaciente() %></td>
                        <td><%= turno.getNivelTriaje() %></td>
                        <td><%= turno.getEstado() %></td>
                        <td><%= turno.getFechaIngreso() %></td>
                    </tr>
                </tbody>
            </table>
            <div class="actions">
                <form action="${pageContext.request.contextPath}/DoctorServlet"
                      method="post">
                    <input type="hidden" name="turId" value="<%= turno.getId() %>">
                    <label>Nombre del Médico</label>
                    <input type="text" name="nombreMedico" required>
                    <button type="submit">Finalizar Atención</button>
                </form>
            </div>
            <%
                } else {
            %>
            <p>No hay pacientes en espera actualmente.</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>