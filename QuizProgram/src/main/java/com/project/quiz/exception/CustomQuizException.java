package com.project.quiz.exception;

public class CustomQuizException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Throwable exception;
	String message;
	
	
	public CustomQuizException(String e) {
		super(e);
	}
	
	public CustomQuizException(String message,Throwable th) {
		
		this.exception = th;
		this.message = message;
	}

}
