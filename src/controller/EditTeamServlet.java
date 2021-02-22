package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;

/**
 * Servlet implementation class EditItemServlet
 */
/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Feb 17, 2021
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsTeamHelper dao = new SportsTeamHelper();
		
		String city = request.getParameter("city");
		String name  = request.getParameter("name");
		String sport = request.getParameter("sport");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		SportsTeam teamToUpdate = dao.searchForTeamById(tempId);
		teamToUpdate.setCity(city);
		teamToUpdate.setName(name);
		teamToUpdate.setSport(sport);
		
		dao.updateTeam(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
