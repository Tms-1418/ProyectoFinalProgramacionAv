/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalpa.conexion;

import java.sql.*;
import com.mycompany.proyectofinalpa.model.RegistroAtencion; 

/**
 *
 * @author Usuario
 */
public class TDBRegistroAtencion {

    DBConexion cn;

    public TDBRegistroAtencion() {
        cn = new DBConexion();
    }

    public ResultSet getRegistroAtencionById(int id) throws SQLException {
        // Triple JOIN: Unimos Registro con Turno, Registro con Médico, y Turno con Paciente
        String sql = "SELECT ra.reg_id, "
                   + " ra.reg_turid, "
                   + " ra.reg_medid, "
                   + " tm.tur_codigoTurno, "    // Del turno
                   + " p.pac_nombre, "          // Del paciente (a través del turno)
                   + " p.pac_documento, "       // Del paciente
                   + " m.med_nombre, "          // Del médico
                   + " m.med_rol "              // Del médico
                   + " FROM registro_atencion ra "
                   + " INNER JOIN turnos_medicos tm ON ra.reg_turid = tm.tur_id "
                   + " INNER JOIN pacientes p ON tm.tur_pacid = p.pac_id "
                   + " INNER JOIN medicos m ON ra.reg_medid = m.med_id "
                   + " WHERE ra.reg_id = ? ";

        PreparedStatement pstm = cn.getConexion().prepareStatement(sql);
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        return res;
    }

    /**
     * trae todos los registros de atencion combinados con turno, paciente y medico
     */
    public ResultSet getRegistrosAtencion() throws SQLException {
        String sql = "SELECT ra.reg_id, "
                   + " ra.reg_turid, "
                   + " ra.reg_medid, "
                   + " tm.tur_codigoTurno, "
                   + " p.pac_nombre, "
                   + " p.pac_documento, "
                   + " m.med_nombre, "
                   + " m.med_rol "
                   + " FROM registro_atencion ra "
                   + " INNER JOIN turnos_medicos tm ON ra.reg_turid = tm.tur_id "
                   + " INNER JOIN pacientes p ON tm.tur_pacid = p.pac_id "
                   + " INNER JOIN medicos m ON ra.reg_medid = m.med_id "
                   + " ORDER BY ra.reg_id DESC";

        PreparedStatement pstm = cn.getConexion().prepareStatement(sql);
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarRegistroAtencion(RegistroAtencion r) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registro_atencion (reg_turid, "
                    + " reg_medid) "
                    + " values(?,?)");
            
            pstm.setInt(1, r.getTurId()); 
            pstm.setInt(2, r.getMedId()); 

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizarRegistroAtencion(RegistroAtencion r) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update registro_atencion set reg_turid = ?, "
                    + " reg_medid = ? " 
                    + " where reg_id = ?");
            
            pstm.setInt(1, r.getTurId());
            pstm.setInt(2, r.getMedId());
            pstm.setInt(3, r.getId()); 

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void borrarRegistroAtencion(RegistroAtencion r) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from registro_atencion "
                    + " where reg_id = ?");

            pstm.setInt(1, r.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}