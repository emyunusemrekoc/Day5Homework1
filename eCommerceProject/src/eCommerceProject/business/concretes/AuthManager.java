package eCommerceProject.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceProject.business.abstracts.AuthService;

public class AuthManager implements AuthService {
	static boolean eMailFormat(String eMailAddress) {

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMailAddress);
		return matcher.matches();
	}

	static boolean passwordFormat(String passwordRegex) {

		String regex = "^[a-zA-Z\\d]{1,5}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(passwordRegex);
		return matcher.matches();
	}

	static boolean nameFormat(String nameRegex) {

		String regex = "^[a-zA-Z\\d]{1,1}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nameRegex);
		return matcher.matches();
	}

	public void confirmationCode(String eMailAddress) {

		System.out.println(eMailAddress + " -doðrulama kodu gönderildi");

	}
}
