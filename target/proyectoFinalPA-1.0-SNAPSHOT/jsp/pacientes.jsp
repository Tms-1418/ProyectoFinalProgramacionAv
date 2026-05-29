<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.proyectofinalpa.conexion.TDBPacientes"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Gestión de Pacientes</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>
    
    <% if("1".equals(request.getParameter("exito"))){ %>
        <script>alert("Paciente registrado exitosamente.");</script>
    <% } %>

    <div class="container">

        <h1>Gestión de Pacientes</h1>

        <div class="card">

            <h2>Registrar Paciente</h2>

            <form action="${pageContext.request.contextPath}/PacienteServlet"
                  method="POST">
                <input type="hidden" name="accion" value="insertar">
                <label>Documento</label>
                <input type="number" name="documento" required>
                <label>Nombre Completo</label>
                <input type="text" name="nombre" required>
                <label>Fecha de Nacimiento</label>
                <input type="date" name="fechaNacimiento" required>
                <label>Género</label>
                <select name="genero">
                    <option value ="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                    <option value="Otro">Otro</option>
                </select>
                <label>Información Especial</label>
                <textarea name="informacionEspecial" rows="4"
                    placeholder="Alergias, embarazo, discapacidad, etc."></textarea>
                <button type="submit">Registrar Paciente</button>
            </form>
        </div>
                  
                  <div class="card" style="margin-top: 30px;">
                      <h2>Actualizar Paciente</h2>
                      <table>
                          <thead>
                              <tr>
                                  <th>Documento</th>
                                  <th>Nombre</th>
                                  <th>Fecha Nacimiento</th>
                                  <th>Género</th>
                                  <th>Info Especial</th>
                                  <th>Acción</th>
                              </tr>
                          </thead>
                          <tbody>
                                <%
                                  TDBPacientes tdb = new TDBPacientes();
                                  ResultSet rs = tdb.getPacientes();
                                  while(rs.next()){
                                %>
                                <tr>
                                    <td><%= rs.getString("pac_documento") %></td>
                                    <td><%= rs.getString("pac_nombre") %></td>
                                    <td><%= rs.getString("pac_fechaNacimiento") %></td>
                                    <td><%= rs.getString("pac_genero") %></td>
                                    <td><%= rs.getString("pac_informacionEspecial") %></td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/PacienteServlet"
                                              method="POST">
                                            <input type="hidden" name="accion" value="actualizar">
                                            <input type="hidden" name="id" value="<%= rs.getInt("pac_id") %>">
                                            <input type="text" name="nombre" value="<%= rs.getString("pac_nombre") %>">
                                            <button type="submit">Actualizar</button>
                                        </form>
                                    </td>
                                </tr>
                               
                                <% } %>
                                
                          </tbody>
                      </table>
                  </div>

    </div>

</body>

</html>