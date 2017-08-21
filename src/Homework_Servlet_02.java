

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import static java.lang.Math.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homework_Servlet_02
 */
@WebServlet("/Homework_Servlet_02")
public class Homework_Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework_Servlet_02() {
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
		PrintWriter out = response.getWriter();
		String textValue = request.getParameter("binValue");
		List<Integer> listOfNumbers = new ArrayList<>();
		for (int i = 0; i < textValue.length(); i++) {
			char oneChar = textValue.charAt(i);
			if (! (oneChar == '0' || oneChar == '1')) {
				out.append("Nie można zamienić liczby ponieważ nie jest zapsana w systemie binarnym.");
				return;
			}
			listOfNumbers.add(oneChar == '1' ? 1 : 0);
		}
		System.out.println(listOfNumbers.get(0));
		double decNum = 0;
		for (int j = listOfNumbers.size() - 1; j >= 0; j--) {
			decNum = decNum + listOfNumbers.get(j)*pow(2, listOfNumbers.size() - 1 - j);
		}
		out.append(Double.toString(decNum));
	}

}
