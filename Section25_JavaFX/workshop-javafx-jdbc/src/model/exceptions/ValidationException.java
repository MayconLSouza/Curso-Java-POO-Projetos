package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errors = new HashMap<>();
	
	public ValidationException(String message) {
		super(message);
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String errorMsg) {
		errors.put(fieldName, errorMsg);
	}
}
