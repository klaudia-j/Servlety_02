

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Servlet_01_Del
 */
@WebServlet("/deleteCookie")
public class Cookie_Servlet_01_Del extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cookie_Servlet_01_Del() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = "brak ciasteczka";
		Cookie[] arrayOfCookies = request.getCookies();
		if (arrayOfCookies != null) {
			for(Cookie cookie : arrayOfCookies) {
				if("User".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					value = cookie.getValue();
					break;
				}
			}
		}
		response.getWriter().append("User: " + value);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
