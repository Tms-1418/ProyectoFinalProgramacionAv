<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">

    <title>Dashboard</title>

   <link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/styles.css?v=2">

</head>

<body>

    <div class="container">

        <h1>
            Sistema de Triaje Hospitalario
        </h1>

        <div class="card">

            <h2>
                Panel Principal
            </h2>

            <div class="dashboard-grid">

                <a class="dashboard-card"
                   href="${pageContext.request.contextPath}/jsp/patients.jsp">

                    Gestión de Pacientes

                </a>

                <a class="dashboard-card"
                   href="${pageContext.request.contextPath}/jsp/triage.jsp">

                    Módulo de Triaje

                </a>

                <a class="dashboard-card"
                   href="${pageContext.request.contextPath}/jsp/waitingRoom.jsp">

                    Sala de Espera

                </a>

                <a class="dashboard-card"
                   href="${pageContext.request.contextPath}/jsp/doctorPanel.jsp">

                    Panel Médico

                </a>

                <a class="dashboard-card"
                   href="${pageContext.request.contextPath}/jsp/history.jsp">

                    Historial de Atención

                </a>

                <a class="dashboard-card logout"
                   href="${pageContext.request.contextPath}/jsp/login.jsp">

                    Cerrar Sesión

                </a>

            </div>

        </div>

    </div>

</body>

</html>