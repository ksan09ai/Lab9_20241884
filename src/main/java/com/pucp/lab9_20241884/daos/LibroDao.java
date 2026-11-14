package com.pucp.lab9_20241884.daos;

import com.pucp.lab9_20241884.beans.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDao extends BaseDao {

    public ArrayList<Libro> listarLibros() throws SQLException {

        ArrayList<Libro> lista = new ArrayList<>();

        String sql = "SELECT id_libro, titulo, autor, anio_publicacion FROM libro";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Libro libro = new Libro();

                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnioPublicacion(rs.getInt("anio_publicacion"));
                lista.add(libro);
            }
        }
        return lista;
    }
}

