package com.manzuraz.dojooverflow.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.manzuraz.dojooverflow.models.Answer;
import com.manzuraz.dojooverflow.models.Question;
import com.manzuraz.dojooverflow.models.Tag;
import com.manzuraz.dojooverflow.repositories.AnswerRepository;
import com.manzuraz.dojooverflow.repositories.QuestionRepository;
import com.manzuraz.dojooverflow.repositories.TagRepository;

@Service
public class OverflowService {
	private final QuestionRepository qr;
	private final AnswerRepository ar;
	private final TagRepository tr;
	
	public OverflowService(QuestionRepository qr,AnswerRepository ar, TagRepository tr) {
		this.qr=qr;
		this.ar=ar;
		this.tr=tr;		
	}
	public List<Question> all_questions(){
		return qr.findAll();
		}
	
	public List<Answer> all_answers(){
		return ar.findAll();
		}
	
	public List<Tag> all_tags(){
		return tr.findAll();
	}
	public Question addQuestion(Question question){
		  qr.save(question);
		  return question;
	}
	
	public void addAnswer(Answer answer) {
		ar.save(answer);
	}
	
	public void addTag(Tag tag) {
		tr.save(tag);
	}
	
	public Question findQuestionById(Long id){
		return (Question) qr.findById(id).get();
	}
	
	public Answer findAnswerById(Long id){
		return (Answer) ar.findById(id).get();
	}
	
	public Tag findTagById(Long id){
		return (Tag) tr.findById(id).get();
	}
	
	public Tag findTagBySubject(String subject) {
		return tr.findBySubject(subject);
	}
	
	public void add_tags_to_questions(List<Tag> t, Question q){
		q.setTags(t);
		qr.save(q);
	}
	
	public void add_answers_to_question(Question q, Answer answer) {
		List<Answer> answers= q.getAnswers();
		answers.add(answer);
		q.setAnswers(answers);
		qr.save(q);
	}

}
