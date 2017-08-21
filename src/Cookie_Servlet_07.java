

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Servlet_07
 */
@WebServlet("/rememberMe")
public class Cookie_Servlet_07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cookie_Servlet_07() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")) {
					response.getWriter().append("Cześć " + cookie.getValue());
					return;
				}
			}
		}
		response.getWriter().append("<html><head><meta charset=\"UTF-8\"></head>"
				+ "<body><form action=\"rememberMe\" method=\"post\">"
				+ "<label>Zapamiętaj mnie"
				+ "<input type=\"checkbox\" name=\"rememberMe\" "
				+ "value=\"tak\"></label>" 
				+ "<input type=\"text\" name=\"name\" placeholder=\"wpisz imię\">"
				+ "<input type=\"submit\"></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String rememberMe = request.getParameter("rememberMe");
		String name = request.getParameter("name");
		response.getWriter().append("Cześć " + name);
		if (rememberMe != null) {
			Cookie cookieToRemember = new Cookie("name", name);
			response.addCookie(cookieToRemember);
		}
	}

}
