package Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomWords
 */
@WebServlet("/RandomWords")
public class RandomWords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if (session.getAttribute("count") == null) {	
		    session.setAttribute("count", 0);
			
		} else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}

			String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
			StringBuilder word = new StringBuilder();
		    Random random = new Random();
		    for (int i = 0; i < 10; i++) {
		    	int randIndex=random.nextInt(alphanumeric.length());
		    	word.append(alphanumeric.charAt(randIndex));
		    }
		    session.setAttribute("word", word);
		   
	        Date date = new Date();
	        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
	        String formattedDate= dateFormat.format(date);
	        
			session.setAttribute("time", formattedDate);
		    
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/RandomWord.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
