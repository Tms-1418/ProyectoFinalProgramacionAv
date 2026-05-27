<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Gestión de Pacientes</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

    <div class="container">

        <h1>Gestión de Pacientes</h1>

        <div class="card">

            <h2>Registrar Paciente</h2>

            <form action="${pageContext.request.contextPath}/PatientServlet"
                  method="POST">

                <label>
                    Documento
                </label>

                <input
                    type="number"
                    name="documento"
                    required
                >

                <label>
                    Nombre Completo
                </label>

                <input
                    type="text"
                    name="nombre"
                    required
                >

                <label>
                    Fecha de Nacimiento
                </label>

                <input
                    type="date"
                    name="fechaNacimiento"
                    required
                >

                <label>
                    Género
                </label>

                <select name="genero">

                    <option value="Masculino">
                        Masculino
                    </option>

                    <option value="Femenino">
                        Femenino
                    </option>

                    <option value="Otro">
                        Otro
                    </option>

                </select>

                <label>
                    Información Especial
                </label>

                <textarea
                    name="informacionEspecial"
                    rows="4"
                    placeholder="Alergias, embarazo, discapacidad, etc.">
                </textarea>

                <button type="submit">
                    Registrar Paciente
                </button>

            </form>

        </div>

    </div>

</body>

</html>