package com.project.quiz.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.quiz.entity.Question;
import com.project.quiz.exception.CustomQuizException;
import com.project.quiz.utility.Responses;

public interface QuizApplicationDao {
	
	public int registerUser(String Username, String Password) throws CustomQuizException, SQLException;

	public List<Question> getquestionforQuiz() throws CustomQuizException;

	public int[] saveResponse(Responses responseValues) throws CustomQuizException;

	public int getScore() throws CustomQuizException;

}
