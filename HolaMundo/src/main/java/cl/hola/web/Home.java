package cl.hola.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = "Mijail";
		int edad = 18;
		
		request.setAttribute("nombreHijo", nombre);
		request.setAttribute("edadHijo", edad);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}


}
