

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post_Servlet_04
 */
@WebServlet("/Post_Servlet_04")
public class Post_Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Post_Servlet_04() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		Random r = new Random();
		int numberOfInputs = r.nextInt(6)+5;
		writer.append("<html><body><form action='' method='post'>");
		for (int i = 0; i < numberOfInputs; i++) {
			writer.append("<input name='numbers' placeholder='wpisz coś'><br/>");
		}
		writer.append("<input type='submit'>");
		writer.append("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		String[] values = request.getParameterValues("numbers"); 
//		Map<String, String[]> mapOfParameters = request.getParameterMap();
//		Set<String> parameter = mapOfParameters.keySet();
//		Iterator<String> it = parameter.iterator();
//		String[] values = mapOfParameters.get(it.next()); //?? tu nie może być tylko parameter = musi być wskazanie na 1 miejsce
		List<Integer> numbers = new ArrayList<>(); 
		for (String value : values) {
			try {
				int number = Integer.parseInt(value);
				numbers.add(number);
			} catch (Exception e) {

			}
		}
		int[] numbersArray = new int[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			numbersArray[i] = numbers.get(i);
		}
		Arrays.sort(numbersArray);
		for (int numb : numbersArray) {
			writer.append(Integer.toString(numb) + "<br>");
		}
		
	}
}