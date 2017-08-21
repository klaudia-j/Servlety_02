

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homework_Servlet_01
 */
@WebServlet("/Homework_Servlet_01")
public class Homework_Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Homework_Servlet_01() {
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
		double plnForEur = 4.0;
		double plnForUsd = 3.5;
		double usdForEur = 1.15;
		String exchange = request.getParameter("exchange");
		double amount = Double.parseDouble(request.getParameter("amount"));
		double result = 0;
		switch (exchange) {
			case "EUR to USD": 
				result = amount * usdForEur; 
				break;
			case "USD to EUR": 
				result = amount / usdForEur; 
				break;
			case "EUR to PLN": 
				result = amount * plnForEur; 
				break;
			case "PLN to EUR": 
				result = amount / plnForEur; 
				break;
			case "USD to PLN": 
				result = amount * plnForUsd; 
				break;
			case "PLN to USD": 
				result = amount / plnForUsd; 
				break;
		}
		response.getWriter().append(Double.toString(result));
	}

}
