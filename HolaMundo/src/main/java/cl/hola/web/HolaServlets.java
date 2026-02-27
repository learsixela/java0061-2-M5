package cl.hola.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hola")//http://localhost:8081/HolaMundo/
public class HolaServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HolaServlets() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("metodo doGet");
		//pagina dinamica
		PrintWriter salida = response.getWriter();//.append("Served at: ").append(request.getContextPath());
		/*salida.println("<html>");
		salida.println("<head>");
		salida.println("<title>Hola Mundo</title>");
		salida.println("</head>");
		salida.println("<body>");
		salida.println("<h1>Hola Mundo desde Servlets</h1>");
		salida.println("</body>");
		salida.println("</html>");*/
		
		String pagina = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Hola Mundo::</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ " <h1>Hola Mundo desde Servlets 2</h1>   \r\n"
				+ "</body>\r\n"
				+ "</html>";
		salida.println(pagina);
	}

}
