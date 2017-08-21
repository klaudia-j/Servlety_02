

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Get_Servlet_03
 */
@WebServlet("/Get_Servlet_03")
public class Get_Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Get_Servlet_03() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		int width = 5;
		int height = 10;
		PrintWriter writer = response.getWriter();
		writer.append("<html><body>");
		width = getInt(request.getParameter("width"), width);
		height = getInt(request.getParameter("height"),height);
		for (int i = 1; i <= height; i++) {
			writer.append("<ul>");
			for (int j = 1; j <= width; j++) {
				writer.append(i + "x" + j + "=" + i*j + ", ");
			}
			writer.append("<br>");
			writer.append("</ul>");
		}
		writer.append("</body></html>");
	}

	private int getInt(String raw_paramter, int def) {
		int result = def;
		if (raw_paramter != null) {
			try {
				result = Integer.parseInt(raw_paramter);
			} catch(Exception e) {
				
			}
		}
		return result;
	}
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
