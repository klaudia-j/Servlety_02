

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_Servlet_01_Get
 */
@WebServlet("/Session_Servlet_01_Get")
public class Session_Servlet_01_Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session_Servlet_01_Get() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if (sess.getAttribute("counter") != null) {
			int counter = (int) sess.getAttribute("counter");
			response.getWriter().append("Counter is: " + counter);
			counter++;
			sess.setAttribute("counter", counter);
		} else {
			response.getWriter().append("There is no counter!");
		}
	}


}
