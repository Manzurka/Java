package com.manzuraz.teamroster.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manzuraz.teamroster.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id") != null) {
			int teamId = Integer.parseInt(request.getParameter("id")); 
			HttpSession session = request.getSession();
			session.setAttribute("id", teamId );
			//unfinished. need to replace the session with .getParameter("id")to be able to view all players when clicking Details link on Home page. 
			Team t = Team.findTeams(teamId);
			request.setAttribute("team", t);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String team_name = String.valueOf(request.getParameter("teamName"));
		Team team1 = new Team(team_name);
		request.setAttribute("team", team1);

		response.sendRedirect("/TeamRoster/Home");
	}

}
