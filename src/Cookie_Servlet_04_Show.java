

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Servlet_04_Show
 */
@WebServlet("/Cookie_Servlet_04_Show")
public class Cookie_Servlet_04_Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_Servlet_04_Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] arrayOfCookies = request.getCookies();
		out.append("<html><body><ul>");
		for(Cookie cookie : arrayOfCookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			out.append("<li>Ciasteczko: " + name + " o wartości " + value + " <a href=/Servlety_02/Cookie_Servlet_04_Del?name=" + name + ">link do usunięcia</a></li>");
		}
		out.append("</ul></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
