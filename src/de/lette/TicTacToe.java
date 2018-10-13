package de.lette;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TicTacToe")
public class TicTacToe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean player;
	
    public TicTacToe() {
        super();
    }

    /**
     * handle get request and session attributes
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		boolean player = false;
		if(session.getAttribute("player") == null)
			session.setAttribute("player", player);
		else
			player = (boolean) session.getAttribute("player");
		
		char[][] field = new char[3][3];
		if(session.getAttribute("tictactoe") == null)
			session.setAttribute("tictactoe", field);
		else
			field = (char[][]) session.getAttribute("tictactoe");
		
		if(request.getParameter("move") != null)
		{
			int move = Integer.parseInt(request.getParameter("move"));
			int x = move/3;
			int y = move%3;
			
			if(field[x][y] == '\0')
			{
				if(player)
					field[x][y] = 'X';
				else
					field[x][y] = 'O';
				session.setAttribute("player", !player);
			}
			else
			{
				System.out.println("Already set");
			}
		}

		response.setContentType("text/html");
		printTicTacToe(response.getWriter(), field);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void printTicTacToe(PrintWriter writer, char[][] field)
	{
		try {
			writer.println("<!DOCTYPE html>");
			writer.println("<html><head>");
			writer.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			writer.println("<title>TicTacToe</title></head>");
			writer.println("<body>");
			writer.println("<form action = \"TicTacToe\" method = \"POST\">");
			writer.println("<table>");
			int count = 0;
			for (int i = 0; i < field.length; i++) {
				writer.println("<tr>");
				for (int j = 0; j < field[i].length; j++) {
					writer.println("<td>");
					writer.print("<button style=\"height:2.5em; width:100%\" type = \"submit\" name=\"move\" value=\"");
					writer.print(count);
					writer.print("\">");
					writer.print(field[i][j]);
					writer.println("</button>");
					writer.println("</td>");
					count++;
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
