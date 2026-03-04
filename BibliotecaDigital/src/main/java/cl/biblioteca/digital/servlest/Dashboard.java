package cl.biblioteca.digital.servlest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // No crees sesión nueva: si no existe, es porque no hizo login
	    HttpSession session = request.getSession(false);

	    if (session == null) {
	        response.sendRedirect(request.getContextPath() + "/login");
	        return;
	    }

	    String emailSession = (String) session.getAttribute("emailSession");

	    // Si no hay atributo, no está logueado
	    if (emailSession == null || emailSession.isBlank()) {
	        response.sendRedirect(request.getContextPath() + "/login");
	        return;
	    }

	    // (Opcional) cookies usando el nick real
	    String nickSession = (String) session.getAttribute("nickSession");

	    Cookie nick = new Cookie("nick", nickSession != null ? nickSession : "");
	    Cookie color = new Cookie("color", "Red");
	    nick.setMaxAge(60 * 60);
	    color.setMaxAge(60 * 60);
	    nick.setPath(request.getContextPath());
	    color.setPath(request.getContextPath());
	    response.addCookie(nick);
	    response.addCookie(color);

	    // Forward al JSP (ruta absoluta)
	    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

}
