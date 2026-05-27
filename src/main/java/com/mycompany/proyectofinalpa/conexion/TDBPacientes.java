/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalpa.conexion;

import java.sql.*;
import com.mycompany.proyectofinalpa.model.Paciente;

/**
 *
 * @author Usuario
 */
public class TDBPacientes {

    DBConexion cn;

    public TDBPacientes() {
        cn = new DBConexion();
    }

    public ResultSet getPacienteById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pac_id, "
                + " pac_documento, "
                + " pac_nombre, "
                + " pac_fechaNacimiento, "
                + " pac_genero, "
                + " pac_informacionEspecial "
                + " FROM pacientes "
                + " WHERE pac_id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        return res;
    }

    /**
     * trae todos los registros de la tabla pacientes
     */
    public ResultSet getPacientes() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pac_id, "
                + " pac_documento, "
                + " pac_nombre, "
                + " pac_fechaNacimiento, "
                + " pac_genero, "
                + " pac_informacionEspecial "
                + " FROM pacientes "
                + " ORDER BY pac_nombre");

        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarPaciente(Paciente p) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into pacientes (pac_documento, "
                    + " pac_nombre, "
                    + " pac_fechaNacimiento, "
                    + " pac_genero, "
                    + " pac_informacionEspecial) "
                    + " values(?,?,?,?,?)");
            
            pstm.setInt(1, p.getDocumento());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getFechaNacimiento()); // Retorna un String en formato 'YYYY-MM-DD'
            pstm.setString(4, p.getGenero());
            pstm.setString(5, p.getInformacionEspecial());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizarPaciente(Paciente p) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update pacientes set pac_documento = ?, "
                    + " pac_nombre = ?,"
                    + " pac_fechaNacimiento = ?,"
                    + " pac_genero = ?,"
                    + " pac_informacionEspecial = ? " 
                    + " where pac_id = ?");
            
            pstm.setInt(1, p.getDocumento());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getFechaNacimiento());
            pstm.setString(4, p.getGenero());
            pstm.setString(5, p.getInformacionEspecial());
            pstm.setInt(6, p.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void borrarPaciente(Paciente p) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from pacientes "
                    + " where pac_id = ?");

            pstm.setInt(1, p.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}