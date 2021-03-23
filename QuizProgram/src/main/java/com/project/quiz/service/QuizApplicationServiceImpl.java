package com.project.quiz.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quiz.dao.QuizApplicationDao;
import com.project.quiz.entity.Question;
import com.project.quiz.exception.CustomQuizException;
import com.project.quiz.utility.Responses;

@Service
public class QuizApplicationServiceImpl implements QuizApplicationService {

	public static Logger logger = LoggerFactory.getLogger(QuizApplicationServiceImpl.class);
	
	@Autowired
	QuizApplicationDao qAD;
	
	@Override
	public String registerUser(String Username, String Password) {
		int insertStatus = 0;
		
		try {
		insertStatus = qAD.registerUser(Username, Password);
		}catch(CustomQuizException | SQLException e) {
			logger.info("Exception Occured while Registering User");
		}

		return (insertStatus > 0) ? "Registered" : "Filed to Register";
	}

	@Override
	public List<Question> getquestionForQuiz() {
	
		List<Question> qa = new ArrayList<>();
		
		try {
			qa = qAD.getquestionforQuiz();
		} catch (CustomQuizException e) {
			logger.info("Exception Occured while Getting Quetion List");
		}
		
		return qa;
	}

	@Override
	public String saveResponse(Responses responseValues) {
		
		
		int[] insertStatus = null;

		try {
			insertStatus = qAD.saveResponse(responseValues);
		} catch (CustomQuizException e) {
			logger.info("Exception Occured while Saving Response");
		
		}
		 
		boolean checkfail = IntStream.of(insertStatus).allMatch(i -> i == 0);

		return (checkfail) ? "Failed to insert Responses" :"Successfully inserted Responses";
		
	}

	@Override
	public int getScore() {
		
		int score = 0;	
		try {
			score = qAD.getScore();
		} catch (CustomQuizException e) {
			logger.info("Exception Occured while Getting User");
		}
		return score;
		
	}
	
	

}
