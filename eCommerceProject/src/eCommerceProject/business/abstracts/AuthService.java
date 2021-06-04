package eCommerceProject.business.abstracts;

public interface AuthService {
	static boolean eMailFormat(String eMailAddress) {
		return true;
	}
	static boolean passwordFormat(String passwordRegex) {
		return true;
	}
	static boolean nameFormat(String nameRegex) {
		return true;
	}
	
	void confirmationCode(String eMailAdress);
}
