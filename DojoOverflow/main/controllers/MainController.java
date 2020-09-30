  
package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class MainController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public MainController(QuestionService questionService, TagService tagService, AnswerService answerService ) {
		this.questionService=questionService;
		this.tagService=tagService;
		this.answerService=answerService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> myQuestionList = questionService.findAll();
		model.addAttribute("questions", myQuestionList);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("addQuestion")Question question) {
		return "questions.jsp";
	}
	
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("addQuestion")Question question, BindingResult result, @RequestParam("myTag")String myTag,RedirectAttributes flash) {
		
		int numComma = myTag.replaceAll("[^,]", "").length();
		if (numComma>2) {
			flash.addFlashAttribute("errors", "You can add 3 tags at the most");

		}if (!myTag.equals(myTag.toLowerCase())) {
			flash.addFlashAttribute("errors", "must be all lower case");
		}
			
		if((result.hasErrors()) || (flash.getFlashAttributes().size()>0)){	
			return "redirect:/questions/new";
		}else {
			
			Question myQ = questionService.createQuestion(question);
			
			List<String> items = (List<String>)Arrays.asList(myTag.trim().split("\\s*,\\s*"));
			System.out.println(items);
			
			ArrayList<Tag> tags = new ArrayList<Tag>();
			for(int i=0;i<items.size();i++) {
				tags.add(tagService.createTag(items.get(i)));
				System.out.println("show : "+items.get(i));
			}
			
			myQ.setTags(tags);
			questionService.createQuestion(myQ);
			
			return "redirect:/questions/new";
		}
		
	}

	@RequestMapping("/questions/{id}")
	public String show(@ModelAttribute("ans")Answer answer, @PathVariable("id")Long id, Model model) {
		Question myQuestion = questionService.findQ(id);
		model.addAttribute("myquestion", myQuestion);
		model.addAttribute("myTags", myQuestion.getTags());
		model.addAttribute("answers", myQuestion.getAnswers());
		return "showQuestion.jsp";
	}
	
	@RequestMapping(value="/questions/", method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("ans")Answer ans, BindingResult result){
		System.out.println(ans.getId());
		answerService.createAns(ans);
		Long myID = ans.getQuestion().getId();
		return "redirect:/questions/"+myID;
	}
}