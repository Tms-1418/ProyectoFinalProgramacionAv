<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Módulo de Triaje</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

    <div class="container">

        <h1>Módulo de Triaje</h1>

        <div class="card">

            <h2>Generar Turno Médico</h2>

            <form action="${pageContext.request.contextPath}/TriageServlet" method="POST">

                <label>
                    ID Paciente
                </label>

                <input
                    type="number"
                    name="pacId"
                    required
                >

                <label>
                    Código del Turno
                </label>

                <input
                    type="text"
                    name="codigoTurno"
                    placeholder="Ejemplo: A-15"
                    required
                >

                <label>
                    Nivel de Triaje
                </label>

                <select name="nivelTriaje">

                    <option value="1">
                        Nivel 1 - Reanimación
                    </option>

                    <option value="2">
                        Nivel 2 - Emergencia
                    </option>

                    <option value="3">
                        Nivel 3 - Urgencia
                    </option>

                    <option value="4">
                        Nivel 4 - Prioritario
                    </option>

                    <option value="5">
                        Nivel 5 - No urgente
                    </option>

                </select>

                <label>
                    Estado
                </label>

                <select name="estado">

                    <option value="EN_ESPERA">
                        En Espera
                    </option>

                    <option value="EN_ATENCION">
                        En Atención
                    </option>

                    <option value="FINALIZADO">
                        Finalizado
                    </option>

                </select>

                <label>
                    Fecha de Ingreso
                </label>

                <input
                    type="datetime-local"
                    name="fechaIngreso"
                    required
                >

                <button type="submit">
                    Generar Turno
                </button>

            </form>

        </div>

    </div>

</body>

</html>