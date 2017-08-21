

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post_Servlet_03
 */
@WebServlet("/Post_Servlet_03")
public class Post_Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post_Servlet_03() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int c = Integer.parseInt(request.getParameter("c"));
		writer.append("<html><body>");
		if (delta(a, b, c) < 0) {
			writer.append("<h1>Brak rozwiązań równania kwadratowego");
		} else {
			double pierwiastek = Math.sqrt(delta(a, b, c));
			double result1 = (-b - pierwiastek) / (2 * a);
			double result2 = (-b + pierwiastek) / (2 * a);
			writer.append("<h1>Rozwiązania to " + result1 + " i " + result2);
		}
		writer.append("</h1></body></html>");
	}
	
	private double delta (int a, int b, int c) {
		return (b * b - 4 * a * c);
	}

}
