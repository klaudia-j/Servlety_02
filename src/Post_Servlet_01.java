

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post_Servlet_01
 */
@WebServlet("/Post_Servlet_01")
public class Post_Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Post_Servlet_01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		out.append("<html><body>");
		Map<String, String[]> parameters = request.getParameterMap();
		out.append("<ul>");

		for(String name: parameters.keySet()) {
			out.append("<b>" + name + ":</b><ul>");
			String[] values = parameters.get(name);

			for(String value: values) {
				out.append("<li>" + value + "</li>");
			}

			out.append("</ul>");
		}

		out.append("</ul>");

		out.append("<h1>Witaj ")
		.append(request.getParameter("firstname"))
		.append(" ")
		.append(request.getParameter("surname"))
		.append(" ")
		.append(request.getParameter("checkbox"))
		.append("</h1></body></html>");
	}

}
