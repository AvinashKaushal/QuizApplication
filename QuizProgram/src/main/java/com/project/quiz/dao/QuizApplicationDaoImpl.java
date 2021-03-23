package com.project.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.quiz.entity.Question;
import com.project.quiz.entity.UserResponse;
import com.project.quiz.exception.CustomQuizException;
import com.project.quiz.utility.QuestionRowMapper;
import com.project.quiz.utility.Responses;
import com.project.quiz.utility.SQLQuery;

@Repository
public class QuizApplicationDaoImpl implements QuizApplicationDao {
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public int registerUser(String Username, String Password) throws CustomQuizException,SQLException{
		
		int insertstatus;
		
		try {
		//Can pass parameters as new Object[] {Username,Password} in the update method
		insertstatus =  jdbctemplate.update(SQLQuery.REGISTER_USER_QUERY,Username,Password);
		}catch(DataAccessException e){
			throw new CustomQuizException("Exception Occured while Registering Record",e);
		}
		return insertstatus ;
	}

	@Override
	public List<Question> getquestionforQuiz() throws CustomQuizException {
		List<Question> qlist = null;
		
		try {
		qlist = jdbctemplate.query(SQLQuery.GET_QUESTION_LIST_QUERY, new QuestionRowMapper());
		}catch(EmptyResultDataAccessException e) {
			
			throw new CustomQuizException("Error while fetching Question for Quiz",e);
			
		}
		
		return qlist;
		
		
	
	}

	@Override
	public int[] saveResponse(Responses responseValues) throws CustomQuizException {
		int[] insertstatus ;
		
		
		//Used linked list so it maintains order of list
		List<String> response = new LinkedList<>();
		
		response.add(responseValues.getQ1());
		response.add(responseValues.getQ2());
		response.add(responseValues.getQ3());
		response.add(responseValues.getQ4());
		response.add(responseValues.getQ5());
		
		try {
		insertstatus =  jdbctemplate.batchUpdate(SQLQuery.INSERT_RESPONSES_QUERY, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				ps.setString(1, response.get(i));
				ps.setInt(2, i+1);
				
			}
			@Override
			public int getBatchSize() {
				
				return response.size();
			}
		});
		}catch(DataAccessException e){
			throw new CustomQuizException("Exception Occured while Inserting Responses",e);
		}
		
		return insertstatus;
	}

	@Override
	public int getScore() throws CustomQuizException {
		
		int score;
		
		try {
		score = jdbctemplate.queryForObject(SQLQuery.GET_SCORE_QUERY,Integer.class);
		}catch(EmptyResultDataAccessException e) {
			
			throw new CustomQuizException("Error while fetching your Score",e);
			
		}
		return score;
	}
	
	

}
