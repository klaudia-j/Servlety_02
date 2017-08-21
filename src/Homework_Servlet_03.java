

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
 * Servlet implementation class Homework_Servlet_03
 */
@WebServlet("/Homework_Servlet_03")
public class Homework_Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework_Servlet_03() {
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
		String name = (String) sess.getAttribute("name");
		if (name == null) {
			name = "";
		}
		String surname = (String) sess.getAttribute("surname");
		if (surname == null) {
			surname = "";
		}
		String email = (String) sess.getAttribute("email");
		if (email == null) {
			email = "";
		}
		PrintWriter out = response.getWriter();
		out.append("<html><body><form action=\"Homework_Servlet_03\" method=\"POST\">"
				+ "<label> Imię: <input type=\"text\" name=\"name\" value=" + name + "></label>"
				+ "<label> Nazwisko: <input type=\"text\" name=\"surname\" value=" + surname + "></label>"
				+ "<label> E-mail: <input type=\"text\" name=\"email\" value=" + email + "></label>"
				+ "<input type=\"submit\"></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		sess.setAttribute("name", name);
		sess.setAttribute("surname", surname);
		sess.setAttribute("email", email);
	}

}
