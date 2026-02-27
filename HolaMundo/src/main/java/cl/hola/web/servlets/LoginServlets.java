package cl.hola.web.servlets;

import java.io.IOException;

import cl.hola.web.dao.UsuarioDAO;
import cl.hola.web.dao.UsuarioDAOImpl;
import cl.hola.web.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encargado de capturar los datos
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//validacion de los parametros
		if(email == null || email.trim().isEmpty() || !email.contains("@") || password == null || password.trim().isEmpty() || password.length()<6) {
			request.setAttribute("loginError", "Error al ingresar al sistema.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
		
		//comparar con la base de datos
		UsuarioDAO usuarioDao = new UsuarioDAOImpl();
		
		Usuario usuario= usuarioDao.login(email, password);
		
		if(usuario == null) {
			request.setAttribute("loginError", "Credenciales incorrectas.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		// guardar en session si los datos son correctos!!
		HttpSession session = request.getSession(true);
		session.setAttribute("emailSession", email);
		session.setAttribute("nickSession", usuario.getNick());
		
		response.sendRedirect(request.getContextPath()+ "/dashboard");
	}

}
