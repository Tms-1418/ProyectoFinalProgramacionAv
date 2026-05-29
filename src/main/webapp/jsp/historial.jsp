<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.proyectofinalpa.conexion.TDBRegistroAtencion"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Historial de Atención</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

    <div class="container">

        <h1>Historial de Atención</h1>

        <div class="card">

            <h2>Registros Médicos</h2>

            <table>

                <thead>

                    <tr>

                        <th>Código Turno</th>
                        <th>Documento Paciente</th>
                        <th>Nombre Paciente</th>
                        <th>Médico</th>
                        <th>Rol Médico</th>
                    
                    </tr>

                </thead>

                <tbody>

                    <%
                        TDBRegistroAtencion tdb = new TDBRegistroAtencion();
                        ResultSet rs = tdb.getRegistrosAtencion();
                        while(rs.next()){
                    %>
                    <tr>
                        <td><%= rs.getString("tur_codigoTurno") %></td>
                        <td><%= rs.getString("pac_documento") %></td>
                        <td><%= rs.getString("pac_nombre") %></td>
                        <td><%= rs.getString("med_nombre") %></td>
                        <td><%= rs.getString("med_rol") %></td>
                    </tr>
                    <%
                        }
                        rs.close();
                    %>

                </tbody>

            </table>

        </div>

    </div>

</body>

</html>