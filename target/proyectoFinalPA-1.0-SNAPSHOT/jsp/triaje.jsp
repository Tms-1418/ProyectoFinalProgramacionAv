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
            <form action="${pageContext.request.contextPath}/TriajeServlet" method="POST">
                <label>Nombre del Paciente</label>
                <input type="text" name="nombrePaciente" required>

                <label>Temperatura (°C)</label>
                <input type="number" step="0.1" name="temperatura" required>

                <label>Frecuencia Cardíaca (bpm)</label>
                <input type="number" name="frecuenciaCardiaca" required>

                <label>Saturación de Oxígeno (%)</label>
                <input type="number" name="saturacionOxigeno" required>

                <label>Nivel de Dolor (1-10)</label>
                <input type="number" name="nivelDolor" min="1" max="10" required>

                <label>Motivo de Consulta</label>
                <textarea name="motivoConsulta" rows="4" 
                    placeholder="Describa el motivo de consulta"></textarea>

                <label>Fecha de Ingreso</label>
                <input type="date" name="fechaIngreso" required>

                <button type="submit">Generar Turno</button>
            </form>
        </div>
    </div>
</body>
</html>