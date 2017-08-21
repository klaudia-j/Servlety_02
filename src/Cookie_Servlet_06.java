

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Servlet_06
 */
@WebServlet("/Cookie_Servlet_06")
public class Cookie_Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cookie_Servlet_06() {
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
		String color = null;
		String backgroundColor = null;
		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("color")) {
					color = cookie.getValue();
				}
				if(cookie.getName().equals("backgroundColor")) {
					backgroundColor = cookie.getValue();
				}
			}
			if (! (color == null || backgroundColor == null)) {
				response.getWriter().append("Zapamiętany w ciasteczku kolor tekstu to: " + color + ", oraz tła jako: " + backgroundColor);
				return;
			}
		}
		response.sendRedirect("cookies_index6.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color");
		String backgroundColor = request.getParameter("backgroundColor");
		if (! (color.equals("") || backgroundColor.equals(""))) {
			Cookie colorCookie = new Cookie("color", color);
			Cookie backgroundColorCookies = new Cookie("backgroundColor", backgroundColor);
			response.addCookie(colorCookie);
			response.addCookie(backgroundColorCookies);
			response.getWriter().append("<html><head></head><body><p style = 'color: " 
					+ color +"; background-color: " + backgroundColor + "'>"
					+ "Wybrałeś kolor tekstu jako: " + color
					+ " oraz tła jako: " + backgroundColor 
					+ ". Twój wybór został zapisane w ciasteczku.</p></body></html>");
		} else {
			response.sendRedirect("cookies_index6.html");
		}
	}

}
