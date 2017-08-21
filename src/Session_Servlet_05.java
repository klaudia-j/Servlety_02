

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_Servlet_05
 */
@WebServlet("/Session_Servlet_05")
public class Session_Servlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session_Servlet_05() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		Random r = new Random();
		int num1 = r.nextInt(101);
		int num2 = r.nextInt(101);
		int sum = num1 + num2;
		sess.setAttribute("captcha", sum);
		PrintWriter out = response.getWriter();
		out.append("<html><body><form action=\"Session_Servlet_05\" method=\"POST\">"
				+ "<label> Imię: <input type=\"text\" name=\"name\"></label>"
				+ "<label> Nazwisko: <input type=\"text\" name=\"surname\"></label>"
				+ "<label> E-mail: <input type=\"text\" name=\"email\"></label>"
				+ "<label> Wpisz wynik dodawania: " + num1 + " + " + num2 + "<input type=\"number\" name=\"sum\"></label>"
				+ "<input type=\"submit\"></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
		try {
			int captcha = (int) sess.getAttribute("captcha");
			int sum = Integer.parseInt(request.getParameter("sum"));
			if (sum == captcha) {
				out.append("Witaj nie-robocie!");
			} else {
				out.append("Odejdź stąd robocie");
			}
		} catch (Exception e) {
			out.append("Wystąpił błąd");
		}
	}

}
