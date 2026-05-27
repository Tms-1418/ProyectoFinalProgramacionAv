<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Panel Médico</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

    <div class="container">

        <h1>Panel Médico</h1>

        <div class="card">

            <h2>Paciente Actual</h2>

            <table>

                <thead>

                    <tr>

                        <th>
                            Código Turno
                        </th>

                        <th>
                            Nivel Triaje
                        </th>

                        <th>
                            Estado
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <tr>

                        <td>
                            A-15
                        </td>

                        <td>
                            2
                        </td>

                        <td>
                            EN ATENCIÓN
                        </td>

                    </tr>

                </tbody>

            </table>

            <div class="actions">

                <form action="${pageContext.request.contextPath}/DoctorServlet"
                      method="post">

                    <input type="hidden"
                           name="turId"
                           value="15">

                    <input type="hidden"
                           name="medId"
                           value="1">

                    <button type="submit">
                        Finalizar Atención
                    </button>

                </form>

            </div>

        </div>

    </div>

</body>

</html>