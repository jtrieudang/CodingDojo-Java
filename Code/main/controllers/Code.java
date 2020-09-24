package com.codingdojo.code;

import java.net.InetAddress;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Code {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	@RequestMapping(path="process", method=RequestMethod.POST)
	public String processpass(@RequestParam(value="code") String code, HttpSession session) {
		String pass = "bushido";
		if(code.equals(pass)) {
			session.setAttribute("res", null);
			return "redirect:/success";
		}
		else {
			session.setAttribute("res", "incorrect");
			return "redirect:/";	
		}
	}
	
	@RequestMapping("success")
	public String successful() {
		return "success.jsp";
	}
}