package com.project.quiz.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.project.quiz.entity.Question;

public class QuestionRowMapper implements RowMapper<Question>{

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Question ques = new Question();
		
		ques.setQuestionId(rs.getInt("question_Id"));
		ques.setChoice1(rs.getString("choice1"));
		ques.setChoice2(rs.getString("choice2"));
		ques.setChoice3(rs.getString("choice3"));
		ques.setChoice4(rs.getString("choice4"));
		ques.setCorrectChoice(rs.getString("Correct_Choice"));
		ques.setQuestionName(rs.getString("Question_Name"));
		
		
		
		return ques;
	}

}
