

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Homework_Servlet_05_1
 */
@WebServlet("/Homework_Servlet_05_1")
public class Homework_Servlet_05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework_Servlet_05_1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		display(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if (sess.getAttribute("cart") == null) {
			Map<String, Double[]> cart = new HashMap<>();
			sess.setAttribute("cart", cart);
		}
		try {
			String name = request.getParameter("name");
			Double price = Double.parseDouble(request.getParameter("price"));
			Double quantity = Double.parseDouble(request.getParameter("quantity"));
			Map<String, Double[]> cart = (Map<String, Double[]>) sess.getAttribute("cart");
			Double[] params = new Double[2];
			params[0] = price;
			params[1] = quantity;
			cart.put(name, params);
			sess.setAttribute("cart", cart);
			display(request, response);
		} catch (Exception e) {
		}
	}

	private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		try {
			Map<String, Double[]> cart = (Map<String, Double[]>) sess.getAttribute("cart");
			PrintWriter out = response.getWriter();
			out.append("<!DOCTYPE html><html><body>");
			Set<String> keys = cart.keySet();
			double sum = 0;
			out.append("<ul>");
			for (String key : keys) {
				double price = cart.get(key)[0];
				double quantity = cart.get(key)[1];
				sum = sum + price*quantity;
				out.append("<li>" + key + " " + price + " x " + quantity + " = " + price*quantity + " zl</li>");
			}
			out.append("</ul><p>Suma: " + sum + " zł</p>");
			out.append("</body></html>");
		} catch (Exception e) {

		}
	}

}

