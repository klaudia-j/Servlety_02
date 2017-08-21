

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session_Servlet_03_Add
 */
@WebServlet("/addToSession")
public class Session_Servlet_03_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session_Servlet_03_Add() {
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
		out.append("<html><body><form action=\"addToSession\" method=\"post\">"+
				"<label>Klucz:<input type=\"text\" name=\"key\"></label>"+
				"<label>Wartość:<input type=\"text\" name=\"value\"></label>"+
				"<input type=\"submit\">");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if (sess.getAttribute("mapOfParameters") == null) {
			Map<String, String> mapOfParameters = new HashMap<>();
			sess.setAttribute("mapOfParameters", mapOfParameters);
		}
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		Map<String, String> mapOfParameters = (Map<String, String>) sess.getAttribute("mapOfParameters");
		mapOfParameters.put(key, value);
		sess.setAttribute("mapOfParameters", mapOfParameters);
	}			
}
