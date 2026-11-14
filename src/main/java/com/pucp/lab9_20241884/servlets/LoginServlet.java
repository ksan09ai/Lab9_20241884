package com.pucp.lab9_20241884.servlets;

import com.pucp.lab9_20241884.beans.Usuario;
import com.pucp.lab9_20241884.daos.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioDao usuarioDao = new UsuarioDao();

        try{
            Usuario usuario = usuarioDao.validarUsuario(email, password);

            if (usuario != null){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);

                session.setMaxInactiveInterval(600);
                response.sendRedirect(request.getContextPath() + "/LibroServlet");

            } else {
                request.setAttribute("Error", "Algo esta incorrecto");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
