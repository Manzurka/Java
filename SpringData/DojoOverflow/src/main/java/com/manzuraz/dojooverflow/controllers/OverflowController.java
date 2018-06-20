package com.manzuraz.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.manzuraz.dojooverflow.models.Answer;
import com.manzuraz.dojooverflow.models.Question;
import com.manzuraz.dojooverflow.models.Tag;
import com.manzuraz.dojooverflow.services.OverflowService;

@Controller
public class OverflowController {
	private final OverflowService os;
	
	public OverflowController(OverflowService os) {
		this.os=os;
	}
	
	@RequestMapping("/questions")
	public String home(Model m) {
		List<Question> qlist = os.all_questions();
		m.addAttribute("qlist", qlist);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(Model m, @ModelAttribute("q") Question question) {
		return "newQuestion.jsp";
	}
	
	
	@PostMapping("/questions/create")
		public String createQuestionWithTags(@Valid @ModelAttribute("q") Question question, BindingResult res, 
				@RequestParam("subject1") String subject1, @RequestParam("subject2") String subject2, @RequestParam("subject3") String subject3) {
		if(res.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			Question q = os.addQuestion(question);
			List<Tag>tags = new ArrayList<Tag>();
			
			Tag t1 = os.findTagBySubject(subject1);
			if (t1 != null) {
				tags.add(t1);
			} else {
				if(subject1 != null){
				Tag tg1=new Tag(subject1);
				os.addTag(tg1);
				tags.add(tg1);
				}
			}
			
			Tag t2 = os.findTagBySubject(subject2);
			if (t2 != null) {
				tags.add(t2);
			} else {
				 if(subject2 != null){
				 Tag tg2=new Tag(subject2);
				 os.addTag(tg2);
				 tags.add(tg2);
				 }
			}
			
			Tag t3 = os.findTagBySubject(subject3);
			if (t3 != null) {
				tags.add(t3);
			} else {
				if(subject3 != null){
				Tag tg3=new Tag(subject3);
				os.addTag(tg3);
				tags.add(tg3);
				}
			}
			
//			q.setTags(tags);
//			os.addQuestion(q);
			os.add_tags_to_questions(tags, q);
			
			return "redirect:/questions/"+ q.getId();
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String newAnswer(Model m, @ModelAttribute("a") Answer answer, @PathVariable("id") Long id) {
		m.addAttribute("question", os.findQuestionById(id));
		return "newAnswer.jsp";
	}
	
	@PostMapping("/answers/create")
	public String addAnswers(@Valid @ModelAttribute("a") Answer answer, BindingResult res, @RequestParam("id") Long id, Model m) {
		if(res.hasErrors()) {
			m.addAttribute("question", os.findQuestionById(id));
			return "newAnswer.jsp";
		} else {
			Question q = os.findQuestionById(id);
			answer.setQuestion(q);
			os.addAnswer(answer);
			os.add_answers_to_question(q, answer);
			return "redirect:/questions/"+ q.getId();
		}
	}
}
