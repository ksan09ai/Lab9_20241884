package com.pucp.lab9_20241884.servlets;

import com.pucp.lab9_20241884.beans.Usuario;
import com.pucp.lab9_20241884.daos.LibroDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
                session.getAttribute("usuario") == null) {

            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        LibroDao LibroDao = new LibroDao();

        try {
            request.setAttribute("listaLibros", LibroDao.listarLibros());
            request.getRequestDispatcher("/libro.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
