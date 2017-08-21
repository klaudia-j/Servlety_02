

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_Servlet_03_All
 */
@WebServlet("/showAllSession")
public class Session_Servlet_03_All extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session_Servlet_03_All() {
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
		try {
			Map<String, String> mapOfParameters = (Map<String, String>) sess.getAttribute("mapOfParameters");
			PrintWriter out = response.getWriter();
			out.append("<!DOCTYPE html><html><body><table>");
			Set<String> keys = mapOfParameters.keySet();
			for (String key : keys) {
				out.append("<tr><td style='border: 1px solid black;'>" + key + "</td><td style='border: 1px solid black;'>" + mapOfParameters.get(key) + "</td></tr>");
			}
			out.append("</table></body></html>");
		} catch (Exception e) {

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
