/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalpa.conexion;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class DBConexion {

    static String bd = "triajeurgencias";
    static String login = "root";
    static String password = "mysql";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String mensaje = "";

    Connection conexion = null;

    public DBConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, password);

            if (conexion != null) {
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        } catch (ClassNotFoundException e) {
            mensaje = e.getMessage();
        }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión a base de datos cerrada correctamente.");
            }
        } catch (SQLException e) {
            mensaje = "Error al cerrar la conexión: " + e.getMessage();
            System.err.println(mensaje);
        }
    }
}
