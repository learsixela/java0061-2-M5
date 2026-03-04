package cl.biblioteca.digital.servlest.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import cl.biblioteca.digital.models.Usuario;
import cl.biblioteca.digital.servicios.UsuarioServicio;
import cl.biblioteca.digital.servicios.UsuarioServicioImpl;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UsuarioServicio usuarioServicio = new UsuarioServicioImpl();
       
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
		//validaciones basicas
		
		//comparar con la base de datos
		Usuario usuario = usuarioServicio.obtenerUsuario(email, password);
		
		if(usuario != null) {
			// guardar en session si los datos son correctos!!
			HttpSession session = request.getSession(true);
			session.setAttribute("emailSession", usuario.getEmail());
			session.setAttribute("nickSession", usuario.getNick());
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		//mensaje de error
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
		
	}

}
