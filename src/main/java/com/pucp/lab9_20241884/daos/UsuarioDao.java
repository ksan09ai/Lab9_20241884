package com.pucp.lab9_20241884.daos;

import com.pucp.lab9_20241884.beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends BaseDao {


    public boolean existeEmail(String email) throws SQLException {

        String sql = "SELECT id_usuario FROM usuario WHERE email = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario " +
                "(nombres, apellidos, email, password_hash, rol, estado) " +
                "VALUES (?, ?, ?, SHA2(?,256), 'LECTOR', 'ACTIVO')";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getPasswordHash());

            pstmt.executeUpdate();
        }
    }





}
