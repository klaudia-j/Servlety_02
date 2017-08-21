

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_Servlet_02
 */
@WebServlet("/Session_Servlet_02")
public class Session_Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session_Servlet_02() {
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
		PrintWriter out = response.getWriter();
		out.append("<html><body><form action=\"Session_Servlet_02\" method=\"post\">"
				+ "<label>Oceń sesję: <select name=\"grade\"><option value=\"\" disabled option>Select...</option>"
				+ "<option value=\"1\">1</option>"
				+ "<option value=\"2\">2</option>"
				+ "<option value=\"3\">3</option>"
				+ "<option value=\"4\">4</option>"
				+ "<option value=\"5\">5</option>"
				+ "<option value=\"6\">6</option></select>"
				+ "</label><button type=\"submit\" name=\"submit\" value=\"1\">Wyślij</button>"
				+ "</form>");
		try {
			List<Integer> listOfGrades = (List) sess.getAttribute("listOfGrades");
			out.append("<p>Dotychczasowe oceny: </p><br><ul>");
			for (int oneGrade : listOfGrades) {
				out.append("<li>" + oneGrade + "</li>");
			}
			double averageGrade = (double) sess.getAttribute("averageGrade");
			out.append("</ul><p>Średnia ocen to: " + averageGrade + "</p></body></html>");
		} catch (NullPointerException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int grade = Integer.parseInt(request.getParameter("grade"));
		if (sess.getAttribute("listOfGrades") == null) {
			List<Integer> listOfGrades = new ArrayList<>();
			sess.setAttribute("listOfGrades", listOfGrades);
		}
		List<Integer> listOfGrades = (List) sess.getAttribute("listOfGrades");
		listOfGrades.add(grade);
		double sum = 0;
		double counter = 0;
		for (int oneGrade : listOfGrades) {
			sum += oneGrade;
			counter++;
		}
		double averageGrade = sum/counter;
		sess.setAttribute("listOfGrades", listOfGrades);
		sess.setAttribute("averageGrade", averageGrade);
		doGet(request, response);
	}

}
