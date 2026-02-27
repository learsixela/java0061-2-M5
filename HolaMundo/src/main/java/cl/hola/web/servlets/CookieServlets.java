package cl.hola.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookieServlets
 */
@WebServlet("/cookieServlets")
public class CookieServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener cookies
		Cookie[] galletas = request.getCookies();
		if (galletas != null) {
			for (Cookie cookie : galletas) {
				System.out.println(cookie.getName()+" " +cookie.getValue());
			}
		}
		
	}

}
