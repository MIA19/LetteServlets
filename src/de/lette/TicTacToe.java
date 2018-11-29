package de.lette;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TicTacToe Servlet
 * 
 * @author invalid
 */
@WebServlet("/TicTacToe")
public class TicTacToe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handle get request paramters and session attributes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(true);
		
		var field = (char[]) session.getAttribute("field");
		var player = (char) session.getAttribute("player");
		
		var names = request.getParameterNames();
		String name = null;
		if (names.hasMoreElements())
			name = names.nextElement();

		if(name != null)
			field[Integer.parseInt(name)] = (player == 'O' ? 'X' : 'O');
		
		response.setContentType("text/html; charset=UTF-8");
		printTicTacToe(response.getWriter(), field);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Prints the TicTacToe field as html
	 */
	private void printTicTacToe(PrintWriter writer, char[] field) {
		try {
			writer.println("<!DOCTYPE html>");
			writer.println("<html>");
			writer.println("<title>TicTacToe</title></head>");
			writer.println("<body>");
			writer.println("<form>");
			writer.println("<table>");
			for (int i = 0; i < 3; i++) {
				writer.println("<tr>");
				for (int j = 0; j < 3; j++) {
					writer.println("<td>");
					writer.print("<input style=\"height:2.5em; width:100%\" type = \"submit\" name=\"");
					writer.print(3 * i + j);
					writer.print("\"");
					char actualField = field[3*i+j];
					if(actualField != ' ') writer.print(" disabled=\"true\"");
					writer.print(" value=\"");
					writer.print(actualField);
					writer.println("\" />");
					writer.println("</td>");
				}
				writer.println("</tr>");
			}
			writer.println("</table>");
			writer.println("</form>");
			writer.println("</body>");
			writer.println("</html>");
		} finally {
			writer.close();
		}
	}

}
