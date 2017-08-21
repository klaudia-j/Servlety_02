

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homework_Servlet_04
 */
@WebServlet("/Homework_Servlet_04")
public class Homework_Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework_Servlet_04() {
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
		Cookie[] cookies = request.getCookies();
		Cookie visits = new Cookie("visits", "1");
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visits")) {
				visits.setValue(Integer.toString((Integer.parseInt(cookie.getValue()) + 1)));
				break;
			}
		}
		response.addCookie(visits);
		if (visits.getValue().equals("1")) {
			out.append("Witaj pierwszy raz na naszej stronie");
		} else {
			out.append("Witaj, odwiedziłeś nas już " + visits.getValue() + " razy");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
