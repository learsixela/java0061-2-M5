package cl.biblioteca.digital.servlest.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/registrar")
public class RegistroServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		System.out.println(nick+" "+ email+" "+ password);
		
		//enviar datos al front
		request.setAttribute("nick", nick);
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
	}


}
