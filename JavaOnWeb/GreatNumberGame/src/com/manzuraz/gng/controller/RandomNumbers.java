package com.manzuraz.gng.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomNumbers
 */
@WebServlet("/RandomNumbers")
public class RandomNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomNumbers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if (session.getAttribute("number") == null) {
			Integer number = (int)(Math.random()*100 + 1);
			session.setAttribute("number", number);
		} else {
			session = request.getSession();
			Integer num = (int) session.getAttribute("number");
			session.setAttribute("number", num);
		}
	   
	    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NumberGame.jsp");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session = request.getSession();
		Boolean play = Boolean.valueOf(request.getParameter("playagain"));
		if (play) {
				session.invalidate();
				response.sendRedirect("/GreatNumberGame/RandomNumbers");
		} else {
				Integer user_number = Integer.parseInt(request.getParameter("number"));
				session.setAttribute("userNum", user_number);
				response.sendRedirect("/GreatNumberGame/RandomNumbers");		
		}
	}
}


