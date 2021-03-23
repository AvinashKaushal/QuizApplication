package com.project.quiz.utility;

public final class SQLQuery {
	
	public static final String REGISTER_USER_QUERY = "Insert into Login (username,password) values (?,?)";
	
	public static final String GET_QUESTION_LIST_QUERY = "Select * from Question";
	
	public static final String INSERT_RESPONSES_QUERY = "Insert into USER_RESPONSE (Selected_choice,Question_Id) values(?,?)";
	
	public static final String GET_SCORE_QUERY = "Select Count(*) from Question as q , User_Response as ur where q.question_id = ur.question_id and q.correct_choice = ur.selected_choice ";

}
