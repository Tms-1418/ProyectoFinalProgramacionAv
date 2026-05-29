<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Inicio de Sesión</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>
    
    <% if("1".equals(request.getParameter("error"))){ %>
        <script>alert("Contraseña incorrecta. Intente de nuevo.");</script>
    <% } %>

    <div class="container">

        <div class="card">

            <h1>Sistema de Triaje Hospitalario</h1>

            <p>
                Acceso exclusivo para personal autorizado de la clínica.
            </p>

            <form action="${pageContext.request.contextPath}/InicioSesionServlet"
                  method="POST">

                <label>
                    Contraseña
                </label>

                <input
                    type="password"
                    name="password"
                    placeholder="Ingrese la contraseña"
                    required
                >

                <button type="submit">
                    Ingresar al Sistema
                </button>

            </form>

            <div class="note">

                <p>
                    <strong>Nota para evaluación:</strong>
                </p>

                <p>
                    Contraseña de acceso: <strong>2026</strong>
                </p>

            </div>

        </div>

    </div>

</body>

</html>