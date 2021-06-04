package eCommerceProject.core.concretes;

import eCommerceProject.core.abstracts.LogService;
import eCommerceProject.entities.concretes.User;

public class LogManager implements LogService{

	@Override
	public void sendVerificationMail(String _eMail, User user) {
		System.out.println("Doðrulama kodu gönerildi");
	}

}
