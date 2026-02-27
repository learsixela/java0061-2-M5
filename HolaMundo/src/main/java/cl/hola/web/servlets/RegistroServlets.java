package cl.hola.web.servlets;

import java.io.IOException;
import java.time.LocalDate;

import cl.hola.web.dao.UsuarioDAO;
import cl.hola.web.dao.UsuarioDAOImpl;
import cl.hola.web.model.Usuario;
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
	//polimorfismo
    private final UsuarioDAO usuarioDao = new UsuarioDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("En el metodo doPost");
		//capturar datos desde el front, por medio del name del input
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String edad = request.getParameter("edad");
		String f_nacimiento = request.getParameter("f_nac");
		String sexo = request.getParameter("sexo");
		//logica de validacion
		if(nick == null || nick.trim().isEmpty()) {
			request.setAttribute("nickError", "Error: nick no puede ser vacio o null");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
		
		if(email == null || email.trim().isEmpty() || !email.contains("@")) {
			request.setAttribute("emailError", "Error: email no puede ser vacio o null o no tiene el formato correcto");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
		
		if(password == null || password.trim().isEmpty() || password.length()<6) {
			request.setAttribute("passError", "Error: Password no puede ser vacio o null y mayor o igual a 6 caracteres");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
		
		
		//se almacenan los datos en BD
		Usuario usuario = new Usuario(
				nick,
				email,
				password,
				Integer.parseInt(edad),
				LocalDate.parse(f_nacimiento)
				);
		//usuario.setNick(nick);
		
		System.out.println(nick+" "+ email+" "+ password+" "+edad+" "+f_nacimiento);
		System.out.println("Sexo seleccionado "+ sexo);
		
		boolean resultado = usuarioDao.registrar(usuario);
		
		if(resultado) {
			//enviar datos al front
			request.setAttribute("email", email);
		
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}


}
