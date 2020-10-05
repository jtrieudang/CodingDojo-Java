package com.codingdojo.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
		}
		return "index.jsp";
	}
	@RequestMapping(path="", method=RequestMethod.POST)
	public String updateGold(HttpSession session, @RequestParam(value="place") String place) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        //farm
		if(place.equals("farm")) {
			Random rand = new Random();
			Integer amount = rand.nextInt(11) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You entered a farm and earned "+amount+" gold. ("+timeStamp+")");
        }
        
        //cave
		else if(place.equals("cave")) {
			Random rand = new Random();
			Integer amount = rand.nextInt(6) + 5;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You entered a cave and earned "+amount+" gold. ("+timeStamp+")");
        }
        
        //house
		else if(place.equals("house")) {
			Random rand = new Random();
			Integer amount = rand.nextInt(4) + 2;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You entered a house and earned "+amount+" gold. ("+timeStamp+")");
        }
        
        //casino
		else if(place.equals("casino")) {
			Random rand = new Random();
			Integer winLose = rand.nextInt(2)+1;
			Integer amount = rand.nextInt(51);
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			if(winLose == 1) {
				session.setAttribute("gold", gold+amount);
				activities.add("You entered a casino and earned "+amount+" gold. ("+timeStamp+")");
			}else {
				if(gold-amount < 0) {
					session.setAttribute("gold", 0);
					activities.add("You entered a casino and lost all of your gold. ("+timeStamp+")");
				} else {
					session.setAttribute("gold", gold-amount);
					activities.add("You entered a casino and lost "+amount+" gold. ("+timeStamp+")");
				}
            }
            
            
		} else if(place.equals("reset")) {
			session.invalidate();
		}
		return "redirect:/";
	}
}