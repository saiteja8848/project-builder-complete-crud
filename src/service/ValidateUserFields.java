package service;

public class ValidateUserFields {

	public boolean validateName(String name) {
		return name.matches("^[a-zA-Z]*$");
	}

	public boolean validateEmailId(String emailId) {
		return emailId.matches("^[^@\\s]+@[^@\\s\\.]+\\.[^@\\.\\s]+$");
	}

	public boolean validatePassword(String password) {
		return password.matches("^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$");
	}

	public boolean validatePhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(0/91)?[7-9][0-9]{9}");
	}

	public boolean validate(String emailId, String password) {
		boolean status = false;

		if (validateEmailId(emailId)) {
			if (validatePassword(password)) {
				status = true;

			} else
				status = false;

		} else
			status = false;
		return status;
	}

}
