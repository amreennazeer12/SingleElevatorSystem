package com.wipro.elevator.exception;

public class InvalidDirectionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public InvalidDirectionException(String errorMessage) {
			this.errorMessage = errorMessage;
	}

}
