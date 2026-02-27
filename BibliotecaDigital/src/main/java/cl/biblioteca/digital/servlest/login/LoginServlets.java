package cl.biblioteca.digital.servlest.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlets() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// metodo encargado del despliegue del jsp
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encargado de capturar los datos
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//comparar con la base de datos
		
		// guardar en session si los datos son correctos!!
		HttpSession session = request.getSession(true);
		session.setAttribute("emailSession", email);
		session.setAttribute("PASSWORD_SESSION", password);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
