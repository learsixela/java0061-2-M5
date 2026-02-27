package cl.hola.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashboardServlets() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  HttpSession session = request.getSession(true);
		  //Object emailObject = session.getAttribute("emailSession");
		  String emailSession = (String) session.getAttribute("emailSession");
		  System.out.println("Dashboard - emailSession "+ emailSession);
		  //controlar acceso a rutas o paginas sin login
		  if(emailSession == null || emailSession.isEmpty()) {
			  response.sendRedirect(request.getContextPath()+ "/login");
		  }
		  Cookie cookie = new Cookie("nick","Isra");
		  Cookie color = new Cookie("color", "Red");
		  
		  cookie.setMaxAge(60*60);//1 hora
		  color.setMaxAge(60*60);
		  response.addCookie(cookie);
		  response.addCookie(color);
		
		  request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
