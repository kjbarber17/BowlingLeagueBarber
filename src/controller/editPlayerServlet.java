package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;


/**
 * Servlet implementation class editPlayer
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlayerServlet() {
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
		// TODO Auto-generated method stub
		PlayerHelper ph = new PlayerHelper();
		String act = request.getParameter("doThisToPlayer");

		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);

		}else if(act.equals("Delete Selected Player")) {

			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player playerToDelete = ph.searchForPlayerById(tempId);
			ph.deletePlayer(playerToDelete);
			System.out.println("test");

			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			System.out.println("test2");

		}else if(act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/addPlayer.html").forward(request, response);
		}
	}

}
