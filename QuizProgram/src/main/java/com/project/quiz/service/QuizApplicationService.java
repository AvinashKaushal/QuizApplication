package com.project.quiz.service;

import java.sql.SQLException;
import java.util.List;

import com.project.quiz.entity.Question;
import com.project.quiz.exception.CustomQuizException;
import com.project.quiz.utility.Responses;

public interface QuizApplicationService {
	
	public String registerUser(String Username, String Password) ;

	public List<Question> getquestionForQuiz();

	public String saveResponse(Responses responseValues);

	public int getScore();

}
