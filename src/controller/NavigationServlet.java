package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;

/**
 * Servlet implementation class NavigationServlet
 */
/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Feb 21, 2021
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("doThisToTeam");
		String path="/viewAllTeamsServlet";
		SportsTeamHelper dao = new SportsTeamHelper();
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SportsTeam teamToDelete = dao.searchForTeamById(tempId);
				dao.deleteTeam(teamToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}
			
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SportsTeam teamToEdit = dao.searchForTeamById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				path="/edit-team.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}

			
		} else if (act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
