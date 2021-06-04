package eCommerceProject.core.abstracts;

import eCommerceProject.entities.concretes.User;

public interface LogService {
	void sendVerificationMail(String _eMail, User user);

}
