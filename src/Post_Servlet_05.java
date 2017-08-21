

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post_Servlet_05
 */
@WebServlet("/Post_Servlet_05")
public class Post_Servlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Post_Servlet_05() {
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
		String convertionType = request.getParameter("convertionType");
		PrintWriter out = response.getWriter();
		float temp = Float.parseFloat(request.getParameter("degrees"));
		if (convertionType == "CelcToFahr") {
			float newTemp = 32 + temp * 9 / 5;
			out.append(temp + " stopni Celsjusza to " + newTemp + " stopni Fahrenheita");
		} else {
			float newTemp = (-32 + temp) * 5 / 9;
			out.append(temp + " stopni Fahrenheita to " + newTemp + " stopni Celsjusza");
		}
	}

}
