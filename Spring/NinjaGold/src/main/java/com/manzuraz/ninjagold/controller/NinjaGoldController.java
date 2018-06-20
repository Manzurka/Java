package com.manzuraz.ninjagold.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			ArrayList<String> activity_list = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("activity", activity_list);
		
		} else {
			ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
			int gold = (int)session.getAttribute("gold");
			session.setAttribute("gold", gold);
			session.setAttribute("activity", activity_list);
		
		}
		return "main.jsp";
	}
	@RequestMapping(path="/check", method=RequestMethod.POST)
	public String farm(HttpSession session, @RequestParam(value="building") String building) {
		if (building.equals("farm")) {
			Random random = new Random();
			int winnings = random.nextInt(10)+10;
			int gold = (int)session.getAttribute("gold");
			gold = winnings + gold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
			SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
			activity_list.add("Earned " + winnings + " golds from the farm!  " + date.format(new Date()));
			session.setAttribute("activity", activity_list);
			return "redirect:/";
		}
		if (building.equals("cave")) {
			Random random = new Random();
			int winnings = random.nextInt(5) + 5;
			int gold = (int)session.getAttribute("gold");
			gold = winnings + gold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
			SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
			activity_list.add("Earned " + winnings + " golds from the cave!  " + date.format(new Date()));
			session.setAttribute("activity", activity_list);
			return "redirect:/";
		}
	
		if (building.equals("house")) {
			Random random = new Random();
			int winnings = random.nextInt(3) + 2;
			int gold = (int)session.getAttribute("gold");
			session.setAttribute("gold", gold+=winnings);
			ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
			SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
			activity_list.add("Earned " + winnings + " golds from the house!  " + date.format(new Date()));
			session.setAttribute("activity", activity_list);
			return "redirect:/";
		}
	
		 if (building.equals("casino")) {
			Random random = new Random();
			int money = random.nextInt(101)-50;
			int gold = (int)session.getAttribute("gold");
			if (money>0) {
				session.setAttribute("gold", gold+=money);
				ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
				SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
				activity_list.add("Earned " + money + " golds from the casino!  " + date.format(new Date()));
				session.setAttribute("activity", activity_list);
				return "redirect:/";
			}else {
				session.setAttribute("gold", gold+=money);
				ArrayList<String> activity_list = (ArrayList<String>) session.getAttribute("activity");
				SimpleDateFormat date = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
				activity_list.add("Lost " + (-money) + " golds from the casino!  " + date.format(new Date()));
				session.setAttribute("activity", activity_list);
				return "redirect:/";
			}
		}

		 return "redirect:/";
	}
}
