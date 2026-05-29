/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalpa.conexion;

import java.sql.*;
import com.mycompany.proyectofinalpa.model.Medico;

/**
 *
 * @author Usuario
 */
public class TDBMedicos {

    DBConexion cn;

    public TDBMedicos() {
        cn = new DBConexion();
    }

    public ResultSet getMedicoById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT med_id, "
                + " med_nombre, "
                + " med_rol "
                + " FROM medicos "
                + " WHERE med_id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        return res;
    }

    /**
     * trae todos los registros de la tabla medicos
     */
    public ResultSet getMedicos() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT med_id, "
                + " med_nombre, "
                + " med_rol "
                + " FROM medicos "
                + " ORDER BY med_nombre");

        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarMedico(Medico m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into medicos (med_nombre, "
                    + " med_rol) "
                    + " values(?,?)");
            
            pstm.setString(1, m.getNombre());
            pstm.setString(2, m.getRol());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizarMedico(Medico m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update medicos set med_nombre = ?, "
                    + " med_rol = ? " 
                    + " where med_id = ?");
            
            pstm.setString(1, m.getNombre());
            pstm.setString(2, m.getRol());
            pstm.setInt(3, m.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void borrarMedico(Medico m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from medicos "
                    + " where med_id = ?");

            pstm.setInt(1, m.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}