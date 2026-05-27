<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Sala de Espera</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

    <div class="container">

        <h1>Sala de Espera</h1>

        <div class="card">

            <h2>Turnos Actuales</h2>

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
                            EN ESPERA
                        </td>

                    </tr>

                    <tr>

                        <td>
                            B-03
                        </td>

                        <td>
                            4
                        </td>

                        <td>
                            EN ATENCIÓN
                        </td>

                    </tr>

                    <tr>

                        <td>
                            C-11
                        </td>

                        <td>
                            1
                        </td>

                        <td>
                            EN ESPERA
                        </td>

                    </tr>

                </tbody>

            </table>

        </div>

    </div>

</body>

</html>