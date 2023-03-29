package kodlama.io.rentACar.core.exceptions;

import java.util.Map;

import kodlama.io.rentACar.business.rules.ProblemDetails;

public class ValidationProblemDetails extends ProblemDetails{
	private Map<String, String> validationErrors;

	public ValidationProblemDetails() {
		super();
	}

	public ValidationProblemDetails(Map<String, String> validationErrors) {
		super();
		this.validationErrors = validationErrors;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
