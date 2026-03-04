package cl.biblioteca.digital.servlest.login;

import java.io.IOException;

import cl.biblioteca.digital.dtos.UsuarioDTO;
import cl.biblioteca.digital.servicios.UsuarioServicio;
import cl.biblioteca.digital.servicios.UsuarioServicioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/registrar")
public class RegistroServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UsuarioServicio usuarioServicio = new UsuarioServicioImpl();
       
    public RegistroServlets() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login/registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("En el metodo doPost");
		//capturar datos desde el front, por medio del name del input
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//logica de validacion
		
		//se almacenan los datos en BD
		UsuarioDTO usuario = new UsuarioDTO(nick,email, password);
		
		usuarioServicio.guardarUsuario(usuario);
		
		//enviar datos al front
		request.setAttribute("email", email);
		
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
	}


}
