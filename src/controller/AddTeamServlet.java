package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;

/**
 * Servlet implementation class AddItemServlet
 */
/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Feb 18, 2021
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String name  = request.getParameter("name");
		String sport = request.getParameter("sport");
		SportsTeam st = new SportsTeam(city, name, sport);
		SportsTeamHelper dao = new SportsTeamHelper();
		dao.insertTeam(st);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
