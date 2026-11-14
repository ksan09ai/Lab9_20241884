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


@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/registro.jsp")
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombres =  request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (nombres == null || nombres.isBlank()
            || apellidos == null || apellidos.isBlank()
            || email == null || email.isBlank()
            || password == null ||  password.isBlank()){

            request.setAttribute("error", "El registro no puede estar vacio");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
            return;

        }

        UsuarioDao usuarioDao = new UsuarioDao();

        try {
            if (usuarioDao.existeEmail(email)) {
                request.setAttribute("msg", "El email ya existe");
                request.getRequestDispatcher("/registro.jsp").forward(request, response);
                return;
            }


            Usuario usuario = new Usuario();

            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setEmail(email);
            usuario.setPasswordHash(password);
            usuario.setRol("LECTOR");
            usuario.setEstado("ACTIVO");

            usuarioDao.registrarUsuario(usuario);
            HttpSession session = request.getSession();

            session.setAttribute("mensaje", "Cuenta creada con exito");
            response.sendRedirect(request.getContextPath() + "/LoginServlet");


        } catch (SQLException e) {
            request.setAttribute("msg", "Error al registrar el usuario");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
        }

    }


}
