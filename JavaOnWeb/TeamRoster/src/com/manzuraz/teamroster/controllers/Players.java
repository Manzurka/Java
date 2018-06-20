package com.manzuraz.teamroster.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manzuraz.teamroster.models.Player;
import com.manzuraz.teamroster.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		//unfinished. need to replace the session with .getParameter("id")to be able to view all players when clicking Details link on Home page. 
		Team t = Team.findTeams(id);
		request.setAttribute("team", t);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name = String.valueOf(request.getParameter("first_name"));
		String last_name = String.valueOf(request.getParameter("last_name"));
		Integer age = Integer.valueOf(request.getParameter("age"));
		Player p = new Player(first_name, last_name, age);
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		//unfinished. need to replace the session with .getParameter("id")to be able to view all players when clicking Details link on Home page. 
		Team t = Team.findTeams(id);
		Team.addPlayer(t,p);
		request.setAttribute("team", t);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
		view.forward(request, response);
	}

}
