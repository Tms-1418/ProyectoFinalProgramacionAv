/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalpa.conexion;

import java.sql.*;
import com.mycompany.proyectofinalpa.model.TurnoMedico; 

/**
 *
 * @author Usuario
 */
public class TDBTurnosMedicos {

    DBConexion cn;

    public TDBTurnosMedicos() {
        cn = new DBConexion();
    }

    public ResultSet getTurnoMedicoById(int id) throws SQLException {

        String sql = "SELECT tm.tur_id, "
                   + " tm.tur_pacid, "
                   + " p.pac_documento, " // Dato extraído de la tabla pacientes
                   + " p.pac_nombre, "    // Dato extraído de la tabla pacientes
                   + " tm.tur_codigoTurno, "
                   + " tm.tur_nivelTriaje, "
                   + " tm.tur_estado, "
                   + " tm.tur_fechaIngreso "
                   + " FROM turnos_medicos tm "
                   + " INNER JOIN pacientes p ON tm.tur_pacid = p.pac_id "
                   + " WHERE tm.tur_id = ? ";
                   
        PreparedStatement pstm = cn.getConexion().prepareStatement(sql);
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        return res;
    }

    /**
     * trae todos los registros de la tabla turnos_medicos combinados con el paciente
     */
    public ResultSet getTurnosMedicos() throws SQLException {
        String sql = "SELECT tm.tur_id, "
                   + " tm.tur_pacid, "
                   + " p.pac_documento, " 
                   + " p.pac_nombre, "    
                   + " tm.tur_codigoTurno, "
                   + " tm.tur_nivelTriaje, "
                   + " tm.tur_estado, "
                   + " tm.tur_fechaIngreso "
                   + " FROM turnos_medicos tm "
                   + " INNER JOIN pacientes p ON tm.tur_pacid = p.pac_id "
                   + " ORDER BY tm.tur_fechaIngreso DESC";

        PreparedStatement pstm = cn.getConexion().prepareStatement(sql);
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarTurnoMedico(TurnoMedico t) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into turnos_medicos (tur_pacid, "
                    + " tur_codigoTurno, "
                    + " tur_nivelTriaje, "
                    + " tur_estado, "
                    + " tur_fechaIngreso) "
                    + " values(?,?,?,?,?)");
            
            pstm.setInt(1, t.getPacId()); 
            pstm.setString(2, t.getCodigoTurno());
            pstm.setInt(3, t.getNivelTriaje());
            pstm.setString(4, t.getEstado());
            pstm.setString(5, t.getFechaIngreso()); 

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizarTurnoMedico(TurnoMedico t) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update turnos_medicos set tur_pacid = ?, "
                    + " tur_codigoTurno = ?,"
                    + " tur_nivelTriaje = ?,"
                    + " tur_estado = ?,"
                    + " tur_fechaIngreso = ? " 
                    + " where tur_id = ?");
            
            pstm.setInt(1, t.getPacId());
            pstm.setString(2, t.getCodigoTurno());
            pstm.setInt(3, t.getNivelTriaje());
            pstm.setString(4, t.getEstado());
            pstm.setString(5, t.getFechaIngreso());
            pstm.setInt(6, t.getId()); 

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void borrarTurnoMedico(TurnoMedico t) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from turnos_medicos "
                    + " where tur_id = ?");

            pstm.setInt(1, t.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}