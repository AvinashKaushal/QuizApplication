package com.project.quiz.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.quiz.entity.Question;
import com.project.quiz.exception.CustomQuizException;
import com.project.quiz.service.QuizApplicationService;
import com.project.quiz.utility.Responses;

@RestController
public class QuizApplicationController {

	
	@Autowired
	QuizApplicationService qAS;
	
	@RequestMapping(value="/register/{Username}/{Password}", method = RequestMethod.POST)
	@ResponseBody
	public String userRegistration(@PathVariable ("Username") String username,@PathVariable ("Password") String password) {
			
		String status = null;
		
			status =  qAS.registerUser(username, password);
		
		return status; 
		
	}
	
	@RequestMapping(value="/question", method = RequestMethod.GET)
	@ResponseBody
	public List<Question> getQuestions() {
			
		return qAS.getquestionForQuiz();
		
	}
	
	@RequestMapping(value="/saveResponse", method = RequestMethod.POST)
	@ResponseBody
	public String saveResponse(@RequestBody Responses responseValues) {
		String status;
		
		status = qAS.saveResponse(responseValues);
		
		return status;		
	}
	
	@RequestMapping(value="/getYourScore", method = RequestMethod.POST)
	@ResponseBody
	public int getScore() {
		int score;
		
		score = qAS.getScore();
		
		return score;		
	}
	
	
}
