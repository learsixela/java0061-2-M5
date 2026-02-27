package cl.hola.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  HttpSession session = request.getSession(true);
		  //Object emailObject = session.getAttribute("emailSession");
		  String emailSession = (String) session.getAttribute("emailSession");
		  //controlar acceso a rutas o paginas sin login
		  if(emailSession == null || emailSession.isEmpty()) {
			  response.sendRedirect(request.getContextPath()+ "/login");
		  }
		  request.getRequestDispatcher("libro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
