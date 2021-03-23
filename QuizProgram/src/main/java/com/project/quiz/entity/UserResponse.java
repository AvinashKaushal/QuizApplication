package com.project.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int responseid;
	
	private int questionId;
    private String Selected_choice;
    
    
	public int getResponseid() {
		return responseid;
	}
	public void setResponseid(int responseid) {
		this.responseid = responseid;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getSelected_choice() {
		return Selected_choice;
	}
	public void setSelected_choice(String selected_choice) {
		Selected_choice = selected_choice;
	}
	
	

	
	

}
